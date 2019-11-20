package com.yw.circleimageview;


import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.yw.customimageview.CircleImageView;
import com.yw.customimageview.HCircleRelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleImageView imageView =findViewById(R.id.imageview);
        List<String> datas = new ArrayList<>();
        datas.add("http://pic26.nipic.com/20121229/9252150_101013018353_2.jpg");
        datas.add("http://b-ssl.duitang.com/uploads/blog/201509/26/20150926184102_ZXtPh.jpeg");
        datas.add("http://pic19.nipic.com/20120302/6647776_211749086000_2.jpg");
        datas.add("http://pic26.nipic.com/20130129/9252150_095222158122_2.jpg");
        datas.add("http://pic77.nipic.com/file/20150909/9448607_165423679000_2.jpg");
        HCircleRelativeLayout relativeLayout = findViewById(R.id.h_rel);
        relativeLayout.setConfig(2, 200, R.mipmap.ic_launcher);
        relativeLayout.setList(datas);
        GlideUrl glideUrl = new GlideUrl(datas.get(0), new LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (android) GoogleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .build());
        Glide.with(this).load(glideUrl).placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}