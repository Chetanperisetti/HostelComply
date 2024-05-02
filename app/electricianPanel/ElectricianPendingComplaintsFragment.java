package my.hostelcomply.app.electricianPanel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import my.hostelcomply.app.R;
import my.hostelcomply.app.Student;
import my.hostelcomply.app.studentPanel.StudentComplaintDetails;
import my.hostelcomply.app.studentPanel.Student_postComplaint;

public class ElectricianPendingComplaintsFragment extends Fragment{

    Button viewComplaint;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_electrician_pending_complaints,null);
        getActivity().setTitle("View complaints");




        viewComplaint=(Button) v.findViewById(R.id.view_complaint);
        viewComplaint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), StudentelectricalComplaintDetailsList.class));
            }


        });
        return v;
    }
}