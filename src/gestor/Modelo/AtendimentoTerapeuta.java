/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class AtendimentoTerapeuta {

    private int idLanc;
    private int idATN;
    private int idAvaliaTOI;
    private int idAvaliaTOII;
    private int idHistoricoEduN;
    private int idItemICTHEN;
    private int idHistoricoLabPN;
    private int idItemPTHPN;
    private String statusLanc;
    private Date DataLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String deptoTerapia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;
    //
    private String dominancia;
    private String amputacao;
    private String deficienciaOcupa;
    private String reabilitacao;
    private String motora;
    private String cognitiva;
    private String sensorial;
    private String intPsi;
    private String aVD;
    private String aIVD;
    private String lazer;
    private String trabalho;
    private String obsDesempenhoOcupacional;
    //
    private String paisVivos;
    private String temCompanheira;
    private String temFilhos;
    private int quantosFilhos;
    private String visitaFamiliar;
    private int sFSeg;
    private int sFTer;
    private int sFQua;
    private int sFQui;
    private int sFSex;
    private int sFSab;
    private int sFDom;
    private String visitaIntima;            
    private int intSeg;
    private int intTer;
    private int intQua;
    private int intQui;
    private int intSex;
    private int intSab;
    private int intDom;
    private String ObsHistoricoFamiliar;
    //
    private String hipertensao;
    private String diabetes;
    private String cancer;
    private String proRespiratorio;
    private String transMental;
    private String infectoContagiosa;
    private String doencasDigestiva;
    private String deficienciaVAF;
    //
    private String obsDadosClinicos;
    private String humor;
    private String insonia;
    private String irritabilidade;
    private String frustracao;
    private String dificuldadeConcentrar;
    private String raiva;
    private String inquietacao;
    private String ansiedade;
    private String obsAlteracoesPsicologicas;
    //
    private String tabagismo;
    private int quantoTabagismo;
    private String tabagismoUsuario;
    private String etilismo;
    private String tipoEtilismo;
    private String medicacaoAlopativa;
    private String tipoMedicacaoAlopativa;
    private String sPA;
    private String tipoSPA;
    private String etilismoUsuario;
    private String medicaoAlopaticaUsuario;
    private String sPAUsuario;
    private String obsTriagemSPA;
    private String vidaSexual;
    private String metodoContraCeptivo;
    private String qualMetodoContraCeptivo;
    private String gestante;
    private String aborto;
    private String motivoAborto;
    private String praticaAtividadeFisica;
    private String qualAtividadeFisica;
    private String trataPsicologica;
    private String obsEstiloVida;         

    public AtendimentoTerapeuta() {
    }

    public AtendimentoTerapeuta(int idLanc, int idATN, int idAvaliaTOI, int idAvaliaTOII, int idHistoricoEduN, int idItemICTHEN, int idHistoricoLabPN, int idItemPTHPN, String statusLanc, Date DataLanc, int idInternoCrc, String nomeInternoCrc, String deptoTerapia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String dominancia, String amputacao, String deficienciaOcupa, String reabilitacao, String motora, String cognitiva, String sensorial, String intPsi, String aVD, String aIVD, String lazer, String trabalho, String obsDesempenhoOcupacional, String paisVivos, String temCompanheira, String temFilhos, int quantosFilhos, String visitaFamiliar, int sFSeg, int sFTer, int sFQua, int sFQui, int sFSex, int sFSab, int sFDom, String visitaIntima, int intSeg, int intTer, int intQua, int intQui, int intSex, int intSab, int intDom, String ObsHistoricoFamiliar, String hipertensao, String diabetes, String cancer, String proRespiratorio, String transMental, String infectoContagiosa, String doencasDigestiva, String deficienciaVAF, String obsDadosClinicos, String humor, String insonia, String irritabilidade, String frustracao, String dificuldadeConcentrar, String raiva, String inquietacao, String ansiedade, String obsAlteracoesPsicologicas, String tabagismo, int quantoTabagismo, String tabagismoUsuario, String etilismo, String tipoEtilismo, String medicacaoAlopativa, String tipoMedicacaoAlopativa, String sPA, String tipoSPA, String etilismoUsuario, String medicaoAlopaticaUsuario, String sPAUsuario, String obsTriagemSPA, String vidaSexual, String metodoContraCeptivo, String qualMetodoContraCeptivo, String gestante, String aborto, String motivoAborto, String praticaAtividadeFisica, String qualAtividadeFisica, String trataPsicologica, String obsEstiloVida) {
        this.idLanc = idLanc;
        this.idATN = idATN;
        this.idAvaliaTOI = idAvaliaTOI;
        this.idAvaliaTOII = idAvaliaTOII;
        this.idHistoricoEduN = idHistoricoEduN;
        this.idItemICTHEN = idItemICTHEN;
        this.idHistoricoLabPN = idHistoricoLabPN;
        this.idItemPTHPN = idItemPTHPN;
        this.statusLanc = statusLanc;
        this.DataLanc = DataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.deptoTerapia = deptoTerapia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.dominancia = dominancia;
        this.amputacao = amputacao;
        this.deficienciaOcupa = deficienciaOcupa;
        this.reabilitacao = reabilitacao;
        this.motora = motora;
        this.cognitiva = cognitiva;
        this.sensorial = sensorial;
        this.intPsi = intPsi;
        this.aVD = aVD;
        this.aIVD = aIVD;
        this.lazer = lazer;
        this.trabalho = trabalho;
        this.obsDesempenhoOcupacional = obsDesempenhoOcupacional;
        this.paisVivos = paisVivos;
        this.temCompanheira = temCompanheira;
        this.temFilhos = temFilhos;
        this.quantosFilhos = quantosFilhos;
        this.visitaFamiliar = visitaFamiliar;
        this.sFSeg = sFSeg;
        this.sFTer = sFTer;
        this.sFQua = sFQua;
        this.sFQui = sFQui;
        this.sFSex = sFSex;
        this.sFSab = sFSab;
        this.sFDom = sFDom;
        this.visitaIntima = visitaIntima;
        this.intSeg = intSeg;
        this.intTer = intTer;
        this.intQua = intQua;
        this.intQui = intQui;
        this.intSex = intSex;
        this.intSab = intSab;
        this.intDom = intDom;
        this.ObsHistoricoFamiliar = ObsHistoricoFamiliar;
        this.hipertensao = hipertensao;
        this.diabetes = diabetes;
        this.cancer = cancer;
        this.proRespiratorio = proRespiratorio;
        this.transMental = transMental;
        this.infectoContagiosa = infectoContagiosa;
        this.doencasDigestiva = doencasDigestiva;
        this.deficienciaVAF = deficienciaVAF;
        this.obsDadosClinicos = obsDadosClinicos;
        this.humor = humor;
        this.insonia = insonia;
        this.irritabilidade = irritabilidade;
        this.frustracao = frustracao;
        this.dificuldadeConcentrar = dificuldadeConcentrar;
        this.raiva = raiva;
        this.inquietacao = inquietacao;
        this.ansiedade = ansiedade;
        this.obsAlteracoesPsicologicas = obsAlteracoesPsicologicas;
        this.tabagismo = tabagismo;
        this.quantoTabagismo = quantoTabagismo;
        this.tabagismoUsuario = tabagismoUsuario;
        this.etilismo = etilismo;
        this.tipoEtilismo = tipoEtilismo;
        this.medicacaoAlopativa = medicacaoAlopativa;
        this.tipoMedicacaoAlopativa = tipoMedicacaoAlopativa;
        this.sPA = sPA;
        this.tipoSPA = tipoSPA;
        this.etilismoUsuario = etilismoUsuario;
        this.medicaoAlopaticaUsuario = medicaoAlopaticaUsuario;
        this.sPAUsuario = sPAUsuario;
        this.obsTriagemSPA = obsTriagemSPA;
        this.vidaSexual = vidaSexual;
        this.metodoContraCeptivo = metodoContraCeptivo;
        this.qualMetodoContraCeptivo = qualMetodoContraCeptivo;
        this.gestante = gestante;
        this.aborto = aborto;
        this.motivoAborto = motivoAborto;
        this.praticaAtividadeFisica = praticaAtividadeFisica;
        this.qualAtividadeFisica = qualAtividadeFisica;
        this.trataPsicologica = trataPsicologica;
        this.obsEstiloVida = obsEstiloVida;
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
     * @return the idATN
     */
    public int getIdATN() {
        return idATN;
    }

    /**
     * @param idATN the idATN to set
     */
    public void setIdATN(int idATN) {
        this.idATN = idATN;
    }

    /**
     * @return the idAvaliaTOI
     */
    public int getIdAvaliaTOI() {
        return idAvaliaTOI;
    }

    /**
     * @param idAvaliaTOI the idAvaliaTOI to set
     */
    public void setIdAvaliaTOI(int idAvaliaTOI) {
        this.idAvaliaTOI = idAvaliaTOI;
    }

    /**
     * @return the idAvaliaTOII
     */
    public int getIdAvaliaTOII() {
        return idAvaliaTOII;
    }

    /**
     * @param idAvaliaTOII the idAvaliaTOII to set
     */
    public void setIdAvaliaTOII(int idAvaliaTOII) {
        this.idAvaliaTOII = idAvaliaTOII;
    }

    /**
     * @return the idHistoricoEduN
     */
    public int getIdHistoricoEduN() {
        return idHistoricoEduN;
    }

    /**
     * @param idHistoricoEduN the idHistoricoEduN to set
     */
    public void setIdHistoricoEduN(int idHistoricoEduN) {
        this.idHistoricoEduN = idHistoricoEduN;
    }

    /**
     * @return the idItemICTHEN
     */
    public int getIdItemICTHEN() {
        return idItemICTHEN;
    }

    /**
     * @param idItemICTHEN the idItemICTHEN to set
     */
    public void setIdItemICTHEN(int idItemICTHEN) {
        this.idItemICTHEN = idItemICTHEN;
    }

    /**
     * @return the idHistoricoLabPN
     */
    public int getIdHistoricoLabPN() {
        return idHistoricoLabPN;
    }

    /**
     * @param idHistoricoLabPN the idHistoricoLabPN to set
     */
    public void setIdHistoricoLabPN(int idHistoricoLabPN) {
        this.idHistoricoLabPN = idHistoricoLabPN;
    }

    /**
     * @return the idItemPTHPN
     */
    public int getIdItemPTHPN() {
        return idItemPTHPN;
    }

    /**
     * @param idItemPTHPN the idItemPTHPN to set
     */
    public void setIdItemPTHPN(int idItemPTHPN) {
        this.idItemPTHPN = idItemPTHPN;
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
     * @return the DataLanc
     */
    public Date getDataLanc() {
        return DataLanc;
    }

    /**
     * @param DataLanc the DataLanc to set
     */
    public void setDataLanc(Date DataLanc) {
        this.DataLanc = DataLanc;
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
     * @return the deptoTerapia
     */
    public String getDeptoTerapia() {
        return deptoTerapia;
    }

    /**
     * @param deptoTerapia the deptoTerapia to set
     */
    public void setDeptoTerapia(String deptoTerapia) {
        this.deptoTerapia = deptoTerapia;
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
     * @return the dominancia
     */
    public String getDominancia() {
        return dominancia;
    }

    /**
     * @param dominancia the dominancia to set
     */
    public void setDominancia(String dominancia) {
        this.dominancia = dominancia;
    }

    /**
     * @return the amputacao
     */
    public String getAmputacao() {
        return amputacao;
    }

    /**
     * @param amputacao the amputacao to set
     */
    public void setAmputacao(String amputacao) {
        this.amputacao = amputacao;
    }

    /**
     * @return the deficienciaOcupa
     */
    public String getDeficienciaOcupa() {
        return deficienciaOcupa;
    }

    /**
     * @param deficienciaOcupa the deficienciaOcupa to set
     */
    public void setDeficienciaOcupa(String deficienciaOcupa) {
        this.deficienciaOcupa = deficienciaOcupa;
    }

    /**
     * @return the reabilitacao
     */
    public String getReabilitacao() {
        return reabilitacao;
    }

    /**
     * @param reabilitacao the reabilitacao to set
     */
    public void setReabilitacao(String reabilitacao) {
        this.reabilitacao = reabilitacao;
    }

    /**
     * @return the motora
     */
    public String getMotora() {
        return motora;
    }

    /**
     * @param motora the motora to set
     */
    public void setMotora(String motora) {
        this.motora = motora;
    }

    /**
     * @return the cognitiva
     */
    public String getCognitiva() {
        return cognitiva;
    }

    /**
     * @param cognitiva the cognitiva to set
     */
    public void setCognitiva(String cognitiva) {
        this.cognitiva = cognitiva;
    }

    /**
     * @return the sensorial
     */
    public String getSensorial() {
        return sensorial;
    }

    /**
     * @param sensorial the sensorial to set
     */
    public void setSensorial(String sensorial) {
        this.sensorial = sensorial;
    }

    /**
     * @return the intPsi
     */
    public String getIntPsi() {
        return intPsi;
    }

    /**
     * @param intPsi the intPsi to set
     */
    public void setIntPsi(String intPsi) {
        this.intPsi = intPsi;
    }

    /**
     * @return the aVD
     */
    public String getaVD() {
        return aVD;
    }

    /**
     * @param aVD the aVD to set
     */
    public void setaVD(String aVD) {
        this.aVD = aVD;
    }

    /**
     * @return the aIVD
     */
    public String getaIVD() {
        return aIVD;
    }

    /**
     * @param aIVD the aIVD to set
     */
    public void setaIVD(String aIVD) {
        this.aIVD = aIVD;
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
     * @return the trabalho
     */
    public String getTrabalho() {
        return trabalho;
    }

    /**
     * @param trabalho the trabalho to set
     */
    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    /**
     * @return the obsDesempenhoOcupacional
     */
    public String getObsDesempenhoOcupacional() {
        return obsDesempenhoOcupacional;
    }

    /**
     * @param obsDesempenhoOcupacional the obsDesempenhoOcupacional to set
     */
    public void setObsDesempenhoOcupacional(String obsDesempenhoOcupacional) {
        this.obsDesempenhoOcupacional = obsDesempenhoOcupacional;
    }

    /**
     * @return the paisVivos
     */
    public String getPaisVivos() {
        return paisVivos;
    }

    /**
     * @param paisVivos the paisVivos to set
     */
    public void setPaisVivos(String paisVivos) {
        this.paisVivos = paisVivos;
    }

    /**
     * @return the temCompanheira
     */
    public String getTemCompanheira() {
        return temCompanheira;
    }

    /**
     * @param temCompanheira the temCompanheira to set
     */
    public void setTemCompanheira(String temCompanheira) {
        this.temCompanheira = temCompanheira;
    }

    /**
     * @return the temFilhos
     */
    public String getTemFilhos() {
        return temFilhos;
    }

    /**
     * @param temFilhos the temFilhos to set
     */
    public void setTemFilhos(String temFilhos) {
        this.temFilhos = temFilhos;
    }

    /**
     * @return the quantosFilhos
     */
    public int getQuantosFilhos() {
        return quantosFilhos;
    }

    /**
     * @param quantosFilhos the quantosFilhos to set
     */
    public void setQuantosFilhos(int quantosFilhos) {
        this.quantosFilhos = quantosFilhos;
    }

    /**
     * @return the visitaFamiliar
     */
    public String getVisitaFamiliar() {
        return visitaFamiliar;
    }

    /**
     * @param visitaFamiliar the visitaFamiliar to set
     */
    public void setVisitaFamiliar(String visitaFamiliar) {
        this.visitaFamiliar = visitaFamiliar;
    }

    /**
     * @return the sFSeg
     */
    public int getsFSeg() {
        return sFSeg;
    }

    /**
     * @param sFSeg the sFSeg to set
     */
    public void setsFSeg(int sFSeg) {
        this.sFSeg = sFSeg;
    }

    /**
     * @return the sFTer
     */
    public int getsFTer() {
        return sFTer;
    }

    /**
     * @param sFTer the sFTer to set
     */
    public void setsFTer(int sFTer) {
        this.sFTer = sFTer;
    }

    /**
     * @return the sFQua
     */
    public int getsFQua() {
        return sFQua;
    }

    /**
     * @param sFQua the sFQua to set
     */
    public void setsFQua(int sFQua) {
        this.sFQua = sFQua;
    }

    /**
     * @return the sFQui
     */
    public int getsFQui() {
        return sFQui;
    }

    /**
     * @param sFQui the sFQui to set
     */
    public void setsFQui(int sFQui) {
        this.sFQui = sFQui;
    }

    /**
     * @return the sFSex
     */
    public int getsFSex() {
        return sFSex;
    }

    /**
     * @param sFSex the sFSex to set
     */
    public void setsFSex(int sFSex) {
        this.sFSex = sFSex;
    }

    /**
     * @return the sFSab
     */
    public int getsFSab() {
        return sFSab;
    }

    /**
     * @param sFSab the sFSab to set
     */
    public void setsFSab(int sFSab) {
        this.sFSab = sFSab;
    }

    /**
     * @return the sFDom
     */
    public int getsFDom() {
        return sFDom;
    }

    /**
     * @param sFDom the sFDom to set
     */
    public void setsFDom(int sFDom) {
        this.sFDom = sFDom;
    }

    /**
     * @return the visitaIntima
     */
    public String getVisitaIntima() {
        return visitaIntima;
    }

    /**
     * @param visitaIntima the visitaIntima to set
     */
    public void setVisitaIntima(String visitaIntima) {
        this.visitaIntima = visitaIntima;
    }

    /**
     * @return the intSeg
     */
    public int getIntSeg() {
        return intSeg;
    }

    /**
     * @param intSeg the intSeg to set
     */
    public void setIntSeg(int intSeg) {
        this.intSeg = intSeg;
    }

    /**
     * @return the intTer
     */
    public int getIntTer() {
        return intTer;
    }

    /**
     * @param intTer the intTer to set
     */
    public void setIntTer(int intTer) {
        this.intTer = intTer;
    }

    /**
     * @return the intQua
     */
    public int getIntQua() {
        return intQua;
    }

    /**
     * @param intQua the intQua to set
     */
    public void setIntQua(int intQua) {
        this.intQua = intQua;
    }

    /**
     * @return the intQui
     */
    public int getIntQui() {
        return intQui;
    }

    /**
     * @param intQui the intQui to set
     */
    public void setIntQui(int intQui) {
        this.intQui = intQui;
    }

    /**
     * @return the intSex
     */
    public int getIntSex() {
        return intSex;
    }

    /**
     * @param intSex the intSex to set
     */
    public void setIntSex(int intSex) {
        this.intSex = intSex;
    }

    /**
     * @return the intSab
     */
    public int getIntSab() {
        return intSab;
    }

    /**
     * @param intSab the intSab to set
     */
    public void setIntSab(int intSab) {
        this.intSab = intSab;
    }

    /**
     * @return the intDom
     */
    public int getIntDom() {
        return intDom;
    }

    /**
     * @param intDom the intDom to set
     */
    public void setIntDom(int intDom) {
        this.intDom = intDom;
    }

    /**
     * @return the ObsHistoricoFamiliar
     */
    public String getObsHistoricoFamiliar() {
        return ObsHistoricoFamiliar;
    }

    /**
     * @param ObsHistoricoFamiliar the ObsHistoricoFamiliar to set
     */
    public void setObsHistoricoFamiliar(String ObsHistoricoFamiliar) {
        this.ObsHistoricoFamiliar = ObsHistoricoFamiliar;
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
     * @return the cancer
     */
    public String getCancer() {
        return cancer;
    }

    /**
     * @param cancer the cancer to set
     */
    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    /**
     * @return the proRespiratorio
     */
    public String getProRespiratorio() {
        return proRespiratorio;
    }

    /**
     * @param proRespiratorio the proRespiratorio to set
     */
    public void setProRespiratorio(String proRespiratorio) {
        this.proRespiratorio = proRespiratorio;
    }

    /**
     * @return the transMental
     */
    public String getTransMental() {
        return transMental;
    }

    /**
     * @param transMental the transMental to set
     */
    public void setTransMental(String transMental) {
        this.transMental = transMental;
    }

    /**
     * @return the infectoContagiosa
     */
    public String getInfectoContagiosa() {
        return infectoContagiosa;
    }

    /**
     * @param infectoContagiosa the infectoContagiosa to set
     */
    public void setInfectoContagiosa(String infectoContagiosa) {
        this.infectoContagiosa = infectoContagiosa;
    }

    /**
     * @return the doencasDigestiva
     */
    public String getDoencasDigestiva() {
        return doencasDigestiva;
    }

    /**
     * @param doencasDigestiva the doencasDigestiva to set
     */
    public void setDoencasDigestiva(String doencasDigestiva) {
        this.doencasDigestiva = doencasDigestiva;
    }

    /**
     * @return the deficienciaVAF
     */
    public String getDeficienciaVAF() {
        return deficienciaVAF;
    }

    /**
     * @param deficienciaVAF the deficienciaVAF to set
     */
    public void setDeficienciaVAF(String deficienciaVAF) {
        this.deficienciaVAF = deficienciaVAF;
    }

    /**
     * @return the obsDadosClinicos
     */
    public String getObsDadosClinicos() {
        return obsDadosClinicos;
    }

    /**
     * @param obsDadosClinicos the obsDadosClinicos to set
     */
    public void setObsDadosClinicos(String obsDadosClinicos) {
        this.obsDadosClinicos = obsDadosClinicos;
    }

    /**
     * @return the humor
     */
    public String getHumor() {
        return humor;
    }

    /**
     * @param humor the humor to set
     */
    public void setHumor(String humor) {
        this.humor = humor;
    }

    /**
     * @return the insonia
     */
    public String getInsonia() {
        return insonia;
    }

    /**
     * @param insonia the insonia to set
     */
    public void setInsonia(String insonia) {
        this.insonia = insonia;
    }

    /**
     * @return the irritabilidade
     */
    public String getIrritabilidade() {
        return irritabilidade;
    }

    /**
     * @param irritabilidade the irritabilidade to set
     */
    public void setIrritabilidade(String irritabilidade) {
        this.irritabilidade = irritabilidade;
    }

    /**
     * @return the frustracao
     */
    public String getFrustracao() {
        return frustracao;
    }

    /**
     * @param frustracao the frustracao to set
     */
    public void setFrustracao(String frustracao) {
        this.frustracao = frustracao;
    }

    /**
     * @return the dificuldadeConcentrar
     */
    public String getDificuldadeConcentrar() {
        return dificuldadeConcentrar;
    }

    /**
     * @param dificuldadeConcentrar the dificuldadeConcentrar to set
     */
    public void setDificuldadeConcentrar(String dificuldadeConcentrar) {
        this.dificuldadeConcentrar = dificuldadeConcentrar;
    }

    /**
     * @return the raiva
     */
    public String getRaiva() {
        return raiva;
    }

    /**
     * @param raiva the raiva to set
     */
    public void setRaiva(String raiva) {
        this.raiva = raiva;
    }

    /**
     * @return the inquietacao
     */
    public String getInquietacao() {
        return inquietacao;
    }

    /**
     * @param inquietacao the inquietacao to set
     */
    public void setInquietacao(String inquietacao) {
        this.inquietacao = inquietacao;
    }

    /**
     * @return the ansiedade
     */
    public String getAnsiedade() {
        return ansiedade;
    }

    /**
     * @param ansiedade the ansiedade to set
     */
    public void setAnsiedade(String ansiedade) {
        this.ansiedade = ansiedade;
    }

    /**
     * @return the obsAlteracoesPsicologicas
     */
    public String getObsAlteracoesPsicologicas() {
        return obsAlteracoesPsicologicas;
    }

    /**
     * @param obsAlteracoesPsicologicas the obsAlteracoesPsicologicas to set
     */
    public void setObsAlteracoesPsicologicas(String obsAlteracoesPsicologicas) {
        this.obsAlteracoesPsicologicas = obsAlteracoesPsicologicas;
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
     * @return the quantoTabagismo
     */
    public int getQuantoTabagismo() {
        return quantoTabagismo;
    }

    /**
     * @param quantoTabagismo the quantoTabagismo to set
     */
    public void setQuantoTabagismo(int quantoTabagismo) {
        this.quantoTabagismo = quantoTabagismo;
    }

    /**
     * @return the tabagismoUsuario
     */
    public String getTabagismoUsuario() {
        return tabagismoUsuario;
    }

    /**
     * @param tabagismoUsuario the tabagismoUsuario to set
     */
    public void setTabagismoUsuario(String tabagismoUsuario) {
        this.tabagismoUsuario = tabagismoUsuario;
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
     * @return the tipoEtilismo
     */
    public String getTipoEtilismo() {
        return tipoEtilismo;
    }

    /**
     * @param tipoEtilismo the tipoEtilismo to set
     */
    public void setTipoEtilismo(String tipoEtilismo) {
        this.tipoEtilismo = tipoEtilismo;
    }

    /**
     * @return the medicacaoAlopativa
     */
    public String getMedicacaoAlopativa() {
        return medicacaoAlopativa;
    }

    /**
     * @param medicacaoAlopativa the medicacaoAlopativa to set
     */
    public void setMedicacaoAlopativa(String medicacaoAlopativa) {
        this.medicacaoAlopativa = medicacaoAlopativa;
    }

    /**
     * @return the tipoMedicacaoAlopativa
     */
    public String getTipoMedicacaoAlopativa() {
        return tipoMedicacaoAlopativa;
    }

    /**
     * @param tipoMedicacaoAlopativa the tipoMedicacaoAlopativa to set
     */
    public void setTipoMedicacaoAlopativa(String tipoMedicacaoAlopativa) {
        this.tipoMedicacaoAlopativa = tipoMedicacaoAlopativa;
    }

    /**
     * @return the sPA
     */
    public String getsPA() {
        return sPA;
    }

    /**
     * @param sPA the sPA to set
     */
    public void setsPA(String sPA) {
        this.sPA = sPA;
    }

    /**
     * @return the tipoSPA
     */
    public String getTipoSPA() {
        return tipoSPA;
    }

    /**
     * @param tipoSPA the tipoSPA to set
     */
    public void setTipoSPA(String tipoSPA) {
        this.tipoSPA = tipoSPA;
    }

    /**
     * @return the etilismoUsuario
     */
    public String getEtilismoUsuario() {
        return etilismoUsuario;
    }

    /**
     * @param etilismoUsuario the etilismoUsuario to set
     */
    public void setEtilismoUsuario(String etilismoUsuario) {
        this.etilismoUsuario = etilismoUsuario;
    }

    /**
     * @return the medicaoAlopaticaUsuario
     */
    public String getMedicaoAlopaticaUsuario() {
        return medicaoAlopaticaUsuario;
    }

    /**
     * @param medicaoAlopaticaUsuario the medicaoAlopaticaUsuario to set
     */
    public void setMedicaoAlopaticaUsuario(String medicaoAlopaticaUsuario) {
        this.medicaoAlopaticaUsuario = medicaoAlopaticaUsuario;
    }

    /**
     * @return the sPAUsuario
     */
    public String getsPAUsuario() {
        return sPAUsuario;
    }

    /**
     * @param sPAUsuario the sPAUsuario to set
     */
    public void setsPAUsuario(String sPAUsuario) {
        this.sPAUsuario = sPAUsuario;
    }

    /**
     * @return the obsTriagemSPA
     */
    public String getObsTriagemSPA() {
        return obsTriagemSPA;
    }

    /**
     * @param obsTriagemSPA the obsTriagemSPA to set
     */
    public void setObsTriagemSPA(String obsTriagemSPA) {
        this.obsTriagemSPA = obsTriagemSPA;
    }

    /**
     * @return the vidaSexual
     */
    public String getVidaSexual() {
        return vidaSexual;
    }

    /**
     * @param vidaSexual the vidaSexual to set
     */
    public void setVidaSexual(String vidaSexual) {
        this.vidaSexual = vidaSexual;
    }

    /**
     * @return the metodoContraCeptivo
     */
    public String getMetodoContraCeptivo() {
        return metodoContraCeptivo;
    }

    /**
     * @param metodoContraCeptivo the metodoContraCeptivo to set
     */
    public void setMetodoContraCeptivo(String metodoContraCeptivo) {
        this.metodoContraCeptivo = metodoContraCeptivo;
    }

    /**
     * @return the qualMetodoContraCeptivo
     */
    public String getQualMetodoContraCeptivo() {
        return qualMetodoContraCeptivo;
    }

    /**
     * @param qualMetodoContraCeptivo the qualMetodoContraCeptivo to set
     */
    public void setQualMetodoContraCeptivo(String qualMetodoContraCeptivo) {
        this.qualMetodoContraCeptivo = qualMetodoContraCeptivo;
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
     * @return the aborto
     */
    public String getAborto() {
        return aborto;
    }

    /**
     * @param aborto the aborto to set
     */
    public void setAborto(String aborto) {
        this.aborto = aborto;
    }

    /**
     * @return the motivoAborto
     */
    public String getMotivoAborto() {
        return motivoAborto;
    }

    /**
     * @param motivoAborto the motivoAborto to set
     */
    public void setMotivoAborto(String motivoAborto) {
        this.motivoAborto = motivoAborto;
    }

    /**
     * @return the praticaAtividadeFisica
     */
    public String getPraticaAtividadeFisica() {
        return praticaAtividadeFisica;
    }

    /**
     * @param praticaAtividadeFisica the praticaAtividadeFisica to set
     */
    public void setPraticaAtividadeFisica(String praticaAtividadeFisica) {
        this.praticaAtividadeFisica = praticaAtividadeFisica;
    }

    /**
     * @return the qualAtividadeFisica
     */
    public String getQualAtividadeFisica() {
        return qualAtividadeFisica;
    }

    /**
     * @param qualAtividadeFisica the qualAtividadeFisica to set
     */
    public void setQualAtividadeFisica(String qualAtividadeFisica) {
        this.qualAtividadeFisica = qualAtividadeFisica;
    }

    /**
     * @return the trataPsicologica
     */
    public String getTrataPsicologica() {
        return trataPsicologica;
    }

    /**
     * @param trataPsicologica the trataPsicologica to set
     */
    public void setTrataPsicologica(String trataPsicologica) {
        this.trataPsicologica = trataPsicologica;
    }

    /**
     * @return the obsEstiloVida
     */
    public String getObsEstiloVida() {
        return obsEstiloVida;
    }

    /**
     * @param obsEstiloVida the obsEstiloVida to set
     */
    public void setObsEstiloVida(String obsEstiloVida) {
        this.obsEstiloVida = obsEstiloVida;
    }
}
