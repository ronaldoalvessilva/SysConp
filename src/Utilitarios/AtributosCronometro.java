/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author Ronaldo
 */
public class AtributosCronometro extends Thread{

    int hora;  
    int minuto;  
    int segundo;  
  
    public void Inicio() {  
        this.hora = 0;  
        this.minuto = 0;  
        this.segundo = 0;  
    }  
  
    public int getHora() {  
        return hora;  
    }  
  
    public void setHora(int hora) {  
        this.hora = hora;  
    }  
  
    public int getMinuto() {  
        return minuto;  
    }  
  
    public void setMinuto(int minuto) {  
        this.minuto = minuto;  
    }  
  
    public int getSegundo() {  
        return segundo;  
    }  
  
    public void setSegundo(int segundo) {  
        this.segundo = segundo;  
    }  
}
