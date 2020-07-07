package com.yw.customimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

/**
 * 原型图片堆叠效果，最后一张图片漏出其他遮住
 * create by yangwei
 * on 2019-11-18 21:31
 *
 * @author yangwei
 */
public class FoldImageViewLayout extends RelativeLayout {
    /**
     * 图片宽高
     */
    private int width = 200;
    /**
     * 填充，分上填充和下填充
     */
    private int margin = 0;

    /**
     * 默认图标
     */
    private int defaultIcon;
    /**
     * 第一张图是否显示完整
     */
    private boolean isFirstShow;
    /**
     * 是否是横向布局
     */
    private boolean isHLayout;
    private Context context;
    private TypedArray ta = null;

    public FoldImageViewLayout(Context context) {
        super(context);
        this.context = context;
    }

    public FoldImageViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        ta = context.obtainStyledAttributes(attrs, R.styleable.FoldImageViewLayout);
        width = ta.getDimensionPixelSize(R.styleable.FoldImageViewLayout_imageWidth, 30);
        margin = ta.getDimensionPixelSize(R.styleable.FoldImageViewLayout_margin, 30);
        isFirstShow = ta.getBoolean(R.styleable.FoldImageViewLayout_isFirstShow, true);
        isHLayout = ta.getBoolean(R.styleable.FoldImageViewLayout_isHLayout, true);
        defaultIcon = ta.getResourceId(R.styleable.FoldImageViewLayout_defaultIcon, R.drawable.girl);
        ta.recycle();
    }

    /**
     * 设置数据源
     *
     * @param datas 设置数据源
     */
    public void setList(List<String> datas) {
        if (datas == null) {
            return;
        }
        for (int i = datas.size() - 1; i >= 0; i--) {
            CircleImageView imageView = new CircleImageView(context);
            LayoutParams params = new LayoutParams(width, width);
            imageView.setLayoutParams(params);
            this.addView(imageView);
            loadImage(datas.get(i), imageView);
        }
    }

    /**
     * 加载图片
     *
     * @param url       图片路径
     * @param imageView 显示图片的容器
     */
    private void loadImage(String url, ImageView imageView) {
        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (android) GoogleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .build());
        Glide.with(context).load(glideUrl).into(imageView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取子View的数量
        int count = getChildCount();
        //循环遍历子View，并计算子View的总长度
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            //精确计算宽高
            int childWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
            int childHeightSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
            childView.measure(childWidthSpec, childHeightSpec);
        }
        //设置测量值，设置当前View的宽度和高度
        setMeasuredDimension((width - margin) * (count - 1) + width, width);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取ViewGroup中的View总数
        int count = getChildCount();
        if (isFirstShow) {
            for (int i = 0; i < count; i++) {
                //循环拿到子View，并计算其位置
                View childView = getChildAt(i);
                int measureWidth = childView.getMeasuredWidth();
                int measureHeight = childView.getMeasuredHeight();
                //给子View重新布局
                //第一张图片完全显示
                childView.layout((count - i - 1) * measureWidth - margin * (count - i - 1), t, ((count - i - 1) * measureWidth + measureWidth) - margin * (count - i - 1), b);
            }
        } else {
            for (int i = 0; i < count; i++) {
                //循环拿到子View，并计算其位置
                View childView = getChildAt(i);
                int measureWidth = childView.getMeasuredWidth();
                int measureHeight = childView.getMeasuredHeight();
                //给子View重新布局
                //最后一张图片完全显示
                childView.layout(i * measureWidth - margin * i, t, (i * measureWidth + measureWidth) - margin * i, b);
            }
        }

    }
}
