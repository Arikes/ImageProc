package com.kame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kame.functions.EditImageActivity;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mBtnEditImage;
    private Button mBtnTakePhoto;
    private Button mBtnComposeImgVideo;
    private Button mBtnEditVideo;
    private Button mBtnMixVideo;

    private static final int REQUEST_CODE_CHOOSE = 23;//定义请求码常量
    private Button mBtnChooseImage;
    List<Uri> mSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI(){
        mBtnEditImage = findViewById(R.id.btn_edit_image);
        mBtnEditImage.setOnClickListener(this);
        mBtnTakePhoto = findViewById(R.id.btn_take_photo);
        mBtnTakePhoto.setOnClickListener(this);
        mBtnComposeImgVideo = findViewById(R.id.btn_compose_image);
        mBtnComposeImgVideo.setOnClickListener(this);
        mBtnEditVideo = findViewById(R.id.btn_edit_video);
        mBtnEditVideo.setOnClickListener(this);
        mBtnMixVideo = findViewById(R.id.btn_mix_edit);
        mBtnMixVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_edit_image:
                editImage();
                break;
            case R.id.btn_take_photo:
                takePhoto();
                break;
            case R.id.btn_compose_image:
                composeVideo();
                break;
            case R.id.btn_edit_video:
                editVideo();
                break;
            case R.id.btn_mix_edit:
                mixEditVideo();
                break;
            default:
                break;
        }
    }

    private void editImage(){
        Log.e(TAG,"function editImage");

        Intent editImageIntent = new Intent(MainActivity.this, EditImageActivity.class);
        startActivity(editImageIntent);
    }

    private void takePhoto(){
        Log.e(TAG,"function takePhoto");
    }

    private void composeVideo(){
        Log.e(TAG,"function composeVideo");
    }

    private void editVideo(){
        Log.e(TAG,"function editVideo");
    }

    private void mixEditVideo(){
        Log.e(TAG,"function mixEditVideo");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
        }
    }
}
