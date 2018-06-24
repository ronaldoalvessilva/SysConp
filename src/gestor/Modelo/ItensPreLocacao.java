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
public class ItensPreLocacao {

    private int IdItem;
    private int CodigoReg;
    private int IdPav;
    private String descricaoPavilhao;
    private int IdInternoCrc;
    private String nomeInternoCrc;
    private int idEntrada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private int tipoPesquisa;

    public ItensPreLocacao() {
    }

    public ItensPreLocacao(int IdItem, int CodigoReg, int IdPav, String descricaoPavilhao, int IdInternoCrc, String nomeInternoCrc, int idEntrada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, int tipoPesquisa) {
        this.IdItem = IdItem;
        this.CodigoReg = CodigoReg;
        this.IdPav = IdPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idEntrada = idEntrada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.tipoPesquisa = tipoPesquisa;
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
     * @return the CodigoReg
     */
    public int getCodigoReg() {
        return CodigoReg;
    }

    /**
     * @param CodigoReg the CodigoReg to set
     */
    public void setCodigoReg(int CodigoReg) {
        this.CodigoReg = CodigoReg;
    }

    /**
     * @return the IdPav
     */
    public int getIdPav() {
        return IdPav;
    }

    /**
     * @param IdPav the IdPav to set
     */
    public void setIdPav(int IdPav) {
        this.IdPav = IdPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the idEntrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * @param idEntrada the idEntrada to set
     */
    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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

    /**
     * @return the tipoPesquisa
     */
    public int getTipoPesquisa() {
        return tipoPesquisa;
    }

    /**
     * @param tipoPesquisa the tipoPesquisa to set
     */
    public void setTipoPesquisa(int tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }

}
