package view;

import java.util.Scanner;

import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.constants.ShowContactListOfConstants;

public class ShowContactListView {
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para imprimir contactos de un contacto
     */
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos) {
        System.out.print(ShowContactListOfConstants.TITLE);
        char response;
        do {
            System.out.println(ShowContactListOfConstants.SUBTITLE);
            String number = read.nextLine();
            if (number.equals("0"))
            break; 
            Contact contact= new Contact(Long.valueOf(number));
            NodoBinarioGenerico<Contact> padre= ejecutivos.buscarNodoContacto(contact);
            String contactos=ejecutivos.imprimirDescendencia(padre);
            
            System.out.println("Contactos del padre "+ contactos);
            do {
                System.out.print(ShowContactListOfConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');      
    }
     

    }
    

