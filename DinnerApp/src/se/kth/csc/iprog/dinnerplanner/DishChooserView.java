package se.kth.csc.iprog.dinnerplanner;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import ExtendedClasses.ImageArrayAdapter;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

public class DishChooserView implements Observer {
	
	Activity activity;
	DinnerModel model;
	
	ListView dishList;
	TextView t;
	
	private Set<Dish> list;
	private ImageArrayAdapter aa;
	private int type;
	
	public DishChooserView(Activity activity, DinnerModel model, int initialScreen)
	{
		this.activity = activity;
		this.model    = model;
		this.type     = initialScreen;
		this.activity.setContentView(R.layout.dish_list_pattern);
		
		initLayout();
		
		model.addObserver(this);
	}
	
	private void initLayout()
	{		
		t = (TextView) activity.findViewById(R.id.dish_list_pattern_title);
		dishList = (ListView) activity.findViewById(R.id.dish_list);
		
		// initially, load the appetizer view
		setDishInfo();
	}
	
	private void setDishInfo()
	{
		list = model.getDishesOfType(type);
		ArrayList<Dish> list1 = formatDishes();
		aa = new ImageArrayAdapter(activity.getApplicationContext(), android.R.layout.simple_list_item_single_choice, list1);
		
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
		
		// for some reason, it does not detect a click to any option in list
		//dishList.setOnItemClickListener(itemClickListener);
		dishList.setAdapter(aa);
	}
	
	private ArrayList<Dish> formatDishes()
	{
		ArrayList<Dish> ret = new ArrayList<Dish>();
		for (Dish d : list) { ret.add(d); }
		return ret;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		
	}
	

}
