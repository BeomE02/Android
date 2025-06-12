# ➗ 사칙연산 계산기 앱 (Basic Calculator App)

이 Android 애플리케이션은 두 숫자를 입력받아 버튼 클릭으로 사칙연산(+, -, ×, ÷)을 수행하고 결과를 보여주는 간단한 계산기 앱입니다.

---

## 🧩 주요 기능

- 두 개의 숫자 입력 후 사칙연산 버튼 클릭 → 결과 출력  
- 나눗셈 시 0으로 나누는 오류 처리  
- 빈 입력값에 대한 예외 처리

---

## 📁 프로젝트 구조

```
📁 com.example.calculator
├── MainActivity.java           // 계산 로직 및 UI 이벤트 처리
└── res/layout/activity_main.xml   // EditText, Button, TextView로 구성된 UI
```

---

## 💡 코드 요약

### ▶ MainActivity.java

```java
btnAdd.setOnClickListener(view -> calculate('+'));
btnSub.setOnClickListener(view -> calculate('-'));
btnMul.setOnClickListener(view -> calculate('*'));
btnDiv.setOnClickListener(view -> calculate('/'));

private void calculate(char operator) {
    // 숫자 입력 확인
    // 사칙연산 처리 및 결과 출력
}
```

👉 `calculate()` 함수에서 연산자에 따라 덧셈, 뺄셈, 곱셈, 나눗셈 수행  
👉 나눗셈에서 0 입력 시 `"0으로 나눌 수 없습니다."` 안내

---

## 🖼️ 화면 구성

- EditText 2개: 숫자 입력 필드  
- Button 4개: +, -, ×, ÷  
- TextView: 결과 출력 영역

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 에뮬레이터 또는 실제 기기에서 실행  
3. 숫자 입력 → 연산 버튼 클릭 → 결과 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
