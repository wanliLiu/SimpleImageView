
SimpleImageView
--------------

Simpleimageview contains circleImageview,RecImageView,SquareImageview,all of this just set attr.

![](https://github.com/wanliLiu/SimpleImageView/raw/master/images/dem0.png)


you want to dipslay circleImageView,just xml like this:

    <com.soli.simpleimageview.library.SimpleImageView
        android:layout_width="50dp"
        android:layout_height="wrap_content"
        android:layout_marginRight="10dp"
        android:scaleType="centerCrop"
        android:src="@mipmap/girl"
        app:isCycle="true" />

circleimageview size define by width.

RectRoundImageview

     <com.soli.simpleimageview.library.SimpleImageView
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_marginRight="10dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            app:heightPercent="1.4"
            app:radius="15dp" />
            
SquareRoundImageview
   
    <com.soli.simpleimageview.library.SimpleImageView
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:scaleType="centerCrop"
            android:src="@mipmap/girl"
            app:isSquare="true"
            app:radius="15dp" />
            
SquareImageView

    <com.soli.simpleimageview.library.SimpleImageView
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:scaleType="centerCrop"
        android:src="@mipmap/girl"
        app:isSquare="true"
        app:radius="0dp" />
        
        
