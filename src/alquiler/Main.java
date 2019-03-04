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

        //Generamos clientes aleatorios y los mostramos por pantalla
        easydrive.generarClientesAlea();
        easydrive.imprimirClientes();
        
        //Generamos vehiculos aleatorios y los mostramos por pantalla
        easydrive.generarVehiculosAlea();
        easydrive.imprimirVehiculos();
        
        //Solicitamos un nif, una matricula y el número de dias que queremos alquilar
        //un vehiculo
        System.out.println("Introduce un nif: ");
        String nif=teclado.nextLine();
        System.out.println("Introduce una matricula: ");
        String matricula=teclado.nextLine();
        System.out.println("Introduce numero de dias para alquilar un vehiculo: ");
        int dias=teclado.nextInt();
        
        teclado.nextLine();
        
        //Alquilamos el vehiculo con los datos anteriores
        easydrive.alquilarVehiculo(matricula, nif, dias);
        
        System.out.println(easydrive.toString());
        
        //Ordenamos clientes y los mostramos por pantalla
        easydrive.ordenarCarteraClientes();
        easydrive.imprimirClientes();
        
        //Ordenamos vehiculos y los mostramos por pantalla
        easydrive.ordenarCatalogoVehiculos();
        easydrive.imprimirVehiculos();
        
        //Hacemos una busqueda de la matricula
        System.out.println("Introduce una matricula a buscar: ");
        String buscaMatr=teclado.nextLine();
        System.out.println(easydrive.busquedaVehiculo(buscaMatr));
        
        //Hacemos una busqueda de los clientes
        System.out.println("Introduce un cliente a buscar: ");
        String buscaCli=teclado.nextLine();
        System.out.println(easydrive.busquedaCliente(buscaCli));
        
    }
}
   
