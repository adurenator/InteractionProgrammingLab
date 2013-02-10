package controllers;

import java.util.ArrayList;

import controllers.SuperController;
import se.kth.csc.iprog.dinnerplanner.DescriptionPopup;
import views.DishChooserView;
import Types.ExtraContent;
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
		this.dcv.dishList.setOnItemLongClickListener(this);	
		this.dcv.dishList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		selpos = -1;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		Log.v("DinnerApp", "Clicked element " + position);
		
		if (selpos != -1) {
			RelativeLayout rv = (RelativeLayout) dcv.dishList.getChildAt(selpos);
			RadioButton rb = (RadioButton) rv.getChildAt(0);
			rb.setChecked(false);
		}
		
		((RadioButton)((RelativeLayout) view).getChildAt(0)).setChecked(true);
		selpos = position;
		
		switch (dcv.type) {
			case 1:
				dcv.model.setAppetizer(dcv.list1.get(position));
				break;
			case 2:
				dcv.model.setMainCourse(dcv.list1.get(position));
				break;
			case 3:
				dcv.model.setDessert(dcv.list1.get(position));
				break;
			default:
				break;
		}
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	{
		Log.v("DinnerApp", "Item long click in pos: " + position);
		
		ArrayList<ExtraContent> ec = new ArrayList<ExtraContent>();
		
		ExtraContent ec1 = new ExtraContent();
		ec1.name  = "type";
		ec1.extra = Integer.toString(dcv.type);
		ec.add(ec1);
		ExtraContent ec2 = new ExtraContent();
		ec2.name  = "name";
		ec2.extra = ((TextView)((RelativeLayout) view).getChildAt(2)).getText().toString();
		ec.add(ec2);
		
		SuperController.changeActivity(dcv.activity, DescriptionPopup.class, true, ec);
		
		return true;
	}

}
