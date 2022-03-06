package bussiness.util;

import java.io.*;
import java.util.Stack;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import models.Contact;

public class AvlTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";
    public static final String COLON_SEPARATOR = ":";

    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */

    public static void txtFile(ArbolAVL<Contact> avl, String path) throws IOException {

        NodoAVL<Contact> raiz = avl.getRoot();

        try {

            File file = new File(path);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            /////

            Stack<NodoAVL<Contact>> migas = new Stack<>();
            NodoAVL<Contact> r = raiz;
            migas.add(r);
            r = (NodoAVL<Contact>) r.getLi();

            while (!migas.isEmpty() || r != null) {
                if (r != null) {
                    migas.add(r);
                    r = (NodoAVL<Contact>) r.getLi();
                } else {
                    r = migas.pop();
                    Contact tempContact = (Contact) r.getDato();
                    String newLine = tempContact.toLineText();
                    bw.write(newLine);
                    bw.newLine();

                    r = (NodoAVL<Contact>) r.getLd();
                }

            }

            bw.close();
        } catch (

        Exception e) {
            e.printStackTrace();
        }

    }

}
