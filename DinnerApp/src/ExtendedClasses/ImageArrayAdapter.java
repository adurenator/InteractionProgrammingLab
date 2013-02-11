package ExtendedClasses;

import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ImageArrayAdapter extends ArrayAdapter<Dish> {
	
	private Context context;
	private ArrayList<Dish> l;
	
	public ImageArrayAdapter(Context context, int textViewResourceId, ArrayList<Dish> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.l = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.row, parent, false);
		
		Dish d = l.get(position);
		if (d != null) {
			TextView t1 = (TextView) row.findViewById(R.id.row_title);
			t1.setText(d.getName());
			
			// Display image of dish
			ImageView imageView = (ImageView) row.findViewById(R.id.row_image);
			Resources resource = context.getResources();
			int id = context.getResources().getIdentifier(
					d.getImage().substring(0, d.getImage().lastIndexOf(".")),
					"drawable", context.getPackageName());
			imageView.setImageDrawable(resource.getDrawable(id));
		}
		
		return row;
	}

}
