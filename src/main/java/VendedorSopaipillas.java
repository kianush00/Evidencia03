import java.util.Arrays;

public class VendedorSopaipillas {
    //Atributos
    String nombre;
    int sopaipillasDisponibles;
    int sopaipillasCocinadas;
    int sopaipillasVendidas;
    int ketchup;   //en gramos
    int mayonesa;    //en gramos
    int mostaza;      //en gramos
    int aji;     //en gramos
    int pebre;      //en gramos
    int aceite;      //en gramos
    int harina;      //en gramos
    int precioSopaipilla;     //en CLP
    int ingresoTotal;     //en CLP
    int[] vueltoDisponible;   //Cantidad de monedas y billetes de 10, 50, 100, 500, 1000, 2000, 5000 y 10000 disponibles
    int[] vueltoRecibido;    //Cantidad de monedas y billetes recibidos hace poco
    int sumaVueltoRecibido;
    int[] vueltoAEntregar;    //Cantidad de monedas y billetes a entregar a partir de lo recibido
    int sumaVueltoAEntregar;
    int[] valoresMonedasyBilletes;     //arreglo que contiene las 8 categorías de monedas y billetes

    //Métodos
    public VendedorSopaipillas(String nombre){
        this.nombre = nombre;
        this.ketchup = 1000;
        this.mayonesa = 1000;
        this.mostaza = 1000;
        this.aji = 1000;
        this.pebre = 1000;
        this.aceite = 10000;
        this.harina = 20000;
        this.precioSopaipilla = 250;
        this.vueltoDisponible = new int[8];
        this.vueltoRecibido = new int[8];
        this.vueltoAEntregar = new int[8];
        this.valoresMonedasyBilletes = new int[8];

        for (int i=0; i < 4; i++){      //El vendedor poseerá x monedas de cada categoría como vuelto
            this.vueltoDisponible[i] = 50;
        }
        for (int i=4; i < 8; i++){      //El vendedor poseerá x billetes de cada categoría como vuelto
            this.vueltoDisponible[i] = 20;
        }
        this.valoresMonedasyBilletes[0] = 10;
        this.valoresMonedasyBilletes[1] = 50;
        this.valoresMonedasyBilletes[2] = 100;
        this.valoresMonedasyBilletes[3] = 500;
        this.valoresMonedasyBilletes[4] = 1000;
        this.valoresMonedasyBilletes[5] = 2000;
        this.valoresMonedasyBilletes[6] = 5000;
        this.valoresMonedasyBilletes[7] = 10000;
    }

    public void cocinarSopaipillas(int cantidad){
        if((cantidad * 30 >= this.aceite) && (cantidad * 60 >= this.harina)){
            this.aceite -= 30 * cantidad;
            this.harina -= 60 * cantidad;
            this.sopaipillasCocinadas += cantidad;
            this.sopaipillasDisponibles += cantidad;
        }
    }

    public void saludar(){
        System.out.println("Hola, ¿qué desea?");
    }

    public boolean sopaipillasEstanDisponibles(){
        return (sopaipillasDisponibles > 0);
    }

    public void echarKetchup(){
        if(this.ketchup >= 10){
            this.ketchup -= 10;
        }else{
            imprimirFaltaDeCondimento("ketchup");
        }
    }

    public void echarMayonesa(){
        if(this.mayonesa >= 10){
            this.mayonesa -= 10;
        }else{
            imprimirFaltaDeCondimento("mayonesa");
        }
    }

    public void echarMostaza(){
        if(this.mostaza >= 10){
            this.mostaza -= 10;
        }else{
            imprimirFaltaDeCondimento("mostaza");
        }
    }

    public void echarAji(){
        if(this.aji >= 10){
            this.aji -= 10;
        }else{
            imprimirFaltaDeCondimento("aji");
        }
    }

    public void echarPebre(){
        if(this.pebre >= 10){
            this.pebre -= 10;
        }else{
            imprimirFaltaDeCondimento("pebre");
        }
    }

    public void venderSopaipillas(int cantidad){
        this.sopaipillasVendidas += cantidad;
        this.sopaipillasDisponibles -= cantidad;
        this.ingresoTotal += (precioSopaipilla * cantidad);
    }

    public void despedirse(){
        System.out.println("¡Gracias, buen día!");
    }

    public void imprimirFaltaDeCondimento(String condimento){
        System.out.println("No queda más " + condimento + ".");
    }

    public void recibirMonedasDe10(int cantidad){
        this.vueltoRecibido[0] = cantidad;
    }

    public void recibirMonedasDe50(int cantidad){
        this.vueltoRecibido[1] = cantidad;
    }

    public void recibirMonedasDe100(int cantidad){
        this.vueltoRecibido[2] = cantidad;
    }

    public void recibirMonedasDe500(int cantidad){
        this.vueltoRecibido[3] = cantidad;
    }

    public void recibirBilletesDe1000(int cantidad){
        this.vueltoRecibido[4] = cantidad;
    }

    public void recibirBilletesDe2000(int cantidad){
        this.vueltoRecibido[5] = cantidad;
    }

    public void recibirBilletesDe5000(int cantidad){
        this.vueltoRecibido[6] = cantidad;
    }

    public void recibirBilletesDe10000(int cantidad){
        this.vueltoRecibido[7] = cantidad;
    }

    public int[] calcularVuelto(int cantidadSopaipillas){
        int vuelto[];

        calcularSumaVueltoRecibido();
        calcularSumaVueltoAEntregar(cantidadSopaipillas);
        vuelto = calcularVueltoAEntregar();

        Arrays.fill(this.vueltoRecibido,0);    //se vacía el vuelto recibido que posee el vendedor actualmente
        Arrays.fill(this.vueltoAEntregar,0);    //se vacía el vuelto a entregar que posee el vendedor actualmente
        this.sumaVueltoRecibido = 0;
        this.sumaVueltoAEntregar = 0;

        return vuelto;
    }

    public void calcularSumaVueltoRecibido(){
        for (int i=0; i<this.vueltoRecibido.length; i++){
            this.sumaVueltoRecibido += this.vueltoRecibido[i] * this.valoresMonedasyBilletes[i];
        }
    }

    public void calcularSumaVueltoAEntregar(int cantidadSopaipillas){
        this.sumaVueltoAEntregar = this.sumaVueltoRecibido - (cantidadSopaipillas * this.precioSopaipilla);
    }

    public int[] calcularVueltoAEntregar(){
        for (int i=0; i<this.vueltoDisponible.length; i++){
            if(this.sumaVueltoAEntregar > this.valoresMonedasyBilletes[valoresMonedasyBilletes.length - (i + 1)]){
                this.vueltoAEntregar[vueltoAEntregar.length - (i + 1)] = this.sumaVueltoAEntregar / this.valoresMonedasyBilletes[valoresMonedasyBilletes.length - (i + 1)];
            }
        }

        return this.vueltoAEntregar;
    }
}