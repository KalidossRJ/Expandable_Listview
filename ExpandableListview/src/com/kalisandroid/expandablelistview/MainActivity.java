package com.kalisandroid.expandablelistview;

import info.androidhive.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	boolean ischecked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);
		
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
			int previousGroup = -1;

			@Override
			public void onGroupExpand(int groupPosition) 
			{
				if(groupPosition != previousGroup)
					expListView.collapseGroup(previousGroup);
				previousGroup = groupPosition;
			}
		});

		/*// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});*/

		// Listview Group expanded listener
		/*expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});*/

		// Listview Group collasped listener
		/*expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});*/

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {
			TextView a;
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				
				
				
				/*if(ischecked){
					a=(TextView)v.findViewWithTag(v);
					a.setTextColor(0xFF000000);
				}else{
				//	a.setTextColor(0xFFFFFFFF);
					ischecked=true;
				}*/
				
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("India");
		listDataHeader.add("Pakistan");
		listDataHeader.add("Srilanka");
		listDataHeader.add("Chinna");

		// Adding child data
		List<String> India = new ArrayList<String>();
		India.add("Chennai");
		India.add("New Delhi");
		India.add("Mumbai");
		India.add("Kolkata");
		India.add("Bangalore");
		India.add("Hyderabad");

		List<String> Pakistan = new ArrayList<String>();
		Pakistan.add("Karachi");
		Pakistan.add("Lahore");
		Pakistan.add("Faisalabad");
		Pakistan.add("Rawalpindi");

		List<String> Srilanka = new ArrayList<String>();
		Srilanka.add("Colombo");
		Srilanka.add("Jaffna");
		Srilanka.add("Kandy");
		Srilanka.add("Negombo");
		Srilanka.add("Talawakele");
		
		List<String> Chinna = new ArrayList<String>();
		Chinna.add("Beijing");
		Chinna.add("Shanghai");
		Chinna.add("Chongqing");
		Chinna.add("Hong Kong");
		Chinna.add("Guangzhou");

		listDataChild.put(listDataHeader.get(0), India); // Header, Child data
		listDataChild.put(listDataHeader.get(1), Pakistan);
		listDataChild.put(listDataHeader.get(2), Srilanka);
		listDataChild.put(listDataHeader.get(3), Chinna);
	}
}
