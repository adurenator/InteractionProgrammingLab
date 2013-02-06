package se.kth.csc.iprog.dinnerplanner;

import java.util.ArrayList;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DescriptionPopup extends Activity
{
	
	private DinnerModel model;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description_popup);
		initLayout();
	}
	
	/***************************************************************/
	/** PRIVATE METHODS ********************************************/
	/***************************************************************/
	
	// NOTE:
	// for the second lab "French Toast" will be showed automatically. For the
	// following labs, the name and type of the dish to be shown will be passed through the
	// activity calling intent.
	// The type and name will be used to get the dish and its associated features from
	// the model.
	
	private void initLayout()
	{
		model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		HeaderView hfc = new HeaderView(this, model);
		hfc.updateHeaderFields();
		
		TextView title        = (TextView) findViewById(R.id.description_popup_title);
		TextView ingredients  = (TextView) findViewById(R.id.description_popup_ingredients);
		TextView instructions = (TextView) findViewById(R.id.description_popup_instructions);
		
		//ImageView img = (ImageView) findViewById(R.id.description_popup_image);
		
		Button back = (Button) findViewById(R.id.description_popup_back);
		back.setOnClickListener(clickListener);
		
		// Get the dish
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		Set<Dish> sd = model.getDishesOfType(1);
		ArrayList<Dish> ad = formatDishes(sd);
		Dish d = ad.get(0);
		Set<Ingredient> si = d.getIngredients();
		
		// Load data
		title.setText(d.getName());
		ingredients.setText(formatIngredients(si));
		instructions.setText(d.getDescription());
	}
	
	private ArrayList<Dish> formatDishes(Set<Dish> list)
	{
		ArrayList<Dish> ret = new ArrayList<Dish>();
		for (Dish d : list) { ret.add(d); }
		return ret;
	}
	
	private String formatIngredients(Set<Ingredient> list)
	{
		String ret = "";
		for (Ingredient i : list) {
			String ing = i.getQuantity() + i.getUnit() + " " + i.getName() + "\n";
			ret = ret.concat(ing);
		}
		return ret;
	}
	
	
	/***************************************************************/
	/** LISTENERS **************************************************/
	/***************************************************************/
	
	OnClickListener clickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			finish();
		}
	};
	
}
