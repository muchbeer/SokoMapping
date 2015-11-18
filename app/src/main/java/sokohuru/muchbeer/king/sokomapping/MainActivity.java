package sokohuru.muchbeer.king.sokomapping;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText passwordText, userText, emailText;
     Button _loginButton;
      TextView _signupLink;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _loginButton=(Button)findViewById(R.id.btn_signup);
        passwordText=(EditText)findViewById(R.id.input_password);
        emailText=(EditText)findViewById(R.id.input_email);
        userText=(EditText)findViewById(R.id.input_name);

    //    b2=(Button)findViewById(R.id.button2);
        _signupLink=(TextView)findViewById(R.id.link_login);
        _signupLink.setVisibility(View.GONE);

        _loginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (emailText.getText().toString().equals("admin") &&

                         passwordText.getText().toString().equals("admin")) {
                     Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                     Intent startPage = new Intent(getApplicationContext(), NewPage.class);
                     // Use TaskStackBuilder to build the back stack and get the PendingIntent

                     startActivity(startPage);

                 } else {
                     Toast.makeText(getApplicationContext(), "Wrong Credentials, Please try again", Toast.LENGTH_SHORT).show();

                     passwordText.setText("");
                     emailText.setText("");
                     userText.setText("");
                     _signupLink.setVisibility(View.VISIBLE);
                     _signupLink.setBackgroundColor(Color.WHITE);
                     counter--;

                     if (counter == 0) {
                         _loginButton.setEnabled(false);
                     }
                 }
             }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
