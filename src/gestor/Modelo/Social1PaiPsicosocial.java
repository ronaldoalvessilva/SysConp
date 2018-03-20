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
public class Social1PaiPsicosocial {

    private int idPaiSS1;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String documentoCivil;
    private String cNascimento;
    private String rG;
    private String cPF;
    private String cTPS;
    private String outrosDoc;
    private int qtdFilhosMaior;
    private String filhosSemRegistros;
    private int qtdFilhosSemRegistro;
    private int qtdFilhosMenor;
    private String observacaoFilhos;
    private String vulnerabilidaSocial;
    private String atendePrevistas;
    private String inseriProgramaSocial;
    private String qualProgramaSocial;
    private int partFamiliaCumpre;
    private String intervencaoPrograma;
    private String localizacaoFamiliares;    
    private String observacaoParticipacaoFamilia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;      

    public Social1PaiPsicosocial(int idPaiSS1, int idPai, int idInternoCrc, String nomeInternoCrc, String documentoCivil, String cNascimento, String rG, String cPF, String cTPS, String outrosDoc, int qtdFilhosMaior, String filhosSemRegistros, int qtdFilhosSemRegistro, int qtdFilhosMenor, String observacaoFilhos, String vulnerabilidaSocial, String atendePrevistas, String inseriProgramaSocial, String qualProgramaSocial, int partFamiliaCumpre, String intervencaoPrograma, String localizacaoFamiliares, String observacaoParticipacaoFamilia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPaiSS1 = idPaiSS1;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.documentoCivil = documentoCivil;
        this.cNascimento = cNascimento;
        this.rG = rG;
        this.cPF = cPF;
        this.cTPS = cTPS;
        this.outrosDoc = outrosDoc;
        this.qtdFilhosMaior = qtdFilhosMaior;
        this.filhosSemRegistros = filhosSemRegistros;
        this.qtdFilhosSemRegistro = qtdFilhosSemRegistro;
        this.qtdFilhosMenor = qtdFilhosMenor;
        this.observacaoFilhos = observacaoFilhos;
        this.vulnerabilidaSocial = vulnerabilidaSocial;
        this.atendePrevistas = atendePrevistas;
        this.inseriProgramaSocial = inseriProgramaSocial;
        this.qualProgramaSocial = qualProgramaSocial;
        this.partFamiliaCumpre = partFamiliaCumpre;
        this.intervencaoPrograma = intervencaoPrograma;
        this.localizacaoFamiliares = localizacaoFamiliares;
        this.observacaoParticipacaoFamilia = observacaoParticipacaoFamilia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Social1PaiPsicosocial() {
    }

    /**
     * @return the idPaiSS1
     */
    public int getIdPaiSS1() {
        return idPaiSS1;
    }

    /**
     * @param idPaiSS1 the idPaiSS1 to set
     */
    public void setIdPaiSS1(int idPaiSS1) {
        this.idPaiSS1 = idPaiSS1;
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
     * @return the documentoCivil
     */
    public String getDocumentoCivil() {
        return documentoCivil;
    }

    /**
     * @param documentoCivil the documentoCivil to set
     */
    public void setDocumentoCivil(String documentoCivil) {
        this.documentoCivil = documentoCivil;
    }

    /**
     * @return the cNascimento
     */
    public String getcNascimento() {
        return cNascimento;
    }

    /**
     * @param cNascimento the cNascimento to set
     */
    public void setcNascimento(String cNascimento) {
        this.cNascimento = cNascimento;
    }

    /**
     * @return the rG
     */
    public String getrG() {
        return rG;
    }

    /**
     * @param rG the rG to set
     */
    public void setrG(String rG) {
        this.rG = rG;
    }

    /**
     * @return the cPF
     */
    public String getcPF() {
        return cPF;
    }

    /**
     * @param cPF the cPF to set
     */
    public void setcPF(String cPF) {
        this.cPF = cPF;
    }

    /**
     * @return the cTPS
     */
    public String getcTPS() {
        return cTPS;
    }

    /**
     * @param cTPS the cTPS to set
     */
    public void setcTPS(String cTPS) {
        this.cTPS = cTPS;
    }

    /**
     * @return the outrosDoc
     */
    public String getOutrosDoc() {
        return outrosDoc;
    }

    /**
     * @param outrosDoc the outrosDoc to set
     */
    public void setOutrosDoc(String outrosDoc) {
        this.outrosDoc = outrosDoc;
    }

    /**
     * @return the qtdFilhosMaior
     */
    public int getQtdFilhosMaior() {
        return qtdFilhosMaior;
    }

    /**
     * @param qtdFilhosMaior the qtdFilhosMaior to set
     */
    public void setQtdFilhosMaior(int qtdFilhosMaior) {
        this.qtdFilhosMaior = qtdFilhosMaior;
    }

    /**
     * @return the filhosSemRegistros
     */
    public String getFilhosSemRegistros() {
        return filhosSemRegistros;
    }

    /**
     * @param filhosSemRegistros the filhosSemRegistros to set
     */
    public void setFilhosSemRegistros(String filhosSemRegistros) {
        this.filhosSemRegistros = filhosSemRegistros;
    }

    /**
     * @return the qtdFilhosSemRegistro
     */
    public int getQtdFilhosSemRegistro() {
        return qtdFilhosSemRegistro;
    }

    /**
     * @param qtdFilhosSemRegistro the qtdFilhosSemRegistro to set
     */
    public void setQtdFilhosSemRegistro(int qtdFilhosSemRegistro) {
        this.qtdFilhosSemRegistro = qtdFilhosSemRegistro;
    }

    /**
     * @return the qtdFilhosMenor
     */
    public int getQtdFilhosMenor() {
        return qtdFilhosMenor;
    }

    /**
     * @param qtdFilhosMenor the qtdFilhosMenor to set
     */
    public void setQtdFilhosMenor(int qtdFilhosMenor) {
        this.qtdFilhosMenor = qtdFilhosMenor;
    }

    /**
     * @return the observacaoFilhos
     */
    public String getObservacaoFilhos() {
        return observacaoFilhos;
    }

    /**
     * @param observacaoFilhos the observacaoFilhos to set
     */
    public void setObservacaoFilhos(String observacaoFilhos) {
        this.observacaoFilhos = observacaoFilhos;
    }

    /**
     * @return the vulnerabilidaSocial
     */
    public String getVulnerabilidaSocial() {
        return vulnerabilidaSocial;
    }

    /**
     * @param vulnerabilidaSocial the vulnerabilidaSocial to set
     */
    public void setVulnerabilidaSocial(String vulnerabilidaSocial) {
        this.vulnerabilidaSocial = vulnerabilidaSocial;
    }

    /**
     * @return the atendePrevistas
     */
    public String getAtendePrevistas() {
        return atendePrevistas;
    }

    /**
     * @param atendePrevistas the atendePrevistas to set
     */
    public void setAtendePrevistas(String atendePrevistas) {
        this.atendePrevistas = atendePrevistas;
    }

    /**
     * @return the inseriProgramaSocial
     */
    public String getInseriProgramaSocial() {
        return inseriProgramaSocial;
    }

    /**
     * @param inseriProgramaSocial the inseriProgramaSocial to set
     */
    public void setInseriProgramaSocial(String inseriProgramaSocial) {
        this.inseriProgramaSocial = inseriProgramaSocial;
    }

    /**
     * @return the qualProgramaSocial
     */
    public String getQualProgramaSocial() {
        return qualProgramaSocial;
    }

    /**
     * @param qualProgramaSocial the qualProgramaSocial to set
     */
    public void setQualProgramaSocial(String qualProgramaSocial) {
        this.qualProgramaSocial = qualProgramaSocial;
    }

    /**
     * @return the partFamiliaCumpre
     */
    public int getPartFamiliaCumpre() {
        return partFamiliaCumpre;
    }

    /**
     * @param partFamiliaCumpre the partFamiliaCumpre to set
     */
    public void setPartFamiliaCumpre(int partFamiliaCumpre) {
        this.partFamiliaCumpre = partFamiliaCumpre;
    }

    /**
     * @return the intervencaoPrograma
     */
    public String getIntervencaoPrograma() {
        return intervencaoPrograma;
    }

    /**
     * @param intervencaoPrograma the intervencaoPrograma to set
     */
    public void setIntervencaoPrograma(String intervencaoPrograma) {
        this.intervencaoPrograma = intervencaoPrograma;
    }

    /**
     * @return the localizacaoFamiliares
     */
    public String getLocalizacaoFamiliares() {
        return localizacaoFamiliares;
    }

    /**
     * @param localizacaoFamiliares the localizacaoFamiliares to set
     */
    public void setLocalizacaoFamiliares(String localizacaoFamiliares) {
        this.localizacaoFamiliares = localizacaoFamiliares;
    }

    /**
     * @return the observacaoParticipacaoFamilia
     */
    public String getObservacaoParticipacaoFamilia() {
        return observacaoParticipacaoFamilia;
    }

    /**
     * @param observacaoParticipacaoFamilia the observacaoParticipacaoFamilia to set
     */
    public void setObservacaoParticipacaoFamilia(String observacaoParticipacaoFamilia) {
        this.observacaoParticipacaoFamilia = observacaoParticipacaoFamilia;
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
