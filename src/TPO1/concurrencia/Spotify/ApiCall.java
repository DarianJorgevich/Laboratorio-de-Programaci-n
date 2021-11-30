/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia.Spotify;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class ApiCall {
    public static Artist  getArtist(String name) {
        final String token = "BQCAycDFipIeaY7eRqganL6nlFp3X5VWV0R49Sgp1qErZdbkOdcxHYXEQuNtmgC02qXkxNgjv6nVi8J_kkRuXPYVgOuhswvPRj1P9c5JIdVyJt7pfWo7AVrc6A1FRGDDyK0jSLu78EyZ";
        //final String token = "BQDvmyqaBJBhQr2sToaK1U2YpOAF0nQ2kMA6U7qja5VRGi8zIUaEoV42CpPAks9LTHtwyWUt7DmxKZCrp-hLWhoJwqAxv0H1DhTYKjN6Sb0ndkByoE4IsnbqaMf8aTCcbzXuvsTT6NDi";
        StringBuffer response = new StringBuffer();
        try {      
        URL url = new URL("https://api.spotify.com/v1/search?q="+name.trim().replaceAll(" ", "%20")+"&type=artist&limit=1&offset=0");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+token);
      

        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        
        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        in.close();
        } catch (MalformedURLException ex) {
            System.err.println(ex);
            
        } catch (IOException ex) {
            System.err.println("Renovar token");
        }
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(response.toString()).getAsJsonObject();
        JsonObject artista = o.getAsJsonObject("artists");
        JsonObject aux = artista.getAsJsonArray("items").get(0).getAsJsonObject();
        int pop = Integer.parseInt(aux.get("popularity").getAsString());
        Artist artist = new Artist(aux.get("name").getAsString(),aux.get("id").getAsString(), pop );
        return artist; 
    }
}
