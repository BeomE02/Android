# 🎯 숫자 맞추기 게임 앱 (Number Guessing Game)

이 Android 앱은 사용자가 1부터 100 사이의 정답 숫자를 추측하여 맞히는 **간단한 숫자 게임**입니다.  
정답보다 낮거나 높을 경우 힌트를 제공하며, 정답을 맞히면 축하 메시지를 보여줍니다.

---

## 🧩 주요 기능

- 1~100 사이 무작위 정답 생성
- 사용자 입력과 정답 비교
- 결과: `Low!!`, `High!!`, `Correct!! 🎉` 출력
- 입력 누락 시 Toast로 안내

---

## 📁 프로젝트 구조

```
📁 com.example.numberguess
├── MainActivity.java              // 정답 생성 및 게임 로직 처리
└── res/layout/activity_main.xml  // 입력창, 버튼, 결과 출력 뷰 포함
```

---

## 💡 핵심 코드

```java
answerNumber = new Random().nextInt(100) + 1;

if (guess < answerNumber)
    textResult.setText("Low!!");
else if (guess > answerNumber)
    textResult.setText("High!!");
else
    textResult.setText("Correct!! 🎉");
```

- `Random().nextInt(100) + 1` : 1~100 범위 정수 생성
- `EditText`에서 사용자 입력값 받아 비교 후 결과 출력

---

## 🖼️ UI 구성

- `EditText`: 숫자 입력 필드
- `Button`: "맞추기" 클릭 시 결과 판정
- `TextView`: 결과 출력
- `Toast`: 입력 누락 시 안내 메시지 출력

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기
2. 앱 실행 → 숫자 입력 → 버튼 클릭
3. 정답에 따라 "Low!!", "High!!", "Correct!! 🎉" 중 하나 출력

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상
- minSdkVersion 21
- Java 언어 사용

---

## 👨‍💻 개발자

- **이름:** 하재범
- **GitHub:** [BeomE02](https://github.com/BeomE02)
