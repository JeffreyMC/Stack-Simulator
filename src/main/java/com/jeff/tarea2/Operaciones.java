/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.tarea2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Operaciones {

    
    private Persona [] p = new Persona[50];
    
    private String[] menor;
    
    private String[] mayor;
    
    private String[] anciano;
    
       /**
     * @return the menor
     */
    public String[] getMenor() {
        return menor;
    }

    /**
     * @return the mayor
     */
    public String[] getMayor() {
        return mayor;
    }

    /**
     * @return the anciano
     */
    public String[] getAnciano() {
        return anciano;
    }
    
    public Persona [] generar(){
        
        Random rnd = new Random();
        boolean seguir = true;
        
        for(int i = 0; i< p.length; i++){
            
            do{
                int id = 100000000 + rnd.nextInt(900000000);

                if(!duplicado(id, i)){
                    int edad = 1 + rnd.nextInt(101);
                    
                    Persona person = new Persona();
                    person.setId(id);
                    person.setEdad(edad);
                    
                    p[i] = person;

                    seguir = false;
                }
            }while(seguir);  
        }
        
        return p;
    }
    
    public boolean duplicado(int id, int cont){
        
        for(int i =0; i < cont; i++){
            if(p[i].getId() == id)
                return true;                
        }

        return false;
    }
    
    public String[] menores(){
        menor = new String[findMenores()];
        
        int cont = cuentaMenores()-1;
        if(cont < 0)
            cont = 0;
        
        for(int i=0; i<p.length; i++){
            if(p[i].getEdad() <18){
                menor[cont] = "ID: " + p[i].getId() + " | Edad: " + p[i].getEdad();
                cont--;
            }          
        }
        
        return getMenor();
    }
    
    public String[] mayores(){
        mayor = new String[findMayores()];

        int cont = cuentaMayores()-1;
        if(cont < 0)
            cont = 0;
        
        for(int i=0; i<p.length; i++){
            if(p[i].getEdad() >=18 && p[i].getEdad() < 65){
                mayor[cont] = "ID: " + p[i].getId() + " | Edad: " + p[i].getEdad();
                cont--;
            }          
        }

        return getMayor();
    }
    
    public String[] ancianos(){
        anciano = new String[findAncianos()];

        int cont = cuentaAncianos()-1;
        if(cont < 0)
            cont = 0;
        
        for(int i=0; i<p.length; i++){
            if(p[i].getEdad() >= 65){
                anciano[cont] = "ID: " + p[i].getId() + " | Edad: " + p[i].getEdad();
                cont--;
            }          
        }

        return getAnciano();
    }
    
    public int cuentaMenores(){
        return getMenor().length;
    }
    
    public int cuentaMayores(){
        return getMayor().length;
    }
    
    public int cuentaAncianos(){
        return getAnciano().length;
    }
    
        public int findMenores(){
        int cont = 0;
        
        for(Persona per:p){
            if(per.getEdad() < 18)
                cont++;
        }
        return cont;
    }
    
    public int findMayores(){
        int cont = 0;
        
        for(Persona per:p){
            if(per.getEdad() >= 18 && per.getEdad() < 65)
                cont++;
        }
        return cont;
    }
    
    public int findAncianos(){
        int cont = 0;
        
        for(Persona per:p){
            if(per.getEdad() >= 65)
                cont++;
        }
        return cont;
    }
    
    //EXTRAER
    public String[] popMenores(){
        
        String[] nuevo;
        
        try{  
             nuevo = new String[getMenor().length-1];
             
            String personaEliminada = getMenor()[0];
        
            JOptionPane.showMessageDialog(null, String.format("Persona eliminada: %s",
                    personaEliminada),"Remover persona", JOptionPane.INFORMATION_MESSAGE);
        
            for(int i = 0; i < getMenor().length-1; i++)
                nuevo[i] = getMenor()[i+1];
        
            menor = nuevo;
            
            return nuevo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No quedan más elementos en la pila","ERROR", JOptionPane.WARNING_MESSAGE);
        }         
        
        return nuevo = new String[]{""};
    }
    
    public String[] popMayores(){
        
        String[] nuevo;
        
        try{  
             nuevo = new String[getMayor().length-1];
             
            String personaEliminada = getMayor()[0];
        
            JOptionPane.showMessageDialog(null, String.format("Persona eliminada: %s",
                    personaEliminada),"Remover persona", JOptionPane.INFORMATION_MESSAGE);
        
            for(int i = 0; i < getMayor().length-1; i++)
                nuevo[i] = getMayor()[i+1];
        
            mayor = nuevo;
            
            return nuevo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No quedan más elementos en la pila","ERROR", JOptionPane.WARNING_MESSAGE);
        }         
        
        return nuevo = new String[]{""};
    }
    
    public String[] popAncianos(){
        
        String[] nuevo;
        
        try{  
             nuevo = new String[getAnciano().length-1];
             
            String personaEliminada = getAnciano()[0];
        
            JOptionPane.showMessageDialog(null, String.format("Persona eliminada: %s",
                    personaEliminada),"Remover persona", JOptionPane.INFORMATION_MESSAGE);
        
            for(int i = 0; i < getAnciano().length-1; i++)
                nuevo[i] = getAnciano()[i+1];
        
            anciano = nuevo;
            
            return nuevo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No quedan más elementos en la pila","ERROR", JOptionPane.WARNING_MESSAGE);
        }         
        
        return nuevo = new String[]{""};
    }
    
    public void vaciarMenores(){
        menor = new String[0];
    }
    
    public void vaciarMayores(){
        mayor = new String[0];
    }
    
    public void vaciarAncianos(){
        anciano = new String[0];
    }
}
