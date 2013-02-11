package controllers;

import java.util.ArrayList;
import java.util.Collections;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import views.IngredientsView;
import Types.SortType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class IngredientsController implements OnClickListener{

	IngredientsView iv;
	SortType orderedBy;
	boolean ascendant;
	
	public IngredientsController(IngredientsView iv){
		this.iv=iv;
		iv.sort_name_button.setOnClickListener(this);
		iv.sort_quantity_button.setOnClickListener(this);
		iv.sort_cost_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		ArrayList<Ingredient> allIngredients = null;
		if(v.getId()==iv.sort_name_button.getId()){
			allIngredients=iv.model.getAllIngredients(SortType.Name);
			if(orderedBy!=null && orderedBy==SortType.Name){
				if(ascendant)
					Collections.reverse(allIngredients);
				ascendant=!ascendant;
			}else{
				ascendant=true;
				orderedBy=SortType.Name;
			}			
		} else if(v.getId()==iv.sort_quantity_button.getId()){
			allIngredients=iv.model.getAllIngredients(SortType.Quantity);
			if(orderedBy!=null && orderedBy==SortType.Quantity){
				if(ascendant)
					Collections.reverse(allIngredients);
				ascendant=!ascendant;
			}else{
				ascendant=true;
				orderedBy=SortType.Quantity;
			}	
		} else if(v.getId()==iv.sort_cost_button.getId()){
			allIngredients=iv.model.getAllIngredients(SortType.Cost);
			if(orderedBy!=null && orderedBy==SortType.Cost){
				if(ascendant)
					Collections.reverse(allIngredients);
				ascendant=!ascendant;
			}else{
				ascendant=true;
				orderedBy=SortType.Cost;
			}	
		}
		
		
		//Get all the table layout inside the ScrollView
		TableLayout ingredientsList = (TableLayout) iv.activity.findViewById(R.id.ingredients_table);
		//we save the table_header
		TableRow table_header = (TableRow) iv.activity.findViewById(R.id.table_header);
		//remove all the old rows
		ingredientsList.removeAllViews();
		//we add the table header
		ingredientsList.addView(table_header);
		//get the number of guests
		int guests = Integer.parseInt(((Button)iv.activity.findViewById(R.id.guests_button)).getText().toString());
		
		//Iterate over all the ingredients
		for(Ingredient ingr: allIngredients){
			//Load the view from the ingredients_row layout file
		    View ingredientView = iv.activity.getLayoutInflater().inflate(R.layout.activity_ingredients_row, null);
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
