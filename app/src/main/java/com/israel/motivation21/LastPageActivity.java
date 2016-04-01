package com.israel.motivation21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LastPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_page);

        Log.v("Load","LastPageActivity -> onCreate");

        Toast.makeText(this, "bla", Toast.LENGTH_SHORT);

        Button startButton = (Button) findViewById(R.id.start_motivation_button);
        startButton.setText("tewd");
    }



}

