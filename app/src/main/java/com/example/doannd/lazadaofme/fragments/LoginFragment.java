package com.example.doannd.lazadaofme.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.activities.LoginActivity;
import com.example.doannd.lazadaofme.activities.MainActivity;
import com.example.doannd.lazadaofme.utils.CommonUtils;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.fragment_login_btn_login_google)
    Button btnLoginGoogle;
    @BindView(R.id.fragment_login_btn_login_facebook)
    Button btnLoginFacebook;

    private String mParam1;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(int position) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        // handle event in fragment login
        btnLoginGoogle.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fragment_login_btn_login_google: {
                // TODO:
                singInGoogle();
                break;
            }
            case R.id.fragment_login_btn_login_facebook: {
                // TODO:
                singInFacebook();
                break;
            }
            default: {
                // TODO:
            }
        }
    }

    private void singInFacebook() {
    }

    private void singInGoogle() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

}
