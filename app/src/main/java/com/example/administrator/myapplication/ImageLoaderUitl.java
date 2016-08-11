package com.example.administrator.myapplication;

import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * created by litao
 **/
public class ImageLoaderUitl {
    /**
     * 从uri中加载图片到view中
     * @param view
     * @param uri
     */
    public static void loadImage(ImageView view,Uri uri){
        Picasso.with(view.getContext())
                .load(uri)
                .fit()
                .centerCrop()
                .into(view);
    }

    /**
     * 从resId中加载图片到view中
     * @param view
     * @param resId
     */
    public static void loadImage(ImageView view,int resId){
        Picasso.with(view.getContext())
                .load(resId)
                .fit()
                .centerCrop()
                .into(view);
    }

    public static void loadImage(ImageView view,String path,int errorResId){
        Picasso.with(view.getContext())
                .load(path)
                .error(errorResId)
                .fit()
                .centerCrop()
                .into(view);
    }
}
