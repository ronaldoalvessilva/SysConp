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
public class AdmissaoEvolucaoEducacaoFisica {

    private Integer idRegistroEF;
    private String statusEF;
    private Date dataRegistroEF;
    private Integer idInternoEF;
    private String matriculaEF;
    private Date dataNascimentoEF;
    private float pesoEF;
    private float alturaEF;
    private String nomeInternoEF;
    //PARTE I
    private String atividadeFisica;
    private String frequenciaSemanal;
    private String nivelCondicionamento;
    private String restricaoAtividadeFisica;
    private String qualRestricaoFisica;
    private String problemaCardiaco;
    private String qualProblemaCardiaco;
    //PARTE II
    private String algumTipoCirurgia;
    private String especificarCirurgia;
    private String problemaOrtopedico;
    private String habitoFumar;
    private Integer quantosCigarros;
    private String algumMedicamento;
    private String especificarMedicamento;
    //PARTE III
    private String diabetico;
    private String pressaoSanguinea;
    private String doresPeito;
    private String desmaio;
    //EVOLUÇÃO ADMISSÃO
    private String textoEvolucaoAdmissao;
    //EVOLUÇÃO        
    private Date dataEvolucaoEF;
    private String textoEvolucaoEF;
    //
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public AdmissaoEvolucaoEducacaoFisica() {
    }

