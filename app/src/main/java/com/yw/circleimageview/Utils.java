package com.yw.circleimageview;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * create by yangwei
 * on 2020/6/30 09:41
 */
public class Utils {
    /**
     * 获取图片数据
     *
     * @return 返回图片数据
     */
    public static List<String> getImagData() {
        List<String> datas = new ArrayList<>();
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593497751365&di=08613eeca8d1f3a50684d8916e3a0783&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201711%2F25%2F20171125090718_zavJd.thumb.700_0.png");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593497751364&di=9e036f9d2579b8cec6ce4599726a20b8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171110%2Fbd4b16a2eaa74eb683704ff4f85dc813.jpeg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593497751364&di=4ada9bf29e769bf8268d6846135d2586&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201806%2F22%2F20180622155427_qewbl.thumb.400_0.jpg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593497751364&di=9789241d54fe868330aa3dd9fb48157d&imgtype=0&src=http%3A%2F%2Fpics4.baidu.com%2Ffeed%2F37d3d539b6003af3d6c4234ad7a202581038b628.jpeg%3Ftoken%3D138d3113ca1211ea227ed69443fe5351%26s%3D5BA8BB454802765D02A5888F03006083");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593497751363&di=56678de0150a164af8f7bf0b63564d5c&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn15%2F652%2Fw829h623%2F20180518%2Fb390-haturfs1330800.png");
        return datas;
    }

    /**
     * 加载ImageView
     *
     * @param imageView ImageView
     * @param url       图片链接
     */
    public static void loadImage(Context context, ImageView imageView, String url) {
        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (android) GoogleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .build());
        Glide.with(context).load(glideUrl).placeholder(R.mipmap.ic_launcher)
                .listener(new RequestListener<GlideUrl, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, GlideUrl model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.e("Excepton:", e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, GlideUrl model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.e("Excepton:", "执行成功");
                        return false;
                    }
                }).into(imageView);
    }
}
