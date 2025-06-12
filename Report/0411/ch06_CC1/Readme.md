
# 📱 코딩 챌린지 앱 (CodingChallenge)

이 앱은 사용자에게 세 가지 주요 화면을 제공합니다:

- **앱 소개 (IntroductionActivity)**
- **설정 화면 (SettingsActivity)**
- **챌린지 시작 화면 (StartActivity)**

---

## 🔧 주요 기능

| 버튼 이름     | 기능 설명                         |
|--------------|----------------------------------|
| 소개 버튼     | IntroductionActivity로 이동          |
| 설정 버튼     | SettingsActivity로 이동              |
| 시작 버튼     | StartActivity로 이동                 |

---

## 🗂️ 앱 구조

```
com.example.codingchallenge
├── MainActivity.java            // 메인 화면 - 3가지 버튼
├── IntroductionActivity.java    // 앱 소개 화면
├── SettingsActivity.java        // 설정 화면
└── StartActivity.java           // 챌린지 시작 화면
```

---

## 📌 사용 방법

1. 앱을 실행하면 메인 화면이 나타납니다.
2. 원하는 버튼(소개 / 설정 / 시작)을 클릭하여 해당 화면으로 이동합니다.

---

## 📁 리소스 구성

- 각 Activity는 `activity_*.xml` 레이아웃 파일과 연결됩니다.
- 버튼 ID:
  - `btnIntroduction`
  - `btnSettings`
  - `btnStart`
