# 🧠 좌뇌형 vs 우뇌형 성향 테스트 앱 (Java + Fragment 기반)

이 프로젝트는 Android 프래그먼트를 기반으로 한 **10문항 설문조사 앱**입니다.  
바이브 코딩(Vibe Coding) 방식으로 AI와 함께 실시간으로 구조를 설계하고,  
기획부터 프래그먼트 연결, 그래프 시각화까지 **코딩 대화를 통해 하나하나 구현해낸 과정형 앱**입니다.

---

## ✨ 개발 히스토리 (AI와 함께한 협업 기록)

이 프로젝트는 단순히 코드를 작성하는 것을 넘어서,  
AI와 개발자의 **실시간 대화와 피드백, 오류 수정 과정을 거쳐 점진적으로 발전**해왔습니다.

### 🎬 1. 주제 선정

- **처음 목표**는 프래그먼트를 사용한 설문 앱 만들기
- 주제 후보로 `음식 취향`, `MBTI`, `콘텐츠 성향`, `좌뇌/우뇌` 등을 고려했고  
- 최종적으로 **‘좌뇌형 vs 우뇌형 테스트’** 주제를 선택함

> “좋아 좌뇌형 vs 우뇌형 테스트로 하자” – 사용자  
> “각 문항에 대해 좌/우뇌 성향 선택지를 주고, 누적해서 성향 분석 결과와 그래프까지 출력하자” – AI

---

### 📐 2. 프로젝트 구조 설계

- 프래그먼트 중심 앱 구조 설계
- Java 기반으로 구현
- 구성 요소:

```bash
MainActivity.java          # 프래그먼트 컨테이너
└── fragment/
    ├── StartFragment.java       # 시작 화면 – 설명 + 시작 버튼
    ├── QuestionFragment.java    # 10문항 설문 처리
    └── ResultFragment.java      # 결과 화면 – 메시지 + 그래프
└── model/
    └── Question.java            # 질문 데이터 클래스
```

- layout 폴더에는 각 프래그먼트에 대응하는 XML 파일 생성

---

### 🧱 3. 화면 흐름

```text
MainActivity
   └─ StartFragment
         [테스트 시작 버튼 클릭]
   └─ QuestionFragment (0 ~ 9)
         [각 문항 선택 → 다음]
   └─ ResultFragment
         [결과 메시지 + 그래프 출력]
         [다시하기 버튼 → StartFragment로]
```

---

### 💻 4. 주요 구현 내역

#### ✅ `Question.java`
```java
public class Question {
    private String text, optionA, optionB;
    // getter + 생성자 구성
}
```

#### ✅ `StartFragment.java`
- “테스트 시작” 버튼 → QuestionFragment.newInstance(0) 호출

#### ✅ `QuestionFragment.java`
- 10문항 중 현재 인덱스에 맞는 질문 표시
- 버튼 클릭 시 좌뇌/우뇌 카운터 증가
- 마지막 질문 후 ResultFragment로 이동

#### ✅ `ResultFragment.java`
- 전달받은 좌/우뇌 점수 비교
- 결과 메시지 출력
- MPAndroidChart 라이브러리로 **BarChart 시각화**

---

### 🧪 5. 오류 및 디버깅 히스토리

- `R.color.purple_500` 오류 → colors.xml 누락 원인 발견
- 해결책: `ContextCompat.getColor()` 또는 **`Color.RED`, `Color.BLUE` 기본 색상 대체**
- JitPack 의존성 오류 발생 → `settings.gradle.kts`에 `maven("https://jitpack.io")` 추가

> “에러 떠” → “colors.xml 없어! 기본 색으로 바꿔줄게!” → “완성형 코드 다시 줄게”  
> 이런 식으로 **코딩 바이브 안에서 실시간 대응하며 점진적으로 완성**

---

## 🎨 그래프 구현 (MPAndroidChart)

- 라이브러리: [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
- 적용 방식:
```gradle
// build.gradle.kts
implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

// settings.gradle.kts
maven(url = "https://jitpack.io")
```

- `fragment_result.xml`에 `<BarChart />` 추가
- 자바 코드에서 값 입력, 색상 지정, x축 라벨 설정
- 색상은 단순하게 `Color.RED`, `Color.BLUE` 사용

---

## 📋 예시 질문 (10문항)

1. 문제를 해결할 때? – 논리적으로 분석 / 직관적으로 판단  
2. 일정을 정할 때? – 계획표 작성 / 감으로  
3. 설명을 들을 때? – 숫자와 논리 / 감정과 표현  
4. 취미는? – 퍼즐 / 그림  
5. 친구 생일은? – 미리 기록 / 대충 기억  
6. 여행 계획은? – 예산 중심 / 느낌 중심  
7. 설명 스타일은? – 구체적 / 비유적  
8. 감정 표현은? – 억제 / 표현  
9. 대화에서 집중하는 것은? – 내용 / 분위기  
10. 선택의 기준은? – 분석 / 직감

---

## ✅ 실행 방법

1. Android Studio에서 프로젝트 열기
2. `MainActivity` 실행
3. 앱 시작 → 질문 선택 → 결과 확인 → 그래프로 성향 시각화

---

## 📦 추가 기능 아이디어 (확장 가능)

- 성향 결과를 공유하기 (Intent + SNS)
- Firebase에 선택 기록 저장
- 결과에 따른 추천 콘텐츠 제공
- 타이머 기능 추가해 성향 변화 체크

---

## 🧑‍💻 개발 방식 요약

이 앱은 전통적인 설계 방식이 아니라,  
**실시간 AI 코딩 파트너와의 협업**을 통해  
문제 발생 → 해결 → 코드 수정 → 구조 확장 과정을 거쳐  
코드의 흐름과 이유까지 파악하며 만들어진 **실전형 프로젝트**입니다.

---
