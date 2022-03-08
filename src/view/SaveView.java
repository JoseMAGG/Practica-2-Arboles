package view;

import java.io.IOException;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;
import bussiness.util.EjecutivosTo;

public class SaveView {
    public static void index(IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) throws IOException {
        identificador.avlToFile();
        EjecutivosTo.txtFile(ejecutivos, "src/empresariales.txt");
        System.out.println("Árboles guardados con éxito");
    }
}

