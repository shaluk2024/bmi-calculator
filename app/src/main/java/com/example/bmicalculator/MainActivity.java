package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt_feet,edt_inch,edt_wt;
        AppCompatButton btn_calc;
        TextView txt_result;
        LinearLayoutCompat llc;

        edt_feet = findViewById(R.id.edtFeet);
        edt_inch = findViewById(R.id.edtInch);
        edt_wt = findViewById(R.id.edtWeight);
        btn_calc = findViewById(R.id.btnCalculate);
        txt_result = findViewById(R.id.txtResult);
        llc = findViewById(R.id.llMain);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int height_feet = Integer.parseInt(edt_feet.getText().toString());

                int height_inch = Integer.parseInt(edt_inch.getText().toString());

                int weight = Integer.parseInt(edt_wt.getText().toString());

                double heightInCms =  ((height_feet * 12) + height_inch) * 2.54;

                double heightInMtr = heightInCms/100;

                double bmi = weight/ (heightInMtr*heightInMtr);
                if(bmi <= 18.4){
                    txt_result.setText("You are Underweight");
                    llc.setBackgroundColor(getResources().getColor(R.color.yellow));
                }else if(bmi >= 18.5 && bmi <= 24.9){
                    txt_result.setText("You are Healthy");
                    llc.setBackgroundColor(getResources().getColor(R.color.green));
                }else if(bmi >= 25 && bmi <= 39.9){
                    txt_result.setText("You are Overweight");
                    llc.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    txt_result.setText("You are Obese");
                    llc.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });




    }
}