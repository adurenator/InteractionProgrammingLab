package se.kth.csc.iprog.dinnerplanner;

import controllers.FooterController;
import controllers.SuperController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
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
		
		// depending on whitch activity was running before, the first
		// view to show may not be the appetizer selection. (type)
		int type          = this.getIntent().getIntExtra("init", 1);
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		new FooterController(new FooterView(this), this);
		dcv = new DishChooserView(this, model, type);
		new DishChooserController(dcv);
		
	}

	@Override
	public void performNext()
	{
		if (!dcv.performNext()) {
			// if the view did not perform an internal view change
			// means that the activity must be switched, so the
			// super-controller is called for that purpose
			SuperController.performPositive(this, null);
		}
	}

	@Override
	public void performBack()
	{
		if (!dcv.performBack()) {
			// if the view did not perform an internal view change
			// means that the activity must be switched, so the
			// super-controller is called for that purpose
			SuperController.performNegative(this, null);
		}
	}
	
}
