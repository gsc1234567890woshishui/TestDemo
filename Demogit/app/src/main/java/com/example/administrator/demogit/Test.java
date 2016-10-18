package com.example.administrator.demogit;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Test  extends Activity implements  View.OnClickListener {
    private PullToZoomScrollViewEx pz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        pz= (PullToZoomScrollViewEx) findViewById(R.id.pz);
        View headView = LayoutInflater.from(this).inflate(R.layout.headview, null);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.head_zoom, null);
        View contentView = LayoutInflater.from(this).inflate(R.layout.content_view, null);
        pz.setHeaderView(headView);
        pz.setZoomView(zoomView);
        pz.setScrollContentView(contentView);
        setPullToZoomViewLayoutParams(pz);
        pz.getPullRootView().findViewById(R.id.t).setOnClickListener(this);
    }

    // 设置头部的View的宽高。
    private void setPullToZoomViewLayoutParams(PullToZoomScrollViewEx scrollView) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth,
                (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }



    @Override
    public void onClick(View v) {
        Log.i("gsc","onClick)");
    }
}
