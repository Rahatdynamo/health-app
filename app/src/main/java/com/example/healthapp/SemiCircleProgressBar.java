package com.example.healthapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class SemiCircleProgressBar extends View {

    private Paint backgroundPaint;
    private Paint progressPaint;
    private Paint textPaint;
    private RectF rectF;
    private float progress = 0;

    public SemiCircleProgressBar(Context context) {
        super(context);
        init();
    }

    public SemiCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.parseColor("#AEACAC"));
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(30);

        progressPaint = new Paint();
        progressPaint.setColor(Color.parseColor("#FCB000"));


        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(35);

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(75);
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setTextAlign(Paint.Align.CENTER);

        rectF = new RectF();
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();


        rectF.set(20, 20, width - 10, height * 2 - 10);


        canvas.drawArc(rectF, 180, 180, false, backgroundPaint);


        float angle = 180 * (progress / 100f);
        canvas.drawArc(rectF, 180, angle, false, progressPaint);


        String progressText = String.valueOf((int) progress) + "%";
        canvas.drawText(progressText, width / 2f, height - 20, textPaint);
    }
}
