# 🎨 Android 그림판 앱 (Paint App)

이 앱은 Android Studio와 Java를 사용하여 직접 구현한 그림판 앱입니다.  
기본 드로잉 기능뿐만 아니라 **색상 변경**, **굵기 조절**, **되돌리기(Undo)**, **저장 기능**까지 포함되어 있으며,  
실제 개발 과정을 통해 안드로이드 커스텀 뷰, Canvas, 터치 이벤트 처리 등에 대한 깊은 이해를 기반으로 설계되었습니다.

---

## 📌 개발 배경 및 의도

이 앱은 **학습용 드로잉 앱**으로 시작되었으며, 다음 목표를 달성하고자 하였습니다:

- 안드로이드 커스텀 View(Canvas, Paint, Path 등)에 대한 실전 구현 연습
- 사용자가 직접 터치 이벤트를 통해 선을 그리고, 이를 저장하거나 되돌릴 수 있는 기능을 구성
- 기초 기능에서 출발해 점진적으로 고급 기능(Redo, 이미지 불러오기 등)까지 확장 가능한 구조 설계

---

## 💬 개발 과정 요약

### 🎯 1. 기능 구상 및 목표 설정
- 초기 대화에서 사용자는 "그림판을 만들고 싶다", "색상 변경, 굵기 변경, 지우기 기능을 꼭 넣고 싶다"고 요청함
- 추가로 **Pixel 2 에뮬레이터에서 테스트하고 Java로 구현**하는 것을 확정함

### 🧩 2. 구조 설계
- 기능별 클래스를 분리하여 `MainActivity.java`, `PaintView.java`, `activity_main.xml`의 구조로 설계
- `PaintView`에서 터치 기반 드로잉 처리 (`Path` + `Paint`를 List로 저장하여 복수 선을 구현)

### ⚠️ 3. 되돌리기 문제 해결 과정
- 초기 `undo()`는 동작은 했지만 **그리고 있는 도중의 선이 지워지지 않음**
- 문제 원인을 분석하여 `ACTION_UP` 시점에서만 `Path`를 저장하도록 변경 → 즉각 반응하도록 수정 완료

### 💾 4. 저장 기능 구현
- 현재 화면을 `Bitmap`으로 변환하고, Android MediaStore를 통해 갤러리에 저장하는 로직 구현
- 저장 후 사용자에게 `Toast`로 피드백 제공

---

## 📁 프로젝트 구조

```
app/
├── java/com/example/paintapp/
│   ├── MainActivity.java       # 메인 Activity, UI 버튼 처리 및 이벤트 연결
│   ├── PaintView.java          # 커스텀 View, 터치 기반 드로잉 로직
├── res/layout/
│   └── activity_main.xml       # 버튼 및 SeekBar 배치, PaintView 포함
```

---

## ✅ 주요 기능

| 기능명     | 설명 |
|------------|------|
| ✍️ 드로잉 | 손가락으로 자유롭게 그림 |
| 🎨 색상 변경 | 다이얼로그로 색상 선택 및 적용 |
| 📏 굵기 조절 | SeekBar로 선 굵기 실시간 변경 |
| 🧼 전체 지우기 | 캔버스를 초기화하여 모든 선 제거 |
| ↩️ 되돌리기 | 가장 최근의 Path 삭제 (즉시 반응) |
| 💾 이미지 저장 | 현재 화면을 이미지로 저장 후 갤러리에 등록 |

---

## 🛠 사용 기술

- **언어**: Java
- **툴**: Android Studio Arctic Fox 이상
- **UI 구성**: LinearLayout 기반 툴바 + 커스텀 View
- **SDK 최소 버전**: API 21 (Android 5.0 Lollipop)
- **실행 환경**: Pixel 2 (AVD)

---

## 🧠 핵심 구현 코드 예시

### 📌 PaintView 드로잉 처리

```java
@Override
public boolean onTouchEvent(MotionEvent event) {
    float x = event.getX();
    float y = event.getY();

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            currentPath.reset();
            currentPath.moveTo(x, y);
            break;

        case MotionEvent.ACTION_MOVE:
            currentPath.lineTo(x, y);
            break;

        case MotionEvent.ACTION_UP:
            paths.add(new Path(currentPath));
            paints.add(new Paint(paint));
            currentPath.reset();
            break;
    }

    invalidate();
    return true;
}
```

### 📌 저장 기능

```java
Bitmap bitmap = paintView.getBitmap();
MediaStore.Images.Media.insertImage(
    getContentResolver(),
    bitmap,
    "PaintApp_" + System.currentTimeMillis(),
    "그림판 앱으로 저장됨"
);
```

---

## 📱 UI 구성 요약

- **상단 툴바**: 색상 / 지우기 / 되돌리기 / 저장 버튼 + 굵기 조절 SeekBar
- **하단 영역**: Canvas 기반 커스텀 View(PaintView)

---

## 🔮 향후 확장 계획

- 다시 실행(Redo)
- 다양한 브러시 (예: 점선, 형광펜)
- PNG 저장 및 공유
- 배경 이미지 불러오기
- 드로잉 레이어 기능 추가
- 갤러리 열기 및 불러오기
- Material Design 기반 UI 리디자인

---

## 👤 개발자 정보

- **개발자**: 하재범
- **역할**: 기획, 개발, 테스트 전 과정 주도
- **목표**: 기능 완성도 높은 드로잉 앱 → 포트폴리오용으로 확장 가능

---

## 🗂 라이선스

본 프로젝트는 [MIT 라이선스](https://opensource.org/licenses/MIT)를 따릅니다.

---

