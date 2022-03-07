package view;

import java.util.Scanner;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.constants.NewContactLevel1Constants;

public class NewContactLevel1View { 
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para ingresar un nuevo contacto al nivel 1 (ejecutivos)
     */
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos) {

    System.out.print(NewContactLevel1Constants.TITLE);
    char response;
    do {
        System.out.println(NewContactLevel1Constants.SUBTITLE);
        String number = read.nextLine();
        System.out.println(NewContactLevel1Constants.NOTES);
        
        Contact contact= new Contact(Long.valueOf(number));
        ejecutivos.agregarContactoN1(contact);
        
        System.out.println("Contacto "+ contact+"agregado de forma correcta");
        do {
            System.out.print(NewContactLevel1Constants.QUESTION);
            response = read.next().charAt(0);
            read.nextLine();
        } while (response != 'y' && response != 'n');
    } while (response == 'y');      
}
}
