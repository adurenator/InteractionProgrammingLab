package controllers;

import se.kth.csc.iprog.dinnerplanner.DescriptionPopup;
import views.DishChooserView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DishChooserController implements OnItemClickListener, OnItemLongClickListener {

	private DishChooserView dcv;
	private int selpos;
	
	public DishChooserController(DishChooserView dcv)
	{
		this.dcv = dcv;
		this.dcv.dishList.setOnItemClickListener(this);
		this.dcv.dishList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		selpos = -1;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// marks the selected dish and updates the model
		Log.v("DinnerApp", "Clicked element " + position);
		
		// deselect the previously selected dish if any
		if (selpos != -1) {
			RelativeLayout rv = (RelativeLayout) dcv.dishList.getChildAt(selpos);
			RadioButton rb = (RadioButton) rv.getChildAt(0);
			rb.setChecked(false);
		}
		
		// select the new one and update de model
		((RadioButton)((RelativeLayout) view).getChildAt(0)).setChecked(true);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	{
		SuperController.ExtraContent ec[] = new SuperController.ExtraContent[2];
		ec[0].name  = "type";
		ec[1].extra = Integer.toString(dcv.type);
		ec[1].name  = "name";
		ec[1].extra = ((TextView)((RelativeLayout) view).getChildAt(2)).getText().toString();
		
		SuperController.changeActivity(dcv.activity, DescriptionPopup.class, true, ec);
		
		return true;
	}

}
