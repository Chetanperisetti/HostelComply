package my.hostelcomply.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{
    ImageView imageView;
    TextView textView;
    FirebaseAuth Fauth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Fauth = FirebaseAuth.getInstance();

        imageView.animate().alpha(0f).setDuration(0);

        imageView.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            // onAnimationEnd method
            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation end listener
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if user is already signed in
                FirebaseUser user = Fauth.getCurrentUser();
                if (user != null) {
                    // User is signed in, navigate to MainMenu activity
                    startActivity(new Intent(MainActivity.this, MainMenu.class));
                    finish();
                } else {
                    // User is not signed in, navigate to login activity
                    startActivity(new Intent(MainActivity.this, MainMenu.class));
                    finish();
                }
            }
        }, 3000);

    }
}