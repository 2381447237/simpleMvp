package com.youli.test20180410.m;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Anthony on 2016/2/15.
 * Class Note:延时模拟登陆（2s），如果名字或者密码为空则登陆失败，否则登陆成功
 */

public class LoginModelImpl implements  LoginModel{


    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){

                    listener.onSuccess();

                }else {

                    if(TextUtils.isEmpty(username)){

                        listener.onUsernameError();

                    }else if(TextUtils.isEmpty(password)){

                        listener.onPasswordError();

                    }

                }

            }
        },2000);

    }
}
