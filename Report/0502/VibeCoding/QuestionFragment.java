package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionFragment extends Fragment {

    private static final String ARG_INDEX = "question_index";
    private int currentIndex;
    private static List<Question> questionList;

    private static int leftBrainCount = 0;
    private static int rightBrainCount = 0;

    public QuestionFragment() {}

    public static QuestionFragment newInstance(int index) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);

        if (questionList == null) {
            questionList = new ArrayList<>();
            questionList.add(new Question("문제를 해결할 때?", "논리적으로 분석", "직관적으로 판단"));
            questionList.add(new Question("일정을 정할 때?", "계획표를 작성한다", "느낌대로 움직인다"));
            questionList.add(new Question("설명을 들을 때?", "숫자와 논리", "비유와 감정"));
            questionList.add(new Question("일 처리 방식은?", "체계적 순서", "즉흥적 감각"));
            questionList.add(new Question("그림을 보면?", "구조, 형태가 보인다", "색감, 느낌이 보인다"));
            questionList.add(new Question("좋아하는 취미는?", "퍼즐, 수학", "예술, 창작"));
            questionList.add(new Question("대화 시 집중하는 것은?", "사실/논리", "감정/표현"));
            questionList.add(new Question("새로운 일을 시작할 때?", "계획부터 세운다", "일단 시도해본다"));
            questionList.add(new Question("친구 생일은?", "미리 캘린더에 기록", "그냥 기억한다"));
            questionList.add(new Question("여행 계획은?", "경로/예산부터", "가고 싶은 곳 위주"));
        }

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);

        currentIndex = getArguments().getInt(ARG_INDEX);

        TextView tvQuestion = view.findViewById(R.id.tv_question);
        Button btnA = view.findViewById(R.id.btn_option_a);
        Button btnB = view.findViewById(R.id.btn_option_b);

        Question q = questionList.get(currentIndex);
        tvQuestion.setText(q.getText());
        btnA.setText(q.getOptionA());
        btnB.setText(q.getOptionB());

        btnA.setOnClickListener(v -> {
            leftBrainCount++;
            goToNext();
        });

        btnB.setOnClickListener(v -> {
            rightBrainCount++;
            goToNext();
        });

        return view;
    }

    private void goToNext() {
        if (currentIndex + 1 < questionList.size()) {
            QuestionFragment next = QuestionFragment.newInstance(currentIndex + 1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, next);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            ResultFragment result = ResultFragment.newInstance(leftBrainCount, rightBrainCount);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, result);
            ft.commit();
        }
    }
}
