package ir.roojano.sematec.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Call extends AppCompatActivity {

    private View Btn_Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        final EditText phoneEDT = findViewById(R.id.Edit_Call);
        final Button dialBtn = findViewById(R.id.dialBtn);

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneEDT.getText().toString();
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:" + phoneNumber));
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
}