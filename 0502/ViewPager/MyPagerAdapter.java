package kr.co.company.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {
    private final Context context;
    private final int[] images;
    private final String[] titles;
    private final LayoutInflater inflater;

    public MyPagerAdapter(Context context, int[] images, String[] titles) {
        this.context = context;
        this.images = images;
        this.titles = titles;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item, container, false);

        ImageView iv = view.findViewById(R.id.imageView);
        TextView tv = view.findViewById(R.id.textView);

        iv.setImageResource(images[position]);
        tv.setText(titles[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
