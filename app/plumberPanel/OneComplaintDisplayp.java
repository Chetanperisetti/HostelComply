package my.hostelcomply.app.plumberPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import my.hostelcomply.app.R;
import my.hostelcomply.app.electricianPanel.OneComplaintDisplay;
import my.hostelcomply.app.electricianPanel.StudentelectricalComplaintDetailswithdate;

public class OneComplaintDisplayp extends AppCompatActivity {


    Calendar calendar;

    EditText dateEditText, timeEditText;
    Button saveButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String dateStr, timeStr, status;
    StudentplumbingComplaintDetailswithdate sdw;

    FirebaseAuth mAuth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_complaint_displayp);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        saveButton = findViewById(R.id.saveButton);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("StudentplumbingComplaintDetailswithdate");

        // Initialize the FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        calendar = Calendar.getInstance();
        // Initialize the StudentelectricalComplaintDetailswithdate object
        sdw = new StudentplumbingComplaintDetailswithdate();

        // Retrieve data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstname = extras.getString("firstname");
            String problemItem = extras.getString("problem_item");
            String description = extras.getString("description");
            String roomNumber = extras.getString("roomnumber");
            String phoneNumber = extras.getString("phonenumber");
            String studentId=extras.getString("studentId");
            String randomUid=extras.getString("randomUid");

            String washroomNumber=extras.getString("washroomNumber");


            // Display data in TextViews
            TextView firstNameTextView = findViewById(R.id.firstNameTextView);
            TextView problemItemTextView = findViewById(R.id.problemItemTextView);
            TextView descriptionTextView = findViewById(R.id.descriptionTextView);
            TextView roomNumberTextView = findViewById(R.id.roomNumberTextView);
            TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
            TextView waashroomsideTextView=findViewById(R.id.waashroomsideTextView);
            firstNameTextView.setText(firstname);
            problemItemTextView.setText(problemItem);
            descriptionTextView.setText(description);

            waashroomsideTextView.setText("washroom side"+washroomNumber);
            roomNumberTextView.setText(roomNumber);
            phoneNumberTextView.setText(phoneNumber);


            sdw.setFirstname(firstname);
            sdw.setProblemIte(problemItem);
            sdw.setDescription(description);
            sdw.setRoomNumber(roomNumber);
            sdw.setPhoneNumber(phoneNumber);
            sdw.setStudentId(studentId);
            sdw.setRandomUid(randomUid);
            sdw.setWashroomNumber(washroomNumber);

        }

        status = "du";

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateStr = dateEditText.getText().toString();
                timeStr = timeEditText.getText().toString();

                if (TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(timeStr)) {
                    Toast.makeText(OneComplaintDisplayp.this, "Please enter date and time", Toast.LENGTH_SHORT).show();
                } else {
                    saveComplaint();
                }
            }
        });
    }

    private void saveComplaint() {
        // Get the current user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {

            String electricianPhoneNumber = currentUser.getPhoneNumber();
            String key = databaseReference.push().getKey();

            // Create a new complaint object
            StudentplumbingComplaintDetailswithdate complaintwd = new StudentplumbingComplaintDetailswithdate(dateStr, timeStr, sdw.getFirstname(), sdw.getProblemIte(), sdw.getDescription(), sdw.getRoomNumber(), sdw.getPhoneNumber(), status, sdw.getStudentId(), electricianPhoneNumber,key,sdw.getRandomUid(),sdw.getWashroomNumber());

            // Generate a unique key for the complaint


            if (key != null) {
                // Save the complaint to Firebase
                databaseReference.child(key).setValue(complaintwd)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(OneComplaintDisplayp.this, "Complaint posted successfully", Toast.LENGTH_SHORT).show();
                                    finish(); // Finish the activity after successful posting
                                } else {
                                    Toast.makeText(OneComplaintDisplayp.this, "Failed to post complaint", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                Toast.makeText(OneComplaintDisplayp.this, "Failed to generate unique key", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(OneComplaintDisplayp.this, "Failed to get current user", Toast.LENGTH_SHORT).show();
        }
    }
    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Set the selected date to the EditText
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDateEditText();
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public void showTimePickerDialog(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Set the selected time to the EditText
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        updateTimeEditText();
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);
        timePickerDialog.show();
    }
    private void updateDateEditText() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateEditText.setText(sdf.format(calendar.getTime()));
    }

    private void updateTimeEditText() {
        String myFormat = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        timeEditText.setText(sdf.format(calendar.getTime()));
    }
}