# ✅ 할 일 체크리스트 앱 (Simple Checklist with ListView)

이 Android 애플리케이션은 사용자가 입력한 할 일을 리스트에 추가하고 **체크박스 형식으로 선택**할 수 있는 간단한 체크리스트 앱입니다.

---

## 🧩 주요 기능

- 텍스트 입력 후 버튼 클릭 → 항목 추가  
- `ListView`에 체크박스 형식(`CHOICE_MODE_MULTIPLE`)으로 표시  
- 빈 값은 무시, 입력 후 자동 초기화

---

## 📁 프로젝트 구조

```
📁 com.example.calculator1
├── MainActivity.java             // 체크리스트 로직
└── res/layout/activity_main.xml // EditText + Button + ListView UI 구성
```

---

## 💡 핵심 코드

```java
adapter = new ArrayAdapter<>(
    this,
    android.R.layout.simple_list_item_multiple_choice,
    tasks
);
listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
```

👉 `ArrayAdapter`를 통해 다중 선택 가능한 `ListView` 구성  
👉 `notifyDataSetChanged()`로 실시간 업데이트

---

## 🖼️ UI 구성

- `EditText`: 할 일 입력  
- `Button`: 추가 버튼  
- `ListView`: 다중 선택이 가능한 체크리스트 형식

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 앱 실행 → 할 일 입력 → 버튼 클릭  
3. 항목이 리스트에 추가되고 체크 가능

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- 위젯: ListView + ArrayAdapter + CHOICE_MODE_MULTIPLE

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
