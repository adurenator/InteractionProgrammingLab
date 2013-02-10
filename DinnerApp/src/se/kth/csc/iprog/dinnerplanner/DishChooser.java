package se.kth.csc.iprog.dinnerplanner;

import controllers.DishChooserController;
import controllers.FooterController;
import controllers.SuperController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.DishChooserView;
import views.FooterView;
import Interfaces.FooterInterface;
import android.app.Activity;
import android.os.Bundle;

public class DishChooser extends Activity implements FooterInterface
{
	
	private DishChooserView dcv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish_list_pattern);
		
		// depending on which activity was running before, the first
		// view to show may not be the appetizer selection. (type)
		int type          = Integer.parseInt(this.getIntent().getStringExtra("init"));
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		dcv = new DishChooserView(this, model, type);
		new DishChooserController(dcv);
		new FooterController(new FooterView(this), this);
	}

	@Override
	public void performNext()
	{
		if (!dcv.performNext()) {
			// if the view did not perform an internal view change
			// means that the activity must be switched, so the
			// super-controller is called for that purpose
			SuperController.changeActivity(this, PreparationActivity.class, false, null);
		}
	}

	@Override
	public void performBack()
	{
		if (!dcv.performBack()) {
			// if the view did not perform an internal view change
			// means that the activity must be switched, so the
			// super-controller is called for that purpose
			SuperController.changeActivity(this, GuestSelection_Activity.class, false, null);
		}
	}
	
}
