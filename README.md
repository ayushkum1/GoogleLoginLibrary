# GoogleLoginLibrary

<h2><strong>Google Login Library</strong></h2>
<p>This library will do google login and if authentication is successful, logs you in and takes you to next specified activity</p>
<ul>
    <p>To use this library, you need to do the following: </p>
    <li>Create a project in Android Studio.</li>
    <li>Connect it to Google Firebase and enable google login from Authentication</li>
    <li>Add your SHA1 fingerprint to your project. Add required dependencies for firebase in your project</li>
    <li>Add a button which will trigger login.</li>
</ul>

<ul>
    <li>Add the following in your project level gradle file</li>
    <img src="https://i.postimg.cc/DzWps8yV/Project-level-gradle-dependency-1.jpg">
  
  > maven { url 'https://jitpack.io' }
</ul>

<ul>
    <li>Add the following in your app level gradle file</li>
    <img src="https://i.postimg.cc/v80dyxjM/App-level-gradle-dependency-1-1.jpg">
  
  > implementation 'com.github.ayushkum1:GoogleLoginLibrary:0.1.0'
</ul>

<p>Sync your gradle file</p>

<ul>
  <li>Now, in your base activity, implement <strong>ResultInterface</strong> interface, as shown</li>
    
  > public class MainActivity extends AppCompatActivity implements ResultInterface{
  >      ...
  >      }
  
  <li>Implement the onActivityResult(), it will be like the below code</li>
  
  > @Override
  
  >  public void onActivityResult(int requestCode, int resultCode, Intent data) {
  
  >      super.onActivityResult(requestCode, resultCode, data);
 
  >  }
</ul>

<ul>
  <li>Declare the following: </li>
  <p>UpdateUI class updates the user with required action after the authentication</p>
  
  > UpdateUI updateUI = new UpdateUI(); 
  <p>Request Code</p>
  
  > public static final int RC_SIGN_IN = 1;
  <p>Call the parameterized constructor of GoogleLogin class which takes your current activity or base activity as first parameter and next activity(where you want to go after successfull login) as the two parameters </p>
  
  > GoogleLogin googleLogin = new GoogleLogin(this, base_activity.this, next_activity.class);
</ul>

<ul>
  <li>In your onStart() add the following code:</li>
  
  <p>
  
  ```
  GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
  if(account!= null){
            updateUI.updateUI(this, account, base_activity.this, next_activity.class);
            updateUI.updateUI(this, account, base_activity.this, next_activity.class);
            }
  ```
  
  <p>should look something like this:</p>
  <img src="https://i.postimg.cc/Prk8xqJ9/Screenshot-from-2020-08-14-23-08-42-1.jpg">
</ul>

<ul>
    <li>Now in your onCreate() add the following code</li>
    <li>Call the google_login(base_activity) from GoogleLogin class and the call startActivityForResult() as shown below</li>
    
    GoogleLogin.google_login(base_activity.this);
    startActivityForResult(GoogleLogin.google_login(base_activity.this), RC_SIGN_IN);
       
  <p>Your code will look like this:</p>
  <img src="https://i.postimg.cc/nc4ZFF9d/on-Create-1.jpg">
</ul>

<ul>
  <li>Finally in your onActivityResult() write the below code: </li>
  
 > googleLogin.onActivityResult(requestCode, resultCode, data);
 
</ul>

- To get photo url, in your next activity class write:
```
Intent intent = getIntent();
String photo = String.valueOf(intent.getParcelableExtra("photo"));
```
