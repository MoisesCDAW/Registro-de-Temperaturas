
package Proyecto;

import java.io.*;
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
     * @param temperatura con valor entero en ºC
     */
    public Temperatura(int temperatura){
        this.fecha = LocalDateTime.now();
        setTemperatura(temperatura);
    }
     
    // Métodos
    
    /**
     * Para guardar el histórico en un fichero binario. El fichero se guarda en la carpeta "Downloads" del equipo
     * y se agrega como cabecera la fecha en que se hizo el último guardado
     * @param histoT colección de objetos Temperatura
     */
    public static void guardarHistorico(List<Temperatura> histoT){
        String fechaGuardado = String.valueOf(LocalDateTime.now());
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\moise\\Downloads\\historicoTemps.dat"))){
//            out.writeObject(fechaGuardado);
            out.writeObject(histoT);
            System.out.println("\nHistórico guardado correctamente.\n");
 
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado.");
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * 
     * @param rutaFichero pasado en formato String: "C:\\raiz\\usuario\\origen\\fichero.dat"
     * @param HistoT colección donde se guardará el histórico que se leerá
     * @return colección del histórico
     */
    public static List<Temperatura> leerHistorico(String rutaFichero, List<Temperatura> HistoT){
        
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream(rutaFichero))){
            while (true) {
                HistoT = (List<Temperatura>) input.readObject();
            }
        
        } catch (EOFException ex) {
            System.out.println("Fin de la lectura.\n");
        }
        catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        
        return HistoT;
    
    }
    
    /**
     * Método capaz de leer y guardar el histórico de un fichero binario externo dentro de nuestro programa
     * @return Cadena de texto que muestra información sobre el objeto
     */
    @Override           
    public String toString(){
        return String.format("\nDETALLES DE LA TEMPERATURA\nTemperatura: %d ºC\nCon fecha: %s\n", this.temperatura, this.fecha);
    }
    
    /**
     * Compara la igualdad de dos objetos del mismo tipo
     * @param t objecto de tipo Temperatura
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
     * @param temperatura con valor entero en ºC
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
     * Se implementa Collection - Set - TreeSet, a modo de conjunto de datos ya que estos no se pueden repetir
     * y se busca solo el orden de entrada
     * @return the historico
     */
    public static List<Temperatura> getHistorico() {
        return historico;
    }
 
}
