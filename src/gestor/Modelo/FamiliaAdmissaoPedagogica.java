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
public class FamiliaAdmissaoPedagogica {

    private int idFam;
    private int idAdm;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String relacaoPai;
    private String relacaoMae;
    private String irmaos;
    private String paisLerEscrever;        
    private String paisSeparados;
    private String religiao;
    private int idadeAndou;
    private int idadeFalou;
    private String dificuldadeFala;
    private String qualDificuldadeFala;
    private String comunicacao;
    private String relacionamento;
    private String lider;    
    private String repetiuAno;
    private String porqueRepetiuAno;
    private String problemaProfessor;
    private String qualProblemaProfessor;
    private String comoAtitudeSala;
    private String faltaEscola;
    private String porqueFaltaEscola;
    private String achaEscola;            
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public FamiliaAdmissaoPedagogica(int idFam, int idAdm, int idInternoCrc, String nomeInternoCrc, String relacaoPai, String relacaoMae, String irmaos, String paisLerEscrever, String paisSeparados, String religiao, int idadeAndou, int idadeFalou, String dificuldadeFala, String qualDificuldadeFala, String comunicacao, String relacionamento, String lider, String repetiuAno, String porqueRepetiuAno, String problemaProfessor, String qualProblemaProfessor, String comoAtitudeSala, String faltaEscola, String porqueFaltaEscola, String achaEscola, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFam = idFam;
        this.idAdm = idAdm;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.relacaoPai = relacaoPai;
        this.relacaoMae = relacaoMae;
        this.irmaos = irmaos;
        this.paisLerEscrever = paisLerEscrever;
        this.paisSeparados = paisSeparados;
        this.religiao = religiao;
        this.idadeAndou = idadeAndou;
        this.idadeFalou = idadeFalou;
        this.dificuldadeFala = dificuldadeFala;
        this.qualDificuldadeFala = qualDificuldadeFala;
        this.comunicacao = comunicacao;
        this.relacionamento = relacionamento;
        this.lider = lider;
        this.repetiuAno = repetiuAno;
        this.porqueRepetiuAno = porqueRepetiuAno;
        this.problemaProfessor = problemaProfessor;
        this.qualProblemaProfessor = qualProblemaProfessor;
        this.comoAtitudeSala = comoAtitudeSala;
        this.faltaEscola = faltaEscola;
        this.porqueFaltaEscola = porqueFaltaEscola;
        this.achaEscola = achaEscola;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FamiliaAdmissaoPedagogica() {
    }

    /**
     * @return the idFam
     */
    public int getIdFam() {
        return idFam;
    }

    /**
     * @param idFam the idFam to set
     */
    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }

    /**
     * @return the idAdm
     */
    public int getIdAdm() {
        return idAdm;
    }

    /**
     * @param idAdm the idAdm to set
     */
    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
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
     * @return the relacaoPai
     */
    public String getRelacaoPai() {
        return relacaoPai;
    }

    /**
     * @param relacaoPai the relacaoPai to set
     */
    public void setRelacaoPai(String relacaoPai) {
        this.relacaoPai = relacaoPai;
    }

    /**
     * @return the relacaoMae
     */
    public String getRelacaoMae() {
        return relacaoMae;
    }

    /**
     * @param relacaoMae the relacaoMae to set
     */
    public void setRelacaoMae(String relacaoMae) {
        this.relacaoMae = relacaoMae;
    }

    /**
     * @return the irmaos
     */
    public String getIrmaos() {
        return irmaos;
    }

    /**
     * @param irmaos the irmaos to set
     */
    public void setIrmaos(String irmaos) {
        this.irmaos = irmaos;
    }

    /**
     * @return the paisLerEscrever
     */
    public String getPaisLerEscrever() {
        return paisLerEscrever;
    }

    /**
     * @param paisLerEscrever the paisLerEscrever to set
     */
    public void setPaisLerEscrever(String paisLerEscrever) {
        this.paisLerEscrever = paisLerEscrever;
    }

    /**
     * @return the paisSeparados
     */
    public String getPaisSeparados() {
        return paisSeparados;
    }

    /**
     * @param paisSeparados the paisSeparados to set
     */
    public void setPaisSeparados(String paisSeparados) {
        this.paisSeparados = paisSeparados;
    }

    /**
     * @return the religiao
     */
    public String getReligiao() {
        return religiao;
    }

    /**
     * @param religiao the religiao to set
     */
    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    /**
     * @return the idadeAndou
     */
    public int getIdadeAndou() {
        return idadeAndou;
    }

