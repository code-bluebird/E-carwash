package in.dean.e_carwash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class BookActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private FirebaseAuth mAuth;
    private String userid;
    private static final String USERS = "Users";
    ImageView mImage;
    Button mBooknow;
    String email,Olocation,Oaddress1,Oaddress2,Otitle,name,mobile;
    Spinner spinner;
    DatabaseReference databaseOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            email=bundle.getString("email");
            Olocation=bundle.getString("location");
            Oaddress1=bundle.getString("address1");
            Oaddress2=bundle.getString("address2");
            Otitle=bundle.getString("title");
           /* Toast.makeText(this, Otitle+"\n"+email+"\n"+Olocation+"\n"+Oaddress1+"\n"+Oaddress2, Toast.LENGTH_SHORT).show();*/

        }
        else{
            Intent intent=new Intent(BookActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Session finished"+"Login Again!", Toast.LENGTH_SHORT).show();
        }
        mImage=findViewById(R.id.image);
        mBooknow=findViewById(R.id.booknow);
        mBooknow.setEnabled(false);
        Intent intent=getIntent();
        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);
        mImage.setImageBitmap(bitmap);
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        /*Log.v("USERID", userRef.getKey());*/
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        name = keyId.child("name").getValue(String.class);
                        mobile = keyId.child("mobile").getValue(String.class);
                        mBooknow.setEnabled(true);
                        break;
                    }
                }

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(BookActivity.this, "Fetching Failed!! Check later", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(BookActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        databaseOrders=FirebaseDatabase.getInstance().getReference("Orders");
        mBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                Toast.makeText(BookActivity.this,title+"\n"+email+"\n"+location+"\n"+address1+"\n"+address2+"\n"+name+"\n"+mobile , Toast.LENGTH_SHORT).show();
*/
                addOrder();

            }
        });

    }
    private void addOrder(){
        if ((!TextUtils.isEmpty(email))||(!TextUtils.isEmpty(Olocation))||(!TextUtils.isEmpty(Otitle))||(!TextUtils.isEmpty(Oaddress1))||(!TextUtils.isEmpty(Oaddress2))||(!TextUtils.isEmpty(mobile))||(!TextUtils.isEmpty(name)))
        {
            String id=databaseOrders.push().getKey();
/*
            Toast.makeText(this,id+"\n"+title+"\n"+email+"\n"+location+"\n"+address1+"\n"+address2+"\n"+name+"\n"+mobile , Toast.LENGTH_SHORT).show();
*/
            bookOrder bookOrder = new bookOrder(id,email, mobile, name,Oaddress1,Oaddress2,Olocation,Otitle);

            //Saving the Artist
            databaseOrders.child(id).setValue(bookOrder);

            //setting edittext to blank again

            Intent intent=new Intent(BookActivity.this,DoneActivity.class);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
/*
            Toast.makeText(this,id+"\n"+title+"\n"+email+"\n"+location+"\n"+address1+"\n"+address2+"\n"+name+"\n"+mobile , Toast.LENGTH_SHORT).show();
*/
            //displaying a success toast
            /*Toast.makeText(this, "added", Toast.LENGTH_LONG).show();*/
/*
            Toast.makeText(this, Otitle+"\n"+email+"\n"+Olocation+"\n"+Oaddress1+"\n"+Oaddress2+"\n"+name+"\n"+mobile, Toast.LENGTH_SHORT).show();
*/
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(BookActivity.this, "Unable to process request"+"\n"+"login again or try later", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(BookActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
        }

