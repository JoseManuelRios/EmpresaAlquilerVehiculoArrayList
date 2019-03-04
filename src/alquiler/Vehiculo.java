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
public class Vehiculo {
    
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;
    
    //Métodos
    //Constructor parametrizado
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    public Vehiculo(){
        Random aleatorio=new Random();
        
        ArrayList<Character> matricula=new ArrayList();
        ArrayList<String> marca=new ArrayList();
        marca.add("Subaru");
        marca.add("Audi");
        marca.add("Chevrolet");
        marca.add("Peugeot");
        marca.add("Mitsubishi");
        marca.add("Seat");
        marca.add("Opel");
        marca.add("Nissan");
        marca.add("Lexus");
        marca.add("Citroen");
        marca.add("Ferrari");
        marca.add("Porsche");
        marca.add("BMW");
        marca.add("Volkswagen");
        
        ArrayList<String> modelo=new ArrayList();
        modelo.add("1500");
        modelo.add("Piara");
        modelo.add("Palmera");
        modelo.add("350c");
        modelo.add("G7");
        modelo.add("Estepona");
        modelo.add("Mar azul");
        modelo.add("307");
        modelo.add("Borrasca");
        modelo.add("Canon");
        modelo.add("Horse");
        modelo.add("AMG");
        modelo.add("Enzo");
        modelo.add("Veneno");
        modelo.add("Forest");
        
        ArrayList<String> color=new ArrayList();
        color.add("Azul");
        color.add("Verde");
        color.add("Rojo");
        color.add("Amarillo");
        color.add("Blanco");
        color.add("Negro");
        color.add("Plateado");
        color.add("Rosa");
        color.add("Marrón");
        color.add("Violeta");
        color.add("Naranja");
        color.add("Cian");
        color.add("Gris");
        
        int tarifa;
        boolean disponible;
        int numAlea;
        int letraAlea;
        
        //Bucle para ponerle los numeros a la matricula
        for(int x=0;x<4;x++){
            numAlea=aleatorio.nextInt(10)+48;
            matricula.add((char)numAlea);
        }
        
        //Bucle para ponerla las letras a la matricula
        for(int x=4;x<7;x++){
            letraAlea=aleatorio.nextInt(25)+65;
            matricula.add((char)letraAlea);
        }
        
        this.matricula="";
        for(int x=0;x<matricula.size();x++){
            this.matricula=this.matricula+matricula.get(x);
        }
        
        int marcaAlea=aleatorio.nextInt(marca.size()-1);
        int modeloAlea=aleatorio.nextInt(modelo.size()-1);
        int colorAlea=aleatorio.nextInt(color.size()-1);
        tarifa=aleatorio.nextInt(250)+50;
        disponible=aleatorio.nextBoolean();
        
        this.marca=marca.get(marcaAlea);
        this.modelo=modelo.get(modeloAlea);
        this.color=color.get(colorAlea);
        this.tarifa=tarifa;
        this.disponible=disponible;
    }
    
    //Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tarifa=" + tarifa + ", disponible=" + disponible + '}';
    }
    
}
