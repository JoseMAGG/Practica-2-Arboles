package view;

import java.util.Scanner;

import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import controller.SearchByNumberController;
import models.Contact;
import view.constants.NewContactLevel1Constants;

public class NewContactLevel1View {
    static Scanner read = new Scanner(System.in);

    /**
     * Formulario para ingresar un nuevo contacto al nivel 1 (ejecutivos)
     */
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos, IdentificadorDeLlamadas identificador) {

        System.out.print(NewContactLevel1Constants.TITLE);
        char response;
        do {
            System.out.println(NewContactLevel1Constants.SUBTITLE);
            String number = read.nextLine();
            if (number.equals("0"))
                break;
            
            Contact contact = identificador.searchContact(number);
            if (contact.getName().equals("Contacto no encontrado")) {
                System.out.println(
                        "El numero ingresado no se encuetnra en la base de datos, debe agregarlo primero en la opción 5");
                break;
            }
            // Contact contact= new Contact(Long.valueOf(number));
            System.out.println(NewContactLevel1Constants.NOTES);
            System.out.println(NewContactLevel1Constants.NOTES2);
            String numberHijo = read.nextLine();
            Contact contactHijo = identificador.searchContact(numberHijo);
            if (contactHijo.getName().equals("Contacto no encontrado")) {
                System.out.println(
                        "El numero ingresado no se encuetnra en la base de datos, debe agregarlo primero en la opción 5");
                break;
            }
            ejecutivos.agregarContactoN1(contact, contactHijo);
            System.out.println("Contacto "+ contact+"agregado de forma correcta");

            do {
                System.out.print(NewContactLevel1Constants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');
    }
}
