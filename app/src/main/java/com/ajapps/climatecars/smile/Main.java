package com.ajapps.climatecars.smile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


@SuppressWarnings("deprecation")
public class Main extends Activity implements ViewSwitcher.ViewFactory {

    Integer pics[] = { R.drawable.image1, R.drawable.image2, R.drawable.image4,
            R.drawable.image5, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16};

    ImageSwitcher iSwitcher;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iSwitcher = (ImageSwitcher) findViewById(R.id.ImageSwitcher01);
        iSwitcher.setFactory(this);
        iSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        Gallery gallery = (Gallery) findViewById(R.id.Gallery01);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                iSwitcher.setImageResource(pics[arg2]);
            }
        });
    }

    @SuppressWarnings("deprecation")
    public class ImageAdapter extends BaseAdapter {

        private Context ctx;

        public ImageAdapter(Context c) {
            ctx = c;
        }

        @Override
        public int getCount() {

            return pics.length;
        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg0) {

            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            ImageView iView = new ImageView(ctx);
            iView.setImageResource(pics[arg0]);
            iView.setScaleType(ImageView.ScaleType.FIT_XY);
            iView.setLayoutParams(new Gallery.LayoutParams(300, 300));
            return iView;
        }

    }

    @Override
    public View makeView() {
        ImageView iView = new ImageView(this);
        iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iView.setLayoutParams(new ImageSwitcher.LayoutParams(
                Gallery.LayoutParams.FILL_PARENT, Gallery.LayoutParams.FILL_PARENT));
        iView.setBackgroundColor(0xffffffff);
        return iView;
    }
}
