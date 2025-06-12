# 🧮 사칙연산 계산기 앱 (Basic Arithmetic Calculator)

이 Android 앱은 두 개의 숫자를 입력받아 **덧셈, 뺄셈, 곱셈, 나눗셈**을 수행하고 결과를 실시간으로 출력해주는 기본 계산기 앱입니다.

---

## 🧩 주요 기능

- EditText를 통해 숫자 2개 입력
- 버튼 클릭 시 선택된 연산 수행
- 결과는 TextView로 출력
- 0으로 나눌 경우 예외 메시지 출력

---

## 📁 프로젝트 구조

```
📁 com.example.calculator
├── MainActivity.java             // 연산 로직 및 UI 처리
└── res/layout/activity_main.xml // 입력창, 버튼 4개, 결과 출력 텍스트
```

---

## 💡 핵심 코드

```java
switch (operator) {
    case '+': result = num1 + num2; break;
    case '-': result = num1 - num2; break;
    case '*': result = num1 * num2; break;
    case '/':
        if (num2 == 0) {
            textViewResult.setText("0으로 나눌 수 없습니다.");
            return;
        }
        result = num1 / num2;
        break;
}
```

- 사용자 입력값이 비어 있으면 `"숫자를 입력하세요."` 출력
- 결과는 `"결과: [값]"` 형태로 표시

---

## 🖼️ UI 구성

- `EditText` 2개: 숫자 입력 필드
- `Button` 4개: +, -, ×, ÷ 연산 버튼
- `TextView`: 결과 출력

---

## 🚀 실행 방법

1. Android Studio로 프로젝트 열기
2. 앱 실행 → 숫자 입력 후 연산 버튼 클릭
3. 연산 결과를 TextView로 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상
- minSdkVersion 21
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범
- **GitHub:** [BeomE02](https://github.com/BeomE02)
