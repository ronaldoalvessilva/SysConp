/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class IndicadoresAcompanhamento {

    private int IdIndAco;
    private String statusPerfil;
    private Date dataPerfil;
    private int idInternoCrc;
    private String nomeInternoPerfil;
    private String opcaoSexual;
    private int anoNascimento;
    private int anoReferencia;
    private String mesReferencia;
    private String observacaoPerfil;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    // ENFERMARIA
    private int idEnf;
    private Date dataReg;
    private String diabetes;
    private String diabControl;
    private int qtdDiabetes;
    private String hipertensao;
    private String hiperControl;
    private int qtdHipertensao;
    private String escabiose;
    private String escabioseCura;
    private int qtdEscabiose;
    private String hanseniase;
    private String hanseniaseCura;
    private int qtdHanseniase;
    private String sifilis;
    private String sifilisCura;
    private int qtdSifilis;
    private String tuberculose;
    private String tuberculoseCura;
    private int qtdTuberculose;
    private String hiv;
    private String hivControlada;
    private int qtdHib;
    private String hepatiteB;
    private String hepatiBCont;
    private int qtdHepatiteB;
    private String hepatiteC;
    private String hepatiCcont;
    private int qtdHepatiteC;
    private String dst;
    private String curaDst;
    private int qdtDst;
    private String vDLR;
    private String curaVdlr;
    private int qtdVdlr;
    private String vacina;
    private String vacinaCura;
    private int qtdVacina;
    private String observacaoEnf;
    // PEDAGOGIA
    private int idPedago;
    private Date dataPeda;
    private String iCAA;
    private int qtdICAA;
    private String iC1;
    private int qtdIC1;
    private String iC2P;
    private int qtdIC2P;
    private String iAAU;
    private int qtdIAAU;
    private String iC3;
    private int qtdIC3;
    private String iREL;
    private int qtdIREL;
    private String iAC;
    private int qtdIAC;
    private String iCU1;
    private int qtdICU1;
    private String iC2;
    private int qtdIC2;
    private String iCA;
    private int qtdICA;
    private String observacaoPeda;
    // JURIDICO/CRC
    private int idJurCrc;
    private Date dataJurCrc;
    private String processos;
    private int qtdProgresso;
    private String documentacao;
    private int qtdDocumentacao;
    private String progressao;
    private int qtdProgressao;
    private String livramento;
    private int qtdLivramento;
    private String observacaoCrc;
    // TERAPIA OCUPACIONAL
    private int idTo;
    private Date dataTo;
    private String programa;
    private int qtdprograma;
    private String curso;
    private int qtdCurso;
    private String profissional;
    private int qtdProfissional;
    private String observacaoTo;
    // PSICOLOGIA
    private int idPsi;
    private Date dataPsi;
    private String tratamento;
    private int qtdTratamento;
    private String acompanha;
    private int qtdAcompanha;
    private String recuparacao;
    private int qtdRecuparacao;
    private String observacaoPsi;
    // SERVIÇO SOCIAL
    private int idSS;
    private Date dataSS;
    private String acompanhaSS;
    private int qtdAcompanhaSS;
    private String observacao;   

    public IndicadoresAcompanhamento() {
    }

    public IndicadoresAcompanhamento(int IdIndAco, String statusPerfil, Date dataPerfil, int idInternoCrc, String nomeInternoPerfil, String opcaoSexual, int anoNascimento, int anoReferencia, String mesReferencia, String observacaoPerfil, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, int idEnf, Date dataReg, String diabetes, String diabControl, int qtdDiabetes, String hipertensao, String hiperControl, int qtdHipertensao, String escabiose, String escabioseCura, int qtdEscabiose, String hanseniase, String hanseniaseCura, int qtdHanseniase, String sifilis, String sifilisCura, int qtdSifilis, String tuberculose, String tuberculoseCura, int qtdTuberculose, String hiv, String hivControlada, int qtdHib, String hepatiteB, String hepatiBCont, int qtdHepatiteB, String hepatiteC, String hepatiCcont, int qtdHepatiteC, String dst, String curaDst, int qdtDst, String vDLR, String curaVdlr, int qtdVdlr, String vacina, String vacinaCura, int qtdVacina, String observacaoEnf, int idPedago, Date dataPeda, String iCAA, int qtdICAA, String iC1, int qtdIC1, String iC2P, int qtdIC2P, String iAAU, int qtdIAAU, String iC3, int qtdIC3, String iREL, int qtdIREL, String iAC, int qtdIAC, String iCU1, int qtdICU1, String iC2, int qtdIC2, String iCA, int qtdICA, String observacaoPeda, int idJurCrc, Date dataJurCrc, String processos, int qtdProgresso, String documentacao, int qtdDocumentacao, String progressao, int qtdProgressao, String livramento, int qtdLivramento, String observacaoCrc, int idTo, Date dataTo, String programa, int qtdprograma, String curso, int qtdCurso, String profissional, int qtdProfissional, String observacaoTo, int idPsi, Date dataPsi, String tratamento, int qtdTratamento, String acompanha, int qtdAcompanha, String recuparacao, int qtdRecuparacao, String observacaoPsi, int idSS, Date dataSS, String acompanhaSS, int qtdAcompanhaSS, String observacao) {
        this.IdIndAco = IdIndAco;
        this.statusPerfil = statusPerfil;
        this.dataPerfil = dataPerfil;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoPerfil = nomeInternoPerfil;
        this.opcaoSexual = opcaoSexual;
        this.anoNascimento = anoNascimento;
        this.anoReferencia = anoReferencia;
        this.mesReferencia = mesReferencia;
        this.observacaoPerfil = observacaoPerfil;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.idEnf = idEnf;
        this.dataReg = dataReg;
        this.diabetes = diabetes;
        this.diabControl = diabControl;
        this.qtdDiabetes = qtdDiabetes;
        this.hipertensao = hipertensao;
        this.hiperControl = hiperControl;
        this.qtdHipertensao = qtdHipertensao;
        this.escabiose = escabiose;
        this.escabioseCura = escabioseCura;
        this.qtdEscabiose = qtdEscabiose;
        this.hanseniase = hanseniase;
        this.hanseniaseCura = hanseniaseCura;
        this.qtdHanseniase = qtdHanseniase;
        this.sifilis = sifilis;
        this.sifilisCura = sifilisCura;
        this.qtdSifilis = qtdSifilis;
        this.tuberculose = tuberculose;
        this.tuberculoseCura = tuberculoseCura;
        this.qtdTuberculose = qtdTuberculose;
        this.hiv = hiv;
        this.hivControlada = hivControlada;
        this.qtdHib = qtdHib;
        this.hepatiteB = hepatiteB;
        this.hepatiBCont = hepatiBCont;
        this.qtdHepatiteB = qtdHepatiteB;
        this.hepatiteC = hepatiteC;
        this.hepatiCcont = hepatiCcont;
        this.qtdHepatiteC = qtdHepatiteC;
        this.dst = dst;
        this.curaDst = curaDst;
        this.qdtDst = qdtDst;
        this.vDLR = vDLR;
        this.curaVdlr = curaVdlr;
        this.qtdVdlr = qtdVdlr;
        this.vacina = vacina;
        this.vacinaCura = vacinaCura;
        this.qtdVacina = qtdVacina;
        this.observacaoEnf = observacaoEnf;
        this.idPedago = idPedago;
        this.dataPeda = dataPeda;
        this.iCAA = iCAA;
        this.qtdICAA = qtdICAA;
        this.iC1 = iC1;
        this.qtdIC1 = qtdIC1;
        this.iC2P = iC2P;
        this.qtdIC2P = qtdIC2P;
        this.iAAU = iAAU;
        this.qtdIAAU = qtdIAAU;
        this.iC3 = iC3;
        this.qtdIC3 = qtdIC3;
        this.iREL = iREL;
        this.qtdIREL = qtdIREL;
        this.iAC = iAC;
        this.qtdIAC = qtdIAC;
        this.iCU1 = iCU1;
        this.qtdICU1 = qtdICU1;
        this.iC2 = iC2;
        this.qtdIC2 = qtdIC2;
        this.iCA = iCA;
        this.qtdICA = qtdICA;
        this.observacaoPeda = observacaoPeda;
        this.idJurCrc = idJurCrc;
        this.dataJurCrc = dataJurCrc;
        this.processos = processos;
        this.qtdProgresso = qtdProgresso;
        this.documentacao = documentacao;
        this.qtdDocumentacao = qtdDocumentacao;
        this.progressao = progressao;
        this.qtdProgressao = qtdProgressao;
        this.livramento = livramento;
        this.qtdLivramento = qtdLivramento;
        this.observacaoCrc = observacaoCrc;
        this.idTo = idTo;
        this.dataTo = dataTo;
        this.programa = programa;
        this.qtdprograma = qtdprograma;
        this.curso = curso;
        this.qtdCurso = qtdCurso;
        this.profissional = profissional;
        this.qtdProfissional = qtdProfissional;
        this.observacaoTo = observacaoTo;
        this.idPsi = idPsi;
        this.dataPsi = dataPsi;
        this.tratamento = tratamento;
        this.qtdTratamento = qtdTratamento;
        this.acompanha = acompanha;
        this.qtdAcompanha = qtdAcompanha;
        this.recuparacao = recuparacao;
        this.qtdRecuparacao = qtdRecuparacao;
        this.observacaoPsi = observacaoPsi;
        this.idSS = idSS;
        this.dataSS = dataSS;
        this.acompanhaSS = acompanhaSS;
        this.qtdAcompanhaSS = qtdAcompanhaSS;
        this.observacao = observacao;
    }

    /**
     * @return the IdIndAco
     */
    public int getIdIndAco() {
        return IdIndAco;
    }

    /**
     * @param IdIndAco the IdIndAco to set
     */
    public void setIdIndAco(int IdIndAco) {
        this.IdIndAco = IdIndAco;
    }

    /**
     * @return the statusPerfil
     */
    public String getStatusPerfil() {
        return statusPerfil;
    }

    /**
     * @param statusPerfil the statusPerfil to set
     */
    public void setStatusPerfil(String statusPerfil) {
        this.statusPerfil = statusPerfil;
    }

    /**
     * @return the dataPerfil
     */
    public Date getDataPerfil() {
        return dataPerfil;
    }

    /**
     * @param dataPerfil the dataPerfil to set
     */
    public void setDataPerfil(Date dataPerfil) {
        this.dataPerfil = dataPerfil;
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
     * @return the nomeInternoPerfil
     */
    public String getNomeInternoPerfil() {
        return nomeInternoPerfil;
    }

    /**
     * @param nomeInternoPerfil the nomeInternoPerfil to set
     */
    public void setNomeInternoPerfil(String nomeInternoPerfil) {
        this.nomeInternoPerfil = nomeInternoPerfil;
    }

    /**
     * @return the opcaoSexual
     */
    public String getOpcaoSexual() {
        return opcaoSexual;
    }

    /**
     * @param opcaoSexual the opcaoSexual to set
     */
    public void setOpcaoSexual(String opcaoSexual) {
        this.opcaoSexual = opcaoSexual;
    }

    /**
     * @return the anoNascimento
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * @param anoNascimento the anoNascimento to set
     */
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * @return the anoReferencia
     */
    public int getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @return the observacaoPerfil
     */
    public String getObservacaoPerfil() {
        return observacaoPerfil;
    }

    /**
     * @param observacaoPerfil the observacaoPerfil to set
     */
    public void setObservacaoPerfil(String observacaoPerfil) {
        this.observacaoPerfil = observacaoPerfil;
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

    /**
     * @return the idEnf
     */
    public int getIdEnf() {
        return idEnf;
    }

    /**
     * @param idEnf the idEnf to set
     */
    public void setIdEnf(int idEnf) {
        this.idEnf = idEnf;
    }

    /**
     * @return the dataReg
     */
    public Date getDataReg() {
        return dataReg;
    }

    /**
     * @param dataReg the dataReg to set
     */
    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
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
     * @return the diabControl
     */
    public String getDiabControl() {
        return diabControl;
    }

    /**
     * @param diabControl the diabControl to set
     */
    public void setDiabControl(String diabControl) {
        this.diabControl = diabControl;
    }

    /**
     * @return the qtdDiabetes
     */
    public int getQtdDiabetes() {
        return qtdDiabetes;
    }

    /**
     * @param qtdDiabetes the qtdDiabetes to set
     */
    public void setQtdDiabetes(int qtdDiabetes) {
        this.qtdDiabetes = qtdDiabetes;
    }

    /**
     * @return the hipertensao
     */
    public String getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the hiperControl
     */
    public String getHiperControl() {
        return hiperControl;
    }

    /**
     * @param hiperControl the hiperControl to set
     */
    public void setHiperControl(String hiperControl) {
        this.hiperControl = hiperControl;
    }

    /**
     * @return the qtdHipertensao
     */
    public int getQtdHipertensao() {
        return qtdHipertensao;
    }

    /**
     * @param qtdHipertensao the qtdHipertensao to set
     */
    public void setQtdHipertensao(int qtdHipertensao) {
        this.qtdHipertensao = qtdHipertensao;
    }

    /**
     * @return the escabiose
     */
    public String getEscabiose() {
        return escabiose;
    }

    /**
     * @param escabiose the escabiose to set
     */
    public void setEscabiose(String escabiose) {
        this.escabiose = escabiose;
    }

    /**
     * @return the escabioseCura
     */
    public String getEscabioseCura() {
        return escabioseCura;
    }

    /**
     * @param escabioseCura the escabioseCura to set
     */
    public void setEscabioseCura(String escabioseCura) {
        this.escabioseCura = escabioseCura;
    }

    /**
     * @return the qtdEscabiose
     */
    public int getQtdEscabiose() {
        return qtdEscabiose;
    }

    /**
     * @param qtdEscabiose the qtdEscabiose to set
     */
    public void setQtdEscabiose(int qtdEscabiose) {
        this.qtdEscabiose = qtdEscabiose;
    }

    /**
     * @return the hanseniase
     */
    public String getHanseniase() {
        return hanseniase;
    }

    /**
     * @param hanseniase the hanseniase to set
     */
    public void setHanseniase(String hanseniase) {
        this.hanseniase = hanseniase;
    }

    /**
     * @return the hanseniaseCura
     */
    public String getHanseniaseCura() {
        return hanseniaseCura;
    }

    /**
     * @param hanseniaseCura the hanseniaseCura to set
     */
    public void setHanseniaseCura(String hanseniaseCura) {
        this.hanseniaseCura = hanseniaseCura;
    }

    /**
     * @return the qtdHanseniase
     */
    public int getQtdHanseniase() {
        return qtdHanseniase;
    }

    /**
     * @param qtdHanseniase the qtdHanseniase to set
     */
    public void setQtdHanseniase(int qtdHanseniase) {
        this.qtdHanseniase = qtdHanseniase;
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
     * @return the sifilisCura
     */
    public String getSifilisCura() {
        return sifilisCura;
    }

    /**
     * @param sifilisCura the sifilisCura to set
     */
    public void setSifilisCura(String sifilisCura) {
        this.sifilisCura = sifilisCura;
    }

    /**
     * @return the qtdSifilis
     */
    public int getQtdSifilis() {
        return qtdSifilis;
    }

    /**
     * @param qtdSifilis the qtdSifilis to set
     */
    public void setQtdSifilis(int qtdSifilis) {
        this.qtdSifilis = qtdSifilis;
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
     * @return the tuberculoseCura
     */
    public String getTuberculoseCura() {
        return tuberculoseCura;
    }

    /**
     * @param tuberculoseCura the tuberculoseCura to set
     */
    public void setTuberculoseCura(String tuberculoseCura) {
        this.tuberculoseCura = tuberculoseCura;
    }

    /**
     * @return the qtdTuberculose
     */
    public int getQtdTuberculose() {
        return qtdTuberculose;
    }

    /**
     * @param qtdTuberculose the qtdTuberculose to set
     */
    public void setQtdTuberculose(int qtdTuberculose) {
        this.qtdTuberculose = qtdTuberculose;
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
     * @return the hivControlada
     */
    public String getHivControlada() {
        return hivControlada;
    }

    /**
     * @param hivControlada the hivControlada to set
     */
    public void setHivControlada(String hivControlada) {
        this.hivControlada = hivControlada;
    }

    /**
     * @return the qtdHib
     */
    public int getQtdHib() {
        return qtdHib;
    }

    /**
     * @param qtdHib the qtdHib to set
     */
    public void setQtdHib(int qtdHib) {
        this.qtdHib = qtdHib;
    }

    /**
     * @return the hepatiteB
     */
    public String getHepatiteB() {
        return hepatiteB;
    }

    /**
     * @param hepatiteB the hepatiteB to set
     */
    public void setHepatiteB(String hepatiteB) {
        this.hepatiteB = hepatiteB;
    }

    /**
     * @return the hepatiBCont
     */
    public String getHepatiBCont() {
        return hepatiBCont;
    }

    /**
     * @param hepatiBCont the hepatiBCont to set
     */
    public void setHepatiBCont(String hepatiBCont) {
        this.hepatiBCont = hepatiBCont;
    }

    /**
     * @return the qtdHepatiteB
     */
    public int getQtdHepatiteB() {
        return qtdHepatiteB;
    }

    /**
     * @param qtdHepatiteB the qtdHepatiteB to set
     */
    public void setQtdHepatiteB(int qtdHepatiteB) {
        this.qtdHepatiteB = qtdHepatiteB;
    }

    /**
     * @return the hepatiteC
     */
    public String getHepatiteC() {
        return hepatiteC;
    }

    /**
     * @param hepatiteC the hepatiteC to set
     */
    public void setHepatiteC(String hepatiteC) {
        this.hepatiteC = hepatiteC;
    }

    /**
     * @return the hepatiCcont
     */
    public String getHepatiCcont() {
        return hepatiCcont;
    }

    /**
     * @param hepatiCcont the hepatiCcont to set
     */
    public void setHepatiCcont(String hepatiCcont) {
        this.hepatiCcont = hepatiCcont;
    }

    /**
     * @return the qtdHepatiteC
     */
    public int getQtdHepatiteC() {
        return qtdHepatiteC;
    }

    /**
     * @param qtdHepatiteC the qtdHepatiteC to set
     */
    public void setQtdHepatiteC(int qtdHepatiteC) {
        this.qtdHepatiteC = qtdHepatiteC;
    }

    /**
     * @return the dst
     */
    public String getDst() {
        return dst;
    }

    /**
     * @param dst the dst to set
     */
    public void setDst(String dst) {
        this.dst = dst;
    }

    /**
     * @return the curaDst
     */
    public String getCuraDst() {
        return curaDst;
    }

    /**
     * @param curaDst the curaDst to set
     */
    public void setCuraDst(String curaDst) {
        this.curaDst = curaDst;
    }

    /**
     * @return the qdtDst
     */
    public int getQdtDst() {
        return qdtDst;
    }

    /**
     * @param qdtDst the qdtDst to set
     */
    public void setQdtDst(int qdtDst) {
        this.qdtDst = qdtDst;
    }

    /**
     * @return the vDLR
     */
    public String getvDLR() {
        return vDLR;
    }

    /**
     * @param vDLR the vDLR to set
     */
    public void setvDLR(String vDLR) {
        this.vDLR = vDLR;
    }

    /**
     * @return the curaVdlr
     */
    public String getCuraVdlr() {
        return curaVdlr;
    }

    /**
     * @param curaVdlr the curaVdlr to set
     */
    public void setCuraVdlr(String curaVdlr) {
        this.curaVdlr = curaVdlr;
    }

    /**
     * @return the qtdVdlr
     */
    public int getQtdVdlr() {
        return qtdVdlr;
    }

    /**
     * @param qtdVdlr the qtdVdlr to set
     */
    public void setQtdVdlr(int qtdVdlr) {
        this.qtdVdlr = qtdVdlr;
    }

    /**
     * @return the vacina
     */
    public String getVacina() {
        return vacina;
    }

    /**
     * @param vacina the vacina to set
     */
    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    /**
     * @return the vacinaCura
     */
    public String getVacinaCura() {
        return vacinaCura;
    }

    /**
     * @param vacinaCura the vacinaCura to set
     */
    public void setVacinaCura(String vacinaCura) {
        this.vacinaCura = vacinaCura;
    }

    /**
     * @return the qtdVacina
     */
    public int getQtdVacina() {
        return qtdVacina;
    }

    /**
     * @param qtdVacina the qtdVacina to set
     */
    public void setQtdVacina(int qtdVacina) {
        this.qtdVacina = qtdVacina;
    }

    /**
     * @return the observacaoEnf
     */
    public String getObservacaoEnf() {
        return observacaoEnf;
    }

    /**
     * @param observacaoEnf the observacaoEnf to set
     */
    public void setObservacaoEnf(String observacaoEnf) {
        this.observacaoEnf = observacaoEnf;
    }

    /**
     * @return the idPedago
     */
    public int getIdPedago() {
        return idPedago;
    }

    /**
     * @param idPedago the idPedago to set
     */
    public void setIdPedago(int idPedago) {
        this.idPedago = idPedago;
    }

    /**
     * @return the dataPeda
     */
    public Date getDataPeda() {
        return dataPeda;
    }

    /**
     * @param dataPeda the dataPeda to set
     */
    public void setDataPeda(Date dataPeda) {
        this.dataPeda = dataPeda;
    }

    /**
     * @return the iCAA
     */
    public String getiCAA() {
        return iCAA;
    }

    /**
     * @param iCAA the iCAA to set
     */
    public void setiCAA(String iCAA) {
        this.iCAA = iCAA;
    }

    /**
     * @return the qtdICAA
     */
    public int getQtdICAA() {
        return qtdICAA;
    }

    /**
     * @param qtdICAA the qtdICAA to set
     */
    public void setQtdICAA(int qtdICAA) {
        this.qtdICAA = qtdICAA;
    }

    /**
     * @return the iC1
     */
    public String getiC1() {
        return iC1;
    }

    /**
     * @param iC1 the iC1 to set
     */
    public void setiC1(String iC1) {
        this.iC1 = iC1;
    }

    /**
     * @return the qtdIC1
     */
    public int getQtdIC1() {
        return qtdIC1;
    }

    /**
     * @param qtdIC1 the qtdIC1 to set
     */
    public void setQtdIC1(int qtdIC1) {
        this.qtdIC1 = qtdIC1;
    }

    /**
     * @return the iC2P
     */
    public String getiC2P() {
        return iC2P;
    }

    /**
     * @param iC2P the iC2P to set
     */
    public void setiC2P(String iC2P) {
        this.iC2P = iC2P;
    }

    /**
     * @return the qtdIC2P
     */
    public int getQtdIC2P() {
        return qtdIC2P;
    }

    /**
     * @param qtdIC2P the qtdIC2P to set
     */
    public void setQtdIC2P(int qtdIC2P) {
        this.qtdIC2P = qtdIC2P;
    }

    /**
     * @return the iAAU
     */
    public String getiAAU() {
        return iAAU;
    }

    /**
     * @param iAAU the iAAU to set
     */
    public void setiAAU(String iAAU) {
        this.iAAU = iAAU;
    }

    /**
     * @return the qtdIAAU
     */
    public int getQtdIAAU() {
        return qtdIAAU;
    }

    /**
     * @param qtdIAAU the qtdIAAU to set
     */
    public void setQtdIAAU(int qtdIAAU) {
        this.qtdIAAU = qtdIAAU;
    }

    /**
     * @return the iC3
     */
    public String getiC3() {
        return iC3;
    }

    /**
     * @param iC3 the iC3 to set
     */
    public void setiC3(String iC3) {
        this.iC3 = iC3;
    }

    /**
     * @return the qtdIC3
     */
    public int getQtdIC3() {
        return qtdIC3;
    }

    /**
     * @param qtdIC3 the qtdIC3 to set
     */
    public void setQtdIC3(int qtdIC3) {
        this.qtdIC3 = qtdIC3;
    }

    /**
     * @return the iREL
     */
    public String getiREL() {
        return iREL;
    }

    /**
     * @param iREL the iREL to set
     */
    public void setiREL(String iREL) {
        this.iREL = iREL;
    }

    /**
     * @return the qtdIREL
     */
    public int getQtdIREL() {
        return qtdIREL;
    }

    /**
     * @param qtdIREL the qtdIREL to set
     */
    public void setQtdIREL(int qtdIREL) {
        this.qtdIREL = qtdIREL;
    }

    /**
     * @return the iAC
     */
    public String getiAC() {
        return iAC;
    }

    /**
     * @param iAC the iAC to set
     */
    public void setiAC(String iAC) {
        this.iAC = iAC;
    }

    /**
     * @return the qtdIAC
     */
    public int getQtdIAC() {
        return qtdIAC;
    }

    /**
     * @param qtdIAC the qtdIAC to set
     */
    public void setQtdIAC(int qtdIAC) {
        this.qtdIAC = qtdIAC;
    }

    /**
     * @return the iCU1
     */
    public String getiCU1() {
        return iCU1;
    }

    /**
     * @param iCU1 the iCU1 to set
     */
    public void setiCU1(String iCU1) {
        this.iCU1 = iCU1;
    }

    /**
     * @return the qtdICU1
     */
    public int getQtdICU1() {
        return qtdICU1;
    }

    /**
     * @param qtdICU1 the qtdICU1 to set
     */
    public void setQtdICU1(int qtdICU1) {
        this.qtdICU1 = qtdICU1;
    }

    /**
     * @return the iC2
     */
    public String getiC2() {
        return iC2;
    }

    /**
     * @param iC2 the iC2 to set
     */
    public void setiC2(String iC2) {
        this.iC2 = iC2;
    }

    /**
     * @return the qtdIC2
     */
    public int getQtdIC2() {
        return qtdIC2;
    }

    /**
     * @param qtdIC2 the qtdIC2 to set
     */
    public void setQtdIC2(int qtdIC2) {
        this.qtdIC2 = qtdIC2;
    }

    /**
     * @return the iCA
     */
    public String getiCA() {
        return iCA;
    }

    /**
     * @param iCA the iCA to set
     */
    public void setiCA(String iCA) {
        this.iCA = iCA;
    }

    /**
     * @return the qtdICA
     */
    public int getQtdICA() {
        return qtdICA;
    }

    /**
     * @param qtdICA the qtdICA to set
     */
    public void setQtdICA(int qtdICA) {
        this.qtdICA = qtdICA;
    }

    /**
     * @return the observacaoPeda
     */
    public String getObservacaoPeda() {
        return observacaoPeda;
    }

    /**
     * @param observacaoPeda the observacaoPeda to set
     */
    public void setObservacaoPeda(String observacaoPeda) {
        this.observacaoPeda = observacaoPeda;
    }

    /**
     * @return the idJurCrc
     */
    public int getIdJurCrc() {
        return idJurCrc;
    }

    /**
     * @param idJurCrc the idJurCrc to set
     */
    public void setIdJurCrc(int idJurCrc) {
        this.idJurCrc = idJurCrc;
    }

    /**
     * @return the dataJurCrc
     */
    public Date getDataJurCrc() {
        return dataJurCrc;
    }

    /**
     * @param dataJurCrc the dataJurCrc to set
     */
    public void setDataJurCrc(Date dataJurCrc) {
        this.dataJurCrc = dataJurCrc;
    }

    /**
     * @return the processos
     */
    public String getProcessos() {
        return processos;
    }

    /**
     * @param processos the processos to set
     */
    public void setProcessos(String processos) {
        this.processos = processos;
    }

    /**
     * @return the qtdProgresso
     */
    public int getQtdProgresso() {
        return qtdProgresso;
    }

    /**
     * @param qtdProgresso the qtdProgresso to set
     */
    public void setQtdProgresso(int qtdProgresso) {
        this.qtdProgresso = qtdProgresso;
    }

    /**
     * @return the documentacao
     */
    public String getDocumentacao() {
        return documentacao;
    }

    /**
     * @param documentacao the documentacao to set
     */
    public void setDocumentacao(String documentacao) {
        this.documentacao = documentacao;
    }

    /**
     * @return the qtdDocumentacao
     */
    public int getQtdDocumentacao() {
        return qtdDocumentacao;
    }

    /**
     * @param qtdDocumentacao the qtdDocumentacao to set
     */
    public void setQtdDocumentacao(int qtdDocumentacao) {
        this.qtdDocumentacao = qtdDocumentacao;
    }

    /**
     * @return the progressao
     */
    public String getProgressao() {
        return progressao;
    }

    /**
     * @param progressao the progressao to set
     */
    public void setProgressao(String progressao) {
        this.progressao = progressao;
    }

    /**
     * @return the qtdProgressao
     */
    public int getQtdProgressao() {
        return qtdProgressao;
    }

    /**
     * @param qtdProgressao the qtdProgressao to set
     */
    public void setQtdProgressao(int qtdProgressao) {
        this.qtdProgressao = qtdProgressao;
    }

    /**
     * @return the livramento
     */
    public String getLivramento() {
        return livramento;
    }

    /**
     * @param livramento the livramento to set
     */
    public void setLivramento(String livramento) {
        this.livramento = livramento;
    }

    /**
     * @return the qtdLivramento
     */
    public int getQtdLivramento() {
        return qtdLivramento;
    }

    /**
     * @param qtdLivramento the qtdLivramento to set
     */
    public void setQtdLivramento(int qtdLivramento) {
        this.qtdLivramento = qtdLivramento;
    }

    /**
     * @return the observacaoCrc
     */
    public String getObservacaoCrc() {
        return observacaoCrc;
    }

    /**
     * @param observacaoCrc the observacaoCrc to set
     */
    public void setObservacaoCrc(String observacaoCrc) {
        this.observacaoCrc = observacaoCrc;
    }

    /**
     * @return the idTo
     */
    public int getIdTo() {
        return idTo;
    }

    /**
     * @param idTo the idTo to set
     */
    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }

    /**
     * @return the dataTo
     */
    public Date getDataTo() {
        return dataTo;
    }

    /**
     * @param dataTo the dataTo to set
     */
    public void setDataTo(Date dataTo) {
        this.dataTo = dataTo;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * @return the qtdprograma
     */
    public int getQtdprograma() {
        return qtdprograma;
    }

    /**
     * @param qtdprograma the qtdprograma to set
     */
    public void setQtdprograma(int qtdprograma) {
        this.qtdprograma = qtdprograma;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the qtdCurso
     */
    public int getQtdCurso() {
        return qtdCurso;
    }

    /**
     * @param qtdCurso the qtdCurso to set
     */
    public void setQtdCurso(int qtdCurso) {
        this.qtdCurso = qtdCurso;
    }

    /**
     * @return the profissional
     */
    public String getProfissional() {
        return profissional;
    }

    /**
     * @param profissional the profissional to set
     */
    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    /**
     * @return the qtdProfissional
     */
    public int getQtdProfissional() {
        return qtdProfissional;
    }

    /**
     * @param qtdProfissional the qtdProfissional to set
     */
    public void setQtdProfissional(int qtdProfissional) {
        this.qtdProfissional = qtdProfissional;
    }

    /**
     * @return the observacaoTo
     */
    public String getObservacaoTo() {
        return observacaoTo;
    }

    /**
     * @param observacaoTo the observacaoTo to set
     */
    public void setObservacaoTo(String observacaoTo) {
        this.observacaoTo = observacaoTo;
    }

    /**
     * @return the idPsi
     */
    public int getIdPsi() {
        return idPsi;
    }

    /**
     * @param idPsi the idPsi to set
     */
    public void setIdPsi(int idPsi) {
        this.idPsi = idPsi;
    }

    /**
     * @return the dataPsi
     */
    public Date getDataPsi() {
        return dataPsi;
    }

    /**
     * @param dataPsi the dataPsi to set
     */
    public void setDataPsi(Date dataPsi) {
        this.dataPsi = dataPsi;
    }

    /**
     * @return the tratamento
     */
    public String getTratamento() {
        return tratamento;
    }

    /**
     * @param tratamento the tratamento to set
     */
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    /**
     * @return the qtdTratamento
     */
    public int getQtdTratamento() {
        return qtdTratamento;
    }

    /**
     * @param qtdTratamento the qtdTratamento to set
     */
    public void setQtdTratamento(int qtdTratamento) {
        this.qtdTratamento = qtdTratamento;
    }

    /**
     * @return the acompanha
     */
    public String getAcompanha() {
        return acompanha;
    }

    /**
     * @param acompanha the acompanha to set
     */
    public void setAcompanha(String acompanha) {
        this.acompanha = acompanha;
    }

    /**
     * @return the qtdAcompanha
     */
    public int getQtdAcompanha() {
        return qtdAcompanha;
    }

    /**
     * @param qtdAcompanha the qtdAcompanha to set
     */
    public void setQtdAcompanha(int qtdAcompanha) {
        this.qtdAcompanha = qtdAcompanha;
    }

    /**
     * @return the recuparacao
     */
    public String getRecuparacao() {
        return recuparacao;
    }

    /**
     * @param recuparacao the recuparacao to set
     */
    public void setRecuparacao(String recuparacao) {
        this.recuparacao = recuparacao;
    }

    /**
     * @return the qtdRecuparacao
     */
    public int getQtdRecuparacao() {
        return qtdRecuparacao;
    }

    /**
     * @param qtdRecuparacao the qtdRecuparacao to set
     */
    public void setQtdRecuparacao(int qtdRecuparacao) {
        this.qtdRecuparacao = qtdRecuparacao;
    }

    /**
     * @return the observacaoPsi
     */
    public String getObservacaoPsi() {
        return observacaoPsi;
    }

    /**
     * @param observacaoPsi the observacaoPsi to set
     */
    public void setObservacaoPsi(String observacaoPsi) {
        this.observacaoPsi = observacaoPsi;
    }

    /**
     * @return the idSS
     */
    public int getIdSS() {
        return idSS;
    }

    /**
     * @param idSS the idSS to set
     */
    public void setIdSS(int idSS) {
        this.idSS = idSS;
    }

    /**
     * @return the dataSS
     */
    public Date getDataSS() {
        return dataSS;
    }

    /**
     * @param dataSS the dataSS to set
     */
    public void setDataSS(Date dataSS) {
        this.dataSS = dataSS;
    }

    /**
     * @return the acompanhaSS
     */
    public String getAcompanhaSS() {
        return acompanhaSS;
    }

    /**
     * @param acompanhaSS the acompanhaSS to set
     */
    public void setAcompanhaSS(String acompanhaSS) {
        this.acompanhaSS = acompanhaSS;
    }

    /**
     * @return the qtdAcompanhaSS
     */
    public int getQtdAcompanhaSS() {
        return qtdAcompanhaSS;
    }

    /**
     * @param qtdAcompanhaSS the qtdAcompanhaSS to set
     */
    public void setQtdAcompanhaSS(int qtdAcompanhaSS) {
        this.qtdAcompanhaSS = qtdAcompanhaSS;
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
}
