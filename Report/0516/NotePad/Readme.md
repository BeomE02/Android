# 📒 Notepad 앱

Android로 구현된 간단한 메모장 앱입니다. 사용자가 작성한 메모를 내부 저장소에 저장하고, 앱 재실행 시 다시 불러올 수 있도록 구성되어 있습니다.

## 💡 주요 기능

- 텍스트 메모 작성 및 수정
- 메모 **저장** / **불러오기** 기능
- 앱 시작 시 자동으로 마지막 메모 로드
- EditText에 자동 포커스 및 커서 위치 지정

## 📁 저장 방식

- 파일 이름: `note.txt`
- 저장 위치: 앱 전용 내부 저장소 (`Context.MODE_PRIVATE`)

## 🔧 주요 클래스 및 메서드

### `MainActivity`

#### `saveNote()`
- 사용자가 작성한 텍스트를 내부 저장소 파일 `note.txt`에 저장

#### `loadNote()`
- `note.txt` 파일 내용을 읽어 `EditText`에 표시

#### `onResume()`
- 액티비티가 다시 보여질 때 EditText에 자동 포커스

#### `ViewTreeObserver.OnGlobalLayoutListener`
- 화면이 완전히 로드된 후 EditText에 포커스 및 커서 위치 설정

## 🛠 향후 개선 가능성

- 메모 자동 저장 (예: `onPause()` 활용)
- 메모 다중 저장 (파일 이름 동적 지정)
- 다크모드 대응, 텍스트 스타일 변경 기능

---

### ✅ 개발 환경

- 언어: Java
- 개발 도구: Android Studio
- 최소 SDK: API 21+
