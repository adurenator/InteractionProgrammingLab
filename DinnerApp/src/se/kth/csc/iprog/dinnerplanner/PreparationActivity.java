package se.kth.csc.iprog.dinnerplanner;

import controllers.HeaderController;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.HeaderView;
import views.PreparationView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PreparationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preparation);
		
		// To get the dinner model you can use the following code:
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		// Add the preparation view
		new PreparationView(this, model);
		
		// Add a header
		new HeaderController(new HeaderView(this, model), this);
		
		// Add a footer
		// TODO
		
		model.requestNotification();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
