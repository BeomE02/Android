# 📝 SQLite 기반 할 일 관리 앱 (To-Do List with DB)

이 Android 앱은 SQLite를 활용해 사용자가 입력한 할 일(Task)을 저장, 표시, 삭제할 수 있는 기능을 갖춘 **간단한 할 일 관리 앱**입니다. RecyclerView와 DB를 연동하여 지속적인 데이터 관리가 가능합니다.

---

## 🧩 주요 기능

- 할 일 입력 및 등록  
- RecyclerView를 통한 실시간 목록 표시  
- 완료 시 체크 후 애니메이션 → DB에서 자동 삭제  
- SQLite DB를 이용한 영구 저장

---

## 📁 프로젝트 구조

```
📁 com.example.todo2
├── MainActivity.java             // 앱 UI 및 로직 담당
├── TaskDBHelper.java             // SQLite DB 관리 클래스
├── res/layout/activity_main.xml
└── res/layout/task_item.xml      // 할 일 항목 레이아웃
```

---

## 💡 핵심 로직 요약

### ▶ SQLite 테이블 생성

```java
CREATE TABLE tasks (
    _id INTEGER PRIMARY KEY AUTOINCREMENT,
    task_text TEXT NOT NULL,
    checked INTEGER NOT NULL DEFAULT 0
);
```

### ▶ 할 일 추가 및 DB 저장

```java
dbHelper.insertTask(taskText);
taskList.add(new TaskItem(taskText, false));
```

### ▶ 완료된 할 일 처리

```java
radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
    dbHelper.deleteTask(task.taskText);
    taskList.remove(position);
    notifyItemRemoved(position);
});
```

---

## 🖼️ UI 구성

- `EditText` + `ImageButton`: 할 일 입력 및 추가  
- `RecyclerView`: 전체 할 일 목록  
- 각 항목: `RadioButton` + `TextView`

---

## 🚀 실행 흐름

1. 할 일을 입력하고 버튼 클릭 → DB에 저장 및 리스트에 반영  
2. 체크 시 애니메이션 → DB에서 삭제  
3. 앱 재실행 시 DB에서 모든 할 일을 불러와 목록 재구성

---

## 🔧 개발 환경

- Android Studio Electric Eel 이상  
- minSdkVersion 21  
- Java 언어  
- SQLite (내장 DB)

---

## 👨‍💻 개발자

- **이름:** 하재범  
- **GitHub:** [BeomE02](https://github.com/BeomE02)
