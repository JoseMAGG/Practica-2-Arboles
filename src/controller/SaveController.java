package controller;

import java.io.IOException;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;
import view.SaveView;

public class SaveController {
    public static void index(IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) throws IOException{
        
        SaveView.index(identificador, ejecutivos );  
    }
  
    
}
