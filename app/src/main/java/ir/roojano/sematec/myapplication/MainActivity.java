package ir.roojano.sematec.myapplication;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final DrawerLayout  drawerLayout = findViewById(R.id.drawer01);
       final Button btn_drawer = findViewById(R.id.Btn_Drawer);
       final TextView Btn_Register = findViewById(R.id.Btn_Register);
       final TextView Btn_Profile  = findViewById(R.id.Btn_Profile);
       final TextView Btn_Call  = findViewById(R.id.Btn_Call);
       btn_drawer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               drawerLayout.openDrawer(Gravity.RIGHT);
           }

       });
        Btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this,register02.class);
                startActivity(register);
                drawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });
        Btn_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showProfile = new Intent(MainActivity.this, preview_thirth.class);
                showProfile.putExtra("name", PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name", ""));
                showProfile.putExtra("family", PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family", ""));
                showProfile.putExtra("mail", PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("mail", ""));
                showProfile.putExtra("phone", PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("phone", ""));
                showProfile.putExtra("showProfile", true);
                startActivity(showProfile);
            }
        });

        Btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(MainActivity.this, Call.class);
                startActivity(dial);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.drawerMenu)
        {
            DrawerLayout mDrawerLayout = findViewById(R.id.drawerLayout);

            if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
            } else mDrawerLayout.openDrawer(Gravity.RIGHT);

        }
        return super.onOptionsItemSelected(item);

    }
}
