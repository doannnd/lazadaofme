package com.example.doannd.lazadaofme.models;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.domain.UserDTO;
import com.example.doannd.lazadaofme.fragments.LoginFragment;
import com.example.doannd.lazadaofme.interfaces.LoginContract;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Collections;

public class LoginModel implements LoginContract.LoginPresenterToModel {

    private static final String TAG = LoginModel.class.getSimpleName();

    private static final int GOOGLE_SIGN_IN_REQUEST_CODE = 9001;

    private LoginContract.LoginToPresenter mLoginToPresenter;
    private CallbackManager mCallbackManager;

    public LoginModel(LoginContract.LoginToPresenter loginToPresenter) {
        this.mLoginToPresenter = loginToPresenter;
    }

    @Override
    public void signIn(UserDTO userCredentials) {

    }

    @Override
    public void isLoggedIn() {

    }

    @Override
    public void signInFacebook(final LoginFragment loginFragment) {
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mLoginToPresenter.onLoginResponse(true);
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "Facebook sign in cancel");
            }

            @Override
            public void onError(FacebookException error) {
                mLoginToPresenter.onError(loginFragment.getString(R.string.error_message_login));
            }
        });

        LoginManager.getInstance().logInWithReadPermissions(loginFragment, Collections.singletonList("public_profile"));
    }

    @Override
    public void signInGoogle(LoginFragment loginFragment) {
        GoogleSignInClient mGoogleSignInClient = getGoogleSignInClient(loginFragment.getActivity());
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        loginFragment.startActivityForResult(signInIntent, GOOGLE_SIGN_IN_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(LoginFragment loginFragment, int requestCode, int resultCode, Intent data) {
        // handle of google sign in
        if (requestCode == GOOGLE_SIGN_IN_REQUEST_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task, loginFragment);
        } else {
            // handle of facebook sign in
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> task, LoginFragment loginFragment) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            mLoginToPresenter.onLoginResponse(true);
        } catch (ApiException e) {
            Log.w(TAG, "googleSignInResult:failed code=" + e.getStatusCode());
            mLoginToPresenter.onError(loginFragment.getString(R.string.error_message_login));
        }
    }

    private GoogleSignInClient getGoogleSignInClient(Context context) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        return GoogleSignIn.getClient(context, gso);
    }

}
