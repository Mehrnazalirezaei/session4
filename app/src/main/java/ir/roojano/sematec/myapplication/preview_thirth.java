package ir.roojano.sematec.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class preview_thirth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_thirth);
        TextView nameTxt = findViewById(R.id.nameTxt);
        TextView familyTxt = findViewById(R.id.familyTxt);
        TextView mailTxt = findViewById(R.id.mailTxt);
        TextView phoneTxt = findViewById(R.id.phoneTxt);
        Button editBtn = findViewById(R.id.editBtn);
        Button saveBtn = findViewById(R.id.saveBtn);

        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        final String family = i.getStringExtra("family");
        final String mail = i.getStringExtra("mail");
        final String phone = i.getStringExtra("phone");
        Boolean showProfile = i.getBooleanExtra("showProfile", false);

        nameTxt.setText(name);
        familyTxt.setText(family);
        mailTxt.setText(mail);
        phoneTxt.setText(phone);

        if (showProfile) {
            editBtn.setVisibility(View.GONE);
            saveBtn.setVisibility(View.GONE);
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saving anything!
                PreferenceManager.getDefaultSharedPreferences(preview_thirth.this).edit().putString("name", name).apply();
                PreferenceManager.getDefaultSharedPreferences(preview_thirth.this).edit().putString("family", family).apply();
                PreferenceManager.getDefaultSharedPreferences(preview_thirth.this).edit().putString("mail", mail).apply();
                PreferenceManager.getDefaultSharedPreferences(preview_thirth.this).edit().putString("phone", phone).apply();

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }
        });
    }
}
