package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Boolean isNull = true;
    private String operator = "";
    private String number;
    private String tv0tag = "tv0tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    public void initView() {
        result = findViewById(R.id.result);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_clear = findViewById(R.id.btn_clear);
        Button btn_plus_minus = findViewById(R.id.btn_plus_minus);
        Button btn_percentage = findViewById(R.id.btn_percentage);
        Button btn_divide = findViewById(R.id.btn_divide);
        Button btn_multiply = findViewById(R.id.btn_multiply);
        Button btn_subtract = findViewById(R.id.btn_subtract);
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_dot = findViewById(R.id.btn_dot);
        Button btn_equal = findViewById(R.id.btn_equal);


        buttonSetOnClickListener(btn_1);
        buttonSetOnClickListener(btn_2);
        buttonSetOnClickListener(btn_3);
        buttonSetOnClickListener(btn_4);
        buttonSetOnClickListener(btn_5);
        buttonSetOnClickListener(btn_6);
        buttonSetOnClickListener(btn_7);
        buttonSetOnClickListener(btn_8);
        buttonSetOnClickListener(btn_9);
        buttonSetOnClickListener(btn_0);
        clearSetOnClickListener(btn_clear);
        buttonSetOnClickListener(btn_plus_minus);
        percetageSetOnClickListener(btn_percentage);
        actionsSetOnClickListener(btn_divide);
        actionsSetOnClickListener(btn_multiply);
        actionsSetOnClickListener(btn_subtract);
        actionsSetOnClickListener(btn_add);
        buttonSetOnClickListener(btn_dot);
        equalSetOnClickListener(btn_equal);

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        String res = result.getText().toString();
        instanceState.putString(tv0tag, res);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        result.setText(instanceState.getString(tv0tag, "0"));
    }

    public void buttonSetOnClickListener(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                if (isNull)
                    result.setText("");
                isNull = false;
                String button = result.getText().toString();
                switch (view.getId()) {
                    case R.id.btn_1:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "1";
                        break;
                    case R.id.btn_2:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "2";
                        break;
                    case R.id.btn_3:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "3";
                        break;
                    case R.id.btn_4:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "4";
                        break;
                    case R.id.btn_5:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "5";
                        break;
                    case R.id.btn_6:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "6";
                        break;
                    case R.id.btn_7:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "7";
                        break;
                    case R.id.btn_8:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "8";
                        break;
                    case R.id.btn_9:
                        if (oneZero(button) && button.length() == 1) {
                            button = button.substring(1);
                        }
                        button = button + "9";
                        break;
                    case R.id.btn_0:
                        if (oneZero(button) && button.length() == 1) {
                            button = "0";
                        } else {
                            button = button + "0";
                        }
                        break;

                    case R.id.btn_dot:
                        if (dotIsPresent(button)) {
                        } else if (oneZero(button)) {
                            button = "0.";
                        } else {
                            button = button + ".";
                        }
                        break;
                    case R.id.btn_plus_minus:
                        if (oneZero(button)) {
                            button = "0";
                        } else {
                            if (minusIsPresent(button)) {
                                button = button.substring(1);
                            } else {
                                button = "-" + button;
                            }
                        }
                        break;

                }
                result.setText(button);
            }
        });
    }

    public void percetageSetOnClickListener(Button percetage) {
        percetage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (operator == "") {
                    String number = result.getText().toString();
                    double perc = Double.parseDouble(number) / 100;
                    number = perc + "";
                    result.setText(number);
                } else {
                    String nextNumber = result.getText().toString();
                    double res = 0.0;
                    switch (operator) {
                        case "/":
                            res = Double.parseDouble(number) / Double.parseDouble(nextNumber) * 100;
                            break;
                        case "*":
                            res = Double.parseDouble(number) * Double.parseDouble(nextNumber) / 100;
                            break;
                        case "-":
                            res = Double.parseDouble(number) - Double.parseDouble(number) * Double.parseDouble(nextNumber) / 100;
                            break;
                        case "+":
                            res = Double.parseDouble(number) + Double.parseDouble(number) * Double.parseDouble(nextNumber) / 100;
                            break;
                    }
                    result.setText(res + "");


                }
            }
        });
    }

    public void actionsSetOnClickListener(Button actions) {
        actions.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                isNull = true;
                number = result.getText().toString();
                switch (view.getId()) {
                    case R.id.btn_divide:
                        operator = "/";
                        break;
                    case R.id.btn_multiply:
                        operator = "*";
                        break;
                    case R.id.btn_subtract:
                        operator = "-";
                        break;
                    case R.id.btn_add:
                        operator = "+";
                        break;
                }
            }
        });
    }

    public void equalSetOnClickListener(Button equal) {
        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String nextNumber = result.getText().toString();
                double res = 0.0;
                if (Double.parseDouble(nextNumber) < 0.000000001 && operator == "/" || nextNumber.equals("") && operator == "/") {
                    Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_SHORT).show();
                } else {
                    switch (operator) {
                        case "/":
                            res = Double.parseDouble(number) / Double.parseDouble(nextNumber);
                            break;
                        case "*":
                            res = Double.parseDouble(number) * Double.parseDouble(nextNumber);
                            break;
                        case "-":
                            res = Double.parseDouble(number) - Double.parseDouble(nextNumber);
                            break;
                        case "+":
                            res = Double.parseDouble(number) + Double.parseDouble(nextNumber);
                            break;
                    }
                    result.setText(res + "");
                }
            }
        });
    }

    public void clearSetOnClickListener(Button clear) {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("0");
                isNull = true;
            }
        });
    }

    public boolean dotIsPresent(String button) {
        if (!button.contains(".")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean minusIsPresent(String button) {
        if (button.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public boolean oneZero(String button) {
        if (button.equals("")) {
            return true;
        }
        if (button.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }

}