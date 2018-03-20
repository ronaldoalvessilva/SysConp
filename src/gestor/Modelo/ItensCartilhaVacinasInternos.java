/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class ItensCartilhaVacinasInternos {

    private int idItemCart;
    private int idCart;
    private int idVacina;
    private String descricaoVacina;
    private String statusCart;
    private Date data1Dose;
    private Date data2Dose;
    private Date data3Dose;
    private Date dataReforco;
    private String lote1Dose;
    private String lote2Dose;
    private String lote3Dose;
    private String loteReforco;
    private Date dataValidade1;
    private Date dataValidade2;
    private Date dataValidade3;
    private Date dataValidadeRef;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public ItensCartilhaVacinasInternos(int idItemCart, int idCart, int idVacina, String descricaoVacina, String statusCart, Date data1Dose, Date data2Dose, Date data3Dose, Date dataReforco, String lote1Dose, String lote2Dose, String lote3Dose, String loteReforco, Date dataValidade1, Date dataValidade2, Date dataValidade3, Date dataValidadeRef, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItemCart = idItemCart;
        this.idCart = idCart;
        this.idVacina = idVacina;
        this.descricaoVacina = descricaoVacina;
        this.statusCart = statusCart;
        this.data1Dose = data1Dose;
        this.data2Dose = data2Dose;
        this.data3Dose = data3Dose;
        this.dataReforco = dataReforco;
        this.lote1Dose = lote1Dose;
        this.lote2Dose = lote2Dose;
        this.lote3Dose = lote3Dose;
        this.loteReforco = loteReforco;
        this.dataValidade1 = dataValidade1;
        this.dataValidade2 = dataValidade2;
        this.dataValidade3 = dataValidade3;
        this.dataValidadeRef = dataValidadeRef;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensCartilhaVacinasInternos() {
    }

    /**
     * @return the idItemCart
     */
    public int getIdItemCart() {
        return idItemCart;
    }

    /**
     * @param idItemCart the idItemCart to set
     */
    public void setIdItemCart(int idItemCart) {
        this.idItemCart = idItemCart;
    }

    /**
     * @return the idCart
     */
    public int getIdCart() {
        return idCart;
    }

    /**
     * @param idCart the idCart to set
     */
    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    /**
     * @return the idVacina
     */
    public int getIdVacina() {
        return idVacina;
    }

    /**
     * @param idVacina the idVacina to set
     */
    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    /**
     * @return the descricaoVacina
     */
    public String getDescricaoVacina() {
        return descricaoVacina;
    }

    /**
     * @param descricaoVacina the descricaoVacina to set
     */
    public void setDescricaoVacina(String descricaoVacina) {
        this.descricaoVacina = descricaoVacina;
    }

    /**
     * @return the statusCart
     */
    public String getStatusCart() {
        return statusCart;
    }

    /**
     * @param statusCart the statusCart to set
     */
    public void setStatusCart(String statusCart) {
        this.statusCart = statusCart;
    }

    /**
     * @return the data1Dose
     */
    public Date getData1Dose() {
        return data1Dose;
    }

    /**
     * @param data1Dose the data1Dose to set
     */
    public void setData1Dose(Date data1Dose) {
        this.data1Dose = data1Dose;
    }

    /**
     * @return the data2Dose
     */
    public Date getData2Dose() {
        return data2Dose;
    }

    /**
     * @param data2Dose the data2Dose to set
     */
    public void setData2Dose(Date data2Dose) {
        this.data2Dose = data2Dose;
    }

    /**
     * @return the data3Dose
     */
    public Date getData3Dose() {
        return data3Dose;
    }

    /**
     * @param data3Dose the data3Dose to set
     */
    public void setData3Dose(Date data3Dose) {
        this.data3Dose = data3Dose;
    }

    /**
     * @return the dataReforco
     */
    public Date getDataReforco() {
        return dataReforco;
    }

    /**
     * @param dataReforco the dataReforco to set
     */
    public void setDataReforco(Date dataReforco) {
        this.dataReforco = dataReforco;
    }

    /**
     * @return the lote1Dose
     */
    public String getLote1Dose() {
        return lote1Dose;
    }

    /**
     * @param lote1Dose the lote1Dose to set
     */
    public void setLote1Dose(String lote1Dose) {
        this.lote1Dose = lote1Dose;
    }

    /**
     * @return the lote2Dose
     */
    public String getLote2Dose() {
        return lote2Dose;
    }

    /**
     * @param lote2Dose the lote2Dose to set
     */
    public void setLote2Dose(String lote2Dose) {
        this.lote2Dose = lote2Dose;
    }

    /**
     * @return the lote3Dose
     */
    public String getLote3Dose() {
        return lote3Dose;
    }

    /**
     * @param lote3Dose the lote3Dose to set
     */
    public void setLote3Dose(String lote3Dose) {
        this.lote3Dose = lote3Dose;
    }

    /**
     * @return the loteReforco
     */
    public String getLoteReforco() {
        return loteReforco;
    }

    /**
     * @param loteReforco the loteReforco to set
     */
    public void setLoteReforco(String loteReforco) {
        this.loteReforco = loteReforco;
    }

    /**
     * @return the dataValidade1
     */
    public Date getDataValidade1() {
        return dataValidade1;
    }

    /**
     * @param dataValidade1 the dataValidade1 to set
     */
    public void setDataValidade1(Date dataValidade1) {
        this.dataValidade1 = dataValidade1;
    }

    /**
     * @return the dataValidade2
     */
    public Date getDataValidade2() {
        return dataValidade2;
    }

    /**
     * @param dataValidade2 the dataValidade2 to set
     */
    public void setDataValidade2(Date dataValidade2) {
        this.dataValidade2 = dataValidade2;
    }

    /**
     * @return the dataValidade3
     */
    public Date getDataValidade3() {
        return dataValidade3;
    }

    /**
     * @param dataValidade3 the dataValidade3 to set
     */
    public void setDataValidade3(Date dataValidade3) {
        this.dataValidade3 = dataValidade3;
    }

    /**
     * @return the dataValidadeRef
     */
    public Date getDataValidadeRef() {
        return dataValidadeRef;
    }

    /**
     * @param dataValidadeRef the dataValidadeRef to set
     */
    public void setDataValidadeRef(Date dataValidadeRef) {
        this.dataValidadeRef = dataValidadeRef;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }
}
