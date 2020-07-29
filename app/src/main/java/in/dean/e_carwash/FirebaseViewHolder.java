package in.dean.e_carwash;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    public TextView email,mobile,name,oaddress1,oaddress2,olocation,otitle;
    public ImageView image;
    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);
        email=itemView.findViewById(R.id.email);
        name=itemView.findViewById(R.id.name);
        mobile=itemView.findViewById(R.id.mobile);
        oaddress1=itemView.findViewById(R.id.oaddress1);
        oaddress2=itemView.findViewById(R.id.oaddress2);
        olocation=itemView.findViewById(R.id.olocation);
        image=itemView.findViewById(R.id.image);
        otitle=itemView.findViewById(R.id.otitle);

    }
}
