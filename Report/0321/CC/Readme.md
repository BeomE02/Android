# 🔢 카운터 앱 (Counter App)

이 Android 애플리케이션은 버튼 클릭으로 숫자를 증가 또는 감소시키는 간단한 **카운터 앱**입니다.

---

## 🧩 주요 기능

- 증가 버튼 클릭 시 숫자 +1  
- 감소 버튼 클릭 시 숫자 -1  
- `TextView`를 통해 실시간 숫자 표시

---

## 📁 프로젝트 구조

```
📁 com.example.counterapp
├── MainActivity.java             // 카운터 증가/감소 처리
└── res/layout/activity_main.xml  // TextView + 버튼 2개
```

---

## 💡 코드 요약

```java
count++;
tvCounter.setText(String.valueOf(count));

count--;
tvCounter.setText(String.valueOf(count));
```

👉 `count` 변수로 현재 값 추적  
👉 증가/감소 후 즉시 화면에 반영

---

## 🖼️ 화면 구성

- `TextView`: 현재 숫자 표시  
- `Button`: "증가", "감소" 버튼 각각 1개

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 앱 실행 후 버튼 클릭 → 숫자 변화 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- 기본 UI 구성만 사용 (레이아웃 단순)

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
