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
}
















