package utilidades;

import com.github.javafaker.Faker;
import modelos.*;
import modelos.Factura;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenerarDatos {

    private static Faker faker = new Faker();


    public static List<Factura> generarFactura(int numFacturas , Cliente clientes , List<LineaFactura> ListaFactura){

        List<Factura> facturaList = new ArrayList<>();
        int numeroAleatorio = faker.number().numberBetween(1, 15);
        for(int i = 0 ; i < numFacturas; i++) {

            Factura factura = new Factura();
            factura.setCodigoFactura(String.valueOf(faker.number().numberBetween(100000, 9999999)));
            factura.setIdentificador(faker.number().numberBetween(5,10));
            factura.setLineaFactura(ListaFactura);
            factura.setDescuento(faker.number().randomDouble(2,5,5000));
            factura.setFechaEmision(faker.date().past(1000, TimeUnit.HOURS).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            factura.setCliente(clientes);
            factura.setIva(faker.number().randomDouble(2,1,100000));
            factura.setFechaVencimiento(LocalDate.now());
            factura.setImporteBase(faker.number().randomDouble(2,1,200000));
            factura.setPagada(faker.bool().bool());










        }

        return facturaList;
    }





    public static List<Cliente> generarClientes(int numClientes){

        List<Cliente> listaClientes = new ArrayList<>();


        for (int i=0; i<numClientes;i++){
            Cliente cliente = new Cliente();
            cliente.setTipoCliente(TipoCliente.values()[faker.number().numberBetween(0,100)]);
            cliente.setDireccion(faker.address().city());
            cliente.setNombre(faker.dragonBall().character());
            cliente.setApellidos(faker.cat().name());
            cliente.setDni(String.valueOf(faker.idNumber()));
            cliente.setIdentificador(faker.number().randomDigit());



            listaClientes.add(cliente);
        }

        return listaClientes;
    }

    public static List<Almacen> generarAlmacenAleatorio(int numAlmacen){

        List<Almacen> listaalmacenes= new ArrayList<>();

        for (int i= 0; i <numAlmacen;i++) {
            Almacen almacen = new Almacen();
            almacen.setNombre(faker.dog().name());
            almacen.setCapacidad(faker.number().numberBetween(1000, 100000));
            almacen.setIdentificador(faker.number().numberBetween(12345, 1234256));

            listaalmacenes.add(almacen);
        }
        return listaalmacenes;
    }

    public static List<Producto> generadorProductos(int numProductos){

        List<Producto> listaProductos = new ArrayList<>();

        for(int i=0;i>numProductos;i++){

            Producto producto = new Producto();

            producto.setTipoProducto((TipoProducto.values()[faker.number().numberBetween(0,2)]));
            producto.setDescripcion(faker.pokemon().name());
            producto.setCodigo(String.valueOf(faker.number().numberBetween(0,100000)));
            producto.setAlmacen(generarAlmacenAleatorio(1).get(0));
            producto.setIdentificador(faker.number().numberBetween(10,100000));
            producto.setFechaCaducidad(LocalDate.now());
            producto.setPrecio(faker.number().randomDouble(2,1,10000));

            listaProductos.add(producto);

        }

        return listaProductos;

    }


    public static List<LineaFactura> generadorLineaFacturas(int numLineaFactura){

        List<LineaFactura> listaLineaFacturas = new ArrayList<>();

        for(int i=0;i<numLineaFactura;i++){

            LineaFactura lineaFactura = new LineaFactura();

            lineaFactura.setFactura(generarFactura(1).get(0));
            lineaFactura.setCantidad(faker.number().numberBetween(1,100000));
            lineaFactura.setProducto(generadorProductos(1).get(0));
            lineaFactura.setIdentificador(faker.number().numberBetween(1,100000));

            listaLineaFacturas.add(lineaFactura);

        }

        return listaLineaFacturas;

    }

    public static List<Contrato> generadorContratos(int numContratos){


        List<Contrato> listaContratos = new ArrayList<>();

        for (int i=0; i<numContratos;i++){

            Contrato contrato = new Contrato();

            contrato.setTipoContrato(TipoContrato.values()[faker.number().numberBetween(0,3)]);
            contrato.setIdentificador(faker.number().numberBetween(1,100000));
            contrato.setSalarioBase(faker.number().randomDouble(2,1,10000));

            listaContratos.add(contrato);

        }
        return listaContratos;
    }

    public static List<Empresa> generadorEmpresas(int numEmpresas, List<Empleado> empleados){

        List<Empresa> listaEmpresas=new ArrayList<>();

        for ( int i = 0;i<numEmpresas;i++){

            Empresa empresa = new Empresa();
            empresa.setCodigoEmpresa(String.valueOf(faker.number().numberBetween(1,10000)));
            empresa.setTipoEmpresa(TipoEmpresa.values()[faker.number().numberBetween(0,3)]);
            empresa.setIdentificador(faker.number().numberBetween(1,100000));
            empresa.setEmpleados(empleados);
            listaEmpresas.add(empresa);

        }
        return listaEmpresas;
    }

    public static List<Empleado> generadorEmpleados(int numEmpleados, Empresa empresas, Contrato contratos){


        List<Empleado> listaEmpleado = new ArrayList<>();

        for (int i = 0 ; i<numEmpleados;i++) {
            Empleado empleado = new Empleado();
            empleado.setNombre(faker.artist().name());
            empleado.setApellidos(faker.color().name());
            empleado.setContrato(contratos);
            empleado.setIdentificador(faker.number().numberBetween(1,1000000));
            empleado.setDireccion(faker.address().firstName());
            empleado.setEmpresa(empresas);
            empleado.setNumTelf(faker.phoneNumber().phoneNumber());
            empleado.setDni(faker.idNumber().toString());



        }
        return listaEmpleado;
    }

}
