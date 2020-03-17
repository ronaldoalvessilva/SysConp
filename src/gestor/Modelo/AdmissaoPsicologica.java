/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class AdmissaoPsicologica {

    private int idLanc;
    private int idPortaPSI;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    //HISTORICO PRISIONAL
    private String presoAntes;
    private String familiaPreso;
    private String quemFamiliaPreso;
    private String ondePreso;
    private String historicoCriminal;
    // DROGAS
    private String usaDrogras;
    private int alcool;
    private int cigarro;
    private int maconha;
    private int crack;
    private int cocaina;
    private int cola;
    private int outros;
    private String outrasDrogas;
    private int qualIdade;
    private String porqueUsaDrogas;
    private String drogas;
    // TRANSTORNO MENTAL
    private String tratamentoPSI;
    private String medicamentoPSI;
    private String qualMedicamento;
    private String acompanhaPSI;
    private String transtornoMental;
    // ENCAMINHAMENTOS
    private String departamentoEncaminha;
    private Date dataEncaminhamento;
    private String horaAcompanha;
    private String encaminhamento;
    // PARECER PSICOLOGICO
    private int idParecer;
    private Date dataParecer;
    private String parecerPsicologico;    
    // TRATAMENTOS ANTERIORES
    private String tratamentoSaude;
    private String qualTratamentoSaude;
    private String ondeFazTratamento;
    private String tratamentoAntriores;
    // TENTATIVA DE SUICIDIO
    private String situacaoTraumatica;
    private String qualSituacaoTraumatica;
    private String houveTentativaSuicidio;
    private String porQueSuicidio;
    private String comoFoiTentarSuicidio;
    private String ondeTentouSuicidio;
    private String tentativaSuicidio;
    // USO DE MEDICAMENTOS
    private String qualMedicamentoUtiliza;
    private String porqueUsaMedicamento;
    private String usoMedicamentos;
    // FAMILIARES
    private String recebeVisitas;
    private String familiares;
    //
    private String deptoPsicologico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;   

    public AdmissaoPsicologica() {
    }

    public AdmissaoPsicologica(int idLanc, int idPortaPSI, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, String presoAntes, String familiaPreso, String quemFamiliaPreso, String ondePreso, String historicoCriminal, String usaDrogras, int alcool, int cigarro, int maconha, int crack, int cocaina, int cola, int outros, String outrasDrogas, int qualIdade, String porqueUsaDrogas, String drogas, String tratamentoPSI, String medicamentoPSI, String qualMedicamento, String acompanhaPSI, String transtornoMental, String departamentoEncaminha, Date dataEncaminhamento, String horaAcompanha, String encaminhamento, int idParecer, Date dataParecer, String parecerPsicologico, String tratamentoSaude, String qualTratamentoSaude, String ondeFazTratamento, String tratamentoAntriores, String situacaoTraumatica, String qualSituacaoTraumatica, String houveTentativaSuicidio, String porQueSuicidio, String comoFoiTentarSuicidio, String ondeTentouSuicidio, String tentativaSuicidio, String qualMedicamentoUtiliza, String porqueUsaMedicamento, String usoMedicamentos, String recebeVisitas, String familiares, String deptoPsicologico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idLanc = idLanc;
        this.idPortaPSI = idPortaPSI;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.presoAntes = presoAntes;
        this.familiaPreso = familiaPreso;
        this.quemFamiliaPreso = quemFamiliaPreso;
        this.ondePreso = ondePreso;
        this.historicoCriminal = historicoCriminal;
        this.usaDrogras = usaDrogras;
        this.alcool = alcool;
        this.cigarro = cigarro;
        this.maconha = maconha;
        this.crack = crack;
        this.cocaina = cocaina;
        this.cola = cola;
        this.outros = outros;
        this.outrasDrogas = outrasDrogas;
        this.qualIdade = qualIdade;
        this.porqueUsaDrogas = porqueUsaDrogas;
        this.drogas = drogas;
        this.tratamentoPSI = tratamentoPSI;
        this.medicamentoPSI = medicamentoPSI;
        this.qualMedicamento = qualMedicamento;
        this.acompanhaPSI = acompanhaPSI;
        this.transtornoMental = transtornoMental;
        this.departamentoEncaminha = departamentoEncaminha;
        this.dataEncaminhamento = dataEncaminhamento;
        this.horaAcompanha = horaAcompanha;
        this.encaminhamento = encaminhamento;
        this.idParecer = idParecer;
        this.dataParecer = dataParecer;
        this.parecerPsicologico = parecerPsicologico;
        this.tratamentoSaude = tratamentoSaude;
        this.qualTratamentoSaude = qualTratamentoSaude;
        this.ondeFazTratamento = ondeFazTratamento;
        this.tratamentoAntriores = tratamentoAntriores;
        this.situacaoTraumatica = situacaoTraumatica;
        this.qualSituacaoTraumatica = qualSituacaoTraumatica;
        this.houveTentativaSuicidio = houveTentativaSuicidio;
        this.porQueSuicidio = porQueSuicidio;
        this.comoFoiTentarSuicidio = comoFoiTentarSuicidio;
        this.ondeTentouSuicidio = ondeTentouSuicidio;
        this.tentativaSuicidio = tentativaSuicidio;
        this.qualMedicamentoUtiliza = qualMedicamentoUtiliza;
        this.porqueUsaMedicamento = porqueUsaMedicamento;
        this.usoMedicamentos = usoMedicamentos;
        this.recebeVisitas = recebeVisitas;
        this.familiares = familiares;
        this.deptoPsicologico = deptoPsicologico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
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
     * @return the idPortaPSI
     */
    public int getIdPortaPSI() {
        return idPortaPSI;
    }

    /**
     * @param idPortaPSI the idPortaPSI to set
     */
    public void setIdPortaPSI(int idPortaPSI) {
        this.idPortaPSI = idPortaPSI;
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
     * @return the presoAntes
     */
    public String getPresoAntes() {
        return presoAntes;
    }

    /**
     * @param presoAntes the presoAntes to set
     */
    public void setPresoAntes(String presoAntes) {
        this.presoAntes = presoAntes;
    }

    /**
     * @return the familiaPreso
     */
    public String getFamiliaPreso() {
        return familiaPreso;
    }

    /**
     * @param familiaPreso the familiaPreso to set
     */
    public void setFamiliaPreso(String familiaPreso) {
        this.familiaPreso = familiaPreso;
    }

    /**
     * @return the quemFamiliaPreso
     */
    public String getQuemFamiliaPreso() {
        return quemFamiliaPreso;
    }

    /**
     * @param quemFamiliaPreso the quemFamiliaPreso to set
     */
    public void setQuemFamiliaPreso(String quemFamiliaPreso) {
        this.quemFamiliaPreso = quemFamiliaPreso;
    }

    /**
     * @return the ondePreso
     */
    public String getOndePreso() {
        return ondePreso;
    }

    /**
     * @param ondePreso the ondePreso to set
     */
    public void setOndePreso(String ondePreso) {
        this.ondePreso = ondePreso;
    }

    /**
     * @return the historicoCriminal
     */
    public String getHistoricoCriminal() {
        return historicoCriminal;
    }

    /**
     * @param historicoCriminal the historicoCriminal to set
     */
    public void setHistoricoCriminal(String historicoCriminal) {
        this.historicoCriminal = historicoCriminal;
    }

    /**
     * @return the usaDrogras
     */
    public String getUsaDrogras() {
        return usaDrogras;
    }

    /**
     * @param usaDrogras the usaDrogras to set
     */
    public void setUsaDrogras(String usaDrogras) {
        this.usaDrogras = usaDrogras;
    }

    /**
     * @return the alcool
     */
    public int getAlcool() {
        return alcool;
    }

    /**
     * @param alcool the alcool to set
     */
    public void setAlcool(int alcool) {
        this.alcool = alcool;
    }

    /**
     * @return the cigarro
     */
    public int getCigarro() {
        return cigarro;
    }

    /**
     * @param cigarro the cigarro to set
     */
    public void setCigarro(int cigarro) {
        this.cigarro = cigarro;
    }

    /**
     * @return the maconha
     */
    public int getMaconha() {
        return maconha;
    }

    /**
     * @param maconha the maconha to set
     */
    public void setMaconha(int maconha) {
        this.maconha = maconha;
    }

    /**
     * @return the crack
     */
    public int getCrack() {
        return crack;
    }

    /**
     * @param crack the crack to set
     */
    public void setCrack(int crack) {
        this.crack = crack;
    }

    /**
     * @return the cocaina
     */
    public int getCocaina() {
        return cocaina;
    }

    /**
     * @param cocaina the cocaina to set
     */
    public void setCocaina(int cocaina) {
        this.cocaina = cocaina;
    }

    /**
     * @return the cola
     */
    public int getCola() {
        return cola;
    }

    /**
     * @param cola the cola to set
     */
    public void setCola(int cola) {
        this.cola = cola;
    }

    /**
     * @return the outros
     */
    public int getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(int outros) {
        this.outros = outros;
    }

    /**
     * @return the outrasDrogas
     */
    public String getOutrasDrogas() {
        return outrasDrogas;
    }

    /**
     * @param outrasDrogas the outrasDrogas to set
     */
    public void setOutrasDrogas(String outrasDrogas) {
        this.outrasDrogas = outrasDrogas;
    }

    /**
     * @return the qualIdade
     */
    public int getQualIdade() {
        return qualIdade;
    }

    /**
     * @param qualIdade the qualIdade to set
     */
    public void setQualIdade(int qualIdade) {
        this.qualIdade = qualIdade;
    }

    /**
     * @return the porqueUsaDrogas
     */
    public String getPorqueUsaDrogas() {
        return porqueUsaDrogas;
    }

    /**
     * @param porqueUsaDrogas the porqueUsaDrogas to set
     */
    public void setPorqueUsaDrogas(String porqueUsaDrogas) {
        this.porqueUsaDrogas = porqueUsaDrogas;
    }

    /**
     * @return the drogas
     */
    public String getDrogas() {
        return drogas;
    }

    /**
     * @param drogas the drogas to set
     */
    public void setDrogas(String drogas) {
        this.drogas = drogas;
    }

    /**
     * @return the tratamentoPSI
     */
    public String getTratamentoPSI() {
        return tratamentoPSI;
    }

    /**
     * @param tratamentoPSI the tratamentoPSI to set
     */
    public void setTratamentoPSI(String tratamentoPSI) {
        this.tratamentoPSI = tratamentoPSI;
    }

    /**
     * @return the medicamentoPSI
     */
    public String getMedicamentoPSI() {
        return medicamentoPSI;
    }

    /**
     * @param medicamentoPSI the medicamentoPSI to set
     */
    public void setMedicamentoPSI(String medicamentoPSI) {
        this.medicamentoPSI = medicamentoPSI;
    }

    /**
     * @return the qualMedicamento
     */
    public String getQualMedicamento() {
        return qualMedicamento;
    }

    /**
     * @param qualMedicamento the qualMedicamento to set
     */
    public void setQualMedicamento(String qualMedicamento) {
        this.qualMedicamento = qualMedicamento;
    }

    /**
     * @return the acompanhaPSI
     */
    public String getAcompanhaPSI() {
        return acompanhaPSI;
    }

    /**
     * @param acompanhaPSI the acompanhaPSI to set
     */
    public void setAcompanhaPSI(String acompanhaPSI) {
        this.acompanhaPSI = acompanhaPSI;
    }

    /**
     * @return the transtornoMental
     */
    public String getTranstornoMental() {
        return transtornoMental;
    }

    /**
     * @param transtornoMental the transtornoMental to set
     */
    public void setTranstornoMental(String transtornoMental) {
        this.transtornoMental = transtornoMental;
    }

    /**
     * @return the departamentoEncaminha
     */
    public String getDepartamentoEncaminha() {
        return departamentoEncaminha;
    }

    /**
     * @param departamentoEncaminha the departamentoEncaminha to set
     */
    public void setDepartamentoEncaminha(String departamentoEncaminha) {
        this.departamentoEncaminha = departamentoEncaminha;
    }

    /**
     * @return the dataEncaminhamento
     */
    public Date getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    /**
     * @param dataEncaminhamento the dataEncaminhamento to set
     */
    public void setDataEncaminhamento(Date dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    /**
     * @return the horaAcompanha
     */
    public String getHoraAcompanha() {
        return horaAcompanha;
    }

    /**
     * @param horaAcompanha the horaAcompanha to set
     */
    public void setHoraAcompanha(String horaAcompanha) {
        this.horaAcompanha = horaAcompanha;
    }

    /**
     * @return the encaminhamento
     */
    public String getEncaminhamento() {
        return encaminhamento;
    }

    /**
     * @param encaminhamento the encaminhamento to set
     */
    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    /**
     * @return the idParecer
     */
    public int getIdParecer() {
        return idParecer;
    }

    /**
     * @param idParecer the idParecer to set
     */
    public void setIdParecer(int idParecer) {
        this.idParecer = idParecer;
    }

    /**
     * @return the dataParecer
     */
    public Date getDataParecer() {
        return dataParecer;
    }

    /**
     * @param dataParecer the dataParecer to set
     */
    public void setDataParecer(Date dataParecer) {
        this.dataParecer = dataParecer;
    }

    /**
     * @return the parecerPsicologico
     */
    public String getParecerPsicologico() {
        return parecerPsicologico;
    }

    /**
     * @param parecerPsicologico the parecerPsicologico to set
     */
    public void setParecerPsicologico(String parecerPsicologico) {
        this.parecerPsicologico = parecerPsicologico;
    }

    /**
     * @return the tratamentoSaude
     */
    public String getTratamentoSaude() {
        return tratamentoSaude;
    }

    /**
     * @param tratamentoSaude the tratamentoSaude to set
     */
    public void setTratamentoSaude(String tratamentoSaude) {
        this.tratamentoSaude = tratamentoSaude;
    }

    /**
     * @return the qualTratamentoSaude
     */
    public String getQualTratamentoSaude() {
        return qualTratamentoSaude;
    }

    /**
     * @param qualTratamentoSaude the qualTratamentoSaude to set
     */
    public void setQualTratamentoSaude(String qualTratamentoSaude) {
        this.qualTratamentoSaude = qualTratamentoSaude;
    }

    /**
     * @return the ondeFazTratamento
     */
    public String getOndeFazTratamento() {
        return ondeFazTratamento;
    }

    /**
     * @param ondeFazTratamento the ondeFazTratamento to set
     */
    public void setOndeFazTratamento(String ondeFazTratamento) {
        this.ondeFazTratamento = ondeFazTratamento;
    }

    /**
     * @return the tratamentoAntriores
     */
    public String getTratamentoAntriores() {
        return tratamentoAntriores;
    }

    /**
     * @param tratamentoAntriores the tratamentoAntriores to set
     */
    public void setTratamentoAntriores(String tratamentoAntriores) {
        this.tratamentoAntriores = tratamentoAntriores;
    }

    /**
     * @return the situacaoTraumatica
     */
    public String getSituacaoTraumatica() {
        return situacaoTraumatica;
    }

    /**
     * @param situacaoTraumatica the situacaoTraumatica to set
     */
    public void setSituacaoTraumatica(String situacaoTraumatica) {
        this.situacaoTraumatica = situacaoTraumatica;
    }

    /**
     * @return the qualSituacaoTraumatica
     */
    public String getQualSituacaoTraumatica() {
        return qualSituacaoTraumatica;
    }

    /**
     * @param qualSituacaoTraumatica the qualSituacaoTraumatica to set
     */
    public void setQualSituacaoTraumatica(String qualSituacaoTraumatica) {
        this.qualSituacaoTraumatica = qualSituacaoTraumatica;
    }

    /**
     * @return the houveTentativaSuicidio
     */
    public String getHouveTentativaSuicidio() {
        return houveTentativaSuicidio;
    }

    /**
     * @param houveTentativaSuicidio the houveTentativaSuicidio to set
     */
    public void setHouveTentativaSuicidio(String houveTentativaSuicidio) {
        this.houveTentativaSuicidio = houveTentativaSuicidio;
    }

    /**
     * @return the porQueSuicidio
     */
    public String getPorQueSuicidio() {
        return porQueSuicidio;
    }

    /**
     * @param porQueSuicidio the porQueSuicidio to set
     */
    public void setPorQueSuicidio(String porQueSuicidio) {
        this.porQueSuicidio = porQueSuicidio;
    }

    /**
     * @return the comoFoiTentarSuicidio
     */
    public String getComoFoiTentarSuicidio() {
        return comoFoiTentarSuicidio;
    }

    /**
     * @param comoFoiTentarSuicidio the comoFoiTentarSuicidio to set
     */
    public void setComoFoiTentarSuicidio(String comoFoiTentarSuicidio) {
        this.comoFoiTentarSuicidio = comoFoiTentarSuicidio;
    }

    /**
     * @return the ondeTentouSuicidio
     */
    public String getOndeTentouSuicidio() {
        return ondeTentouSuicidio;
    }

    /**
     * @param ondeTentouSuicidio the ondeTentouSuicidio to set
     */
    public void setOndeTentouSuicidio(String ondeTentouSuicidio) {
        this.ondeTentouSuicidio = ondeTentouSuicidio;
    }

    /**
     * @return the tentativaSuicidio
     */
    public String getTentativaSuicidio() {
        return tentativaSuicidio;
    }

    /**
     * @param tentativaSuicidio the tentativaSuicidio to set
     */
    public void setTentativaSuicidio(String tentativaSuicidio) {
        this.tentativaSuicidio = tentativaSuicidio;
    }

    /**
     * @return the qualMedicamentoUtiliza
     */
    public String getQualMedicamentoUtiliza() {
        return qualMedicamentoUtiliza;
    }

    /**
     * @param qualMedicamentoUtiliza the qualMedicamentoUtiliza to set
     */
    public void setQualMedicamentoUtiliza(String qualMedicamentoUtiliza) {
        this.qualMedicamentoUtiliza = qualMedicamentoUtiliza;
    }

    /**
     * @return the porqueUsaMedicamento
     */
    public String getPorqueUsaMedicamento() {
        return porqueUsaMedicamento;
    }

    /**
     * @param porqueUsaMedicamento the porqueUsaMedicamento to set
     */
    public void setPorqueUsaMedicamento(String porqueUsaMedicamento) {
        this.porqueUsaMedicamento = porqueUsaMedicamento;
    }

    /**
     * @return the usoMedicamentos
     */
    public String getUsoMedicamentos() {
        return usoMedicamentos;
    }

    /**
     * @param usoMedicamentos the usoMedicamentos to set
     */
    public void setUsoMedicamentos(String usoMedicamentos) {
        this.usoMedicamentos = usoMedicamentos;
    }

    /**
     * @return the recebeVisitas
     */
    public String getRecebeVisitas() {
        return recebeVisitas;
    }

    /**
     * @param recebeVisitas the recebeVisitas to set
     */
    public void setRecebeVisitas(String recebeVisitas) {
        this.recebeVisitas = recebeVisitas;
    }

    /**
     * @return the familiares
     */
    public String getFamiliares() {
        return familiares;
    }

    /**
     * @param familiares the familiares to set
     */
    public void setFamiliares(String familiares) {
        this.familiares = familiares;
    }

    /**
     * @return the deptoPsicologico
     */
    public String getDeptoPsicologico() {
        return deptoPsicologico;
    }

    /**
     * @param deptoPsicologico the deptoPsicologico to set
     */
    public void setDeptoPsicologico(String deptoPsicologico) {
        this.deptoPsicologico = deptoPsicologico;
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
