package com.example.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Gallery gallery;
    int[] imageRes = {R.mipmap.img_jgca2x,R.mipmap.img_jgca2x,R.mipmap.img_jgca2x,R.mipmap.img_jgca2x,R.mipmap.img_jgca2x};
    private String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setSpacing(50);
        gallery.setUnselectedAlpha(0.3f);
        gallery.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                Log.i(TAG,"visibility");
            }
        });
//        gallery.
    }

    class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context context){
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return imageRes == null ? 0:imageRes.length;
        }

        @Override
        public Object getItem(int position) {
            return imageRes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (convertView == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.imageview, null);

            }else {
                view = convertView;
            }
//            Log.i(TAG,"getview: "+ view);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);

            imageView.setImageResource(imageRes[position]);
            imageView.setTag(position);
            //        imageView.setImageResource(mList.get(position).getId());
            /*imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //                Toast.makeText(mContext, strList.get(position), Toast.LENGTH_SHORT).show();
                    if (strList.get(position).getContent() == null) {
                        Intent intent = new Intent(mContext, MainActivity.class);
                        intent.putExtra("strlist", strList.get(position));
                        mContext.startActivity(intent);
                    } else {
                        Intent intent = new Intent(mContext, TopicsWebActivity.class);
                        mContext.startActivity(intent);
                    }
                }
            });*/
            return view;
        }
    }
}
