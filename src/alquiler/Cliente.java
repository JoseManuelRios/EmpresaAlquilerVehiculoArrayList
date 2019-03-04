/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jriosaguilar
 */
public class Cliente {
    
    //Atributos
    private String nif;
    private String nombre;
    private String apellidos;
    
    //Metodos
    public Cliente(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    //Método para crear un cliente aleatorio. Será un constructor por defecto pero
    //creará un cliente aleatorio
    public Cliente(){
        Random aleatorio=new Random();
        
        ArrayList<Character> nif=new ArrayList<>();
        
        ArrayList<String> nombre=new ArrayList<>();
        nombre.add("Raul");
        nombre.add("Jose");
        nombre.add("Juan");
        nombre.add("Hector");
        nombre.add("Daniel");
        nombre.add("Alejandro");
        nombre.add("Victor");
        nombre.add("Ana");
        nombre.add("María");
        nombre.add("Paula");
        nombre.add("Roberta");
        nombre.add("Lucia");
        nombre.add("Lidia");
        
        ArrayList<String> apellido=new ArrayList<>();
        apellido.add("Ramírez");
        apellido.add("Ríos");
        apellido.add("González");
        apellido.add("Aguilar");
        apellido.add("García");
        apellido.add("Lopez");
        apellido.add("Ruiz");
        apellido.add("Cabas");
        apellido.add("Torres");
        apellido.add("Bernal");
        apellido.add("Sánchez");
        apellido.add("Morales");
        apellido.add("Sierra");
        apellido.add("Perez");
        int numAlea;
        
        //Entramos en un bucle for para seleccionar los numeros del nif. Al salir del bucle 
        //le damos una letra aleatoria
        for(int x=0;x<8;x++){
            numAlea=aleatorio.nextInt(10)+48;
            nif.add((char)numAlea);
        }
        
        //Al ultimo hueco del array nif le asignamos una letra aleatoria
        int letraAlea;
        letraAlea=aleatorio.nextInt(25)+65;
        nif.add((char)letraAlea);
        
        this.nif="";
        for(int x=0;x<nif.size();x++){
            this.nif=this.nif+nif.get(x);
        }
        
        //Elegimos un numero aleatorio para seleccionar el nombre y dos aleatorios para los dos apellidos
        int nom=aleatorio.nextInt(nombre.size()-1);
        int ape1=aleatorio.nextInt(apellido.size()-1);
        int ape2=aleatorio.nextInt(apellido.size()-1);
        
        this.nombre=nombre.get(nom);
        this.apellidos=apellido.get(ape1)+" "+apellido.get(ape2);
        
    }
    
    //Getters y setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
}
