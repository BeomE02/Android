# 📝 메모장 앱 (Simple Notepad)

이 Android 애플리케이션은 텍스트를 입력하고 저장하거나 불러올 수 있는 간단한 메모장 앱입니다. 앱 내부 저장소를 활용해 파일에 내용을 저장/로드합니다.

---

## 🧩 주요 기능

- EditText를 통한 메모 작성  
- "저장" 버튼 클릭 시 내부 저장소에 저장 (`note.txt`)  
- "불러오기" 버튼 클릭 시 저장된 메모 자동 불러오기  
- 앱 시작 시 자동 로딩  
- EditText 포커스 및 커서 초기 위치 지정

---

## 📁 프로젝트 구조

```
📁 com.example.notepad
├── MainActivity.java               // 메모 저장/불러오기 및 UI 제어
└── res/layout/activity_main.xml    // EditText + 버튼 UI 구성
```

---

## 💡 코드 요약

### ▶ 저장 기능

```java
FileOutputStream fos = openFileOutput("note.txt", Context.MODE_PRIVATE);
fos.write(text.getBytes());
```

### ▶ 불러오기 기능

```java
BufferedReader br = new BufferedReader(new InputStreamReader(fis));
StringBuilder sb = new StringBuilder();
while ((text = br.readLine()) != null) { sb.append(text).append("\n"); }
```

👉 내부 저장소에 파일을 읽고 쓰는 방식 사용

---

## 🖼️ 화면 구성

- `EditText`: 메모 입력 필드  
- `Button`: "저장", "불러오기"  
- 첫 실행 또는 복귀 시 자동 포커스 + 커서 위치 지정

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. 앱 실행 → 텍스트 입력 → 저장 → 앱 재실행 후 불러오기 확인  
3. 저장된 내용은 `note.txt`로 내부 저장됨

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- 내부 저장소 파일 입출력 API 사용

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
