/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia.Spotify;

import static TPO1.concurrencia.Spotify.ApiCall.getArtist;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class DownloaderArtists extends RecursiveAction{

    String data[];
    DownloaderArtists(String[] data) {
	this.data = data;	  
    }
    @Override
    protected void compute() {
        if(data.length ==1){
            Artist auxi = getArtist(data[0]);
            System.out.println(auxi.toString());
        }
        else{
            int mid = data.length/2;
            if(data.length % 2 !=0)mid++;
            invokeAll(new DownloaderArtists(Arrays.copyOfRange(data, 0, mid)), 
                 new DownloaderArtists(Arrays.copyOfRange(data, mid, data.length)));
        }
    }
    
}
