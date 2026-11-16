package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import entities.Voo;
import exception.BusinessException;

public class Program {
    
    public static void main(String args[]){
    	
    	Voo voo, voo2, voo3;
    	
    	voo = new Voo("AB4566", "Azul", LocalDateTime.parse("20/12/2025 12:55:22", Voo.FMT), LocalDateTime.parse("21/12/2025 13:55:22",Voo.FMT), "Las Vegas");
    	System.out.println(voo);
    	
    	voo2 = new Voo("2601GB ", "GOol", LocalDateTime.parse("25/12/2025 12:55:22", Voo.FMT ) , LocalDateTime.parse("26/12/2025 12:55:22", Voo.FMT ) , " Pimba");
    	voo2.avancarStatus();
    	System.out.println(voo2);
    	
    	voo3 = new Voo("89P600", "Latam ", LocalDateTime.parse("25/12/2025 12:55:22", Voo.FMT ) , LocalDateTime.parse("26/12/2025 09:55:26", Voo.FMT ), "Utinga");
    	 
    	try {
    	
    	voo.alterarCompanhiaAerea("    ");
    	
    	}
    	catch(BusinessException e) {
    		e.printStackTrace();
    	}
    	catch(DateTimeParseException e) {
    		e.printStackTrace();
    	}
    	
    	System.out.println(voo);
    }
}
	