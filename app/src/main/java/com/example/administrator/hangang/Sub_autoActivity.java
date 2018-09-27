package com.example.administrator.hangang;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;

import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;


public class Sub_autoActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;
    private ConvenientBanner convenientBanner;

    private ArrayList<String> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.sub_auto_main);
        //loadTestDatas();


        actionBar = getSupportActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ;
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        RollPagerView mRollViewPager = (RollPagerView)findViewById(R.id.rollpagerview);
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));
    }



    @Override
    protected void onResume() {
        super.onResume();

    }


    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.mainimgslide1,
                R.drawable.mainimgslide2,
                R.drawable.mainimgslide3,
                R.drawable.mainimgslide4,
                R.drawable.mainimgslide5,
                R.drawable.mainimgslide6,

        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.openDrawer(GravityCompat.START);
            }else{
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
