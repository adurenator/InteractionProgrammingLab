package se.kth.csc.iprog.dinnerplanner;

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

public class ExpandableMenuAdapter extends BaseExpandableListAdapter {
	
	// The names of the different dinner types.
	final String[] DINNER_TYPE_NAMES = { "Starter", "Main", "Desert" };
	
	private Context context;
	private DinnerModel model;
	
	public ExpandableMenuAdapter(Context context, DinnerModel model) {
		this.context = context;
		this.model = model;
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
		
		Dish dish = (Dish) model.getSelectedDish(groupPosition + 1);
		
		if(dish != null) {
			ImageView imageView = (ImageView) convertView.findViewById(R.id.preparation_dish_image);
			Resources resource = context.getResources();
			int id = context.getResources().getIdentifier(
					dish.getImage().substring(0, dish.getImage().lastIndexOf(".")),
					"drawable", context.getPackageName());
			imageView.setImageDrawable(resource.getDrawable(id));
			
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
		if(model.getSelectedDish(groupPosition + 1) != null) {
			// There is only one dish per dinner type.
			return 1;
		}
		return 0;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupPosition;
	}

	@Override
	public int getGroupCount() {
		return DINNER_TYPE_NAMES.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		String text = DINNER_TYPE_NAMES[groupPosition];
		
		if(model.getSelectedDish(groupPosition + 1) != null) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

}
