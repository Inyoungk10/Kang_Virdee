package ca.bcit.kang_virdee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NHLPlayerAdapter extends ArrayAdapter<NHLPlayer> {
    Context _context;

    public NHLPlayerAdapter(Context context, ArrayList<NHLPlayer> playerData) {
        super(context, 0, playerData);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        NHLPlayer player = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.screen_three_layout, parent, false);
        }

        // Lookup view for data population
        TextView nameTextView = convertView.findViewById(R.id.fullName);
        TextView teamTextView = convertView.findViewById(R.id.team);
        TextView ageTextView = convertView.findViewById(R.id.currentAge);
        TextView nationalityTextView = convertView.findViewById(R.id.nationality);
        TextView positionTextView = convertView.findViewById(R.id.position);

        // Populate the data into the template view using the data object
        nameTextView.setText(player.getName());
        teamTextView.setText(player.getTeam().getName());
        String age = "" + player.getCurrentAge();
        ageTextView.setText(age);
        nationalityTextView.setText(player.getNationality());
        positionTextView.setText(player.getPos().getPos());

        // Return the completed view to render on screen
        return convertView;
    }
}
