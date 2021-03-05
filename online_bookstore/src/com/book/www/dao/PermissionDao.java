package com.book.www.dao;

import com.book.www.entity.Admin;

public interface PermissionDao {
    Admin checkAdmin(String administrator, String password);

}
