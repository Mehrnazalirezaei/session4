package ir.roojano.sematec.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register02);
        final EditText nameEdt = findViewById(R.id.nameEdt);
        final EditText familyEdt = findViewById(R.id.familyEdt);
        final EditText mailEdt = findViewById(R.id.mailEdt);
        final EditText phoneEdt = findViewById(R.id.Edit_Call);

        Button previewBtn = findViewById(R.id.previewBtn);
        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String family = familyEdt.getText().toString();
                String mail = mailEdt.getText().toString();
                String phone = phoneEdt.getText().toString();
                if ((!name.matches("")) && (!family.matches("")) && (!mail.matches("")) && (!phone.matches("")))
                {
                    Log.d("register", "Complite!!");
                    Intent preview = new Intent(register02.this, preview_thirth.class);
                    preview.putExtra("name", name);
                    preview.putExtra("family", family);
                    preview.putExtra("mail", mail);
                    preview.putExtra("phone", phone);
                    startActivityForResult(preview, 1000);
                }
                else {
                    Log.d("register", "Not Complite!");
                    Toast.makeText(register02.this, "", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1000) && (resultCode == Activity.RESULT_OK)) {
            Log.d("register", "user saved his data!");

            EditText nameEdt = findViewById(R.id.nameEdt);
            EditText familyEdt = findViewById(R.id.familyEdt);
            EditText mailEdt = findViewById(R.id.mailEdt);
            EditText phoneEdt = findViewById(R.id.Edit_Call);

            nameEdt.setText("");
            familyEdt.setText("");
            mailEdt.setText("");
            phoneEdt.setText("");

            Toast.makeText(register02.this, "Saved!", Toast.LENGTH_SHORT).show();
        }
    }}



