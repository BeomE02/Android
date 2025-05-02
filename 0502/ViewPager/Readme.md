# ViewPager 갤러리

Android ViewPager를 이용한 이미지 스크롤 갤러리 예제입니다.

## 기능
- 좌우 스와이프 가능한 이미지 갤러리  
- 각 이미지별 제목 표시

## 미리보기
![갤러리 스크린샷](screenshots/screenshot1.png)

## 요구 사항
- Android Studio 4.0 이상  
- AndroidX ViewPager 라이브러리  
- 최소 SDK 버전 16 (Jelly Bean) 이상

## 설치 및 실행
1. 저장소 복제:
   ```bash
   git clone https://github.com/username/ViewPagerGallery.git
   ```
2. Android Studio에서 프로젝트 열기  
3. `app/src/main/res/drawable` 폴더에 `image1.jpg`, `image2.jpg`, `image3.jpg` 등을 추가  
4. `MainActivity.java`의 `images` 배열과 `titles` 배열을 원하는 값으로 수정  
5. 앱 빌드 및 실행

## 프로젝트 구조
```
ViewPagerGallery/
├── app/
│   ├── src/main/java/kr/co/company/viewpager/
│   │   ├── MainActivity.java
│   │   └── MyPagerAdapter.java
│   └── src/main/res/layout/
│       ├── activity_main.xml
│       └── item.xml
└── README.md
```

## 코드 설명
- **MainActivity.java**: ViewPager를 초기화하고, 이미지 및 제목 배열을 어댑터에 전달하여 설정합니다.  
- **MyPagerAdapter.java**: PagerAdapter를 확장하여 `item.xml`을 인플레이트하고, 이미지와 제목을 바인딩합니다.  
- **activity_main.xml**: 전체 화면을 차지하는 ViewPager를 정의합니다.  
- **item.xml**: 각 페이지에 표시될 ImageView와 TextView 레이아웃을 정의합니다.  

## 커스터마이징
- `MainActivity.java`에서 이미지 리소스 및 제목 배열을 변경하여 원하는 내용을 표시할 수 있습니다.  
- `item.xml`을 수정하여 페이지 레이아웃을 자유롭게 변경할 수 있습니다.
