package com.deepinto.service;

import com.deepinto.entity.LoginEntity;
import com.deepinto.utils.MsResult;

public interface LoginService {

    MsResult login(LoginEntity entity) throws Exception;
}
