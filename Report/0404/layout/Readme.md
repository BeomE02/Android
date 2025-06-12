# 🖼️ 이미지 표시 앱 (ImageView Example)

이 Android 애플리케이션은 앱 실행 시 `ImageView`에 지정된 이미지를 동적으로 설정하여 보여주는 간단한 이미지 표시 앱입니다.

---

## 🧩 주요 기능

- `ImageView`에 코드로 이미지 설정  
- 앱 실행 시 `example_image` 리소스를 표시

---

## 📁 프로젝트 구조

```
📁 com.example.myapp
├── MainActivity.java               // 이미지 설정 로직 포함
└── res/layout/activity_main.xml    // ImageView 구성
📁 res/drawable
└── example_image.png               // 표시할 이미지 리소스
```

---

## 💡 핵심 코드

```java
imageView = findViewById(R.id.imageView);
imageView.setImageResource(R.drawable.example_image);
```

👉 `R.drawable.example_image` 리소스를 Java 코드에서 설정하여 표시

---

## 🖼️ 화면 구성

- `ImageView`: 이미지 표시용 위젯
- `example_image.png`: 앱에 포함된 이미지 파일

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `res/drawable/` 폴더에 `example_image.png` 추가  
3. 앱 실행 → 이미지가 화면에 표시됨

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- UI 요소: ImageView

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
