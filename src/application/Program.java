package application;

import java.time.LocalDateTime;

import entities.Voo;
import exception.BusinessException;

public class Program {
    
    public static void main(String args[]){
    	
    	Voo voo = null, voo2 = null, voo3 = null;
    	
    	//Testando caracteres inválidos 
    	try { 
    		
    		voo = new Voo("AA4566", "AZUL", LocalDateTime.parse("20/12/2025 12:55:22", Voo.FMT), LocalDateTime.parse("21/12/2025 13:55:22",Voo.FMT), "LASVEGAS");
    		voo2 = new Voo("2601GB", "GOol", LocalDateTime.parse("25/12/2025 12:55:22", Voo.FMT ) , LocalDateTime.parse("26/12/2025 12:55:22", Voo.FMT ) , " Pimba");
        	voo2.avancarStatus();
        
    	}
    	catch(BusinessException e ) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
    	
    	System.out.println(voo);
    	System.out.println(voo2);
    	
    	
    	//verificando horários iguais
    	try {
    		
    		voo3 = new Voo("89P600", "Latam", LocalDateTime.parse("25/12/2025 12:55:22", Voo.FMT ) , LocalDateTime.parse("25/12/2025 12:55:22", Voo.FMT ), "Utinga");
        
    	}
    	catch(BusinessException e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
    	
    	System.out.println(voo3);
    	
    	//Verificando horários nulos 
    	try {
    		   	
    		voo.alterarHorarios(null, null);
    	}
    	catch(BusinessException e){
    		
    	}
    	
    	System.out.println(voo);
    }
}
	