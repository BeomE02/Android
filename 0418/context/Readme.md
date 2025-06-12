# 🎨 배경 색상 변경 앱 (Context Menu Example)

이 Android 애플리케이션은 레이아웃을 길게 누르면 컨텍스트 메뉴(Context Menu)를 표시하고, 선택한 항목에 따라 배경색을 변경하는 앱입니다.

---

## 🧩 주요 기능

- 레이아웃을 길게 누르면 색상 선택 메뉴 표시  
- 메뉴 선택에 따라 배경색 변경 (`빨강`, `초록`, `파랑`)  
- `ContextMenu` 및 `MenuInflater` 사용

---

## 📁 프로젝트 구조

```
📁 com.example.context
├── MainActivity.java           // 컨텍스트 메뉴 등록 및 배경색 변경 처리
├── res/layout/activity_main.xml
└── res/menu/context_menu.xml   // 메뉴 리소스 정의
```

---

## 💡 코드 요약

### ▶ 컨텍스트 메뉴 등록

```java
registerForContextMenu(layout);
```

### ▶ 메뉴 생성 및 항목 처리

```java
public void onCreateContextMenu(...) {
    inflater.inflate(R.menu.context_menu, menu);
}

public boolean onContextItemSelected(MenuItem item) {
    layout.setBackgroundColor(...);
}
```

👉 길게 누른 후 색상 메뉴 선택 시 해당 색상으로 배경 변경

---

## 🖼️ 화면 구성

- `ConstraintLayout`: 기본 배경 영역  
- 길게 누르면 컨텍스트 메뉴 등장  
- 메뉴 항목: 빨강 / 초록 / 파랑

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `context_menu.xml`에서 색상 항목 구성 확인  
3. 앱 실행 → 배경을 길게 눌러 컨텍스트 메뉴 → 색상 선택

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
