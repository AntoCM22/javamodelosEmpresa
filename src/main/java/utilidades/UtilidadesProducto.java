package utilidades;

import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UtilidadesProducto {


    public List<Producto>getPorTipo(List<Producto> productos , TipoProducto tipo){



        List ProductosDelTipo = new ArrayList<>();

        for (Producto producto : productos ){

            if (producto.getTipoProducto().equals(tipo)){

                ProductosDelTipo.add(producto);

            }

        }

        List<Producto> listaProductosFiltrado = productos.stream().filter(p-> p.getTipoProducto().equals(tipo)).collect(Collectors.toList());

        return listaProductosFiltrado;
        }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){


        List productosAlmacen = new ArrayList<>();

        for (Producto producto : productos ){

            if (producto.getAlmacen().equals(almacen)){

                productosAlmacen.add(producto);

            }

        }
        List<Producto> listaProductoEnAlmacen = productos.stream().filter(p->p.getAlmacen().equals(almacen)).collect(Collectors.toList());
        return productosAlmacen;


    }

}
