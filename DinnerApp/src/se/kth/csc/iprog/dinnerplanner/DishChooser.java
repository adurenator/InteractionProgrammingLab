package se.kth.csc.iprog.dinnerplanner;

import java.util.ArrayList;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import ExtendedClasses.ImageArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class DishChooser extends Activity
{
	
	private int type;
	
	private DinnerModel model;
	private Set<Dish> list;
	
	private TextView g;
	private TextView p;
	private TextView t;
	
	private Button s;
	private Button n;
	private Button b;
	
	private ListView lv;
	
	ImageArrayAdapter aa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish_list_pattern);
		initLayout();
	}
	
	/***************************************************************/
	/** PRIVATE METHODS ********************************************/
	/***************************************************************/
	
	private void initLayout()
	{
		model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		g = (TextView) findViewById(R.id.guests_number);
		p = (TextView) findViewById(R.id.total_price);
		t = (TextView) findViewById(R.id.dish_list_pattern_title);
		
		s = (Button) findViewById(R.id.button1);
		s.setOnClickListener(summaryListener);
		n = (Button) findViewById(R.id.next_button);
		n.setOnClickListener(nextListener);
		b = (Button) findViewById(R.id.back_button);
		b.setOnClickListener(backListener);
		
		// initial setting
		g.setText(Integer.toString(model.getNumberOfGuests()));
		p.setText(Float.toString(model.getTotalMenuPrice()));
		
	    lv = (ListView) findViewById(R.id.dish_list);
	    lv.setOnItemClickListener(itemClickListener);
		
		// initially, load the appetizer view
		type = 1;
		setDishInfo();
	}
	
	private void setDishInfo()
	{
		list = model.getDishesOfType(type);
		ArrayList<Dish> list1 = formatDishes();
		aa = new ImageArrayAdapter(this, android.R.layout.simple_list_item_single_choice, list1);
		
		switch (type) {
			case 1:
				t.setText("Choose Appetizer"); break;
			case 2:
				t.setText("Choose Main Course"); break;
			case 3:
				t.setText("Choose Dessert"); break;
			default:
				break;
		}
		
		// for some reason, it does not detect a click to any option in list
		lv.setOnItemClickListener(itemClickListener);
		lv.setAdapter(aa);
	}
	
	private ArrayList<Dish> formatDishes()
	{
		ArrayList<Dish> ret = new ArrayList<Dish>();
		for (Dish d : list) { ret.add(d); }
		return ret;
	}
	
	
	/***************************************************************/
	/** LISTENERS **************************************************/
	/***************************************************************/
	
	private OnClickListener summaryListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			
		}
	};
	
	private OnClickListener nextListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			if (type < 3) ++type;
			setDishInfo();
		}
	};
	
	private OnClickListener backListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			if (type > 1) --type;
			setDishInfo();
		}
	};
	
	private OnItemClickListener itemClickListener = new OnItemClickListener()
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			Toast.makeText(getApplicationContext(), ("Clicked on element no " + position), Toast.LENGTH_SHORT).show();
		}
	};
}
