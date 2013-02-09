package se.kth.csc.iprog.dinnerplanner;





import android.os.Bundle;
import android.app.Activity;

import views.GuestSelection_View;
import controllers.GuestSelection_Controller;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class GuestSelection_Activity extends Activity {

	@Override
	@SuppressWarnings("unused")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest_selection);
		
		// To get the dinner model you can use the following code:
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		// Setting the view and the controller for the start screen.
		GuestSelection_View guestSelection_View = new GuestSelection_View(this);
		GuestSelection_Controller guestSelection_Controller = new GuestSelection_Controller(guestSelection_View, model);
		
	}

}
