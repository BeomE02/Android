
# 🧮 사칙연산 계산기 앱 (Basic Calculator App)

이 Android 애플리케이션은 두 개의 숫자를 입력받아 버튼 클릭으로 사칙연산(+, -, ×, ÷)을 수행하고 결과를 표시하는 **기초 계산기 앱**입니다.

---

## 🧩 주요 기능

- 덧셈, 뺄셈, 곱셈, 나눗셈 기능 지원  
- 나눗셈에서 0으로 나누는 경우 예외 처리  
- 실시간 결과 출력

---

## 📁 프로젝트 구조

```
📁 com.example.calculator
├── MainActivity.java               // 연산 로직 및 UI 이벤트 처리
└── res/layout/activity_main.xml   // EditText 2개, Button 4개, TextView 1개 구성
```

---

## 💡 코드 요약

```java
double result;
switch (operator) {
    case '+': result = num1 + num2; break;
    case '-': result = num1 - num2; break;
    case '*': result = num1 * num2; break;
    case '/': 
        if (num2 == 0) { ... } 
        else result = num1 / num2;
}
textViewResult.setText("결과: " + result);
```

---

## 🖼️ 화면 구성

- `EditText`: 숫자 2개 입력 필드  
- `Button`: +, -, ×, ÷  
- `TextView`: 결과 출력

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 숫자 입력 → 연산 버튼 클릭  
3. 결과가 하단에 바로 출력됨

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
