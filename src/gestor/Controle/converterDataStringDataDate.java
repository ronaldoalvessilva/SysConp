/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

/**
 *
 * @author Socializa TI 02
 */
public class converterDataStringDataDate {

    public static String dataSisConvert = "";

    public String converter(String dataSis) {

        String ano = dataSis.substring(6, 10);
        String mes = dataSis.substring(3, 5);
        String dia = dataSis.substring(0, 2);
        dataSisConvert = ano + "-" + mes + "-" + dia;
        return dataSisConvert;
    }

//    public converterDataStringDataDate() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
