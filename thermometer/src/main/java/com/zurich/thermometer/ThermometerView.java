package com.zurich.thermometer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ���¶ȼ�View
 *
 * @author weixinfei
 * @date 2018/2/9
 */

public class ThermometerView extends View {
    private int radius;
    private int maxLength;

    private Paint progressPaint;
    private boolean showNumber;
    private String numberText = "0��C";
    private int textSize;
    private LinearGradient linearGradient;

    private Paint textPaint;
    private boolean textBold;
    private int startColor;
    private int endColor;
    private int textColor;
    /**
     * �¶����ֵ��Ĭ��Ϊ100
     */
    private int maxValue = 100;

    {
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private Paint backgroundPaint;
    private int centerX;
    private int centerY;
    private float progressWidth;
    private int halfRadius;

    public ThermometerView(Context context) {
        this(context, null);
    }

    public ThermometerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ThermometerView);
        if (typedArray != null) {
            radius = typedArray.getDimensionPixelSize(R.styleable.ThermometerView_radius, 10);
            textSize = typedArray.getDimensionPixelSize(R.styleable.ThermometerView_textSize, 10);
            maxLength = typedArray.getDimensionPixelSize(R.styleable.ThermometerView_maxLength, 50);
            showNumber = typedArray.getBoolean(R.styleable.ThermometerView_showNumber, false);
            textBold = typedArray.getBoolean(R.styleable.ThermometerView_textBold, false);
            startColor = typedArray.getColor(R.styleable.ThermometerView_startColor, Color.parseColor("#F7C74F"));
            endColor = typedArray.getColor(R.styleable.ThermometerView_endColor, Color.parseColor("#ED2729"));
            textColor = typedArray.getColor(R.styleable.ThermometerView_textColor, Color.parseColor("#ED2729"));
            typedArray.recycle();
            centerX = radius;
            centerY = radius;
            halfRadius = radius / 2;
            linearGradient = new LinearGradient(0, 0, 100, 100, startColor, endColor, Shader.TileMode.MIRROR);
        }
    }

    /**
     * ���ý���
     * ���ֵ����{@link #setMax(int)}
     * @param progress ʵ�ʵ��¶�
     */
    public void setProgress(float progress) {
        numberText = progress + "��C";
        progressWidth = progress <= maxValue ? progress : maxValue / (float) maxValue * maxLength;
        postInvalidate();
    }

    /**
     * ���ý������ֵ
     * @param maxValue ����¶�ֵ��Ĭ��Ϊ100
     */
    public void setMax(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        backgroundPaint.setColor(Color.WHITE);
        canvas.drawCircle(centerX, centerY, radius, backgroundPaint);
        backgroundPaint.setStrokeWidth((float) (radius * 1.2));
        backgroundPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine((float) (centerX * 1.7), centerY, (float) (radius * 1.7 + maxLength), centerY, backgroundPaint);

        progressPaint.setShader(linearGradient);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint.setStrokeWidth(halfRadius);
        canvas.drawLine((float) (centerX * 1.7), centerY, (float) (radius * 1.7 + progressWidth), centerY, progressPaint);

        progressPaint.setColor(startColor);
        canvas.drawCircle(centerX, centerY, (float) (radius * 0.7), progressPaint);

        if (showNumber) {
            textPaint.setColor(textColor);
            textPaint.setTextSize(textSize);
            textPaint.setFakeBoldText(textBold);
            canvas.drawText(numberText, radius * 4 + maxLength, (float) (radius * 1.4), textPaint);
        }
    }
}
