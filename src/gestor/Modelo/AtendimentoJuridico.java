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
public class AtendimentoJuridico {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private Date dataEnca;
    private String setorEncaminhameto;
    private String tipoAdvogado;
    private String horaEnvio;
    private String resposta;
    private String evolucao;
    private String deptoJuridico;
    private String Observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  

    public AtendimentoJuridico(int idLanc, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, Date dataEnca, String setorEncaminhameto, String tipoAdvogado, String horaEnvio, String resposta, String evolucao, String deptoJuridico, String Observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.dataEnca = dataEnca;
        this.setorEncaminhameto = setorEncaminhameto;
        this.tipoAdvogado = tipoAdvogado;
        this.horaEnvio = horaEnvio;
        this.resposta = resposta;
        this.evolucao = evolucao;
        this.deptoJuridico = deptoJuridico;
        this.Observacao = Observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public AtendimentoJuridico() {
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the dataEnca
     */
    public Date getDataEnca() {
        return dataEnca;
    }

    /**
     * @param dataEnca the dataEnca to set
     */
    public void setDataEnca(Date dataEnca) {
        this.dataEnca = dataEnca;
    }

    /**
     * @return the setorEncaminhameto
     */
    public String getSetorEncaminhameto() {
        return setorEncaminhameto;
    }

    /**
     * @param setorEncaminhameto the setorEncaminhameto to set
     */
    public void setSetorEncaminhameto(String setorEncaminhameto) {
        this.setorEncaminhameto = setorEncaminhameto;
    }

    /**
     * @return the tipoAdvogado
     */
    public String getTipoAdvogado() {
        return tipoAdvogado;
    }

    /**
     * @param tipoAdvogado the tipoAdvogado to set
     */
    public void setTipoAdvogado(String tipoAdvogado) {
        this.tipoAdvogado = tipoAdvogado;
    }

    /**
     * @return the horaEnvio
     */
    public String getHoraEnvio() {
        return horaEnvio;
    }

    /**
     * @param horaEnvio the horaEnvio to set
     */
    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the evolucao
     */
    public String getEvolucao() {
        return evolucao;
    }

    /**
     * @param evolucao the evolucao to set
     */
    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    /**
     * @return the deptoJuridico
     */
    public String getDeptoJuridico() {
        return deptoJuridico;
    }

    /**
     * @param deptoJuridico the deptoJuridico to set
     */
    public void setDeptoJuridico(String deptoJuridico) {
        this.deptoJuridico = deptoJuridico;
    }

    /**
     * @return the Observacao
     */
    public String getObservacao() {
        return Observacao;
    }

    /**
     * @param Observacao the Observacao to set
     */
    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
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
}
