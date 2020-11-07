package application;

public aspect Logger {
	
	pointcut successA() : call(* cambiarColor*(..) );
    after() : successA() { 
    	System.out.println("**** Color cambiado ****");    	
    }

    
}