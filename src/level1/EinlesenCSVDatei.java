package level1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EinlesenCSVDatei {

	public static void main(String[] args) {
	  String dateiname = "zeiten.csv";
	  String startTime = "";
	  String endTime = "";
	  boolean isStarttime = true;
	  
	  File file = new File(dateiname);
	  Scanner inputStream;
	  
	  try {
		
		  inputStream = new Scanner(file);
		  
		  while(inputStream.hasNextLine()){
			
			  String data = inputStream.nextLine();
			  
			  String [] dateien = data.split("\t");
			  int restZeit = 0;
			
			  for (String d : dateien) {
			  		
			  		if(d.contains(":") && isStarttime) {
			  			
			  			startTime = d;
			  			isStarttime = false;
			  			
			  		}else if(d.contains(":") && !isStarttime) {
			  			endTime = d;
			  			isStarttime = true;
			  			//Diff berechnen
			  			restZeit = berechneDifferenz(startTime, endTime) - 480;
			  		}
			  }
				  
			  System.out.println(data + "\t" + restZeit + " Minuten");
			
		  }
		  
		  
	  	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	  	}
	}
	
		
	public static int berechneDifferenz(String startTime, String endTime) {
		
		int [] starttime = wandleZeitstringInInteger(startTime);
		int [] endtime = wandleZeitstringInInteger(endTime);
		int stunden = 0;
		int minuten = 0;
		
		//Berechnung
		stunden = (endtime[0] - starttime[0])*60; // in Minuten
		minuten = endtime[1] - starttime[1];
		
		if(minuten < 0) {
			stunden = stunden - minuten;
		}else {
			stunden = stunden + minuten;
		}
		
		//Pause abziehen
		int jobtime = stunden - 30;

		
		return jobtime;
	}
	
	//08:00
	public static int [] wandleZeitstringInInteger(String zeit) {
		
		int [] hm = new int[2];
		//hier wird z.B. 08 und 00 in Array gespeichert
		String [] stundeMinute = zeit.split(":");
		
		hm[0] = Integer.parseInt(stundeMinute[0]); // Speichere die Stunden als Integer
		hm[1] = Integer.parseInt(stundeMinute[1]); // Speichere die Minuten als Integer
		return hm;
	}
	
}
