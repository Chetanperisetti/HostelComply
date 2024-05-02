package my.hostelcomply.app.studentPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import my.hostelcomply.app.R;
import my.hostelcomply.app.Student;




public class Student_postplumber_complaint extends AppCompatActivity {
    Button post_complaints;
    DatabaseReference dataaa;
    Spinner ProblemItems,washroomNumberSpinner; ;
    TextInputLayout desc;
    String description, problems,washroomNumber;;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth FAuth;
    String StudentId;
    String Roomnumber, Phonenumber, First_name,status;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_postplumber_complaint);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("StudentPlumbingComplaintDetails");

        ProblemItems= findViewById(R.id.Pitems);
        washroomNumberSpinner = findViewById(R.id.washroomsidenum); // Initialize washroomNumberSpinner

        desc = findViewById(R.id.description);
        post_complaints = findViewById(R.id.post);
        FAuth = FirebaseAuth.getInstance();

        try {
            String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            dataaa = firebaseDatabase.getReference("Student").child(userid);
            dataaa.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Student studentc = dataSnapshot.getValue(Student.class);
                    Roomnumber = studentc.getRoomnumber();
                    Phonenumber = studentc.getMobile_No();
                    First_name = studentc.getFirst_Name();
                    status="p";

                    post_complaints.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            problems = ProblemItems.getSelectedItem().toString().trim();
                            washroomNumber = washroomNumberSpinner.getSelectedItem().toString().trim(); // Get selected washroom number


                            description = desc.getEditText().getText().toString().trim();

                            if (isValid()) {
                                saveComplaint();
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e("DatabaseError", databaseError.getMessage());
                }
            });

        } catch (Exception e) {
            Log.e("Errrrrr: ", e.getMessage());
        }
    }

    private boolean isValid() {
        desc.setErrorEnabled(false);
        desc.setError("");

        boolean isValidDescription = !TextUtils.isEmpty(description);
        if (!isValidDescription) {
            desc.setError("Description is Required");
        }

        return isValidDescription;
    }

    private void saveComplaint() {
        String randomUid = String.valueOf(System.currentTimeMillis()); // Generating unique ID
        StudentId = FirebaseAuth.getInstance().getCurrentUser().getUid();


        StudentpComplaintDetails complaint=new StudentpComplaintDetails(First_name,Roomnumber,Phonenumber,problems, description,randomUid, status,StudentId,washroomNumber);
        databaseReference.child(randomUid).setValue(complaint)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Student_postplumber_complaint.this, "Complaint posted successfully", Toast.LENGTH_SHORT).show();
                            desc.getEditText().setText(""); // Clearing the description field
                        } else {
                            Toast.makeText(Student_postplumber_complaint.this, "Failed to post complaint", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}