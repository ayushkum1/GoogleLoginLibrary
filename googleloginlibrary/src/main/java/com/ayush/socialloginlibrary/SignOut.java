package com.ayush.socialloginlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class SignOut {

    public SignOut() {
    }

    public void signout(final Context context, GoogleSignInOptions gso, final Activity baseActivity, final Class<? extends Activity> nextActivity){
        GoogleSignInClient client = GoogleSignIn.getClient(context, gso);
        client.signOut().addOnCompleteListener(baseActivity, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(baseActivity, "logged out", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(baseActivity, nextActivity));
            }
        }).addOnFailureListener(baseActivity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(baseActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
