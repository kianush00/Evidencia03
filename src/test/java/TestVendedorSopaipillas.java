import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestVendedorSopaipillas {
    private VendedorSopaipillas v;
    private int aceiteInicial;
    private int aceiteFinal;
    private int harinaInicial;
    private int harinaFinal;
    private int salsaInicial;
    private int salsaFinal;
    private int vueltoInicial;
    private int vueltoFinal;
    private int sopaipillasDisponiblesInicial;
    private int sopaipillasDisponiblesFinal;
    private int cantidadSopaipillas;


    @Before
    public void setUp() throws Exception {
        v = new VendedorSopaipillas("Pedro");
    }

    @After
    public void tearDown() throws Exception {
        v = null;
        aceiteInicial = 0;
        aceiteFinal = 0;
        harinaInicial = 0;
        harinaFinal = 0;
        salsaInicial = 0;
        salsaFinal = 0;
        vueltoInicial = 0;
        vueltoFinal = 0;
        cantidadSopaipillas = 0;
        sopaipillasDisponiblesInicial = 0;
        sopaipillasDisponiblesFinal = 0;
    }

    @Test
    //Probar que el aceite se usa adecuadamente
    public void testCocinarSopaipillas01(){
        aceiteInicial = v.aceite;
        cantidadSopaipillas = 10;
        v.cocinarSopaipillas(cantidadSopaipillas);
        aceiteFinal = aceiteInicial - (cantidadSopaipillas * 30);
        assertEquals(aceiteFinal, v.aceite);
    }

    @Test
    //Probar que la harina se usa adecuadamente
    public void testCocinarSopaipillas02(){
        harinaInicial = v.harina;
        cantidadSopaipillas = 10;
        v.cocinarSopaipillas(cantidadSopaipillas);
        harinaFinal = harinaInicial - (cantidadSopaipillas * 60);
        assertEquals(harinaFinal, v.harina);
    }

    @Test
    public void testCocinarSopaipillas03(){
        v.sopaipillasDisponibles = 20;
        sopaipillasDisponiblesInicial = v.sopaipillasDisponibles;
        cantidadSopaipillas = 15;
        v.cocinarSopaipillas(cantidadSopaipillas);
        sopaipillasDisponiblesFinal = sopaipillasDisponiblesInicial + cantidadSopaipillas;
        assertEquals(35, sopaipillasDisponiblesFinal);
    }

    @Test
    public void testSopaipillasEstanDisponibles01(){
        v.sopaipillasDisponibles = 0;
        assertFalse(v.sopaipillasEstanDisponibles());
    }

    @Test
    public void testEcharSalsa01(){
        salsaInicial = v.ketchup;
        v.echarKetchup();
        salsaFinal = salsaInicial - 10;
        assertEquals(salsaFinal,v.ketchup);
    }

    @Test
    //Probar que no se eche una cierta salsa en caso de que esté agotada
    public void testEcharSalsa02(){
        v.mayonesa = 5;
        salsaInicial = v.mayonesa;
        v.echarMayonesa();
        salsaFinal = v.mayonesa;
        assertEquals(salsaFinal,salsaInicial);
    }

    @Test
    public void testVenderSopaipillas01(){

    }

    @Test
    public void testRecibirMonedasDe100(){
        vueltoInicial = v.vueltoRecibido[2];
        v.recibirMonedasDe100(5);
        vueltoFinal = v.vueltoRecibido[2] - vueltoInicial;   //arreglo ubicado en la posición de las monedas de 100
        assertEquals(5,vueltoFinal);
    }
}