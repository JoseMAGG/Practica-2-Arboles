package bussiness.util;

import java.io.*;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;

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



        try {
            String ruta = "src/contactos.txt";
            String contenido = "Contenido de ejemplo";
            File file = new File(ruta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            avl.toString();

            bw.newLine();
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    
}