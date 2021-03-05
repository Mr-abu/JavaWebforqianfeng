package com.book.www.service.impl;

import com.book.www.dao.PermissionDao;
import com.book.www.dao.impl.PermissionDaoImpl;
import com.book.www.entity.Admin;
import com.book.www.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao = new PermissionDaoImpl();
    @Override
    public Admin checkAdmin(String administrator, String password) {
        return permissionDao.checkAdmin(administrator, password);
    }
}
