package com.example.doannd.lazadaofme.interfaces;

import android.content.Context;
import android.content.Intent;

import com.example.doannd.lazadaofme.domain.UserDTO;

public interface LoginContract {

    interface LoginToPresenter {

        void login(UserDTO userCredentials);

        void loginGoogle(Context context);

        void loginFacebook();

        void isLoggedIn();

        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);

        void onActivityResult(int requestCode, int resultCode, Intent data);

    }

    interface LoginPresenterToView {

        void showProgress();

        void hideProgress();

        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    interface LoginPresenterToModel {
        void login(UserDTO userCredentials);

        void loginGoogle(Context context);

        void loginFacebook();

        void isLoggedIn();
    }
}
