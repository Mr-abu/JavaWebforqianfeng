package com.book.www.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","")+UUID.randomUUID().toString().replace("-","");
    }
}
