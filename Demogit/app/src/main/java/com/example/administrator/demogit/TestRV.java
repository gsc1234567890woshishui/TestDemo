package com.example.administrator.demogit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.dinuscxj.pullzoom.PullZoomRecyclerView;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class TestRV extends Activity {
    private RecyclerView pz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testrv);
        pz= (RecyclerView) findViewById(R.id.recycler_view);
        String[] dataURls={"http://a.hiphotos.baidu.com/image/pic/item/e7cd7b899e510fb3a78c787fdd33c895d0430c44.jpg","http://e.hiphotos.baidu.com/image/pic/item/7aec54e736d12f2ee5e3bf6a4dc2d562843568d1.jpg","http://g.hiphotos.baidu.com/image/pic/item/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg","http://b.hiphotos.baidu.com/image/pic/item/d788d43f8794a4c224a6a42b0cf41bd5ad6e392c.jpg","http://a.hiphotos.baidu.com/image/pic/item/e7cd7b899e510fb3a78c787fdd33c895d0430c44.jpg","http://e.hiphotos.baidu.com/image/pic/item/7aec54e736d12f2ee5e3bf6a4dc2d562843568d1.jpg"};
        pz.setAdapter(new MyRvAdapter(dataURls));
        pz.setLayoutManager(new LinearLayoutManager(this));
//        View zoomView = LayoutInflater.from(this).inflate(R.layout.head_zoom, null);
//        pz.setZoomView(zoomView);
//        LinearLayout headView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.headview1, null);
//        pz.setHeaderContainer(headView);
    }
}
