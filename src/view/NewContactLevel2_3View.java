package view;

import java.util.Scanner;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.constants.NewContactLevel2_3Constants;

public class NewContactLevel2_3View {    
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para ingresar un nuevo contacto al nivel 1 (ejecutivos)
     */
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos) {

    System.out.print(NewContactLevel2_3Constants.TITLE);
    char response;
    do {
        System.out.println(NewContactLevel2_3Constants.SUBTITLE);
        String fatherNumber = read.nextLine();
        if (fatherNumber.equals("0"))
            break; 
        System.out.println(NewContactLevel2_3Constants.NOTES);
        String number = read.nextLine();
        
        Contact contactoAgregar= new Contact(Long.valueOf(number));
        Contact referidoGuardado= new Contact(Long.valueOf(fatherNumber));
        ejecutivos.agregarContactoN2O3(contactoAgregar, referidoGuardado);
        
        System.out.println("Contacto "+ contactoAgregar+"agregado de forma correcta");
        do {
            System.out.print(NewContactLevel2_3Constants.QUESTION);
            response = read.next().charAt(0);
            read.nextLine();
        } while (response != 'y' && response != 'n');
    } while (response == 'y');      
}
    
}
