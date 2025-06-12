# 🎞️ VideoListApp

이 앱은 안드로이드 기기의 저장소에 있는 **동영상 파일 목록을 읽어서 표시**하는 간단한 리스트 앱입니다. Android 6.0부터 Android 13까지의 권한 체계를 반영하여, 사용자의 저장소 접근 권한을 요청하고, 목록을 불러와 ListView에 출력합니다.

---

## 📱 주요 기능

- 📂 기기에 저장된 모든 동영상 파일 목록을 불러오기
- ✅ Android 6~12: `READ_EXTERNAL_STORAGE`, Android 13+: `READ_MEDIA_VIDEO` 권한 사용
- 🧾 영상 이름, 용량(읽기 쉬운 단위로 변환), 재생 시간 표시 가능
- 🔃 동영상 리스트를 `ListView`를 통해 깔끔하게 출력
- 🔔 결과에 따라 Toast 메시지 출력 (파일 없을 경우 안내 등)

---

## 📂 주요 구성

### 📁 Java 코드
```java
// 권한 체크 및 요청
if (checkPermission()) {
    loadVideoFiles();
} else {
    requestPermission();
}

// 동영상 목록 불러오기
Cursor cursor = resolver.query(uri, projection, null, null, sortOrder);
```

### 📁 XML 레이아웃 (activity_main.xml)
- `ListView` : 동영상 리스트 표시용

---

## 🔐 권한 처리

| Android 버전 | 필요 권한 |
|--------------|------------|
| Android 6~12 | `READ_EXTERNAL_STORAGE` |
| Android 13+  | `READ_MEDIA_VIDEO` |

- 앱 실행 시 권한이 없는 경우 `requestPermissions()`로 요청
- 권한이 거부되면 Toast로 안내

---

## 🛠️ 사용 기술

- Java + Android SDK
- `ContentResolver`, `MediaStore.Video.Media`
- `ArrayAdapter`, `ListView`
- Android 권한 처리 (`ContextCompat`, `ActivityCompat`)

---

## 🔍 예외 처리

- 권한이 없는 경우 → 사용자에게 요청
- 동영상이 없는 경우 → 안내 메시지 출력
- 파일 크기 및 재생 시간 없는 경우 → 기본 값 처리

---

## 🧪 실행 결과 예시

- 동영상이 있는 경우:
  > `3개의 동영상 파일을 찾았습니다.`

- 동영상이 없는 경우:
  > `저장된 동영상 파일이 없습니다.`

- 권한이 없는 경우:
  > `동영상 파일에 접근하려면 권한이 필요합니다.`

---

## 📌 주의사항

- Android 13 이상에서는 `READ_MEDIA_VIDEO` 권한을 별도로 요청해야 함
- 실제 디바이스 또는 권한 설정이 완료된 에뮬레이터에서 테스트 필요

---

## 🧑‍💻 개발자
- Made by Android Studio + Java
