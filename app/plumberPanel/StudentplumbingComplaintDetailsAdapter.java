package my.hostelcomply.app.plumberPanel;

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
import my.hostelcomply.app.studentPanel.StudentpComplaintDetails;

public class StudentplumbingComplaintDetailsAdapter extends RecyclerView.Adapter<StudentplumbingComplaintDetailsAdapter.MyViewHolder> {
    Context context;
    ArrayList<StudentPlumbingComplaintDetails> list;

    public StudentplumbingComplaintDetailsAdapter(Context context, ArrayList<StudentPlumbingComplaintDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentplumbingComplaintDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.complaint_itemp, parent, false);
        return new StudentplumbingComplaintDetailsAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentplumbingComplaintDetailsAdapter.MyViewHolder holder, int position) {
        StudentPlumbingComplaintDetails complaint = list.get(position);
        holder.firstname.setText(complaint.getFname());
        holder.problem_item.setText(complaint.getProblemitem());
        holder.description.setText(complaint.getDesc());
        holder.washroomNumber.setText(complaint.getWashroomNumber());

        holder.roomnumber.setText(complaint.getRoomnumber());
        holder.phonenumber.setText(complaint.getPhonenumber());
        holder.phonenumber.setText(complaint.getPhonenumber());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OneComplaintDisplayp.class);
                intent.putExtra("firstname", complaint.getFname());
                intent.putExtra("problem_item", complaint.getProblemitem());
                intent.putExtra("description", complaint.getDesc());
                intent.putExtra("roomnumber", complaint.getRoomnumber());
                intent.putExtra("phonenumber", complaint.getPhonenumber());
                intent.putExtra("studentId",complaint.getStudentId());
                intent.putExtra("randomUid",complaint.getRandomUid());

                intent.putExtra("washroomNumber",complaint.getWashroomNumber());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, problem_item, description, roomnumber, phonenumber,washroomNumber;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.first_name);
            problem_item = itemView.findViewById(R.id.problem_item);
            description = itemView.findViewById(R.id.description);

            washroomNumber= itemView.findViewById(R.id.washroomside);
            roomnumber = itemView.findViewById(R.id.roomnumber);
            phonenumber = itemView.findViewById(R.id.phonenumber);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
