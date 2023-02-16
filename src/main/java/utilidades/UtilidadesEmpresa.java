package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {



    public List<Empleado> getEmpleadosPorContrato(Empresa empresa , TipoContrato tipoContrato){


        List<Empleado> listaEmpleadosPertenecientes= new ArrayList<>();

        for (Empleado empleadoperteneciente : empresa.getEmpleados()){

            if (empleadoperteneciente.getContrato().getTipoContrato().equals(tipoContrato)){

                listaEmpleadosPertenecientes.add(empleadoperteneciente);
            }

        }
        return listaEmpleadosPertenecientes;

    }
    public List<Empleado> getEmpleadosPorContrato2(Empresa empresa , TipoContrato tipoContrato){

        return empresa.getEmpleados().stream().filter(e->e.getContrato().getTipoContrato().equals(tipoContrato)).collect(Collectors.toList());

    }


    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){

        List<Empleado> empleadosConPasta = new ArrayList<>();

        for (Empleado empleadoConSalario : empresa.getEmpleados() ){

            if(empleadoConSalario.getContrato().getSalarioBase()>=1000){

                empleadosConPasta.add(empleadoConSalario);

            }

        }

        empleadosConPasta.sort(Comparator.comparing(e->e.getContrato().getSalarioBase()));

        return empleadosConPasta;
    }


    public double fondoSalarialEmpresa(Empresa empresa){

        Double SumaTotal = 0.0;



        for(Empleado empleadito : empresa.getEmpleados()){

            if(empleadito.getEmpresa().equals(empresa)){

                SumaTotal+=empleadito.getContrato().getSalarioBase();

            }

        }

        return SumaTotal;


    }


    public Empleado getMejorPagado(List<Empresa> empresas){

        List<Empleado> empleados_empresas = new ArrayList<>();

        for(Empresa empresa : empresas){
            for(Empleado empleados : empresa.getEmpleados()){

                empleados_empresas.add(empleados);

            }
        }



        empleados_empresas.sort(Comparator.comparing(empleado -> empleado.getContrato().getSalarioBase()));


        return empleados_empresas.get(0);

    }



    public Map<TipoContrato, List<Empleado>>
    getEmpleadosPorTipoContrato(Empresa empresas){

        Map<TipoContrato , List <Empleado>> mapita = new HashMap<>();


        for (TipoContrato tipofacil : TipoContrato.values()){

        mapita.put(tipofacil , new ArrayList<>());

        }

        for (Empleado empleado : empresas.getEmpleados()){

            mapita.get(empleado.getContrato().getTipoContrato()).add(empleado);
        }

        return mapita;

    /// java8 ==  return empresas.getEmpleados().stream().collect(Collectors.groupingBy(e->e.getContrato().getTipoContrato()));


    }

//    public Map<Empresa, Map<TipoContrato, List<Empleado>>>
//    getEmpleadosPorTipoContrato(List<Empresa> empresas){
//
//        Map<Empresa, Map<TipoContrato, List<Empleado>>> mapa1 = new HashMap<>();
//
//        for (Empresa empresita : empresas){
//
//            Map<TipoContrato, List<Empleado>> mapa2 = new HashMap<>();
//
//            mapa1.put(empresita , mapa2);
//
//            for (Empleado empleadito : empresita.getEmpleados()){
//
//                if(empleadito.getContrato().getTipoContrato().equals(TipoContrato.OBRAYSERVICIO)){
//
//                    mapa2.get(TipoContrato.OBRAYSERVICIO).add(empleadito);
//
//                if(empleadito.getContrato().getTipoContrato().equals(TipoContrato.INDEFINIDO)){
//
//                    mapa2.get(TipoContrato.INDEFINIDO).add(empleadito);
//
//
//                if(empleadito.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
//
//                    mapa2.get(TipoContrato.PRACTICAS).add(empleadito);
//
//                if(empleadito.getContrato().getTipoContrato().equals(TipoContrato.TEMPORAL)) {
//
//                    mapa2.get(TipoContrato.TEMPORAL).add(empleadito);
//
//                }
//                }
//
//        return mapa2;
//    }
//

    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas){

        List <Empleado> EmpleadosEmpresaYpracticas = new ArrayList<>();

        for (Empresa miempresa : empresas){

            if(miempresa.getTipoEmpresa().equals(TipoEmpresa.PYME))

            for( Empleado miempleado : miempresa.getEmpleados()){

                if (miempleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){

                    EmpleadosEmpresaYpracticas.add(miempleado);
                }

            }
        }

        return EmpleadosEmpresaYpracticas;
    }



    public Map<Empresa,Empleado>
    getLosMejorPagadosPorEmpresa(List<Empresa> empresas){

        Map<Empresa,Empleado> mapamejorpagado = new HashMap<>();
        Empleado empleadomessi = null;

        for(Empresa empresita2:empresas){

            for(Empleado empleadoMejor : empresita2.getEmpleados()){

                if(empleadomessi == null ||empleadoMejor.getContrato().getSalarioBase()>empleadomessi.getContrato().getSalarioBase()){

                    empleadomessi = empleadoMejor;
                }
            }
            mapamejorpagado.put(empresita2, empleadomessi);
        }
         return mapamejorpagado;

    }






}
