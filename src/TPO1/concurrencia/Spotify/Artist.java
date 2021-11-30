/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia.Spotify;

/**
 *
 * @author juan
 */
public class Artist {
   public String name;
   public String id;
   public int poularity;

   public Artist(String name, String id, int poularity) {
        this.name = name;
        this.id = id;
        this.poularity = poularity;
    }

    public String getId() {
        return id;
    }
   @Override
    public String toString(){
        return this.name+" - "+this.poularity+" - "+this.id;
    }
   
}
