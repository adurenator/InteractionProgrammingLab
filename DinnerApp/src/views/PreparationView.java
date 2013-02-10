package views;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import ExtendedClasses.ExpandableMenuAdapter;
import android.app.Activity;
import android.widget.ExpandableListView;

public class PreparationView {
	
	// Activity used by the view
	public Activity activity;
	
	public PreparationView(Activity activity, DinnerModel model){
		
		// Setting the view and the widgets.
		this.activity = activity;
		
		// Create an expandable list view for the menu
		ExpandableListView exp = (ExpandableListView) activity.findViewById(R.id.expandable_list);
		exp.setAdapter(new ExpandableMenuAdapter(activity, model));
	}
	
}