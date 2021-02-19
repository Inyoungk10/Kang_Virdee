package ca.bcit.kang_virdee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NHLRosterAdapter extends ArrayAdapter<NHLRoster> {
    Context _context;

    public NHLRosterAdapter(Context context, ArrayList<NHLRoster> roster) {
        super(context, 0, roster);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        NHLRoster roster = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.screen_two_layout, parent, false);
        }

        // Lookup view for data population
        TextView rosterTextView = convertView.findViewById(R.id.roster);

        // Populate the data into the template view using the data object
        rosterTextView.setText(roster.getPerson().getFullName());

        // Return the completed view to render on screen
        return convertView;
    }
}