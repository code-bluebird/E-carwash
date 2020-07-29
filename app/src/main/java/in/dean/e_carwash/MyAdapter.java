package in.dean.e_carwash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models;
    String email,location,address1,address2,title;


    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {

        myHolder.mEmail.setText(models.get(i).getEmail());
        email=myHolder.mEmail.getText().toString();
        myHolder.mLocation.setText(models.get(i).getLocation());
        location=myHolder.mLocation.getText().toString();
        myHolder.mAddress1.setText(models.get(i).getAddress1());
        address1=myHolder.mAddress1.getText().toString();
        myHolder.mAddress2.setText(models.get(i).getAddress2());
        address2=myHolder.mAddress2.getText().toString();



        /*myHolder.mDes.setText(models.get(i).getDescription());*/
        myHolder.mImage.setImageResource(models.get(i).getImg());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                BitmapDrawable bitmapDrawable=(BitmapDrawable)myHolder.mImage.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] bytes=stream.toByteArray();
                myHolder.mTitle.setText(models.get(position).getTitle());
                title=myHolder.mTitle.getText().toString();
                Intent intent=new Intent(c,BookActivity.class);
                intent.putExtra("iImage",bytes);
                intent.putExtra("email",email);
                intent.putExtra("location",location);
                intent.putExtra("address1",address1);
                intent.putExtra("address2",address2);
                intent.putExtra("title",title);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
