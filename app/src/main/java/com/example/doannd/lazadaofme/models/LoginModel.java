package com.example.doannd.lazadaofme.models;

import android.content.Context;

import com.example.doannd.lazadaofme.domain.UserDTO;
import com.example.doannd.lazadaofme.interfaces.LoginContract;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class LoginModel implements LoginContract.LoginPresenterToModel {

    private LoginContract.LoginToPresenter mLoginToPresenter;

    public LoginModel(LoginContract.LoginToPresenter loginToPresenter) {
        this.mLoginToPresenter = loginToPresenter;
    }

    @Override
    public void login(UserDTO userCredentials) {

    }

    @Override
    public void loginGoogle(Context context) {

    }

    @Override
    public void loginFacebook() {

    }

    @Override
    public void isLoggedIn() {

    }

    private GoogleSignInClient getGoogleSignInClient(Context context) {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        return GoogleSignIn.getClient(context, gso);
    }
}
