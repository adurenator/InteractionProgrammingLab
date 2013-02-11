package views;


import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class IngredientsView implements Observer{

	public DinnerModel model;
	public Activity activity;
	
	public ImageButton sort_name_button;
	public ImageButton sort_quantity_button;
	public ImageButton sort_cost_button;
	
	public IngredientsView(Activity activity, DinnerModel model) {
		
		this.activity=activity;
		this.model=model;
		
		sort_name_button = (ImageButton) activity.findViewById(R.id.sort_name_button);
		sort_quantity_button = (ImageButton) activity.findViewById(R.id.sort_quantity_button);
		sort_cost_button = (ImageButton) activity.findViewById(R.id.sort_cost_button);
		
		initLayout();
		
		model.addObserver(this);
	}

	private void initLayout(){
		
		//Get all the table layout inside the ScrollView
		TableLayout ingredientsList = (TableLayout) activity.findViewById(R.id.ingredients_table);
		//get the number of guests
		int guests = Integer.parseInt(((Button)activity.findViewById(R.id.guests_button)).getText().toString());
		//Iterate over all the ingredients
		for(Ingredient ingr: model.getAllIngredients()){
			//Load the view from the ingredients_row layout file
		    View ingredientView = activity.getLayoutInflater().inflate(R.layout.activity_ingredients_row, null);
		    //Get the TextView from the specific ingredientView that should hold the name
		    TextView ingredientName = (TextView) ingredientView.findViewById(R.id.Name);
		    //Set the ingredient name to that view
		    ingredientName.setText(ingr.getName());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientQuantity = (TextView) ingredientView.findViewById(R.id.Quantity);
		    //Set the ingredient quantity and unit to that view
		    ingredientQuantity.setText(ingr.getQuantity()*guests+" "+ingr.getUnit());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientCost = (TextView) ingredientView.findViewById(R.id.Cost);
		    //Set the ingredient quantity and unit to that view
		    ingredientCost.setText(Double.toString(ingr.getPrice()*guests));  //TODO how to reference to @string/currency ?
		    //Add the dishView to the scroll view's linear layout
		    ingredientsList.addView(ingredientView); 
		}
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		//Get all the table layout inside the ScrollView
		TableLayout ingredientsList = (TableLayout) activity.findViewById(R.id.ingredients_table);
		//we save the table_header
		TableRow table_header = (TableRow) activity.findViewById(R.id.table_header);
		//remove all the old rows
		ingredientsList.removeAllViews();
		//we add the table header
		ingredientsList.addView(table_header);
		//get the number of guests
		int guests = Integer.parseInt(((Button)activity.findViewById(R.id.guests_button)).getText().toString());
		
		//Iterate over all the ingredients
		for(Ingredient ingr: model.getAllIngredients()){
			//Load the view from the ingredients_row layout file
		    View ingredientView = activity.getLayoutInflater().inflate(R.layout.activity_ingredients_row, null);
		    //Get the TextView from the specific ingredientView that should hold the name
		    TextView ingredientName = (TextView) ingredientView.findViewById(R.id.Name);
		    //Set the ingredient name to that view
		    ingredientName.setText(ingr.getName());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientQuantity = (TextView) ingredientView.findViewById(R.id.Quantity);
		    //Set the ingredient quantity and unit to that view
		    ingredientQuantity.setText(ingr.getQuantity()*guests+" "+ingr.getUnit());
		    //Get the TextView from the specific ingredientView that should hold the quantity
		    TextView ingredientCost = (TextView) ingredientView.findViewById(R.id.Cost);
		    //Set the ingredient quantity and unit to that view
		    ingredientCost.setText(Double.toString(ingr.getPrice()*guests));  //TODO how to reference to @string/currency ?
		    //Add the dishView to the scroll view's linear layout
		    ingredientsList.addView(ingredientView); 
		}
		
	}
}
