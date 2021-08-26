/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia.Spotify;


import static TPO1.concurrencia.Spotify.ApiCall.getArtist;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author juan
 */
public class main {
    public static void main(String[] args) throws IOException {
        String []artists = {"Charly García", "Serrat", "The Doors", "Pink Floyd", "The Beatles", "Spinetta", "Foo Figthers", "Rush", "Jethro Tull", "Deep purple"};
        System.out.println("\u001B[31m================Empieza descarga NO concurrente===============");
        long time = System.currentTimeMillis();
        
        for (String artist : artists) {
             String aux = getArtist(artist).toString();
            System.out.println(aux);
        }
        System.out.println("\u001B[31m================Termina descarga NO concurrente===============");
        System.out.println("Tiempo no concurrente : \u001B[31m"+(System.currentTimeMillis()-time));
        
        System.out.println("\u001B[32m================Empieza descarga concurrente===============");
        time = System.currentTimeMillis();
        ForkJoinPool.commonPool().invoke(new DownloaderArtists(artists));
        System.out.println("\u001B[32m================Termina descarga concurrente===============");
        System.out.println("Tiempo concurrente : \u001B[32m"+(System.currentTimeMillis()-time));
    }
}
