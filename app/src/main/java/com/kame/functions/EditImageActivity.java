package com.kame.functions;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.kame.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

public class EditImageActivity extends Activity {
    private static final int REQUEST_CODE_CHOOSE = 23;//定义请求码常量
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);

                Matisse
                .from(EditImageActivity.this)
                .choose(MimeType.ofAll())//照片视频全部显示
                .countable(true)//有序选择图片
                .maxSelectable(12)//最大选择数量为9
                .gridExpectedSize(480)//图片显示表格的大小getResources()
//                .getDimensionPixelSize(R.dimen.grid_expected_size)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//图像选择和预览活动所需的方向。
                .thumbnailScale(0.85f)//缩放比例
                .theme(R.style.Matisse_Dracula)//主题  暗色主题 R.style.Matisse_Dracula
                .imageEngine(new GlideEngine())//加载方式
                .forResult(REQUEST_CODE_CHOOSE);//请求码
    }
}
