package com.xcgn.marry.business.service;

import com.xcgn.marry.business.utils.HttpResponseData;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * create by ajaxgo on 2019/11/27
 **/
public interface MenuService {
    public HttpResponseData findNavTree(String username);

}
