package com.example.kasymov_rinat_hw_27;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, sum;
    private String operation;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void onNumberClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
                    textView.setText("0");
                    first = 0;
                }
        else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();

        switch (textButton) {
            /*case "AC":
                textView.setText("0");
                first = 0;
                break;*/
            case "/":
                first = Integer.valueOf(textView.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case "X":
                first = Integer.valueOf(textView.getText().toString());
                operation = "X";
                isOperationClick = true;
                break;
            case "-":
                first = Integer.valueOf(textView.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case "+":
                first = Integer.valueOf(textView.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;
            case "=":
                second = Integer.valueOf(textView.getText().toString());
                if (operation.equals("+")) {
                    sum = first + second;
                } else if (operation.equals("/")) {
                    if (second != 0) {
                        sum = first / second;
                    } else {
                        //  0 здесь
                    }
                } else if (operation.equals("X")) {
                    sum = first * second;
                } else if (operation.equals("-")) {
                    sum = first - second;
                } else if (operation.equals("%")) {
                    sum = (first * second) / 100;
                } else if (operation.equals("+/-")) {
                    sum = first + second;
                }

                if (sum != null) {
                    textView.setText(sum.toString());
                }

                isOperationClick = true;
                break;
            case "%":
                first = Integer.valueOf(textView.getText().toString());
                operation = "%";
                isOperationClick = true;
                break;
            case "+/-":
                first = Integer.valueOf(textView.getText().toString());
                operation = "+/-";
                isOperationClick = true;
        }
    }
}