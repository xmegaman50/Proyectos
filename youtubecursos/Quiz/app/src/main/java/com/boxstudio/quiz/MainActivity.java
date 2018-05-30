package com.boxstudio.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int id_answers[] = {

            R.id.answer1,R.id.answer2,R.id.answer3,R.id.answer4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text_question =(TextView) findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);

        String[] answers =getResources().getStringArray(R.array.answers);

        for (int i = 0; i <id_answers.length;i++){
            RadioButton rb = (RadioButton) findViewById(id_answers[i]);
            rb.setText(answers[i]);


        }
    }
}
