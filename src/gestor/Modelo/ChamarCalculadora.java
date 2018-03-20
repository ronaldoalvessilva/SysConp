/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

import java.io.IOException;

/**
 *
 * @author Ronaldo
 */
public class ChamarCalculadora {
   // Essa classe está para teste. O aplicativo a ser chamado tem que está no PATH do windows
    public static void main(String[] args)  
   {  
      try  
      {  
         Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");  
      }  
      catch(IOException iOException)  
      {  
         iOException.printStackTrace();  
      }  
   }  
}
