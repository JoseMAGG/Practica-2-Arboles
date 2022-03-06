/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.nario.binariolistaligada;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;

/**
 *
 * @author 57300
 */
public class ArbolNarioBinarioListaLigada extends ArbolBinarioListaLigada {

    public ArbolNarioBinarioListaLigada(NodoBinarioGenerico raiz) {
        super(raiz);
    }

    public int numeroHojas() {
        return -1;
    }
}
