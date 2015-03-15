package com.example.horrornocnegoprogramowania;

import android.graphics.Color;
import android.widget.TextView;

public class UIController {

	static void validateLinks(String[] links, TextView[] opcja)
	{
		int i = 0;
		for (i = 0; i < 3; i++)
		{
			String ID = links[i];
			if (Scenariusz.listaScen.containsKey(ID) == false)
			{
				opcja[i].setTextColor(Color.GRAY);
			}
		};
	}
	
	static void resetColorLinks(TextView[] textArray){
		for (TextView tx : textArray)
		{
			tx.setTextColor(Color.parseColor("#BB0000"));
		}
	}
	
	static String pokazNazwyPrzedmiotow()
	{
		Przedmiot[] listaPrzedmiotow = KontrolerGry.listaRzeczy.toArray(new Przedmiot[KontrolerGry.listaRzeczy.size()]);
		int i;
		StringBuilder stringBuilder = new StringBuilder();
		for (i = 0; i < listaPrzedmiotow.length; i++)
		{
			String przedmiot = listaPrzedmiotow[i].getNazwa();
			stringBuilder.append(przedmiot);
			if (i != listaPrzedmiotow.length)
			{
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.toString();
	}
}
