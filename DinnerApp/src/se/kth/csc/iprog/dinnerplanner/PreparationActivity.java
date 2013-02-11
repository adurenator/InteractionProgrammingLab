package se.kth.csc.iprog.dinnerplanner;

import java.util.ArrayList;

import controllers.FooterController;
import controllers.HeaderController;
import controllers.SuperController;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.FooterView;
import views.HeaderView;
import views.PreparationView;

import Interfaces.FooterInterface;
import Types.ExtraContent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PreparationActivity extends Activity implements FooterInterface {

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
		new FooterController(new FooterView(this, true, false), this);
		
		model.requestNotification();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void performNext() {
		// Do nothing (end of line)
	}

	@Override
	public void performBack() {
		ArrayList<ExtraContent> ec = new ArrayList<ExtraContent>();
		ExtraContent ec1 = new ExtraContent();
		ec1.name = "init";
		ec1.extra = "3";
		ec.add(ec1);
		SuperController.changeActivity(this, DishChooser.class, false, ec);  //TODO something 
	}

}
