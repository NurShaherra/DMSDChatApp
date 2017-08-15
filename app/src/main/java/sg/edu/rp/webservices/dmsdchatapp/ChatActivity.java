package sg.edu.rp.webservices.dmsdchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

public class ChatActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TextView tvWeather = (TextView) findViewById(R.id.tvWeather);
        Button btnAdd = (Button) findViewById(R.id.btnAddMessage);
        EditText etMessage = (EditText) findViewById(R.id.etMessage);
        Intent i = getIntent();


        HttpRequest request= new HttpRequest("https://api.data.gov.sg/v1/environment/2-hour-weather-forecast");
        request.setMethod("GET");
//        request.setAPIKey("api-key", "dHAzdxyyUOsp2YX2qaApuRgVbsJTTcnT");
        request.execute();
        try {

//            String jsonString = request.getResponse();
//            JSONObject jsonObject = new JSONObject(jsonString);
//            JSONObject jObj = jsonObject.getJSONArray("items");






        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {

            mAuth.signOut();

            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
