/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import com.mongodb.Bytes;
import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class ParametrosCrc {

    private int idPar;
    private int qtdDias;
    private String qtdHoras;
    private String usuarioAutorizado;
    private String regRetornoPortaria;
    private String regEntradaPortaria;
    private String docAudiencia;
    private String docTrans;
    private String docSaidaTmp;
    private String docLivraPro;
    private String valAudiencia;
    private String valTrans;
    private String valSaidaTmp;
    private String valLivraPro;
    private String docPro;
    private String docAlvara;
    private String valPro;
    private String valAlvara;
    private String usuarioInsert;
    private String usuariosUp;
    private String dataInsert;
    private String dataUp;
    private String horarioUp;
    private String populacaoBgp;
    private String locacaoBgp;
    private String transferenciaBgp;
    private String pavilhaoCelas;
    private String populacaoBpa;
    private String locacaoBpa;
    private String transferenciaBpa;
    private String pavilhaoCelasBpa;   
    private String caminhoImagemCrc;
    private String caminhoImagemSS;   
    private String caminhoImagemFunc;
    private String localFotoAdvogado;
    private String localFotoVisitasDiversas;
    private String localFotoOficial;
    private String localFotoVisitasInternos;
    private String localFotoColaboradores;   
    private String localFotoInternos;     
    private String biometriaMedicos;
    private String biometriaEnfermerios;
    private String biometriaTecnicos;   
    private String carcereFem;   
    private String localPDF_PI;
    private String localPDF_PE;
    private String localPDF_B1;
    private String localPDF_B2;
    private String caminhoAtualizaSis;
    private Date dataVersao;
    private String numeroVersao;
    private String caminhoExecAntigo;
    private String preLocacaoB1;
    private String preLocacaoB2;
    private String pHabilitaBaseI;
    private String pHabilitaBaseII;
    private String nomeColaboradorPRI;
    private String nomeColaboradorSEG;
    private String pHabilitaAtendSS;
    private String pHabilitaTele;
    private String atendimentoBioPSI;
    private String avaliacaoBioPSI;
    private String adimissaoJuridico;
    private String admissaoTO;
    private String admissaoOdonto;
    private String nomeColaboradorCRC;
    private String nomeColaboradorCRCSEG;
    private String pHabilitaPEDA;
    private String nomeColaboradorTER;
    private String nomeColaboradorQUA;
    private String nomeColaboradorQUI;      
    private String tipoServidor;
    private String tipoBanco;
    private String nomeLiberadorAG0;
    private String nomeLiberadorAG1;
    private String nomeEncerradorAG0;
    private String nomeEncerradorAG1;    
    private String pagamentoKit;
    private String sistemaManutencao;
    private String biometriaEF;
    private Integer idImp;
    private Integer idModulo;
    private String nomeModulo;
    private Integer idTelas;
    private String nomeTela;
    private String habilitarImp;
    private Integer idUsuario;
    private String nomeUsuario;
    private Bytes senhaUsuario;
    private String fecharSistema;
    private String geraPopulacao;
    private int maioridadePenal;
    private String controlaMP;
    private String habilitarAlerta;
    private String habilitarAlertaAlmox;
    private String nomeUsuarioAlmox1;
    private String nomeUsuarioAlmox2;
    private String nomeUsuarioAlmox3;

    public ParametrosCrc() {
    }

    public ParametrosCrc(int idPar, int qtdDias, String qtdHoras, String usuarioAutorizado, String regRetornoPortaria, String regEntradaPortaria, String docAudiencia, String docTrans, String docSaidaTmp, String docLivraPro, String valAudiencia, String valTrans, String valSaidaTmp, String valLivraPro, String docPro, String docAlvara, String valPro, String valAlvara, String usuarioInsert, String usuariosUp, String dataInsert, String dataUp, String horarioUp, String populacaoBgp, String locacaoBgp, String transferenciaBgp, String pavilhaoCelas, String populacaoBpa, String locacaoBpa, String transferenciaBpa, String pavilhaoCelasBpa, String caminhoImagemCrc, String caminhoImagemSS, String caminhoImagemFunc, String localFotoAdvogado, String localFotoVisitasDiversas, String localFotoOficial, String localFotoVisitasInternos, String localFotoColaboradores, String localFotoInternos, String biometriaMedicos, String biometriaEnfermerios, String biometriaTecnicos, String carcereFem, String localPDF_PI, String localPDF_PE, String localPDF_B1, String localPDF_B2, String caminhoAtualizaSis, Date dataVersao, String numeroVersao, String caminhoExecAntigo, String preLocacaoB1, String preLocacaoB2, String pHabilitaBaseI, String pHabilitaBaseII, String nomeColaboradorPRI, String nomeColaboradorSEG, String pHabilitaAtendSS, String pHabilitaTele, String atendimentoBioPSI, String avaliacaoBioPSI, String adimissaoJuridico, String admissaoTO, String admissaoOdonto, String nomeColaboradorCRC, String nomeColaboradorCRCSEG, String pHabilitaPEDA, String nomeColaboradorTER, String nomeColaboradorQUA, String nomeColaboradorQUI, String tipoServidor, String tipoBanco, String nomeLiberadorAG0, String nomeLiberadorAG1, String nomeEncerradorAG0, String nomeEncerradorAG1, String pagamentoKit, String sistemaManutencao, String biometriaEF, Integer idImp, Integer idModulo, String nomeModulo, Integer idTelas, String nomeTela, String habilitarImp, Integer idUsuario, String nomeUsuario, Bytes senhaUsuario, String fecharSistema, String geraPopulacao, int maioridadePenal, String controlaMP, String habilitarAlerta, String habilitarAlertaAlmox, String nomeUsuarioAlmox1, String nomeUsuarioAlmox2, String nomeUsuarioAlmox3) {
        this.idPar = idPar;
        this.qtdDias = qtdDias;
        this.qtdHoras = qtdHoras;
        this.usuarioAutorizado = usuarioAutorizado;
        this.regRetornoPortaria = regRetornoPortaria;
        this.regEntradaPortaria = regEntradaPortaria;
        this.docAudiencia = docAudiencia;
        this.docTrans = docTrans;
        this.docSaidaTmp = docSaidaTmp;
        this.docLivraPro = docLivraPro;
        this.valAudiencia = valAudiencia;
        this.valTrans = valTrans;
        this.valSaidaTmp = valSaidaTmp;
        this.valLivraPro = valLivraPro;
        this.docPro = docPro;
        this.docAlvara = docAlvara;
        this.valPro = valPro;
        this.valAlvara = valAlvara;
        this.usuarioInsert = usuarioInsert;
        this.usuariosUp = usuariosUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.populacaoBgp = populacaoBgp;
        this.locacaoBgp = locacaoBgp;
        this.transferenciaBgp = transferenciaBgp;
        this.pavilhaoCelas = pavilhaoCelas;
        this.populacaoBpa = populacaoBpa;
        this.locacaoBpa = locacaoBpa;
        this.transferenciaBpa = transferenciaBpa;
        this.pavilhaoCelasBpa = pavilhaoCelasBpa;
        this.caminhoImagemCrc = caminhoImagemCrc;
        this.caminhoImagemSS = caminhoImagemSS;
        this.caminhoImagemFunc = caminhoImagemFunc;
        this.localFotoAdvogado = localFotoAdvogado;
        this.localFotoVisitasDiversas = localFotoVisitasDiversas;
        this.localFotoOficial = localFotoOficial;
        this.localFotoVisitasInternos = localFotoVisitasInternos;
        this.localFotoColaboradores = localFotoColaboradores;
        this.localFotoInternos = localFotoInternos;
        this.biometriaMedicos = biometriaMedicos;
        this.biometriaEnfermerios = biometriaEnfermerios;
        this.biometriaTecnicos = biometriaTecnicos;
        this.carcereFem = carcereFem;
        this.localPDF_PI = localPDF_PI;
        this.localPDF_PE = localPDF_PE;
        this.localPDF_B1 = localPDF_B1;
        this.localPDF_B2 = localPDF_B2;
        this.caminhoAtualizaSis = caminhoAtualizaSis;
        this.dataVersao = dataVersao;
        this.numeroVersao = numeroVersao;
        this.caminhoExecAntigo = caminhoExecAntigo;
        this.preLocacaoB1 = preLocacaoB1;
        this.preLocacaoB2 = preLocacaoB2;
        this.pHabilitaBaseI = pHabilitaBaseI;
        this.pHabilitaBaseII = pHabilitaBaseII;
        this.nomeColaboradorPRI = nomeColaboradorPRI;
        this.nomeColaboradorSEG = nomeColaboradorSEG;
        this.pHabilitaAtendSS = pHabilitaAtendSS;
        this.pHabilitaTele = pHabilitaTele;
        this.atendimentoBioPSI = atendimentoBioPSI;
        this.avaliacaoBioPSI = avaliacaoBioPSI;
        this.adimissaoJuridico = adimissaoJuridico;
        this.admissaoTO = admissaoTO;
        this.admissaoOdonto = admissaoOdonto;
        this.nomeColaboradorCRC = nomeColaboradorCRC;
        this.nomeColaboradorCRCSEG = nomeColaboradorCRCSEG;
        this.pHabilitaPEDA = pHabilitaPEDA;
        this.nomeColaboradorTER = nomeColaboradorTER;
        this.nomeColaboradorQUA = nomeColaboradorQUA;
        this.nomeColaboradorQUI = nomeColaboradorQUI;
        this.tipoServidor = tipoServidor;
        this.tipoBanco = tipoBanco;
        this.nomeLiberadorAG0 = nomeLiberadorAG0;
        this.nomeLiberadorAG1 = nomeLiberadorAG1;
        this.nomeEncerradorAG0 = nomeEncerradorAG0;
        this.nomeEncerradorAG1 = nomeEncerradorAG1;
        this.pagamentoKit = pagamentoKit;
        this.sistemaManutencao = sistemaManutencao;
        this.biometriaEF = biometriaEF;
        this.idImp = idImp;
        this.idModulo = idModulo;
        this.nomeModulo = nomeModulo;
        this.idTelas = idTelas;
        this.nomeTela = nomeTela;
        this.habilitarImp = habilitarImp;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.fecharSistema = fecharSistema;
        this.geraPopulacao = geraPopulacao;
        this.maioridadePenal = maioridadePenal;
        this.controlaMP = controlaMP;
        this.habilitarAlerta = habilitarAlerta;
        this.habilitarAlertaAlmox = habilitarAlertaAlmox;
        this.nomeUsuarioAlmox1 = nomeUsuarioAlmox1;
        this.nomeUsuarioAlmox2 = nomeUsuarioAlmox2;
        this.nomeUsuarioAlmox3 = nomeUsuarioAlmox3;
    }

    /**
     * @return the idPar
     */
    public int getIdPar() {
        return idPar;
    }

    /**
     * @param idPar the idPar to set
     */
    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }

    /**
     * @return the qtdDias
     */
    public int getQtdDias() {
        return qtdDias;
    }

    /**
     * @param qtdDias the qtdDias to set
     */
    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    /**
     * @return the qtdHoras
     */
    public String getQtdHoras() {
        return qtdHoras;
    }

    /**
     * @param qtdHoras the qtdHoras to set
     */
    public void setQtdHoras(String qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    /**
     * @return the usuarioAutorizado
     */
    public String getUsuarioAutorizado() {
        return usuarioAutorizado;
    }

    /**
     * @param usuarioAutorizado the usuarioAutorizado to set
     */
    public void setUsuarioAutorizado(String usuarioAutorizado) {
        this.usuarioAutorizado = usuarioAutorizado;
    }

    /**
     * @return the regRetornoPortaria
     */
    public String getRegRetornoPortaria() {
        return regRetornoPortaria;
    }

    /**
     * @param regRetornoPortaria the regRetornoPortaria to set
     */
    public void setRegRetornoPortaria(String regRetornoPortaria) {
        this.regRetornoPortaria = regRetornoPortaria;
    }

    /**
     * @return the regEntradaPortaria
     */
    public String getRegEntradaPortaria() {
        return regEntradaPortaria;
    }

    /**
     * @param regEntradaPortaria the regEntradaPortaria to set
     */
    public void setRegEntradaPortaria(String regEntradaPortaria) {
        this.regEntradaPortaria = regEntradaPortaria;
    }

    /**
     * @return the docAudiencia
     */
    public String getDocAudiencia() {
        return docAudiencia;
    }

    /**
     * @param docAudiencia the docAudiencia to set
     */
    public void setDocAudiencia(String docAudiencia) {
        this.docAudiencia = docAudiencia;
    }

    /**
     * @return the docTrans
     */
    public String getDocTrans() {
        return docTrans;
    }

    /**
     * @param docTrans the docTrans to set
     */
    public void setDocTrans(String docTrans) {
        this.docTrans = docTrans;
    }

    /**
     * @return the docSaidaTmp
     */
    public String getDocSaidaTmp() {
        return docSaidaTmp;
    }

    /**
     * @param docSaidaTmp the docSaidaTmp to set
     */
    public void setDocSaidaTmp(String docSaidaTmp) {
        this.docSaidaTmp = docSaidaTmp;
    }

    /**
     * @return the docLivraPro
     */
    public String getDocLivraPro() {
        return docLivraPro;
    }

    /**
     * @param docLivraPro the docLivraPro to set
     */
    public void setDocLivraPro(String docLivraPro) {
        this.docLivraPro = docLivraPro;
    }

    /**
     * @return the valAudiencia
     */
    public String getValAudiencia() {
        return valAudiencia;
    }

    /**
     * @param valAudiencia the valAudiencia to set
     */
    public void setValAudiencia(String valAudiencia) {
        this.valAudiencia = valAudiencia;
    }

    /**
     * @return the valTrans
     */
    public String getValTrans() {
        return valTrans;
    }

    /**
     * @param valTrans the valTrans to set
     */
    public void setValTrans(String valTrans) {
        this.valTrans = valTrans;
    }

    /**
     * @return the valSaidaTmp
     */
    public String getValSaidaTmp() {
        return valSaidaTmp;
    }

    /**
     * @param valSaidaTmp the valSaidaTmp to set
     */
    public void setValSaidaTmp(String valSaidaTmp) {
        this.valSaidaTmp = valSaidaTmp;
    }

    /**
     * @return the valLivraPro
     */
    public String getValLivraPro() {
        return valLivraPro;
    }

    /**
     * @param valLivraPro the valLivraPro to set
     */
    public void setValLivraPro(String valLivraPro) {
        this.valLivraPro = valLivraPro;
    }

    /**
     * @return the docPro
     */
    public String getDocPro() {
        return docPro;
    }

    /**
     * @param docPro the docPro to set
     */
    public void setDocPro(String docPro) {
        this.docPro = docPro;
    }

    /**
     * @return the docAlvara
     */
    public String getDocAlvara() {
        return docAlvara;
    }

    /**
     * @param docAlvara the docAlvara to set
     */
    public void setDocAlvara(String docAlvara) {
        this.docAlvara = docAlvara;
    }

    /**
     * @return the valPro
     */
    public String getValPro() {
        return valPro;
    }

    /**
     * @param valPro the valPro to set
     */
    public void setValPro(String valPro) {
        this.valPro = valPro;
    }

    /**
     * @return the valAlvara
     */
    public String getValAlvara() {
        return valAlvara;
    }

    /**
     * @param valAlvara the valAlvara to set
     */
    public void setValAlvara(String valAlvara) {
        this.valAlvara = valAlvara;
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
     * @return the usuariosUp
     */
    public String getUsuariosUp() {
        return usuariosUp;
    }

    /**
     * @param usuariosUp the usuariosUp to set
     */
    public void setUsuariosUp(String usuariosUp) {
        this.usuariosUp = usuariosUp;
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
     * @return the populacaoBgp
     */
    public String getPopulacaoBgp() {
        return populacaoBgp;
    }

    /**
     * @param populacaoBgp the populacaoBgp to set
     */
    public void setPopulacaoBgp(String populacaoBgp) {
        this.populacaoBgp = populacaoBgp;
    }

    /**
     * @return the locacaoBgp
     */
    public String getLocacaoBgp() {
        return locacaoBgp;
    }

    /**
     * @param locacaoBgp the locacaoBgp to set
     */
    public void setLocacaoBgp(String locacaoBgp) {
        this.locacaoBgp = locacaoBgp;
    }

    /**
     * @return the transferenciaBgp
     */
    public String getTransferenciaBgp() {
        return transferenciaBgp;
    }

    /**
     * @param transferenciaBgp the transferenciaBgp to set
     */
    public void setTransferenciaBgp(String transferenciaBgp) {
        this.transferenciaBgp = transferenciaBgp;
    }

    /**
     * @return the pavilhaoCelas
     */
    public String getPavilhaoCelas() {
        return pavilhaoCelas;
    }

    /**
     * @param pavilhaoCelas the pavilhaoCelas to set
     */
    public void setPavilhaoCelas(String pavilhaoCelas) {
        this.pavilhaoCelas = pavilhaoCelas;
    }

    /**
     * @return the populacaoBpa
     */
    public String getPopulacaoBpa() {
        return populacaoBpa;
    }

    /**
     * @param populacaoBpa the populacaoBpa to set
     */
    public void setPopulacaoBpa(String populacaoBpa) {
        this.populacaoBpa = populacaoBpa;
    }

    /**
     * @return the locacaoBpa
     */
    public String getLocacaoBpa() {
        return locacaoBpa;
    }

    /**
     * @param locacaoBpa the locacaoBpa to set
     */
    public void setLocacaoBpa(String locacaoBpa) {
        this.locacaoBpa = locacaoBpa;
    }

    /**
     * @return the transferenciaBpa
     */
    public String getTransferenciaBpa() {
        return transferenciaBpa;
    }

    /**
     * @param transferenciaBpa the transferenciaBpa to set
     */
    public void setTransferenciaBpa(String transferenciaBpa) {
        this.transferenciaBpa = transferenciaBpa;
    }

    /**
     * @return the pavilhaoCelasBpa
     */
    public String getPavilhaoCelasBpa() {
        return pavilhaoCelasBpa;
    }

    /**
     * @param pavilhaoCelasBpa the pavilhaoCelasBpa to set
     */
    public void setPavilhaoCelasBpa(String pavilhaoCelasBpa) {
        this.pavilhaoCelasBpa = pavilhaoCelasBpa;
    }

    /**
     * @return the caminhoImagemCrc
     */
    public String getCaminhoImagemCrc() {
        return caminhoImagemCrc;
    }

    /**
     * @param caminhoImagemCrc the caminhoImagemCrc to set
     */
    public void setCaminhoImagemCrc(String caminhoImagemCrc) {
        this.caminhoImagemCrc = caminhoImagemCrc;
    }

    /**
     * @return the caminhoImagemSS
     */
    public String getCaminhoImagemSS() {
        return caminhoImagemSS;
    }

    /**
     * @param caminhoImagemSS the caminhoImagemSS to set
     */
    public void setCaminhoImagemSS(String caminhoImagemSS) {
        this.caminhoImagemSS = caminhoImagemSS;
    }

    /**
     * @return the caminhoImagemFunc
     */
    public String getCaminhoImagemFunc() {
        return caminhoImagemFunc;
    }

    /**
     * @param caminhoImagemFunc the caminhoImagemFunc to set
     */
    public void setCaminhoImagemFunc(String caminhoImagemFunc) {
        this.caminhoImagemFunc = caminhoImagemFunc;
    }

    /**
     * @return the localFotoAdvogado
     */
    public String getLocalFotoAdvogado() {
        return localFotoAdvogado;
    }

    /**
     * @param localFotoAdvogado the localFotoAdvogado to set
     */
    public void setLocalFotoAdvogado(String localFotoAdvogado) {
        this.localFotoAdvogado = localFotoAdvogado;
    }

    /**
     * @return the localFotoVisitasDiversas
     */
    public String getLocalFotoVisitasDiversas() {
        return localFotoVisitasDiversas;
    }

    /**
     * @param localFotoVisitasDiversas the localFotoVisitasDiversas to set
     */
    public void setLocalFotoVisitasDiversas(String localFotoVisitasDiversas) {
        this.localFotoVisitasDiversas = localFotoVisitasDiversas;
    }

    /**
     * @return the localFotoOficial
     */
    public String getLocalFotoOficial() {
        return localFotoOficial;
    }

    /**
     * @param localFotoOficial the localFotoOficial to set
     */
    public void setLocalFotoOficial(String localFotoOficial) {
        this.localFotoOficial = localFotoOficial;
    }

    /**
     * @return the localFotoVisitasInternos
     */
    public String getLocalFotoVisitasInternos() {
        return localFotoVisitasInternos;
    }

    /**
     * @param localFotoVisitasInternos the localFotoVisitasInternos to set
     */
    public void setLocalFotoVisitasInternos(String localFotoVisitasInternos) {
        this.localFotoVisitasInternos = localFotoVisitasInternos;
    }

    /**
     * @return the localFotoColaboradores
     */
    public String getLocalFotoColaboradores() {
        return localFotoColaboradores;
    }

    /**
     * @param localFotoColaboradores the localFotoColaboradores to set
     */
    public void setLocalFotoColaboradores(String localFotoColaboradores) {
        this.localFotoColaboradores = localFotoColaboradores;
    }

    /**
     * @return the localFotoInternos
     */
    public String getLocalFotoInternos() {
        return localFotoInternos;
    }

    /**
     * @param localFotoInternos the localFotoInternos to set
     */
    public void setLocalFotoInternos(String localFotoInternos) {
        this.localFotoInternos = localFotoInternos;
    }

    /**
     * @return the biometriaMedicos
     */
    public String getBiometriaMedicos() {
        return biometriaMedicos;
    }

    /**
     * @param biometriaMedicos the biometriaMedicos to set
     */
    public void setBiometriaMedicos(String biometriaMedicos) {
        this.biometriaMedicos = biometriaMedicos;
    }

    /**
     * @return the biometriaEnfermerios
     */
    public String getBiometriaEnfermerios() {
        return biometriaEnfermerios;
    }

    /**
     * @param biometriaEnfermerios the biometriaEnfermerios to set
     */
    public void setBiometriaEnfermerios(String biometriaEnfermerios) {
        this.biometriaEnfermerios = biometriaEnfermerios;
    }

    /**
     * @return the biometriaTecnicos
     */
    public String getBiometriaTecnicos() {
        return biometriaTecnicos;
    }

    /**
     * @param biometriaTecnicos the biometriaTecnicos to set
     */
    public void setBiometriaTecnicos(String biometriaTecnicos) {
        this.biometriaTecnicos = biometriaTecnicos;
    }

    /**
     * @return the carcereFem
     */
    public String getCarcereFem() {
        return carcereFem;
    }

    /**
     * @param carcereFem the carcereFem to set
     */
    public void setCarcereFem(String carcereFem) {
        this.carcereFem = carcereFem;
    }

    /**
     * @return the localPDF_PI
     */
    public String getLocalPDF_PI() {
        return localPDF_PI;
    }

    /**
     * @param localPDF_PI the localPDF_PI to set
     */
    public void setLocalPDF_PI(String localPDF_PI) {
        this.localPDF_PI = localPDF_PI;
    }

    /**
     * @return the localPDF_PE
     */
    public String getLocalPDF_PE() {
        return localPDF_PE;
    }

    /**
     * @param localPDF_PE the localPDF_PE to set
     */
    public void setLocalPDF_PE(String localPDF_PE) {
        this.localPDF_PE = localPDF_PE;
    }

    /**
     * @return the localPDF_B1
     */
    public String getLocalPDF_B1() {
        return localPDF_B1;
    }

    /**
     * @param localPDF_B1 the localPDF_B1 to set
     */
    public void setLocalPDF_B1(String localPDF_B1) {
        this.localPDF_B1 = localPDF_B1;
    }

    /**
     * @return the localPDF_B2
     */
    public String getLocalPDF_B2() {
        return localPDF_B2;
    }

    /**
     * @param localPDF_B2 the localPDF_B2 to set
     */
    public void setLocalPDF_B2(String localPDF_B2) {
        this.localPDF_B2 = localPDF_B2;
    }

    /**
     * @return the caminhoAtualizaSis
     */
    public String getCaminhoAtualizaSis() {
        return caminhoAtualizaSis;
    }

    /**
     * @param caminhoAtualizaSis the caminhoAtualizaSis to set
     */
    public void setCaminhoAtualizaSis(String caminhoAtualizaSis) {
        this.caminhoAtualizaSis = caminhoAtualizaSis;
    }

    /**
     * @return the dataVersao
     */
    public Date getDataVersao() {
        return dataVersao;
    }

    /**
     * @param dataVersao the dataVersao to set
     */
    public void setDataVersao(Date dataVersao) {
        this.dataVersao = dataVersao;
    }

    /**
     * @return the numeroVersao
     */
    public String getNumeroVersao() {
        return numeroVersao;
    }

    /**
     * @param numeroVersao the numeroVersao to set
     */
    public void setNumeroVersao(String numeroVersao) {
        this.numeroVersao = numeroVersao;
    }

    /**
     * @return the caminhoExecAntigo
     */
    public String getCaminhoExecAntigo() {
        return caminhoExecAntigo;
    }

    /**
     * @param caminhoExecAntigo the caminhoExecAntigo to set
     */
    public void setCaminhoExecAntigo(String caminhoExecAntigo) {
        this.caminhoExecAntigo = caminhoExecAntigo;
    }

    /**
     * @return the preLocacaoB1
     */
    public String getPreLocacaoB1() {
        return preLocacaoB1;
    }

    /**
     * @param preLocacaoB1 the preLocacaoB1 to set
     */
    public void setPreLocacaoB1(String preLocacaoB1) {
        this.preLocacaoB1 = preLocacaoB1;
    }

    /**
     * @return the preLocacaoB2
     */
    public String getPreLocacaoB2() {
        return preLocacaoB2;
    }

    /**
     * @param preLocacaoB2 the preLocacaoB2 to set
     */
    public void setPreLocacaoB2(String preLocacaoB2) {
        this.preLocacaoB2 = preLocacaoB2;
    }

    /**
     * @return the pHabilitaBaseI
     */
    public String getpHabilitaBaseI() {
        return pHabilitaBaseI;
    }

    /**
     * @param pHabilitaBaseI the pHabilitaBaseI to set
     */
    public void setpHabilitaBaseI(String pHabilitaBaseI) {
        this.pHabilitaBaseI = pHabilitaBaseI;
    }

    /**
     * @return the pHabilitaBaseII
     */
    public String getpHabilitaBaseII() {
        return pHabilitaBaseII;
    }

    /**
     * @param pHabilitaBaseII the pHabilitaBaseII to set
     */
    public void setpHabilitaBaseII(String pHabilitaBaseII) {
        this.pHabilitaBaseII = pHabilitaBaseII;
    }

    /**
     * @return the nomeColaboradorPRI
     */
    public String getNomeColaboradorPRI() {
        return nomeColaboradorPRI;
    }

    /**
     * @param nomeColaboradorPRI the nomeColaboradorPRI to set
     */
    public void setNomeColaboradorPRI(String nomeColaboradorPRI) {
        this.nomeColaboradorPRI = nomeColaboradorPRI;
    }

    /**
     * @return the nomeColaboradorSEG
     */
    public String getNomeColaboradorSEG() {
        return nomeColaboradorSEG;
    }

    /**
     * @param nomeColaboradorSEG the nomeColaboradorSEG to set
     */
    public void setNomeColaboradorSEG(String nomeColaboradorSEG) {
        this.nomeColaboradorSEG = nomeColaboradorSEG;
    }

    /**
     * @return the pHabilitaAtendSS
     */
    public String getpHabilitaAtendSS() {
        return pHabilitaAtendSS;
    }

    /**
     * @param pHabilitaAtendSS the pHabilitaAtendSS to set
     */
    public void setpHabilitaAtendSS(String pHabilitaAtendSS) {
        this.pHabilitaAtendSS = pHabilitaAtendSS;
    }

    /**
     * @return the pHabilitaTele
     */
    public String getpHabilitaTele() {
        return pHabilitaTele;
    }

    /**
     * @param pHabilitaTele the pHabilitaTele to set
     */
    public void setpHabilitaTele(String pHabilitaTele) {
        this.pHabilitaTele = pHabilitaTele;
    }

    /**
     * @return the atendimentoBioPSI
     */
    public String getAtendimentoBioPSI() {
        return atendimentoBioPSI;
    }

    /**
     * @param atendimentoBioPSI the atendimentoBioPSI to set
     */
    public void setAtendimentoBioPSI(String atendimentoBioPSI) {
        this.atendimentoBioPSI = atendimentoBioPSI;
    }

    /**
     * @return the avaliacaoBioPSI
     */
    public String getAvaliacaoBioPSI() {
        return avaliacaoBioPSI;
    }

    /**
     * @param avaliacaoBioPSI the avaliacaoBioPSI to set
     */
    public void setAvaliacaoBioPSI(String avaliacaoBioPSI) {
        this.avaliacaoBioPSI = avaliacaoBioPSI;
    }

    /**
     * @return the adimissaoJuridico
     */
    public String getAdimissaoJuridico() {
        return adimissaoJuridico;
    }

    /**
     * @param adimissaoJuridico the adimissaoJuridico to set
     */
    public void setAdimissaoJuridico(String adimissaoJuridico) {
        this.adimissaoJuridico = adimissaoJuridico;
    }

    /**
     * @return the admissaoTO
     */
    public String getAdmissaoTO() {
        return admissaoTO;
    }

    /**
     * @param admissaoTO the admissaoTO to set
     */
    public void setAdmissaoTO(String admissaoTO) {
        this.admissaoTO = admissaoTO;
    }

    /**
     * @return the admissaoOdonto
     */
    public String getAdmissaoOdonto() {
        return admissaoOdonto;
    }

    /**
     * @param admissaoOdonto the admissaoOdonto to set
     */
    public void setAdmissaoOdonto(String admissaoOdonto) {
        this.admissaoOdonto = admissaoOdonto;
    }

    /**
     * @return the nomeColaboradorCRC
     */
    public String getNomeColaboradorCRC() {
        return nomeColaboradorCRC;
    }

    /**
     * @param nomeColaboradorCRC the nomeColaboradorCRC to set
     */
    public void setNomeColaboradorCRC(String nomeColaboradorCRC) {
        this.nomeColaboradorCRC = nomeColaboradorCRC;
    }

    /**
     * @return the nomeColaboradorCRCSEG
     */
    public String getNomeColaboradorCRCSEG() {
        return nomeColaboradorCRCSEG;
    }

    /**
     * @param nomeColaboradorCRCSEG the nomeColaboradorCRCSEG to set
     */
    public void setNomeColaboradorCRCSEG(String nomeColaboradorCRCSEG) {
        this.nomeColaboradorCRCSEG = nomeColaboradorCRCSEG;
    }

    /**
     * @return the pHabilitaPEDA
     */
    public String getpHabilitaPEDA() {
        return pHabilitaPEDA;
    }

    /**
     * @param pHabilitaPEDA the pHabilitaPEDA to set
     */
    public void setpHabilitaPEDA(String pHabilitaPEDA) {
        this.pHabilitaPEDA = pHabilitaPEDA;
    }

    /**
     * @return the nomeColaboradorTER
     */
    public String getNomeColaboradorTER() {
        return nomeColaboradorTER;
    }

    /**
     * @param nomeColaboradorTER the nomeColaboradorTER to set
     */
    public void setNomeColaboradorTER(String nomeColaboradorTER) {
        this.nomeColaboradorTER = nomeColaboradorTER;
    }

    /**
     * @return the nomeColaboradorQUA
     */
    public String getNomeColaboradorQUA() {
        return nomeColaboradorQUA;
    }

    /**
     * @param nomeColaboradorQUA the nomeColaboradorQUA to set
     */
    public void setNomeColaboradorQUA(String nomeColaboradorQUA) {
        this.nomeColaboradorQUA = nomeColaboradorQUA;
    }

    /**
     * @return the nomeColaboradorQUI
     */
    public String getNomeColaboradorQUI() {
        return nomeColaboradorQUI;
    }

    /**
     * @param nomeColaboradorQUI the nomeColaboradorQUI to set
     */
    public void setNomeColaboradorQUI(String nomeColaboradorQUI) {
        this.nomeColaboradorQUI = nomeColaboradorQUI;
    }

    /**
     * @return the tipoServidor
     */
    public String getTipoServidor() {
        return tipoServidor;
    }

    /**
     * @param tipoServidor the tipoServidor to set
     */
    public void setTipoServidor(String tipoServidor) {
        this.tipoServidor = tipoServidor;
    }

    /**
     * @return the tipoBanco
     */
    public String getTipoBanco() {
        return tipoBanco;
    }

    /**
     * @param tipoBanco the tipoBanco to set
     */
    public void setTipoBanco(String tipoBanco) {
        this.tipoBanco = tipoBanco;
    }

    /**
     * @return the nomeLiberadorAG0
     */
    public String getNomeLiberadorAG0() {
        return nomeLiberadorAG0;
    }

    /**
     * @param nomeLiberadorAG0 the nomeLiberadorAG0 to set
     */
    public void setNomeLiberadorAG0(String nomeLiberadorAG0) {
        this.nomeLiberadorAG0 = nomeLiberadorAG0;
    }

    /**
     * @return the nomeLiberadorAG1
     */
    public String getNomeLiberadorAG1() {
        return nomeLiberadorAG1;
    }

    /**
     * @param nomeLiberadorAG1 the nomeLiberadorAG1 to set
     */
    public void setNomeLiberadorAG1(String nomeLiberadorAG1) {
        this.nomeLiberadorAG1 = nomeLiberadorAG1;
    }

    /**
     * @return the nomeEncerradorAG0
     */
    public String getNomeEncerradorAG0() {
        return nomeEncerradorAG0;
    }

    /**
     * @param nomeEncerradorAG0 the nomeEncerradorAG0 to set
     */
    public void setNomeEncerradorAG0(String nomeEncerradorAG0) {
        this.nomeEncerradorAG0 = nomeEncerradorAG0;
    }

    /**
     * @return the nomeEncerradorAG1
     */
    public String getNomeEncerradorAG1() {
        return nomeEncerradorAG1;
    }

    /**
     * @param nomeEncerradorAG1 the nomeEncerradorAG1 to set
     */
    public void setNomeEncerradorAG1(String nomeEncerradorAG1) {
        this.nomeEncerradorAG1 = nomeEncerradorAG1;
    }

    /**
     * @return the pagamentoKit
     */
    public String getPagamentoKit() {
        return pagamentoKit;
    }

    /**
     * @param pagamentoKit the pagamentoKit to set
     */
    public void setPagamentoKit(String pagamentoKit) {
        this.pagamentoKit = pagamentoKit;
    }

    /**
     * @return the sistemaManutencao
     */
    public String getSistemaManutencao() {
        return sistemaManutencao;
    }

    /**
     * @param sistemaManutencao the sistemaManutencao to set
     */
    public void setSistemaManutencao(String sistemaManutencao) {
        this.sistemaManutencao = sistemaManutencao;
    }

    /**
     * @return the biometriaEF
     */
    public String getBiometriaEF() {
        return biometriaEF;
    }

    /**
     * @param biometriaEF the biometriaEF to set
     */
    public void setBiometriaEF(String biometriaEF) {
        this.biometriaEF = biometriaEF;
    }

    /**
     * @return the idImp
     */
    public Integer getIdImp() {
        return idImp;
    }

    /**
     * @param idImp the idImp to set
     */
    public void setIdImp(Integer idImp) {
        this.idImp = idImp;
    }

    /**
     * @return the idModulo
     */
    public Integer getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * @return the nomeModulo
     */
    public String getNomeModulo() {
        return nomeModulo;
    }

    /**
     * @param nomeModulo the nomeModulo to set
     */
    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    /**
     * @return the idTelas
     */
    public Integer getIdTelas() {
        return idTelas;
    }

    /**
     * @param idTelas the idTelas to set
     */
    public void setIdTelas(Integer idTelas) {
        this.idTelas = idTelas;
    }

    /**
     * @return the nomeTela
     */
    public String getNomeTela() {
        return nomeTela;
    }

    /**
     * @param nomeTela the nomeTela to set
     */
    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    /**
     * @return the habilitarImp
     */
    public String getHabilitarImp() {
        return habilitarImp;
    }

    /**
     * @param habilitarImp the habilitarImp to set
     */
    public void setHabilitarImp(String habilitarImp) {
        this.habilitarImp = habilitarImp;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senhaUsuario
     */
    public Bytes getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     * @param senhaUsuario the senhaUsuario to set
     */
    public void setSenhaUsuario(Bytes senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    /**
     * @return the fecharSistema
     */
    public String getFecharSistema() {
        return fecharSistema;
    }

    /**
     * @param fecharSistema the fecharSistema to set
     */
    public void setFecharSistema(String fecharSistema) {
        this.fecharSistema = fecharSistema;
    }

    /**
     * @return the geraPopulacao
     */
    public String getGeraPopulacao() {
        return geraPopulacao;
    }

    /**
     * @param geraPopulacao the geraPopulacao to set
     */
    public void setGeraPopulacao(String geraPopulacao) {
        this.geraPopulacao = geraPopulacao;
    }

    /**
     * @return the maioridadePenal
     */
    public int getMaioridadePenal() {
        return maioridadePenal;
    }

    /**
     * @param maioridadePenal the maioridadePenal to set
     */
    public void setMaioridadePenal(int maioridadePenal) {
        this.maioridadePenal = maioridadePenal;
    }

    /**
     * @return the controlaMP
     */
    public String getControlaMP() {
        return controlaMP;
    }

    /**
     * @param controlaMP the controlaMP to set
     */
    public void setControlaMP(String controlaMP) {
        this.controlaMP = controlaMP;
    }

    /**
     * @return the habilitarAlerta
     */
    public String getHabilitarAlerta() {
        return habilitarAlerta;
    }

    /**
     * @param habilitarAlerta the habilitarAlerta to set
     */
    public void setHabilitarAlerta(String habilitarAlerta) {
        this.habilitarAlerta = habilitarAlerta;
    }

    /**
     * @return the habilitarAlertaAlmox
     */
    public String getHabilitarAlertaAlmox() {
        return habilitarAlertaAlmox;
    }

    /**
     * @param habilitarAlertaAlmox the habilitarAlertaAlmox to set
     */
    public void setHabilitarAlertaAlmox(String habilitarAlertaAlmox) {
        this.habilitarAlertaAlmox = habilitarAlertaAlmox;
    }

    /**
     * @return the nomeUsuarioAlmox1
     */
    public String getNomeUsuarioAlmox1() {
        return nomeUsuarioAlmox1;
    }

    /**
     * @param nomeUsuarioAlmox1 the nomeUsuarioAlmox1 to set
     */
    public void setNomeUsuarioAlmox1(String nomeUsuarioAlmox1) {
        this.nomeUsuarioAlmox1 = nomeUsuarioAlmox1;
    }

    /**
     * @return the nomeUsuarioAlmox2
     */
    public String getNomeUsuarioAlmox2() {
        return nomeUsuarioAlmox2;
    }

    /**
     * @param nomeUsuarioAlmox2 the nomeUsuarioAlmox2 to set
     */
    public void setNomeUsuarioAlmox2(String nomeUsuarioAlmox2) {
        this.nomeUsuarioAlmox2 = nomeUsuarioAlmox2;
    }

    /**
     * @return the nomeUsuarioAlmox3
     */
    public String getNomeUsuarioAlmox3() {
        return nomeUsuarioAlmox3;
    }

    /**
     * @param nomeUsuarioAlmox3 the nomeUsuarioAlmox3 to set
     */
    public void setNomeUsuarioAlmox3(String nomeUsuarioAlmox3) {
        this.nomeUsuarioAlmox3 = nomeUsuarioAlmox3;
    }
}
