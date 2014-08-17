package com.ProjectShop.app;

/**
 * Created by Spicycurryman on 8/16/14.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.gridview.shirts.ImageAdapter;

public class ImageZoomActivity extends Activity {

    private TextView Small;
    private TextView Medium;
    private TextView Large;

    private TextView XLarge;

    View previousView;
   private Button purchasebutton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_image);


        SpannableString s = new SpannableString("ProjectShop");
        s.setSpan(new TypefaceSpan(this, "actionman.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Update the action bar title with the TypefaceSpan instance
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);

        Small = (TextView) findViewById(R.id.Small);
        Small.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/actionmanshaded.ttf"));

        Medium = (TextView) findViewById(R.id.Medium);
        Medium.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/actionmanshaded.ttf"));

        Large = (TextView) findViewById(R.id.Large);
        Large.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/actionmanshaded.ttf"));

        XLarge = (TextView) findViewById(R.id.XLarge);
        XLarge.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/actionmanshaded.ttf"));


        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mLargeThumbIds[position]);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView previousText = (TextView) previousView;
                TextView curText = (TextView) v;
                // If the clicked view is selected, do nothing
                if (curText.isSelected()) {
                    //curText.setSelected(false);
                    //curText.setTextColor(getResources().getColor(R.color.red_highlight));
                } else { // If this isn't selected, deselect  the previous one (if any)
                    if (previousText != null && previousText.isSelected()) {
                        previousText.setSelected(false);
                        previousText.setTextColor(getResources().getColor(R.color.black));
                    }
                    curText.setSelected(true);
                    curText.setTextColor(getResources().getColor(R.color.red_highlight));
                    previousView = v;
                }

            }




        };


        findViewById(R.id.Small).setOnClickListener(clickListener);
        findViewById(R.id.Medium).setOnClickListener(clickListener);
        findViewById(R.id.Large).setOnClickListener(clickListener);
        findViewById(R.id.XLarge).setOnClickListener(clickListener);


        purchasebutton = (Button) findViewById(R.id.purchasebutton);


        purchasebutton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(ImageZoomActivity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.payment);
                // Set dialog title
                dialog.setTitle("Payment Information");



                dialog.show();

                Button submitbutton = (Button) dialog.findViewById(R.id.btnsubmit);
                // if decline button is clicked, close the custom dialog
                submitbutton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });


            }

        });





    }








}