package com.chuilun.aop;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class App {
        private String className;
        private String methodName;
        private Date logTime;
        private long comsumeTime;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public long getComsumeTime() {
        return comsumeTime;
    }

    public void setComsumeTime(long comsumeTime) {
        this.comsumeTime = comsumeTime;
    }
}