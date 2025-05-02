package kr.co.company.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    // 이미지 리소스 배열
    int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
    };
    // 각 페이지에 표시할 제목 배열 (images와 길이를 맞춰주세요)
    String[] titles = {
            "나의 첫번째 IoT 포트폴리오",
            "좌석배정 시스템 포트폴리오",
            "ESG 경진대회 대상 포폴"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        // 이미지와 제목 배열을 함께 전달
        myPagerAdapter = new MyPagerAdapter(this, images, titles);
        viewPager.setAdapter(myPagerAdapter);
    }
}
