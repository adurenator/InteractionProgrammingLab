package se.kth.csc.iprog.dinnerplanner;

import controllers.DescriptionPopupController;
import controllers.HeaderController;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.DescriptionPopupView;
import views.HeaderView;
import android.app.Activity;
import android.os.Bundle;

public class DescriptionPopup extends Activity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description_popup);
		
		int type          = Integer.parseInt(getIntent().getStringExtra("type"));
		String name       = getIntent().getStringExtra("name");
		String image       = getIntent().getStringExtra("image");
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		new HeaderController(new HeaderView(this, model), this);
		new DescriptionPopupController(new DescriptionPopupView(this, model, type, name, image));
		new HeaderController(new HeaderView(this, model), this);
	}
	
}
