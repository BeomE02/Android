# Android UI Layout 설명

## 개요

이 프로젝트에서는 Android의 `LinearLayout`을 사용하여 기본 UI를 구성합니다. 
배경색이 설정된 레이아웃 안에 하나의 버튼이 배치되어 있습니다.

## XML 코드 설명

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#8BC34A">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼" />

</LinearLayout>
