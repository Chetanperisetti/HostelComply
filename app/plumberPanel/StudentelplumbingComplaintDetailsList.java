package my.hostelcomply.app.plumberPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import my.hostelcomply.app.R;
import my.hostelcomply.app.studentPanel.StudentComplaintDetails;

public class StudentelplumbingComplaintDetailsList extends AppCompatActivity {



    RecyclerView recyclerView;
    DatabaseReference database;
    StudentplumbingComplaintDetailsAdapter studentplumbingComplaintDetailsAdapter;
    ArrayList<StudentPlumbingComplaintDetails> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentelplumbing_complaint_details_list);

        recyclerView = findViewById(R.id.StudentelplumbingComplaintDetailsList);
        database = FirebaseDatabase.getInstance().getReference("StudentPlumbingComplaintDetails");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        studentplumbingComplaintDetailsAdapter = new StudentplumbingComplaintDetailsAdapter(this, list);
        recyclerView.setAdapter(studentplumbingComplaintDetailsAdapter);

        // Retrieve data from Firebase
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear(); // Clear the list before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Get data from each complaint entry
                    String desc = dataSnapshot.child("desc").getValue(String.class);
                    String fname = dataSnapshot.child("fname").getValue(String.class);
                    String phonenumber = dataSnapshot.child("phonenumber").getValue(String.class);
                    String problemitem = dataSnapshot.child("problemitem").getValue(String.class);
                    String randomUid = dataSnapshot.child("randomUid").getValue(String.class);
                    String roomnumber = dataSnapshot.child("roomnumber").getValue(String.class);
                    String studentId = dataSnapshot.child("studentId").getValue(String.class);
                    String status=dataSnapshot.child("status").getValue(String.class);
                    String washroomNumber=dataSnapshot.child("washroomNumber").getValue(String.class);

                    // Create StudentelectricalComplaintDetails object
                    StudentPlumbingComplaintDetails complaintDetails = new StudentPlumbingComplaintDetails(fname, roomnumber, phonenumber, problemitem, desc, randomUid, status,studentId,washroomNumber);

                    //    public StudentPlumbingComplaintDetails(String fname,String roomnumber,String phonenumber,String problemitem, String desc,String randomUid, String status,String studentId,String washroomNumber) {
                    if(complaintDetails.getStatus().equals("p")){
                        list.add(complaintDetails);
                    }


                    // Add the object to the list

                }
                // Notify adapter about data changes
                studentplumbingComplaintDetailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });
        studentplumbingComplaintDetailsAdapter = new StudentplumbingComplaintDetailsAdapter(this, list);
        recyclerView.setAdapter(studentplumbingComplaintDetailsAdapter);
    }
}