package com.example.demo.entity;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/20 10:40
 * @description ：返回接口调用信息描述
 * @modified By：
 */
public class Response {
    String msg;
    int code;
    Boolean isSuc = true;
    Object result;

    public Response() {
    }

    public Response(String msg, int code, Boolean isSuc) {
        this.msg = msg;
        this.code = code;
        this.isSuc = isSuc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuc() {
        return isSuc;
    }

    public void setSuc(Boolean suc) {
        isSuc = suc;
    }

    public Object getResult(){
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setResponse(String msg, int code, Boolean isSuc, Object result) {
        this.msg = msg;
        this.code = code;
        this.isSuc = isSuc;
        this.result = result;
    }
}
