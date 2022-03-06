package src.view;
import java.util.Scanner;
import src.bussiness.avl.IdentificadorDeLlamadas;
import src.models.Contact;
import src.view.constants.NewContactIdCallConstants;

public class NewContacIdCallView {
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para ingresar un nuevo contacto al identificador de llamadas
     */
    public static void index(IdentificadorDeLlamadas identificador) {

    System.out.print(NewContactIdCallConstants.TITLE);
    char response;
    do {
        System.out.println(NewContactIdCallConstants.SUBTITLE);
        String number = read.nextLine();
        System.out.println(NewContactIdCallConstants.NOTES);
        String name = read.nextLine();
        Contact contact= new Contact(name, number);
        Contact newContact=identificador.addContact(contact);
        
        System.out.println("Contacto "+ newContact+"agregado de forma correcta");
        do {
            System.out.print(NewContactIdCallConstants.QUESTION);
            response = read.next().charAt(0);
            read.nextLine();
        } while (response != 'y' && response != 'n');
    } while (response == 'y');      
}
 
    
}
