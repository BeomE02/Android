# 🔄 인텐트 화면 전환 앱 (Intent Activity Switch)

이 Android 애플리케이션은 버튼 클릭 시 다른 액티비티로 전환하고, 새 화면에서 닫기 버튼으로 이전 화면으로 돌아오는 간단한 인텐트 전환 예제입니다.

---

## 🧩 주요 기능

- 첫 번째 화면에서 버튼 클릭 → 두 번째 화면으로 이동  
- 두 번째 화면에서 "닫기" 버튼 → 이전 화면으로 복귀  
- `Intent`와 `Activity.finish()` 활용

---

## 📁 프로젝트 구조

```
📁 com.example.intentex
├── MainActivity.java      // 첫 화면: 인텐트 전환 시작
├── MainActivity2.java     // 두 번째 화면: 닫기 버튼으로 종료
├── res/layout/activity_main.xml
└── res/layout/activity_main2.xml
```

---

## 💡 코드 요약

### ▶ MainActivity.java

```java
Intent intent = new Intent(MainActivity.this, MainActivity2.class);
startActivity(intent);
```

### ▶ MainActivity2.java

```java
btnClose.setOnClickListener(v -> finish());
```

👉 `startActivity()`로 새 액티비티 실행  
👉 `finish()`로 현재 액티비티 종료

---

## 🖼️ 화면 구성

- **MainActivity**: "다음 화면 열기" 버튼  
- **MainActivity2**: "닫기" 버튼

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `AndroidManifest.xml`에 두 액티비티가 등록되어 있는지 확인  
3. 첫 화면에서 버튼 클릭 → 두 번째 화면 확인 → 닫기 버튼 클릭 시 복귀

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