    public AdmissaoEvolucaoEducacaoFisica(Integer idRegistroEF, String statusEF, Date dataRegistroEF, Integer idInternoEF, String matriculaEF, Date dataNascimentoEF, float pesoEF, float alturaEF, String nomeInternoEF, String atividadeFisica, String frequenciaSemanal, String nivelCondicionamento, String restricaoAtividadeFisica, String qualRestricaoFisica, String problemaCardiaco, String qualProblemaCardiaco, String algumTipoCirurgia, String especificarCirurgia, String problemaOrtopedico, String habitoFumar, Integer quantosCigarros, String algumMedicamento, String especificarMedicamento, String diabetico, String pressaoSanguinea, String doresPeito, String desmaio, String textoEvolucaoAdmissao, Date dataEvolucaoEF, String textoEvolucaoEF, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idRegistroEF = idRegistroEF;
        this.statusEF = statusEF;
        this.dataRegistroEF = dataRegistroEF;
        this.idInternoEF = idInternoEF;
        this.matriculaEF = matriculaEF;
        this.dataNascimentoEF = dataNascimentoEF;
        this.pesoEF = pesoEF;
        this.alturaEF = alturaEF;
        this.nomeInternoEF = nomeInternoEF;
        this.atividadeFisica = atividadeFisica;
        this.frequenciaSemanal = frequenciaSemanal;
        this.nivelCondicionamento = nivelCondicionamento;
        this.restricaoAtividadeFisica = restricaoAtividadeFisica;
        this.qualRestricaoFisica = qualRestricaoFisica;
        this.problemaCardiaco = problemaCardiaco;
        this.qualProblemaCardiaco = qualProblemaCardiaco;
        this.algumTipoCirurgia = algumTipoCirurgia;
        this.especificarCirurgia = especificarCirurgia;
        this.problemaOrtopedico = problemaOrtopedico;
        this.habitoFumar = habitoFumar;
        this.quantosCigarros = quantosCigarros;
        this.algumMedicamento = algumMedicamento;
        this.especificarMedicamento = especificarMedicamento;
        this.diabetico = diabetico;
        this.pressaoSanguinea = pressaoSanguinea;
        this.doresPeito = doresPeito;
        this.desmaio = desmaio;
        this.textoEvolucaoAdmissao = textoEvolucaoAdmissao;
        this.dataEvolucaoEF = dataEvolucaoEF;
        this.textoEvolucaoEF = textoEvolucaoEF;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegistroEF
     */
    public Integer getIdRegistroEF() {
        return idRegistroEF;
    }

    /**
     * @param idRegistroEF the idRegistroEF to set
     */
    public void setIdRegistroEF(Integer idRegistroEF) {
        this.idRegistroEF = idRegistroEF;
    }

    /**
     * @return the statusEF
     */
    public String getStatusEF() {
        return statusEF;
    }

    /**
     * @param statusEF the statusEF to set
     */
    public void setStatusEF(String statusEF) {
        this.statusEF = statusEF;
    }

    /**
     * @return the dataRegistroEF
     */
    public Date getDataRegistroEF() {
        return dataRegistroEF;
    }

    /**
     * @param dataRegistroEF the dataRegistroEF to set
     */
    public void setDataRegistroEF(Date dataRegistroEF) {
        this.dataRegistroEF = dataRegistroEF;
    }

    /**
     * @return the idInternoEF
     */
    public Integer getIdInternoEF() {
        return idInternoEF;
    }

    /**
     * @param idInternoEF the idInternoEF to set
     */
    public void setIdInternoEF(Integer idInternoEF) {
        this.idInternoEF = idInternoEF;
    }

    /**
     * @return the matriculaEF
     */
    public String getMatriculaEF() {
        return matriculaEF;
    }

    /**
     * @param matriculaEF the matriculaEF to set
     */
    public void setMatriculaEF(String matriculaEF) {
        this.matriculaEF = matriculaEF;
    }

    /**
     * @return the dataNascimentoEF
     */
    public Date getDataNascimentoEF() {
        return dataNascimentoEF;
    }

    /**
     * @param dataNascimentoEF the dataNascimentoEF to set
     */
    public void setDataNascimentoEF(Date dataNascimentoEF) {
        this.dataNascimentoEF = dataNascimentoEF;
    }

    /**
     * @return the pesoEF
     */
    public float getPesoEF() {
        return pesoEF;
    }

    /**
     * @param pesoEF the pesoEF to set
     */
    public void setPesoEF(float pesoEF) {
        this.pesoEF = pesoEF;
    }

    /**
     * @return the alturaEF
     */
    public float getAlturaEF() {
        return alturaEF;
    }

    /**
     * @param alturaEF the alturaEF to set
     */
    public void setAlturaEF(float alturaEF) {
        this.alturaEF = alturaEF;
    }

    /**
     * @return the nomeInternoEF
     */
    public String getNomeInternoEF() {
        return nomeInternoEF;
    }

    /**
     * @param nomeInternoEF the nomeInternoEF to set
     */
    public void setNomeInternoEF(String nomeInternoEF) {
        this.nomeInternoEF = nomeInternoEF;
    }

    /**
     * @return the atividadeFisica
     */
    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    /**
     * @param atividadeFisica the atividadeFisica to set
     */
    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    /**
     * @return the frequenciaSemanal
     */
    public String getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    /**
     * @param frequenciaSemanal the frequenciaSemanal to set
     */
    public void setFrequenciaSemanal(String frequenciaSemanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }

    /**
     * @return the nivelCondicionamento
     */
    public String getNivelCondicionamento() {
        return nivelCondicionamento;
    }

    /**
     * @param nivelCondicionamento the nivelCondicionamento to set
     */
    public void setNivelCondicionamento(String nivelCondicionamento) {
        this.nivelCondicionamento = nivelCondicionamento;
    }

    /**
     * @return the restricaoAtividadeFisica
     */
    public String getRestricaoAtividadeFisica() {
        return restricaoAtividadeFisica;
    }

    /**
     * @param restricaoAtividadeFisica the restricaoAtividadeFisica to set
     */
    public void setRestricaoAtividadeFisica(String restricaoAtividadeFisica) {
        this.restricaoAtividadeFisica = restricaoAtividadeFisica;
    }

    /**
     * @return the qualRestricaoFisica
     */
    public String getQualRestricaoFisica() {
        return qualRestricaoFisica;
    }

    /**
     * @param qualRestricaoFisica the qualRestricaoFisica to set
     */
    public void setQualRestricaoFisica(String qualRestricaoFisica) {
        this.qualRestricaoFisica = qualRestricaoFisica;
    }

    /**
     * @return the problemaCardiaco
     */
    public String getProblemaCardiaco() {
        return problemaCardiaco;
    }

    /**
     * @param problemaCardiaco the problemaCardiaco to set
     */
    public void setProblemaCardiaco(String problemaCardiaco) {
        this.problemaCardiaco = problemaCardiaco;
    }

    /**
     * @return the qualProblemaCardiaco
     */
    public String getQualProblemaCardiaco() {
        return qualProblemaCardiaco;
    }

    /**
     * @param qualProblemaCardiaco the qualProblemaCardiaco to set
     */
    public void setQualProblemaCardiaco(String qualProblemaCardiaco) {
        this.qualProblemaCardiaco = qualProblemaCardiaco;
    }

    /**
     * @return the algumTipoCirurgia
     */
    public String getAlgumTipoCirurgia() {
        return algumTipoCirurgia;
    }

    /**
     * @param algumTipoCirurgia the algumTipoCirurgia to set
     */
    public void setAlgumTipoCirurgia(String algumTipoCirurgia) {
        this.algumTipoCirurgia = algumTipoCirurgia;
    }

    /**
     * @return the especificarCirurgia
     */
    public String getEspecificarCirurgia() {
        return especificarCirurgia;
    }

    /**
     * @param especificarCirurgia the especificarCirurgia to set
     */
    public void setEspecificarCirurgia(String especificarCirurgia) {
        this.especificarCirurgia = especificarCirurgia;
    }

    /**
     * @return the problemaOrtopedico
     */
    public String getProblemaOrtopedico() {
        return problemaOrtopedico;
    }

    /**
     * @param problemaOrtopedico the problemaOrtopedico to set
     */
    public void setProblemaOrtopedico(String problemaOrtopedico) {
        this.problemaOrtopedico = problemaOrtopedico;
    }

    /**
     * @return the habitoFumar
     */
    public String getHabitoFumar() {
        return habitoFumar;
    }

    /**
     * @param habitoFumar the habitoFumar to set
     */
    public void setHabitoFumar(String habitoFumar) {
        this.habitoFumar = habitoFumar;
    }

    /**
     * @return the quantosCigarros
     */
    public Integer getQuantosCigarros() {
        return quantosCigarros;
    }

    /**
     * @param quantosCigarros the quantosCigarros to set
     */
    public void setQuantosCigarros(Integer quantosCigarros) {
        this.quantosCigarros = quantosCigarros;
    }

    /**
     * @return the algumMedicamento
     */
    public String getAlgumMedicamento() {
        return algumMedicamento;
    }

    /**
     * @param algumMedicamento the algumMedicamento to set
     */
    public void setAlgumMedicamento(String algumMedicamento) {
        this.algumMedicamento = algumMedicamento;
    }

    /**
     * @return the especificarMedicamento
     */
    public String getEspecificarMedicamento() {
        return especificarMedicamento;
    }

    /**
     * @param especificarMedicamento the especificarMedicamento to set
     */
    public void setEspecificarMedicamento(String especificarMedicamento) {
        this.especificarMedicamento = especificarMedicamento;
    }

    /**
     * @return the diabetico
     */
    public String getDiabetico() {
        return diabetico;
    }

    /**
     * @param diabetico the diabetico to set
     */
    public void setDiabetico(String diabetico) {
        this.diabetico = diabetico;
    }

    /**
     * @return the pressaoSanguinea
     */
    public String getPressaoSanguinea() {
        return pressaoSanguinea;
    }

    /**
     * @param pressaoSanguinea the pressaoSanguinea to set
     */
    public void setPressaoSanguinea(String pressaoSanguinea) {
        this.pressaoSanguinea = pressaoSanguinea;
    }

    /**
     * @return the doresPeito
     */
    public String getDoresPeito() {
        return doresPeito;
    }

    /**
     * @param doresPeito the doresPeito to set
     */
    public void setDoresPeito(String doresPeito) {
        this.doresPeito = doresPeito;
    }

    /**
     * @return the desmaio
     */
    public String getDesmaio() {
        return desmaio;
    }

    /**
     * @param desmaio the desmaio to set
     */
    public void setDesmaio(String desmaio) {
        this.desmaio = desmaio;
    }

    /**
     * @return the textoEvolucaoAdmissao
     */
    public String getTextoEvolucaoAdmissao() {
        return textoEvolucaoAdmissao;
    }

    /**
     * @param textoEvolucaoAdmissao the textoEvolucaoAdmissao to set
     */
    public void setTextoEvolucaoAdmissao(String textoEvolucaoAdmissao) {
        this.textoEvolucaoAdmissao = textoEvolucaoAdmissao;
    }

    /**
     * @return the dataEvolucaoEF
     */
    public Date getDataEvolucaoEF() {
        return dataEvolucaoEF;
    }

    /**
     * @param dataEvolucaoEF the dataEvolucaoEF to set
     */
    public void setDataEvolucaoEF(Date dataEvolucaoEF) {
        this.dataEvolucaoEF = dataEvolucaoEF;
    }

    /**
     * @return the textoEvolucaoEF
     */
    public String getTextoEvolucaoEF() {
        return textoEvolucaoEF;
    }

    /**
     * @param textoEvolucaoEF the textoEvolucaoEF to set
     */
    public void setTextoEvolucaoEF(String textoEvolucaoEF) {
        this.textoEvolucaoEF = textoEvolucaoEF;
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
