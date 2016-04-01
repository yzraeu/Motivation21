package com.israel.motivation21;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Israel on 23/03/2016.
 */
public class WelcomeAdapter extends PagerAdapter {

    private Context context;
    private final int pageCount = 7;
    private int[] images;
    private int[] titles;
    private int[] tips;
    private int[] phrases;
    private int[] authors;

    public WelcomeAdapter(Context context, int[] imgs, int[] titles, int[] tips, int[] phrases, int[] authors) {
        this.context = context;
        this.images = imgs;
        this.titles = titles;
        this.tips = tips;
        this.phrases = phrases;
        this.authors = authors;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("Event","instantiateItem");
        View v = null;
        if (position == 0)
            v = showWelcomePage(container);
        else if (position > 0 && position < 6)
            v = tipPage(container, position - 1);
        else if (position == 6)
            v = showFinalStep(container);

        return v;
    }

    private View showFinalStep(ViewGroup container) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.last_page, null);
        Log.i("Inflate","last_page");

        container.addView(v);

        return v;
    }

    private View tipPage(ViewGroup container, int position) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.tip_page_layout, null);
        Log.i("Inflate","tip_page_layout");

        CharSequence title = getResourceText(titles[position]);
        CharSequence tip = getResourceText(tips[position]);
        CharSequence phrase = getResourceText(phrases[position]);
        CharSequence author = getResourceText(authors[position]);

        ImageView imageView = (ImageView) v.findViewById(R.id.back_image);
        imageView.setImageResource(images[position]);

        TextView titleTextView = (TextView) v.findViewById(R.id.title_view);
        titleTextView.setText(title);

        TextView tipTextView = (TextView) v.findViewById(R.id.tip_view);
        tipTextView.setText(tip);

        TextView phraseTextView = (TextView) v.findViewById(R.id.phrase_view);
        phraseTextView.setText("\"" + phrase + "\"");

        TextView authorTextView = (TextView) v.findViewById(R.id.author_view);
        authorTextView.setText(" – " + author);

        container.addView(v);

        return v;
    }

    private View showWelcomePage(ViewGroup container) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.first_page, null);
        Log.i("Inflate","first_page");
        container.addView(v);

        return v;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

//        Log.i("Script", "Destroy car: " + (position + 1));

        container.removeView((View) object);

//        super.destroyItem(container, position, object);
    }

    private CharSequence getResourceText(int resId) {
        return context.getResources().getText(resId);
    }
}
