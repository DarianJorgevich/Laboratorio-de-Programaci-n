/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Darian y Lucas
 */


public class Translator {
    /**Languages:
     *      "en": Ingles
     *      "es": Español
     *      "ja": Japones
     *      "de": Aleman
     *      "pt": Portugues
     *      "fr": Frances
     *      
     * Hice este ejemplo usando google script.
     * https://developers.google.com/apps-script/guides/services/quotas
     * 
     * 
     * @param args
     * @throws IOException 
     */

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        //Cuando el lenguaje de entrada especificado no es correcto, devuelvo el mismo texto a traducir sin operar
        String urlStr = "https://script.google.com/macros/s/AKfycbzTOq0M69opJUEy9xBZVV517bCe_RkNj9_m2yhJzqb6UmkgYCQ/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
        
    }

}
