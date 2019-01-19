package com.example.doannd.lazadaofme.interfaces;

import android.content.Context;
import android.content.Intent;

import com.example.doannd.lazadaofme.domain.UserDTO;
import com.example.doannd.lazadaofme.fragments.LoginFragment;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.Task;

public interface LoginContract {

    interface LoginToPresenter {
        void signIn(UserDTO userCredentials);

        void isLoggedIn();

        void signInFacebook(LoginFragment loginFragment);

        void signInGoogle(LoginFragment loginFragment);

        void onActivityResult(LoginFragment loginFragment, int requestCode, int resultCode, Intent data);

        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);

    }

    interface LoginPresenterToView {
        void onLoginResponse(boolean isLoginSuccess);

        void onError(String message);

        void isLoggedIn(boolean isLoggedIn);

        void showLoading();

        void hideLoading();
    }

    interface LoginPresenterToModel {
        void signIn(UserDTO userCredentials);

        void isLoggedIn();

        void signInFacebook(LoginFragment loginFragment);

        void signInGoogle(LoginFragment loginFragment);

        void onActivityResult(LoginFragment loginFragment, int requestCode, int resultCode, Intent data);

    }
}
