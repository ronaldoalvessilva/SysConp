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
public class CancelamentoEvasao {

    private Integer idCancelaEvasao;
    private String statusCancelarEvasao;
    private Date dataRegistroCancelamento;
    private Date dataCancelaEvasao;
    private int tipoOperacaoCancelar;
    private String descricaoOperacaoCancela;
    private String nomeResponsavel;
    private String cargoResponsavel;
    private String numeroDocumentoCancela;
    private Date dataCancelamento;
    private String motivoCancelamento;
    //DADOS DA EVASÃO
    private String statusLanc;
    private Date dataLanc;
    private String tipoOperacao;
    private String nrDocSaida;
    private int tipoEvasao;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String maeInterno;
    private String paiInterno;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String internoEvadido;
    private Date dataEvasao;
    private Date dataDocumento;
    //DADOS DE ENTRADA DO INTERNO NA UNIDADE
    private int idItem;
    private String nomeInterno;
    private Date dataEntrada;
    private String horarioEntrada;
    private Date dataSaida;
    private String horarioSaida;
    private int qtdInt;
    private String mesReferencia;
    private String horaInsert;
    private String horaUp;
    private byte[] assinaturaDigital;
    private int idItemSaida;
    private Date dataRetorno;
    private String nomeDestino;
    private String documento;
    private int idInternoSaida;
    private String confirmaRetorno;
    private String confirmaEvasao;
    private String confirmaSaida;
    private Date dataEvasaoTmp;
    private Date dataPrevRetorno;
    private String obito;
    private String confirmaObito;
    //DADOS DO INTERNO E DO KIT
    private String kitInicial;
    private String kitDecendial;
    private String kitQuinzenal;
    private String kitMensal;
    private String kitSemestral;
    private String kitAnual;
    private String kitIPago;
    private String kitDPago;
    private String kitQPago;
    private String kitMPago;
    private String kitSPago;
    private String kitAPago;
    private Date dataChegada;
    private String kitPago;
    private String utilizado;
    private String documentacaoCompleta;
    private String quaisDocumentosFaltam;
    private int idChek;
    private String descricaoDoc;
    private String regime;
    private String tornozeleira;
    //DADOS DA LOCAÇÃO    
    private String descricaoCela;
    private int qtdLanc;
    //DADOS DO ROL
    private Date dataRol;
    private String statusRol;
    private String dataFechamento;
    private String horaFechamento;
    private String recebeVisita;
    private int idInstituicao;
    private String nomeInstituicaoRel;
    private int domingo;
    private int segunda;
    private int terca;
    private int quarta;
    private int quinta;
    private int sexta;
    private int sabado;
    //DADOS FINANCEIRO - SAQUE
    private float valorSaque;
    private String favorecido;
    private String reciboSaque;
    //DADOS FINANCEIRO - DEPOSITO    
    private float valorDeposito;
    private String depositante;
    private String efetuado;  
    private Date dataLancMov;
    private int idHist;
    private int tipo;
    private float valorLiberado;
    private int idUsuario;
    private String nomeUsuario;
    private float saldoAtual;
    private String tipoTrans;
    //
    private Integer idRegistroEvasao;
    private Integer idRegistroLabor;
    private Integer idRegistroEduca;
    private Integer idSaida;
    private int idDeposito;
    private int idSaque;
    private Integer idLancHist;
    private Integer idLoca;
    private Integer idCela;
    private Integer idRol;

    public CancelamentoEvasao() {
    }

