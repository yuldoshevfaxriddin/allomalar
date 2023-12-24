package uz.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class AboutActuvity extends AppCompatActivity {

    MaterialCardView developerCard,darkCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_actuvity);

        developerCard=findViewById(R.id.developerCard);
        darkCard=findViewById(R.id.darkMode);

        developerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://t.me/faxriddin_yuldoshev");
                Intent likeling=new Intent(Intent.ACTION_VIEW,uri);
                likeling.setPackage("com.telegram.android");
                try{
                    startActivity(likeling);
                }
                catch(ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://t.me/faxriddin_yuldoshev")));
                }
            }
        });
    }
    public void onBackPressed(){
        startActivity(new Intent(AboutActuvity.this,MainActivity.class));
        finish();
    }

}