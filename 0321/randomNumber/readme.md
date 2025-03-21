# Android 난수 생성기 앱

## 개요

이 프로젝트는 Android 앱에서 버튼을 클릭할 때마다 0~99 사이의 난수를 생성하여 화면에 표시하는 기능을 구현합니다.

## XML 코드 (레이아웃)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <!-- 난수 표시용 TextView -->
    <TextView
        android:id="@+id/textViewRandomNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="난수 : "
        android:textSize="24sp"
        android:padding="16dp"/>

    <!-- 난수 생성 버튼 -->
    <Button
        android:id="@+id/buttonGenerate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="난수 생성"
        android:onClick="generateRandomNumber"/>

</LinearLayout>
```

## Java 코드

```java
package com.example.randomnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
    }

    public void generateRandomNumber(View view) {
        // 난수 생성
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0부터 99까지의 난수 생성

        // 텍스트 뷰에 난수 표시
        textViewRandomNumber.setText("난수 : " + randomNumber);
    }
}
```

