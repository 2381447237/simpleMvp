package com.youli.test20180410.m;

/**
 * Created by liutao on 2018/4/10.
 * 登陆事件监听
 */

public  interface OnLoginFinishedListener {

       void onUsernameError();

       void onPasswordError();

       void onSuccess();
}
