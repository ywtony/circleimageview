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

 /**
     * 加载第一个图片完整显示的布局
     */
    private void loadHFirstImageLayout() {
        FoldImageViewLayout relativeLayout = findViewById(R.id.h_first_rel);
        relativeLayout.setList(datas);
    }
    
    
  <com.yw.customimageview.FoldImageViewLayout
            android:id="@+id/h_first_rel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:defaultIcon="@drawable/girl"
            app:imageWidth="100dp"
            app:isFirstShow="true"
            app:isHLayout="true"
            app:margin="80dp"
            tools:ignore="MissingConstraints">



![测试结果](https://github.com/ywtony/circleimageview/blob/master/app/src/main/demo_image.jpeg)
  
  


