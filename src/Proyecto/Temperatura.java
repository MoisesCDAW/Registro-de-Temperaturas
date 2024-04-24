
package Proyecto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MoisesC
 */
public class Temperatura implements Serializable{
    /**
     * Atributo temperatura de tipo primitivo "int". Se trabajará con la medida de grandos centígrados 
     */
    private int temperatura;
    /**
     * Atributo fecha de tipo LocalDate, para referenciar a la fecha y hora en la que se tomó la temperatura
     */
    private final LocalDateTime fecha;
    /**
     * Atributo histórico que almacena temperaturas y las fechas en las que fueron tomadas
     * Se implementa Collection -> Set -> TreeSet, a modo de conjunto de datos ya que estos no se pueden repetir
     * y se busca solo el orden de entrada
     */
    private static List<Temperatura> historico = new ArrayList<>();
    
    
    /**
     * Constructor
     * Se pide una temperatura y se le asigna por defecto la hora del sistema con now() de la clase LocalDate
     * @param temperatura
     */
    public Temperatura(int temperatura){
        this.fecha = LocalDateTime.now();
        setTemperatura(temperatura);
    }
     
    // Métodos
    
    /**
     * @return Cadeta de texto que muestra información sobre el objeto
     */
    @Override           
    public String toString(){
        return String.format("\nDETALLES DE LA TEMPERATURA\nTemperatura: %d ºC\nCon fecha: %s\n", this.temperatura, this.fecha);
    }
    
    /**
     * Compara la igualdad de dos objetos del mismo tipo
     * @param t
     * @return True o False si los objetos comparados son iguales
     */
    @Override
    public boolean equals(Object t){ 
        Temperatura t1 = (Temperatura)t;
        return this.temperatura==t1.temperatura &&
                this.fecha.equals(t1.fecha);     
    }
    
    /**
     * Dedicado a agregar una nueva temperatura al histórico
     * @param temperatura 
     */
    public static void addTemperatura(Temperatura temperatura){
        historico.add(temperatura);
    }
    
    /**
     * Atributo temperatura de tipo primitivo "int". Se trabajará con la medida de grandos centígrados
     * @return the temperatura
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * Atributo temperatura de tipo primitivo "int". Se trabajará con la medida de grandos centígrados
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Atributo fecha de tipo LocalDate, para referenciar a la fecha y hora en la que se tomó la temperatura
     * @return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Atributo histórico que almacena temperaturas y las fechas en las que fueron tomadas
     * Se implementa Collection -> Set -> TreeSet, a modo de conjunto de datos ya que estos no se pueden repetir
     * y se busca solo el orden de entrada
     * @return the historico
     */
    public static List<Temperatura> getHistorico() {
        return historico;
    }

    
    
}
