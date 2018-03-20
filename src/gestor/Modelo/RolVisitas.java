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
public class RolVisitas {

    private int idRol;
    private Date dataRol;
    private String statusRol;
    private int idInterno;
    private String nomeInternoCrc;
    private String obsRol;
    private String obsPortaria;     
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private String recebeVisita;
    private int idInstituicao;
    private String nomeInstituicaoRel;
    private int domingo;
    private int segunda;
    private int terca;
    private int quarta;
    private int quinta;
    private int sexta;
    private int sabado;     

    public RolVisitas(int idRol, Date dataRol, String statusRol, int idInterno, String nomeInternoCrc, String obsRol, String obsPortaria, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String recebeVisita, int idInstituicao, String nomeInstituicaoRel, int domingo, int segunda, int terca, int quarta, int quinta, int sexta, int sabado) {
        this.idRol = idRol;
        this.dataRol = dataRol;
        this.statusRol = statusRol;
        this.idInterno = idInterno;
        this.nomeInternoCrc = nomeInternoCrc;
        this.obsRol = obsRol;
        this.obsPortaria = obsPortaria;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.recebeVisita = recebeVisita;
        this.idInstituicao = idInstituicao;
        this.nomeInstituicaoRel = nomeInstituicaoRel;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    public RolVisitas() {
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the dataRol
     */
    public Date getDataRol() {
        return dataRol;
    }

    /**
     * @param dataRol the dataRol to set
     */
    public void setDataRol(Date dataRol) {
        this.dataRol = dataRol;
    }

    /**
     * @return the statusRol
     */
    public String getStatusRol() {
        return statusRol;
    }

    /**
     * @param statusRol the statusRol to set
     */
    public void setStatusRol(String statusRol) {
        this.statusRol = statusRol;
    }

    /**
     * @return the idInterno
     */
    public int getIdInterno() {
        return idInterno;
    }

    /**
     * @param idInterno the idInterno to set
     */
    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
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
     * @return the obsRol
     */
    public String getObsRol() {
        return obsRol;
    }

    /**
     * @param obsRol the obsRol to set
     */
    public void setObsRol(String obsRol) {
        this.obsRol = obsRol;
    }

    /**
     * @return the obsPortaria
     */
    public String getObsPortaria() {
        return obsPortaria;
    }

    /**
     * @param obsPortaria the obsPortaria to set
     */
    public void setObsPortaria(String obsPortaria) {
        this.obsPortaria = obsPortaria;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    /**
     * @return the recebeVisita
     */
    public String getRecebeVisita() {
        return recebeVisita;
    }

    /**
     * @param recebeVisita the recebeVisita to set
     */
    public void setRecebeVisita(String recebeVisita) {
        this.recebeVisita = recebeVisita;
    }

    /**
     * @return the idInstituicao
     */
    public int getIdInstituicao() {
        return idInstituicao;
    }

    /**
     * @param idInstituicao the idInstituicao to set
     */
    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    /**
     * @return the nomeInstituicaoRel
     */
    public String getNomeInstituicaoRel() {
        return nomeInstituicaoRel;
    }

    /**
     * @param nomeInstituicaoRel the nomeInstituicaoRel to set
     */
    public void setNomeInstituicaoRel(String nomeInstituicaoRel) {
        this.nomeInstituicaoRel = nomeInstituicaoRel;
    }

    /**
     * @return the domingo
     */
    public int getDomingo() {
        return domingo;
    }

    /**
     * @param domingo the domingo to set
     */
    public void setDomingo(int domingo) {
        this.domingo = domingo;
    }

    /**
     * @return the segunda
     */
    public int getSegunda() {
        return segunda;
    }

    /**
     * @param segunda the segunda to set
     */
    public void setSegunda(int segunda) {
        this.segunda = segunda;
    }

    /**
     * @return the terca
     */
    public int getTerca() {
        return terca;
    }

    /**
     * @param terca the terca to set
     */
    public void setTerca(int terca) {
        this.terca = terca;
    }

    /**
     * @return the quarta
     */
    public int getQuarta() {
        return quarta;
    }

    /**
     * @param quarta the quarta to set
     */
    public void setQuarta(int quarta) {
        this.quarta = quarta;
    }

    /**
     * @return the quinta
     */
    public int getQuinta() {
        return quinta;
    }

    /**
     * @param quinta the quinta to set
     */
    public void setQuinta(int quinta) {
        this.quinta = quinta;
    }

    /**
     * @return the sexta
     */
    public int getSexta() {
        return sexta;
    }

    /**
     * @param sexta the sexta to set
     */
    public void setSexta(int sexta) {
        this.sexta = sexta;
    }

    /**
     * @return the sabado
     */
    public int getSabado() {
        return sabado;
    }

    /**
     * @param sabado the sabado to set
     */
    public void setSabado(int sabado) {
        this.sabado = sabado;
    }
}
