package com.example.administrator.demogit;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class TestPhotos extends AppCompatActivity {
    private static final int REQUEST_CODE_GALLERY = 200;
    private FunctionConfig functionConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos);
        FunctionConfig.Builder builder=new FunctionConfig.Builder();
        functionConfig=builder.build();
        intconfig(builder);
    }
    class MyHandlerResult implements  GalleryFinal.OnHanlderResultCallback{

        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            switch (reqeustCode){
                case 200:
                    Log.i("gsc","单选打开相册");
                    break;////单选打开相册
                case 50://多选打开相册
                    Log.i("gsc","多选打开相册");
                    break;
                case 300:
                    Log.i("gsc","使用拍照");
                    break;//使用拍照
                case 400:
                    Log.i("gsc","裁剪");
                    break;//裁剪
                case 500:
                    Log.i("gsc","编辑");
                    break;//编辑
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {

        }
    }
    MyHandlerResult mOnHanlderResultCallback=new MyHandlerResult();

    //单选打开相册
    public void dxPhoto(View view){
        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
      ;
//带配置


       // GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
    }

    private void intconfig(FunctionConfig.Builder builder) {
        //builder.setMutiSelect(false);//配置是否多选
        builder. setMutiSelectMaxSize(10);//配置多选数量
        builder.setEnableEdit(true);//开启编辑功能
        builder.setEnableCrop(true);//开启裁剪功能
        builder.setEnableRotate(true);//开启旋转功能
        builder.setEnableCamera(true);//开启相机功能
        builder.setCropWidth(50);//裁剪宽度
        builder.setCropHeight(80);//裁剪高度
        builder.setCropSquare(true);//裁剪正方形
       // builder.setSelected(List)//添加已选列表,只是在列表中默认呗选中不会过滤图片
       // builder.setFilter(List list)//添加图片过滤，也就是不在GalleryFinal中显示
       // builder.takePhotoFolter(File file)//配置拍照保存目录，不做配置的话默认是/sdcard/DCIM/GalleryFinal/
        builder.setRotateReplaceSource(true);//配置选择图片时是否替换原始图片，默认不替换
        builder.setCropReplaceSource(true);//配置裁剪图片时是否替换原始图片，默认不替换
        builder.setForceCrop(true);//启动强制裁剪功能,一进入编辑页面就开启图片裁剪，不需要用户手动点击裁剪，此功能只针对单选操作
        builder.setForceCropEdit(true);//在开启强制裁剪功能时是否可以对图片进行编辑（也就是是否显示旋转图标和拍照图标）
        builder.setEnablePreview(true);//是否开启预览功能
    }

    public void MxPhoto(View view){
        GalleryFinal.openGalleryMuti(50,3, mOnHanlderResultCallback);
////带配置
//        FunctionConfig config = new FunctionConfig.Builder(TestPhotos.this)
//                .setMutiSelectMaxSize(8)
//                .build();
//        GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, config, mOnHanlderResultCallback);
    }
    public void TakePhoto(View view){
        GalleryFinal.openCamera(300, mOnHanlderResultCallback);
    }
    //wenti
    public void cutPhoto(View view){
        GalleryFinal.openCrop(400, functionConfig,Environment.getDataDirectory().getPath(), mOnHanlderResultCallback);
       // GalleryFinal.openCrop(400, mOnHanlderResultCallback);
    }
    // //wenti
    public void EditPhoto(View view){
        GalleryFinal.openEdit(500, Environment.getDataDirectory().getPath(),mOnHanlderResultCallback);
      //  GalleryFinal.openEdit(500, mOnHanlderResultCallback);
    }

}
