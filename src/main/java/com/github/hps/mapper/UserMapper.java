package com.github.hps.mapper;

import com.github.hps.bean.OrgCheck;
import com.github.hps.bean.User;
import com.github.hps.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT T1.PHONE1 as id,T2.USERID,T2.EMPLOYEEID,T2.USERNAME as nickname,T2.PSWD as password, '' as salt,T1.ORGID,T1.SEX,T1.PHONEPATH FROM sys_employee t1 INNER JOIN sys_user t2  ON T2.EMPLOYEEID = T1.EMPLOYEEID where T1.ISENABLED = 1 AND T2.ISENABLED = 1 AND T1.PHONE1 = #{id}")
    List<User> getById(@Param("id")String id);//手机号登录

    @Select("SELECT T1.PHONE1 as id,T2.USERID,T2.EMPLOYEEID,T2.USERNAME as nickname,T2.PSWD as password, '' as salt,T5.ORGID, " +
            "T1.SEX,T1.PHONEPATH,decode(t5.orgCtype,1,'机关',2,'针剂',3,'口服',4,'民康','系统') as orgNm FROM sys_employee t1  " +
            "INNER JOIN sys_user t2  ON T2.EMPLOYEEID = T1.EMPLOYEEID    " +
            "inner join sys_usercoordorgs t4 on t4.userid = t2.userId  inner join sys_org t5 on t5.orgid = t4.orgId  " +
            "where T1.ISENABLED = 1 AND T2.ISENABLED = 1 AND T1.IDCARD = #{id}")
    List<User> getByIdCard(@Param("id")String id);//身份证登录

    @Select("select  b.orgId as orgId1,b.orgNm as orgNm1,c.orgId as orgId2,c.orgNm as orgNm2,d.orgId as orgId3,d.orgNm as orgNm3,e.orgId as orgId4,e.orgNm as orgNm4  from (" +
            "select * from sys_employee where employeeId=#{employeeId} and isEnabled=1" +
            ")a inner   join sys_org b on a.orgId=b.orgId inner join sys_org c on b.parentOrgId=c.orgId " +
            "inner join sys_org d on c.parentOrgId=d.orgId inner join sys_org e on d.parentOrgId=e.orgId ")
    OrgCheck selectUserByEmployee(@Param("employeeId") Long employeeId);


    @Select("select  b.orgId as orgId1,b.orgNm as orgNm1,c.orgId as orgId2,c.orgNm as orgNm2,d.orgId as orgId3,d.orgNm as orgNm3,e.orgId as orgId4,e.orgNm as orgNm4  from (" +
            "select * from  sys_usercoordorgs a where a.userrrel=2 and a.userId=#{userId} and a.isEnabled=1" +
            ")a inner   join sys_org b on a.orgId=b.orgId inner join sys_org c on b.parentOrgId=c.orgId " +
            "inner join sys_org d on c.parentOrgId=d.orgId inner join sys_org e on d.parentOrgId=e.orgId ")
    List<OrgCheck> selectUserUsercoordorgs(@Param("userId") Long userId);


    @Select("select * from trn_examorg where isenabled=1")
    Long selectExamOrg();

    @Update("update sys_user set pswd = #{password} where userId = #{userId}")
    void update(User toBeUpdate);

    @Select(" SELECT M.USERID, A.*,C.ROLENAME,D.ORGNM\n" +
            "                          FROM SYS_USER M  \n" +
            "                          INNER JOIN(\n" +
            "                                        SELECT EMPLOYEEID,SEX,EMPLOYEENM,ORGID,PHONEPATH FROM SYS_EMPLOYEE WHERE   ISENABLED = 1 AND EMPLOYEEID=#{employeeId}\n" +
            "                                  ) A  ON A.EMPLOYEEID = M.EMPLOYEEID \n" +
            "                          INNER JOIN (SELECT * FROM SYS_USERCOORDORGS WHERE USERRREL = 1 AND ISENABLED = 1 )B ON B.USERID = M.USERID\n" +
            "                          INNER JOIN SYS_ROLE C ON C.ROLEID = B.ROLEID\n" +
            "                          INNER JOIN SYS_ORG D ON B.ORGID = D.ORGID")
    User getUserByEmployeeId(@Param("employeeId")long employeeId);

    @Select("SELECT T1.PHONE1 as id,T2.USERID,T2.EMPLOYEEID,T2.USERNAME as nickname,T2.PSWD as plainPwd, '' as salt,T1.ORGID,T1.SEX,T1.PHONEPATH,t3.orgNm FROM sys_employee t1 INNER JOIN sys_user t2  ON T2.EMPLOYEEID = T1.EMPLOYEEID  inner join sys_org t3 on t1.orgid=t3.orgid where T1.ISENABLED = 1 AND T2.ISENABLED = 1 AND T1.EMPLOYEEID = #{employeeId}")
    UserVo getUserById(@Param("employeeId")Long employeeId);//身份证登录

}
