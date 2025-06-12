# 📻 라디오 버튼 이미지 표시 앱 (RadioGroup + ImageView)

이 Android 앱은 사용자가 라디오 버튼을 선택한 뒤 버튼을 누르면 **선택된 항목에 따라 다른 이미지를 표시**하는 기능을 제공합니다.

---

## 🧩 주요 기능

- `RadioGroup`으로 항목 선택 (라디오 버튼 3개)  
- 버튼 클릭 시 선택된 항목에 따라 이미지 변경  
- 이미지 리소스는 `image0`, `image1`, `image2` 사용

---

## 📁 프로젝트 구조

```
📁 com.example.myapplication
├── MainActivity.java               // 라디오 그룹 + 이미지 표시 처리
└── res/layout/activity_main.xml    // RadioGroup + Button + ImageView
📁 res/drawable
├── image0.png
├── image1.png
└── image2.png
```

---

## 💡 핵심 코드

```java
int selectedId = radioGroup.getCheckedRadioButtonId();
if (selectedId == R.id.radio233) {
    imageView.setImageResource(R.drawable.image0);
} else if (selectedId == R.id.radio41) {
    imageView.setImageResource(R.drawable.image1);
} else if (selectedId == R.id.radio44) {
    imageView.setImageResource(R.drawable.image2);
}
```

👉 선택된 라디오 버튼의 ID를 기준으로 이미지 변경

---

## 🖼️ 화면 구성

- `RadioGroup`: 라디오 버튼 3개 (`radio233`, `radio41`, `radio44`)  
- `Button`: "이미지 보기" 등으로 활용  
- `ImageView`: 선택 결과에 따른 이미지 표시

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. drawable 폴더에 `image0`, `image1`, `image2` 이미지 준비  
3. 앱 실행 → 라디오 버튼 선택 → 버튼 클릭 → 이미지 변경 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- UI 위젯: RadioGroup, Button, ImageView

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
