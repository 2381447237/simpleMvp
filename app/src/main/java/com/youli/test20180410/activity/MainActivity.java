package com.youli.test20180410.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.youli.test20180410.R;
import com.youli.test20180410.p.LoginPresenter;
import com.youli.test20180410.p.LoginPresenterImpl;
import com.youli.test20180410.v.LoginView;

/**
 * Created by Anthony on 2016/2/15.
 * Class Note:MVP模式中View层对应一个activity，这里是登陆的activity
 * demo的代码流程：Activity做了一些UI初始化的东西并需要实例化对应
 * LoginPresenter的引用和实现 LoginView的接口，监听界面动作，
 * Go按钮按下后即接收到查询天气的事件，在onClick里接收到即通过LoginPresenter
 * 的引用把它交给LoginPresenter处理。LoginPresenter接收到了登陆的逻辑就知道要登陆了，
 * 然后LoginPresenter显示进度条并且把逻辑交给我们的Model去处理，也就是这里面的LoginModel，
 * （LoginModel的实现类LoginModelImpl），同时会把OnLoginFinishedListener也就是LoginPresenter
 * 自身传递给我们的Model（LoginModel）。LoginModel处理完逻辑之后，结果通过
 * OnLoginFinishedListener回调通知LoginPresenter，LoginPresenter再把结果返回给view层的Activity，
 * 最后activity显示结果
 */

public class MainActivity extends Activity implements LoginView,View.OnClickListener{

    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter=new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View view) {

        presenter.validateCredentials(username.getText().toString(),password.getText().toString());

    }

    @Override
    public void showProgress() {

        ProgressDialogUtils.showMyProgressDialog(this);

    }

    @Override
    public void hideProgress() {

        ProgressDialogUtils.dismissMyProgressDialog(this);

    }

    @Override
    public void setUsernameError() {

        Toast.makeText(this,"用户名错误",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setPasswordError() {

        Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccess() {

        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();

    }
}
