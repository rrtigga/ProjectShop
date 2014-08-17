package com.ProjectShop.app;

/**
 * Created by Spicycurryman on 8/16/14.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.ImageView;

import com.gridview.shirts.ProjectImageAdapter;

public class ProjectZoomActivity extends Activity {





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectzoom);


        SpannableString s = new SpannableString("ProjectShop");
        s.setSpan(new TypefaceSpan(this, "actionman.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Update the action bar title with the TypefaceSpan instance
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);


        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ProjectImageAdapter imageAdapter = new ProjectImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mProjectArray[position]);


    }



    }








