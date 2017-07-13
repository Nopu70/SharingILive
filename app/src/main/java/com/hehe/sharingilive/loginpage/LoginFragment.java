package com.hehe.sharingilive.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hehe.sharingilive.R;
import com.hehe.sharingilive.homepage.HomeActivity;
import com.hehe.sharingilive.model.entity.User;

/**
 * Created by tarena on 2017/7/11.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private View view;
    private ImageView ivBack;
    private TextView tvTilte;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvForgetPassword;
    private TextView tvRegister;
    private boolean isLogin;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LoginContract.Presenter presenter;

    @Override
    public void setPresent(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, container, false);
        initView();
        addListener();
        return view;
    }

    private void addListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                        if (isLogin) {
                            presenter.login(username, password);
                        } else {
                            presenter.register(username, password);
                        }
                } else {
                    Toast.makeText(getContext(), "请输入正确的账号密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLogin) {
                    isLogin = false;
                    tvTilte.setText("注册享播账号");
                    etUsername.setHint("请输入手机号/邮箱");
                    etPassword.setHint("请设置密码");
                    btnLogin.setText("注册");
                    tvRegister.setText("已有账号啊？登陆");
                } else {
                    isLogin = true;
                    tvTilte.setText("欢迎登陆SharingILive");
                    etUsername.setHint("手机号/邮箱");
                    etPassword.setHint("密码");
                    btnLogin.setText("登录");
                    tvRegister.setText("注册");
                }
            }
        });

    }

    private void initView() {
        isLogin = true;
        ivBack = view.findViewById(R.id.iv_back);
        tvTilte = view.findViewById(R.id.tv_title);
        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_login);
        tvForgetPassword = view.findViewById(R.id.tv_forget_password);
        tvRegister = view.findViewById(R.id.tv_register);
    }

    @Override
    public void loginEnd(User user) {
        //登陆成功,跳转到主界面
        if (user == null) {
            Toast.makeText(getContext(), "请输入正确的账号密码", Toast.LENGTH_SHORT).show();
            return;
        }
        getContext().startActivity(new Intent(getContext(), HomeActivity.class));
    }
}
