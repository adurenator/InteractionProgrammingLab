package se.kth.csc.iprog.dinnerplanner;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class Ingredients extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingredients);
		
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		/*TextView price = (TextView) findViewById(R.id.total_price);
		price.setText(""+model.getTotalMenuPrice()+'$');  //TODO how to reference to @string/currency ?
		
		TextView guestsN = (TextView) findViewById(R.id.guests_number);
		guestsN.setText(""+model.getNumberOfGuests());*/
		
		HeaderView hfc = new HeaderView(this, model);
		hfc.updateHeaderFields();
		
		//Get all the table layout inside the ScrollView
		TableLayout ingredientsList = (TableLayout) findViewById(R.id.ingredients_table);
		//Iterate over all the ingredients
		for(Ingredient ingr: model.getAllIngredients()){
			//Load the view from the ingredients_row layout file
		    View ingredientView = getLayoutInflater().inflate(R.layout.activity_ingredients_row, null);
		    //Get the TextView from the specific ingredientView that should hold the name
		    TextView ingredientName = (TextView) ingredientView.findViewById(R.id.Name);
		    //Set the ingredient name to that view
		    ingredientName.setText(ingr.getName());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientQuantity = (TextView) ingredientView.findViewById(R.id.Quantity);
		    //Set the ingredient quantity and unit to that view
		    ingredientQuantity.setText(ingr.getQuantity()+" "+ingr.getUnit());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientCost = (TextView) ingredientView.findViewById(R.id.Cost);
		    //Set the ingredient quantity and unit to that view
		    ingredientCost.setText(Double.toString(ingr.getPrice()));  //TODO how to reference to @string/currency ?
		    //Add the dishView to the scroll view's linear layout
		    ingredientsList.addView(ingredientView); 
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
