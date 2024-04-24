
package Principal;

import Proyecto.ComparaTemp;
import Proyecto.Temperatura;

/**
 *
 * @author MoisesC
 */
public class Main {

    /**
     * Método Main del proyecto "Temperaturas"
     * @param args tipo String[]
     */
    public static void main(String[] args) {
        Temperatura t1 = new Temperatura(15);
        Temperatura t2 = new Temperatura(10);
        Temperatura t3 = new Temperatura(20);
        
        Temperatura.addTemperatura(t1);
        Temperatura.addTemperatura(t2);
        Temperatura.addTemperatura(t3);
        System.out.println(Temperatura.getHistorico());
        
        System.out.println("\n------------- Histórico ordenado por temperaturas --------------\n");
        
        Temperatura.getHistorico().sort(new ComparaTemp());
        System.out.println(Temperatura.getHistorico());
    }
    
    
}
