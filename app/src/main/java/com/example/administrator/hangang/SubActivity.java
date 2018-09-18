package com.example.administrator.hangang;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;

import java.util.ArrayList;

import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;



import android.graphics.drawable.Animatable;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;


public class SubActivity extends AppCompatActivity  implements OnViewTapListener {

    private ConvenientBanner convenientBanner;

    private ArrayList<String> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.sub_main);
        loadTestDatas();
        initViews();
        init();

    }

    @Override
    public void onViewTap(View view, float x, float y) {
        //单击关闭
        finish();
    }


    private void initViews() {
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);



    }

    private void init(){
        loadTestDatas();
        //图片例子
        convenientBanner.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public NetWorkImageHolderView createHolder(View itemView) {
                        return new NetWorkImageHolderView(itemView, SubActivity.this);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_photoview;
                    }
                }, images).setCanLoop(true)

                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});


    }


    @Override
    protected void onResume() {
        super.onResume();

        convenientBanner.setCanLoop(true);
    }

    /*
        加入测试Views
        * */
    private void loadTestDatas() {
        //图片可能过期哦，自己换来测试吧
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525319864&di=87f476652c96678547ccabbf112076be&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fgamephotolib%2F1410%2F27%2Fc0%2F40170771_1414341013392.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524714908870&di=9d43d35cefbabacdc879733aa7ddc82b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D46de93bfc711728b24208461a095a9bb%2F4610b912c8fcc3ce5423d51d9845d688d43f2038.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524714935901&di=052557513540f3d740eeeb2439c585bb&imgtype=0&src=http%3A%2F%2Fwww.gzlco.com%2Fimggzl%2F214%2F1b6e6520ca474fe4bd3ff728817950717651.jpeg");
    }


    public class NetWorkImageHolderView extends Holder<String>{
        private PhotoDraweeView ivPost;

        public NetWorkImageHolderView(View itemView, OnViewTapListener onViewTapListener) {
            super(itemView);
            ivPost.setOnViewTapListener(onViewTapListener);
        }

        @Override
        protected void initView(View itemView) {
            ivPost =itemView.findViewById(R.id.ivPost);
        }

        @Override
        public void updateUI(String data) {
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(data);
            controller.setOldController(ivPost.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null) {
                        return;
                    }
                    ivPost.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            ivPost.setController(controller.build());
        }
    }

    class LocalImageHolderView extends Holder<Integer> {

        private ImageView imageView;

        public LocalImageHolderView(View itemView) {
            super(itemView);
        }

        @Override
        protected void initView(View itemView) {
            imageView =itemView.findViewById(R.id.ivPost);
        }

        @Override
        public void updateUI(Integer data) {
            imageView.setImageResource(data);
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

        return super.onOptionsItemSelected(item);
    }
}
