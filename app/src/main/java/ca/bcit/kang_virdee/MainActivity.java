package ca.bcit.kang_virdee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    // url to get teams json
    private static String SERVICE_URL = "https://statsapi.web.nhl.com/api/v1/teams/";
    private ArrayList<NHLTeam> nhlTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nhlTeams = new ArrayList<>();
        lv = findViewById(R.id.nhlTeams);
        lv.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent i = new Intent(MainActivity.this, RosterActivity.class);
            adapterView.getItemAtPosition((int)id);
            i.putExtra("id", (int)id);
            startActivity(i);
        });
        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "teams": . . . . }
                //jsonStr = "{\"teams\":" + jsonStr + "}";
                Gson gson = new Gson();
                BaseTeam baseTeam = gson.fromJson(jsonStr, BaseTeam.class);
                nhlTeams = baseTeam.getTeams();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            NHLTeamAdapter adapter = new NHLTeamAdapter(MainActivity.this, nhlTeams);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }
}