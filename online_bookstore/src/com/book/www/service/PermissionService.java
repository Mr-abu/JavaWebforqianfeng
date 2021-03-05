package com.book.www.service;

import com.book.www.entity.Admin;

public interface PermissionService {
    //核对是否存在Admin账号
    Admin checkAdmin(String administrator, String password);

}
