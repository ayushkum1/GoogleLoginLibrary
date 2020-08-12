package com.ayush.socialloginlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class UpdateUI extends Activity {

    public UpdateUI() {
    }

    public void updateUI(Context context, GoogleSignInAccount account, Activity baseActivity, Class<? extends Activity> nextActivity){
        if(account != null){
            Intent intent = new Intent(baseActivity, nextActivity);
            if(account.getPhotoUrl()!=null){
                intent.putExtra("photo", account.getPhotoUrl());//photo
            }
            else {
                intent.putExtra("photo", "");
            }
            context.startActivity(intent);

        }
        else{
            Toast.makeText(baseActivity, "error", Toast.LENGTH_SHORT).show();
        }
    }

}
