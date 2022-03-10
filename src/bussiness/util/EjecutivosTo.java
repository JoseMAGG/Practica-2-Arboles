/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussiness.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import bussiness.arbol.binario.listaligada.normal.NodoBinarioGenerico;
import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;

/**
 *
 * @author Jose
 */
public class EjecutivosTo {
     public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";
    public static final String COLON_SEPARATOR = ":";

    /**
     * @param contactosEjecutivos
     * @param path
     * @throws IOException
     */

    public static void txtFile(ArbolContactosEjecutivos<Contact> contactosEjecutivos, String path) throws IOException {        
        try {

            File file = new File(path);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            Stack<NodoBinarioGenerico<Contact>> migas = new Stack<>();
            Stack<NodoBinarioGenerico<Contact>> migasAnterior = new Stack<>();
            NodoBinarioGenerico<Contact> aux = contactosEjecutivos.getRaiz();
            NodoBinarioGenerico<Contact> r = aux.getLi();
            int nivel = 1;
            String linea;
            migasAnterior.add(null);
            while(!migas.isEmpty() || r != null){
                if(r != null){                    
                    migas.add(r.getLd());                    
                    aux = migasAnterior.peek();
                    if(aux != null){
                        linea = (nivel-1) + COLON_SEPARATOR + aux.getDato().getUserId()
                            + COLON_SEPARATOR + r.getDato().getUserId();                                         
                        bw.write(linea);
                        bw.newLine();
                    }                   
                    
                    migasAnterior.add(r);
                    r = r.getLi();
                    nivel++;                    
                }else{
                    r = migas.pop();
                    migasAnterior.pop();
                    nivel--;
                }
            }
            bw.close();
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
