package com.ayush.sociallogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ayush.socialloginlibrary.UpdateUI;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.ayush.socialloginlibrary.GoogleLogin;
import com.ayush.socialloginlibrary.ResultInterface;

public class MainActivity extends AppCompatActivity implements ResultInterface {

    UpdateUI updateUI = new UpdateUI();

    public static final int RC_SIGN_IN = 1;

    Button btnLogin;
    Context context;

    GoogleLogin googleLogin = new GoogleLogin(context, MainActivity.this, HomeScreen.class);

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!= null){
            updateUI.updateUI(this, account, MainActivity.this, HomeScreen.class);
        }
        else {
            Toast.makeText(this, "Pls log in", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        btnLogin = findViewById(R.id.tv);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleLogin.google_login(MainActivity.this);
                if (account != null) {
                    start(GoogleLogin.google_login(MainActivity.this), RC_SIGN_IN);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0){
            Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
        }
        else{
            googleLogin.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void start(Intent data, int requestcode){
        this.startActivityForResult(data, requestcode);
    }
}
