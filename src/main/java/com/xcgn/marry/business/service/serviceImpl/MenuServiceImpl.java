package com.xcgn.marry.business.service.serviceImpl;

import com.xcgn.marry.business.dao.PermissionMapper;
import com.xcgn.marry.business.service.MenuService;
import com.xcgn.marry.business.utils.HttpResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by ajaxgo on 2019/11/27
 **/
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public HttpResponseData findNavTree(String username) {
        return HttpResponseData.return_data(200,"操作成功",permissionMapper.findNavTree(username));
    }
}
