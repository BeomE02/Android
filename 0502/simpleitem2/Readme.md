# 📋 SimpleAdapter 예제 앱 (Two-Line ListView)

이 Android 애플리케이션은 `SimpleAdapter`를 사용하여 **두 줄 텍스트 리스트뷰**를 구성하는 예제입니다. 각 항목은 `이름(title)`과 `설명(subtitle)`으로 구성됩니다.

---

## 🧩 주요 기능

- `ListView`에 두 줄짜리 아이템 표시 (`simple_list_item_2`)  
- `SimpleAdapter`를 이용한 Map 기반 데이터 연결  
- `title` → `text1`, `subtitle` → `text2`로 바인딩

---

## 📁 프로젝트 구조

```
📁 com.example.simpleitem2
├── MainActivity.java               // SimpleAdapter 설정 및 데이터 구성
└── res/layout/activity_main.xml   // ListView 포함 레이아웃
```

---

## 💡 코드 요약

### ▶ 데이터 생성

```java
List<Map<String, String>> data = new ArrayList<>();
addItem(data, "이순신", "조선의 명장");
```

### ▶ 어댑터 설정

```java
new SimpleAdapter(
    this,
    data,
    android.R.layout.simple_list_item_2,
    new String[] { "title", "subtitle" },
    new int[] { android.R.id.text1, android.R.id.text2 }
);
```

👉 기본 제공되는 `simple_list_item_2` 레이아웃 활용

---

## 🖼️ 화면 구성

- `ListView`: 각 항목에 두 줄(이름 + 설명) 표시  
- 예시 항목:
  - 이순신 — 조선의 명장
  - 홍길동 — 의적이자 영웅
  - 김유신 — 신라의 대장군

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `ListView` ID가 `listView`인지 확인  
3. 실행 후 목록이 두 줄 형태로 표시되는지 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- 레이아웃: `android.R.layout.simple_list_item_2`

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
