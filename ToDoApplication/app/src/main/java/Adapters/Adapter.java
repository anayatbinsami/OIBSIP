package Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import DB.DbHelper;
import Models.Model;

import com.example.todoapplication.DataAddActivity;
import com.example.todoapplication.MainActivity;
import com.example.todoapplication.R;

import java.util.ArrayList;
import java.util.prefs.PreferenceChangeEvent;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    ArrayList<Model> list = new ArrayList<>();
    Context context;


    public Adapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final Model model = list.get(position);
       holder.title.setText(model.getTitle());
       holder.description.setText(model.getDiscription());

       holder.update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, DataAddActivity.class);
               intent.putExtra("type",2);
               intent.putExtra("title",model.getTitle().toString());
               intent.putExtra("discription",model.getDiscription().toString());
               intent.putExtra("id",model.getId());
               context.startActivity(intent);
           }
       });
       holder.delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DbHelper dbHelper = new DbHelper(context);

               AlertDialog.Builder builder = new AlertDialog.Builder(context);
               builder.setTitle("Delete");
               builder.setMessage("Are you sure to delete it?");



               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                       if (dbHelper.deleteData(model.getId())> 0){
                           Toast.makeText(context, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();


                       }
                   }
               });

               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                   }
               });

               builder.create().show();
               
           }

       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title, description;
    Button update,delete;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

       title= itemView.findViewById(R.id.title);
      description=  itemView.findViewById(R.id.discription);
      update = itemView.findViewById(R.id.Update);
      delete = itemView.findViewById(R.id.delete);

    }
}
}
