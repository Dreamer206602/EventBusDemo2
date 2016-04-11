package com.loonggg.eventbusdemo;

/**
 * Created by loongggdroid on 2016/4/1.
 */
public class UserEvent {
    
    private String userName;

    public UserEvent() {
    }

    public UserEvent(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
