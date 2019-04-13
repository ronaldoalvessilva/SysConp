/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class ProgramacaoKit {

    private int idPROG;
    private Date dataPROG;
    private Date dataUltimoPagto;
    private Date dataPrevisao;
    private int tipoKit;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private int idPav;
    private String descricaoPav;

    public ProgramacaoKit() {
    }

    public ProgramacaoKit(int idPROG, Date dataPROG, Date dataUltimoPagto, Date dataPrevisao, int tipoKit, String usuarioInsert, String dataInsert, String horarioInsert, int idPav, String descricaoPav) {
        this.idPROG = idPROG;
        this.dataPROG = dataPROG;
        this.dataUltimoPagto = dataUltimoPagto;
        this.dataPrevisao = dataPrevisao;
        this.tipoKit = tipoKit;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idPROG
     */
    public int getIdPROG() {
        return idPROG;
    }

    /**
     * @param idPROG the idPROG to set
     */
    public void setIdPROG(int idPROG) {
        this.idPROG = idPROG;
    }

    /**
     * @return the dataPROG
     */
    public Date getDataPROG() {
        return dataPROG;
    }

    /**
     * @param dataPROG the dataPROG to set
     */
    public void setDataPROG(Date dataPROG) {
        this.dataPROG = dataPROG;
    }

    /**
     * @return the dataUltimoPagto
     */
    public Date getDataUltimoPagto() {
        return dataUltimoPagto;
    }

    /**
     * @param dataUltimoPagto the dataUltimoPagto to set
     */
    public void setDataUltimoPagto(Date dataUltimoPagto) {
        this.dataUltimoPagto = dataUltimoPagto;
    }

    /**
     * @return the dataPrevisao
     */
    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    /**
     * @param dataPrevisao the dataPrevisao to set
     */
    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    /**
     * @return the tipoKit
     */
    public int getTipoKit() {
        return tipoKit;
    }

    /**
     * @param tipoKit the tipoKit to set
     */
    public void setTipoKit(int tipoKit) {
        this.tipoKit = tipoKit;
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
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }
}
