/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class FichaPAI_DS {

    private int idDS;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String refereSaude;
    private int hanseniase;
    private int diabetes;
    private int tuberculose;
    private int hipertensao;
    private int hepatites;
    private int sifilis;
    private int escabiose;
    private int hIV;
    private String outrasDoencas;
    private String fazendoTratamento;
    private String psiquiatrico;
    private String ondePsiquiatrico;
    private String psicotropico;
    private String qualPsicotropico;
    private String mental;
    private int desanimo;
    private int insonia;
    private int faltaApetite;
    private int isolamentoSocial;
    private int pensamentosSuicidas;
    private int agressividade;
    private int inquietacao;
    private int outroDoencas;
    private String qualOutrosDoencas;
    private String internadoPSI;
    private Date dataInternaPSI;
    private String acompanhaCAPS;
    private Date dataCAPS;
    private String usoPsicoativos;
    private int alcool;
    private int maconha;
    private int cocaina;
    private int cola;
    private int crack;
    private int injetaveis;
    private int outrasSub;
    private String qualOutrasSub;
    private String compartilhaCrack;
    private int sudorese;
    private int tremores;
    private int fissura;
    private int bocaSeca;
    private int nausea;
    private int desejo;
    private int naoPara;
    private int aumentoTolerancia;
    private String cAPSAD;
    private Date dataCAPSAD;
    private String esteveInternado;
    private int quantoTempoInternado;
    private String aceitaDanos;
    private String saudeBucal;
    private String necessitaAtende;
    private int enfermagem;
    private int medico;
    private int psiquiatricoN;
    private int psicologico;
    private String pessoasQuimica;
    private String quemNecessita;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;  

    public FichaPAI_DS(int idDS, int idPai, int idInternoCrc, String nomeInternoCrc, String refereSaude, int hanseniase, int diabetes, int tuberculose, int hipertensao, int hepatites, int sifilis, int escabiose, int hIV, String outrasDoencas, String fazendoTratamento, String psiquiatrico, String ondePsiquiatrico, String psicotropico, String qualPsicotropico, String mental, int desanimo, int insonia, int faltaApetite, int isolamentoSocial, int pensamentosSuicidas, int agressividade, int inquietacao, int outroDoencas, String qualOutrosDoencas, String internadoPSI, Date dataInternaPSI, String acompanhaCAPS, Date dataCAPS, String usoPsicoativos, int alcool, int maconha, int cocaina, int cola, int crack, int injetaveis, int outrasSub, String qualOutrasSub, String compartilhaCrack, int sudorese, int tremores, int fissura, int bocaSeca, int nausea, int desejo, int naoPara, int aumentoTolerancia, String cAPSAD, Date dataCAPSAD, String esteveInternado, int quantoTempoInternado, String aceitaDanos, String saudeBucal, String necessitaAtende, int enfermagem, int medico, int psiquiatricoN, int psicologico, String pessoasQuimica, String quemNecessita, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDS = idDS;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.refereSaude = refereSaude;
        this.hanseniase = hanseniase;
        this.diabetes = diabetes;
        this.tuberculose = tuberculose;
        this.hipertensao = hipertensao;
        this.hepatites = hepatites;
        this.sifilis = sifilis;
        this.escabiose = escabiose;
        this.hIV = hIV;
        this.outrasDoencas = outrasDoencas;
        this.fazendoTratamento = fazendoTratamento;
        this.psiquiatrico = psiquiatrico;
        this.ondePsiquiatrico = ondePsiquiatrico;
        this.psicotropico = psicotropico;
        this.qualPsicotropico = qualPsicotropico;
        this.mental = mental;
        this.desanimo = desanimo;
        this.insonia = insonia;
        this.faltaApetite = faltaApetite;
        this.isolamentoSocial = isolamentoSocial;
        this.pensamentosSuicidas = pensamentosSuicidas;
        this.agressividade = agressividade;
        this.inquietacao = inquietacao;
        this.outroDoencas = outroDoencas;
        this.qualOutrosDoencas = qualOutrosDoencas;
        this.internadoPSI = internadoPSI;
        this.dataInternaPSI = dataInternaPSI;
        this.acompanhaCAPS = acompanhaCAPS;
        this.dataCAPS = dataCAPS;
        this.usoPsicoativos = usoPsicoativos;
        this.alcool = alcool;
        this.maconha = maconha;
        this.cocaina = cocaina;
        this.cola = cola;
        this.crack = crack;
        this.injetaveis = injetaveis;
        this.outrasSub = outrasSub;
        this.qualOutrasSub = qualOutrasSub;
        this.compartilhaCrack = compartilhaCrack;
        this.sudorese = sudorese;
        this.tremores = tremores;
        this.fissura = fissura;
        this.bocaSeca = bocaSeca;
        this.nausea = nausea;
        this.desejo = desejo;
        this.naoPara = naoPara;
        this.aumentoTolerancia = aumentoTolerancia;
        this.cAPSAD = cAPSAD;
        this.dataCAPSAD = dataCAPSAD;
        this.esteveInternado = esteveInternado;
        this.quantoTempoInternado = quantoTempoInternado;
        this.aceitaDanos = aceitaDanos;
        this.saudeBucal = saudeBucal;
        this.necessitaAtende = necessitaAtende;
        this.enfermagem = enfermagem;
        this.medico = medico;
        this.psiquiatricoN = psiquiatricoN;
        this.psicologico = psicologico;
        this.pessoasQuimica = pessoasQuimica;
        this.quemNecessita = quemNecessita;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaPAI_DS() {
    }

    /**
     * @return the idDS
     */
    public int getIdDS() {
        return idDS;
    }

    /**
     * @param idDS the idDS to set
     */
    public void setIdDS(int idDS) {
        this.idDS = idDS;
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
     * @return the refereSaude
     */
    public String getRefereSaude() {
        return refereSaude;
    }

    /**
     * @param refereSaude the refereSaude to set
     */
    public void setRefereSaude(String refereSaude) {
        this.refereSaude = refereSaude;
    }

    /**
     * @return the hanseniase
     */
    public int getHanseniase() {
        return hanseniase;
    }

    /**
     * @param hanseniase the hanseniase to set
     */
    public void setHanseniase(int hanseniase) {
        this.hanseniase = hanseniase;
    }

    /**
     * @return the diabetes
     */
    public int getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the tuberculose
     */
    public int getTuberculose() {
        return tuberculose;
    }

    /**
     * @param tuberculose the tuberculose to set
     */
    public void setTuberculose(int tuberculose) {
        this.tuberculose = tuberculose;
    }

    /**
     * @return the hipertensao
     */
    public int getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(int hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the hepatites
     */
    public int getHepatites() {
        return hepatites;
    }

    /**
     * @param hepatites the hepatites to set
     */
    public void setHepatites(int hepatites) {
        this.hepatites = hepatites;
    }

    /**
     * @return the sifilis
     */
    public int getSifilis() {
        return sifilis;
    }

    /**
     * @param sifilis the sifilis to set
     */
    public void setSifilis(int sifilis) {
        this.sifilis = sifilis;
    }

    /**
     * @return the escabiose
     */
    public int getEscabiose() {
        return escabiose;
    }

    /**
     * @param escabiose the escabiose to set
     */
    public void setEscabiose(int escabiose) {
        this.escabiose = escabiose;
    }

    /**
     * @return the hIV
     */
    public int gethIV() {
        return hIV;
    }

    /**
     * @param hIV the hIV to set
     */
    public void sethIV(int hIV) {
        this.hIV = hIV;
    }

    /**
     * @return the outrasDoencas
     */
    public String getOutrasDoencas() {
        return outrasDoencas;
    }

    /**
     * @param outrasDoencas the outrasDoencas to set
     */
    public void setOutrasDoencas(String outrasDoencas) {
        this.outrasDoencas = outrasDoencas;
    }

    /**
     * @return the fazendoTratamento
     */
    public String getFazendoTratamento() {
        return fazendoTratamento;
    }

    /**
     * @param fazendoTratamento the fazendoTratamento to set
     */
    public void setFazendoTratamento(String fazendoTratamento) {
        this.fazendoTratamento = fazendoTratamento;
    }

    /**
     * @return the psiquiatrico
     */
    public String getPsiquiatrico() {
        return psiquiatrico;
    }

    /**
     * @param psiquiatrico the psiquiatrico to set
     */
    public void setPsiquiatrico(String psiquiatrico) {
        this.psiquiatrico = psiquiatrico;
    }

    /**
     * @return the ondePsiquiatrico
     */
    public String getOndePsiquiatrico() {
        return ondePsiquiatrico;
    }

    /**
     * @param ondePsiquiatrico the ondePsiquiatrico to set
     */
    public void setOndePsiquiatrico(String ondePsiquiatrico) {
        this.ondePsiquiatrico = ondePsiquiatrico;
    }

    /**
     * @return the psicotropico
     */
    public String getPsicotropico() {
        return psicotropico;
    }

    /**
     * @param psicotropico the psicotropico to set
     */
    public void setPsicotropico(String psicotropico) {
        this.psicotropico = psicotropico;
    }

    /**
     * @return the qualPsicotropico
     */
    public String getQualPsicotropico() {
        return qualPsicotropico;
    }

    /**
     * @param qualPsicotropico the qualPsicotropico to set
     */
    public void setQualPsicotropico(String qualPsicotropico) {
        this.qualPsicotropico = qualPsicotropico;
    }

    /**
     * @return the mental
     */
    public String getMental() {
        return mental;
    }

    /**
     * @param mental the mental to set
     */
    public void setMental(String mental) {
        this.mental = mental;
    }

    /**
     * @return the desanimo
     */
    public int getDesanimo() {
        return desanimo;
    }

    /**
     * @param desanimo the desanimo to set
     */
    public void setDesanimo(int desanimo) {
        this.desanimo = desanimo;
    }

    /**
     * @return the insonia
     */
    public int getInsonia() {
        return insonia;
    }

    /**
     * @param insonia the insonia to set
     */
    public void setInsonia(int insonia) {
        this.insonia = insonia;
    }

    /**
     * @return the faltaApetite
     */
    public int getFaltaApetite() {
        return faltaApetite;
    }

    /**
     * @param faltaApetite the faltaApetite to set
     */
    public void setFaltaApetite(int faltaApetite) {
        this.faltaApetite = faltaApetite;
    }

    /**
     * @return the isolamentoSocial
     */
    public int getIsolamentoSocial() {
        return isolamentoSocial;
    }

    /**
     * @param isolamentoSocial the isolamentoSocial to set
     */
    public void setIsolamentoSocial(int isolamentoSocial) {
        this.isolamentoSocial = isolamentoSocial;
    }

    /**
     * @return the pensamentosSuicidas
     */
    public int getPensamentosSuicidas() {
        return pensamentosSuicidas;
    }

    /**
     * @param pensamentosSuicidas the pensamentosSuicidas to set
     */
    public void setPensamentosSuicidas(int pensamentosSuicidas) {
        this.pensamentosSuicidas = pensamentosSuicidas;
    }

    /**
     * @return the agressividade
     */
    public int getAgressividade() {
        return agressividade;
    }

    /**
     * @param agressividade the agressividade to set
     */
    public void setAgressividade(int agressividade) {
        this.agressividade = agressividade;
    }

    /**
     * @return the inquietacao
     */
    public int getInquietacao() {
        return inquietacao;
    }

    /**
     * @param inquietacao the inquietacao to set
     */
    public void setInquietacao(int inquietacao) {
        this.inquietacao = inquietacao;
    }

    /**
     * @return the outroDoencas
     */
    public int getOutroDoencas() {
        return outroDoencas;
    }

    /**
     * @param outroDoencas the outroDoencas to set
     */
    public void setOutroDoencas(int outroDoencas) {
        this.outroDoencas = outroDoencas;
    }

    /**
     * @return the qualOutrosDoencas
     */
    public String getQualOutrosDoencas() {
        return qualOutrosDoencas;
    }

    /**
     * @param qualOutrosDoencas the qualOutrosDoencas to set
     */
    public void setQualOutrosDoencas(String qualOutrosDoencas) {
        this.qualOutrosDoencas = qualOutrosDoencas;
    }

    /**
     * @return the internadoPSI
     */
    public String getInternadoPSI() {
        return internadoPSI;
    }

    /**
     * @param internadoPSI the internadoPSI to set
     */
    public void setInternadoPSI(String internadoPSI) {
        this.internadoPSI = internadoPSI;
    }

    /**
     * @return the dataInternaPSI
     */
    public Date getDataInternaPSI() {
        return dataInternaPSI;
    }

    /**
     * @param dataInternaPSI the dataInternaPSI to set
     */
    public void setDataInternaPSI(Date dataInternaPSI) {
        this.dataInternaPSI = dataInternaPSI;
    }

    /**
     * @return the acompanhaCAPS
     */
    public String getAcompanhaCAPS() {
        return acompanhaCAPS;
    }

    /**
     * @param acompanhaCAPS the acompanhaCAPS to set
     */
    public void setAcompanhaCAPS(String acompanhaCAPS) {
        this.acompanhaCAPS = acompanhaCAPS;
    }

    /**
     * @return the dataCAPS
     */
    public Date getDataCAPS() {
        return dataCAPS;
    }

    /**
     * @param dataCAPS the dataCAPS to set
     */
    public void setDataCAPS(Date dataCAPS) {
        this.dataCAPS = dataCAPS;
    }

    /**
     * @return the usoPsicoativos
     */
    public String getUsoPsicoativos() {
        return usoPsicoativos;
    }

    /**
     * @param usoPsicoativos the usoPsicoativos to set
     */
    public void setUsoPsicoativos(String usoPsicoativos) {
        this.usoPsicoativos = usoPsicoativos;
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
     * @return the injetaveis
     */
    public int getInjetaveis() {
        return injetaveis;
    }

    /**
     * @param injetaveis the injetaveis to set
     */
    public void setInjetaveis(int injetaveis) {
        this.injetaveis = injetaveis;
    }

    /**
     * @return the outrasSub
     */
    public int getOutrasSub() {
        return outrasSub;
    }

    /**
     * @param outrasSub the outrasSub to set
     */
    public void setOutrasSub(int outrasSub) {
        this.outrasSub = outrasSub;
    }

    /**
     * @return the qualOutrasSub
     */
    public String getQualOutrasSub() {
        return qualOutrasSub;
    }

    /**
     * @param qualOutrasSub the qualOutrasSub to set
     */
    public void setQualOutrasSub(String qualOutrasSub) {
        this.qualOutrasSub = qualOutrasSub;
    }

    /**
     * @return the compartilhaCrack
     */
    public String getCompartilhaCrack() {
        return compartilhaCrack;
    }

    /**
     * @param compartilhaCrack the compartilhaCrack to set
     */
    public void setCompartilhaCrack(String compartilhaCrack) {
        this.compartilhaCrack = compartilhaCrack;
    }

    /**
     * @return the sudorese
     */
    public int getSudorese() {
        return sudorese;
    }

    /**
     * @param sudorese the sudorese to set
     */
    public void setSudorese(int sudorese) {
        this.sudorese = sudorese;
    }

    /**
     * @return the tremores
     */
    public int getTremores() {
        return tremores;
    }

    /**
     * @param tremores the tremores to set
     */
    public void setTremores(int tremores) {
        this.tremores = tremores;
    }

    /**
     * @return the fissura
     */
    public int getFissura() {
        return fissura;
    }

    /**
     * @param fissura the fissura to set
     */
    public void setFissura(int fissura) {
        this.fissura = fissura;
    }

    /**
     * @return the bocaSeca
     */
    public int getBocaSeca() {
        return bocaSeca;
    }

    /**
     * @param bocaSeca the bocaSeca to set
     */
    public void setBocaSeca(int bocaSeca) {
        this.bocaSeca = bocaSeca;
    }

    /**
     * @return the nausea
     */
    public int getNausea() {
        return nausea;
    }

    /**
     * @param nausea the nausea to set
     */
    public void setNausea(int nausea) {
        this.nausea = nausea;
    }

    /**
     * @return the desejo
     */
    public int getDesejo() {
        return desejo;
    }

    /**
     * @param desejo the desejo to set
     */
    public void setDesejo(int desejo) {
        this.desejo = desejo;
    }

    /**
     * @return the naoPara
     */
    public int getNaoPara() {
        return naoPara;
    }

    /**
     * @param naoPara the naoPara to set
     */
    public void setNaoPara(int naoPara) {
        this.naoPara = naoPara;
    }

    /**
     * @return the aumentoTolerancia
     */
    public int getAumentoTolerancia() {
        return aumentoTolerancia;
    }

    /**
     * @param aumentoTolerancia the aumentoTolerancia to set
     */
    public void setAumentoTolerancia(int aumentoTolerancia) {
        this.aumentoTolerancia = aumentoTolerancia;
    }

    /**
     * @return the cAPSAD
     */
    public String getcAPSAD() {
        return cAPSAD;
    }

    /**
     * @param cAPSAD the cAPSAD to set
     */
    public void setcAPSAD(String cAPSAD) {
        this.cAPSAD = cAPSAD;
    }

    /**
     * @return the dataCAPSAD
     */
    public Date getDataCAPSAD() {
        return dataCAPSAD;
    }

    /**
     * @param dataCAPSAD the dataCAPSAD to set
     */
    public void setDataCAPSAD(Date dataCAPSAD) {
        this.dataCAPSAD = dataCAPSAD;
    }

    /**
     * @return the esteveInternado
     */
    public String getEsteveInternado() {
        return esteveInternado;
    }

    /**
     * @param esteveInternado the esteveInternado to set
     */
    public void setEsteveInternado(String esteveInternado) {
        this.esteveInternado = esteveInternado;
    }

    /**
     * @return the quantoTempoInternado
     */
    public int getQuantoTempoInternado() {
        return quantoTempoInternado;
    }

    /**
     * @param quantoTempoInternado the quantoTempoInternado to set
     */
    public void setQuantoTempoInternado(int quantoTempoInternado) {
        this.quantoTempoInternado = quantoTempoInternado;
    }

    /**
     * @return the aceitaDanos
     */
    public String getAceitaDanos() {
        return aceitaDanos;
    }

    /**
     * @param aceitaDanos the aceitaDanos to set
     */
    public void setAceitaDanos(String aceitaDanos) {
        this.aceitaDanos = aceitaDanos;
    }

    /**
     * @return the saudeBucal
     */
    public String getSaudeBucal() {
        return saudeBucal;
    }

    /**
     * @param saudeBucal the saudeBucal to set
     */
    public void setSaudeBucal(String saudeBucal) {
        this.saudeBucal = saudeBucal;
    }

    /**
     * @return the necessitaAtende
     */
    public String getNecessitaAtende() {
        return necessitaAtende;
    }

    /**
     * @param necessitaAtende the necessitaAtende to set
     */
    public void setNecessitaAtende(String necessitaAtende) {
        this.necessitaAtende = necessitaAtende;
    }

    /**
     * @return the enfermagem
     */
    public int getEnfermagem() {
        return enfermagem;
    }

    /**
     * @param enfermagem the enfermagem to set
     */
    public void setEnfermagem(int enfermagem) {
        this.enfermagem = enfermagem;
    }

    /**
     * @return the medico
     */
    public int getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(int medico) {
        this.medico = medico;
    }

    /**
     * @return the psiquiatricoN
     */
    public int getPsiquiatricoN() {
        return psiquiatricoN;
    }

    /**
     * @param psiquiatricoN the psiquiatricoN to set
     */
    public void setPsiquiatricoN(int psiquiatricoN) {
        this.psiquiatricoN = psiquiatricoN;
    }

    /**
     * @return the psicologico
     */
    public int getPsicologico() {
        return psicologico;
    }

    /**
     * @param psicologico the psicologico to set
     */
    public void setPsicologico(int psicologico) {
        this.psicologico = psicologico;
    }

    /**
     * @return the pessoasQuimica
     */
    public String getPessoasQuimica() {
        return pessoasQuimica;
    }

    /**
     * @param pessoasQuimica the pessoasQuimica to set
     */
    public void setPessoasQuimica(String pessoasQuimica) {
        this.pessoasQuimica = pessoasQuimica;
    }

    /**
     * @return the quemNecessita
     */
    public String getQuemNecessita() {
        return quemNecessita;
    }

    /**
     * @param quemNecessita the quemNecessita to set
     */
    public void setQuemNecessita(String quemNecessita) {
        this.quemNecessita = quemNecessita;
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
