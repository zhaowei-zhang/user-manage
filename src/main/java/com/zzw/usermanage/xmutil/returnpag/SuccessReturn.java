package com.zzw.usermanage.xmutil.returnpag;


/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/6
 */
public class SuccessReturn implements Return {
    protected boolean success;
    protected String exception;
    public SuccessReturn(){
        super();
    }

    public SuccessReturn(boolean success){
        super();
        this.success=success;
    }

    public SuccessReturn(boolean success, String exception) {
        this.success = success;
        this.exception = exception;
    }



    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
