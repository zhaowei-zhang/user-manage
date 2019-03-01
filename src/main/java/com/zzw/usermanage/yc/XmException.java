package com.zzw.usermanage.yc;

import org.springframework.boot.web.servlet.ErrorPage;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/1
 */
public class XmException extends Exception {

    public XmException(){
        super();
    }

    public XmException(String msg){
        super(msg);
    }

    public XmException(XmError msg){
        super(msg.toString());
    }
}
