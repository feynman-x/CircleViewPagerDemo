package com.drolmen.viewpagerdemo;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        //准备数据
        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(Color.RED);
        lists.add(Color.YELLOW);
        lists.add(Color.GREEN);
        lists.add(Color.BLUE);

        BannerAdapter adapter = new BannerAdapter(lists);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(Integer.MAX_VALUE >> 2);
    }

    public static class BannerAdapter extends PagerAdapter{

        private final ArrayList<Integer> mDatas;

        public BannerAdapter(ArrayList<Integer> list) {
            mDatas = new CircleList<>(list);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setBackgroundColor(mDatas.get(position));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
