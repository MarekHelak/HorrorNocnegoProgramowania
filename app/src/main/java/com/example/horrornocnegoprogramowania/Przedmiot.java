package com.example.horrornocnegoprogramowania;

public class Przedmiot {

	Przedmiot(String nazwa)
	{
		this.nazwa = nazwa;
	}
	
	protected String getNazwa() {
		return nazwa;
	}

	protected void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	protected String getKolor() {
		return kolor;
	}

	protected void setKolor(String kolor) {
		this.kolor = kolor;
	}

    public String toString(){
        return nazwa;
    }

	private String nazwa = "";
	private String kolor = "";
	
	
}
