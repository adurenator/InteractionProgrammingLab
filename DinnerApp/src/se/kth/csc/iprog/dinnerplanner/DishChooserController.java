package se.kth.csc.iprog.dinnerplanner;

import controllers.SuperController;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;

public class DishChooserController implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener, OnClickListener {

	private DishChooserView dcv;
	
	public DishChooserController(DishChooserView dcv)
	{
		this.dcv = dcv;
		this.dcv.dishList.setOnItemClickListener(this);
		//this.dcv.dishList.setOnItemLongClickListener(this);
		//this.dcv.dishList.setOnItemSelectedListener(this);
		this.dcv.dishList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		//this.dcv.dishList.setOnClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// marks the selected dish and updates the model
		Log.v("DinnerApp", "Clicked element " + position);
		
		// deselect the previously selected dish if any
		
		
		// select the new one and update de model
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		SuperController.performPositive(dcv.activity, "description");
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		Log.v("DinnerApp", "Selected element " + position);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

	@Override
	public void onClick(View v) {
		Log.v("DinnerApp", "Clicked element " + v.getId());
	}

}
