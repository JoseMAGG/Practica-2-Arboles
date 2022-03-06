<<<<<<< HEAD
import src.arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import src.bussiness.util.FileTo;
import src.models.Contact;
import src.view.Index;
import src.bussiness.avl.IdentificadorDeLlamadas;


//3. Conocer que personas están asociados a una característica particular en uno de sus genes.

public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        IdentificadorDeLlamadas identificador = new IdentificadorDeLlamadas();
        identificador.creteAvlFromFile();
        //crear arbol binario
        ArbolContactosEjecutivos 

        Index.mainScreen(identificador);


        
       // Contact foundContact = identificador.searchContact("3148284339");
       // System.out.println("contacto encontrado: " + foundContact);

        System.out.println("Contacto insertado" + (identificador.addContact(new Contact("ANA SOFIA", "123456"))));
        foundContact = identificador.searchContact("123456");
        System.out.println("contacto encontrado: " + foundContact);

        identificador.avlToFile();

        // ArbolAVL<Contact> contactos;
        // contactos = FileTo.agenda("src/contactos.txt"); // crear el directorio
        // general
        // System.out.println(contactos.toString());
        // Contact contact = new Contact((Long.valueOf("3148284339")));
        // System.out.println((contactos.buscar(contact)));// ejemplo buscar

    }

=======
public class main {
    
>>>>>>> origin/juand2
}
