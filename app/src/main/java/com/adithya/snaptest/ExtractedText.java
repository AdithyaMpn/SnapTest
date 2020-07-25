package com.adithya.snaptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExtractedText extends AppCompatActivity {

    public static String EXTRACTED_TEXT = "EXTRACTED_TEXT";
    private String extractedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extracted_text);

        extractedText = getIntent().getStringExtra(EXTRACTED_TEXT);

        final AppCompatEditText extracted_text = findViewById(R.id.extracted_text);
        extracted_text.setText(extractedText);

        AppCompatButton convert_button = findViewById(R.id.convert_button);
        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtractedText.this, QuizActivity.class);
                intent.putExtra(EXTRACTED_TEXT, extracted_text.getText().toString());
                startActivity(intent);
            }
        });
    }
}