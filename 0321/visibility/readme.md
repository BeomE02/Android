
# Android UI Layout 설명

## 개요

이 프로젝트에서는 Android의 `LinearLayout`을 사용하여 기본 UI를 구성합니다. 
배경색이 설정된 레이아웃 안에 여러 개의 버튼이 배치되어 있으며, 일부 버튼은 `visibility` 속성을 사용하여 표시 여부를 조정합니다.

## XML 코드 설명

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼 1" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼 2"
        android:visibility="invisible" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼 3" />

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼 4"
        android:visibility="gone" />

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼 5" />

</LinearLayout>
```

