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
public class AtendimentoFemininoP2 {

    private int idAfp2;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int numeroGestacoes;
    private int numeroPartos;
    private int numeroAbortos;
    private int numeroFilhosVivos;
    private int idadePrimeiraGestacao;
    private int intervaloGestacoes;
    private int pretermo;
    private int postermo;
    private int baixoPeso;
    private int mortesNeonataisPrecoce;
    private String motivoMorteNeonataisPrecoce;
    private int mortesNeonataisTardias;
    private String motivoMortesNeonataisTardias;
    private int natimortos;
    private int ictericia;
    private int transfusao;
    private int hipoglicemia;
    private String isoimunizacaoRH;
    private String intercorrenciaComplicacoesGestoes;
    private String historiaAleitamentosAnteriores;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AtendimentoFemininoP2(int idAfp2, int idLanc, int idInternoCrc, String nomeInternoCrc, int numeroGestacoes, int numeroPartos, int numeroAbortos, int numeroFilhosVivos, int idadePrimeiraGestacao, int intervaloGestacoes, int pretermo, int postermo, int baixoPeso, int mortesNeonataisPrecoce, String motivoMorteNeonataisPrecoce, int mortesNeonataisTardias, String motivoMortesNeonataisTardias, int natimortos, int ictericia, int transfusao, int hipoglicemia, String isoimunizacaoRH, String intercorrenciaComplicacoesGestoes, String historiaAleitamentosAnteriores, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAfp2 = idAfp2;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.numeroGestacoes = numeroGestacoes;
        this.numeroPartos = numeroPartos;
        this.numeroAbortos = numeroAbortos;
        this.numeroFilhosVivos = numeroFilhosVivos;
        this.idadePrimeiraGestacao = idadePrimeiraGestacao;
        this.intervaloGestacoes = intervaloGestacoes;
        this.pretermo = pretermo;
        this.postermo = postermo;
        this.baixoPeso = baixoPeso;
        this.mortesNeonataisPrecoce = mortesNeonataisPrecoce;
        this.motivoMorteNeonataisPrecoce = motivoMorteNeonataisPrecoce;
        this.mortesNeonataisTardias = mortesNeonataisTardias;
        this.motivoMortesNeonataisTardias = motivoMortesNeonataisTardias;
        this.natimortos = natimortos;
        this.ictericia = ictericia;
        this.transfusao = transfusao;
        this.hipoglicemia = hipoglicemia;
        this.isoimunizacaoRH = isoimunizacaoRH;
        this.intercorrenciaComplicacoesGestoes = intercorrenciaComplicacoesGestoes;
        this.historiaAleitamentosAnteriores = historiaAleitamentosAnteriores;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtendimentoFemininoP2() {
    }

    /**
     * @return the idAfp2
     */
    public int getIdAfp2() {
        return idAfp2;
    }

    /**
     * @param idAfp2 the idAfp2 to set
     */
    public void setIdAfp2(int idAfp2) {
        this.idAfp2 = idAfp2;
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
     * @return the numeroGestacoes
     */
    public int getNumeroGestacoes() {
        return numeroGestacoes;
    }

    /**
     * @param numeroGestacoes the numeroGestacoes to set
     */
    public void setNumeroGestacoes(int numeroGestacoes) {
        this.numeroGestacoes = numeroGestacoes;
    }

    /**
     * @return the numeroPartos
     */
    public int getNumeroPartos() {
        return numeroPartos;
    }

    /**
     * @param numeroPartos the numeroPartos to set
     */
    public void setNumeroPartos(int numeroPartos) {
        this.numeroPartos = numeroPartos;
    }

    /**
     * @return the numeroAbortos
     */
    public int getNumeroAbortos() {
        return numeroAbortos;
    }

    /**
     * @param numeroAbortos the numeroAbortos to set
     */
    public void setNumeroAbortos(int numeroAbortos) {
        this.numeroAbortos = numeroAbortos;
    }

    /**
     * @return the numeroFilhosVivos
     */
    public int getNumeroFilhosVivos() {
        return numeroFilhosVivos;
    }

    /**
     * @param numeroFilhosVivos the numeroFilhosVivos to set
     */
    public void setNumeroFilhosVivos(int numeroFilhosVivos) {
        this.numeroFilhosVivos = numeroFilhosVivos;
    }

    /**
     * @return the idadePrimeiraGestacao
     */
    public int getIdadePrimeiraGestacao() {
        return idadePrimeiraGestacao;
    }

    /**
     * @param idadePrimeiraGestacao the idadePrimeiraGestacao to set
     */
    public void setIdadePrimeiraGestacao(int idadePrimeiraGestacao) {
        this.idadePrimeiraGestacao = idadePrimeiraGestacao;
    }

    /**
     * @return the intervaloGestacoes
     */
    public int getIntervaloGestacoes() {
        return intervaloGestacoes;
    }

    /**
     * @param intervaloGestacoes the intervaloGestacoes to set
     */
    public void setIntervaloGestacoes(int intervaloGestacoes) {
        this.intervaloGestacoes = intervaloGestacoes;
    }

    /**
     * @return the pretermo
     */
    public int getPretermo() {
        return pretermo;
    }

    /**
     * @param pretermo the pretermo to set
     */
    public void setPretermo(int pretermo) {
        this.pretermo = pretermo;
    }

    /**
     * @return the postermo
     */
    public int getPostermo() {
        return postermo;
    }

    /**
     * @param postermo the postermo to set
     */
    public void setPostermo(int postermo) {
        this.postermo = postermo;
    }

    /**
     * @return the baixoPeso
     */
    public int getBaixoPeso() {
        return baixoPeso;
    }

    /**
     * @param baixoPeso the baixoPeso to set
     */
    public void setBaixoPeso(int baixoPeso) {
        this.baixoPeso = baixoPeso;
    }

    /**
     * @return the mortesNeonataisPrecoce
     */
    public int getMortesNeonataisPrecoce() {
        return mortesNeonataisPrecoce;
    }

    /**
     * @param mortesNeonataisPrecoce the mortesNeonataisPrecoce to set
     */
    public void setMortesNeonataisPrecoce(int mortesNeonataisPrecoce) {
        this.mortesNeonataisPrecoce = mortesNeonataisPrecoce;
    }

    /**
     * @return the motivoMorteNeonataisPrecoce
     */
    public String getMotivoMorteNeonataisPrecoce() {
        return motivoMorteNeonataisPrecoce;
    }

    /**
     * @param motivoMorteNeonataisPrecoce the motivoMorteNeonataisPrecoce to set
     */
    public void setMotivoMorteNeonataisPrecoce(String motivoMorteNeonataisPrecoce) {
        this.motivoMorteNeonataisPrecoce = motivoMorteNeonataisPrecoce;
    }

    /**
     * @return the mortesNeonataisTardias
     */
    public int getMortesNeonataisTardias() {
        return mortesNeonataisTardias;
    }

    /**
     * @param mortesNeonataisTardias the mortesNeonataisTardias to set
     */
    public void setMortesNeonataisTardias(int mortesNeonataisTardias) {
        this.mortesNeonataisTardias = mortesNeonataisTardias;
    }

    /**
     * @return the motivoMortesNeonataisTardias
     */
    public String getMotivoMortesNeonataisTardias() {
        return motivoMortesNeonataisTardias;
    }

    /**
     * @param motivoMortesNeonataisTardias the motivoMortesNeonataisTardias to set
     */
    public void setMotivoMortesNeonataisTardias(String motivoMortesNeonataisTardias) {
        this.motivoMortesNeonataisTardias = motivoMortesNeonataisTardias;
    }

    /**
     * @return the natimortos
     */
    public int getNatimortos() {
        return natimortos;
    }

    /**
     * @param natimortos the natimortos to set
     */
    public void setNatimortos(int natimortos) {
        this.natimortos = natimortos;
    }

    /**
     * @return the ictericia
     */
    public int getIctericia() {
        return ictericia;
    }

    /**
     * @param ictericia the ictericia to set
     */
    public void setIctericia(int ictericia) {
        this.ictericia = ictericia;
    }

    /**
     * @return the transfusao
     */
    public int getTransfusao() {
        return transfusao;
    }

    /**
     * @param transfusao the transfusao to set
     */
    public void setTransfusao(int transfusao) {
        this.transfusao = transfusao;
    }

    /**
     * @return the hipoglicemia
     */
    public int getHipoglicemia() {
        return hipoglicemia;
    }

    /**
     * @param hipoglicemia the hipoglicemia to set
     */
    public void setHipoglicemia(int hipoglicemia) {
        this.hipoglicemia = hipoglicemia;
    }

    /**
     * @return the isoimunizacaoRH
     */
    public String getIsoimunizacaoRH() {
        return isoimunizacaoRH;
    }

    /**
     * @param isoimunizacaoRH the isoimunizacaoRH to set
     */
    public void setIsoimunizacaoRH(String isoimunizacaoRH) {
        this.isoimunizacaoRH = isoimunizacaoRH;
    }

    /**
     * @return the intercorrenciaComplicacoesGestoes
     */
    public String getIntercorrenciaComplicacoesGestoes() {
        return intercorrenciaComplicacoesGestoes;
    }

    /**
     * @param intercorrenciaComplicacoesGestoes the intercorrenciaComplicacoesGestoes to set
     */
    public void setIntercorrenciaComplicacoesGestoes(String intercorrenciaComplicacoesGestoes) {
        this.intercorrenciaComplicacoesGestoes = intercorrenciaComplicacoesGestoes;
    }

    /**
     * @return the historiaAleitamentosAnteriores
     */
    public String getHistoriaAleitamentosAnteriores() {
        return historiaAleitamentosAnteriores;
    }

    /**
     * @param historiaAleitamentosAnteriores the historiaAleitamentosAnteriores to set
     */
    public void setHistoriaAleitamentosAnteriores(String historiaAleitamentosAnteriores) {
        this.historiaAleitamentosAnteriores = historiaAleitamentosAnteriores;
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
