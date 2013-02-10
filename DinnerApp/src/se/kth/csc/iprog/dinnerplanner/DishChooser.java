package se.kth.csc.iprog.dinnerplanner;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.os.Bundle;

public class DishChooser extends Activity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		int type          = this.getIntent().getIntExtra("init", 1);
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		new DishChooserController(new DishChooserView(this, model, type));
	}
	
}