    public CancelamentoEvasao(Integer idCancelaEvasao, String statusCancelarEvasao, Date dataRegistroCancelamento, Date dataCancelaEvasao, int tipoOperacaoCancelar, String descricaoOperacaoCancela, String nomeResponsavel, String cargoResponsavel, String numeroDocumentoCancela, Date dataCancelamento, String motivoCancelamento, String statusLanc, Date dataLanc, String tipoOperacao, String nrDocSaida, int tipoEvasao, int idInternoCrc, String nomeInternoCrc, String maeInterno, String paiInterno, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String internoEvadido, Date dataEvasao, Date dataDocumento, int idItem, String nomeInterno, Date dataEntrada, String horarioEntrada, Date dataSaida, String horarioSaida, int qtdInt, String mesReferencia, String horaInsert, String horaUp, byte[] assinaturaDigital, int idItemSaida, Date dataRetorno, String nomeDestino, String documento, int idInternoSaida, String confirmaRetorno, String confirmaEvasao, String confirmaSaida, Date dataEvasaoTmp, Date dataPrevRetorno, String obito, String confirmaObito, String kitInicial, String kitDecendial, String kitQuinzenal, String kitMensal, String kitSemestral, String kitAnual, String kitIPago, String kitDPago, String kitQPago, String kitMPago, String kitSPago, String kitAPago, Date dataChegada, String kitPago, String utilizado, String documentacaoCompleta, String quaisDocumentosFaltam, int idChek, String descricaoDoc, String regime, String tornozeleira, String descricaoCela, int qtdLanc, Date dataRol, String statusRol, String dataFechamento, String horaFechamento, String recebeVisita, int idInstituicao, String nomeInstituicaoRel, int domingo, int segunda, int terca, int quarta, int quinta, int sexta, int sabado, float valorSaque, String favorecido, String reciboSaque, float valorDeposito, String depositante, String efetuado, Date dataLancMov, int idHist, int tipo, float valorLiberado, int idUsuario, String nomeUsuario, float saldoAtual, String tipoTrans, Integer idRegistroEvasao, Integer idRegistroLabor, Integer idRegistroEduca, Integer idSaida, int idDeposito, int idSaque, Integer idLancHist, Integer idLoca, Integer idCela, Integer idRol) {
        this.idCancelaEvasao = idCancelaEvasao;
        this.statusCancelarEvasao = statusCancelarEvasao;
        this.dataRegistroCancelamento = dataRegistroCancelamento;
        this.dataCancelaEvasao = dataCancelaEvasao;
        this.tipoOperacaoCancelar = tipoOperacaoCancelar;
        this.descricaoOperacaoCancela = descricaoOperacaoCancela;
        this.nomeResponsavel = nomeResponsavel;
        this.cargoResponsavel = cargoResponsavel;
        this.numeroDocumentoCancela = numeroDocumentoCancela;
        this.dataCancelamento = dataCancelamento;
        this.motivoCancelamento = motivoCancelamento;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.tipoOperacao = tipoOperacao;
        this.nrDocSaida = nrDocSaida;
        this.tipoEvasao = tipoEvasao;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.maeInterno = maeInterno;
        this.paiInterno = paiInterno;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.internoEvadido = internoEvadido;
        this.dataEvasao = dataEvasao;
        this.dataDocumento = dataDocumento;
        this.idItem = idItem;
        this.nomeInterno = nomeInterno;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.qtdInt = qtdInt;
        this.mesReferencia = mesReferencia;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.assinaturaDigital = assinaturaDigital;
        this.idItemSaida = idItemSaida;
        this.dataRetorno = dataRetorno;
        this.nomeDestino = nomeDestino;
        this.documento = documento;
        this.idInternoSaida = idInternoSaida;
        this.confirmaRetorno = confirmaRetorno;
        this.confirmaEvasao = confirmaEvasao;
        this.confirmaSaida = confirmaSaida;
        this.dataEvasaoTmp = dataEvasaoTmp;
        this.dataPrevRetorno = dataPrevRetorno;
        this.obito = obito;
        this.confirmaObito = confirmaObito;
        this.kitInicial = kitInicial;
        this.kitDecendial = kitDecendial;
        this.kitQuinzenal = kitQuinzenal;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitAnual = kitAnual;
        this.kitIPago = kitIPago;
        this.kitDPago = kitDPago;
        this.kitQPago = kitQPago;
        this.kitMPago = kitMPago;
        this.kitSPago = kitSPago;
        this.kitAPago = kitAPago;
        this.dataChegada = dataChegada;
        this.kitPago = kitPago;
        this.utilizado = utilizado;
        this.documentacaoCompleta = documentacaoCompleta;
        this.quaisDocumentosFaltam = quaisDocumentosFaltam;
        this.idChek = idChek;
        this.descricaoDoc = descricaoDoc;
        this.regime = regime;
        this.tornozeleira = tornozeleira;
        this.descricaoCela = descricaoCela;
        this.qtdLanc = qtdLanc;
        this.dataRol = dataRol;
        this.statusRol = statusRol;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.recebeVisita = recebeVisita;
        this.idInstituicao = idInstituicao;
        this.nomeInstituicaoRel = nomeInstituicaoRel;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.valorSaque = valorSaque;
        this.favorecido = favorecido;
        this.reciboSaque = reciboSaque;
        this.valorDeposito = valorDeposito;
        this.depositante = depositante;
        this.efetuado = efetuado;
        this.dataLancMov = dataLancMov;
        this.idHist = idHist;
        this.tipo = tipo;
        this.valorLiberado = valorLiberado;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.saldoAtual = saldoAtual;
        this.tipoTrans = tipoTrans;
        this.idRegistroEvasao = idRegistroEvasao;
        this.idRegistroLabor = idRegistroLabor;
        this.idRegistroEduca = idRegistroEduca;
        this.idSaida = idSaida;
        this.idDeposito = idDeposito;
        this.idSaque = idSaque;
        this.idLancHist = idLancHist;
        this.idLoca = idLoca;
        this.idCela = idCela;
        this.idRol = idRol;
    }

