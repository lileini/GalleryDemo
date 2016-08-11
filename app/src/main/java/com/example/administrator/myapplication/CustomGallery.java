package com.example.administrator.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;

public class CustomGallery extends Gallery {
    ScalePageTransformer scalePageTransformer;

    public CustomGallery(Context context){
        super(context);
    }


    public CustomGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        if (scalePageTransformer ==null){
            scalePageTransformer = new ScalePageTransformer();
        }
        return super.getChildStaticTransformation(child, t);
    }
}
