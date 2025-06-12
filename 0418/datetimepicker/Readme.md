# 📅 날짜 및 시간 선택 앱 (DateTime Picker Example)

이 Android 애플리케이션은 버튼 클릭 시 **날짜 선택기(DatePickerDialog)**와 **시간 선택기(TimePickerDialog)**를 실행하고, 선택 결과를 화면에 출력하는 간단한 예제입니다.

---

## 🧩 주요 기능

- 날짜 선택 버튼 → DatePickerDialog 표시  
- 시간 선택 버튼 → TimePickerDialog 표시  
- 선택된 날짜/시간을 TextView에 표시

---

## 📁 프로젝트 구조

```
📁 com.example.datetimepicker
├── MainActivity.java           // 날짜/시간 다이얼로그 구현
├── res/layout/activity_main.xml
```

---

## 💡 코드 요약

### ▶ 날짜 선택

```java
new DatePickerDialog(this, (view, y, m, d) -> {
    txtDate.setText(String.format("선택된 날짜: %d-%d-%d", y, m + 1, d));
}, year, month, day).show();
```

### ▶ 시간 선택

```java
new TimePickerDialog(this, (view, h, m) -> {
    txtTime.setText(String.format("선택된 시간: %02d:%02d", h, m));
}, hour, minute, true).show();
```

👉 현재 시간 기준으로 다이얼로그 기본값 설정  
👉 `Calendar` 클래스 활용

---

## 🖼️ 화면 구성

- `Button` 2개: 날짜 선택 / 시간 선택  
- `TextView` 2개: 선택된 날짜 / 시간 표시

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 에뮬레이터 또는 실제 기기에서 실행  
3. 날짜/시간 선택 버튼 클릭 → 다이얼로그 → 값 선택 후 화면 출력 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
