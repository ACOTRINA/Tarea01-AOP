package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public aspect Logger {
	
	pointcut success() : call(* cambiarColor*(..) );
    after() : success() { 
    	System.out.println("**** Color cambiado ****");    	
    }
    
    pointcut successA() : call(* abrirArchivo*(..) );    
    after() : successA() {
    	System.out.println("Someone has performed open operation with the following file: Color.txt");
    }
    
    pointcut successC() : call(* cerrarArchivo*(..) );    
    after() : successC() {
    	System.out.println("Someone has performed close operation with the following file: Color.txt");
    }
}

