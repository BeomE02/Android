# ⭐ 별점 등록 앱 (RatingBar Example)

이 Android 애플리케이션은 사용자가 별점을 선택하고 버튼을 클릭하면 해당 별점을 텍스트로 표시하고 Toast 메시지로 알려주는 **간단한 별점 평가 앱**입니다.

---

## 🧩 주요 기능

- `RatingBar`로 별점 선택  
- 버튼 클릭 시 별점 결과 출력  
- `TextView`에 선택한 별점 표시  
- `Toast` 메시지로 사용자 피드백 제공

---

## 📁 프로젝트 구조

```
📁 com.example.scope
├── MainActivity.java               // 별점 처리 및 UI 연동
└── res/layout/activity_main.xml    // RatingBar + 버튼 + 결과 텍스트
```

---

## 💡 코드 요약

### ▶ 별점 처리

```java
float rating = ratingBar.getRating();
tvResult.setText("선택한 별점: " + rating);
Toast.makeText(this, "별점 " + rating + " 등록 완료!", Toast.LENGTH_SHORT).show();
```

👉 `getRating()`으로 현재 선택된 별점 값 확인  
👉 결과를 `TextView`와 `Toast`에 출력

---

## 🖼️ 화면 구성

- `RatingBar`: 별점 선택 (기본 5개 별)  
- `Button`: 별점 등록  
- `TextView`: "선택한 별점: X.X" 출력  
- `Toast`: "별점 X.X 등록 완료!" 안내 메시지

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 앱 실행 → 별점 선택 → 버튼 클릭  
3. 텍스트 및 Toast로 결과 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- UI 위젯: RatingBar, Button, TextView

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
