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
public class AtendimentoOdontologico {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private String tipoAtendimento;
    private String fumante;
    private String gestante;
    private int tempoGestacao;
    private String tratamentoMedico;
    private String medicacao;
    private String alegria;
    private String queixaPrincipal;
    private String afirmacao1;
    private String afirmacao2;
    private String afirmacao3;
    private String observacao;
    private String planoTratamento;
    private String hepatite;
    private String hiv;
    private String asma;
    private String febre;
    private String diabetes;
    private String epilepsia;
    private String cicatrizacao;
    private String disturbios;
    private String endocardite;
    private String epatico;
    private String renal;
    private String cardiaco;
    private String tensao;
    private String cirurgia;
    private String internacao;
    private String sifilis;
    private String tuberculose;
    private String outras;
    private String qualOutraDoenca;
    private String textoDoenca;
    private String deptoOdonto;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private String tipoProcedimento;
    private int numeroDente;
    private Date dataOrtograma;
    private String facesDente;
    private int vermelho;
    private int verde;
    private int azul;

    public AtendimentoOdontologico(int idLanc, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, String tipoAtendimento, String fumante, String gestante, int tempoGestacao, String tratamentoMedico, String medicacao, String alegria, String queixaPrincipal, String afirmacao1, String afirmacao2, String afirmacao3, String observacao, String planoTratamento, String hepatite, String hiv, String asma, String febre, String diabetes, String epilepsia, String cicatrizacao, String disturbios, String endocardite, String epatico, String renal, String cardiaco, String tensao, String cirurgia, String internacao, String sifilis, String tuberculose, String outras, String qualOutraDoenca, String textoDoenca, String deptoOdonto, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, String tipoProcedimento, int numeroDente, Date dataOrtograma, String facesDente, int vermelho, int verde, int azul) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.tipoAtendimento = tipoAtendimento;
        this.fumante = fumante;
        this.gestante = gestante;
        this.tempoGestacao = tempoGestacao;
        this.tratamentoMedico = tratamentoMedico;
        this.medicacao = medicacao;
        this.alegria = alegria;
        this.queixaPrincipal = queixaPrincipal;
        this.afirmacao1 = afirmacao1;
        this.afirmacao2 = afirmacao2;
        this.afirmacao3 = afirmacao3;
        this.observacao = observacao;
        this.planoTratamento = planoTratamento;
        this.hepatite = hepatite;
        this.hiv = hiv;
        this.asma = asma;
        this.febre = febre;
        this.diabetes = diabetes;
        this.epilepsia = epilepsia;
        this.cicatrizacao = cicatrizacao;
        this.disturbios = disturbios;
        this.endocardite = endocardite;
        this.epatico = epatico;
        this.renal = renal;
        this.cardiaco = cardiaco;
        this.tensao = tensao;
        this.cirurgia = cirurgia;
        this.internacao = internacao;
        this.sifilis = sifilis;
        this.tuberculose = tuberculose;
        this.outras = outras;
        this.qualOutraDoenca = qualOutraDoenca;
        this.textoDoenca = textoDoenca;
        this.deptoOdonto = deptoOdonto;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.tipoProcedimento = tipoProcedimento;
        this.numeroDente = numeroDente;
        this.dataOrtograma = dataOrtograma;
        this.facesDente = facesDente;
        this.vermelho = vermelho;
        this.verde = verde;
        this.azul = azul;
    }

    public AtendimentoOdontologico() {
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
     * @return the tipoAtendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * @param tipoAtendimento the tipoAtendimento to set
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * @return the fumante
     */
    public String getFumante() {
        return fumante;
    }

    /**
     * @param fumante the fumante to set
     */
    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    /**
     * @return the gestante
     */
    public String getGestante() {
        return gestante;
    }

    /**
     * @param gestante the gestante to set
     */
    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    /**
     * @return the tempoGestacao
     */
    public int getTempoGestacao() {
        return tempoGestacao;
    }

    /**
     * @param tempoGestacao the tempoGestacao to set
     */
    public void setTempoGestacao(int tempoGestacao) {
        this.tempoGestacao = tempoGestacao;
    }

    /**
     * @return the tratamentoMedico
     */
    public String getTratamentoMedico() {
        return tratamentoMedico;
    }

    /**
     * @param tratamentoMedico the tratamentoMedico to set
     */
    public void setTratamentoMedico(String tratamentoMedico) {
        this.tratamentoMedico = tratamentoMedico;
    }

    /**
     * @return the medicacao
     */
    public String getMedicacao() {
        return medicacao;
    }

    /**
     * @param medicacao the medicacao to set
     */
    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    /**
     * @return the alegria
     */
    public String getAlegria() {
        return alegria;
    }

    /**
     * @param alegria the alegria to set
     */
    public void setAlegria(String alegria) {
        this.alegria = alegria;
    }

    /**
     * @return the queixaPrincipal
     */
    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    /**
     * @param queixaPrincipal the queixaPrincipal to set
     */
    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    /**
     * @return the afirmacao1
     */
    public String getAfirmacao1() {
        return afirmacao1;
    }

    /**
     * @param afirmacao1 the afirmacao1 to set
     */
    public void setAfirmacao1(String afirmacao1) {
        this.afirmacao1 = afirmacao1;
    }

    /**
     * @return the afirmacao2
     */
    public String getAfirmacao2() {
        return afirmacao2;
    }

    /**
     * @param afirmacao2 the afirmacao2 to set
     */
    public void setAfirmacao2(String afirmacao2) {
        this.afirmacao2 = afirmacao2;
    }

    /**
     * @return the afirmacao3
     */
    public String getAfirmacao3() {
        return afirmacao3;
    }

    /**
     * @param afirmacao3 the afirmacao3 to set
     */
    public void setAfirmacao3(String afirmacao3) {
        this.afirmacao3 = afirmacao3;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the planoTratamento
     */
    public String getPlanoTratamento() {
        return planoTratamento;
    }

    /**
     * @param planoTratamento the planoTratamento to set
     */
    public void setPlanoTratamento(String planoTratamento) {
        this.planoTratamento = planoTratamento;
    }

    /**
     * @return the hepatite
     */
    public String getHepatite() {
        return hepatite;
    }

    /**
     * @param hepatite the hepatite to set
     */
    public void setHepatite(String hepatite) {
        this.hepatite = hepatite;
    }

    /**
     * @return the hiv
     */
    public String getHiv() {
        return hiv;
    }

    /**
     * @param hiv the hiv to set
     */
    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    /**
     * @return the asma
     */
    public String getAsma() {
        return asma;
    }

    /**
     * @param asma the asma to set
     */
    public void setAsma(String asma) {
        this.asma = asma;
    }

    /**
     * @return the febre
     */
    public String getFebre() {
        return febre;
    }

    /**
     * @param febre the febre to set
     */
    public void setFebre(String febre) {
        this.febre = febre;
    }

    /**
     * @return the diabetes
     */
    public String getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the epilepsia
     */
    public String getEpilepsia() {
        return epilepsia;
    }

    /**
     * @param epilepsia the epilepsia to set
     */
    public void setEpilepsia(String epilepsia) {
        this.epilepsia = epilepsia;
    }

    /**
     * @return the cicatrizacao
     */
    public String getCicatrizacao() {
        return cicatrizacao;
    }

    /**
     * @param cicatrizacao the cicatrizacao to set
     */
    public void setCicatrizacao(String cicatrizacao) {
        this.cicatrizacao = cicatrizacao;
    }

    /**
     * @return the disturbios
     */
    public String getDisturbios() {
        return disturbios;
    }

    /**
     * @param disturbios the disturbios to set
     */
    public void setDisturbios(String disturbios) {
        this.disturbios = disturbios;
    }

    /**
     * @return the endocardite
     */
    public String getEndocardite() {
        return endocardite;
    }

    /**
     * @param endocardite the endocardite to set
     */
    public void setEndocardite(String endocardite) {
        this.endocardite = endocardite;
    }

    /**
     * @return the epatico
     */
    public String getEpatico() {
        return epatico;
    }

    /**
     * @param epatico the epatico to set
     */
    public void setEpatico(String epatico) {
        this.epatico = epatico;
    }

    /**
     * @return the renal
     */
    public String getRenal() {
        return renal;
    }

    /**
     * @param renal the renal to set
     */
    public void setRenal(String renal) {
        this.renal = renal;
    }

    /**
     * @return the cardiaco
     */
    public String getCardiaco() {
        return cardiaco;
    }

    /**
     * @param cardiaco the cardiaco to set
     */
    public void setCardiaco(String cardiaco) {
        this.cardiaco = cardiaco;
    }

    /**
     * @return the tensao
     */
    public String getTensao() {
        return tensao;
    }

    /**
     * @param tensao the tensao to set
     */
    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    /**
     * @return the cirurgia
     */
    public String getCirurgia() {
        return cirurgia;
    }

    /**
     * @param cirurgia the cirurgia to set
     */
    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    /**
     * @return the internacao
     */
    public String getInternacao() {
        return internacao;
    }

    /**
     * @param internacao the internacao to set
     */
    public void setInternacao(String internacao) {
        this.internacao = internacao;
    }

    /**
     * @return the sifilis
     */
    public String getSifilis() {
        return sifilis;
    }

    /**
     * @param sifilis the sifilis to set
     */
    public void setSifilis(String sifilis) {
        this.sifilis = sifilis;
    }

    /**
     * @return the tuberculose
     */
    public String getTuberculose() {
        return tuberculose;
    }

    /**
     * @param tuberculose the tuberculose to set
     */
    public void setTuberculose(String tuberculose) {
        this.tuberculose = tuberculose;
    }

    /**
     * @return the outras
     */
    public String getOutras() {
        return outras;
    }

    /**
     * @param outras the outras to set
     */
    public void setOutras(String outras) {
        this.outras = outras;
    }

    /**
     * @return the qualOutraDoenca
     */
    public String getQualOutraDoenca() {
        return qualOutraDoenca;
    }

    /**
     * @param qualOutraDoenca the qualOutraDoenca to set
     */
    public void setQualOutraDoenca(String qualOutraDoenca) {
        this.qualOutraDoenca = qualOutraDoenca;
    }

    /**
     * @return the textoDoenca
     */
    public String getTextoDoenca() {
        return textoDoenca;
    }

    /**
     * @param textoDoenca the textoDoenca to set
     */
    public void setTextoDoenca(String textoDoenca) {
        this.textoDoenca = textoDoenca;
    }

    /**
     * @return the deptoOdonto
     */
    public String getDeptoOdonto() {
        return deptoOdonto;
    }

    /**
     * @param deptoOdonto the deptoOdonto to set
     */
    public void setDeptoOdonto(String deptoOdonto) {
        this.deptoOdonto = deptoOdonto;
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

    /**
     * @return the tipoProcedimento
     */
    public String getTipoProcedimento() {
        return tipoProcedimento;
    }

    /**
     * @param tipoProcedimento the tipoProcedimento to set
     */
    public void setTipoProcedimento(String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    /**
     * @return the numeroDente
     */
    public int getNumeroDente() {
        return numeroDente;
    }

    /**
     * @param numeroDente the numeroDente to set
     */
    public void setNumeroDente(int numeroDente) {
        this.numeroDente = numeroDente;
    }

    /**
     * @return the dataOrtograma
     */
    public Date getDataOrtograma() {
        return dataOrtograma;
    }

    /**
     * @param dataOrtograma the dataOrtograma to set
     */
    public void setDataOrtograma(Date dataOrtograma) {
        this.dataOrtograma = dataOrtograma;
    }

    /**
     * @return the facesDente
     */
    public String getFacesDente() {
        return facesDente;
    }

    /**
     * @param facesDente the facesDente to set
     */
    public void setFacesDente(String facesDente) {
        this.facesDente = facesDente;
    }

    /**
     * @return the vermelho
     */
    public int getVermelho() {
        return vermelho;
    }

    /**
     * @param vermelho the vermelho to set
     */
    public void setVermelho(int vermelho) {
        this.vermelho = vermelho;
    }

    /**
     * @return the verde
     */
    public int getVerde() {
        return verde;
    }

    /**
     * @param verde the verde to set
     */
    public void setVerde(int verde) {
        this.verde = verde;
    }

    /**
     * @return the azul
     */
    public int getAzul() {
        return azul;
    }

    /**
     * @param azul the azul to set
     */
    public void setAzul(int azul) {
        this.azul = azul;
    }
}
