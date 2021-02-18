package ca.bcit.kang_virdee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NHLTeamAdapter extends ArrayAdapter<NHLTeam> {
    Context _context;
    public NHLTeamAdapter(Context context, ArrayList<NHLTeam> teams) {
        super(context, 0, teams);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        NHLTeam team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.screen_one_layout, parent, false);
        }

        // Lookup view for data population
        TextView teamName = convertView.findViewById(R.id.name);

        // Populate the data into the template view using the data object
        teamName.setText(team.getName());

        // Return the completed view to render on screen
        return convertView;
    }
}
