package se.kth.csc.iprog.dinnerplanner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class DishChooserController implements OnItemClickListener {

	private DishChooserView dcv;
	
	public DishChooserController(DishChooserView dcv)
	{
		this.dcv.dishList.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		
	}

}
