/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class ItensReservaAcervo {

    private int idItem;
    private int idReserva;
    private int tipoOperacao;
    private int idLivro;
    private String tituloLivro;
    private int quantidade;
    private float saldoEstoque;
    private String utilizaReservaAcervo;
    private String usuarioInsert;
    private String UsuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public ItensReservaAcervo(int idItem, int idReserva, int tipoOperacao, int idLivro, String tituloLivro, int quantidade, float saldoEstoque, String utilizaReservaAcervo, String usuarioInsert, String UsuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idReserva = idReserva;
        this.tipoOperacao = tipoOperacao;
        this.idLivro = idLivro;
        this.tituloLivro = tituloLivro;
        this.quantidade = quantidade;
        this.saldoEstoque = saldoEstoque;
        this.utilizaReservaAcervo = utilizaReservaAcervo;
        this.usuarioInsert = usuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensReservaAcervo() {
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
     * @return the idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * @return the tipoOperacao
     */
    public int getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the tituloLivro
     */
    public String getTituloLivro() {
        return tituloLivro;
    }

    /**
     * @param tituloLivro the tituloLivro to set
     */
    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the saldoEstoque
     */
    public float getSaldoEstoque() {
        return saldoEstoque;
    }

    /**
     * @param saldoEstoque the saldoEstoque to set
     */
    public void setSaldoEstoque(float saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    /**
     * @return the utilizaReservaAcervo
     */
    public String getUtilizaReservaAcervo() {
        return utilizaReservaAcervo;
    }

    /**
     * @param utilizaReservaAcervo the utilizaReservaAcervo to set
     */
    public void setUtilizaReservaAcervo(String utilizaReservaAcervo) {
        this.utilizaReservaAcervo = utilizaReservaAcervo;
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
