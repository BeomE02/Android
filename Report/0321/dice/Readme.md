# 🎲 주사위 앱 (Dice Roller App)

이 Android 애플리케이션은 버튼을 클릭하면 1부터 6까지의 숫자 중 무작위로 선택하여 해당하는 주사위 이미지를 화면에 보여주는 **주사위 시뮬레이터 앱**입니다.

---

## 🧩 주요 기능

- 버튼 클릭 시 주사위 굴리기 (1~6 무작위)  
- `ImageView`를 통해 해당 주사위 이미지 표시  
- `Random` 클래스를 사용한 난수 생성

---

## 📁 프로젝트 구조

```
📁 com.example.diceapp
├── MainActivity.java               // 주사위 로직 및 UI 이벤트 처리
└── res/layout/activity_main.xml   // 버튼 + 이미지뷰 구성
📁 res/drawable
├── dice_1.png
├── dice_2.png
├── dice_3.png
├── dice_4.png
├── dice_5.png
└── dice_6.png
```

---

## 💡 코드 요약

```java
int diceNumber = random.nextInt(6) + 1; // 1~6
int imageResId = getResources().getIdentifier("dice_" + diceNumber, "drawable", getPackageName());
diceImage.setImageResource(imageResId);
```

👉 `dice_1 ~ dice_6` 이름의 이미지 파일을 참조하여 주사위 결과를 동적으로 설정

---

## 🖼️ 화면 구성

- `ImageView`: 주사위 이미지 표시  
- `Button`: "주사위 굴리기" 버튼

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. `res/drawable` 폴더에 `dice_1.png ~ dice_6.png` 이미지가 있어야 함  
3. 앱 실행 → 버튼 클릭 시 주사위 이미지 변경

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- 리소스 기반 이미지 전환 처리

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
