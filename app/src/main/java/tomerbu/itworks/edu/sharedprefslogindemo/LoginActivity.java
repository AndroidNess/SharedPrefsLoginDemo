package tomerbu.itworks.edu.sharedprefslogindemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText etName, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().length()>3
                        &&
                    etPass.getText().toString().length()>3){
                    SharedPreferences.Editor editor =
                            getSharedPreferences("Users", MODE_PRIVATE).edit();

                    editor.putString("userName", etName.getText().toString());
                    editor.putString("password", etPass.getText().toString());
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Intent mainActivityIntent = new Intent(getApplicationContext(),
                            MainActivity.class);
                    startActivity(mainActivityIntent);
                }
                else
                {
                    etName.setError("Must be at least 3 characters.");
                    etPass.setError("Must be at least 3 characters.");
                }
            }
        });
    }

}
