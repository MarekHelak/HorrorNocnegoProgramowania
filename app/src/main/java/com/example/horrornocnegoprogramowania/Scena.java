package com.example.horrornocnegoprogramowania;



class Scena {	

	//Ustaw standardowy widok
	private String 
			miejsce = "Default",
			opis = "Default";
			
	//Przechowywane informacje o zdobytych/straconych przedmiotach
	private Przedmiot sekretnyPrzedmiot;
	
	
	Przedmiot brak = new Przedmiot("");
	Przedmiot[] potrzebnyPrzedmiot = {brak,brak,brak,brak,brak};
	
	private String[] 
			opcja = {"", "", "", "", ""},
			link = {"","1","1","1","1"},
			//potrzebnyPrzedmiot = {"",null,null,null,null},
			sekretnaOpcja = {"", "", "", "", ""},
			sekretnyLink = {"","1","1","1","1"};
					
	//private LinkedHashMap<Character, String> kontenerPrzedmiot—w ;
	
	protected String getMiejsce() {
		return miejsce;
	}

	protected String getOpis() {
		return opis;
	}

	protected String getOpcja(int i) {
		for (Przedmiot przedmiot : KontrolerGry.listaRzeczy){
		if(przedmiot.getNazwa().equals(potrzebnyPrzedmiot[i].getNazwa()))
		return sekretnaOpcja[i];
		} return opcja[i];
	}

	protected Przedmiot getPrzedmiot() {	
		return sekretnyPrzedmiot;
	}

	protected String getLink(int i) {
		for (Przedmiot przedmiot : KontrolerGry.listaRzeczy){
		if(przedmiot.getNazwa().equals(potrzebnyPrzedmiot[i].getNazwa()))
		return sekretnyLink[i];
		} return link[i];
	}

	Scena ustawScene(Scena scena){
		return scena;
	}
	
	void ustawMiejsce(String miejsce) 
	{
		this.miejsce = miejsce;
	}
	
	void ustawOpis(String opis)
	{
		this.opis = opis;
	}
	
	void ustawOpcje(String opcja, int i)
	{
		this.opcja[i] = opcja;
	}
		
	void ustawSekretnaOpcja(String opcja, int i)
	{
		sekretnaOpcja[i] = opcja;
	}

	void ustawLink(String link, int i)
	{
		this.link[i] = link;
	}
	
	void ustawSekretnyLink(String link, int i)
	{
		sekretnyLink[i] = link;
	}
	
	void ustawPotrzebnyPrzedmiot(Przedmiot przedmiot, int i)
	{
		potrzebnyPrzedmiot[i] = przedmiot;
	}
	
	void ustawPrzedmiot(Przedmiot przedmiot)
	{
		this.sekretnyPrzedmiot = przedmiot;
	}
	
	public String toString(){
	return miejsce;
}
}