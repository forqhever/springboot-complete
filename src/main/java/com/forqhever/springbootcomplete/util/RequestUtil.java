package com.forqhever.springbootcomplete.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    private RequestUtil(){}

    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Forwarded-For");

        if(!StringUtils.isEmpty(remoteAddr)) {
            String[] ipList = remoteAddr.split(",");
            for(String ip : ipList) {
                if(StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
                    remoteAddr = ip;
                    break;
                }
            }
        }
        if (StringUtils.isEmpty(remoteAddr) || "unknown".equalsIgnoreCase(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        return remoteAddr;
    }
}
