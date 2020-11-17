/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import gestor.teste.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ronal
 */
public class DateUtils {

    public Date addDate(int field, int amount, Date origDate) {
        GregorianCalendar gcal = new GregorianCalendar();

        try {
            gcal.setTime(origDate);
            gcal.add(field, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (new Date(gcal.getTime().getTime()));
    }
}
