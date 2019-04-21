package com.hotel.sofiter.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取客户端真实IP地址
     *
     */
    public String getRemoteIp(HttpServletRequest request){
        //return CusAccessObjectUtil.getIpAddress(request);
        return null;
    }
}
