/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronal
 */
public class ItensKitHigiene {

    private int idItem;
    private int idKit;
    private int idProd;
    private String nomeProduto;
    private Float quantItem;
    private int kitInicial;
    private int kitQuinzenal;
    private int kitDecendial;
    private int kitMensal;
    private int kitSemestral;
    private int kitAnual;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public ItensKitHigiene() {
    }

    public ItensKitHigiene(int idItem, int idKit, int idProd, String nomeProduto, Float quantItem, int kitInicial, int kitQuinzenal, int kitDecendial, int kitMensal, int kitSemestral, int kitAnual, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idKit = idKit;
        this.idProd = idProd;
        this.nomeProduto = nomeProduto;
        this.quantItem = quantItem;
        this.kitInicial = kitInicial;
        this.kitQuinzenal = kitQuinzenal;
        this.kitDecendial = kitDecendial;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitAnual = kitAnual;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the quantItem
     */
    public Float getQuantItem() {
        return quantItem;
    }

    /**
     * @param quantItem the quantItem to set
     */
    public void setQuantItem(Float quantItem) {
        this.quantItem = quantItem;
    }

    /**
     * @return the kitInicial
     */
    public int getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(int kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitQuinzenal
     */
    public int getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(int kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the kitDecendial
     */
    public int getKitDecendial() {
        return kitDecendial;
    }

    /**
     * @param kitDecendial the kitDecendial to set
     */
    public void setKitDecendial(int kitDecendial) {
        this.kitDecendial = kitDecendial;
    }

    /**
     * @return the kitMensal
     */
    public int getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(int kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public int getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(int kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitAnual
     */
    public int getKitAnual() {
        return kitAnual;
    }

    /**
     * @param kitAnual the kitAnual to set
     */
    public void setKitAnual(int kitAnual) {
        this.kitAnual = kitAnual;
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
