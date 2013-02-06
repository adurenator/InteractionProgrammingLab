package se.kth.csc.iprog.dinnerplanner;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.widget.ListView;

public class DishChooserView implements Observer {
	
	Activity activity;
	DinnerModel model;
	
	ListView dishList;
	
	public DishChooserView(Activity activity, DinnerModel model)
	{
		this.activity = activity;
		this.model    = model;
		this.activity.setContentView(R.layout.dish_list_pattern);
		
		dishList = (ListView) activity.findViewById(R.id.dish_list);
		
		model.addObserver(this);
	}
	
	public void changeListToShow(int type)
	{
		
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		
	}
	

}
