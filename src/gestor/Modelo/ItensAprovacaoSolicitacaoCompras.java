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
public class ItensAprovacaoSolicitacaoCompras {

    private int IdItem;
    private Date DataAprova;
    private int IdAprova;
    private int IdProd;
    private float QtdAprova;
    private float ValorUnitario;
    private float ValorTotal;
    private String UsuarioInsert;
    private String UsuarioUp;
    private String DataInsert;
    private String DataUp;
    private String HorarioInsert;
    private String HorarioUp;

    public ItensAprovacaoSolicitacaoCompras(int IdItem, Date DataAprova, int IdAprova, int IdProd, float QtdAprova, float ValorUnitario, float ValorTotal, String UsuarioInsert, String UsuarioUp, String DataInsert, String DataUp, String HorarioInsert, String HorarioUp) {
        this.IdItem = IdItem;
        this.DataAprova = DataAprova;
        this.IdAprova = IdAprova;
        this.IdProd = IdProd;
        this.QtdAprova = QtdAprova;
        this.ValorUnitario = ValorUnitario;
        this.ValorTotal = ValorTotal;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataInsert = DataInsert;
        this.DataUp = DataUp;
        this.HorarioInsert = HorarioInsert;
        this.HorarioUp = HorarioUp;
    }

    public ItensAprovacaoSolicitacaoCompras() {
    }

    /**
     * @return the IdItem
     */
    public int getIdItem() {
        return IdItem;
    }

    /**
     * @param IdItem the IdItem to set
     */
    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    /**
     * @return the DataAprova
     */
    public Date getDataAprova() {
        return DataAprova;
    }

    /**
     * @param DataAprova the DataAprova to set
     */
    public void setDataAprova(Date DataAprova) {
        this.DataAprova = DataAprova;
    }

    /**
     * @return the IdAprova
     */
    public int getIdAprova() {
        return IdAprova;
    }

    /**
     * @param IdAprova the IdAprova to set
     */
    public void setIdAprova(int IdAprova) {
        this.IdAprova = IdAprova;
    }

    /**
     * @return the IdProd
     */
    public int getIdProd() {
        return IdProd;
    }

    /**
     * @param IdProd the IdProd to set
     */
    public void setIdProd(int IdProd) {
        this.IdProd = IdProd;
    }

    /**
     * @return the QtdAprova
     */
    public float getQtdAprova() {
        return QtdAprova;
    }

    /**
     * @param QtdAprova the QtdAprova to set
     */
    public void setQtdAprova(float QtdAprova) {
        this.QtdAprova = QtdAprova;
    }

    /**
     * @return the ValorUnitario
     */
    public float getValorUnitario() {
        return ValorUnitario;
    }

    /**
     * @param ValorUnitario the ValorUnitario to set
     */
    public void setValorUnitario(float ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    /**
     * @return the ValorTotal
     */
    public float getValorTotal() {
        return ValorTotal;
    }

    /**
     * @param ValorTotal the ValorTotal to set
     */
    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    /**
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the DataUp
     */
    public String getDataUp() {
        return DataUp;
    }

    /**
     * @param DataUp the DataUp to set
     */
    public void setDataUp(String DataUp) {
        this.DataUp = DataUp;
    }

    /**
     * @return the HorarioInsert
     */
    public String getHorarioInsert() {
        return HorarioInsert;
    }

    /**
     * @param HorarioInsert the HorarioInsert to set
     */
    public void setHorarioInsert(String HorarioInsert) {
        this.HorarioInsert = HorarioInsert;
    }

    /**
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }
}
