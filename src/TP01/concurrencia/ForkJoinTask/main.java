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
        /**
         * El ejemplo que decidimos plantear presenta a una aplicación a traves 
         * de la cual al ingresarle el TITULO de una película, ésta buscar su 
         * info relacionada (titulo, año, calificación, duración, etc.).
        */
        String resultado = "";
        long time = System.currentTimeMillis();
        String []titles = {"Blade Runner","Godzilla", "The Godfather", "The Godfather: Part II", "The Dark Knight", "47 Ronin", "El Hoyo", "superman", "inception", "batman 1"};
        /**
         * Inicialmente cargamos un arreglo que contiene los titulos de las 
         * peliculas de las que queremos conocer su información
         */
        System.out.println("\u001B[31m================Empieza descarga NO concurrente===============");
        /**
         * Para tomar un tiempo base de ejecución y poder mostrar la diferencia 
         * existente con respecto a ForkJoin + RecursiveTask primero realizamos 
         * la descarga de la información de cada pelicula de modo secuencial.
         */
        String aux="";
        for (String title : titles) {
           aux+= getMovie(title) + "\n";
         }
        System.out.println(aux);
        
        System.out.println("\u001B[31m================Termina descarga NO concurrente===============");
        System.out.println("Tiempo no concurrente : \u001B[31m"+(System.currentTimeMillis()-time));
        /**
         * Una vez que termina de descargar toda la información referente a cada
         * pelicula de manera secuencial, nos muestra dicha información y el 
         * tiempo que tardó en conseguirla 
         */
        System.out.println("\n \n");
        /**
         * Dejamos un pequeño espacio para que sea más facil ver la separación
         * de las distintas formas de obtener la información (secuencial o concu
         * rrente).
         */
        time = System.currentTimeMillis();  //Reiniciamos el tiempo medido
        System.out.println("\u001B[32m================Empieza descarga concurrente===============");
        /**
         * Ahora comenzamos la misma descarga anterior, pero esta vez utilizando
         * ForkJoin y RecursiveTask para generar la concurrencia.
         */
        DownloaderMovies task = new DownloaderMovies(titles);
        resultado = ForkJoinPool.commonPool().invoke(task);
        System.out.println(resultado);
        System.out.println("\u001B[32m================Termina descarga concurrente===============");
        System.out.println("Tiempo concurrente : \u001B[32m"+(System.currentTimeMillis()-time));
        /**
         * Una vez que termina de descargar toda la información referente a cada
         * pelicula de manera concurrente, nos muestra dicha información y el 
         * tiempo que tardó en conseguirla. Puede notarse que la diferencia de 
         * tiempo entre un modo y otro es bastante.
         */
        /**
         * Con este ejemplo simple podemos ver la ventaja al realizar la descar
         * ga de modo concurrente con ForkJoinPool.
         * En DownloaderMovies podremos ver la implementación de RecursiveTask 
         */
    }
}
