package chetu.second.batch.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


   Context context;
    RadioGroup radioGroup;
    EditText eth_text;
    EditText etw_text;
    Button  clear , submit;
    TextView  res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this;
        radioGroup = findViewById(R.id.group);
        eth_text = findViewById(R.id.hieght);
        etw_text = findViewById(R.id.wight);
        submit = findViewById(R.id.submit);

        res2 = findViewById(R.id.res2);
        clear = findViewById(R.id.clearBtn);
        submit.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (v.getId())
        {
            case R.id.submit:
            String str1 =  eth_text.getText().toString();
            String str2 = etw_text.getText().toString();


            // condition

                if(TextUtils.isEmpty(str1)){
                    eth_text.setError("Please enter your weight");
                    eth_text.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    etw_text.setError("Please enter your weight");
                    etw_text.requestFocus();
                    return;
                }



            float height = Float.parseFloat(str1)/100;
            float weight = Float.parseFloat(str2);
            float bmiValue = calculateBMI(weight, height);
            String bmiInterpretation = interpretBMI(bmiValue);
            res2.setText(String.valueOf(" Your BMI value is "+bmiValue + "-" + bmiInterpretation));
            break;

            case R.id.clearBtn:
                eth_text.setText(null);
                etw_text.setText(null);
                 res2.setText(null);

        }
    }


    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }



    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }

}