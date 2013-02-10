package ExtendedClasses;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ImageArrayAdapter extends ArrayAdapter<Dish> {
	
	private ArrayList<Dish> l;
	
	public ImageArrayAdapter(Context context, int textViewResourceId, ArrayList<Dish> objects) {
		super(context, textViewResourceId, objects);
		this.l = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.row, parent, false);
		
		Dish d = l.get(position);
		if (d != null) {
			//ImageView i1 = (ImageView) row.findViewById(R.id.row_image);
			TextView t1 = (TextView) row.findViewById(R.id.row_title);
			//TextView t2 = (TextView) row.findViewById(R.id.row_description);
			
			t1.setText(d.getName());
			//t2.setText(d.getDescription());
		}
		
		return row;
	}

}
