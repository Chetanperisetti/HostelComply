package my.hostelcomply.app.studentPanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import my.hostelcomply.app.R;
import my.hostelcomply.app.plumberPanel.StudentplumbingComplaintDetailswithdate;

public class StudentPComplaintDetailsAdapter extends RecyclerView.Adapter<StudentPComplaintDetailsAdapter.MyViewHolder>{

    Context context;
    ArrayList<StudentplumbingComplaintDetailswithdate> list;

    public StudentPComplaintDetailsAdapter(Context context, ArrayList<StudentplumbingComplaintDetailswithdate> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentPComplaintDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_complaint_item_p, parent, false);
        return new StudentPComplaintDetailsAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentPComplaintDetailsAdapter.MyViewHolder holder, int position) {
        StudentplumbingComplaintDetailswithdate complaint = list.get(position);
        holder.firstname.setText(complaint.getFirstname());
        holder.problem_item.setText(complaint.getProblemIte());
        holder.washroomNumber.setText(complaint.getWashroomNumber());

        holder.description.setText(complaint.getDescription());
        holder.roomnumber.setText(complaint.getRoomNumber());
        holder.emobile.setText(complaint.getEmobile());
        holder.date.setText(complaint.getDate());
        holder.time.setText(complaint.getTime());

//washroomside


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to OneComplaintDisplay activity
                Intent intent = new Intent(context,OneComplaintStudentDisplayp.class);
                intent.putExtra("firstname", complaint.getFirstname());
                intent.putExtra("problem_item", complaint.getProblemIte());
                intent.putExtra("description", complaint.getDescription());
                intent.putExtra("roomnumber", complaint.getRoomNumber());
                intent.putExtra("phonenumber", complaint.getEmobile());
                intent.putExtra("studentId", complaint.getStudentId());
                intent.putExtra("date", complaint.getDate());
                intent.putExtra("time", complaint.getTime());
                intent.putExtra("status", complaint.getStatus());

                intent.putExtra("key", complaint.getKey());
                intent.putExtra("randomUid", complaint.getRandomUid());
                intent.putExtra("randomUid", complaint.getRandomUid());
                intent.putExtra("washroomNumber", complaint.getWashroomNumber());







                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, problem_item, description, roomnumber, emobile,date,time,washroomNumber;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.first_name);
            problem_item = itemView.findViewById(R.id.problem_item);
            description = itemView.findViewById(R.id.description);
            washroomNumber= itemView.findViewById(R.id.washroomside);
            roomnumber = itemView.findViewById(R.id.roomnumber);
            emobile = itemView.findViewById(R.id.ephonenumber);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);


            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
