# 🎨 색상 변경 앱 (Color Box Changer)

이 Android 애플리케이션은 버튼을 클릭하면 화면의 특정 박스(`FrameLayout`)의 배경색이 변경되는 간단한 색상 변경 앱입니다.

---

## 🧩 주요 기능

- 4개의 버튼을 통해 배경색 실시간 변경  
- `Color.RED`, `Color.GREEN`, `Color.BLUE`, `Color.YELLOW` 사용  
- 배경색만 바꾸고 레이아웃 구조는 유지

---

## 📁 프로젝트 구조

```
📁 com.example.contraintlayout
├── MainActivity.java         // 색상 변경 로직 구현
└── res/layout/activity_main.xml  // FrameLayout + 버튼 UI 구성
```

---

## 💡 코드 요약

### ▶ MainActivity.java

```java
btn1.setOnClickListener(v -> colorBox.setBackgroundColor(Color.RED));
btn2.setOnClickListener(v -> colorBox.setBackgroundColor(Color.GREEN));
btn3.setOnClickListener(v -> colorBox.setBackgroundColor(Color.BLUE));
btn4.setOnClickListener(v -> colorBox.setBackgroundColor(Color.YELLOW));
```

👉 각 버튼 클릭 시 `colorBox`의 배경색을 설정

---

## 🖼️ 화면 구성

- `FrameLayout` : 색상이 바뀌는 영역
- `Button` : 색상 선택 (빨강, 초록, 파랑, 노랑)

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 버튼과 FrameLayout의 ID가 XML과 일치하는지 확인  
3. 실행 후 버튼 클릭 → 색상 변경 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
