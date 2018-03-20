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
public class PopBrasilMasc {
private int IdPopBrash;
private Date DataPop;
private int BrasHomemFec;
private int BrasHomemAbe;
private int BrasHomemSem;
private int BrasHomemPro;
private int TotalGeralMas;

    public PopBrasilMasc(int IdPopBrash, Date DataPop, int BrasHomemFec, int BrasHomemAbe, int BrasHomemSem, int BrasHomemPro, int TotalGeralMas) {
        this.IdPopBrash = IdPopBrash;
        this.DataPop = DataPop;
        this.BrasHomemFec = BrasHomemFec;
        this.BrasHomemAbe = BrasHomemAbe;
        this.BrasHomemSem = BrasHomemSem;
        this.BrasHomemPro = BrasHomemPro;
        this.TotalGeralMas = TotalGeralMas;
    }

    public PopBrasilMasc() {
    }

    /**
     * @return the IdPopBrash
     */
    public int getIdPopBrash() {
        return IdPopBrash;
    }

    /**
     * @param IdPopBrash the IdPopBrash to set
     */
    public void setIdPopBrash(int IdPopBrash) {
        this.IdPopBrash = IdPopBrash;
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
     * @return the BrasHomemFec
     */
    public int getBrasHomemFec() {
        return BrasHomemFec;
    }

    /**
     * @param BrasHomemFec the BrasHomemFec to set
     */
    public void setBrasHomemFec(int BrasHomemFec) {
        this.BrasHomemFec = BrasHomemFec;
    }

    /**
     * @return the BrasHomemAbe
     */
    public int getBrasHomemAbe() {
        return BrasHomemAbe;
    }

    /**
     * @param BrasHomemAbe the BrasHomemAbe to set
     */
    public void setBrasHomemAbe(int BrasHomemAbe) {
        this.BrasHomemAbe = BrasHomemAbe;
    }

    /**
     * @return the BrasHomemSem
     */
    public int getBrasHomemSem() {
        return BrasHomemSem;
    }

    /**
     * @param BrasHomemSem the BrasHomemSem to set
     */
    public void setBrasHomemSem(int BrasHomemSem) {
        this.BrasHomemSem = BrasHomemSem;
    }

    /**
     * @return the BrasHomemPro
     */
    public int getBrasHomemPro() {
        return BrasHomemPro;
    }

    /**
     * @param BrasHomemPro the BrasHomemPro to set
     */
    public void setBrasHomemPro(int BrasHomemPro) {
        this.BrasHomemPro = BrasHomemPro;
    }

    /**
     * @return the TotalGeralMas
     */
    public int getTotalGeralMas() {
        return TotalGeralMas;
    }

    /**
     * @param TotalGeralMas the TotalGeralMas to set
     */
    public void setTotalGeralMas(int TotalGeralMas) {
        this.TotalGeralMas = TotalGeralMas;
    }
    
}
