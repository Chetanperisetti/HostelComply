package my.hostelcomply.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.hostelcomply.app.electricianPanel.Electrical_Hostel_layout;
import my.hostelcomply.app.electricianPanel.ElectricianPendingComplaintsFragment;
import my.hostelcomply.app.electricianPanel.ElectricianSolvedComplaintFragment;

public class ElectricianPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.electrician_button_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.pendincomplaints) {
            fragment = new ElectricianPendingComplaintsFragment();
        } else if (itemId == R.id.solvedcomplaints) {
            fragment = new ElectricianSolvedComplaintFragment();
        }
        else if (itemId == R.id.Hostellayout) {
            fragment = new Electrical_Hostel_layout();
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