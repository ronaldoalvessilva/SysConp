/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class PopEstrangeiraMasc {
    private int IdPopEsth;
private Date DataPop;
private int EstraHomenFec;
private int EstraHomenAbe;
private int EstraHomenSem;
private int EstraHomenPro;
private int TotalGeralMasc;

    public PopEstrangeiraMasc(int IdPopEsth, Date DataPop, int EstraHomenFec, int EstraHomenAbe, int EstraHomenSem, int EstraHomenPro, int TotalGeralMasc) {
        this.IdPopEsth = IdPopEsth;
        this.DataPop = DataPop;
        this.EstraHomenFec = EstraHomenFec;
        this.EstraHomenAbe = EstraHomenAbe;
        this.EstraHomenSem = EstraHomenSem;
        this.EstraHomenPro = EstraHomenPro;
        this.TotalGeralMasc = TotalGeralMasc;
    }

    public PopEstrangeiraMasc() {
    }

    /**
     * @return the IdPopEsth
     */
    public int getIdPopEsth() {
        return IdPopEsth;
    }

    /**
     * @param IdPopEsth the IdPopEsth to set
     */
    public void setIdPopEsth(int IdPopEsth) {
        this.IdPopEsth = IdPopEsth;
    }

    /**
     * @return the DataPop
     */
    public Date getDataPop() {
        return DataPop;
    }

    /**
     * @param DataPop the DataPop to set
     */
    public void setDataPop(Date DataPop) {
        this.DataPop = DataPop;
    }

    /**
     * @return the EstraHomenFec
     */
    public int getEstraHomenFec() {
        return EstraHomenFec;
    }

    /**
     * @param EstraHomenFec the EstraHomenFec to set
     */
    public void setEstraHomenFec(int EstraHomenFec) {
        this.EstraHomenFec = EstraHomenFec;
    }

    /**
     * @return the EstraHomenAbe
     */
    public int getEstraHomenAbe() {
        return EstraHomenAbe;
    }

    /**
     * @param EstraHomenAbe the EstraHomenAbe to set
     */
    public void setEstraHomenAbe(int EstraHomenAbe) {
        this.EstraHomenAbe = EstraHomenAbe;
    }

    /**
     * @return the EstraHomenSem
     */
    public int getEstraHomenSem() {
        return EstraHomenSem;
    }

    /**
     * @param EstraHomenSem the EstraHomenSem to set
     */
    public void setEstraHomenSem(int EstraHomenSem) {
        this.EstraHomenSem = EstraHomenSem;
    }

    /**
     * @return the EstraHomenPro
     */
    public int getEstraHomenPro() {
        return EstraHomenPro;
    }

    /**
     * @param EstraHomenPro the EstraHomenPro to set
     */
    public void setEstraHomenPro(int EstraHomenPro) {
        this.EstraHomenPro = EstraHomenPro;
    }

    /**
     * @return the TotalGeralMasc
     */
    public int getTotalGeralMasc() {
        return TotalGeralMasc;
    }

    /**
     * @param TotalGeralMasc the TotalGeralMasc to set
     */
    public void setTotalGeralMasc(int TotalGeralMasc) {
        this.TotalGeralMasc = TotalGeralMasc;
    }
}
