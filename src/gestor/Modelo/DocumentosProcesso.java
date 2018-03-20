/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class DocumentosProcesso {
        private int idDocPro;
	private int idFicha;	
	private int idNatp;
        private String descricaoNatureza;
	private String documento;	
	private String origemDoc;
	private Date dataDoc;
	private String horaDoc;
	private String observacao;
	private String usuarioInsert;
	private String usuarioUp;
	private String dataInsert;
	private String dataUp;
	private String horarioInsert;
	private String horarioUp;

    public DocumentosProcesso(int idDocPro, int idFicha, int idNatp, String descricaoNatureza, String documento, String origemDoc, Date dataDoc, String horaDoc, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDocPro = idDocPro;
        this.idFicha = idFicha;
        this.idNatp = idNatp;
        this.descricaoNatureza = descricaoNatureza;
        this.documento = documento;
        this.origemDoc = origemDoc;
        this.dataDoc = dataDoc;
        this.horaDoc = horaDoc;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public DocumentosProcesso() {
    }

    /**
     * @return the idDocPro
     */
    public int getIdDocPro() {
        return idDocPro;
    }

    /**
     * @param idDocPro the idDocPro to set
     */
    public void setIdDocPro(int idDocPro) {
        this.idDocPro = idDocPro;
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    /**
     * @return the idNatp
     */
    public int getIdNatp() {
        return idNatp;
    }

    /**
     * @param idNatp the idNatp to set
     */
    public void setIdNatp(int idNatp) {
        this.idNatp = idNatp;
    }

    /**
     * @return the descricaoNatureza
     */
    public String getDescricaoNatureza() {
        return descricaoNatureza;
    }

    /**
     * @param descricaoNatureza the descricaoNatureza to set
     */
    public void setDescricaoNatureza(String descricaoNatureza) {
        this.descricaoNatureza = descricaoNatureza;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the origemDoc
     */
    public String getOrigemDoc() {
        return origemDoc;
    }

    /**
     * @param origemDoc the origemDoc to set
     */
    public void setOrigemDoc(String origemDoc) {
        this.origemDoc = origemDoc;
    }

    /**
     * @return the dataDoc
     */
    public Date getDataDoc() {
        return dataDoc;
    }

    /**
     * @param dataDoc the dataDoc to set
     */
    public void setDataDoc(Date dataDoc) {
        this.dataDoc = dataDoc;
    }

    /**
     * @return the horaDoc
     */
    public String getHoraDoc() {
        return horaDoc;
    }

    /**
     * @param horaDoc the horaDoc to set
     */
    public void setHoraDoc(String horaDoc) {
        this.horaDoc = horaDoc;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
