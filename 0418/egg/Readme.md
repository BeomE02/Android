# ⏲️ 계란 타이머 앱 (Egg Timer with Notification)

이 Android 애플리케이션은 사용자가 설정한 초 단위 시간으로 타이머를 시작하고, 완료 시 알림(Notification)을 발생시키는 **계란 삶기용 타이머 앱**입니다.

---

## 🧩 주요 기능

- 입력 필드를 통한 시간 설정 (초 단위)  
- "시간 추가" 버튼으로 +60초 간편 추가  
- 카운트다운 타이머 시작  
- 타이머 종료 시 알림 전송 (소리 포함)

---

## 🔔 알림 기능

- Android 13 이상: POST_NOTIFICATIONS 권한 요청  
- 알림 채널 생성 (`IMPORTANCE_HIGH`)  
- 알람 사운드 설정 (`RingtoneManager.TYPE_ALARM`)  
- 클릭 시 앱 재실행 (`PendingIntent` 사용)

---

## 📁 프로젝트 구조

```
📁 com.example.egg
├── MainActivity.java               // 타이머 로직 및 알림 기능 포함
├── res/layout/activity_main.xml
└── res/drawable/ic_launcher_background.png  // 알림 아이콘
```

---

## 💡 코드 요약

### ▶ 시간 추가 / 시작

```java
sec += 60;
new CountDownTimer(millis, 1000) { ... }.start();
```

### ▶ 알림 생성

```java
NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
    .setContentTitle("Egg Timer")
    .setContentText("계란 삶기가 완료되었습니다!")
    .setSound(alarmSound)
    .setPriority(NotificationCompat.PRIORITY_HIGH);
```

---

## 🖼️ 화면 구성

- `EditText`: 초 단위 시간 입력  
- `Button`: "시간 추가", "시작"  
- 알림 발생 후 자동 닫힘 + 소리 포함

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기  
2. Android 13+ 기기에서는 알림 권한 승인 필요  
3. 시간 입력 → 시작 → 타이머 종료 시 알림 확인

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- Android 13 대응 (`POST_NOTIFICATIONS` 권한)

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
