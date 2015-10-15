package com.shrimpcolo.wosao;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;

import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.ArrayList;


public class HomeActivityTest extends ActionBarActivity implements View.OnClickListener {

    //step_8 test facebook
    private ImageView imageView;
    private CallbackManager callbackManager;
    private static final String TAG = "THQ";
    private Utils utils = new Utils();
    private LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //facebook step_001
        utils.printKeyHash(this);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        Log.e(TAG, "onCreate!!!");
        setContentView(R.layout.act_home);
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//                Log.e(TAG, "onSuccess --------" + loginResult.getAccessToken());
//                Log.e(TAG, "Token --------" + loginResult.getAccessToken().getToken());
//                Log.e(TAG, "Permision--------" + loginResult.getRecentlyGrantedPermissions());
//
//                Log.e(TAG, "OnGraph ------------------------");
//                GraphRequest request = GraphRequest.newMeRequest(
//                        loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(
//                                    JSONObject object,
//                                    GraphResponse response) {
//                                // Application code
//                                Log.e(TAG, "GraphResponse -------------" + response.toString());
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,link,gender,birthday,email,first_name,last_name,location,locale,timezone");
//                request.setParameters(parameters);
//                request.executeAsync();
//
//                Log.e(TAG, "Total Friend in List ----------------------");
//                new GraphRequest(
//                        loginResult.getAccessToken(),
//                        "/me/friends",
//                        null,
//                        HttpMethod.GET,
//                        new GraphRequest.Callback() {
//                            public void onCompleted(GraphResponse response) {
//                                /* handle the result */
//                                Log.e(TAG, "Friend in List -------------" + response.toString());
//                            }
//                        }
//                ).executeAsync();
//
//            }
//
//            @Override
//            public void onCancel() {
//                Log.e(TAG, "onCancel...");
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//                Log.e(TAG, "onError: " + e.toString());
//            }
//        });


        //step_9
//        imageView = (ImageView) findViewById(R.id.im_icon_share);
//        imageView.setOnClickListener(this);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        Log.e(TAG, "loginButton: " + loginButton);
        if (loginButton == null) {
            return;
        }
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email", "user_birthday"));

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
//                Log.e(TAG, "onSuccess --------" + loginResult.getAccessToken());
//                Log.e(TAG, "Token --------" + loginResult.getAccessToken().getToken());
//                Log.e(TAG, "Permision--------" + loginResult.getRecentlyGrantedPermissions());
//
//                Log.e(TAG, "OnGraph ------------------------");
//                GraphRequest request = GraphRequest.newMeRequest(
//                        loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(
//                                    JSONObject object,
//                                    GraphResponse response) {
//                                // Application code
//                                Log.e(TAG, "GraphResponse -------------" + response.toString());
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,link,gender,birthday,email,first_name,last_name,location,locale,timezone");
//                request.setParameters(parameters);
//                request.executeAsync();
//
//                Log.e(TAG, "Total Friend in List ----------------------");
//                new GraphRequest(
//                        loginResult.getAccessToken(),
//                        "/me/friends",
//                        null,
//                        HttpMethod.GET,
//                        new GraphRequest.Callback() {
//                            public void onCompleted(GraphResponse response) {
//                                /* handle the result */
//                                Log.e(TAG, "Friend in List -------------" + response.toString());
//                            }
//                        }
//                ).executeAsync();
            }

            @Override
            public void onCancel() {
                // App code
                Log.e(TAG, "onCancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.e(TAG, "onError: " + exception.getMessage()
                +"\n " + exception.toString());
            }
        });
    }

    //add click
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_icon_share:
                Log.e(TAG, "onClick...");
                //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile",
                  //      "user_friends", "email", "user_birthday"));

               // LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));

                android.util.Log.e(TAG, "go to facebook login!!!");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "onResume!!!");
        //AppEventsLogger.activateApp(this);
    }

    //step_
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(TAG, "request: " + requestCode + ",  resultCode: " + resultCode
                + ", data: " + data.toString());
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
