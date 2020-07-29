package in.dean.e_carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DoneActivity extends AppCompatActivity {
ImageView DoneImage;
Button back;
String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            email=bundle.getString("email");

            /*Toast.makeText(this, email, Toast.LENGTH_SHORT).show();*/

        }
        else{
            Intent intent=new Intent(DoneActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Session finished"+"Login Again!", Toast.LENGTH_SHORT).show();
        }
        back=(Button) findViewById(R.id.back);
        DoneImage = (ImageView) findViewById(R.id.DoneImage);
        Glide
                .with(this)
                .load(R.drawable.done)
                        .into(DoneImage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DoneActivity.this,MainActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });
    }
}