package com.soli.simpleimageview.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by soli on 15/8/11.
 *
 * refrence this
 *
 * https://github.com/MostafaGazar/CustomShapeImageView
 * https://github.com/Pkmmte/CircularImageView
 */
public class SimpleImageView extends ImageView {

    private final RectF roundRect = new RectF();
    private final float defaultRadius = 6;
    private float radius = defaultRadius;
    private final Paint maskPaint = new Paint();
    private final Paint zonePaint = new Paint();

    private boolean isCycle = false;
    private boolean isSquare = false;
    private float heightPercent = 0.0f;

    public SimpleImageView(Context context) {
        super(context);
    }

    public SimpleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SimpleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(23)
    public SimpleImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    /**
     *
     */
    private void init(AttributeSet attrs) {
        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(Color.WHITE);
        //
//        radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, defaultRadius, getResources().getDisplayMetrics());

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleImageView);
        if (a != null) {
            radius = a.getDimension(R.styleable.SimpleImageView_radius, radius);
            heightPercent = a.getFloat(R.styleable.SimpleImageView_heightPercent, heightPercent);
            isCycle = a.getBoolean(R.styleable.SimpleImageView_isCycle, false);
            isSquare = a.getBoolean(R.styleable.SimpleImageView_isSquare, false);
            if (isCycle || isSquare) {
                heightPercent = 1.0f;
            }
        }
        a.recycle();
    }

    /**
     * @param adius
     */
    public void setRectAdius(float adius) {
        radius = adius;
        invalidate();
    }

    public void setHeightPercent(float heightPercent) {
        this.heightPercent = heightPercent;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        roundRect.set(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
        if (isCycle) {
            canvas.drawOval(roundRect, zonePaint);
        } else {
            canvas.drawRoundRect(roundRect, radius, radius, zonePaint);
        }

        canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        canvas.restore();
    }

//    @Override
//    public void draw(Canvas canvas) {
//        canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
//        if (isCycle) {
//            canvas.drawOval(roundRect, zonePaint);
//        } else {
//            canvas.drawRoundRect(roundRect, radius, radius, zonePaint);
//        }
//
//        canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
//        super.draw(canvas);
//        canvas.restore();
//    }

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
