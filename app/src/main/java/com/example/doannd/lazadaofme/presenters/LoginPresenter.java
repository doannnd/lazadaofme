package com.example.doannd.lazadaofme.presenters;

import android.content.Context;
import android.content.Intent;

import com.example.doannd.lazadaofme.domain.UserDTO;
import com.example.doannd.lazadaofme.interfaces.LoginContract;
import com.example.doannd.lazadaofme.models.LoginModel;

public class LoginPresenter implements LoginContract.LoginToPresenter {

    private LoginContract.LoginPresenterToView mLoginPresenterToView;
    private LoginContract.LoginPresenterToModel mLoginPresenterToModel;

    public LoginPresenter(LoginContract.LoginPresenterToView loginPresenterToView) {
        this.mLoginPresenterToView = loginPresenterToView;
        mLoginPresenterToModel = new LoginModel(this);
    }

    @Override
    public void login(UserDTO userCredentials) {
        mLoginPresenterToModel.login(userCredentials);
    }

    @Override
    public void loginGoogle(Context context) {
        mLoginPresenterToModel.loginGoogle(context);
    }

    @Override
    public void loginFacebook() {
        mLoginPresenterToModel.loginFacebook();
    }

    @Override
    public void isLoggedIn() {
        mLoginPresenterToModel.isLoggedIn();
    }

    @Override
    public void onLoginResponse(boolean isLoginSuccess) {
        mLoginPresenterToView.onLoginResponse(isLoginSuccess);
    }

    @Override
    public void onError(String message) {
        mLoginPresenterToView.onError(message);
    }

    @Override
    public void isLoggedIn(boolean isLoggedIn) {
        mLoginPresenterToView.isLoggedIn(isLoggedIn);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mLoginPresenterToView.onActivityResult(requestCode, resultCode, data);
    }

}
