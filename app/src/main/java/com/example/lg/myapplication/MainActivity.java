package com.example.lg.myapplication;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.github.vivchar.viewpagerindicator.ViewPagerIndicator;

public class MainActivity extends Activity {
   private ViewPagerIndicator mViewPagerIndicator;
    private ViewPager mViewPager;



    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.viewpaper);

        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPagerIndicator.setupWithViewPager(mViewPager);
        mViewPagerIndicator.addOnPageChangeListener(mOnPageChangeListener);

    }


    private class MyPagerAdapter extends PagerAdapter
    {
        @Override
        public int getCount() {
            return 5;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {


            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(R.drawable.image1+position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public
        boolean isViewFromObject(final View view, final Object object) {
            return view.equals(object);
        }

        @Override
        public
        void destroyItem(final ViewGroup container, final int position, final Object object) {
            container.removeView((View) object);
        }

        @Override
        public
        CharSequence getPageTitle(final int position) {
            return String.valueOf(position);
        }
    }

    @NonNull
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener()
    {
        @Override
        public
        void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

        }

        @Override
        public
        void onPageSelected(final int position) {
            Toast.makeText(MainActivity.this, "Page selected " + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public
        void onPageScrollStateChanged(final int state) {

        }
    };
}