    /**
     * @return the idCancelaEvasao
     */
    public Integer getIdCancelaEvasao() {
        return idCancelaEvasao;
    }

    /**
     * @param idCancelaEvasao the idCancelaEvasao to set
     */
    public void setIdCancelaEvasao(Integer idCancelaEvasao) {
        this.idCancelaEvasao = idCancelaEvasao;
    }

    /**
     * @return the statusCancelarEvasao
     */
    public String getStatusCancelarEvasao() {
        return statusCancelarEvasao;
    }

    /**
     * @param statusCancelarEvasao the statusCancelarEvasao to set
     */
    public void setStatusCancelarEvasao(String statusCancelarEvasao) {
        this.statusCancelarEvasao = statusCancelarEvasao;
    }

    /**
     * @return the dataRegistroCancelamento
     */
    public Date getDataRegistroCancelamento() {
        return dataRegistroCancelamento;
    }

    /**
     * @param dataRegistroCancelamento the dataRegistroCancelamento to set
     */
    public void setDataRegistroCancelamento(Date dataRegistroCancelamento) {
        this.dataRegistroCancelamento = dataRegistroCancelamento;
    }

    /**
     * @return the dataCancelaEvasao
     */
    public Date getDataCancelaEvasao() {
        return dataCancelaEvasao;
    }

    /**
     * @param dataCancelaEvasao the dataCancelaEvasao to set
     */
    public void setDataCancelaEvasao(Date dataCancelaEvasao) {
        this.dataCancelaEvasao = dataCancelaEvasao;
    }

    /**
     * @return the tipoOperacaoCancelar
     */
    public int getTipoOperacaoCancelar() {
        return tipoOperacaoCancelar;
    }

    /**
     * @param tipoOperacaoCancelar the tipoOperacaoCancelar to set
     */
    public void setTipoOperacaoCancelar(int tipoOperacaoCancelar) {
        this.tipoOperacaoCancelar = tipoOperacaoCancelar;
    }

    /**
     * @return the descricaoOperacaoCancela
     */
    public String getDescricaoOperacaoCancela() {
        return descricaoOperacaoCancela;
    }

