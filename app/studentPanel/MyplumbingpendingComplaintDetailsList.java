package my.hostelcomply.app.studentPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import my.hostelcomply.app.R;
import my.hostelcomply.app.electricianPanel.StudentelectricalComplaintDetailswithdate;
import my.hostelcomply.app.plumberPanel.StudentplumbingComplaintDetailswithdate;

public class MyplumbingpendingComplaintDetailsList extends AppCompatActivity {



    RecyclerView recyclerView;
    DatabaseReference database;
    StudentPComplaintDetailsAdapter studentpComplaintDetailsAdapter;
    ArrayList<StudentplumbingComplaintDetailswithdate> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplumbingpending_complaint_details_list);

        recyclerView = findViewById(R.id.MyplumbingpendingComplaintDetailsList);
        database = FirebaseDatabase.getInstance().getReference("StudentplumbingComplaintDetailswithdate");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        studentpComplaintDetailsAdapter = new StudentPComplaintDetailsAdapter(this, list);
        recyclerView.setAdapter(studentpComplaintDetailsAdapter);
        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Retrieve data from Firebase
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear(); // Clear the list before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Get data from each complaint entry
                    StudentplumbingComplaintDetailswithdate complaint = dataSnapshot.getValue(StudentplumbingComplaintDetailswithdate.class);
                    if (complaint != null && complaint.getStatus().equals("du")&&complaint.getStudentId().equals(userid)) {
                        list.add(complaint);
                    }
                }
                // Notify adapter about data changes
                studentpComplaintDetailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });
    }
}