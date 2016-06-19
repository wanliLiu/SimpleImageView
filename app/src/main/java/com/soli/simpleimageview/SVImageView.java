package com.soli.simpleimageview;

import android.content.Context;
import android.util.AttributeSet;

import com.github.siyamed.shapeimageview.ShaderImageView;
import com.github.siyamed.shapeimageview.shader.ShaderHelper;
import com.github.siyamed.shapeimageview.shader.SvgShader;

/**
 * Created by soli on 6/19/16.
 */
public class SVImageView extends ShaderImageView {

    public SVImageView(Context context) {
        super(context);
    }

    public SVImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SVImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.imgheart);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width * 0.4);
        setMeasuredDimension(width, height);
    }
}
