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
public class PopEstrangeiraFem {

    private int IdPopEstFem;
    private Date DataPop;
    private int EstraMulherFec;
    private int EstraMulherAbe;
    private int EstraMulherSem;
    private int EstraMulherPro;
    private int TotalGeralFem;   

    public PopEstrangeiraFem(int IdPopEstFem, Date DataPop, int EstraMulherFec, int EstraMulherAbe, int EstraMulherSem, int EstraMulherPro, int TotalGeralFem) {
        this.IdPopEstFem = IdPopEstFem;
        this.DataPop = DataPop;
        this.EstraMulherFec = EstraMulherFec;
        this.EstraMulherAbe = EstraMulherAbe;
        this.EstraMulherSem = EstraMulherSem;
        this.EstraMulherPro = EstraMulherPro;
        this.TotalGeralFem = TotalGeralFem;
    }

    public PopEstrangeiraFem() {
    }

    /**
     * @return the IdPopEstFem
     */
    public int getIdPopEstFem() {
        return IdPopEstFem;
    }

    /**
     * @param IdPopEstFem the IdPopEstFem to set
     */
    public void setIdPopEstFem(int IdPopEstFem) {
        this.IdPopEstFem = IdPopEstFem;
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
     * @return the EstraMulherFec
     */
    public int getEstraMulherFec() {
        return EstraMulherFec;
    }

    /**
     * @param EstraMulherFec the EstraMulherFec to set
     */
    public void setEstraMulherFec(int EstraMulherFec) {
        this.EstraMulherFec = EstraMulherFec;
    }

    /**
     * @return the EstraMulherAbe
     */
    public int getEstraMulherAbe() {
        return EstraMulherAbe;
    }

    /**
     * @param EstraMulherAbe the EstraMulherAbe to set
     */
    public void setEstraMulherAbe(int EstraMulherAbe) {
        this.EstraMulherAbe = EstraMulherAbe;
    }

    /**
     * @return the EstraMulherSem
     */
    public int getEstraMulherSem() {
        return EstraMulherSem;
    }

    /**
     * @param EstraMulherSem the EstraMulherSem to set
     */
    public void setEstraMulherSem(int EstraMulherSem) {
        this.EstraMulherSem = EstraMulherSem;
    }

    /**
     * @return the EstraMulherPro
     */
    public int getEstraMulherPro() {
        return EstraMulherPro;
    }

    /**
     * @param EstraMulherPro the EstraMulherPro to set
     */
    public void setEstraMulherPro(int EstraMulherPro) {
        this.EstraMulherPro = EstraMulherPro;
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
