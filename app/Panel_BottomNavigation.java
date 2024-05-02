package my.hostelcomply.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.hostelcomply.app.studentPanel.StudentComplaintFragment;
import my.hostelcomply.app.studentPanel.StudentHomeFragment;
import my.hostelcomply.app.studentPanel.StudentPendingComplaintFragment;
import my.hostelcomply.app.studentPanel.StudentProfileFragment;

public class Panel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_bottom_navigation);
        BottomNavigationView navigationView=findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        loadstudentfragment(new StudentHomeFragment());
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.studentHome) {
            fragment = new StudentHomeFragment();
        } else if (itemId == R.id.PendingComplaints) {
            fragment = new StudentPendingComplaintFragment();
        } else if (itemId == R.id.Complaints) {
            fragment = new StudentComplaintFragment();
        } else if (itemId == R.id.Profile) {
            fragment = new StudentProfileFragment();
        }

        return loadstudentfragment(fragment);
    }


    private boolean loadstudentfragment(Fragment fragment) {
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
            return true;
        }
        return false;
    }
}