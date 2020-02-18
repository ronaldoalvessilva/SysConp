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
public class AdmissaoMedica {

    private int idLanc;
    private int idAdmAd;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private String ar;
    private String acv;
    private String agu;
    private String cabPesc;
    private String ext;
    private String abd;
    private String comboBoxAR;
    private String comboBoxACV;
    private String comboBoxAGU;
    private String comboBoxCAB;
    private String comboBoxEXT;
    private String comboBoxABD;
    private String tipoSanguineo;
    private String fatorRH;
    private String alergia;
    private String quaisAlergias;
    private String sexualidade;
    private String numeroParceiros;
    private String usoPreservativos;   
    private String drogasInjetavel;
    private String qualTipoDrograInjet;
    private String diagnostico;
    private String cirurgiasPrevisas;
    private String tratamentoCurso;
    private String qualDrogas;
    private String qualEtilismo;
    private String quantoTempoTabagismo;
    private String drogas;
    private String etilismo;
    private String tabagismo;
    private String vacinas;
    private String atualizadaIgnorada;
    private String usaMedicamentos;
    private String qualMedicacaoUsa;
    private String outrasAlergias;
    private String quaisOutrasAlergias;
    private String deptoMedico;  
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private String diagnosticooInicial;   
    private int tipoDiagnostico;
    private String admEvo;

    public AdmissaoMedica() {
    }

