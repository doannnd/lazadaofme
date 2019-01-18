package com.example.doannd.lazadaofme.interfaces;

import com.example.doannd.lazadaofme.domain.UserDTO;

public interface LoginContract {

    interface LoginToPresenter {

        void login(UserDTO userCredentials);

        void isLoggedIn();

        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);
    }

    interface LoginPresenterToView {

        void showProgress();

        void hideProgress();

        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);
    }

    interface LoginPresenterToModel {
        void login(UserDTO userCredentials);

        void isLoggedIn();
    }
}
