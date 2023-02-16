package Test;

import modelos.*;

import java.time.LocalDate;

public class PruebaV1 {


    public static void main(String[] args) {



        Almacen almacen1 = new Almacen();

        almacen1.setCapacidad(12000);
        almacen1.setIdentificador(6544217);
        almacen1.setNombre("Felipe SA");

        Producto champu = new Producto();

        champu.setAlmacen(almacen1);
        champu.setIdentificador(213424);
        champu.setCodigo("asdgretbre");
        champu.setDescripcion("Para un pelo suave y sedoso");
        champu.setTipoProducto(TipoProducto.DROGUERIA);
        champu.setFechaCaducidad(LocalDate.of(2026 ,3 ,10));


        Cliente cliente1 = new Cliente();

        cliente1.setNombre("Juan");
        cliente1.setApellidos("Loco Suarez");
        cliente1.setDireccion("Calle Marchena nº5");
        cliente1.setIdentificador(241253);
        cliente1.setTipoCliente(TipoCliente.PARTICULAR);
        cliente1.setIdentificador(534562);

        System.out.println(almacen1+"\n"+champu+"\n"+ cliente1);






    }

}

