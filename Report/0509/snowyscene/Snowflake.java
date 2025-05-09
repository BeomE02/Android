package com.example.snowyscene;

public class Snowflake {
    public float x, y, radius, speedY;

    public Snowflake(float x, float y, float radius, float speedY) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speedY = speedY;
    }

    public void update(float screenHeight) {
        y += speedY;
        if (y > screenHeight) {
            y = 0;
            x = (float)(Math.random() * 1080); // 예시 화면 폭
        }
    }
}
