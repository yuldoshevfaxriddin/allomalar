package uz.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt,wrongt,resultInfo,resultScore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home=findViewById(R.id.returnHome);
        correctt=findViewById(R.id.resultCorrect);
        wrongt=findViewById(R.id.resultWrong);
        resultInfo=findViewById(R.id.resultInfo);
        resultScore=findViewById(R.id.resultScore);
        resultImage=findViewById(R.id.resultImage);

        int correct=getIntent().getIntExtra("correct",0);
        int wrong=getIntent().getIntExtra("wrong",0);
        int jami=getIntent().getIntExtra("jami",0);
        int score=100*correct/jami;

        correctt.setText(""+correct);
        wrongt.setText(""+wrong);
        resultScore.setText(""+score+"%");

        if(1.0*correct/jami<=0.6){
            resultInfo.setText("You have to take the test again. "+correct+" / "+jami);
            resultImage.setImageResource(R.drawable.ic_sad);
        }
        else if(1.0*correct/jami<=0.8){
            resultInfo.setText("You have to try a little more. "+correct+" / "+jami);
            resultImage.setImageResource(R.drawable.ic_neutral);
       }
        else if(1.0*correct/jami<0.9){
            resultInfo.setText("You are pretty good. "+correct+" / "+jami);
            resultImage.setImageResource(R.drawable.ic_smile);
        }
        else{
            resultInfo.setText("Awesome. "+correct+" / "+jami);
            resultImage.setImageResource(R.drawable.ic_smile);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }

}