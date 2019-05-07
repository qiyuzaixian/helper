package com.github.hps.service;

import com.github.hps.bean.*;
import com.github.hps.mapper.EmployeeExamMapper;
import com.github.hps.redis.EmpExamKey;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.Result;
import com.github.hps.util.FileChangeUrl;
import com.github.hps.util.StringUtils;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeExamService {

    HpsCreditsService hpsCreditsService;
    EmployeeExamMapper employeeExamMapper;
    RedisService redisService;

    @Autowired
    FileChangeUrl fileChangeUrl;

    public Result<Map<String,Object>> getEmployeeExamPage(Integer pageNum,Integer pageSize,String token,Integer examKind){
        Long employeeId=redisService.get(UserKey.token, token, User.class).getEmployeeId();
        List<EmployeeExam> resultList= redisService.get(EmpExamKey.List, token+examKind, List.class);//获取redis缓存数据
        Integer dataSize= redisService.get(EmpExamKey.ListCount, token+examKind, Integer.class);//获取redis缓存数据
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (resultList== null||dataSize==null) {
            EmployeeExam employeeExam = new EmployeeExam();
            employeeExam.setEmployeeId(employeeId);
            BPMExam exam=new BPMExam();
            exam.setExamKind(examKind);
            employeeExam.setExam(exam);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("employeeExam", employeeExam);
            resultList=employeeExamMapper.page(map);
            redisService.set(EmpExamKey.List,token+examKind, resultList);//数据存入redisListCount
            dataSize=employeeExamMapper.count(map);
            redisService.set(EmpExamKey.ListCount,token+examKind, dataSize);//数据存入redisListCount
        }
            List<EmployeeExam> list=new ArrayList<EmployeeExam>();
            Integer start=pageNum * pageSize - pageSize;
            for(int i=start;i<pageNum * pageSize;i++){
                if(i<dataSize){
                    list.add(resultList.get(i));
                }
            }
            resultMap.put("data", list);
            resultMap.put("dataSize", dataSize);
            return Result.success(resultMap);
    }

    public Result<Map<String,Object>> getRank(Long examId,String token,Integer pageSize,Integer pageNum){
        Long employeeId=redisService.get(UserKey.token, token, User.class).getEmployeeId();
        List<ExamRank> rank=redisService.get(EmpExamKey.Rank, examId.toString(),  List.class);//获取考试排名redis缓存数据
        ExamRank myRank=redisService.get(EmpExamKey.MyRank,examId.toString()+employeeId.toString(), ExamRank.class);//获取当前登录用户考试排名redis缓存数据
        Integer dataSize=redisService.get(EmpExamKey.RankCount, examId.toString()+"count", Integer.class);
        if(rank==null){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("examId", examId);
            rank=employeeExamMapper.getRank(map);
            for(ExamRank user:rank){
                if(user.getPhonePath()!=null){
                    String phonePath=user.getPhonePath();
                    phonePath=fileChangeUrl.changeFileUrl(phonePath);
                    user.setPhonePath(phonePath);
                }
                user.setEmployeeNm(user.getEmployeeNm().replaceAll("[^\u4E00-\u9FA5]", ""));
            }
            redisService.set(EmpExamKey.Rank,examId.toString(), rank);
        }
        if(myRank==null){//我的排名为空
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("examId", examId);
            map.put("employeeId", employeeId);
            myRank=employeeExamMapper.getMyRank(map);
            if(myRank.getPhonePath()!=null){
                String phonePath=myRank.getPhonePath();
                phonePath=fileChangeUrl.changeFileUrl(phonePath);
                myRank.setPhonePath(phonePath);
            }
            redisService.set(EmpExamKey.MyRank,examId.toString()+employeeId.toString(), myRank);
        }
        if(dataSize==null) {//排名计数
            dataSize = employeeExamMapper.getRankCount(examId);
            redisService.set(EmpExamKey.RankCount, examId.toString() + "count", dataSize);
        }
        Integer start=pageNum * pageSize - pageSize;
        List<ExamRank> rankList=new ArrayList<ExamRank>();
        for(int i=start;i<pageNum * pageSize;i++){
            if(i<dataSize){
                rankList.add(rank.get(i));
            }
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", rankList);
        resultMap.put("dataSize",dataSize);
        resultMap.put("myData", myRank);
        return Result.success(resultMap);
    }
    public Long selectLastExamId(Integer examKind){
        return employeeExamMapper.selectLastExamId(examKind);
    }




    /**
     * 考试的试卷提交
     * @param examPd
     */
    @Transactional
    public void finishExam(EmployeeExamPd examPd,String token,Integer examKind){
        User user=redisService.get(UserKey.token, token, User.class);
        Long userId=user.getUserId();
        Double score=saveExam(examPd,user.getUserId());
        hpsCreditsService.setHpsCredits(1,userId,score);
        Long examId=examPd.getEmployeeExam().getExam().getExamId();
        Long employeeId=examPd.getEmployeeExam().getEmployeeId();
        redisService.delete(EmpExamKey.List,token+examKind);//数据存入redisListCount
        redisService.delete(EmpExamKey.Rank,examId.toString());
        redisService.delete(EmpExamKey.MyRank,examId.toString()+employeeId.toString());
    }

    @Transactional
    public Double saveExam(EmployeeExamPd examPd,Long userId){
        for (int i = 0; i < examPd.getDetail().size(); i++) {
            EmployeeExamD employeeExamD = examPd.getDetail().get(i);
            if (StringUtils.isNotBlank(employeeExamD.getResult())) {
                employeeExamD.setEmployeeExamPd(examPd);
                employeeExamMapper.saveExamAnswer(employeeExamD);
            }

        }
        Map<String,Object> map = Maps.newHashMap();
        Long employeeId=examPd.getEmployeeExam().getEmployeeId();
        map.put("employeeId",employeeId);
        Long examId=examPd.getEmployeeExam().getExam().getExamId();
        map.put("examId",examId);
        map.put("stageSeq",examPd.getEmployeeExam().getStageSeq());
        map.put("empExamId", examPd.getEmpExamId());
        map.put("paperId",examPd.getPapers().getPaperId());
        map.put("userId",userId);
        //更新员工考试试卷状态，完成时间
        employeeExamMapper.finishExamPd(map);
        //更新员工考试状态
        employeeExamMapper.finishExam(map);
        //计算试题答案
        employeeExamMapper.getExamResult(map);
        return employeeExamMapper.getScore(map);
    }
    @Transactional
    public Map<String,Object> finishExamReturnScore(EmployeeExamPd examPd,String token,Integer examKind){
        Map<String,Object> map=new HashMap<String, Object>();
        try{
            User user=redisService.get(UserKey.token, token, User.class);
            Long userId=user.getUserId();
            Double score=saveExam(examPd,user.getUserId());
            hpsCreditsService.setHpsCredits(1,userId,score);
            map.put("score",score);
            map.put("state",true);
        }catch(Exception e){
            e.printStackTrace();
            map.put("state",false);
        }
       return map;
    }

    public void setRedis(Long examId){
            List<Long> list=employeeExamMapper.getEmployeeId(examId);
            if(list!=null&list.size()>0){
                for(Long employeeId:list){
                    EmployeeExamPd employeeExamPd=getExamById(examId,employeeId);
                    redisService.set(EmpExamKey.ExamInfo,examId+","+employeeId,employeeExamPd);
                }
            }
    }

    public EmployeeExamPd getExamById(Long examId, Long employeeId){
        Integer stageSeq = 1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId", employeeId + "");
        map.put("examId", examId);
        map.put("stageSeq", stageSeq);
        employeeExamMapper.getThisPaper(map);
        EmployeeExam employeeExam = new EmployeeExam();
        employeeExam.setEmployeeId(employeeId);
        employeeExam.setStageSeq(stageSeq);
        BPMExam exam = new BPMExam();
        exam.setExamId(examId);
        employeeExam.setExam(exam);
        EmployeeExamPd examPd=getExamQuestions(employeeExam);
        redisService.set(EmpExamKey.ExamInfo,examId+","+examPd.getPapers().getPaperId(),examPd.getExamTopicTypeList());
        if(examPd != null){
            return examPd;
        }else{
            return null;
        }
    }


     private EmployeeExamPd getExamQuestions(EmployeeExam employeeExam) {
        // 查询完整的员工考试信息
        employeeExam = employeeExamMapper.getEmployeeExamById(employeeExam);
        // 查询本次考试对应的试卷信息
        // 当有未考试的试卷信息时，优先从中随机抽取一套
        // 如果没有未考试的试卷信息，随机从所有试卷中抽取一套
        List<EmployeeExamPd> employeeExamPdList = employeeExamMapper .getEmployeeExamPdList(employeeExam);
        if (employeeExamPdList != null && employeeExamPdList.size() > 0) {
            // 上面的查询结果已经默认按照考试状态，员工考试ID排序
            // 如果第一条数据为未考试过的，那么就是本次考试需要的试卷信息，如果是别的状态，表示该员工全部试卷已经考过，那么随机抽取
            EmployeeExamPd result=employeeExamPdList.get((int) (Math.random() * employeeExamPdList.size()));
            // 获取答案选项的试题信息
            List<ExamTopicType> examTopicTypeList=redisService.get(EmpExamKey.ExamInfo,employeeExam.getExam().getExamId()+","+result.getPapers().getPaperId(),List.class);
            if(examTopicTypeList==null||examTopicTypeList.size()==0){
                examTopicTypeList = this.getEmployeeExamD(result);
            }
            if (examTopicTypeList != null && examTopicTypeList.size() > 0) {
                result.setExamTopicTypeList(examTopicTypeList);
            }
            result.setEmployeeExam(employeeExam);
            return result;
        } else {
            return null;
        }

    }
    private List<ExamTopicType> getEmployeeExamD(EmployeeExamPd result) {
        List<EmployeeExamD> employeeExamDList = employeeExamMapper.getEmployeeExamDList(result);
        if (employeeExamDList != null && employeeExamDList.size() > 0) {
            List<ExamTopicType> examTopicTypeList = new ArrayList<ExamTopicType>();

            // 默认首条题目肯定是一个新的题型，所以创建题型信息
            ExamTopicType examTopicType = new ExamTopicType();
            examTopicType.setTitle(employeeExamDList.get(0).getTitle());
            examTopicType.setQustkSeq(employeeExamDList.get(0).getQustkSeq());
            examTopicType.setTopicTypeId(employeeExamDList.get(0)
                    .getTopicTypeId());
            // 将本条题目信息加入到题型下面的题目信息的数组中
            examTopicType.getExamDList().add(employeeExamDList.get(0));
            for (int i = 1; i < employeeExamDList.size(); i++) {
                if (employeeExamDList.get(i - 1).getTopicTypeId()
                        .equals(employeeExamDList.get(i).getTopicTypeId())) {
                    // 上条题目的题型与本次的题目的题型一致，直接在题型的题目数组中增加数据
                    examTopicType.getExamDList().add(employeeExamDList.get(i));
                    // 如果是最后一条，那么需要往题型的数组中增加
                    if (i == employeeExamDList.size() - 1) {
                        examTopicTypeList.add(examTopicType);
                    }
                } else {
                    // 新的题型
                    // 先将上一条的题型信息保存
                    examTopicTypeList.add(examTopicType);
                    // 重新创建题型信息
                    examTopicType = new ExamTopicType();
                    examTopicType.setQustkSeq(employeeExamDList.get(i)
                            .getQustkSeq());
                    examTopicType.setTopicTypeId(employeeExamDList.get(i)
                            .getTopicTypeId());
                    examTopicType.setTitle(employeeExamDList.get(i).getTitle());
                    examTopicType.getExamDList().add(employeeExamDList.get(i));
                    // 如果是最后一条，那么需要往题型的数组中增加
                    if (i == employeeExamDList.size() - 1) {
                        examTopicTypeList.add(examTopicType);
                    }
                }
            }
            return examTopicTypeList;
        } else {
            return null;
        }
    }

    public Integer checkExam(Long examId,Long employeeId){
        Integer stageSeq;
        Integer examNum = employeeExamMapper.getExamNum();// 获取考试人数上限
        Integer nowExamNum = employeeExamMapper.getNowExamNum();// 查询当前考试人数
        BPMExamCount exam = employeeExamMapper .getIdAndStageSeqWithExamId(examId);// 获得本关的id和关数
        if (exam == null) {
            if (examNum > nowExamNum) {
                return 1;
            } else {
                return 0;
            }
        } else {
            stageSeq = exam.getStageSeq();
        }
        Integer counts = stageSeq;
        if (examNum > nowExamNum) {
            Long firstId = exam.getId();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", firstId);
            map.put("stageSeq", 1);
            Long firstExamId = employeeExamMapper.getLastExamIdWithIdAndStageSeq(map);// 获得本次过关考试的第一次考试examid
            map.clear();
            map.put("examId", firstExamId);
            map.put("employeeId", employeeId);
            EmployeeExam firstEmployeeExam = employeeExamMapper .getLastExamDetailsWithExamId(map);// 获得本次过关考试的第一次考试的详细信息
            if (stageSeq == 1) {
                return 1;
            }
            if (firstEmployeeExam.getExamStatus() != 0) {// 判断是否已从第一场开始答卷
                Long lastId = exam.getId();
                Integer lastStageSeq = counts - 1;
                map.clear();
                map.put("id", lastId);
                map.put("stageSeq", lastStageSeq);
                Long lastExamId = employeeExamMapper .getLastExamIdWithIdAndStageSeq(map);// 获得上一关的考试examid
                if (lastExamId == null) {
                    return 0;
                }
                Map<String, Object> bpmExam =employeeExamMapper.getLastExamPassScoreWithExamId(lastExamId);// 获得上一关考试的passscore
                Long examIdLast = Long.parseLong(bpmExam.get("EXAMID")
                        .toString());
                map.clear();
                map.put("examId", examIdLast);
                map.put("employeeId", employeeId);
                EmployeeExam employeeExam = employeeExamMapper.getLastExamDetailsWithExamId(map);// 获得上一场考试的详细信息
                Double passScore = Double.parseDouble(bpmExam.get("PASSSCORE").toString());
                if (employeeExam.getMaxScore() < passScore) {// 上一关的最高成绩和过关成绩相比较
                    return 3;
                } else {
                    return 1;
                }
            } else {
                return 3;
            }
        } else {
            return 0;
        }
    }
}
