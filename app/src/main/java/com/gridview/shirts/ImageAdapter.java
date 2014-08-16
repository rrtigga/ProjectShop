package com.gridview.shirts;

/**
 * Created by Spicycurryman on 8/16/14.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ProjectShop.app.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.tshirt1, R.drawable.tshirt2,
            R.drawable.tshirt3, R.drawable.tshirt4,
            R.drawable.tshirt5, R.drawable.tshirt6,
            R.drawable.tshirt7, R.drawable.tshirt8,
            R.drawable.tshirt9, R.drawable.tshirt10,
            R.drawable.tshirt11, R.drawable.tshirt12,

    };

    public Integer[] mLargeThumbIds = {
            R.drawable.cooltshirt1, R.drawable.cooltshirt2,
            R.drawable.cooltshirt3, R.drawable.cooltshirt4,
            R.drawable.cooltshirt5, R.drawable.cooltshirt6,
            R.drawable.cooltshirt7, R.drawable.cooltshirt8,
            R.drawable.cooltshirt9, R.drawable.cooltshirt10,
            R.drawable.cooltshirt11, R.drawable.cooltshirt12,

    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;
        if(convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setMaxHeight(400);
            imageView.setImageResource(mThumbIds[position]);
        }else{
            return convertView;
        }
        return imageView;
    }

}
