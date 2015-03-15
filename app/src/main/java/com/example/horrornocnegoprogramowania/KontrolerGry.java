package com.example.horrornocnegoprogramowania;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class KontrolerGry implements OnClickListener {

	static HashSet<Przedmiot> listaRzeczy = new HashSet<Przedmiot>();
	static private TextView miejsce, opcja1, opcja2, opcja3, opcja4, opis, przedmioty;
	private TextView[] opcja = {opcja1, opcja2, opcja3, opcja4};
	static private String[] links = {"1", "1", "1", "1" };
	
	static protected void setLinks(String linkA, String linkB, String linkC, String linkD) {
		links[0] = linkA;
		links[1] = linkB;
		links[2] = linkC;
		links[3] = linkD;
	}
	
	private void dodajPrzedmiot(Przedmiot przedmiot){
		if (przedmiot != null){
			Log.w("Test", przedmiot.getNazwa());
			listaRzeczy.add(przedmiot);
		}
		przedmioty.setText("Przedmioty: " + UIController.pokazNazwyPrzedmiotow());
		}


	void start(Activity activity) {	
		
		miejsce = (TextView) activity.findViewById(R.id.miejsce);
		opis = (TextView) activity.findViewById(R.id.opis);
		opcja[0] = (TextView) activity.findViewById(R.id.jeden);
		opcja[1] = (TextView) activity.findViewById(R.id.dwa);
		opcja[2] = (TextView) activity.findViewById(R.id.trzy);
		opcja[3] = (TextView) activity.findViewById(R.id.cztery);
		przedmioty = (TextView) activity.findViewById(R.id.przedmioty);
		 
		opcja[0].setOnClickListener(this);
		opcja[1].setOnClickListener(this);
		opcja[2].setOnClickListener(this);
		opcja[3].setOnClickListener(this);
	}
	
	@Override
	public void onClick(View clicked) {
		switch(clicked.getId())
		{
		case R.id.jeden: go(Scenariusz.listaScen.get(links[0]));
			break;
		case R.id.dwa: go(Scenariusz.listaScen.get(links[1]));
			break;
		case R.id.trzy: go(Scenariusz.listaScen.get(links[2]));
			break;
		case R.id.cztery: go(Scenariusz.listaScen.get(links[3])); 
			break;
		}
	}
	
	void go(Scena scena)
	{
		UIController.resetColorLinks(opcja);
		
		miejsce.setText(scena.getMiejsce());
		opis.setText(scena.getOpis());
		opcja[0].setText(scena.getOpcja(1));
		opcja[1].setText(scena.getOpcja(2));
		opcja[2].setText(scena.getOpcja(3));
		opcja[3].setText(scena.getOpcja(4));
		setLinks(scena.getLink(1), scena.getLink(2), scena.getLink(3), scena.getLink(4));
		dodajPrzedmiot(scena.getPrzedmiot());
		
		UIController.validateLinks(links, opcja);
		Log.w("Test", listaRzeczy.toString());
	}
	
}
