package in.dean.e_carwash;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView mTitle;
    ImageView mImage;
    TextView mEmail,mLocation,mAddress1,mAddress2;
    ItemClickListener itemClickListener;
     MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mEmail=itemView.findViewById(R.id.email);
        this.mLocation=itemView.findViewById(R.id.location);
        this.mAddress1=itemView.findViewById(R.id.address1);
        this.mAddress2=itemView.findViewById(R.id.address2);
        this.mTitle=itemView.findViewById(R.id.title);
        /*this.mDes=itemView.findViewById(R.id.description);*/
        this.mImage=itemView.findViewById(R.id.imageTV);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener ic){
         this.itemClickListener=ic;
    }
}

