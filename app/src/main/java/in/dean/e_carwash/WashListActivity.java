package in.dean.e_carwash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class WashListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    String email,location,address1,address2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_list);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            email=bundle.getString("email");
            location=bundle.getString("location");
            address1=bundle.getString("address1");
            address2=bundle.getString("address2");
        }
        else{
            Intent intent=new Intent(WashListActivity.this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Session finished"+"Login Again!", Toast.LENGTH_SHORT).show();
        }

        mRecyclerView=findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new MyAdapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {
        ArrayList<Model> models=new ArrayList<>();
        Model m=new Model();
            m.setTitle("w1");
            m.setImg(R.drawable.w1);
        m.setEmail(email);
        m.setLocation(location);
        m.setAddress1(address1);
        m.setAddress2(address2);
            models.add(m);

            m = new Model();
            m.setTitle("w2");
            m.setImg(R.drawable.w2);
        m.setEmail(email);
        m.setLocation(location);
        m.setAddress1(address1);
        m.setAddress2(address2);
            models.add(m);

            m = new Model();
            m.setTitle("w3");
            m.setImg(R.drawable.w3);
        m.setEmail(email);
        m.setLocation(location);
        m.setAddress1(address1);
        m.setAddress2(address2);
            models.add(m);


        return models;
    }
}