
package Proyecto;

import java.util.Comparator;

/**
 *
 * @author MoisesC
 */
public class ComparaFecha implements Comparator<Temperatura>{

    /**
     * Con objetivo de establecer un orden por Fechas dentro una colección ArrayList
     * @param o1 tipo temperatura
     * @param o2 tipo temperatura
     * @return -1, 1 o 0 según la comparativa realizada
     */
    @Override
    public int compare(Temperatura o1, Temperatura o2) { 
        return o1.getFecha().compareTo(o2.getFecha());
    }
    
}
