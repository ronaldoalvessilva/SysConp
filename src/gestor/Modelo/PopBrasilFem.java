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
public class PopBrasilFem {
   
private int IdPopBrasm;
private Date DataPop;
private int BrasMulherFec;
private int BrasMulherAbe;
private int BrasMulherSem;
private int BrasMulherPro;
private int TotalGeralFem;

    public PopBrasilFem(int IdPopBrasm, Date DataPop, int BrasMulherFec, int BrasMulherAbe, int BrasMulherSem, int BrasMulherPro, int TotalGeralFem) {
        this.IdPopBrasm = IdPopBrasm;
        this.DataPop = DataPop;
        this.BrasMulherFec = BrasMulherFec;
        this.BrasMulherAbe = BrasMulherAbe;
        this.BrasMulherSem = BrasMulherSem;
        this.BrasMulherPro = BrasMulherPro;
        this.TotalGeralFem = TotalGeralFem;
    }

    public PopBrasilFem() {
    }

    /**
     * @return the IdPopBrasm
     */
    public int getIdPopBrasm() {
        return IdPopBrasm;
    }

    /**
     * @param IdPopBrasm the IdPopBrasm to set
     */
    public void setIdPopBrasm(int IdPopBrasm) {
        this.IdPopBrasm = IdPopBrasm;
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
     * @return the BrasMulherFec
     */
    public int getBrasMulherFec() {
        return BrasMulherFec;
    }

    /**
     * @param BrasMulherFec the BrasMulherFec to set
     */
    public void setBrasMulherFec(int BrasMulherFec) {
        this.BrasMulherFec = BrasMulherFec;
    }

    /**
     * @return the BrasMulherAbe
     */
    public int getBrasMulherAbe() {
        return BrasMulherAbe;
    }

    /**
     * @param BrasMulherAbe the BrasMulherAbe to set
     */
    public void setBrasMulherAbe(int BrasMulherAbe) {
        this.BrasMulherAbe = BrasMulherAbe;
    }

    /**
     * @return the BrasMulherSem
     */
    public int getBrasMulherSem() {
        return BrasMulherSem;
    }

    /**
     * @param BrasMulherSem the BrasMulherSem to set
     */
    public void setBrasMulherSem(int BrasMulherSem) {
        this.BrasMulherSem = BrasMulherSem;
    }

    /**
     * @return the BrasMulherPro
     */
    public int getBrasMulherPro() {
        return BrasMulherPro;
    }

    /**
     * @param BrasMulherPro the BrasMulherPro to set
     */
    public void setBrasMulherPro(int BrasMulherPro) {
        this.BrasMulherPro = BrasMulherPro;
    }

    /**
     * @return the TotalGeralFem
     */
    public int getTotalGeralFem() {
        return TotalGeralFem;
    }

    /**
     * @param TotalGeralFem the TotalGeralFem to set
     */
    public void setTotalGeralFem(int TotalGeralFem) {
        this.TotalGeralFem = TotalGeralFem;
    }
}
