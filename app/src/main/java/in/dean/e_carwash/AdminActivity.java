package in.dean.e_carwash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ArrayList<Aorders> arrayList;
private FirebaseRecyclerOptions<Aorders> options;
private FirebaseRecyclerAdapter<Aorders,FirebaseViewHolder> adapter;
private DatabaseReference databaseReference;
ProgressBar progressBar;
ImageView image;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<Aorders>();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Orders");
        databaseReference.keepSynced(true);
        options=new FirebaseRecyclerOptions.Builder<Aorders>().setQuery(databaseReference,Aorders.class).build();


        adapter=new FirebaseRecyclerAdapter<Aorders, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final FirebaseViewHolder holder, int position, @NonNull final Aorders model) {
                holder.email.setText(model.getEmail());
                holder.mobile.setText(model.getMobile());
                holder.name.setText(model.getName());
                holder.oaddress1.setText(model.getOaddress1());
                holder.oaddress2.setText(model.getOaddress2());
                holder.olocation.setText(model.getOlocation());
                final String otitle=model.getOtitle();
                switch (otitle) {
                    case "w1":
                        holder.image.setImageResource(R.drawable.w1);
                        break;
                    case "w2":
                        holder.image.setImageResource(R.drawable.w2);
                        break;
                    case "w3":
                        holder.image.setImageResource(R.drawable.w3);
                        break;
                    case "s1":
                        holder.image.setImageResource(R.drawable.s1);
                        break;
                    default:
                        holder.image.setImageResource(R.drawable.s2);
                        break;
                }
               /* holder.image.setImageBitmap(R.drawable.w1);*/
                /*holder.otitle.setText(model.getOtitle());*/
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(AdminActivity.this,AdminHome.class);
                        BitmapDrawable bitmapDrawable=(BitmapDrawable)holder.image.getDrawable();
                        Bitmap bitmap=bitmapDrawable.getBitmap();
                        ByteArrayOutputStream stream=new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                        byte[] bytes=stream.toByteArray();
                        intent.putExtra("email",model.getEmail());
                        intent.putExtra("name",model.getName());
                        intent.putExtra("mobile",model.getMobile());
                        intent.putExtra("oaddress1",model.getOaddress1());
                        intent.putExtra("oaddress2",model.getOaddress2());
                        intent.putExtra("olocation",model.getOlocation());
                        intent.putExtra("image",bytes);
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                progressBar.setVisibility(View.INVISIBLE);
                return new FirebaseViewHolder(LayoutInflater.from(AdminActivity.this).inflate(R.layout.admin_row,viewGroup,false));
            }
        };

        recyclerView.setAdapter(adapter);
    }
    @Override
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
    }
}