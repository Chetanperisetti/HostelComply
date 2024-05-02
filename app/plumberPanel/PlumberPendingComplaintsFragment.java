package my.hostelcomply.app.plumberPanel;

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

public class PlumberPendingComplaintsFragment extends Fragment {

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
                startActivity(new Intent(getContext(), StudentelplumbingComplaintDetailsList.class));
            }


        });
        return v;
    }
}
