import bussiness.util.FileTo;
import models.Contact;
import view.Index;
import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;



public class App {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        IdentificadorDeLlamadas identificador = new IdentificadorDeLlamadas();
        identificador.creteAvlFromFile();
        
        //crear arbol binario
        ArbolContactosEjecutivos<Contact> ejecutivos = FileTo.contactosEjecutivos("src/empresariales.txt", identificador.getDirectorio());
  
        Index.mainScreen(identificador, ejecutivos);



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
