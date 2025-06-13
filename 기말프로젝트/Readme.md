# GeoKit 📍

> **내 장소를 기록하고 관리하는 스마트한 위치 기반 안드로이드 앱**

GeoKit은 사용자가 중요한 장소들을 쉽게 기록하고 관리할 수 있게 도와주는 안드로이드 애플리케이션입니다. Google Maps API를 활용하여 직관적인 지도 인터페이스와 강력한 검색 기능을 제공합니다.

![GeoKit Logo](https://img.shields.io/badge/GeoKit-v1.0-blue?style=for-the-badge&logo=android)

## ✨ 주요 기능

### 🗺️ **지도 기반 위치 관리**
- **실시간 지도 표시**: Google Maps SDK를 활용한 고해상도 지도
- **현재 위치 자동 감지**: GPS를 통한 정확한 현재 위치 표시
- **직관적인 마커 시스템**: 터치 한 번으로 장소 저장

### 🔍 **똑똑한 검색 시스템**
- **통합 검색**: 저장된 장소 + Google Places API 검색
- **실시간 검색 결과**: 전 세계 모든 장소 검색 가능
- **검색 결과 미리보기**: 임시 마커로 위치 확인 후 저장 결정

### 📋 **세련된 장소 관리**
- **상세 장소 리스트**: 카드 형태의 아름다운 UI
- **지도 썸네일**: 각 장소의 위치를 시각적으로 표시
- **통계 정보**: 전체/이번달/이번주 저장 장소 현황
- **원터치 이동**: 리스트에서 클릭하면 해당 위치로 즉시 이동

### ⚡ **사용자 경험 최적화**
- **스플래시 스크린**: 브랜드 정체성이 담긴 로딩 화면
- **영구 저장**: SharedPreferences를 통한 데이터 보존
- **머티리얼 디자인**: 안드로이드 디자인 가이드라인 준수
- **직관적 UI/UX**: 누구나 쉽게 사용할 수 있는 인터페이스

## 🚀 시작하기

### 📋 필수 요구사항

- **Android SDK**: API Level 24 (Android 7.0) 이상
- **개발 환경**: Android Studio 4.0+
- **Google Play Services**: Maps 및 Location 서비스
- **권한**: 위치 권한 (정밀한 위치)

### 🔧 설치 및 설정

1. **저장소 클론**
   ```bash
   git clone https://github.com/yourusername/GeoKit.git
   cd GeoKit
   ```

2. **Google Maps API 키 설정**
   - [Google Cloud Console](https://console.cloud.google.com)에서 새 프로젝트 생성
   - Maps SDK for Android 및 Places API 활성화
   - API 키 생성 및 애플리케이션 제한 설정
   - `AndroidManifest.xml`에서 API 키 교체:
   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="YOUR_API_KEY_HERE" />
   ```

3. **의존성 설치**
   ```gradle
   // app/build.gradle에 이미 포함된 의존성들
   implementation 'com.google.android.gms:play-services-maps:18.2.0'
   implementation 'com.google.android.gms:play-services-location:21.0.1'
   implementation 'com.google.android.libraries.places:places:3.3.0'
   ```

4. **프로젝트 빌드**
   ```bash
   ./gradlew build
   ```

## 📱 사용법

### 1️⃣ **장소 저장하기**
- 앱 실행 후 원하는 위치로 이동
- 화면 하단의 **+ 버튼** 터치
- 장소 이름 입력 후 **"추가"** 버튼 클릭
- 하늘색 마커로 장소 저장 완료

### 2️⃣ **장소 검색하기**
- 상단 검색창에 장소명 입력
- 저장된 장소가 있으면 우선 표시
- 없으면 Google Places API로 전 세계 검색
- 검색 결과는 초록색 마커로 표시

### 3️⃣ **저장된 장소 관리**
- 좌상단 **햄버거 메뉴** 터치
- 저장된 모든 장소를 카드 형태로 확인
- **"지도에서 보기"** 버튼으로 해당 위치로 이동
- **삭제 버튼**으로 불필요한 장소 제거

## 🏗️ 프로젝트 구조

```
app/src/main/
├── java/com/example/geokit/
│   ├── MainActivity.java          # 메인 지도 화면
│   ├── MarkerListActivity.java    # 장소 목록 화면
│   └── SplashActivity.java        # 스플래시 화면
├── res/
│   ├── layout/
│   │   ├── activity_main.xml      # 메인 화면 레이아웃
│   │   ├── activity_marker_list.xml  # 목록 화면 레이아웃
│   │   ├── activity_splash.xml    # 스플래시 레이아웃
│   │   ├── dialog_add_marker.xml  # 마커 추가 다이얼로그
│   │   ├── custom_info_window.xml # 마커 정보창
│   │   └── item_marker_detailed.xml # 목록 아이템
│   ├── drawable/
│   │   ├── circle_button_gray.xml
│   │   ├── dialog_background.xml
│   │   ├── gradient_background.xml
│   │   ├── info_window_background.xml
│   │   └── splash_background.xml
│   ├── values/
│   │   ├── colors.xml             # 앱 색상 테마
│   │   ├── strings.xml            # 문자열 리소스
│   │   └── themes.xml             # 앱 테마
│   └── xml/
└── AndroidManifest.xml            # 앱 설정 및 권한
```

## 🎨 디자인 시스템

### 색상 팔레트
- **Primary Blue**: `#4285F4` - 메인 브랜드 컬러
- **Dark Blue**: `#1976D2` - 강조 색상
- **Cyan**: `#00BCD4` - 마커 색상 (하늘색)
- **Light Gray**: `#F5F5F5` - 백그라운드
- **Text Hint**: `#9E9E9E` - 보조 텍스트

### UI 컴포넌트
- **Material Design 3** 가이드라인 준수
- **CardView**로 깔끔한 카드 레이아웃
- **FloatingActionButton**으로 직관적인 액션
- **TextInputLayout**으로 세련된 입력 필드

## 🔧 기술 스택

### **Frontend**
- **Language**: Java
- **UI Framework**: Android Native (Material Design)
- **Maps**: Google Maps SDK for Android
- **Location**: Google Play Services Location

### **Backend/Storage**
- **Local Storage**: SharedPreferences (JSON)
- **API Integration**: Google Places API, Geocoding API

### **Architecture**
- **Pattern**: MVC (Model-View-Controller)
- **Lifecycle**: Android Activity Lifecycle
- **Threading**: AsyncTask, Handler

## 📊 성능 최적화

- **메모리 효율성**: 마커 객체 재사용 및 적절한 해제
- **네트워크 최적화**: API 호출 최소화 및 캐싱
- **배터리 최적화**: 위치 서비스 효율적 사용
- **UI 반응성**: 백그라운드 스레드에서 무거운 작업 처리

## 🐛 알려진 이슈

- **에뮬레이터 키보드**: Android 에뮬레이터에서 키보드 표시 이슈 (실제 기기에서는 정상)
- **Google 어시스턴트**: 일부 기기에서 검색창 터치 시 Google 어시스턴트 팝업 표시
- **GPS 정확도**: 실내에서 GPS 정확도 저하 가능

## 🔄 향후 계획

### v1.1 업데이트 예정
- [ ] **카테고리 시스템**: 장소를 카테고리별로 분류
- [ ] **사진 첨부**: 각 장소에 사진 저장 기능
- [ ] **메모 기능**: 장소별 상세 메모 추가
- [ ] **내보내기/가져오기**: JSON/CSV 형태로 데이터 백업

### v1.2 업데이트 예정
- [ ] **클라우드 동기화**: Firebase를 통한 계정 간 동기화
- [ ] **공유 기능**: 저장된 장소 다른 사용자와 공유
- [ ] **다국어 지원**: 영어, 일본어, 중국어 지원
- [ ] **다크 테마**: 시스템 테마 연동

## 🤝 기여하기

GeoKit 프로젝트에 기여해주셔서 감사합니다!

1. **Fork** 이 저장소
2. **Feature branch** 생성 (`git checkout -b feature/AmazingFeature`)
3. **Commit** 변경사항 (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Pull Request** 생성

### 기여 가이드라인
- 코드 스타일: Google Java Style Guide 준수
- 커밋 메시지: 명확하고 설명적인 메시지 작성
- 테스트: 새로운 기능에 대한 테스트 코드 포함
- 문서화: README 및 코드 주석 업데이트

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

```
MIT License

Copyright (c) 2025 GeoKit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

## 📞 연락처

프로젝트 관련 문의사항이나 버그 리포트는 아래 방법으로 연락해주세요:

- **Email**: jq5511@naver.com

## 🙏 감사의 말

이 프로젝트는 다음 오픈소스 프로젝트들의 도움을 받았습니다:

- [Google Maps Platform](https://developers.google.com/maps) - 지도 및 위치 서비스
- [Material Design](https://material.io/) - UI/UX 디자인 가이드라인
- [Android Open Source Project](https://source.android.com/) - 안드로이드 플랫폼

---

**⭐ 이 프로젝트가 도움이 되었다면 Star를 눌러주세요! ⭐**

Made with ❤️ by BeomE
