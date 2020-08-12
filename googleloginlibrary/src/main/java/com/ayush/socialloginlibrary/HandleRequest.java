package com.ayush.socialloginlibrary;

import android.app.Activity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

class HandleRequest {

    private UpdateUI updateUI = new UpdateUI();

    HandleRequest() {
    }

    void handleSignIn(Task<GoogleSignInAccount> task, Activity baseActivity, Class<? extends Activity> nextActivity){
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            //update the user, UpdateUI class
            updateUI.updateUI(baseActivity, account, baseActivity, nextActivity);
        }
        catch (ApiException e) {
            e.printStackTrace();
        }

    }
}
