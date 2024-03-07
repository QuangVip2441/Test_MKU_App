package com.example.test_mku_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.test_mku_app.Models.ChoiceModel;
import com.example.test_mku_app.Models.QuestionModel;
import com.example.test_mku_app.Views.AddModuleFragment;
import com.example.test_mku_app.Views.AddQuestionFragment;
import com.example.test_mku_app.ultils.FragmentUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<QuestionModel> mQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestions = new ArrayList<>();
        //mQuestions = getMCQ();

        replaceFragment(new AddQuestionFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentUtils.replaceFragment(
                getSupportFragmentManager(),
                fragment,
                false);
    }

    private ArrayList<QuestionModel> getMCQ() {
        ArrayList<QuestionModel> questions = new ArrayList<>();

        questions.clear();

        ArrayList<ChoiceModel> choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Word"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Power Point aaaaaaa aaaa aaaaa aaaaaaa aaaa aaaaa aaaaaa aaaa aaaaa aaaaaa aaaa aaaaa aaaaaaa"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "1",
                "Trong Windows, phan mem may tinh co ten gì?",
                choices,
                "4"
        ));

        choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Word"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Power Point"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "2",
                "Trong Windows, phan mem go van ban?",
                choices,
                "1"
        ));

        choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Mathlab"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Google"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "3",
                "Trong Windows, phan mem xu ly bang tinh?",
                choices,
                "3"
        ));

        return questions;
    }
}