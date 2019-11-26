package com.xcgn.marry.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.shiroconfig.PhoneToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api("登录接口")
@RestController
@RequestMapping("/login")
public class LoginController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 用户名密码登录方法
     * @return
     */
    @ApiOperation(value="用户名登录", notes="根据用户名密码登录")
    @PostMapping(value = "/userNameLogin",produces = "application/json;charset=UTF-8")
    @CrossOrigin
    public String userNameLogin(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        logger.error("当前为日志测试");
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("username").toString(),map.get("password").toString());
        try {
            subject.login(token);

            Subject sub = SecurityUtils.getSubject();
            Object obj = sub.getPrincipal();
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    /**
     * description: 手机验证码登录
     * version: 1.0 
     * date: 2019/11/25 14:38 
     * author: ajaxgo
     *
     * @return java.lang.String
     */ 
    @ApiOperation(value="手机验证码登录", notes="根据手机验证码登录")
    @PostMapping("/phoneLogin")
    public String phoneLogin(@RequestParam("phone") String phone, @RequestParam("code") String code, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        logger.error("当前为日志测试");
        PhoneToken token = new PhoneToken(phone);
        try {
            subject.login(token);
            Subject sub = SecurityUtils.getSubject();
            Object obj = sub.getPrincipal();
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @ApiOperation(value="获取用户信息", notes="获取用户信息")
    @GetMapping("/info")
    public String info(HttpServletRequest request)
    {
        Subject sub = SecurityUtils.getSubject();
        User obj = (User)sub.getPrincipal();
        return "测试登录成功";
    }
}
