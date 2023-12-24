package uz.example.mytestapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultQuiz extends AppCompatActivity {

    TextView quiztest,aans,bans,cans,dans,quizInfo;
    List<QuesitionsItems>quesitionsItems;
    int currentquestion=0;
    int correct=0,wrong=0;
    int jami=0,testlar=0;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiztest = findViewById(R.id.quizTest);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);
        quizInfo = findViewById(R.id.quizInfo);

        loadAllQuestion();
        Collections.shuffle(quesitionsItems);
        setQuestionScreen(currentquestion);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesitionsItems.get(currentquestion).getAnswer1().equals(quesitionsItems.get(currentquestion).getCorrect())) {
                    correct++;
                    aans.setBackgroundResource(R.color.green);
                    aans.setTextColor(getResources().getColor(R.color.white_second));
                } else {
                    wrong++;
                    aans.setBackgroundResource(R.color.red);
                    aans.setTextColor(getResources().getColor(R.color.white_second));
                }

                if (currentquestion < quesitionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentquestion++;
                            setQuestionScreen(currentquestion);
                            aans.setBackgroundResource(R.color.white_second);
                            aans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    jami = correct+wrong;
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami",jami);
                    startActivity(intent);
                    finish();
                }
            }
        });


        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesitionsItems.get(currentquestion).getAnswer2().equals(quesitionsItems.get(currentquestion).getCorrect())) {
                    correct++;
                    bans.setBackgroundResource(R.color.green);
                    bans.setTextColor(getResources().getColor(R.color.white_second));
                } else {
                    wrong++;
                    bans.setBackgroundResource(R.color.red);
                    bans.setTextColor(getResources().getColor(R.color.white_second));
                }

                if (currentquestion < quesitionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentquestion++;
                            setQuestionScreen(currentquestion);
                            bans.setBackgroundResource(R.color.white_second);
                            bans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    jami = correct+wrong;
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami",jami);
                    startActivity(intent);
                    finish();
                }
            }
        });


        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesitionsItems.get(currentquestion).getAnswer3().equals(quesitionsItems.get(currentquestion).getCorrect())) {
                    correct++;
                    cans.setBackgroundResource(R.color.green);
                    cans.setTextColor(getResources().getColor(R.color.white_second));
                } else {
                    wrong++;
                    cans.setBackgroundResource(R.color.red);
                    cans.setTextColor(getResources().getColor(R.color.white_second));
                }

                if (currentquestion < quesitionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentquestion++;
                            setQuestionScreen(currentquestion);
                            cans.setBackgroundResource(R.color.white_second);
                            cans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    jami = correct+wrong;
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami",jami);
                    startActivity(intent);
                    finish();
                }
            }
        });

        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesitionsItems.get(currentquestion).getAnswer4().equals(quesitionsItems.get(currentquestion).getCorrect())) {
                    correct++;
                    dans.setBackgroundResource(R.color.green);
                    dans.setTextColor(getResources().getColor(R.color.white_second));
                } else {
                    wrong++;
                    dans.setBackgroundResource(R.color.red);
                    dans.setTextColor(getResources().getColor(R.color.white_second));
                }

                if (currentquestion < quesitionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentquestion++;
                            setQuestionScreen(currentquestion);
                            dans.setBackgroundResource(R.color.white_second);
                            dans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    jami = correct+wrong;
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami",jami);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }



    private void setQuestionScreen(int currentquestion) {
        quiztest.setText(quesitionsItems.get(currentquestion).getQuestions());
        aans.setText(quesitionsItems.get(currentquestion).getAnswer1());
        bans.setText(quesitionsItems.get(currentquestion).getAnswer2());
        cans.setText(quesitionsItems.get(currentquestion).getAnswer3());
        dans.setText(quesitionsItems.get(currentquestion).getAnswer4());
        quizInfo.setText((correct+wrong+1)+"/"+testlar);
    }

    private void loadAllQuestion() {
        quesitionsItems = new ArrayList<>();
        String jsonquiz=loadJsonFromAsset("difficultquestions.json");
        try{
            JSONObject jsonObject=new JSONObject(jsonquiz);
            JSONArray questions=jsonObject.getJSONArray("difficultquestions");
            testlar=questions.length();
            for (int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);

                String questionString=question.getString("question");
                String answer1String=question.getString("answer1");
                String answer2String=question.getString("answer2");
                String answer3String=question.getString("answer3");
                String answer4String=question.getString("answer4");
                String correctString=question.getString("correct");

                quesitionsItems.add(new QuesitionsItems(questionString,answer1String,answer2String,answer3String,answer4String,correctString));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private String loadJsonFromAsset(String s) {
        String json="";
        try {
            InputStream inputStream=getAssets().open(s);
            int size=inputStream.available();
            byte[]buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json =new String(buffer,"UTF-8");

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return json;
    }

    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder=new MaterialAlertDialogBuilder(DifficultQuiz.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure want to exit the quiz ?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
            startActivity(new Intent(DifficultQuiz.this,MainActivity.class));
            finish();
            }
        });
        materialAlertDialogBuilder.show();
    }


}