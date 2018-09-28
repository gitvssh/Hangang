package com.example.administrator.hangang.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.hangang.R;
//어댑터에서 사용하는 1개 아이템 뷰 인플레이터
public class SearchView extends LinearLayout{
    TextView textView;
    TextView textView2;
    ImageView imageView;

    public SearchView(Context context){
        super(context);
        init(context);
    }

    public SearchView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.search, this, true);

        textView = (TextView) findViewById(R.id.s_title);
        textView2 = (TextView) findViewById(R.id.s_content);
        imageView = (ImageView) findViewById(R.id.s_image);


    }

    public void setTitle(String title){
        textView.setText(title);

    }
    public void setContent(String content){
        textView2.setText(content);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
}