    /**
     * @param descricaoOperacaoCancela the descricaoOperacaoCancela to set
     */
    public void setDescricaoOperacaoCancela(String descricaoOperacaoCancela) {
        this.descricaoOperacaoCancela = descricaoOperacaoCancela;
    }

    /**
     * @return the nomeResponsavel
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * @param nomeResponsavel the nomeResponsavel to set
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /**
     * @return the cargoResponsavel
     */
    public String getCargoResponsavel() {
        return cargoResponsavel;
    }

    /**
     * @param cargoResponsavel the cargoResponsavel to set
     */
    public void setCargoResponsavel(String cargoResponsavel) {
        this.cargoResponsavel = cargoResponsavel;
    }

    /**
     * @return the numeroDocumentoCancela
     */
    public String getNumeroDocumentoCancela() {
        return numeroDocumentoCancela;
    }

    /**
     * @param numeroDocumentoCancela the numeroDocumentoCancela to set
     */
    public void setNumeroDocumentoCancela(String numeroDocumentoCancela) {
        this.numeroDocumentoCancela = numeroDocumentoCancela;
    }

    /**
     * @return the dataCancelamento
     */
    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    /**
     * @param dataCancelamento the dataCancelamento to set
     */
    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    /**
     * @return the motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * @param motivoCancelamento the motivoCancelamento to set
     */
    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
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
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the nrDocSaida
     */
    public String getNrDocSaida() {
        return nrDocSaida;
    }

    /**
     * @param nrDocSaida the nrDocSaida to set
     */
    public void setNrDocSaida(String nrDocSaida) {
        this.nrDocSaida = nrDocSaida;
    }

    /**
     * @return the tipoEvasao
     */
    public int getTipoEvasao() {
        return tipoEvasao;
    }

