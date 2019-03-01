/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.Scanner;

/**
 *
 * @author jriosaguilar
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        
        // la instancia easydrive de la clase Empresa
        Empresa easydrive = new Empresa("A-28-187189", "easy drive", "www.easydrive.com");
        
        // registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("85618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("67568991Y", "Luis", "Fernández Gómez"));

        // registro de los vehículos de la empresa
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang",

        "Rojo", 150.0, true));

        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));
        
        // imprime la relación de clientes de easydrive
        easydrive.imprimirClientes();
        
        // imprime el catálogo de vehículos de easydrive
        easydrive.imprimirVehiculos();
        
        //Generamos un solo cliente aleatorio
        Cliente c1=new Cliente();
        
        //Generamos un solo vehiculo aleatorio
        Vehiculo v1=new Vehiculo();

        //Generamos clientes aleatorios y los mostramos por pantalla
        easydrive.generarClientesAlea();
        easydrive.imprimirClientes();
        
        //Generamos vehiculos aleatorios y los mostramos por pantalla
        easydrive.generarVehiculosAlea();
        easydrive.imprimirVehiculos();
        
        //Ordenamos clientes y los mostramos por pantalla
        easydrive.ordenarClientes();
        easydrive.imprimirClientes();
        
        //Ordenamos vehiculos y los mostramos por pantalla
        easydrive.ordenarVehiculos();
        easydrive.imprimirVehiculos();
        
        //Hacemos una busqueda de la matricula
        System.out.println("Introduce una matricula a buscar: ");
        String buscaMatr=teclado.nextLine();
        System.out.println(easydrive.busquedaVehiculo(buscaMatr));
        
        //Hacemos una busqueda de los clientes
        System.out.println(easydrive.busquedaCliente("85618927C"));
        
        //Alquilamos un vehiculo pasandole un cliente, un vehiculo y el número
        //de días que se alquila
        easydrive.alquilarVehiculo(v1.getMatricula(), c1.getNif(), 10);
    }
}
   
