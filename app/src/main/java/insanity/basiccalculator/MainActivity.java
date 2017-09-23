package insanity.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btndec;
    Button btn0;
    Button btnequal;
    Button btnC;
    Button btnCE;
    Button btnminus;
    Button btnplus;
    Button btndivide;
    Button btnmultiply;

    TextView valText;
    double num1, num2;
    String oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        btndec = (Button) findViewById(R.id.btnDec);
        btnC = (Button) findViewById(R.id.btnC);
        btnCE = (Button)  findViewById(R.id.btnCE);
        btnequal = (Button) findViewById(R.id.btnEqual);
        btnminus = (Button) findViewById(R.id.subtractBtn);
        btnplus = (Button) findViewById(R.id.plusBtn);
        btndivide = (Button) findViewById(R.id.btnDivide);
        btnmultiply = (Button) findViewById(R.id.multiplyBtn);

        valText = (TextView) findViewById(R.id.valueTxt);

        View.OnClickListener numBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valText.setText(valText.getText().toString() + ((Button)v).getText().toString());
            }
        };


        btn1.setOnClickListener(numBtnClick);
        btn2.setOnClickListener(numBtnClick);
        btn3.setOnClickListener(numBtnClick);
        btn4.setOnClickListener(numBtnClick);
        btn5.setOnClickListener(numBtnClick);
        btn6.setOnClickListener(numBtnClick);
        btn7.setOnClickListener(numBtnClick);
        btn8.setOnClickListener(numBtnClick);
        btn9.setOnClickListener(numBtnClick);
        btn0.setOnClickListener(numBtnClick);
        btndec.setOnClickListener(numBtnClick);

        View.OnClickListener opBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oper = ((Button)v).getText().toString();
                try {
                    num1 = Double.parseDouble(valText.getText().toString());
                }catch (Exception ex)
                {
                    Log.e("ERROR", ex.getMessage().toString());
                    //do something here
                }

                valText.setText("");
            }
        };

        btnmultiply.setOnClickListener(opBtnClick);
        btnplus.setOnClickListener(opBtnClick);
        btnminus.setOnClickListener(opBtnClick);
        btndivide.setOnClickListener(opBtnClick);


        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(valText.getText().toString());

                switch (oper)
                {
                    case "+":
                        valText.setText(String.valueOf(num1 + num2));
                        break;

                    case "-":
                        valText.setText(String.valueOf(num1 - num2));
                        break;

                    case "x":
                        valText.setText(String.valueOf(num1 * num2));
                        break;

                    case "/":
                        valText.setText(String.valueOf(num1 / num2));
                        break;
                }
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valText.setText("");
                num1 = num2 = 0;
                oper = "";
            }
        });

    }
}
