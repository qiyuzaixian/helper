package com.github.hps.redis;

public class EmpExamKey extends BasePrefix {

    public static final int EMPLOYEE_EXAM_LIST = 60*5;//缓存5分钟
    public static final int EMPLOYEE_RANK = 60*5;//缓存5分钟
    public static final int EMPLOYEE_MYRANK = 60*5;//缓存5分钟
    public static final int EXAM_RANK_COUNT=3600*24*2;//缓存5天
    public static final int EXAM_INFO=3600*24*30;//缓存30天
    /**
     * 防止被外面实例化
     */
    private EmpExamKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static EmpExamKey List = new EmpExamKey(EMPLOYEE_EXAM_LIST,"empExamList");
    public static EmpExamKey ListCount = new EmpExamKey(EMPLOYEE_EXAM_LIST,"empExamListCount");
    public static EmpExamKey Rank = new EmpExamKey(EMPLOYEE_RANK,"Rank");
    public static EmpExamKey MyRank = new EmpExamKey(EMPLOYEE_MYRANK,"MyRank");
    public static EmpExamKey RankCount = new EmpExamKey(EXAM_RANK_COUNT,"RankCount");
    public static EmpExamKey ExamInfo = new EmpExamKey(EXAM_INFO, "ExamInfo");



}
