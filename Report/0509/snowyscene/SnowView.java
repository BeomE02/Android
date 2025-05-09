package com.example.snowyscene;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class SnowView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Thread thread;
    private boolean running = false;
    private ArrayList<Snowflake> snowflakes;
    private Bitmap background;
    private int snowflakeCount = 100;
    private float width, height;

    public SnowView(Context context) {
        super(context);
    }

    public SnowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.snow);
        snowflakes = new ArrayList<>();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        width = getWidth();
        height = getHeight();
        background = Bitmap.createScaledBitmap(background, (int) width, (int) height, false);

        for (int i = 0; i < snowflakeCount; i++) {
            float x = (float)(Math.random() * width);
            float y = (float)(Math.random() * height);
            float radius = (float)(Math.random() * 10 + 5);
            float speed = (float)(Math.random() * 5 + 2);
            snowflakes.add(new Snowflake(x, y, radius, speed));
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = null;
            try {
                canvas = getHolder().lockCanvas();
                if (canvas == null) continue;

                synchronized (getHolder()) {
                    drawScene(canvas);
                }

                Thread.sleep(16); // ~60fps
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    getHolder().unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    private void drawScene(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);
        Paint paint = new Paint();
        paint.setARGB(255, 255, 255, 255); // 하얀색 눈

        for (Snowflake snow : snowflakes) {
            canvas.drawCircle(snow.x, snow.y, snow.radius, paint);
            snow.update(height);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
}
