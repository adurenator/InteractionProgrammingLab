package views;

import java.util.ArrayList;
import java.util.Set;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import se.kth.csc.iprog.dinnerplanner.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class DescriptionPopupView
{
	public TextView title;
	public TextView ingredients;
	public TextView instructions;
	
	public Button back;
	public ImageView img;
	
	public Activity a;
	public DinnerModel model;
	
	public DescriptionPopupView(Activity a, DinnerModel model, int dishType, String dishName)
	{
		this.a     = a;
		this.model = model;
		
		title        = (TextView) a.findViewById(R.id.description_popup_title);
		ingredients  = (TextView) a.findViewById(R.id.description_popup_ingredients);
		instructions = (TextView) a.findViewById(R.id.description_popup_instructions);
		img          = (ImageView) a.findViewById(R.id.description_popup_image);
		back         = (Button) a.findViewById(R.id.description_popup_back);
		
		// Get the dish
		Set<Dish> sd = model.getDishesOfType(dishType);
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
}
