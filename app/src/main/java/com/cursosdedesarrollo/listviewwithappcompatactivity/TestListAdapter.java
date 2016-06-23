package com.cursosdedesarrollo.listviewwithappcompatactivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestListAdapter extends BaseAdapter {
	
	private List<Chorbi> chorbis;
	private Context context;

	public TestListAdapter(Context context, Chorbi [] chorbis) {
		this.chorbis =new ArrayList();
		try{
		for(int i=0;i<chorbis.length;i++){
			this.chorbis.add(chorbis[i]);
		}
		}catch(Exception e){

		}
		this.context = context;
	}
	public TestListAdapter(Context context, List<Chorbi> chorbis) {
		this.chorbis=chorbis;
		this.context = context;
	}

	public int getCount() {
		return chorbis.size();
	}

	public Chorbi getItem(int position) {
		return (null == chorbis) ? null : chorbis.get(position);
	}

	public long getItemId(int position) {
		return chorbis.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tli;
		if (null == convertView) {
			tli = (TextView) View.inflate(context, R.layout.item, null);
		} else {
			tli = (TextView)convertView;
		}
		Chorbi c=chorbis.get(position);
		tli.setText(c.getName() + " "+c.getTlf());
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}
	public void add(Chorbi s){
		chorbis.add(s);
	}
	public void remove(int i){
		chorbis.remove(i);
	}
	public void remove(Chorbi s){
		chorbis.remove(s);
	}
	

}