    /**
     * @param tipoEvasao the tipoEvasao to set
     */
    public void setTipoEvasao(int tipoEvasao) {
        this.tipoEvasao = tipoEvasao;
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
     * @return the maeInterno
     */
    public String getMaeInterno() {
        return maeInterno;
    }

    /**
     * @param maeInterno the maeInterno to set
     */
    public void setMaeInterno(String maeInterno) {
        this.maeInterno = maeInterno;
    }

    /**
     * @return the paiInterno
     */
    public String getPaiInterno() {
        return paiInterno;
    }

    /**
     * @param paiInterno the paiInterno to set
     */
    public void setPaiInterno(String paiInterno) {
        this.paiInterno = paiInterno;
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
     * @return the internoEvadido
     */
    public String getInternoEvadido() {
        return internoEvadido;
    }

    /**
     * @param internoEvadido the internoEvadido to set
     */
    public void setInternoEvadido(String internoEvadido) {
        this.internoEvadido = internoEvadido;
    }

    /**
     * @return the dataEvasao
     */
    public Date getDataEvasao() {
        return dataEvasao;
    }

    /**
     * @param dataEvasao the dataEvasao to set
     */
    public void setDataEvasao(Date dataEvasao) {
        this.dataEvasao = dataEvasao;
    }

    /**
     * @return the dataDocumento
     */
    public Date getDataDocumento() {
        return dataDocumento;
    }

    /**
     * @param dataDocumento the dataDocumento to set
     */
    public void setDataDocumento(Date dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horarioEntrada
     */
    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    /**
     * @return the qtdInt
     */
    public int getQtdInt() {
        return qtdInt;
    }

    /**
     * @param qtdInt the qtdInt to set
     */
    public void setQtdInt(int qtdInt) {
        this.qtdInt = qtdInt;
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
     * @return the assinaturaDigital
     */
    public byte[] getAssinaturaDigital() {
        return assinaturaDigital;
    }

    /**
     * @param assinaturaDigital the assinaturaDigital to set
     */
    public void setAssinaturaDigital(byte[] assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    /**
     * @return the idItemSaida
     */
    public int getIdItemSaida() {
        return idItemSaida;
    }

    /**
     * @param idItemSaida the idItemSaida to set
     */
    public void setIdItemSaida(int idItemSaida) {
        this.idItemSaida = idItemSaida;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the nomeDestino
     */
    public String getNomeDestino() {
        return nomeDestino;
    }

    /**
     * @param nomeDestino the nomeDestino to set
     */
    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the idInternoSaida
     */
    public int getIdInternoSaida() {
        return idInternoSaida;
    }

    /**
     * @param idInternoSaida the idInternoSaida to set
     */
    public void setIdInternoSaida(int idInternoSaida) {
        this.idInternoSaida = idInternoSaida;
    }

    /**
     * @return the confirmaRetorno
     */
    public String getConfirmaRetorno() {
        return confirmaRetorno;
    }

    /**
     * @param confirmaRetorno the confirmaRetorno to set
     */
    public void setConfirmaRetorno(String confirmaRetorno) {
        this.confirmaRetorno = confirmaRetorno;
    }

    /**
     * @return the confirmaEvasao
     */
    public String getConfirmaEvasao() {
        return confirmaEvasao;
    }

    /**
     * @param confirmaEvasao the confirmaEvasao to set
     */
    public void setConfirmaEvasao(String confirmaEvasao) {
        this.confirmaEvasao = confirmaEvasao;
    }

    /**
     * @return the confirmaSaida
     */
    public String getConfirmaSaida() {
        return confirmaSaida;
    }

    /**
     * @param confirmaSaida the confirmaSaida to set
     */
    public void setConfirmaSaida(String confirmaSaida) {
        this.confirmaSaida = confirmaSaida;
    }

    /**
     * @return the dataEvasaoTmp
     */
    public Date getDataEvasaoTmp() {
        return dataEvasaoTmp;
    }

    /**
     * @param dataEvasaoTmp the dataEvasaoTmp to set
     */
    public void setDataEvasaoTmp(Date dataEvasaoTmp) {
        this.dataEvasaoTmp = dataEvasaoTmp;
    }

    /**
     * @return the dataPrevRetorno
     */
    public Date getDataPrevRetorno() {
        return dataPrevRetorno;
    }

    /**
     * @param dataPrevRetorno the dataPrevRetorno to set
     */
    public void setDataPrevRetorno(Date dataPrevRetorno) {
        this.dataPrevRetorno = dataPrevRetorno;
    }

    /**
     * @return the obito
     */
    public String getObito() {
        return obito;
    }

    /**
     * @param obito the obito to set
     */
    public void setObito(String obito) {
        this.obito = obito;
    }

    /**
     * @return the confirmaObito
     */
    public String getConfirmaObito() {
        return confirmaObito;
    }

    /**
     * @param confirmaObito the confirmaObito to set
     */
    public void setConfirmaObito(String confirmaObito) {
        this.confirmaObito = confirmaObito;
    }

    /**
     * @return the kitInicial
     */
    public String getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(String kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitDecendial
     */
    public String getKitDecendial() {
        return kitDecendial;
    }

    /**
     * @param kitDecendial the kitDecendial to set
     */
    public void setKitDecendial(String kitDecendial) {
        this.kitDecendial = kitDecendial;
    }

    /**
     * @return the kitQuinzenal
     */
    public String getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(String kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the kitMensal
     */
    public String getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(String kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public String getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(String kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitAnual
     */
    public String getKitAnual() {
        return kitAnual;
    }

    /**
     * @param kitAnual the kitAnual to set
     */
    public void setKitAnual(String kitAnual) {
        this.kitAnual = kitAnual;
    }

    /**
     * @return the kitIPago
     */
    public String getKitIPago() {
        return kitIPago;
    }

    /**
     * @param kitIPago the kitIPago to set
     */
    public void setKitIPago(String kitIPago) {
        this.kitIPago = kitIPago;
    }

    /**
     * @return the kitDPago
     */
    public String getKitDPago() {
        return kitDPago;
    }

    /**
     * @param kitDPago the kitDPago to set
     */
    public void setKitDPago(String kitDPago) {
        this.kitDPago = kitDPago;
    }

    /**
     * @return the kitQPago
     */
    public String getKitQPago() {
        return kitQPago;
    }

    /**
     * @param kitQPago the kitQPago to set
     */
    public void setKitQPago(String kitQPago) {
        this.kitQPago = kitQPago;
    }

    /**
     * @return the kitMPago
     */
    public String getKitMPago() {
        return kitMPago;
    }

    /**
     * @param kitMPago the kitMPago to set
     */
    public void setKitMPago(String kitMPago) {
        this.kitMPago = kitMPago;
    }

    /**
     * @return the kitSPago
     */
    public String getKitSPago() {
        return kitSPago;
    }

    /**
     * @param kitSPago the kitSPago to set
     */
    public void setKitSPago(String kitSPago) {
        this.kitSPago = kitSPago;
    }

    /**
     * @return the kitAPago
     */
    public String getKitAPago() {
        return kitAPago;
    }

    /**
     * @param kitAPago the kitAPago to set
     */
    public void setKitAPago(String kitAPago) {
        this.kitAPago = kitAPago;
    }

    /**
     * @return the dataChegada
     */
    public Date getDataChegada() {
        return dataChegada;
    }

    /**
     * @param dataChegada the dataChegada to set
     */
    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    /**
     * @return the kitPago
     */
    public String getKitPago() {
        return kitPago;
    }

    /**
     * @param kitPago the kitPago to set
     */
    public void setKitPago(String kitPago) {
        this.kitPago = kitPago;
    }

    /**
     * @return the utilizado
     */
    public String getUtilizado() {
        return utilizado;
    }

    /**
     * @param utilizado the utilizado to set
     */
    public void setUtilizado(String utilizado) {
        this.utilizado = utilizado;
    }

    /**
     * @return the documentacaoCompleta
     */
    public String getDocumentacaoCompleta() {
        return documentacaoCompleta;
    }

    /**
     * @param documentacaoCompleta the documentacaoCompleta to set
     */
    public void setDocumentacaoCompleta(String documentacaoCompleta) {
        this.documentacaoCompleta = documentacaoCompleta;
    }

    /**
     * @return the quaisDocumentosFaltam
     */
    public String getQuaisDocumentosFaltam() {
        return quaisDocumentosFaltam;
    }

    /**
     * @param quaisDocumentosFaltam the quaisDocumentosFaltam to set
     */
    public void setQuaisDocumentosFaltam(String quaisDocumentosFaltam) {
        this.quaisDocumentosFaltam = quaisDocumentosFaltam;
    }

    /**
     * @return the idChek
     */
    public int getIdChek() {
        return idChek;
    }

    /**
     * @param idChek the idChek to set
     */
    public void setIdChek(int idChek) {
        this.idChek = idChek;
    }

    /**
     * @return the descricaoDoc
     */
    public String getDescricaoDoc() {
        return descricaoDoc;
    }

    /**
     * @param descricaoDoc the descricaoDoc to set
     */
    public void setDescricaoDoc(String descricaoDoc) {
        this.descricaoDoc = descricaoDoc;
    }

    /**
     * @return the regime
     */
    public String getRegime() {
        return regime;
    }

    /**
     * @param regime the regime to set
     */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    /**
     * @return the tornozeleira
     */
    public String getTornozeleira() {
        return tornozeleira;
    }

    /**
     * @param tornozeleira the tornozeleira to set
     */
    public void setTornozeleira(String tornozeleira) {
        this.tornozeleira = tornozeleira;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the qtdLanc
     */
    public int getQtdLanc() {
        return qtdLanc;
    }

    /**
     * @param qtdLanc the qtdLanc to set
     */
    public void setQtdLanc(int qtdLanc) {
        this.qtdLanc = qtdLanc;
    }

    /**
     * @return the dataRol
     */
    public Date getDataRol() {
        return dataRol;
    }

    /**
     * @param dataRol the dataRol to set
     */
    public void setDataRol(Date dataRol) {
        this.dataRol = dataRol;
    }

    /**
     * @return the statusRol
     */
    public String getStatusRol() {
        return statusRol;
    }

    /**
     * @param statusRol the statusRol to set
     */
    public void setStatusRol(String statusRol) {
        this.statusRol = statusRol;
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
     * @return the recebeVisita
     */
    public String getRecebeVisita() {
        return recebeVisita;
    }

    /**
     * @param recebeVisita the recebeVisita to set
     */
    public void setRecebeVisita(String recebeVisita) {
        this.recebeVisita = recebeVisita;
    }

    /**
     * @return the idInstituicao
     */
    public int getIdInstituicao() {
        return idInstituicao;
    }

    /**
     * @param idInstituicao the idInstituicao to set
     */
    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    /**
     * @return the nomeInstituicaoRel
     */
    public String getNomeInstituicaoRel() {
        return nomeInstituicaoRel;
    }

    /**
     * @param nomeInstituicaoRel the nomeInstituicaoRel to set
     */
    public void setNomeInstituicaoRel(String nomeInstituicaoRel) {
        this.nomeInstituicaoRel = nomeInstituicaoRel;
    }

    /**
     * @return the domingo
     */
    public int getDomingo() {
        return domingo;
    }

    /**
     * @param domingo the domingo to set
     */
    public void setDomingo(int domingo) {
        this.domingo = domingo;
    }

    /**
     * @return the segunda
     */
    public int getSegunda() {
        return segunda;
    }

    /**
     * @param segunda the segunda to set
     */
    public void setSegunda(int segunda) {
        this.segunda = segunda;
    }

    /**
     * @return the terca
     */
    public int getTerca() {
        return terca;
    }

    /**
     * @param terca the terca to set
     */
    public void setTerca(int terca) {
        this.terca = terca;
    }

    /**
     * @return the quarta
     */
    public int getQuarta() {
        return quarta;
    }

    /**
     * @param quarta the quarta to set
     */
    public void setQuarta(int quarta) {
        this.quarta = quarta;
    }

    /**
     * @return the quinta
     */
    public int getQuinta() {
        return quinta;
    }

    /**
     * @param quinta the quinta to set
     */
    public void setQuinta(int quinta) {
        this.quinta = quinta;
    }

    /**
     * @return the sexta
     */
    public int getSexta() {
        return sexta;
    }

    /**
     * @param sexta the sexta to set
     */
    public void setSexta(int sexta) {
        this.sexta = sexta;
    }

    /**
     * @return the sabado
     */
    public int getSabado() {
        return sabado;
    }

    /**
     * @param sabado the sabado to set
     */
    public void setSabado(int sabado) {
        this.sabado = sabado;
    }

    /**
     * @return the valorSaque
     */
    public float getValorSaque() {
        return valorSaque;
    }

    /**
     * @param valorSaque the valorSaque to set
     */
    public void setValorSaque(float valorSaque) {
        this.valorSaque = valorSaque;
    }

    /**
     * @return the favorecido
     */
    public String getFavorecido() {
        return favorecido;
    }

    /**
     * @param favorecido the favorecido to set
     */
    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    /**
     * @return the reciboSaque
     */
    public String getReciboSaque() {
        return reciboSaque;
    }

    /**
     * @param reciboSaque the reciboSaque to set
     */
    public void setReciboSaque(String reciboSaque) {
        this.reciboSaque = reciboSaque;
    }

    /**
     * @return the valorDeposito
     */
    public float getValorDeposito() {
        return valorDeposito;
    }

    /**
     * @param valorDeposito the valorDeposito to set
     */
    public void setValorDeposito(float valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    /**
     * @return the depositante
     */
    public String getDepositante() {
        return depositante;
    }

    /**
     * @param depositante the depositante to set
     */
    public void setDepositante(String depositante) {
        this.depositante = depositante;
    }

    /**
     * @return the efetuado
     */
    public String getEfetuado() {
        return efetuado;
    }

    /**
     * @param efetuado the efetuado to set
     */
    public void setEfetuado(String efetuado) {
        this.efetuado = efetuado;
    }

    /**
     * @return the dataLancMov
     */
    public Date getDataLancMov() {
        return dataLancMov;
    }

    /**
     * @param dataLancMov the dataLancMov to set
     */
    public void setDataLancMov(Date dataLancMov) {
        this.dataLancMov = dataLancMov;
    }

    /**
     * @return the idHist
     */
    public int getIdHist() {
        return idHist;
    }

    /**
     * @param idHist the idHist to set
     */
    public void setIdHist(int idHist) {
        this.idHist = idHist;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valorLiberado
     */
    public float getValorLiberado() {
        return valorLiberado;
    }

    /**
     * @param valorLiberado the valorLiberado to set
     */
    public void setValorLiberado(float valorLiberado) {
        this.valorLiberado = valorLiberado;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
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
     * @return the saldoAtual
     */
    public float getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    /**
     * @return the tipoTrans
     */
    public String getTipoTrans() {
        return tipoTrans;
    }

    /**
     * @param tipoTrans the tipoTrans to set
     */
    public void setTipoTrans(String tipoTrans) {
        this.tipoTrans = tipoTrans;
    }

    /**
     * @return the idRegistroEvasao
     */
    public Integer getIdRegistroEvasao() {
        return idRegistroEvasao;
    }

    /**
     * @param idRegistroEvasao the idRegistroEvasao to set
     */
    public void setIdRegistroEvasao(Integer idRegistroEvasao) {
        this.idRegistroEvasao = idRegistroEvasao;
    }

    /**
     * @return the idRegistroLabor
     */
    public Integer getIdRegistroLabor() {
        return idRegistroLabor;
    }

    /**
     * @param idRegistroLabor the idRegistroLabor to set
     */
    public void setIdRegistroLabor(Integer idRegistroLabor) {
        this.idRegistroLabor = idRegistroLabor;
    }

    /**
     * @return the idRegistroEduca
     */
    public Integer getIdRegistroEduca() {
        return idRegistroEduca;
    }

    /**
     * @param idRegistroEduca the idRegistroEduca to set
     */
    public void setIdRegistroEduca(Integer idRegistroEduca) {
        this.idRegistroEduca = idRegistroEduca;
    }

    /**
     * @return the idSaida
     */
    public Integer getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(Integer idSaida) {
        this.idSaida = idSaida;
    }

    /**
     * @return the idDeposito
     */
    public int getIdDeposito() {
        return idDeposito;
    }

    /**
     * @param idDeposito the idDeposito to set
     */
    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    /**
     * @return the idSaque
     */
    public int getIdSaque() {
        return idSaque;
    }

    /**
     * @param idSaque the idSaque to set
     */
    public void setIdSaque(int idSaque) {
        this.idSaque = idSaque;
    }

    /**
     * @return the idLancHist
     */
    public Integer getIdLancHist() {
        return idLancHist;
    }

    /**
     * @param idLancHist the idLancHist to set
     */
    public void setIdLancHist(Integer idLancHist) {
        this.idLancHist = idLancHist;
    }

    /**
     * @return the idLoca
     */
    public Integer getIdLoca() {
        return idLoca;
    }

    /**
     * @param idLoca the idLoca to set
     */
    public void setIdLoca(Integer idLoca) {
        this.idLoca = idLoca;
    }

    /**
     * @return the idCela
     */
    public Integer getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
