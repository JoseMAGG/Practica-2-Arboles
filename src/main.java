import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import bussiness.util.FileTo;
import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;

import models.Contact;
import view.Index;
import bussiness.avl.IdentificadorDeLlamadas;


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
        ArbolContactosEjecutivos<Contact> ejecutivos = FileTo.contactosEjecutivos("src/empresariales.txt", identificador.getDirectorio());
        //System.out.println("Imprimiendo ejecutivos");
        //System.out.println(ejecutivos);
        Index.mainScreen(identificador, ejecutivos);
       // Contact foundContact = identificador.searchContact("3148284339");
       // System.out.println("contacto encontrado: " + foundContact);
       // Contact hijo = new Contact("Hijo", "5726343473");
        // ejecutivos.agregarContactoN1(new Contact("Padre", "3823335240"), hijo);
        // ejecutivos.agregarContactoN(2, hijo, new Contact("Nieto", "5234234935"));
        
        // ejecutivos.agregarContactoN(2, hijo, new Contact(Long.valueOf("5234234935")));
        // System.out.println(ejecutivos);
        // System.out.println("Mostrando los contactos de: Luis");
        // System.out.println(ejecutivos.obtenerContactos(ejecutivos.buscarNodoContacto(new Contact(Long.valueOf("9471958384")))));
        // System.out.println("Contacto insertado" + (identificador.addContact(new Contact("ANA SOFIA", "123456"))));
        //foundContact = identificador.searchContact("123456");
        //System.out.println("contacto encontrado: " + foundContact);

        

        // ArbolAVL<Contact> contactos;
        // contactos = FileTo.agenda("src/contactos.txt"); // crear el directorio
        // general
        // System.out.println(contactos.toString());
        // Contact contact = new Contact((Long.valueOf("3148284339")));
        // System.out.println((contactos.buscar(contact)));// ejemplo buscar


    }
}

// Lista de contactos ejecutivos=> //lista generalizada o un arbol n-ario aqui
// se van creando los contactos

// Identificador de llamadas =>Arbol AVL, número de telefono y a quien pertenece
// papá : Hijo
// 1. 13148284339 : 300123456
// 2. 300123456 : 301987654
// 3. 301987654 : 302345678
// 3. 301987654 : 302345679
// 1. 302345679 : 301987653 -> ojo con este que ya existía
// se pueden ingresar nuevos contactos de nivel 1 o de nivel 2 en adelante

// 1. buscar en el arbol AVL (Identificador de llamadas) -> JD
// 2. Lista de contactos del arbol de contactos ejecutivos Arbol binario -> LM
// imprimir los contactos(hijos) de un contacto
// 3. ingresar contacto nivel 1 en arbol de contactos ejecutivos -> JM
// 4. Ingresar un nuevo contacto en el nivel 2 o 3 en arbol de contactos
// ejecutivos -> JM
// 5. Ingresar un nuevo contacto en el arbol AVL (Identificador de llamadas)
// ->JD
// 6. Guardar los arboles en archivos de texto txt -> LM
// 7. Vista y menus -> LT
