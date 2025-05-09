package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.myapplication.R;

public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);

        Button btnStart = view.findViewById(R.id.btn_start);
        btnStart.setOnClickListener(v -> {
            // QuestionFragment(0번 질문부터)로 이동
            QuestionFragment questionFragment = QuestionFragment.newInstance(0);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_view, questionFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}
