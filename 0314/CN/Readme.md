# 📞 전화 걸기 앱 (Dialer App)

이 Android 애플리케이션은 버튼 클릭 시 사용자의 기본 다이얼러 앱을 열고, 지정된 전화번호를 자동으로 입력해주는 간단한 예제입니다.

---

## 🧩 주요 기능

- 전화 걸기 버튼 클릭 시 다이얼러 실행  
- 전화번호는 하드코딩된 `"01012345678"`로 자동 입력  
- **권한 요청 없음** (ACTION_DIAL 사용)

---

## 📁 프로젝트 구조

```
📁 com.example.scope
├── MainActivity.java        // 버튼 클릭 → 다이얼러 실행
└── res/layout/activity_main.xml   // 버튼 UI 구성
```

---

## 💡 코드 요약

### ▶ MainActivity.java

- `Intent intent = new Intent(Intent.ACTION_DIAL);`  
- `intent.setData(Uri.parse("tel:01012345678"));`  
- `startActivity(intent);`

👉 `ACTION_DIAL`은 다이얼러만 실행하고, 직접 전화는 걸지 않으므로 `CALL_PHONE` 권한이 **불필요**합니다.

---

## 🖼️ 화면 구성

- **activity_main.xml**  
  중앙 정렬된 버튼 1개  
  텍스트: `"전화 걸기"`

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 실제 기기 또는 에뮬레이터에서 실행  
3. **전화 걸기** 버튼을 누르면 다이얼러가 열리며 전화번호가 자동 입력됨

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
