/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP01.concurrencia.ForkJoinTask;

import static TP01.concurrencia.ForkJoinTask.utiles.getMovie;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author darian
 */
public class main {
    public static void main(String[] args) throws IOException {
        String resultado = "";
        long time = System.currentTimeMillis();
        String []titles = {"Blade Runner","Godzilla", "The Godfather", "The Godfather: Part II", "The Dark Knight", "47 Ronin", "El Hoyo"};
        
        
        System.out.println("\u001B[31m================Empieza descarga NO concurrente===============");
        for (String title : titles) {
             String aux = getMovie(title);
            System.out.println(aux);
        }
        System.out.println("\u001B[31m================Termina descarga NO concurrente===============");
        System.out.println("Tiempo no concurrente : \u001B[31m"+(System.currentTimeMillis()-time));
        System.out.println("\n \n");
        
        time = System.currentTimeMillis();
        System.out.println("\u001B[32m================Empieza descarga concurrente===============");
        
        DownloaderMovies task = new DownloaderMovies(titles);
        resultado = ForkJoinPool.commonPool().invoke(task);
        System.out.println(resultado);
        //ForkJoinPool.commonPool().invoke(new TP01.concurrencia.ForkJoinTask.DownloaderMovies(titles));
        System.out.println("\u001B[32m================Termina descarga concurrente===============");
        System.out.println("Tiempo concurrente : \u001B[32m"+(System.currentTimeMillis()-time));
    }
}
