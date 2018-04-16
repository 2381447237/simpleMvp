package com.youli.test20180410.p;

import com.youli.test20180410.v.LoginView;
import com.youli.test20180410.m.OnLoginFinishedListener;
import com.youli.test20180410.m.LoginModel;
import com.youli.test20180410.m.LoginModelImpl;

/**
 * Created by Anthony on 2016/2/15.
 * Class Note:
 * 1 完成presenter的实现。这里面主要是Model层和View层的交互和操作。
 * 2  presenter里面还有个OnLoginFinishedListener，
 * 其在Presenter层实现，给Model层回调，更改View层的状态，
 * 确保 Model层不直接操作View层。如果没有这一接口在LoginPresenterImpl实现的话，
 * LoginPresenterImpl只 有View和Model的引用那么Model怎么把结果告诉View呢？
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener{

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginModel=new LoginModelImpl();
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccess() {

        loginView.onSuccess();
        loginView.hideProgress();
    }

    @Override
    public void validateCredentials(String username, String password) {

        loginView.showProgress();
        loginModel.login(username,password,this);

    }

    @Override
    public void onDestroy() {

        loginView=null;

    }
}