    /**
     * @param idadeAndou the idadeAndou to set
     */
    public void setIdadeAndou(int idadeAndou) {
        this.idadeAndou = idadeAndou;
    }

    /**
     * @return the idadeFalou
     */
    public int getIdadeFalou() {
        return idadeFalou;
    }

    /**
     * @param idadeFalou the idadeFalou to set
     */
    public void setIdadeFalou(int idadeFalou) {
        this.idadeFalou = idadeFalou;
    }

    /**
     * @return the dificuldadeFala
     */
    public String getDificuldadeFala() {
        return dificuldadeFala;
    }

    /**
     * @param dificuldadeFala the dificuldadeFala to set
     */
    public void setDificuldadeFala(String dificuldadeFala) {
        this.dificuldadeFala = dificuldadeFala;
    }

    /**
     * @return the qualDificuldadeFala
     */
    public String getQualDificuldadeFala() {
        return qualDificuldadeFala;
    }

    /**
     * @param qualDificuldadeFala the qualDificuldadeFala to set
     */
    public void setQualDificuldadeFala(String qualDificuldadeFala) {
        this.qualDificuldadeFala = qualDificuldadeFala;
    }

    /**
     * @return the comunicacao
     */
    public String getComunicacao() {
        return comunicacao;
    }

    /**
     * @param comunicacao the comunicacao to set
     */
    public void setComunicacao(String comunicacao) {
        this.comunicacao = comunicacao;
    }

    /**
     * @return the relacionamento
     */
    public String getRelacionamento() {
        return relacionamento;
    }

    /**
     * @param relacionamento the relacionamento to set
     */
    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    /**
     * @return the lider
     */
    public String getLider() {
        return lider;
    }

    /**
     * @param lider the lider to set
     */
    public void setLider(String lider) {
        this.lider = lider;
    }

    /**
     * @return the repetiuAno
     */
    public String getRepetiuAno() {
        return repetiuAno;
    }

    /**
     * @param repetiuAno the repetiuAno to set
     */
    public void setRepetiuAno(String repetiuAno) {
        this.repetiuAno = repetiuAno;
    }

    /**
     * @return the porqueRepetiuAno
     */
    public String getPorqueRepetiuAno() {
        return porqueRepetiuAno;
    }

    /**
     * @param porqueRepetiuAno the porqueRepetiuAno to set
     */
    public void setPorqueRepetiuAno(String porqueRepetiuAno) {
        this.porqueRepetiuAno = porqueRepetiuAno;
    }

    /**
     * @return the problemaProfessor
     */
    public String getProblemaProfessor() {
        return problemaProfessor;
    }

    /**
     * @param problemaProfessor the problemaProfessor to set
     */
    public void setProblemaProfessor(String problemaProfessor) {
        this.problemaProfessor = problemaProfessor;
    }

    /**
     * @return the qualProblemaProfessor
     */
    public String getQualProblemaProfessor() {
        return qualProblemaProfessor;
    }

    /**
     * @param qualProblemaProfessor the qualProblemaProfessor to set
     */
    public void setQualProblemaProfessor(String qualProblemaProfessor) {
        this.qualProblemaProfessor = qualProblemaProfessor;
    }

    /**
     * @return the comoAtitudeSala
     */
    public String getComoAtitudeSala() {
        return comoAtitudeSala;
    }

    /**
     * @param comoAtitudeSala the comoAtitudeSala to set
     */
    public void setComoAtitudeSala(String comoAtitudeSala) {
        this.comoAtitudeSala = comoAtitudeSala;
    }

    /**
     * @return the faltaEscola
     */
    public String getFaltaEscola() {
        return faltaEscola;
    }

    /**
     * @param faltaEscola the faltaEscola to set
     */
    public void setFaltaEscola(String faltaEscola) {
        this.faltaEscola = faltaEscola;
    }

    /**
     * @return the porqueFaltaEscola
     */
    public String getPorqueFaltaEscola() {
        return porqueFaltaEscola;
    }

    /**
     * @param porqueFaltaEscola the porqueFaltaEscola to set
     */
    public void setPorqueFaltaEscola(String porqueFaltaEscola) {
        this.porqueFaltaEscola = porqueFaltaEscola;
    }

    /**
     * @return the achaEscola
     */
    public String getAchaEscola() {
        return achaEscola;
    }

    /**
     * @param achaEscola the achaEscola to set
     */
    public void setAchaEscola(String achaEscola) {
        this.achaEscola = achaEscola;
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
