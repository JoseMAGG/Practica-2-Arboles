package view;
import view.constants.SearchByNumberConstants;
import java.util.Scanner;

import bussiness.avl.IdentificadorDeLlamadas;
import bussiness.arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import bussiness.avl.*;
import models.Contact;


public class SearchByNumberView {
    
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para buscar contacto por numero de celular
     */
    public static void index(IdentificadorDeLlamadas identificador) {

        System.out.print(SearchByNumberConstants.TITLE);
        char response;
        do {
            System.out.println(SearchByNumberConstants.SUBTITLE);
            System.out.println(SearchByNumberConstants.NOTES);
            String number = read.nextLine();
            Contact contact=identificador.searchContact(number);
            
            System.out.println("Contacto "+ contact);
            do {
                System.out.print(SearchByNumberConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');      
    }
     
    
}
