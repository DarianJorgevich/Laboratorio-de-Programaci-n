/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP01.concurrencia.ForkJoinTask;

import static TP01.concurrencia.ForkJoinTask.utiles.getMovie;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darian y lucas
 */

public class DownloaderMovies extends RecursiveTask<String>{
    String data[];
    DownloaderMovies(String[] data) {
	this.data = data;	  
    }
    
    @Override
    protected String compute() {
        String result = null;
        if(data.length ==1){
            //Si solo tengo un titulo que buscar en el arreglo de titulos de peliculas
            try {
                String aux = getMovie(data[0]);
                result = aux + "\n";
            } catch (IOException ex) {
                Logger.getLogger(DownloaderMovies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            int mid = data.length/2;
            if(data.length % 2 !=0)mid++;
            //Subdivide el arreglo en dos
            //primero realiza un fork a la parte izquierda
            DownloaderMovies leftSide = new DownloaderMovies(Arrays.copyOfRange(data, 0, mid));
            leftSide.fork();       
            
            //Luego computa la parte derecha y espera a que la parte izquierda termine
            DownloaderMovies rightSide = new DownloaderMovies(Arrays.copyOfRange(data, mid, data.length));
            result = rightSide.compute() + leftSide.join();
        }
        return result;
    }
}
