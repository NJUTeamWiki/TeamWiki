package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.ResultCode;

/**
 * @author: xuyangchen
 * @date: 2020/1/15
 */
public class ServiceException extends Exception {

    private ResultCode resultCode;

    public ServiceException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
