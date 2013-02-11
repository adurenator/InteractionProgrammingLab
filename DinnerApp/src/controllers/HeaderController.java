package controllers;

import se.kth.csc.iprog.dinnerplanner.GuestSelection_Activity;
import se.kth.csc.iprog.dinnerplanner.Ingredients;
import se.kth.csc.iprog.dinnerplanner.R;
import views.HeaderView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class HeaderController implements OnClickListener{
	
	private Activity activity;
	
	public HeaderController(HeaderView hv, Activity activity){
		
		this.activity = activity;
		
		hv.guests_button.setOnClickListener(this);
		hv.summary_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.guests_button:
			SuperController.changeActivity(activity, GuestSelection_Activity.class, false, null);
			break;
		case R.id.ingredients_button:
			SuperController.changeActivity(activity, Ingredients.class, true, null);
			break;
		default:
			break;
		}
		
	}
	
}
