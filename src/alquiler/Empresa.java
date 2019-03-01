/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.time.LocalDate;

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
    private Cliente[] clientes;
    
    /*Atributos para controlar el total de vehiculos disponibles para alquilar en 
    la empresa y array de almacenamiento para los objetos Vehiculo*/
    private int totalVehiculos;
    private Vehiculo[] vehiculos;
    
    /*Atributos para controlar el histórico de alquileres: total de alquileres 
    realizados y array de almacenamiento para los objetos VehiculoAlquilado*/
    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;
    
    //Metodos
    /*Constructor parametrizado */
    public Empresa(String cif, String nombre, String paginaWeb){
        this.cif=cif;
        this.nombre=nombre;
        this.paginaWeb=paginaWeb;
        
        //Inicialmente la empresa no tiene clientes
        this.totalClientes=0;
        this.clientes=new Cliente[50];
        
        //Inicialmente la empresa no tiene vehiculos
        this.totalVehiculos=0;
        this.vehiculos=new Vehiculo[50];
        
        //Inicialmente la empresa no tiene alquileres
        this.totalAlquileres=0;
        this.alquileres=new VehiculoAlquilado[100];
    }
    
    //Método para registrar un cliente
    public void registrarCliente(Cliente nuevo){
        this.clientes[this.totalClientes]=nuevo;
        this.totalClientes++;
    }
    
    //Método para registrar un vehiculo
    public void registrarVehiculo(Vehiculo nuevo){
        this.vehiculos[this.totalVehiculos]=nuevo;
        this.totalVehiculos++;
    }
    
    //Método para mostrar los datos de un cliente de la empresa
    public void imprimirClientes() {
        for (int x=0; x<this.totalClientes; x++){
            System.out.println("NIF: "+clientes[x].getNif()+"\tNombre: "+clientes[x].getNombre()+
                    "\tApellidos: "+clientes[x].getApellidos());
        }
    }
    
    //Método para mostrar los vehiculos de la empresa
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int x=0; x<this.totalVehiculos; x++){
            System.out.println("Matricula: "+vehiculos[x].getMatricula()+"\tModelo: "+vehiculos[x].getModelo()+
                    "\tColor: "+vehiculos[x].getColor()+"\tImporte: "+vehiculos[x].getTarifa()+"\tDisponible: "+vehiculos[x].isDisponible());
        }
    }
    
    //Metodo para obtener el cliente
    private Cliente getCliente(String nif) {
        for (int i=0; i<this.getTotalClientes(); i++){
            if (this.clientes[i].getNif().equals(nif)){
                return this.clientes[i];
            }
        }
        return null;
    }
    
    //Metodo para obtener el vehiculo
    private Vehiculo getVehiculo(String matricula) {
        for (int i=0; i<this.getTotalVehiculos(); i++){
            if (this.vehiculos[i].getMatricula().equals(matricula))
                return this.vehiculos[i];
            }
        return null;
    }
    
    //Método para alquilar un vehiculo
    public void alquilarVehiculo(String matricula, String nif, int dias){
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres]=new VehiculoAlquilado(cliente, vehiculo, diaHoy(),
            mesHoy(), anioHoy(), dias);
            this.totalAlquileres++;
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
            this.vehiculos[x]=new Vehiculo();
        }
        this.totalVehiculos=50;
    }
    
    public void generarClientesAlea(){
        for(int x=0;x<50;x++){
            this.clientes[x]=new Cliente();
        }
        this.totalClientes=50;
    }
    
    //Método para ordenar clientes del array por medio de la burbuja
    public void ordenarClientes(){
        for(int x=0;x<this.clientes.length-1;x++){
            for(int y=x+1;y<this.clientes.length;y++){
                if(clientes[x].getNif().compareTo(clientes[y].getNif())>0){
                    Cliente tmp;
                    tmp=clientes[x];
                    clientes[x]=clientes[y];
                    clientes[y]=tmp;
                }
            }
        }
    }
    
    //Método para ordenar vehiculos del array por medio de la burbuja
    public void ordenarVehiculos(){
        for(int x=0;x<this.vehiculos.length-1;x++){
            for(int y=x+1;y<vehiculos.length;y++){
                if(vehiculos[x].getMatricula().compareTo(vehiculos[y].getMatricula())>0){
                    Vehiculo tmp;
                    tmp=vehiculos[x];
                    vehiculos[x]=vehiculos[y];
                    vehiculos[y]=tmp;
                }
            }
        }
    }
    
    //Método para hacer una busqueda binaria en los clientes
    public int busquedaCliente(String nif){
        int mitad;
        int limiteInferior=0;
        int limiteSuperior=this.clientes.length-1;
        boolean encontrado=false;
        while((limiteInferior<=limiteSuperior)&&(!encontrado)){
            mitad=(limiteInferior+limiteSuperior)/2;
            if(this.clientes[mitad].getNif()==nif){
                return mitad; // ¡encontrado!
            }else if(this.clientes[mitad].getNif().compareTo(nif)>0){
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
        int limiteSuperior=this.vehiculos.length-1;
        String busqueda=matricula;
        boolean encontrado=false;
        while((limiteInferior<=limiteSuperior)&&(!encontrado)){
            mitad=(limiteInferior+limiteSuperior)/2;
            if(this.vehiculos[mitad].getMatricula()==busqueda){
                return mitad; // ¡encontrado!
            }else if(this.vehiculos[mitad].getMatricula().compareTo(busqueda)>0){
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

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
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
