package ca.bcit.kang_virdee;

import android.content.Intent;
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
    private ArrayList<NHLRoster> teamRoster;
    private ListView lv;
    private final String TAG = PlayerActivity.class.getSimpleName();
    private String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
        teamRoster = new ArrayList<>();

        String id = "" + getIntent().getExtras().get("id");
        int idNum = Integer.parseInt(id) + 1;
        BASE_URL = SERVICE_URL + idNum + "/roster";

        lv = findViewById(R.id.roster);
        lv.setOnItemClickListener((adapterView, view, position, idPlayer) -> {
            int idP = teamRoster.get(position).getPerson().getId();
            Intent i = new Intent(RosterActivity.this, PlayerActivity.class);
            i.putExtra("idPlayer", idP);
            startActivity(i);
        });
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
                // a JSON object that looks like this { "roster": . . . . }
                //jsonStr = "{\"roster\":" + jsonStr + "}";
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
