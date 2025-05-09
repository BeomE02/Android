# 📋 하루 단위 To-Do 리스트 앱 (Java + Room + Android)

이 프로젝트는 **Java 언어**와 **Room 데이터베이스**, 그리고 **Fragment 기반 UI 구조**를 활용하여  
Android 앱 개발의 주요 기술을 폭넓게 학습하고 실전 프로젝트에 적용한 결과물입니다.  
목표는 단순한 할 일 목록 앱을 넘어서, **하루 단위로 정리되는 계획**, **사용자 친화적 UX**,  
그리고 **체계적인 코드 구조**를 모두 갖춘 완성도 높은 To-Do 리스트 앱을 만드는 것이었습니다.

---

## ✨ 주요 기능 요약

| 기능 | 설명 |
|------|------|
| ➕ 할 일 추가 | 제목, 메모, 날짜 입력 가능. `DatePickerDialog`로 미래 날짜 지정도 지원 |
| ✅ 완료 처리 | 완료 시 "정말 완료하셨나요?" 다이얼로그 → 버튼 사라지고 `"🎉 수고하셨습니다!"` 문구 전환 |
| ❌ 개별 삭제 | 각 항목 옆 "삭제" 버튼으로 개별 삭제 가능 |
| 🗑 전체 삭제 | 오늘 등록된 모든 할 일을 한 번에 삭제 가능 (다이얼로그 확인 포함) |
| 📭 빈 목록 안내 | 할 일이 없을 경우 `"오늘도 화이팅 해봅시다!"` 문구를 화면 중앙에 표시 |
| 📅 날짜 선택 기능 | 할 일을 오늘이 아닌 특정 날짜로도 등록 가능 |
| 💾 로컬 저장 | Room DB 사용으로 앱을 껐다 켜도 데이터 유지 |
| ♻️ 오늘 기준 필터링 | `timestamp` 기준으로 오늘 할 일만 표시 (자정 기준) |

---

## 🧱 전체 프로젝트 구조

이 앱은 **기능 단위로 디렉토리를 분리**하여 유지보수성과 확장성을 고려한 구조로 설계되었습니다.

```
app/
├── java/com/example/todomanager/
│   ├── MainActivity.java                  # 앱의 진입점, Fragment 전환 처리
│   ├── adapter/
│   │   └── TodoAdapter.java              # RecyclerView 항목 관리
│   ├── db/
│   │   ├── TodoDao.java                  # Room 쿼리 정의 인터페이스
│   │   └── TodoDatabase.java             # Room DB 인스턴스 정의
│   ├── fragment/
│   │   ├── AddTodoFragment.java          # 할 일 추가 화면
│   │   └── TodoListFragment.java         # 할 일 목록 + 완료/삭제 처리
│   ├── model/
│   │   └── TodoItem.java                 # 데이터 모델 클래스
│   └── util/
│       └── DateUtils.java                # 자정 시간 계산 유틸
├── res/layout/
│   ├── activity_main.xml
│   ├── fragment_add_todo.xml
│   ├── fragment_todo_list.xml
│   └── item_todo.xml
```

---

## 📱 UI 구성 흐름

### MainActivity
- 기본으로 `TodoListFragment`를 실행하고, FloatingActionButton 클릭 시 `AddTodoFragment`로 이동

### AddTodoFragment
- 제목, 내용, 날짜 선택 기능 포함
- "저장" → DB 저장 및 목록 복귀
- "취소" → 이전 화면으로 복귀

### TodoListFragment
- 오늘 날짜에 해당하는 할 일만 필터링해 보여줌
- 빈 목록일 경우 `"오늘도 화이팅 해봅시다!"` 문구 표시
- 리스트가 1개 이상이면 `"전체 삭제"` 버튼 표시
- 각 항목에는 `"완료"` 버튼과 `"삭제"` 버튼이 함께 제공

---

## 🧠 Room Entity 구조 (`TodoItem.java`)

```java
@Entity
public class TodoItem {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String content;
    public long timestamp;  // 선택한 날짜의 자정 기준 밀리초
    public boolean isDone;
    public long doneTime;   // 완료한 시간 (0이면 미완료 상태)
}
```

---

## 🛠 주요 기술 스택 및 사용 이유

| 기술 | 설명 |
|------|------|
| Java | 전체 앱을 Java로 구현하여 Android 개발 입문자도 쉽게 이해 가능 |
| Room DB | SQLite 기반 ORM 라이브러리로 데이터 영속성 및 안정성 확보 |
| RecyclerView | 동적 목록 UI 처리. 완료/삭제/축하 등 항목별 다양한 뷰 지원 |
| Fragment | 화면 분할 및 교체를 위해 사용. 단일 Activity 기반으로 전환 구현 |
| Executor | Room의 비동기 처리 (UI 스레드 차단 방지) |
| AlertDialog | 사용자 확인용 메시지 다이얼로그 |

---

## 🎯 주요 UX 고려 사항

- 할 일 완료 시 바로 사라지는 대신 `"🎉 수고하셨습니다"` 표시 → 사용자 성취감 유도
- 날짜를 직접 지정할 수 있어 미래 계획도 관리 가능
- 빈 화면이 단조롭지 않도록 격려 메시지 추가
- 실수 방지를 위한 `"정말 삭제하시겠습니까?"` 다이얼로그 기본 적용
- 버튼을 너무 많이 노출하지 않도록 조건부 표시 (`전체 삭제`, `완료`, `삭제` 등)

---

## 💡 확장 아이디어

| 기능 | 구현 아이디어 |
|------|----------------|
| 알림 기능 | AlarmManager 또는 WorkManager로 할 일 시간에 맞춰 알림 |
| 할 일 카테고리 | 라벨 추가 (Work, Study, Personal 등) |
| 통계 기능 | 일별 완료율, 주간 달성률 등을 차트로 시각화 |
| Firebase 연동 | 클라우드 동기화, 여러 기기에서 동일 목록 사용 |
| 다크 모드 | 스타일 설정 + Theme 적용으로 전환 가능 |

---

## 🧪 테스트 환경

- Android Studio Hedgehog
- Java 11 / Gradle 8.x
- Pixel 2 (API 30) AVD
- Room 2.5.2

---

## 👨‍💻 개발자 정보

- 이름: 하재범
- 역할: 전체 기획, UI 설계, DB 구조, 기능 개발 및 테스트
- 이메일: [이메일 입력]
- GitHub: [https://github.com/your-id]

---

## 🪪 라이선스

본 프로젝트는 [MIT License](https://opensource.org/licenses/MIT)를 따릅니다.  
상업적 사용, 수정, 재배포가 자유롭지만 반드시 라이선스를 명시해야 합니다.

---

이 프로젝트는 안드로이드 앱 개발의 구조적 사고와 사용자 경험 설계를 연습하고,  
기본기를 다지기 위한 최적의 예제로 만들었습니다. 다음 프로젝트에서도 더 발전된 기능과 구조를 보여줄 수 있을 것입니다.

