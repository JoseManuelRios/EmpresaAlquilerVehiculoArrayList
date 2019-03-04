/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jriosaguilar
 */
public class Empresa {
    
    //Atributos
    private String cif;
    private String nombre;
    private String paginaWeb;
    
    /*Atributos para almacenar el total de clientes que tiene la empresa y array 
    de almacenamiento para los objetos Cliente*/
    private int totalClientes;
    private ArrayList<Cliente> clientes=new ArrayList<>();
    
    /*Atributos para controlar el total de vehiculos disponibles para alquilar en 
    la empresa y array de almacenamiento para los objetos Vehiculo*/
    private int totalVehiculos;
    private ArrayList<Vehiculo> vehiculos=new ArrayList<>();;
    
    /*Atributos para controlar el histórico de alquileres: total de alquileres 
    realizados y array de almacenamiento para los objetos VehiculoAlquilado*/
    private int totalAlquileres;
    private ArrayList<VehiculoAlquilado> alquileres=new ArrayList<>();
    
    //Metodos
    /*Constructor parametrizado */
    public Empresa(String cif, String nombre, String paginaWeb){
        this.cif=cif;
        this.nombre=nombre;
        this.paginaWeb=paginaWeb;
        
        //Inicialmente la empresa no tiene clientes. No es necesario darle una longitud
        //a los clientesya que al ser una lista, esta incrementará o disminuirá su capacidad
        //según introduzcamos clientes o los eliminemos
        this.totalClientes=0;
        
        //Inicialmente la empresa no tiene vehiculos
        this.totalVehiculos=0;
        
        //Inicialmente la empresa no tiene alquileres
        this.totalAlquileres=0;
    }
    
    //Método para registrar un cliente
    public void registrarCliente(Cliente nuevo){
        clientes.add(nuevo);
        this.totalClientes++;
    }
    
    //Método para registrar un vehiculo
    public void registrarVehiculo(Vehiculo nuevo){
        vehiculos.add(nuevo);
        this.totalVehiculos++;
    }
    
    //Método para mostrar los datos de un cliente de la empresa
    public void imprimirClientes() {
        for (int x=0; x<this.totalClientes; x++){
            System.out.println("NIF: "+clientes.get(x).getNif()+"\tNombre: "+clientes.get(x).getNombre()+
                    "\tApellidos: "+clientes.get(x).getApellidos());
        }
    }
    
    //Método para mostrar los vehiculos de la empresa
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int x=0; x<this.totalVehiculos; x++){
            System.out.println("Matricula: "+vehiculos.get(x).getMatricula()+"\tModelo: "+vehiculos.get(x).getModelo()+
                    "\tColor: "+vehiculos.get(x).getColor()+"\tImporte: "+vehiculos.get(x).getTarifa()+"\tDisponible: "+vehiculos.get(x).isDisponible());
        }
    }
    
    //Metodo para obtener el cliente
    private Cliente getCliente(String nif) {
        for (int x=0; x<this.getTotalClientes(); x++){
            if (this.clientes.get(x).getNif().equals(nif)){
                return this.clientes.get(x);
            }
        }
        return null;
    }
    
    //Metodo para obtener el vehiculo
    private Vehiculo getVehiculo(String matricula) {
        for (int x=0; x<this.getTotalVehiculos(); x++){
            if (this.vehiculos.get(x).getMatricula().equals(matricula))
                return this.vehiculos.get(x);
            }
        return null;
    }
    
    //Método para alquilar un vehiculo
    public void alquilarVehiculo(String matricula, String nif, int dias){
        Cliente cliente=getCliente(nif);
        Vehiculo vehiculo=getVehiculo(matricula);
        if (vehiculo.isDisponible()){
            vehiculo.setDisponible(false);
            this.alquileres.add(new VehiculoAlquilado(cliente, vehiculo, diaHoy(), mesHoy(), anioHoy(), dias));
        }
    }
    
    //Metodo para poner un vehiculo a estado disponible para alquilar
    public void recibirVehiculo(String matricula) {
    // busca el vehículo con la matrícula dada en el
    // array vehiculos y modifica su disponibilidad
    // para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null){
            vehiculo.setDisponible(true);
        }
    }
    
    public void generarVehiculosAlea(){
        for(int x=0;x<50;x++){
            this.vehiculos.add(new Vehiculo());
        }
        this.totalVehiculos=50;
    }
    
    public void generarClientesAlea(){
        for(int x=0;x<50;x++){
            this.clientes.add(new Cliente());
        }
        this.totalClientes=50;
    }
    
    //Método para ordenar clientes del array por medio de la burbuja
    public void ordenarClientes(){
        for(int x=0;x<this.clientes.size()-1;x++){
            for(int y=x+1;y<this.clientes.size();y++){
                if(clientes.get(x).getNif().compareTo(clientes.get(y).getNif())>0){
                    Cliente tmp;
                    tmp=clientes.get(x);
                    clientes.set(x,clientes.get(y));
                    clientes.set(y, tmp);
                }
            }
        }
    }
    
    //Método para ordenar vehiculos del array por medio de la burbuja
    public void ordenarVehiculos(){
        for(int x=0;x<this.vehiculos.size()-1;x++){
            for(int y=x+1;y<vehiculos.size();y++){
                if(vehiculos.get(x).getMatricula().compareTo(vehiculos.get(y).getMatricula())>0){
                    Vehiculo tmp;
                    tmp=vehiculos.get(x);
                    vehiculos.set(x,vehiculos.get(y));
                    vehiculos.set(y, tmp);
                }
            }
        }
    }
    
    //Método para hacer una busqueda binaria en los clientes
    public int busquedaCliente(String nif){
        int mitad;
        int limiteInferior=0;
        int limiteSuperior=this.clientes.size()-1;
        boolean encontrado=false;
        while((limiteInferior<=limiteSuperior)&&(!encontrado)){
            mitad=(limiteInferior+limiteSuperior)/2;
            if(this.clientes.get(mitad).getNif()==nif){
                return mitad; // ¡encontrado!
            }else if(this.clientes.get(mitad).getNif().compareTo(nif)>0){
                limiteSuperior=mitad-1; // buscar en la primera mitad
            }else{
                limiteInferior=mitad+1; // buscar en la segunda mitad
            }
        }
        return -1;
    }
  
    //Método para hacer una busqueda binaria en los vehiculos
    public int busquedaVehiculo(String matricula){
        int mitad;
        int limiteInferior=0;
        int limiteSuperior=this.vehiculos.size()-1;
        boolean encontrado=false;
        while((limiteInferior<=limiteSuperior)&&(!encontrado)){
            mitad=(limiteInferior+limiteSuperior)/2;
            if(this.vehiculos.get(mitad).getMatricula()==matricula){
                return mitad; // ¡encontrado!
            }else if(this.vehiculos.get(mitad).getMatricula().compareTo(matricula)>0){
                limiteSuperior=mitad-1; // buscar en la primera mitad
            }else{
                limiteInferior=mitad+1; // buscar en la segunda mitad
            }
        }
        return -1;
    }

    //Getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public ArrayList<VehiculoAlquilado> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
        this.alquileres = alquileres;
    } 
    
    public LocalDate diaHoy(){
        LocalDate hoy=LocalDate.now();
        hoy.getDayOfMonth();
        return hoy;
    }
    
    public LocalDate mesHoy(){
        LocalDate mes=LocalDate.now();
        mes.getMonth();
        return mes;
    }
    
    public LocalDate anioHoy(){
        LocalDate anio=LocalDate.now();
        anio.getYear();
        return anio;
    } 
    
}
