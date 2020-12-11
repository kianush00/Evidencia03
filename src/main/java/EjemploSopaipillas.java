public class EjemploSopaipillas {
    public static void main(String[] args) {
        VendedorSopaipillas miVendedor = new VendedorSopaipillas("Juan");
        miVendedor.saludar();
        miVendedor.cocinarSopaipillas(10);
        System.out.println(miVendedor.sopaipillasEstanDisponibles());
        miVendedor.echarMayonesa();
        miVendedor.echarKetchup();
        miVendedor.echarAji();
        miVendedor.venderSopaipillas(3);
        miVendedor.despedirse();
        miVendedor.recibirMonedasDe100(2);
        miVendedor.recibirMonedasDe50(1);
    }
}
