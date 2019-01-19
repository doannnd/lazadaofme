package com.example.doannd.lazadaofme.presenters;

import android.content.Intent;

import com.example.doannd.lazadaofme.domain.UserDTO;
import com.example.doannd.lazadaofme.fragments.LoginFragment;
import com.example.doannd.lazadaofme.interfaces.LoginContract;
import com.example.doannd.lazadaofme.models.LoginModel;

public class LoginPresenter implements LoginContract.LoginToPresenter {

    private LoginContract.LoginPresenterToModel mLoginPresenterToModel;
    private LoginContract.LoginPresenterToView mLoginPresenterToView;

    public LoginPresenter(LoginContract.LoginPresenterToView loginPresenterToView) {
        this.mLoginPresenterToView = loginPresenterToView;
        this.mLoginPresenterToModel = new LoginModel(this);
    }

    @Override
    public void signIn(UserDTO userCredentials) {
        mLoginPresenterToModel.signIn(userCredentials);
    }

    @Override
    public void signInFacebook(LoginFragment loginFragment) {
        mLoginPresenterToModel.signInFacebook(loginFragment);
    }

    @Override
    public void signInGoogle(LoginFragment loginFragment) {
        mLoginPresenterToModel.signInGoogle(loginFragment);
    }

    @Override
    public void onLoginResponse(boolean isLoginSuccess) {
        mLoginPresenterToView.onLoginResponse(isLoginSuccess);
        mLoginPresenterToView.hideLoading();
    }

    @Override
    public void onError(String message) {
        mLoginPresenterToView.onError(message);
        mLoginPresenterToView.hideLoading();
    }

    @Override
    public void isLoggedIn(boolean isLoggedIn) {
        mLoginPresenterToView.isLoggedIn(isLoggedIn);
        mLoginPresenterToView.hideLoading();
    }

    @Override
    public void onActivityResult(LoginFragment loginFragment, int requestCode, int resultCode, Intent data) {
        mLoginPresenterToModel.onActivityResult(loginFragment, requestCode, resultCode, data);
    }

    @Override
    public void isLoggedIn() {
        mLoginPresenterToModel.isLoggedIn();
    }
}
