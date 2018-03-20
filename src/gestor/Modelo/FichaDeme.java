/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class FichaDeme {

    private int idDEME;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String necessitaFamilia;
    private String paraQuemFamilia;
    private String estaGravida;
    private String comprovacao;
    private String preNatal;
    private String ondePreNatal;
    private String destinoBebe;
    private String suspeitaGravidez;
    private int quantosPartos;
    private int quantosAbortos;
    private int quantosPartosNornais;
    private int quantasCesarianas;
    private String contraceptivos;
    private String qualContraceptivos;
    private String demanda;
    private String qualDemanda;
    private String instrucao;
    private String estudandoPreso;
    private String participouPrisional;
    private String gostariaPrisional;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public FichaDeme(int idDEME, int idPai, int idInternoCrc, String nomeInternoCrc, String necessitaFamilia, String paraQuemFamilia, String estaGravida, String comprovacao, String preNatal, String ondePreNatal, String destinoBebe, String suspeitaGravidez, int quantosPartos, int quantosAbortos, int quantosPartosNornais, int quantasCesarianas, String contraceptivos, String qualContraceptivos, String demanda, String qualDemanda, String instrucao, String estudandoPreso, String participouPrisional, String gostariaPrisional, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDEME = idDEME;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.necessitaFamilia = necessitaFamilia;
        this.paraQuemFamilia = paraQuemFamilia;
        this.estaGravida = estaGravida;
        this.comprovacao = comprovacao;
        this.preNatal = preNatal;
        this.ondePreNatal = ondePreNatal;
        this.destinoBebe = destinoBebe;
        this.suspeitaGravidez = suspeitaGravidez;
        this.quantosPartos = quantosPartos;
        this.quantosAbortos = quantosAbortos;
        this.quantosPartosNornais = quantosPartosNornais;
        this.quantasCesarianas = quantasCesarianas;
        this.contraceptivos = contraceptivos;
        this.qualContraceptivos = qualContraceptivos;
        this.demanda = demanda;
        this.qualDemanda = qualDemanda;
        this.instrucao = instrucao;
        this.estudandoPreso = estudandoPreso;
        this.participouPrisional = participouPrisional;
        this.gostariaPrisional = gostariaPrisional;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaDeme() {
    }

    /**
     * @return the idDEME
     */
    public int getIdDEME() {
        return idDEME;
    }

    /**
     * @param idDEME the idDEME to set
     */
    public void setIdDEME(int idDEME) {
        this.idDEME = idDEME;
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
     * @return the necessitaFamilia
     */
    public String getNecessitaFamilia() {
        return necessitaFamilia;
    }

    /**
     * @param necessitaFamilia the necessitaFamilia to set
     */
    public void setNecessitaFamilia(String necessitaFamilia) {
        this.necessitaFamilia = necessitaFamilia;
    }

    /**
     * @return the paraQuemFamilia
     */
    public String getParaQuemFamilia() {
        return paraQuemFamilia;
    }

    /**
     * @param paraQuemFamilia the paraQuemFamilia to set
     */
    public void setParaQuemFamilia(String paraQuemFamilia) {
        this.paraQuemFamilia = paraQuemFamilia;
    }

    /**
     * @return the estaGravida
     */
    public String getEstaGravida() {
        return estaGravida;
    }

    /**
     * @param estaGravida the estaGravida to set
     */
    public void setEstaGravida(String estaGravida) {
        this.estaGravida = estaGravida;
    }

    /**
     * @return the comprovacao
     */
    public String getComprovacao() {
        return comprovacao;
    }

    /**
     * @param comprovacao the comprovacao to set
     */
    public void setComprovacao(String comprovacao) {
        this.comprovacao = comprovacao;
    }

    /**
     * @return the preNatal
     */
    public String getPreNatal() {
        return preNatal;
    }

    /**
     * @param preNatal the preNatal to set
     */
    public void setPreNatal(String preNatal) {
        this.preNatal = preNatal;
    }

    /**
     * @return the ondePreNatal
     */
    public String getOndePreNatal() {
        return ondePreNatal;
    }

    /**
     * @param ondePreNatal the ondePreNatal to set
     */
    public void setOndePreNatal(String ondePreNatal) {
        this.ondePreNatal = ondePreNatal;
    }

    /**
     * @return the destinoBebe
     */
    public String getDestinoBebe() {
        return destinoBebe;
    }

    /**
     * @param destinoBebe the destinoBebe to set
     */
    public void setDestinoBebe(String destinoBebe) {
        this.destinoBebe = destinoBebe;
    }

    /**
     * @return the suspeitaGravidez
     */
    public String getSuspeitaGravidez() {
        return suspeitaGravidez;
    }

    /**
     * @param suspeitaGravidez the suspeitaGravidez to set
     */
    public void setSuspeitaGravidez(String suspeitaGravidez) {
        this.suspeitaGravidez = suspeitaGravidez;
    }

    /**
     * @return the quantosPartos
     */
    public int getQuantosPartos() {
        return quantosPartos;
    }

    /**
     * @param quantosPartos the quantosPartos to set
     */
    public void setQuantosPartos(int quantosPartos) {
        this.quantosPartos = quantosPartos;
    }

    /**
     * @return the quantosAbortos
     */
    public int getQuantosAbortos() {
        return quantosAbortos;
    }

    /**
     * @param quantosAbortos the quantosAbortos to set
     */
    public void setQuantosAbortos(int quantosAbortos) {
        this.quantosAbortos = quantosAbortos;
    }

    /**
     * @return the quantosPartosNornais
     */
    public int getQuantosPartosNornais() {
        return quantosPartosNornais;
    }

    /**
     * @param quantosPartosNornais the quantosPartosNornais to set
     */
    public void setQuantosPartosNornais(int quantosPartosNornais) {
        this.quantosPartosNornais = quantosPartosNornais;
    }

    /**
     * @return the quantasCesarianas
     */
    public int getQuantasCesarianas() {
        return quantasCesarianas;
    }

    /**
     * @param quantasCesarianas the quantasCesarianas to set
     */
    public void setQuantasCesarianas(int quantasCesarianas) {
        this.quantasCesarianas = quantasCesarianas;
    }

    /**
     * @return the contraceptivos
     */
    public String getContraceptivos() {
        return contraceptivos;
    }

    /**
     * @param contraceptivos the contraceptivos to set
     */
    public void setContraceptivos(String contraceptivos) {
        this.contraceptivos = contraceptivos;
    }

    /**
     * @return the qualContraceptivos
     */
    public String getQualContraceptivos() {
        return qualContraceptivos;
    }

    /**
     * @param qualContraceptivos the qualContraceptivos to set
     */
    public void setQualContraceptivos(String qualContraceptivos) {
        this.qualContraceptivos = qualContraceptivos;
    }

    /**
     * @return the demanda
     */
    public String getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(String demanda) {
        this.demanda = demanda;
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
     * @return the instrucao
     */
    public String getInstrucao() {
        return instrucao;
    }

    /**
     * @param instrucao the instrucao to set
     */
    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    /**
     * @return the estudandoPreso
     */
    public String getEstudandoPreso() {
        return estudandoPreso;
    }

    /**
     * @param estudandoPreso the estudandoPreso to set
     */
    public void setEstudandoPreso(String estudandoPreso) {
        this.estudandoPreso = estudandoPreso;
    }

    /**
     * @return the participouPrisional
     */
    public String getParticipouPrisional() {
        return participouPrisional;
    }

    /**
     * @param participouPrisional the participouPrisional to set
     */
    public void setParticipouPrisional(String participouPrisional) {
        this.participouPrisional = participouPrisional;
    }

    /**
     * @return the gostariaPrisional
     */
    public String getGostariaPrisional() {
        return gostariaPrisional;
    }

    /**
     * @param gostariaPrisional the gostariaPrisional to set
     */
    public void setGostariaPrisional(String gostariaPrisional) {
        this.gostariaPrisional = gostariaPrisional;
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
