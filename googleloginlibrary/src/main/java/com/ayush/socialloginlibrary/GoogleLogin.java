package com.ayush.socialloginlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;

public class GoogleLogin extends Activity implements ResultInterface{

    //handle the sign in
    HandleRequest handleRequest = new HandleRequest();

    private static final int RC_SIGN_IN = 1;
    Context context;
    Activity baseActivity;
    Class<? extends Activity> nextActivity;

    public GoogleLogin(Context context, Activity baseActivity, Class<? extends Activity> nextActivity) {
        this.context = context;
        this.baseActivity = baseActivity;
        this.nextActivity = nextActivity;
    }

    //returns intent, which will be used in mainactivity to call result activity
    public static Intent google_login(Activity baseActivity){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail().build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(baseActivity, gso);
        Intent intentGoogle = mGoogleSignInClient.getSignInIntent();
        baseActivity.startActivityForResult(intentGoogle, RC_SIGN_IN);
        return intentGoogle;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            //handle the sign in task by HandleRequest
            handleRequest.handleSignIn(task, baseActivity, nextActivity);
        }
    }
}
