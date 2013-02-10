package views;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import ExtendedClasses.ImageArrayAdapter;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

public class DishChooserView implements Observer {
	
	public Activity activity;
	public DinnerModel model;
	
	public ListView dishList;
	public TextView t;
	
	private Set<Dish> list;
	public ArrayList<Dish> list1;
	private ImageArrayAdapter aa;
	public int type;
	
	public DishChooserView(Activity activity, DinnerModel model, int initialScreen)
	{
		this.activity = activity;
		this.model    = model;
		this.type     = initialScreen;
		
		initLayout();
		
		model.addObserver(this);
	}
	
	private void initLayout()
	{		
		t        = (TextView) activity.findViewById(R.id.dish_list_pattern_title);
		dishList = (ListView) activity.findViewById(R.id.dish_list);
		
		setDishInfo();
	}
	
	/*************************************************************************/
	/** LAYOUT UPDATING METHODS **********************************************/
	/*************************************************************************/
	
	private void setDishInfo()
	{
		list  = model.getDishesOfType(type);
		list1 = formatDishes();
		aa    = new ImageArrayAdapter(activity.getApplicationContext(), android.R.layout.simple_list_item_single_choice, list1);
		
		switch (type) {
			case 1:
				t.setText("Choose Appetizer"); break;
			case 2:
				t.setText("Choose Main Course"); break;
			case 3:
				t.setText("Choose Dessert"); break;
			default:
				break;
		}
		
		dishList.setAdapter(aa);
	}
	
	private ArrayList<Dish> formatDishes()
	{
		ArrayList<Dish> ret = new ArrayList<Dish>();
		for (Dish d : list) { ret.add(d); }
		return ret;
	}
	
	
	/*************************************************************************/
	/** PUBLIC METHODS *******************************************************/
	/*************************************************************************/
	
	/**
	 * Changes the internal view of the activity forward.
	 * @return Returns whether the view class performed an action.
	 */
	public boolean performNext()
	{
		if (type < 3) {
			++type;
			setDishInfo();
			return true;
		}
		return false;
	}
	
	/**
	 * Changes the internal view of the activity backward.
	 * @return Returns whether the view class performed an action.
	 */
	public boolean performBack()
	{
		if (type > 1) {
			--type;
			setDishInfo();
			return true;
		}
		return false;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// there is no activity nor code that changes the model contents, so
		// there is nothing to do here.
	}
	

}
