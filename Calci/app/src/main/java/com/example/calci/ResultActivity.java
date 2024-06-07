package com.example.calci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView resultSpace, databaseResult;
    helperDataBase db;
    Button dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultSpace = findViewById(R.id.resultFinal);
        dataBase = findViewById(R.id.buttonData);
        databaseResult=findViewById(R.id.resultDatabase);

        Intent intent = getIntent();
        String firstValue = intent.getStringExtra("FIRST_VALUE");
        String secondValue = intent.getStringExtra("SECOND_VALUE");
        String resultValue = intent.getStringExtra("RESULT");
        resultSpace.setText("Result : "+ resultValue);

        dataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String table = db.ShowData(firstValue, secondValue, resultValue);
               databaseResult.setText(table);
            }
        });


    }
}