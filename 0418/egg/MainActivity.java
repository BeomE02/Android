package com.example.egg;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "egg_timer_chan";
    private static final int REQ_NOTIFY = 100;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = findViewById(R.id.edit);

        // Android 13+ 알림 권한 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{ Manifest.permission.POST_NOTIFICATIONS },
                        REQ_NOTIFY
                );
            }
        }

        createNotificationChannel();
    }

    // “시간 추가” 누르면 현재값에 60초 더하기
    public void addTime(View v) {
        String s = mEdit.getText().toString();
        int sec = 0;
        try {
            sec = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            sec = 0;
        }
        sec += 60;             // +1분
        mEdit.setText(String.valueOf(sec));
    }

    // 타이머 시작
    public void startTimer(View v) {
        String s = mEdit.getText().toString();
        int totalSec;
        try {
            totalSec = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            totalSec = 0;
        }
        long millis = totalSec * 1000L;

        new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long left) {
                mEdit.setText(String.valueOf(left / 1000));
            }
            @Override
            public void onFinish() {
                mEdit.setText("0");
                sendNotification();
            }
        }.start();
    }

    // 알림 채널 생성 (중요도 HIGH + 알람 소리)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel chan = new NotificationChannel(
                    CHANNEL_ID,
                    "Egg Timer 알림",
                    NotificationManager.IMPORTANCE_HIGH
            );
            chan.setDescription("계란 타이머 완료 시 알림");
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            AudioAttributes attrs = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            chan.setSound(alarmSound, attrs);

            NotificationManager mgr = getSystemService(NotificationManager.class);
            mgr.createNotificationChannel(chan);
        }
    }

    // 타이머 완료 후 알림 전송
    private void sendNotification() {
        // 클릭 시 메인 액티비티 재실행 (예시)
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
        );

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        NotificationCompat.Builder b = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Egg Timer")
                .setContentText("계란 삶기가 완료되었습니다!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(alarmSound)
                .setAutoCancel(true)
                .setContentIntent(pi);

        NotificationManager mgr = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(1, b.build());
    }

    // 런타임 권한 결과 처리 (Android 13+)
    @Override
    public void onRequestPermissionsResult(int req, @NonNull String[] perms, @NonNull int[] res) {
        super.onRequestPermissionsResult(req, perms, res);
        // 필요 시 여기서 권한 거부 안내 다이얼로그 띄워도 됩니다.
    }
}
