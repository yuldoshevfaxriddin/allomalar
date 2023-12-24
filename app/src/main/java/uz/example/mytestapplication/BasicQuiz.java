package uz.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicQuiz extends AppCompatActivity {

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
        quizInfo = findViewById(R.id.quizInfo);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);


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
                Log.d("xatolik","shu yergacha ishladi");
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
                    Intent intent = new Intent(BasicQuiz.this, ResultActivity.class);
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
                    Intent intent = new Intent(BasicQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami", jami);
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
                    Intent intent = new Intent(BasicQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami", jami);
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
                    Intent intent = new Intent(BasicQuiz.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("jami", jami);
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
        Log.d("xatolik yoq","setQuestionScreen ishladi");
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

    private void loadAllQuestion() {
        Log.d("xatolik yoq","loadAllQuestion funksiya ishga tushdi");
        quesitionsItems = new ArrayList<>();
        Log.d("xatolik yoq","queestionItem array yuklandi");
        String jsonquiz=loadJsonFromAsset("easyquestions.json");
        Log.d("xatolik yoq","easyquestion fayl yuklandi");
        try{
            JSONObject jsonObject=new JSONObject(jsonquiz);
            JSONArray questions=jsonObject.getJSONArray("easyquestions");
            testlar=questions.length();
            for (int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);

                String questionString=question.getString("question");
                String answer1String=question.getString("answer1");
                String answer2String=question.getString("answer2");
                String answer3String=question.getString("answer3");
                String answer4String=question.getString("answer4");
                String correctString=question.getString("correct");
                String res=questionString+answer1String+answer2String+answer3String+answer4String;
                Log.d("json malumotlar",res);

                quesitionsItems.add(new QuesitionsItems(questionString,answer1String,answer2String,answer3String,answer4String,correctString));
            }
            Log.d("xatolik yoq","try bloki ishga tushdi");
        }
        catch (Exception e){
            Log.d("xatolik bor","bu catch xatolik bor");
            e.printStackTrace();
        }

    }

    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder=new MaterialAlertDialogBuilder(BasicQuiz.this);
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
            startActivity(new Intent(BasicQuiz.this,MainActivity.class));
            finish();
            }
        });
        materialAlertDialogBuilder.show();
    }


}