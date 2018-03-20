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
public class FichaPAI_DJ {

    private int idDJ;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String regimeAprisionamento;
    private int artigo;
    private String delito;
    private String reincidente;
    private String possuiPena;
    private String qualPena;
    private String possuiJuridica;
    private String qualAssistenciaJuridica;
    private String pROMAE;
    private String assistenciaJuridica;
    private String trabalhaempresa;
    private String telefoneContatoEmpresa;
    private String qualEmpresa;
    private String qualFuncaoExerce;
    private String cartaInformal;
    private String paraOnde;
    private String telefoneContato;
    private String estudaUP;
    private String ondeEstuda;
    private String necessitaTrabalho;
    private String qualNecessitaTrabalho;
    private String necessitaEstudaFUP;
    private String qualNecessidadeEstudaFUP;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public FichaPAI_DJ(int idDJ, int idPai, int idInternoCrc, String nomeInternoCrc, String regimeAprisionamento, int artigo, String delito, String reincidente, String possuiPena, String qualPena, String possuiJuridica, String qualAssistenciaJuridica, String pROMAE, String assistenciaJuridica, String trabalhaempresa, String telefoneContatoEmpresa, String qualEmpresa, String qualFuncaoExerce, String cartaInformal, String paraOnde, String telefoneContato, String estudaUP, String ondeEstuda, String necessitaTrabalho, String qualNecessitaTrabalho, String necessitaEstudaFUP, String qualNecessidadeEstudaFUP, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDJ = idDJ;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.regimeAprisionamento = regimeAprisionamento;
        this.artigo = artigo;
        this.delito = delito;
        this.reincidente = reincidente;
        this.possuiPena = possuiPena;
        this.qualPena = qualPena;
        this.possuiJuridica = possuiJuridica;
        this.qualAssistenciaJuridica = qualAssistenciaJuridica;
        this.pROMAE = pROMAE;
        this.assistenciaJuridica = assistenciaJuridica;
        this.trabalhaempresa = trabalhaempresa;
        this.telefoneContatoEmpresa = telefoneContatoEmpresa;
        this.qualEmpresa = qualEmpresa;
        this.qualFuncaoExerce = qualFuncaoExerce;
        this.cartaInformal = cartaInformal;
        this.paraOnde = paraOnde;
        this.telefoneContato = telefoneContato;
        this.estudaUP = estudaUP;
        this.ondeEstuda = ondeEstuda;
        this.necessitaTrabalho = necessitaTrabalho;
        this.qualNecessitaTrabalho = qualNecessitaTrabalho;
        this.necessitaEstudaFUP = necessitaEstudaFUP;
        this.qualNecessidadeEstudaFUP = qualNecessidadeEstudaFUP;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaPAI_DJ() {
    }

    /**
     * @return the idDJ
     */
    public int getIdDJ() {
        return idDJ;
    }

    /**
     * @param idDJ the idDJ to set
     */
    public void setIdDJ(int idDJ) {
        this.idDJ = idDJ;
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
     * @return the regimeAprisionamento
     */
    public String getRegimeAprisionamento() {
        return regimeAprisionamento;
    }

    /**
     * @param regimeAprisionamento the regimeAprisionamento to set
     */
    public void setRegimeAprisionamento(String regimeAprisionamento) {
        this.regimeAprisionamento = regimeAprisionamento;
    }

    /**
     * @return the artigo
     */
    public int getArtigo() {
        return artigo;
    }

    /**
     * @param artigo the artigo to set
     */
    public void setArtigo(int artigo) {
        this.artigo = artigo;
    }

    /**
     * @return the delito
     */
    public String getDelito() {
        return delito;
    }

    /**
     * @param delito the delito to set
     */
    public void setDelito(String delito) {
        this.delito = delito;
    }

    /**
     * @return the reincidente
     */
    public String getReincidente() {
        return reincidente;
    }

    /**
     * @param reincidente the reincidente to set
     */
    public void setReincidente(String reincidente) {
        this.reincidente = reincidente;
    }

    /**
     * @return the possuiPena
     */
    public String getPossuiPena() {
        return possuiPena;
    }

    /**
     * @param possuiPena the possuiPena to set
     */
    public void setPossuiPena(String possuiPena) {
        this.possuiPena = possuiPena;
    }

    /**
     * @return the qualPena
     */
    public String getQualPena() {
        return qualPena;
    }

    /**
     * @param qualPena the qualPena to set
     */
    public void setQualPena(String qualPena) {
        this.qualPena = qualPena;
    }

    /**
     * @return the possuiJuridica
     */
    public String getPossuiJuridica() {
        return possuiJuridica;
    }

    /**
     * @param possuiJuridica the possuiJuridica to set
     */
    public void setPossuiJuridica(String possuiJuridica) {
        this.possuiJuridica = possuiJuridica;
    }

    /**
     * @return the qualAssistenciaJuridica
     */
    public String getQualAssistenciaJuridica() {
        return qualAssistenciaJuridica;
    }

    /**
     * @param qualAssistenciaJuridica the qualAssistenciaJuridica to set
     */
    public void setQualAssistenciaJuridica(String qualAssistenciaJuridica) {
        this.qualAssistenciaJuridica = qualAssistenciaJuridica;
    }

    /**
     * @return the pROMAE
     */
    public String getpROMAE() {
        return pROMAE;
    }

    /**
     * @param pROMAE the pROMAE to set
     */
    public void setpROMAE(String pROMAE) {
        this.pROMAE = pROMAE;
    }

    /**
     * @return the assistenciaJuridica
     */
    public String getAssistenciaJuridica() {
        return assistenciaJuridica;
    }

    /**
     * @param assistenciaJuridica the assistenciaJuridica to set
     */
    public void setAssistenciaJuridica(String assistenciaJuridica) {
        this.assistenciaJuridica = assistenciaJuridica;
    }

    /**
     * @return the trabalhaempresa
     */
    public String getTrabalhaempresa() {
        return trabalhaempresa;
    }

    /**
     * @param trabalhaempresa the trabalhaempresa to set
     */
    public void setTrabalhaempresa(String trabalhaempresa) {
        this.trabalhaempresa = trabalhaempresa;
    }

    /**
     * @return the telefoneContatoEmpresa
     */
    public String getTelefoneContatoEmpresa() {
        return telefoneContatoEmpresa;
    }

    /**
     * @param telefoneContatoEmpresa the telefoneContatoEmpresa to set
     */
    public void setTelefoneContatoEmpresa(String telefoneContatoEmpresa) {
        this.telefoneContatoEmpresa = telefoneContatoEmpresa;
    }

    /**
     * @return the qualEmpresa
     */
    public String getQualEmpresa() {
        return qualEmpresa;
    }

    /**
     * @param qualEmpresa the qualEmpresa to set
     */
    public void setQualEmpresa(String qualEmpresa) {
        this.qualEmpresa = qualEmpresa;
    }

    /**
     * @return the qualFuncaoExerce
     */
    public String getQualFuncaoExerce() {
        return qualFuncaoExerce;
    }

    /**
     * @param qualFuncaoExerce the qualFuncaoExerce to set
     */
    public void setQualFuncaoExerce(String qualFuncaoExerce) {
        this.qualFuncaoExerce = qualFuncaoExerce;
    }

    /**
     * @return the cartaInformal
     */
    public String getCartaInformal() {
        return cartaInformal;
    }

    /**
     * @param cartaInformal the cartaInformal to set
     */
    public void setCartaInformal(String cartaInformal) {
        this.cartaInformal = cartaInformal;
    }

    /**
     * @return the paraOnde
     */
    public String getParaOnde() {
        return paraOnde;
    }

    /**
     * @param paraOnde the paraOnde to set
     */
    public void setParaOnde(String paraOnde) {
        this.paraOnde = paraOnde;
    }

    /**
     * @return the telefoneContato
     */
    public String getTelefoneContato() {
        return telefoneContato;
    }

    /**
     * @param telefoneContato the telefoneContato to set
     */
    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    /**
     * @return the estudaUP
     */
    public String getEstudaUP() {
        return estudaUP;
    }

    /**
     * @param estudaUP the estudaUP to set
     */
    public void setEstudaUP(String estudaUP) {
        this.estudaUP = estudaUP;
    }

    /**
     * @return the ondeEstuda
     */
    public String getOndeEstuda() {
        return ondeEstuda;
    }

    /**
     * @param ondeEstuda the ondeEstuda to set
     */
    public void setOndeEstuda(String ondeEstuda) {
        this.ondeEstuda = ondeEstuda;
    }

    /**
     * @return the necessitaTrabalho
     */
    public String getNecessitaTrabalho() {
        return necessitaTrabalho;
    }

    /**
     * @param necessitaTrabalho the necessitaTrabalho to set
     */
    public void setNecessitaTrabalho(String necessitaTrabalho) {
        this.necessitaTrabalho = necessitaTrabalho;
    }

    /**
     * @return the qualNecessitaTrabalho
     */
    public String getQualNecessitaTrabalho() {
        return qualNecessitaTrabalho;
    }

    /**
     * @param qualNecessitaTrabalho the qualNecessitaTrabalho to set
     */
    public void setQualNecessitaTrabalho(String qualNecessitaTrabalho) {
        this.qualNecessitaTrabalho = qualNecessitaTrabalho;
    }

    /**
     * @return the necessitaEstudaFUP
     */
    public String getNecessitaEstudaFUP() {
        return necessitaEstudaFUP;
    }

    /**
     * @param necessitaEstudaFUP the necessitaEstudaFUP to set
     */
    public void setNecessitaEstudaFUP(String necessitaEstudaFUP) {
        this.necessitaEstudaFUP = necessitaEstudaFUP;
    }

    /**
     * @return the qualNecessidadeEstudaFUP
     */
    public String getQualNecessidadeEstudaFUP() {
        return qualNecessidadeEstudaFUP;
    }

    /**
     * @param qualNecessidadeEstudaFUP the qualNecessidadeEstudaFUP to set
     */
    public void setQualNecessidadeEstudaFUP(String qualNecessidadeEstudaFUP) {
        this.qualNecessidadeEstudaFUP = qualNecessidadeEstudaFUP;
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
