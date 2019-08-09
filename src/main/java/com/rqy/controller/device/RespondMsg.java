package com.rqy.controller.device;

public class RespondMsg {
    private int status;
    private String msg;

    public RespondMsg() {
    }

    public RespondMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static RespondMsg createSusscess(){
        RespondMsg ok = new RespondMsg(200, "ok");
        return ok;
    }
    public static RespondMsg createFail(){
        RespondMsg fail = new RespondMsg(002, "fail");
        return fail;
    }
}
