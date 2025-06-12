# 🎨 옵션 메뉴 배경색 변경 앱 (Options Menu Example)

이 Android 애플리케이션은 옵션 메뉴를 통해 배경색을 변경할 수 있는 간단한 예제입니다. 메뉴는 액션바(우측 상단)로 제공되며, 선택 시 `LinearLayout`의 배경색이 바뀝니다.

---

## 🧩 주요 기능

- 액션바 메뉴(옵션 메뉴) 구성  
- 메뉴 항목 선택 시 배경색 변경  
- XML 메뉴 리소스(`mymenu.xml`) 사용

---

## 📁 프로젝트 구조

```
📁 com.example.option
├── MainActivity.java           // 옵션 메뉴 구성 및 이벤트 처리
├── res/layout/activity_main.xml
└── res/menu/mymenu.xml         // 메뉴 항목 정의 (빨강, 초록, 파랑)
```

---

## 💡 코드 요약

### ▶ 메뉴 생성

```java
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.mymenu, menu);
    return true;
}
```

### ▶ 메뉴 선택 처리

```java
if (id == R.id.blue) {
    view1.setBackgroundColor(Color.BLUE);
}
```

👉 `MenuItem`의 ID에 따라 배경색 설정

---

## 🖼️ 화면 구성

- `LinearLayout`: 앱의 주요 배경 영역  
- 액션바 메뉴: 빨강 / 초록 / 파랑 색상 변경 가능

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `res/menu/mymenu.xml`에 메뉴 구성 확인  
3. 실행 후 우측 상단 메뉴 → 색상 선택 → 배경색 변경 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
