package com.yw.circleimageview;


import android.app.Activity;
import android.os.Bundle;

import com.yw.customimageview.CircleImageView;
import com.yw.customimageview.FoldImageViewLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试入口
 *
 * @author yangwei
 */
public class MainActivity extends Activity {
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        loadImage();
        loadHFirstImageLayout();
        loadHLastImageLayout();
        loadVFirstImageLayout();
        loadVLastImageLayout();
    }

    private void initData() {
        datas = Utils.getImagData();
    }

    /**
     * 加载第一个图片完整显示的布局
     */
    private void loadHFirstImageLayout() {
        FoldImageViewLayout relativeLayout = findViewById(R.id.h_first_rel);
        relativeLayout.setList(datas);
    }

    /**
     * 加载最后一张图片完整显示的布局
     */
    private void loadHLastImageLayout() {
        FoldImageViewLayout relativeLayout = findViewById(R.id.h_last_rel);
        relativeLayout.setList(datas);
    }

    /**
     * 加载纵向第一个图片完整显示的布局
     */
    private void loadVFirstImageLayout() {
        FoldImageViewLayout relativeLayout = findViewById(R.id.v_first_rel);
        relativeLayout.setList(datas);
    }

    /**
     * 加载纵向最后一个完整显示的布局
     */
    private void loadVLastImageLayout() {
        FoldImageViewLayout relativeLayout = findViewById(R.id.v_last_rel);
        relativeLayout.setList(datas);
    }

    /**
     * 加载单张圆形图片
     */
    private void loadImage() {
        CircleImageView imageView = findViewById(R.id.imageview);
        Utils.loadImage(this, imageView, datas.get(0));
    }
}
