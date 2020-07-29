package in.dean.e_carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminHome extends AppCompatActivity {
    public TextView email,mobile,name,oaddress1,oaddress2,olocation,otitle;
    public ImageView image;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        String nameI=getIntent().getStringExtra("name");
        String emailI=getIntent().getStringExtra("email");
        String mobileI=getIntent().getStringExtra("mobile");
        String oaddress1I=getIntent().getStringExtra("oaddress1");
        String oaddress2I=getIntent().getStringExtra("oaddress2");
        String olocationI=getIntent().getStringExtra("olocation");

        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        oaddress1=findViewById(R.id.oaddress1);
        oaddress2=findViewById(R.id.oaddress2);
        olocation=findViewById(R.id.olocation);
        image=findViewById(R.id.image);
        byte[] mBytes = getIntent().getByteArrayExtra("image");
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);
        image.setImageBitmap(bitmap);
        email.setText(emailI);
        name.setText(nameI);
        mobile.setText(mobileI);
        oaddress1.setText(oaddress1I);
        oaddress2.setText(oaddress2I);
        olocation.setText(olocationI);
        Log.i("OUR VALUE",nameI);
        Log.i("OUR email",emailI);
        Log.i("OUR mobile",mobileI);
        Log.i("OUR add1",oaddress1I);
        Log.i("OUR add2",oaddress2I);
        Log.i("OUR location",olocationI);

        /*Toast.makeText(this, name+"\n"+email+"\n"+mobile+"\n"+oaddress1+"\n"+oaddress2+"\n"+olocation+"\n"+otitle, Toast.LENGTH_SHORT).show();
*/
    }

    /*@Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finishAffinity(); // Close all activites
            System.exit(0);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }*/



}