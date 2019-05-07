package com.github.hps.controller;

import com.github.hps.bean.*;
import com.github.hps.redis.RedisService;
import com.github.hps.redis.UserKey;
import com.github.hps.result.CodeMsg;
import com.github.hps.result.Result;
import com.github.hps.service.EmployeeExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/employeeExam")
public class EmployeeExamController {

    RedisService redisService;
    EmployeeExamService employeeExamService;

    @RequestMapping("/getEmployeeExamPage")
    @ResponseBody
    public Result<Map<String, Object>> getEmployeeExamPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("token") String token) {
        try {
            return employeeExamService.getEmployeeExamPage(pageNum, pageSize, token, 2);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/getEmployeeExamPageByDuel")
    @ResponseBody
    public Result<Map<String, Object>> getEmployeeExamPageByDuel(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("token") String token) {
        try {
            return employeeExamService.getEmployeeExamPage(pageNum, pageSize, token, 3);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/beginExamByDay")
    @ResponseBody
    public Result<EmployeeExamPd> beginExamByDay(@RequestParam("token") String token) {
        try {
            Long employeeId = redisService.get(UserKey.token, token, User.class).getEmployeeId();
            Long examId = employeeExamService.selectLastExamId(1);
            EmployeeExamPd employeeExamPd = employeeExamService.getExamById(examId, employeeId);
            if(employeeExamPd!=null){
                return Result.success(employeeExamPd);
            }else{
                return Result.error(CodeMsg.EXAM_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping("/beginExam")
    @ResponseBody
    public Result<EmployeeExamPd> beginExam(@RequestParam("examId") Long examId, @RequestParam("token") String token) {
        try {
            Long employeeId = redisService.get(UserKey.token, token, User.class).getEmployeeId();
            Integer state = employeeExamService.checkExam(examId, employeeId);
            if (state == 0) {//考试错误
                return Result.error(CodeMsg.EXAM_ERROR);
            } else if (state == 1) {
                EmployeeExamPd employeeExamPd = employeeExamService.getExamById(examId, employeeId);
                return Result.success(employeeExamPd);
            } else {//state==3闯关考试上一关未通过
                return Result.error(CodeMsg.EXAM_NOT_PASS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ResponseBody
    @PostMapping(value = "/finishExam")
    public Result<Boolean> finishExam(@RequestBody EmployeeExamPd examPd, @RequestParam("token") String token, @RequestParam("examKind") Integer examKind) {
        //保存考试的答案
        try {
            employeeExamService.finishExam(examPd, token,examKind);
            return Result.success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ResponseBody
    @PostMapping(value = "/finishExamReturnScore")
    public Result<Map<String,Object>> finishExamReturnScore(@RequestBody EmployeeExamPd examPd, @RequestParam("token") String token, @RequestParam("examKind") Integer examKind) {
        try {
            Map<String,Object> map=employeeExamService.finishExamReturnScore(examPd, token,examKind);
            return Result.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/getRank")
    public Result<Map<String, Object>> getRank(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("examId") Long examId, @RequestParam("token") String token) {
        try {
            return employeeExamService.getRank(examId, token, pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    @RequestMapping("/setRedis")
    @ResponseBody
    public Result<Boolean> setRedis(@RequestParam("examId") Long examId) {
        try {
            employeeExamService.setRedis(examId);
            return Result.success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
