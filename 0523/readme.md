# 📱 Android TodoList Manager

> **완전한 기능을 갖춘 Android 할 일 관리 앱**  
> Fragment 기반 아키텍처 + Room Database + 캘린더 뷰 + 통계 기능

## 🌟 주요 기능

### 📋 **할 일 관리**
- ✅ 할 일 추가/수정/삭제
- ✅ 완료 상태 토글
- ✅ 날짜별 할 일 등록
- ✅ 당겨서 새로고침

### 📅 **캘린더 뷰**
- 🗓️ 월별 캘린더 형태로 할 일 현황 확인
- 📊 날짜별 할 일 개수 및 완료율 표시
- 🎨 완료 상태에 따른 색상 구분
- 📱 날짜 클릭으로 해당 날의 할 일 상세 보기

### 📈 **통계 화면**
- 📊 오늘/이번 주/이번 달 완료율 시각화
- 📈 진행률 바로 성취도 확인
- 💪 동기부여 메시지 제공

### 🎨 **UI/UX**
- 🌈 Material Design 적용
- 📱 3탭 하단 네비게이션
- 🔄 SwipeRefreshLayout으로 부드러운 새로고침
- 🎯 직관적인 플로팅 액션 버튼

## 📸 스크린샷

| 할 일 목록 | 캘린더 뷰 | 통계 화면 |
|-----------|----------|----------|
| 📋 | 📅 | 📊 |

## 🏗️ 아키텍처

### **설계 패턴**
- 🏛️ **Fragment 기반 아키텍처**
- 🗄️ **Repository Pattern**
- 📱 **Single Activity Multiple Fragment**
- 🔄 **Observer Pattern** (LiveData 활용 가능)

### **기술 스택**
```
📱 UI Layer
├── Fragment (TodoList, Calendar, Statistics)
├── RecyclerView + Adapter
└── Material Design Components

💼 Business Layer  
├── DateUtils (날짜 계산)
└── Data Models (TodoItem, CalendarDay)

🗃️ Data Layer
├── Room Database
├── DAO (Data Access Object)
└── SQLite
```

## 📁 프로젝트 구조

```
app/src/main/java/com/example/todomanager/
│
├── 📄 MainActivity.java                    # 메인 액티비티
│
├── 📁 fragment/                           # Fragment 클래스들
│   ├── 📄 TodoListFragment.java           # 할 일 목록
│   ├── 📄 AddTodoFragment.java            # 할 일 추가
│   ├── 📄 CalendarFragment.java           # 캘린더 메인
│   ├── 📄 DayDetailFragment.java          # 날짜 상세
│   └── 📄 StatisticsFragment.java         # 통계 화면
│
├── 📁 adapter/                            # 어댑터들
│   ├── 📄 TodoAdapter.java                # 할 일 목록 어댑터
│   └── 📄 CalendarAdapter.java            # 캘린더 어댑터
│
├── 📁 model/                              # 데이터 모델
│   ├── 📄 TodoItem.java                   # 할 일 데이터
│   └── 📄 CalendarDay.java                # 캘린더 날짜 데이터
│
├── 📁 db/                                 # 데이터베이스
│   ├── 📄 TodoDatabase.java               # Room 데이터베이스
│   └── 📄 TodoDao.java                    # DAO 인터페이스
│
└── 📁 util/                               # 유틸리티
    └── 📄 DateUtils.java                  # 날짜 관련 유틸
```

## 🚀 시작하기

### **요구사항**
- Android Studio Arctic Fox 이상
- Android API 30+ (Android 11+)
- Java 11

### **설치 및 실행**

1. **레포지토리 클론**
```bash
git clone https://github.com/BeomE02/Android.git
cd Android/0509/todoList
```

2. **Android Studio에서 프로젝트 열기**
```bash
File > Open > 프로젝트 폴더 선택
```

3. **의존성 동기화**
```bash
Tools > Android > Sync Project with Gradle Files
```

4. **앱 실행**
```bash
Run > Run 'app' (Shift + F10)
```

## 🛠️ 주요 의존성

```gradle
dependencies {
    // Core Android
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    
    // Room Database
    implementation 'androidx.room:room-runtime:2.5.2'
    annotationProcessor 'androidx.room:room-compiler:2.5.2'
    
    // UI Components
    implementation 'androidx.recyclerview:recyclerview:1.3.1'
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.fragment:fragment:1.6.2'
    
    // Java 8+ Features
    coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:2.0.4'
}
```

## 💡 핵심 기능 설명

### **1. 캘린더 뷰**
- 7x6 그리드로 한 달 전체 보기
- 각 날짜에 할 일 개수 표시 (완료/전체)
- 완료 상태별 색상 구분:
  - 🟢 초록색: 모두 완료
  - 🟠 주황색: 일부 완료
  - 🔴 빨간색: 미완료

### **2. 통계 기능**
- 오늘/이번 주/이번 달 완료율 계산
- 시각적 진행률 바 제공
- 실시간 데이터 업데이트

### **3. 데이터베이스**
```sql
CREATE TABLE TodoItem (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    content TEXT,
    timestamp INTEGER NOT NULL,
    isDone INTEGER DEFAULT 0,
    doneTime INTEGER DEFAULT 0
);
```

## 🎯 학습 포인트

이 프로젝트를 통해 학습할 수 있는 Android 개발 개념들:

- ✅ **Fragment 기반 아키텍처**
- ✅ **Room Database & DAO 패턴**
- ✅ **RecyclerView & Adapter 패턴**
- ✅ **Material Design 적용**
- ✅ **날짜/시간 처리**
- ✅ **사용자 인터랙션 처리**
- ✅ **데이터 시각화**

## 🔮 향후 개선사항

- [ ] 알림 기능 추가 (WorkManager)
- [ ] 카테고리/태그 시스템
- [ ] 클라우드 동기화 (Firebase)
- [ ] 다크 테마 지원
- [ ] 위젯 기능
- [ ] 백업/복원 기능

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.

## 👨‍💻 개발자

**BeomE02**
- GitHub: [@BeomE02](https://github.com/BeomE02)