    public AdmissaoMedica(int idLanc, int idAdmAd, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, String ar, String acv, String agu, String cabPesc, String ext, String abd, String comboBoxAR, String comboBoxACV, String comboBoxAGU, String comboBoxCAB, String comboBoxEXT, String comboBoxABD, String tipoSanguineo, String fatorRH, String alergia, String quaisAlergias, String sexualidade, String numeroParceiros, String usoPreservativos, String drogasInjetavel, String qualTipoDrograInjet, String diagnostico, String cirurgiasPrevisas, String tratamentoCurso, String qualDrogas, String qualEtilismo, String quantoTempoTabagismo, String drogas, String etilismo, String tabagismo, String vacinas, String atualizadaIgnorada, String usaMedicamentos, String qualMedicacaoUsa, String outrasAlergias, String quaisOutrasAlergias, String deptoMedico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String diagnosticooInicial, int tipoDiagnostico, String admEvo) {
        this.idLanc = idLanc;
        this.idAdmAd = idAdmAd;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.ar = ar;
        this.acv = acv;
        this.agu = agu;
        this.cabPesc = cabPesc;
        this.ext = ext;
        this.abd = abd;
        this.comboBoxAR = comboBoxAR;
        this.comboBoxACV = comboBoxACV;
        this.comboBoxAGU = comboBoxAGU;
        this.comboBoxCAB = comboBoxCAB;
        this.comboBoxEXT = comboBoxEXT;
        this.comboBoxABD = comboBoxABD;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRH = fatorRH;
        this.alergia = alergia;
        this.quaisAlergias = quaisAlergias;
        this.sexualidade = sexualidade;
        this.numeroParceiros = numeroParceiros;
        this.usoPreservativos = usoPreservativos;
        this.drogasInjetavel = drogasInjetavel;
        this.qualTipoDrograInjet = qualTipoDrograInjet;
        this.diagnostico = diagnostico;
        this.cirurgiasPrevisas = cirurgiasPrevisas;
        this.tratamentoCurso = tratamentoCurso;
        this.qualDrogas = qualDrogas;
        this.qualEtilismo = qualEtilismo;
        this.quantoTempoTabagismo = quantoTempoTabagismo;
        this.drogas = drogas;
        this.etilismo = etilismo;
        this.tabagismo = tabagismo;
        this.vacinas = vacinas;
        this.atualizadaIgnorada = atualizadaIgnorada;
        this.usaMedicamentos = usaMedicamentos;
        this.qualMedicacaoUsa = qualMedicacaoUsa;
        this.outrasAlergias = outrasAlergias;
        this.quaisOutrasAlergias = quaisOutrasAlergias;
        this.deptoMedico = deptoMedico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.diagnosticooInicial = diagnosticooInicial;
        this.tipoDiagnostico = tipoDiagnostico;
        this.admEvo = admEvo;
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
     * @return the idAdmAd
     */
    public int getIdAdmAd() {
        return idAdmAd;
    }

    /**
     * @param idAdmAd the idAdmAd to set
     */
    public void setIdAdmAd(int idAdmAd) {
        this.idAdmAd = idAdmAd;
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
     * @return the ar
     */
    public String getAr() {
        return ar;
    }

    /**
     * @param ar the ar to set
     */
    public void setAr(String ar) {
        this.ar = ar;
    }

    /**
     * @return the acv
     */
    public String getAcv() {
        return acv;
    }

    /**
     * @param acv the acv to set
     */
    public void setAcv(String acv) {
        this.acv = acv;
    }

    /**
     * @return the agu
     */
    public String getAgu() {
        return agu;
    }

    /**
     * @param agu the agu to set
     */
    public void setAgu(String agu) {
        this.agu = agu;
    }

    /**
     * @return the cabPesc
     */
    public String getCabPesc() {
        return cabPesc;
    }

    /**
     * @param cabPesc the cabPesc to set
     */
    public void setCabPesc(String cabPesc) {
        this.cabPesc = cabPesc;
    }

    /**
     * @return the ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext the ext to set
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return the abd
     */
    public String getAbd() {
        return abd;
    }

    /**
     * @param abd the abd to set
     */
    public void setAbd(String abd) {
        this.abd = abd;
    }

    /**
     * @return the comboBoxAR
     */
    public String getComboBoxAR() {
        return comboBoxAR;
    }

    /**
     * @param comboBoxAR the comboBoxAR to set
     */
    public void setComboBoxAR(String comboBoxAR) {
        this.comboBoxAR = comboBoxAR;
    }

    /**
     * @return the comboBoxACV
     */
    public String getComboBoxACV() {
        return comboBoxACV;
    }

    /**
     * @param comboBoxACV the comboBoxACV to set
     */
    public void setComboBoxACV(String comboBoxACV) {
        this.comboBoxACV = comboBoxACV;
    }

    /**
     * @return the comboBoxAGU
     */
    public String getComboBoxAGU() {
        return comboBoxAGU;
    }

    /**
     * @param comboBoxAGU the comboBoxAGU to set
     */
    public void setComboBoxAGU(String comboBoxAGU) {
        this.comboBoxAGU = comboBoxAGU;
    }

    /**
     * @return the comboBoxCAB
     */
    public String getComboBoxCAB() {
        return comboBoxCAB;
    }

    /**
     * @param comboBoxCAB the comboBoxCAB to set
     */
    public void setComboBoxCAB(String comboBoxCAB) {
        this.comboBoxCAB = comboBoxCAB;
    }

    /**
     * @return the comboBoxEXT
     */
    public String getComboBoxEXT() {
        return comboBoxEXT;
    }

    /**
     * @param comboBoxEXT the comboBoxEXT to set
     */
    public void setComboBoxEXT(String comboBoxEXT) {
        this.comboBoxEXT = comboBoxEXT;
    }

    /**
     * @return the comboBoxABD
     */
    public String getComboBoxABD() {
        return comboBoxABD;
    }

    /**
     * @param comboBoxABD the comboBoxABD to set
     */
    public void setComboBoxABD(String comboBoxABD) {
        this.comboBoxABD = comboBoxABD;
    }

    /**
     * @return the tipoSanguineo
     */
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    /**
     * @param tipoSanguineo the tipoSanguineo to set
     */
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    /**
     * @return the fatorRH
     */
    public String getFatorRH() {
        return fatorRH;
    }

    /**
     * @param fatorRH the fatorRH to set
     */
    public void setFatorRH(String fatorRH) {
        this.fatorRH = fatorRH;
    }

    /**
     * @return the alergia
     */
    public String getAlergia() {
        return alergia;
    }

    /**
     * @param alergia the alergia to set
     */
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    /**
     * @return the quaisAlergias
     */
    public String getQuaisAlergias() {
        return quaisAlergias;
    }

    /**
     * @param quaisAlergias the quaisAlergias to set
     */
    public void setQuaisAlergias(String quaisAlergias) {
        this.quaisAlergias = quaisAlergias;
    }

    /**
     * @return the sexualidade
     */
    public String getSexualidade() {
        return sexualidade;
    }

    /**
     * @param sexualidade the sexualidade to set
     */
    public void setSexualidade(String sexualidade) {
        this.sexualidade = sexualidade;
    }

    /**
     * @return the numeroParceiros
     */
    public String getNumeroParceiros() {
        return numeroParceiros;
    }

    /**
     * @param numeroParceiros the numeroParceiros to set
     */
    public void setNumeroParceiros(String numeroParceiros) {
        this.numeroParceiros = numeroParceiros;
    }

    /**
     * @return the usoPreservativos
     */
    public String getUsoPreservativos() {
        return usoPreservativos;
    }

    /**
     * @param usoPreservativos the usoPreservativos to set
     */
    public void setUsoPreservativos(String usoPreservativos) {
        this.usoPreservativos = usoPreservativos;
    }

    /**
     * @return the drogasInjetavel
     */
    public String getDrogasInjetavel() {
        return drogasInjetavel;
    }

    /**
     * @param drogasInjetavel the drogasInjetavel to set
     */
    public void setDrogasInjetavel(String drogasInjetavel) {
        this.drogasInjetavel = drogasInjetavel;
    }

    /**
     * @return the qualTipoDrograInjet
     */
    public String getQualTipoDrograInjet() {
        return qualTipoDrograInjet;
    }

    /**
     * @param qualTipoDrograInjet the qualTipoDrograInjet to set
     */
    public void setQualTipoDrograInjet(String qualTipoDrograInjet) {
        this.qualTipoDrograInjet = qualTipoDrograInjet;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the cirurgiasPrevisas
     */
    public String getCirurgiasPrevisas() {
        return cirurgiasPrevisas;
    }

    /**
     * @param cirurgiasPrevisas the cirurgiasPrevisas to set
     */
    public void setCirurgiasPrevisas(String cirurgiasPrevisas) {
        this.cirurgiasPrevisas = cirurgiasPrevisas;
    }

    /**
     * @return the tratamentoCurso
     */
    public String getTratamentoCurso() {
        return tratamentoCurso;
    }

    /**
     * @param tratamentoCurso the tratamentoCurso to set
     */
    public void setTratamentoCurso(String tratamentoCurso) {
        this.tratamentoCurso = tratamentoCurso;
    }

    /**
     * @return the qualDrogas
     */
    public String getQualDrogas() {
        return qualDrogas;
    }

    /**
     * @param qualDrogas the qualDrogas to set
     */
    public void setQualDrogas(String qualDrogas) {
        this.qualDrogas = qualDrogas;
    }

    /**
     * @return the qualEtilismo
     */
    public String getQualEtilismo() {
        return qualEtilismo;
    }

    /**
     * @param qualEtilismo the qualEtilismo to set
     */
    public void setQualEtilismo(String qualEtilismo) {
        this.qualEtilismo = qualEtilismo;
    }

    /**
     * @return the quantoTempoTabagismo
     */
    public String getQuantoTempoTabagismo() {
        return quantoTempoTabagismo;
    }

    /**
     * @param quantoTempoTabagismo the quantoTempoTabagismo to set
     */
    public void setQuantoTempoTabagismo(String quantoTempoTabagismo) {
        this.quantoTempoTabagismo = quantoTempoTabagismo;
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
     * @return the etilismo
     */
    public String getEtilismo() {
        return etilismo;
    }

    /**
     * @param etilismo the etilismo to set
     */
    public void setEtilismo(String etilismo) {
        this.etilismo = etilismo;
    }

    /**
     * @return the tabagismo
     */
    public String getTabagismo() {
        return tabagismo;
    }

    /**
     * @param tabagismo the tabagismo to set
     */
    public void setTabagismo(String tabagismo) {
        this.tabagismo = tabagismo;
    }

    /**
     * @return the vacinas
     */
    public String getVacinas() {
        return vacinas;
    }

    /**
     * @param vacinas the vacinas to set
     */
    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }

    /**
     * @return the atualizadaIgnorada
     */
    public String getAtualizadaIgnorada() {
        return atualizadaIgnorada;
    }

    /**
     * @param atualizadaIgnorada the atualizadaIgnorada to set
     */
    public void setAtualizadaIgnorada(String atualizadaIgnorada) {
        this.atualizadaIgnorada = atualizadaIgnorada;
    }

    /**
     * @return the usaMedicamentos
     */
    public String getUsaMedicamentos() {
        return usaMedicamentos;
    }

    /**
     * @param usaMedicamentos the usaMedicamentos to set
     */
    public void setUsaMedicamentos(String usaMedicamentos) {
        this.usaMedicamentos = usaMedicamentos;
    }

    /**
     * @return the qualMedicacaoUsa
     */
    public String getQualMedicacaoUsa() {
        return qualMedicacaoUsa;
    }

    /**
     * @param qualMedicacaoUsa the qualMedicacaoUsa to set
     */
    public void setQualMedicacaoUsa(String qualMedicacaoUsa) {
        this.qualMedicacaoUsa = qualMedicacaoUsa;
    }

    /**
     * @return the outrasAlergias
     */
    public String getOutrasAlergias() {
        return outrasAlergias;
    }

    /**
     * @param outrasAlergias the outrasAlergias to set
     */
    public void setOutrasAlergias(String outrasAlergias) {
        this.outrasAlergias = outrasAlergias;
    }

    /**
     * @return the quaisOutrasAlergias
     */
    public String getQuaisOutrasAlergias() {
        return quaisOutrasAlergias;
    }

    /**
     * @param quaisOutrasAlergias the quaisOutrasAlergias to set
     */
    public void setQuaisOutrasAlergias(String quaisOutrasAlergias) {
        this.quaisOutrasAlergias = quaisOutrasAlergias;
    }

    /**
     * @return the deptoMedico
     */
    public String getDeptoMedico() {
        return deptoMedico;
    }

    /**
     * @param deptoMedico the deptoMedico to set
     */
    public void setDeptoMedico(String deptoMedico) {
        this.deptoMedico = deptoMedico;
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
     * @return the diagnosticooInicial
     */
    public String getDiagnosticooInicial() {
        return diagnosticooInicial;
    }

    /**
     * @param diagnosticooInicial the diagnosticooInicial to set
     */
    public void setDiagnosticooInicial(String diagnosticooInicial) {
        this.diagnosticooInicial = diagnosticooInicial;
    }

    /**
     * @return the tipoDiagnostico
     */
    public int getTipoDiagnostico() {
        return tipoDiagnostico;
    }

    /**
     * @param tipoDiagnostico the tipoDiagnostico to set
     */
    public void setTipoDiagnostico(int tipoDiagnostico) {
        this.tipoDiagnostico = tipoDiagnostico;
    }

    /**
     * @return the admEvo
     */
    public String getAdmEvo() {
        return admEvo;
    }

    /**
     * @param admEvo the admEvo to set
     */
    public void setAdmEvo(String admEvo) {
        this.admEvo = admEvo;
    }
}
