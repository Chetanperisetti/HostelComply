package my.hostelcomply.app.electricianPanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import my.hostelcomply.app.R;

public class StudentelectricalComplaintDetailsAdapter extends RecyclerView.Adapter<StudentelectricalComplaintDetailsAdapter.MyViewHolder> {
    Context context;
    ArrayList<StudentelectricalComplaintDetails> list;

    public StudentelectricalComplaintDetailsAdapter(Context context, ArrayList<StudentelectricalComplaintDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.complaint_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        StudentelectricalComplaintDetails complaint = list.get(position);
        holder.firstname.setText(complaint.getFname());
        holder.problem_item.setText(complaint.getProblemitem());
        holder.description.setText(complaint.getDesc());
        holder.roomnumber.setText(complaint.getRoomnumber());
        holder.phonenumber.setText(complaint.getPhonenumber());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OneComplaintDisplay.class);
                intent.putExtra("firstname", complaint.getFname());
                intent.putExtra("problem_item", complaint.getProblemitem());
                intent.putExtra("description", complaint.getDesc());
                intent.putExtra("roomnumber", complaint.getRoomnumber());
                intent.putExtra("phonenumber", complaint.getPhonenumber());
                intent.putExtra("studentId",complaint.getStudentId());
                intent.putExtra("randomUid",complaint.getRandomUid());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, problem_item, description, roomnumber, phonenumber;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.first_name);
            problem_item = itemView.findViewById(R.id.problem_item);
            description = itemView.findViewById(R.id.description);
            roomnumber = itemView.findViewById(R.id.roomnumber);
            phonenumber = itemView.findViewById(R.id.phonenumber);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}