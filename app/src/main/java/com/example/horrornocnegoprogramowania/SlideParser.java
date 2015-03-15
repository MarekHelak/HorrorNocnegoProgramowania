package com.example.horrornocnegoprogramowania;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.content.Context;
import android.util.Log;

class SlideParser {

	static void tekstDoScenariusza(Context ctx, String nazwaPliku)	{
	String text = KontrolerPlikow.read(ctx,"Horror.txt");
	
	String tasmaSlajdow[] = text.split("\\[end\\]"); 
			
	for(int i = 1; i < tasmaSlajdow.length; i++){
		
		String klucz = null;
		Scena scena = new Scena(); 
		
		Matcher id = Pattern.compile("\\[ID\\](.*)").matcher(tasmaSlajdow[i]);
		if(id.find())	{
			klucz = id.group(1);
			}	
		
		Matcher h = Pattern.compile("\\[miejsce\\](.*)").matcher(tasmaSlajdow[i]);
		if(h.find())	{
			scena.ustawMiejsce(h.group(1));
			}
		
		Matcher d = Pattern.compile("\\[opis\\](.*)").matcher(tasmaSlajdow[i]);
		if(d.find())	{
			scena.ustawOpis(d.group(1));
			} 
		
		Matcher p = Pattern.compile("\\[przedmiot\\](.*)").matcher(tasmaSlajdow[i]);
		if(p.find())	{
			Przedmiot przedmiot = new Przedmiot(p.group(1));
			scena.ustawPrzedmiot(przedmiot);
			} 
		
		Matcher o1 = Pattern.compile("\\[opcja1->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(o1.find())	{
			scena.ustawLink((o1.group(1)), 1);
			scena.ustawOpcje((o1.group(2)), 1);
			}
		
		Matcher o2 = Pattern.compile("\\[opcja2->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(o2.find())	{
			scena.ustawLink((o2.group(1)), 2);
			scena.ustawOpcje((o2.group(2)), 2);
			}
		
		Matcher o3 = Pattern.compile("\\[opcja3->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(o3.find())	{
			scena.ustawLink((o3.group(1)), 3);
			scena.ustawOpcje((o3.group(2)), 3);
		}
		
		Matcher o4 = Pattern.compile("\\[opcja4->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(o4.find())	{
			scena.ustawLink((o4.group(1)), 4);
			scena.ustawOpcje((o4.group(2)), 4);
		}
		
		Matcher item1 = Pattern.compile("\\[opcja1\\((.*)\\)->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(item1.find())	{
			scena.ustawPotrzebnyPrzedmiot(new Przedmiot(item1.group(1)), 1);
			scena.ustawSekretnyLink(item1.group(2), 1);
			scena.ustawSekretnaOpcja(item1.group(3), 1);
		}
		
		Matcher item2 = Pattern.compile("\\[opcja2\\((.*)\\)->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(item2.find())	{
			scena.ustawPotrzebnyPrzedmiot(new Przedmiot(item2.group(1)), 2);
			scena.ustawSekretnyLink(item2.group(2), 2);
			scena.ustawSekretnaOpcja(item2.group(3), 2);
		}
		
		Matcher item3 = Pattern.compile("\\[opcja3\\((.*)\\)->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(item3.find())	{
			scena.ustawPotrzebnyPrzedmiot(new Przedmiot(item3.group(1)), 3);
			scena.ustawSekretnyLink(item3.group(2), 3);
			scena.ustawSekretnaOpcja(item3.group(3), 3);
		}
		
		Matcher item4 = Pattern.compile("\\[opcja4\\((.*)\\)->(.*)\\](.*)").matcher(tasmaSlajdow[i]);
		if(item4.find())	{
			scena.ustawPotrzebnyPrzedmiot(new Przedmiot(item4.group(1)), 4);
			scena.ustawSekretnyLink(item4.group(2), 4);
			scena.ustawSekretnaOpcja(item4.group(3), 4);
		}
		
		Scenariusz.listaScen.put(klucz, scena);
		}
	}
	
	
	
	
}

