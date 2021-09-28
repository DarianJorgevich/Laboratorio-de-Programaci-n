/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronbridge.preguntas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Historia implements Pregunta{
    
    private final List<String> preguntasFaciles = new ArrayList<>();
    private final List<String> preguntasDificiles = new ArrayList<>();
    private int preguntaActual = 0;
    private int resultado = 0;
    private final char[] respuestasFaciles = {'a', 'c', 'b', 'b','a','a'};
    private final char[] respuestasDificiles = {'c','b', 'b', 'a', 'a', 'c', 'b', 'a','d','b'};
    
    public Historia(){
        preguntasFaciles.add("¿Como se llama la moneda del pais? \n a) Peso b) Real c) Corona");
        preguntasFaciles.add("¿Quien es el presidente actual de Argentina? \n a) Mauricio Macri b) Cristina Fernández de Kirchner c) Alberto Fernández");
        preguntasFaciles.add("¿Quien es el creador de la bandera Argentina? \n a) Sarmiento b) Belgrano c) San Martin");
        preguntasFaciles.add("¿En que provincia se firmo el Acta de Independencia Argentina? \n a)Buenos Aires 2 b)Tucuman  c)Cordoba 5");
        preguntasFaciles.add("¿En que año se firmo el Acta de Independencia Argentina? \n a)1816 2 b) 1810 c) 1886");
        preguntasFaciles.add("¿Quien se encuentra en el billete de 50$ argentinos? \n a)Sarmiento b) Belgrano c) San Martin");
        
        preguntasDificiles.add("¿De qué nacionalidad era Juana de Arco? \n a) inglesa b) italiano c) francesa");
        preguntasDificiles.add("¿Quién dibujo al famoso Hombre de Vitruvio? \n a) Miguel Angel b) Leonardo da Vinci c) Rubens");
        preguntasDificiles.add("¿Qué famoso filósofo fue maestro de Alejandro Magno durante cinco años? \n a) Sócrates b) Aristóteles c) Platón");
        preguntasDificiles.add("¿Es la prehistoria la etapa más larga del ser humano? \n a) si b) no ");
        preguntasDificiles.add("¿A qué emperador romano asesinó un grupo de senadores? \n a) Julio César b) Nerón c) Calígula ");
        preguntasDificiles.add("¿Cuál es el antiguo nombre de San Petersburgo? \n a) San Petersburgo b) Stalingrado c) Leningrado d) Moscu ");
        preguntasDificiles.add("¿Quién nació antes Jesucristo o Mahoma? \n a) Mahoma b) Jesucristo");
        preguntasDificiles.add("¿Qué isla generó un conflicto entre Reino Unido y Argentina? \n a) Las islas malvinas b) Islas marianas c) Isla Jordan");
        preguntasDificiles.add("¿En qué país se inició la Revolución Industrial? \n a) Francia b) España c) Italia d) Gran Bretaña e) Alemania");
        preguntasDificiles.add("¿Qué ciudad fundaron los aztecas? \n a) Tulúm b) Tenochtitlán. c) Chichén Itzá");

    }
    
    @Override
    public void preguntaFacilMostrar(int num) {
        System.out.println(preguntasFaciles.get(num));
    }

    @Override
    public char preguntaFacilRespuesta(int num) {
        return respuestasFaciles[num];
    }

    @Override
    public void preguntaDificilMostrar(int num) {
        System.out.println(preguntasDificiles.get(num));
    }

    @Override
    public char preguntaDificilRespuesta(int num) {
        return respuestasDificiles[num];
    }

    @Override
    public int obtenerResultado() {
        return this.resultado;
    }

    @Override
    public int obtenerCantidadPreguntasFaciles() {
        return this.preguntasFaciles.size();
    }

    @Override
    public int obtenerCantidadPreguntasDificiles() {
        return this.preguntasDificiles.size();
    }

    @Override
    public void siguientePregunta() {
        preguntaActual++;

    }

    @Override
    public void respuestaCorrecta() {
        resultado++;

    }

    @Override
    public void limpiar() {
        preguntaActual = 0;
        resultado = 0;
    }
}
