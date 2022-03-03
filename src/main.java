import arbol.binario.listaligada.busqueda.avl.ArbolAVL;

import models.Contact;

import util.FileTo;

//3. Conocer que personas están asociados a una característica particular en uno de sus genes.

public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // String inorden = "gehicbfdajklnmop";
        // String preorden = "abceghidflkjmnop";

        ArbolAVL<Contact> contactos;
        contactos = FileTo.agenda("src/contactos.txt"); // crear el directorio general
        System.out.println(contactos.toString());
        Contact contact = new Contact((Long.valueOf("3148284339")));
        System.out.println((contactos.buscar(contact)));// ejemplo buscar

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


//1. buscar en el arbol AVL (Identificador de llamadas) -> JD
//2. Lista de contactos del arbol de contactos ejecutivos Arbol binario  -> LM imprimir los contactos(hijos) de un contacto
//3. ingresar contacto nivel 1 en arbol de contactos ejecutivos  -> JM
//4. Ingresar un nuevo contacto en el nivel 2 o 3  en arbol de contactos ejecutivos -> JM
//5. Ingresar un nuevo contacto  en el arbol AVL (Identificador de llamadas) ->JD
//6. Guardar los arboles en archivos de texto txt  ->  LM 
//7. Vista y menus -> LT

