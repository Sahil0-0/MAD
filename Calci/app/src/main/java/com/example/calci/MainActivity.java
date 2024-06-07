package com.example.calci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText firstValue, secondValue;
    Button submitButton;
    int a, b, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstValue = findViewById(R.id.valueOne);
        secondValue = findViewById(R.id.valueTwo);
        submitButton = findViewById(R.id.buttonCal);




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(firstValue.getText().toString());
                b= Integer.parseInt(secondValue.getText().toString());
                result = a+b;

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("FIRST_VALUE", String.valueOf(a));
                intent.putExtra("SECOND_VALUE", String.valueOf(b));
                intent.putExtra("RESULT", String.valueOf(result));
                startActivity(intent);

            }
        });



    }
}