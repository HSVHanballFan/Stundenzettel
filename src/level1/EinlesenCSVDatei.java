package level1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EinlesenCSVDatei {

	
	public static void main(String[] args) {
	  String dateiname = "zeiten.csv";
	  File file = new File(dateiname);
	  Scanner inputStream;
	  
	  try {
		
		  inputStream = new Scanner(file);
		  
		  while(inputStream.hasNext()){
			
			  String data = inputStream.next();
			  System.out.println(data);
			  
		  }
		  
	  	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	  
		
		
		
		
		
		
		
	}

}
