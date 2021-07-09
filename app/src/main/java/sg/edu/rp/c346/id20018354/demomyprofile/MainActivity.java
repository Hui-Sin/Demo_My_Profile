package sg.edu.rp.c346.id20018354.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = prefs.edit();

        String strName=etName.getText().toString();
        String strGPA=etGPA.getText().toString();
        float gpa=Float.parseFloat(strGPA);

        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa",gpa);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String strName = prefs.getString("name","No name set");

        float gpa = prefs.getFloat("gpa",0.0f);
        String strGPA = String.valueOf(gpa);

        etName.setText(strName);
        etGPA.setText(strGPA);
    }
}