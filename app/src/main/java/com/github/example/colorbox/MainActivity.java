package com.github.example.colorbox;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.colorbox.ColorBox;

public class MainActivity extends Activity {

    private TextView mButton1, mButton2;
    private String TAG1 = "tag1";
    private String TAG2 = "tag2";

    @Override
    public void onResume() {
        super.onResume();

        setLayoutColor();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);

        setLayoutColor();

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorBox.showColorBox(TAG1 ,MainActivity.this, ColorBox.LIGHT);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorBox.showColorBox(TAG2 ,MainActivity.this, ColorBox.DARK);
            }
        });

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment, new SettingsFragment())
                .commit();
    }

    private void setLayoutColor() {

        int color1 = ColorBox.getColor(TAG1, this);

        mButton1.setBackgroundColor(color1);
        mButton1.setText(ColorBox.getHexadecimal(color1));

        int textColor = ColorBox.isColorDark(color1)? Color.WHITE : Color.BLACK;
        mButton1.setTextColor(textColor);

        int color2 = ColorBox.getColor(TAG2, this);

        mButton2.setBackgroundColor(color2);
        mButton2.setText(ColorBox.getHexadecimal(color2));
        mButton2.setTextColor(ColorBox.getComplementaryColor(color2));
    }
}
