package com.xcgn.marry.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.service.MenuService;
import com.xcgn.marry.business.utils.HttpResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * create by ajaxgo on 2019/11/27
 **/
@Api("菜单接口")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value="获取权限菜单", notes="根据用户名获取权限菜单")
    @GetMapping(value = "/findNavTree",produces = "application/json;charset=UTF-8")
    @ResponseBody
    @CrossOrigin
    public HttpResponseData findNavTree(@RequestParam String userName, HttpServletRequest request) {
       return menuService.findNavTree(userName);
    }
}
