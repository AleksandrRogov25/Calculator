package com.example.calculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getAppTheme(R.style.MyThemeBlack));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();
        Button btn_back = findViewById(R.id.button_back);
        settingsSetOnClickListener(btn_back);
    }

        private void initThemeChooser() {
            initRadioButton(findViewById(R.id.radioButtonThemeCalculator), MyThemeBlackCodeStyle);
            initRadioButton(findViewById(R.id.radioButtonMyThemeGrey), MyThemeGreyCodeStyle);
            RadioGroup rg = findViewById(R.id.radioButtons);
            ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MyThemeBlackCodeStyle))).setChecked(true);
        }

        private void initRadioButton(View button, final int codeStyle) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAppTheme(codeStyle);
                    recreate();
                }
            });
        }
        private void settingsSetOnClickListener(Button buttonback) {
            buttonback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

}