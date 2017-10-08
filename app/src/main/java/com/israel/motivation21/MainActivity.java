package com.israel.motivation21;

import android.content.res.ColorStateList;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.churchill, R.drawable.jefferson, R.drawable.darwin, R.drawable.fitzgerald, R.drawable.cameron};
    private int[] titles = {R.string.title_1, R.string.title_2, R.string.title_3, R.string.title_4, R.string.title_5};
    private int[] tips = {R.string.tip_1, R.string.tip_2, R.string.tip_3, R.string.tip_4, R.string.tip_5};
    private int[] phrases = { R.string.phrase_churchill, R.string.phrase_jefferson, R.string.phrase_darwin, R.string.phrase_fitzgerald, R.string.phrase_cameron};
    private int[] authors = {R.string.name_churchill, R.string.name_jefferson, R.string.name_darwin, R.string.name_fitzgerald, R.string.name_cameron};

    private RadioGroup indicator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicator = (RadioGroup) findViewById(R.id.indicator_group);

        setupIndicator();

        ViewPager vp = (ViewPager) findViewById(R.id.tips_pager);
        vp.setAdapter(new WelcomeAdapter(this, images, titles, tips, phrases, authors));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//              Log.i("ScrollPosition", Integer.toString(position));
                RadioButton selectedRadio = (RadioButton) indicator.getChildAt(position);
                selectedRadio.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupIndicator() {
        int count = images.length + 1;

        for(int i = 0; i <= count; i++)
        {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setButtonTintList(getResources().getColorStateList(R.color.semi_transparent_white));
            radioButton.setEnabled(false);
            if(i == 0) radioButton.setChecked(true);
            indicator.addView(radioButton);
        }
    }

    public void startAction(View v){
        Snackbar snack = Snackbar.make(v, "aasasf", Snackbar.LENGTH_SHORT);
        snack.show();
    }
}

