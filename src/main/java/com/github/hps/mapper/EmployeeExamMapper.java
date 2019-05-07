package com.github.hps.mapper;

import com.github.hps.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeExamMapper {
    //获取当前用户的考试个数
    Integer count(Map<String,Object> map);

    //获取当前用户的考试列表
    List<EmployeeExam> page(Map<String,Object> map);

    //获取考试人数上限
    Integer getExamNum();

    //查询当前考试人数
    Integer getNowExamNum();

    //获取上一场闯关考试的信息
    BPMExamCount getIdAndStageSeqWithExamId(Long examId);

    //获取上一场闯关考试的PassScore
    Map<String,Object> getLastExamPassScoreWithExamId(Long examId);

    //获取上一场闯关考试的信息
    Long getLastExamIdWithIdAndStageSeq(Map<String,Object> map);

    //获取上一场闯关考试的详细信息
    EmployeeExam  getLastExamDetailsWithExamId(Map<String,Object> map);

    List<EmployeeExamD> getEmployeeExamDList(EmployeeExamPd employeeExamPd);

    List<EmployeeExamPd> getEmployeeExamPdList(EmployeeExam employeeExam);

    EmployeeExam getEmployeeExamById(EmployeeExam employeeExam);

    void getThisPaper(Map<String, Object> map);

    /**
     * 调用储存过程，计算考试得分以及答案
     * @param map
     */
    void getExamResult(Map<String, Object> map);

    void saveExamAnswer(EmployeeExamD employeeExamD);

    void beginExamPd(Map<String, Object> map);

    void beginExam(Map<String, Object> map);

    //考试结束，更新TRN_EMPLOYEXAMPD
    void finishExamPd(Map<String, Object> map);

     // 考试结束，更新TRN_EMPLOYEXAM
    void finishExam(Map<String, Object> map);

    //获取当前考试排名
    List<ExamRank> getRank(Map<String, Object> map);

    Integer getRankCount(Long examId);
    //获取我的当前考试排名
    ExamRank getMyRank(Map<String, Object> map);

    @Select(" SELECT SCORE FROM TRN_EMPLOYEXAM  WHERE EXAMID=#{examId} and EMPLOYEEID=#{employeeId}")
    Double getScore(Map<String, Object> map);

    List<Long> getEmployeeId(Long examId);

    Long selectLastExamId(Integer examKind);
}
