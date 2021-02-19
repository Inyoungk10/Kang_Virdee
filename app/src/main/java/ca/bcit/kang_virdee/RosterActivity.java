package ca.bcit.kang_virdee;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class RosterActivity extends AppCompatActivity {

    private static String SERVICE_URL = "https://statsapi.web.nhl.com/api/v1/teams/";
    private ArrayList<TeamRoster> teamRoster;
    private ListView lv;
    private final String TAG = RosterActivity.class.getSimpleName();
    private String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BASE_URL = SERVICE_URL + getIntent().getExtras().get("id") + "/roster";

        setContentView(R.layout.activity_roster);
        teamRoster = new ArrayList<>();
        lv = findViewById(R.id.nhlRoster);
        new RosterActivity.GetContacts().execute();

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
            jsonStr = sh.makeServiceCall(BASE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "teams": . . . . }
                //jsonStr = "{\"teams\":" + jsonStr + "}";
                Gson gson = new Gson();
                BaseRoster baseRoster = gson.fromJson(jsonStr, BaseRoster.class);
                teamRoster = baseRoster.getRoster();
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
            NHLRosterAdapter adapter = new NHLRosterAdapter(RosterActivity.this, teamRoster);


            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }
}




    /**private final String TAG = RosterActivity.class.getSimpleName();
    private ListView lv;
    // url to get teams json
    private static String SERVICE_URL = "https://statsapi.web.nhl.com/api/v1/teams/";
    private ArrayList<TeamRoster> teamRoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        teamRoster = new ArrayList<>();
        lv = findViewById(R.id.nhlRoster);
        new RosterActivity.GetContacts().execute();


    }

    /**
     * Async task class to get json by making HTTP call
     */
    /**private class GetContacts extends AsyncTask<Void, Void, Void> {
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
                BaseRoster baseRoster = gson.fromJson(jsonStr, BaseRoster.class);
                teamRoster = baseRoster.getRoster();
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
            NHLRosterAdapter adapter = new NHLRosterAdapter(RosterActivity.this, teamRoster);


            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }


    }*/
