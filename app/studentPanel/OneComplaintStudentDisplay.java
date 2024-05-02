package my.hostelcomply.app.studentPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import my.hostelcomply.app.R;
import my.hostelcomply.app.electricianPanel.OneComplaintDisplay;

public class OneComplaintStudentDisplay extends AppCompatActivity {

    DatabaseReference databaseReference;
    DatabaseReference dr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_complaint_student_display);

        databaseReference = FirebaseDatabase.getInstance().getReference("StudentelectricalComplaintDetailswithdate");
        dr = FirebaseDatabase.getInstance().getReference("StudentelectricalComplaintDetails");


        // Retrieve data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstname = extras.getString("firstname");
            String problemItem = extras.getString("problem_item");
            String description = extras.getString("description");
            String roomNumber = extras.getString("roomnumber");
            String phoneNumber = extras.getString("phonenumber");
            String studentId = extras.getString("studentId");
            String date = extras.getString("date");
            String time = extras.getString("time");
            String status=extras.getString("status");
            String key=extras.getString("key");
            String randomUid=extras.getString("randomUid");




            // Display data in TextViews
            TextView firstNameTextView = findViewById(R.id.firstNameTextView);
            TextView problemItemTextView = findViewById(R.id.problemItemTextView);
            TextView descriptionTextView = findViewById(R.id.descriptionTextView);
            TextView roomNumberTextView = findViewById(R.id.roomNumberTextView);
            TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
            TextView dateTextView = findViewById(R.id.dateTextView);
            TextView timeTextView = findViewById(R.id.timeTextView);



            firstNameTextView.setText(firstname);
            problemItemTextView.setText(problemItem);
            descriptionTextView.setText(description);
            roomNumberTextView.setText(roomNumber);
            phoneNumberTextView.setText(phoneNumber);
            dateTextView.setText(date);
            timeTextView.setText(time);


            Button saveButton = findViewById(R.id.saveButton);
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Update status to "solved" in Firebase
                    databaseReference.child(key).child("status").setValue("solved");
                    dr.child(randomUid).child("status").setValue("solved");

                    // You can also add a toast or a confirmation message here if needed
                }
            });

        }

    }

}