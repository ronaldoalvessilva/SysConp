/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class TerapiaPedagogiaPsicosocial {

    private int idToPed;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String escolaridade;
    private String demandaEscolar;
    private String frequnetaEscola;
    private String qualEscola;
    private int instrucao;
    private String observacaoTOPED;
    private String profissao;
    private String participaLabor;
    private String qualLabor;
    private String observacaoLabor;
    private String demandaQualiProf;
    private String qualDemanda;
    private String experienciaTrabRenda;
    private String qualExperiencia;
    private String habilidades;
    private String participaAtividade;
    private String quaisAtividades;
    private String demandaParticaCultura;
    private String esporte;
    private String qualEsporte;
    private String lazer;
    private String qualLazer;
    private String cultura;
    private String qualCultura;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;      

    public TerapiaPedagogiaPsicosocial(int idToPed, int idPai, int idInternoCrc, String nomeInternoCrc, String escolaridade, String demandaEscolar, String frequnetaEscola, String qualEscola, int instrucao, String observacaoTOPED, String profissao, String participaLabor, String qualLabor, String observacaoLabor, String demandaQualiProf, String qualDemanda, String experienciaTrabRenda, String qualExperiencia, String habilidades, String participaAtividade, String quaisAtividades, String demandaParticaCultura, String esporte, String qualEsporte, String lazer, String qualLazer, String cultura, String qualCultura, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idToPed = idToPed;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.escolaridade = escolaridade;
        this.demandaEscolar = demandaEscolar;
        this.frequnetaEscola = frequnetaEscola;
        this.qualEscola = qualEscola;
        this.instrucao = instrucao;
        this.observacaoTOPED = observacaoTOPED;
        this.profissao = profissao;
        this.participaLabor = participaLabor;
        this.qualLabor = qualLabor;
        this.observacaoLabor = observacaoLabor;
        this.demandaQualiProf = demandaQualiProf;
        this.qualDemanda = qualDemanda;
        this.experienciaTrabRenda = experienciaTrabRenda;
        this.qualExperiencia = qualExperiencia;
        this.habilidades = habilidades;
        this.participaAtividade = participaAtividade;
        this.quaisAtividades = quaisAtividades;
        this.demandaParticaCultura = demandaParticaCultura;
        this.esporte = esporte;
        this.qualEsporte = qualEsporte;
        this.lazer = lazer;
        this.qualLazer = qualLazer;
        this.cultura = cultura;
        this.qualCultura = qualCultura;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TerapiaPedagogiaPsicosocial() {
    }

    /**
     * @return the idToPed
     */
    public int getIdToPed() {
        return idToPed;
    }

    /**
     * @param idToPed the idToPed to set
     */
    public void setIdToPed(int idToPed) {
        this.idToPed = idToPed;
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the demandaEscolar
     */
    public String getDemandaEscolar() {
        return demandaEscolar;
    }

    /**
     * @param demandaEscolar the demandaEscolar to set
     */
    public void setDemandaEscolar(String demandaEscolar) {
        this.demandaEscolar = demandaEscolar;
    }

    /**
     * @return the frequnetaEscola
     */
    public String getFrequnetaEscola() {
        return frequnetaEscola;
    }

    /**
     * @param frequnetaEscola the frequnetaEscola to set
     */
    public void setFrequnetaEscola(String frequnetaEscola) {
        this.frequnetaEscola = frequnetaEscola;
    }

    /**
     * @return the qualEscola
     */
    public String getQualEscola() {
        return qualEscola;
    }

    /**
     * @param qualEscola the qualEscola to set
     */
    public void setQualEscola(String qualEscola) {
        this.qualEscola = qualEscola;
    }

    /**
     * @return the instrucao
     */
    public int getInstrucao() {
        return instrucao;
    }

    /**
     * @param instrucao the instrucao to set
     */
    public void setInstrucao(int instrucao) {
        this.instrucao = instrucao;
    }

    /**
     * @return the observacaoTOPED
     */
    public String getObservacaoTOPED() {
        return observacaoTOPED;
    }

    /**
     * @param observacaoTOPED the observacaoTOPED to set
     */
    public void setObservacaoTOPED(String observacaoTOPED) {
        this.observacaoTOPED = observacaoTOPED;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the participaLabor
     */
    public String getParticipaLabor() {
        return participaLabor;
    }

    /**
     * @param participaLabor the participaLabor to set
     */
    public void setParticipaLabor(String participaLabor) {
        this.participaLabor = participaLabor;
    }

    /**
     * @return the qualLabor
     */
    public String getQualLabor() {
        return qualLabor;
    }

    /**
     * @param qualLabor the qualLabor to set
     */
    public void setQualLabor(String qualLabor) {
        this.qualLabor = qualLabor;
    }

    /**
     * @return the observacaoLabor
     */
    public String getObservacaoLabor() {
        return observacaoLabor;
    }

    /**
     * @param observacaoLabor the observacaoLabor to set
     */
    public void setObservacaoLabor(String observacaoLabor) {
        this.observacaoLabor = observacaoLabor;
    }

    /**
     * @return the demandaQualiProf
     */
    public String getDemandaQualiProf() {
        return demandaQualiProf;
    }

    /**
     * @param demandaQualiProf the demandaQualiProf to set
     */
    public void setDemandaQualiProf(String demandaQualiProf) {
        this.demandaQualiProf = demandaQualiProf;
    }

    /**
     * @return the qualDemanda
     */
    public String getQualDemanda() {
        return qualDemanda;
    }

    /**
     * @param qualDemanda the qualDemanda to set
     */
    public void setQualDemanda(String qualDemanda) {
        this.qualDemanda = qualDemanda;
    }

    /**
     * @return the experienciaTrabRenda
     */
    public String getExperienciaTrabRenda() {
        return experienciaTrabRenda;
    }

    /**
     * @param experienciaTrabRenda the experienciaTrabRenda to set
     */
    public void setExperienciaTrabRenda(String experienciaTrabRenda) {
        this.experienciaTrabRenda = experienciaTrabRenda;
    }

    /**
     * @return the qualExperiencia
     */
    public String getQualExperiencia() {
        return qualExperiencia;
    }

    /**
     * @param qualExperiencia the qualExperiencia to set
     */
    public void setQualExperiencia(String qualExperiencia) {
        this.qualExperiencia = qualExperiencia;
    }

    /**
     * @return the habilidades
     */
    public String getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidades the habilidades to set
     */
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * @return the participaAtividade
     */
    public String getParticipaAtividade() {
        return participaAtividade;
    }

    /**
     * @param participaAtividade the participaAtividade to set
     */
    public void setParticipaAtividade(String participaAtividade) {
        this.participaAtividade = participaAtividade;
    }

    /**
     * @return the quaisAtividades
     */
    public String getQuaisAtividades() {
        return quaisAtividades;
    }

    /**
     * @param quaisAtividades the quaisAtividades to set
     */
    public void setQuaisAtividades(String quaisAtividades) {
        this.quaisAtividades = quaisAtividades;
    }

    /**
     * @return the demandaParticaCultura
     */
    public String getDemandaParticaCultura() {
        return demandaParticaCultura;
    }

    /**
     * @param demandaParticaCultura the demandaParticaCultura to set
     */
    public void setDemandaParticaCultura(String demandaParticaCultura) {
        this.demandaParticaCultura = demandaParticaCultura;
    }

    /**
     * @return the esporte
     */
    public String getEsporte() {
        return esporte;
    }

    /**
     * @param esporte the esporte to set
     */
    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    /**
     * @return the qualEsporte
     */
    public String getQualEsporte() {
        return qualEsporte;
    }

    /**
     * @param qualEsporte the qualEsporte to set
     */
    public void setQualEsporte(String qualEsporte) {
        this.qualEsporte = qualEsporte;
    }

    /**
     * @return the lazer
     */
    public String getLazer() {
        return lazer;
    }

    /**
     * @param lazer the lazer to set
     */
    public void setLazer(String lazer) {
        this.lazer = lazer;
    }

    /**
     * @return the qualLazer
     */
    public String getQualLazer() {
        return qualLazer;
    }

    /**
     * @param qualLazer the qualLazer to set
     */
    public void setQualLazer(String qualLazer) {
        this.qualLazer = qualLazer;
    }

    /**
     * @return the cultura
     */
    public String getCultura() {
        return cultura;
    }

    /**
     * @param cultura the cultura to set
     */
    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    /**
     * @return the qualCultura
     */
    public String getQualCultura() {
        return qualCultura;
    }

    /**
     * @param qualCultura the qualCultura to set
     */
    public void setQualCultura(String qualCultura) {
        this.qualCultura = qualCultura;
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
