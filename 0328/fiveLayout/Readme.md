# 🔐 로그인 UI 레이아웃 비교

이 프로젝트는 **Android 로그인 화면**을 다양한 레이아웃 방식으로 구현한 예제입니다. 각 레이아웃의 특징을 비교하여 UI 구성 방법을 학습할 수 있습니다.

---

## 📦 포함된 레이아웃

| 레이아웃 방식       | 설명 |
|-------------------|------|
| **ConstraintLayout** | 제약 기반의 최신 표준 레이아웃, 반응형 UI 구성에 적합 |
| **GridLayout**       | 표 형태의 정렬, 간단한 행/열 배치에 적합 |
| **LinearLayout**     | 수직 또는 수평 방향으로 순차 배치, 가장 단순함 |
| **RelativeLayout**   | 뷰 간 상대 위치 설정, 유연한 배치 가능 |
| **TableLayout**      | 행과 열 기반 구성, 전통적인 폼 형태 표현 가능 |

---

## 🖥️ 공통 UI 구성

- `ImageView` : 앱 로고 이미지 (`img_company`)
- `EditText` : 아이디, 패스워드 입력 필드
- `Button` : 로그인, 회원가입 버튼
- `TextView` : 안내 메시지 또는 입력 결과 표시

---

## 📁 파일 구성 예시

```
📁 res/layout
├── activity_login_constraint.xml
├── activity_login_grid.xml
├── activity_login_linear.xml
├── activity_login_relative.xml
└── activity_login_table.xml
```

---

## 🔍 레이아웃 선택 가이드

| 목적                           | 추천 레이아웃       |
|--------------------------------|----------------------|
| 반응형 UI / 다양한 해상도 대응      | ConstraintLayout     |
| 단순한 폼 입력 UI 구성             | LinearLayout / TableLayout |
| 요소 간 상대 배치가 필요한 경우     | RelativeLayout       |
| 열 정렬 기반의 균등 배치 필요       | GridLayout           |

---

## 🛠️ 개발 환경

- Android Studio Electric Eel 이상  
- `minSdkVersion 21`  
- Java 또는 Kotlin 지원

---

## 👨‍💻 개발자

- **이름**: 하재범  
- **GitHub**: [BeomE02](https://github.com/BeomE02)
