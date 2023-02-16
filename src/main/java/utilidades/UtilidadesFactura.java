package utilidades;

import modelos.Cliente;
import modelos.Factura;
import modelos.LineaFactura;
import modelos.Producto;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {


    public Boolean esFacturaVencida(Factura factura){


        if(factura.getFechaVencimiento().equals(LocalDate.now()) || factura.getFechaVencimiento().isAfter(LocalDate.now())){


            return true;}

        else{
            return false;
            }



    }




    public Double calculaBaseFactura(Factura factura){

        Double importeBase = 0.0;


        for(LineaFactura linea :factura.getLineaFactura()){

            importeBase+= linea.getProducto().getPrecio()* linea.getCantidad();
        }


        return importeBase;
    }



    public Double calcularTotalAPagar(Factura factura){

        Double totalAPagar = 0.0;

        totalAPagar+=(factura.getImporteBase()-factura.getDescuento())* factura.getIva();

        return totalAPagar;


    }


    public Double gastoTotalCliente(List<Factura> facturas, Cliente
            cliente){

        Double SumatotalFacturas = 0.0;


        for(Factura factura : facturas){

            if (factura.getCliente().equals(cliente)){

                SumatotalFacturas += factura.getTotalApagar();

            }


        }
        return SumatotalFacturas;

    }

}
