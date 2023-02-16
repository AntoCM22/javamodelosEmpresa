package utilidades;

import modelos.Cliente;

public class UtilidadesCliente {



    public Boolean esDniValido(Cliente cliente){

       return cliente.getDni().length() == 9 &&
               cliente.getDni().matches("[0-9]{8} [A-Z] {1}]" );


    }
}
