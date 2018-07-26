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
public class PavilhaoInternosMontagemKit {

    private int IdRegPavInt;
    private int IdRegistroComp;
    private int IdInternoCrc;
    private String nomeInternoCrc;
    private int IdPav;
    private String descricaoPavilhao;
    private int IdRegIntSel;
    private String UsuarioInsert;
    private String UsuarioUp;
    private String DataInsert;
    private String DataUp;
    private String HorarioInsert;
    private String HorarioUp;

    public PavilhaoInternosMontagemKit() {
    }

    public PavilhaoInternosMontagemKit(int IdRegPavInt, int IdRegistroComp, int IdInternoCrc, String nomeInternoCrc, int IdPav, String descricaoPavilhao, int IdRegIntSel, String UsuarioInsert, String UsuarioUp, String DataInsert, String DataUp, String HorarioInsert, String HorarioUp) {
        this.IdRegPavInt = IdRegPavInt;
        this.IdRegistroComp = IdRegistroComp;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.IdPav = IdPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.IdRegIntSel = IdRegIntSel;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataInsert = DataInsert;
        this.DataUp = DataUp;
        this.HorarioInsert = HorarioInsert;
        this.HorarioUp = HorarioUp;
    }

    /**
     * @return the IdRegPavInt
     */
    public int getIdRegPavInt() {
        return IdRegPavInt;
    }

    /**
     * @param IdRegPavInt the IdRegPavInt to set
     */
    public void setIdRegPavInt(int IdRegPavInt) {
        this.IdRegPavInt = IdRegPavInt;
    }

    /**
     * @return the IdRegistroComp
     */
    public int getIdRegistroComp() {
        return IdRegistroComp;
    }

    /**
     * @param IdRegistroComp the IdRegistroComp to set
     */
    public void setIdRegistroComp(int IdRegistroComp) {
        this.IdRegistroComp = IdRegistroComp;
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
     * @return the IdRegIntSel
     */
    public int getIdRegIntSel() {
        return IdRegIntSel;
    }

    /**
     * @param IdRegIntSel the IdRegIntSel to set
     */
    public void setIdRegIntSel(int IdRegIntSel) {
        this.IdRegIntSel = IdRegIntSel;
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
