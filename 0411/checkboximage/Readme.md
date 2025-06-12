# 🧀 체크박스 이미지 표시 앱 (Checkbox Image Toggle)

이 Android 애플리케이션은 체크박스 상태에 따라 이미지의 표시 여부를 제어하는 간단한 UI 예제입니다.

---

## 🧩 주요 기능

- 체크박스 선택 시 해당 이미지 표시  
- 체크 해제 시 이미지 숨김  
- `CheckBox`와 `ImageView` 간의 동기화 처리

---

## 📁 프로젝트 구조

```
📁 com.example.checkboximage
├── MainActivity.java           // 체크 상태에 따라 이미지 표시 여부 제어
└── res/layout/activity_main.xml   // 체크박스 2개 + 이미지 2개 구성
```

---

## 💡 코드 요약

### ▶ MainActivity.java

```java
chkMeat.setOnCheckedChangeListener((buttonView, isChecked) -> {
    imgMeat.setVisibility(isChecked ? ImageView.VISIBLE : ImageView.GONE);
});
```

👉 `CheckBox`가 체크되면 `ImageView.VISIBLE`, 해제되면 `ImageView.GONE`

---

## 🖼️ 화면 구성

- `CheckBox`: 고기, 치즈 항목 각각 제어  
- `ImageView`: 각 체크 상태에 따라 표시/숨김 처리

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `activity_main.xml`에 `chkMeat`, `chkCheese`, `imgMeat`, `imgCheese` ID 확인  
3. 실행 후 체크박스 클릭 시 이미지 표시 여부 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
