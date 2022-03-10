package view;

import java.util.Scanner;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;
import view.constants.NewContactLevel2_3Constants;

public class NewContactLevel2_3View {    
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para ingresar un nuevo contacto al nivel 1 (ejecutivos)
     */
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos, IdentificadorDeLlamadas identificador) {

    System.out.print(NewContactLevel2_3Constants.TITLE);
    char response;
    do {
        System.out.println(NewContactLevel2_3Constants.SUBTITLE);
        String numberPadre = read.nextLine();
        if (numberPadre.equals("0"))
            break; 
        Contact contactPadre = identificador.searchContact(numberPadre);
        if (contactPadre.getName().equals("Contacto no encontrado")) {
            System.out.println(
                "El numero ingresado no se encuetnra en la base de datos, debe agregarlo primero en la opción 5");
            break;
            }
        System.out.println(NewContactLevel2_3Constants.NOTES);
        int nivel = read.nextInt();
        read.nextLine();
        System.out.println(NewContactLevel2_3Constants.NOTES2);
        String numberHijo = read.nextLine();
        Contact contactHijo = identificador.searchContact(numberHijo);
            if (contactHijo.getName().equals("Contacto no encontrado")) {
                System.out.println(
                        "El numero ingresado no se encuetnra en la base de datos, debe agregarlo primero en la opción 5");
                break;
            }
        
        //Contact contactoAgregar= new Contact(Long.valueOf(number));
        //Contact referidoGuardado= new Contact(Long.valueOf(fatherNumber));
        ejecutivos.agregarContactoN(nivel, contactHijo, contactPadre);
        
        //System.out.println("Contacto "+ contactoAgregar+"agregado de forma correcta");

        do {
            System.out.print(NewContactLevel2_3Constants.QUESTION);
            response = read.next().charAt(0);
            read.nextLine();
        } while (response != 'y' && response != 'n');
    } while (response == 'y');      
}
    
}
