package com.gridview.shirts;

/**
 * Created by Spicycurryman on 8/16/14.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ProjectShop.app.R;

public class ProjectImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array

    public Integer[] mProjectArray = {
            R.drawable.beach, R.drawable.afterschool,
            R.drawable.cancer, R.drawable.coffee,
            R.drawable.guitar, R.drawable.familynaan,


    };

    public String[] mProjectStringArray = {
            "Ocean Beach Cleanup in San Francisco", "New After-School Programs for SF Elementary Schools",
            "Cancer Research Fund in UCSF", "Organic Coffee Shop", "Opening a Guitar Shop on Market Street"
            , "Family Naan"
    };

    // Constructor
    public ProjectImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mProjectArray.length;
    }

    @Override
    public Object getItem(int position) {
        return mProjectArray[position];
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.textview_project, parent, false);

        ImageView imageView = null;
        TextView textView = null;
        if(convertView == null) {
            imageView = new ImageView(mContext);

            imageView.setMaxHeight(400);
            imageView.setImageResource(mProjectArray[position]);
            try {
                textView.setText(mProjectStringArray[position]);
            }
            catch(Exception e){
                Log.e("exception", e.getMessage());
            }

        }else{
            return convertView;
        }
        return imageView;
    }

}
