package com.ayush.sociallogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ayush.socialloginlibrary.SignOut;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class HomeScreen extends AppCompatActivity {

    Button btn;
    ImageView ivPro;
    SignOut signOut = new SignOut();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.btn);
        ivPro = findViewById(R.id.propic);

        Intent intent = getIntent();

        final String photo = String.valueOf(intent.getParcelableExtra("photo"));

        Picasso.with(this).load(photo).into(ivPro, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                Toast.makeText(HomeScreen.this, "error loading pic", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions
                                            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                            .build();
                signOut.signout(HomeScreen.this, gso, HomeScreen.this, MainActivity.class);
            }
        });
    }
}
