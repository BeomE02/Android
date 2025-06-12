# 🎲 난수 생성 앱 (Random Number Generator)

이 Android 애플리케이션은 버튼 클릭 시 0부터 99 사이의 정수를 랜덤으로 생성하여 화면에 표시합니다.

---

## 🧩 주요 기능

- 버튼 클릭 → 난수 생성  
- 생성된 숫자는 TextView를 통해 실시간 표시  
- `Random.nextInt(100)` 사용으로 0~99 범위 보장

---

## 📁 프로젝트 구조

```
📁 com.example.random
├── MainActivity.java           // 난수 생성 및 UI 업데이트 로직
└── res/layout/activity_main.xml   // TextView 및 버튼 UI 구성
```

---

## 💡 코드 요약

### ▶ MainActivity.java

```java
Random random = new Random();
int randomNumber = random.nextInt(100);
textViewRandomNumber.setText("난수: " + randomNumber);
```

👉 `Random.nextInt(100)`을 통해 0 이상 100 미만 정수를 생성

---

## 🖼️ 화면 구성

- 중앙 TextView: `"난수: "` + 숫자 표시  
- 버튼 클릭 시 generateRandomNumber() 메서드 실행

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `activity_main.xml`에 버튼의 `onClick` 속성에 `generateRandomNumber` 설정  
3. 실행 후 버튼 클릭 → 난수 생성 및 표시

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
