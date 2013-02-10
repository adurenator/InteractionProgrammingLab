package ExtendedClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableMenuAdapter extends BaseExpandableListAdapter implements Observer {
	
	private Context context;
	
	private String[] dinnerTypes;
	private ArrayList<Set<Dish>> dishes;
	
	public ExpandableMenuAdapter(Context context, DinnerModel model) {
		this.context = context;
		dishes = new ArrayList<Set<Dish>>(model.getDinnerTypesCount());
		dinnerTypes = new String[model.getDinnerTypesCount()];
		
		model.addObserver(this);
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_item_child, null);
		}
		
		Dish dish = (Dish) dishes.get(groupPosition).toArray()[childPosition];
		
		if(dish != null) {
			// Display image of dish
			ImageView imageView = (ImageView) convertView.findViewById(R.id.preparation_dish_image);
			Resources resource = context.getResources();
			int id = context.getResources().getIdentifier(
					dish.getImage().substring(0, dish.getImage().lastIndexOf(".")),
					"drawable", context.getPackageName());
			imageView.setImageDrawable(resource.getDrawable(id));
			
			// Display information about the dish
			TextView text;
			text = (TextView) convertView.findViewById(R.id.preparation_dish_name);
			text.setText(dish.getName());
			text = (TextView) convertView.findViewById(R.id.preparation_dish_description);
			text.setText(dish.getDescription());
			return convertView;
		}
		return null;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return dishes.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupPosition;
	}

	@Override
	public int getGroupCount() {
		return dinnerTypes.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		String text = dinnerTypes[groupPosition];
		
		if(dishes.get(groupPosition).size() > 0) {
			convertView = inflater.inflate(R.layout.list_item_group, null);
		} else {
			convertView = inflater.inflate(R.layout.list_item_group_empty, null);
			text += " (not selected)";
		}
		
		TextView textView = (TextView) convertView.findViewById(R.id.list_item_parent);
		textView.setText(text);
		
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
	
	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public void update(Observable observable, Object data) {
		DinnerModel model = (DinnerModel) observable;
		dishes = new ArrayList<Set<Dish>>(model.getDinnerTypesCount());
		dinnerTypes = new String[model.getDinnerTypesCount()];
		
		Set<Dish> menu = model.getFullMenu();
		
		for(int i = 0; i < dinnerTypes.length; i++) {
			dishes.add(new HashSet<Dish>());
			dinnerTypes[i] = model.getDinnerTypeName(i + 1);
		}
		
		for(Dish d : menu) {
			dishes.get(d.getType() - 1).add(d);
		}
	}

}
