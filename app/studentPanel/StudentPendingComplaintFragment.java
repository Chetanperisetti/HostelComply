package my.hostelcomply.app.studentPanel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import my.hostelcomply.app.R;
import my.hostelcomply.app.electricianPanel.StudentelectricalComplaintDetailsList;

public class StudentPendingComplaintFragment extends Fragment {

    Button viewComplaint;
    Button viewComplaint1;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_pending_complaints,null);
        getActivity().setTitle("Pending complaints");


        viewComplaint=(Button) v.findViewById(R.id.view_complaint);
        viewComplaint1=(Button)v.findViewById(R.id.view_complaint1);


        viewComplaint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyelectricalpendingComplaintDetailsList.class));
            }


        });

        viewComplaint1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyplumbingpendingComplaintDetailsList.class));
            }


        });


        return v;
    }
}
