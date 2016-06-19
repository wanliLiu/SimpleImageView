package com.soli.simpleimageview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

/**
 * Created by soli on 6/19/16.
 */
public class WHImageView extends PorterShapeImageView {

    private boolean isSquare = false;
    private float heightPercent = 0.0f;

    public WHImageView(Context context) {
        super(context);
        init(null);
    }

    public WHImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WHImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    /**
     *
     */
    private void init(AttributeSet attrs) {

        if (attrs == null) return;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleImageView);
        if (a != null) {
            heightPercent = a.getFloat(R.styleable.SimpleImageView_heightPercent, heightPercent);
            isSquare = a.getBoolean(R.styleable.SimpleImageView_isSquare, false);
            if (isSquare) {
                heightPercent = 1.0f;
            }
        }
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (heightPercent > 0.0f) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) (width * heightPercent);
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
