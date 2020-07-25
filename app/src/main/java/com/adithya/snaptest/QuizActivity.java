package com.adithya.snaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String extractedText = getIntent().getStringExtra(ExtractedText.EXTRACTED_TEXT);

        extractedText = extractedText.replace("\n", "");

        Pattern split_que_sets = Pattern.compile("[0-9][.]|[0-9][0-9][.]");
        String[] questionSets = split_que_sets.split(extractedText);

        Pattern split_que_options = Pattern.compile("\\([1-4a-dA-D]\\)");

        String[] splittedQuestions_Options = split_que_options.split(questionSets[2]);

//        for (String questionSet : questionSets) {
//            if (split_que_options.split(questionSet).length != 1) {
//                String[] splittedQuestions_Options = split_que_options.split(questionSet);
//                for (String s : splittedQuestions_Options) {
//                    one_ques_ans.add(s);
//                }
//            }
//
//            ques_ans.add(one_ques_ans);
//            one_ques_ans.clear();
//        }

        TextView tv_question = findViewById(R.id.question);
        tv_question.setText(splittedQuestions_Options[0]);

        final FButton option_a = findViewById(R.id.option_a);
        option_a.setText(splittedQuestions_Options[1]);
        final FButton option_b = findViewById(R.id.option_b);
        option_b.setText(splittedQuestions_Options[2]);
        final FButton option_c = findViewById(R.id.option_c);
        option_c.setText(splittedQuestions_Options[3]);
        final FButton option_d = findViewById(R.id.option_d);
        option_d.setText(splittedQuestions_Options[4]);

        final FButton check_button = findViewById(R.id.check_button);

        option_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_a.setButtonColor(getResources().getColor(R.color.light_blue));
                option_b.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_c.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_d.setButtonColor(getResources().getColor(R.color.light_yellow));
            }
        });

        option_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_a.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_b.setButtonColor(getResources().getColor(R.color.light_blue));
                option_c.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_d.setButtonColor(getResources().getColor(R.color.light_yellow));
            }
        });

        option_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_a.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_b.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_c.setButtonColor(getResources().getColor(R.color.light_blue));
                option_d.setButtonColor(getResources().getColor(R.color.light_yellow));
            }
        });

        option_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_a.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_b.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_c.setButtonColor(getResources().getColor(R.color.light_yellow));
                option_d.setButtonColor(getResources().getColor(R.color.light_blue));
            }
        });

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(QuizActivity.this,"Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}