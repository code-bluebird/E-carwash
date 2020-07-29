package in.dean.e_carwash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Map;
public class ProfileActivity extends AppCompatActivity {
private TextView TVusername,TVemail,TVmobile,TVorders;
Button logout;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String email;
ProgressBar progressBar;
    private String userid;
    private static final String USERS = "Users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
         email=bundle.getString("email");
        }
        else{
            Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Session finished"+"Login Again!", Toast.LENGTH_SHORT).show();
        }
        /*Intent intent=getIntent();
        email=intent.getStringExtra("email");*/
/*
        Toast.makeText(this, email+"..yeah", Toast.LENGTH_SHORT).show();
*/

        TVorders=findViewById(R.id.TVorders);
        TVemail=findViewById(R.id.TVemail);
        TVusername=findViewById(R.id.TVusername);
        TVmobile=findViewById(R.id.TVmobile);
        logout=findViewById(R.id.logout);
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        /*Log.v("USERID", userRef.getKey());*/
        userRef.addValueEventListener(new ValueEventListener() {
            String mobile,name;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        name = keyId.child("name").getValue(String.class);
                        mobile = keyId.child("mobile").getValue(String.class);
                        TVusername.setText(name);
                        TVemail.setText(email);
                        TVmobile.setText(mobile);

                        break;
                    }
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                progressBar.setVisibility(View.INVISIBLE);
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TVorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,OrderActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
    }
}