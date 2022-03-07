package view;

import java.io.IOException;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;

public class SaveView {
    public static void index(IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) throws IOException {
        identificador.avlToFile();
        //ejecutivos.binariosToFile();
        System.out.println("Árboles guardados con éxito");
    }
    
}
