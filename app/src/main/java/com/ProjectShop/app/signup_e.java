package com.ProjectShop.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/**
 * Created by Spicycurryman on 7/19/14.
 */
public class signup_e extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.signup);



    }





    public void sendMsg(View view) {
        // Do something in response to button

        //change back
        Intent intent = new Intent(this, GridView_ShirtM.class);
        startActivity(intent);
    }

}
