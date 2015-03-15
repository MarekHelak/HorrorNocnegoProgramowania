package com.example.horrornocnegoprogramowania;

import java.io.IOException;
import java.io.InputStream;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class KontrolerPlikow {
	
	 static String scenariusz = "";
	
	 static protected String read(Context ctx, String nazwaPliku) {
				 
		 try {
			 InputStream stream = ctx.getAssets().open(nazwaPliku);	
			 byte[] buffer = new byte[stream.available()]; 
			 stream.read(buffer);
			 stream.close();
			 scenariusz = new String(buffer, "UTF-8");
		 } catch (IOException e) {
			 Toast.makeText(ctx, nazwaPliku + " nie istnieje", Toast.LENGTH_LONG).show();
		}
		 
		return scenariusz;	
	 }

}		  
	
 
	