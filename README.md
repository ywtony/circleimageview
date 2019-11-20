# circleimageview
圆形图片以及一组折叠的原型图片

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ywtony:circleimageview:v0.1'
	}
使用方法：

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
	
<?xml version="1.0" encoding="utf-8"?>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000000"
    android:orientation="vertical"
    tools:context=".MainActivity">
    
    <com.yw.customimageview.CircleImageView
        android:id="@+id/imageview"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:scaleType="centerCrop"
        android:src="@mipmap/girl"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="29dp"
        tools:layout_editor_absoluteY="294dp" />
    <com.yw.customimageview.HCircleRelativeLayout
        android:id="@+id/h_rel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        tools:ignore="MissingConstraints" />
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <com.yw.customimageview.CircleImageView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            tools:ignore="MissingConstraints" />
        <com.yw.customimageview.CircleImageView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            android:layout_marginLeft="60dp"
            tools:ignore="MissingConstraints" />
        <com.yw.customimageview.CircleImageView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            android:layout_marginLeft="140dp"
            tools:ignore="MissingConstraints" />
        <com.yw.customimageview.CircleImageView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            android:layout_marginLeft="220dp"
            tools:ignore="MissingConstraints" />
    </RelativeLayout>
</LinearLayout>



![测试结果](https://github.com/ywtony/circleimageview/blob/master/app/src/main/demo_image.jpeg)
  
  


