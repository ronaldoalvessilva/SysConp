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
public class ColaboradoresTransferenciasUnidades {

    private int idFunc;
    private String statusFunc;
    private Date dataCadastro;
    private String foto;
    private String nomeFuncionario;
    private String sexo;
    private String escolaridade;
    private String matricula;
    private int idCargo;
    private String nomeCargo;
    private int idDepartamento;
    private String nomeDepartamento;
    private String estadoCivil;
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private String religiao;
    private String tipoSangue;
    private String cargaHoraria;
    private String regimeTrabalho;
    private String horarioInicio;
    private String horarioFinal;
    private String funcao;
    private String nacionalidade;
    private String pais;
    private String naturalidade;
    private String estadoNacionalidade;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private byte[] imagemFrenteCO;
    private boolean statusDepartamento;
    private int numeroSala;
    private boolean StatusCargo;
    private int idEnd;
    private String nomeFunc;
    private String endereco;
    private String bairroEnd;
    private String compEnd;
    private String cidadeEnd;
    private String estadoEnd;
    private String cepEnd;
    private String foneEnd;
    private String telEnd;
    private String celEnd;
    private String emalEnd;
    private String emailEndEmp;
    private String url;
    private String observacao;
    private int idDoc;
    private String rgDoc;
    private Date dataEmissaoDoc;
    private String orgaoDoc;
    private String estadoOrgao;
    private String cpfDoc;
    private String pisDoc;
    private Date dataCadPisDoc;
    private String tituloDoc;
    private String zonaDoc;
    private String secaoDoc;
    private String ctpsDoc;
    private String serieDoc;
    private String habiliDoc;
    private String reserVistaDoc;
    private String cateDoc;
    private String cartSaudeDoc;
    private String profDoc;
    private String alturaDoc;
    private String pesoDoc;
    private String calcaDoc;
    private String camisaDoc;
    private String sapatoDoc;
    private String carteiraDoc;
    private String tipoConjugue;
    private Date dataNasConjugue;
    private String nomeConjugue;

    public ColaboradoresTransferenciasUnidades() {
    }

    public ColaboradoresTransferenciasUnidades(int idFunc, String statusFunc, Date dataCadastro, String foto, String nomeFuncionario, String sexo, String escolaridade, String matricula, int idCargo, String nomeCargo, int idDepartamento, String nomeDepartamento, String estadoCivil, Date dataNascimento, String nomeMae, String nomePai, String religiao, String tipoSangue, String cargaHoraria, String regimeTrabalho, String horarioInicio, String horarioFinal, String funcao, String nacionalidade, String pais, String naturalidade, String estadoNacionalidade, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, byte[] imagemFrenteCO, boolean statusDepartamento, int numeroSala, boolean StatusCargo, int idEnd, String nomeFunc, String endereco, String bairroEnd, String compEnd, String cidadeEnd, String estadoEnd, String cepEnd, String foneEnd, String telEnd, String celEnd, String emalEnd, String emailEndEmp, String url, String observacao, int idDoc, String rgDoc, Date dataEmissaoDoc, String orgaoDoc, String estadoOrgao, String cpfDoc, String pisDoc, Date dataCadPisDoc, String tituloDoc, String zonaDoc, String secaoDoc, String ctpsDoc, String serieDoc, String habiliDoc, String reserVistaDoc, String cateDoc, String cartSaudeDoc, String profDoc, String alturaDoc, String pesoDoc, String calcaDoc, String camisaDoc, String sapatoDoc, String carteiraDoc, String tipoConjugue, Date dataNasConjugue, String nomeConjugue) {
        this.idFunc = idFunc;
        this.statusFunc = statusFunc;
        this.dataCadastro = dataCadastro;
        this.foto = foto;
        this.nomeFuncionario = nomeFuncionario;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.matricula = matricula;
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.religiao = religiao;
        this.tipoSangue = tipoSangue;
        this.cargaHoraria = cargaHoraria;
        this.regimeTrabalho = regimeTrabalho;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.funcao = funcao;
        this.nacionalidade = nacionalidade;
        this.pais = pais;
        this.naturalidade = naturalidade;
        this.estadoNacionalidade = estadoNacionalidade;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.imagemFrenteCO = imagemFrenteCO;
        this.statusDepartamento = statusDepartamento;
        this.numeroSala = numeroSala;
        this.StatusCargo = StatusCargo;
        this.idEnd = idEnd;
        this.nomeFunc = nomeFunc;
        this.endereco = endereco;
        this.bairroEnd = bairroEnd;
        this.compEnd = compEnd;
        this.cidadeEnd = cidadeEnd;
        this.estadoEnd = estadoEnd;
        this.cepEnd = cepEnd;
        this.foneEnd = foneEnd;
        this.telEnd = telEnd;
        this.celEnd = celEnd;
        this.emalEnd = emalEnd;
        this.emailEndEmp = emailEndEmp;
        this.url = url;
        this.observacao = observacao;
        this.idDoc = idDoc;
        this.rgDoc = rgDoc;
        this.dataEmissaoDoc = dataEmissaoDoc;
        this.orgaoDoc = orgaoDoc;
        this.estadoOrgao = estadoOrgao;
        this.cpfDoc = cpfDoc;
        this.pisDoc = pisDoc;
        this.dataCadPisDoc = dataCadPisDoc;
        this.tituloDoc = tituloDoc;
        this.zonaDoc = zonaDoc;
        this.secaoDoc = secaoDoc;
        this.ctpsDoc = ctpsDoc;
        this.serieDoc = serieDoc;
        this.habiliDoc = habiliDoc;
        this.reserVistaDoc = reserVistaDoc;
        this.cateDoc = cateDoc;
        this.cartSaudeDoc = cartSaudeDoc;
        this.profDoc = profDoc;
        this.alturaDoc = alturaDoc;
        this.pesoDoc = pesoDoc;
        this.calcaDoc = calcaDoc;
        this.camisaDoc = camisaDoc;
        this.sapatoDoc = sapatoDoc;
        this.carteiraDoc = carteiraDoc;
        this.tipoConjugue = tipoConjugue;
        this.dataNasConjugue = dataNasConjugue;
        this.nomeConjugue = nomeConjugue;
    }

    /**
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the statusFunc
     */
    public String getStatusFunc() {
        return statusFunc;
    }

    /**
     * @param statusFunc the statusFunc to set
     */
    public void setStatusFunc(String statusFunc) {
        this.statusFunc = statusFunc;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the nomeCargo
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * @param nomeCargo the nomeCargo to set
     */
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the religiao
     */
    public String getReligiao() {
        return religiao;
    }

    /**
     * @param religiao the religiao to set
     */
    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    /**
     * @return the tipoSangue
     */
    public String getTipoSangue() {
        return tipoSangue;
    }

    /**
     * @param tipoSangue the tipoSangue to set
     */
    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the regimeTrabalho
     */
    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }

    /**
     * @param regimeTrabalho the regimeTrabalho to set
     */
    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    /**
     * @return the horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioFinal
     */
    public String getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @return the estadoNacionalidade
     */
    public String getEstadoNacionalidade() {
        return estadoNacionalidade;
    }

    /**
     * @param estadoNacionalidade the estadoNacionalidade to set
     */
    public void setEstadoNacionalidade(String estadoNacionalidade) {
        this.estadoNacionalidade = estadoNacionalidade;
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
     * @return the imagemFrenteCO
     */
    public byte[] getImagemFrenteCO() {
        return imagemFrenteCO;
    }

    /**
     * @param imagemFrenteCO the imagemFrenteCO to set
     */
    public void setImagemFrenteCO(byte[] imagemFrenteCO) {
        this.imagemFrenteCO = imagemFrenteCO;
    }

    /**
     * @return the statusDepartamento
     */
    public boolean isStatusDepartamento() {
        return statusDepartamento;
    }

    /**
     * @param statusDepartamento the statusDepartamento to set
     */
    public void setStatusDepartamento(boolean statusDepartamento) {
        this.statusDepartamento = statusDepartamento;
    }

    /**
     * @return the numeroSala
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param numeroSala the numeroSala to set
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * @return the StatusCargo
     */
    public boolean isStatusCargo() {
        return StatusCargo;
    }

    /**
     * @param StatusCargo the StatusCargo to set
     */
    public void setStatusCargo(boolean StatusCargo) {
        this.StatusCargo = StatusCargo;
    }

    /**
     * @return the idEnd
     */
    public int getIdEnd() {
        return idEnd;
    }

    /**
     * @param idEnd the idEnd to set
     */
    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
    }

    /**
     * @return the nomeFunc
     */
    public String getNomeFunc() {
        return nomeFunc;
    }

    /**
     * @param nomeFunc the nomeFunc to set
     */
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairroEnd
     */
    public String getBairroEnd() {
        return bairroEnd;
    }

    /**
     * @param bairroEnd the bairroEnd to set
     */
    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    /**
     * @return the compEnd
     */
    public String getCompEnd() {
        return compEnd;
    }

    /**
     * @param compEnd the compEnd to set
     */
    public void setCompEnd(String compEnd) {
        this.compEnd = compEnd;
    }

    /**
     * @return the cidadeEnd
     */
    public String getCidadeEnd() {
        return cidadeEnd;
    }

    /**
     * @param cidadeEnd the cidadeEnd to set
     */
    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    /**
     * @return the estadoEnd
     */
    public String getEstadoEnd() {
        return estadoEnd;
    }

    /**
     * @param estadoEnd the estadoEnd to set
     */
    public void setEstadoEnd(String estadoEnd) {
        this.estadoEnd = estadoEnd;
    }

    /**
     * @return the cepEnd
     */
    public String getCepEnd() {
        return cepEnd;
    }

    /**
     * @param cepEnd the cepEnd to set
     */
    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    /**
     * @return the foneEnd
     */
    public String getFoneEnd() {
        return foneEnd;
    }

    /**
     * @param foneEnd the foneEnd to set
     */
    public void setFoneEnd(String foneEnd) {
        this.foneEnd = foneEnd;
    }

    /**
     * @return the telEnd
     */
    public String getTelEnd() {
        return telEnd;
    }

    /**
     * @param telEnd the telEnd to set
     */
    public void setTelEnd(String telEnd) {
        this.telEnd = telEnd;
    }

    /**
     * @return the celEnd
     */
    public String getCelEnd() {
        return celEnd;
    }

    /**
     * @param celEnd the celEnd to set
     */
    public void setCelEnd(String celEnd) {
        this.celEnd = celEnd;
    }

    /**
     * @return the emalEnd
     */
    public String getEmalEnd() {
        return emalEnd;
    }

    /**
     * @param emalEnd the emalEnd to set
     */
    public void setEmalEnd(String emalEnd) {
        this.emalEnd = emalEnd;
    }

    /**
     * @return the emailEndEmp
     */
    public String getEmailEndEmp() {
        return emailEndEmp;
    }

    /**
     * @param emailEndEmp the emailEndEmp to set
     */
    public void setEmailEndEmp(String emailEndEmp) {
        this.emailEndEmp = emailEndEmp;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return the idDoc
     */
    public int getIdDoc() {
        return idDoc;
    }

    /**
     * @param idDoc the idDoc to set
     */
    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * @return the rgDoc
     */
    public String getRgDoc() {
        return rgDoc;
    }

    /**
     * @param rgDoc the rgDoc to set
     */
    public void setRgDoc(String rgDoc) {
        this.rgDoc = rgDoc;
    }

    /**
     * @return the dataEmissaoDoc
     */
    public Date getDataEmissaoDoc() {
        return dataEmissaoDoc;
    }

    /**
     * @param dataEmissaoDoc the dataEmissaoDoc to set
     */
    public void setDataEmissaoDoc(Date dataEmissaoDoc) {
        this.dataEmissaoDoc = dataEmissaoDoc;
    }

    /**
     * @return the orgaoDoc
     */
    public String getOrgaoDoc() {
        return orgaoDoc;
    }

    /**
     * @param orgaoDoc the orgaoDoc to set
     */
    public void setOrgaoDoc(String orgaoDoc) {
        this.orgaoDoc = orgaoDoc;
    }

    /**
     * @return the estadoOrgao
     */
    public String getEstadoOrgao() {
        return estadoOrgao;
    }

    /**
     * @param estadoOrgao the estadoOrgao to set
     */
    public void setEstadoOrgao(String estadoOrgao) {
        this.estadoOrgao = estadoOrgao;
    }

    /**
     * @return the cpfDoc
     */
    public String getCpfDoc() {
        return cpfDoc;
    }

    /**
     * @param cpfDoc the cpfDoc to set
     */
    public void setCpfDoc(String cpfDoc) {
        this.cpfDoc = cpfDoc;
    }

    /**
     * @return the pisDoc
     */
    public String getPisDoc() {
        return pisDoc;
    }

    /**
     * @param pisDoc the pisDoc to set
     */
    public void setPisDoc(String pisDoc) {
        this.pisDoc = pisDoc;
    }

    /**
     * @return the dataCadPisDoc
     */
    public Date getDataCadPisDoc() {
        return dataCadPisDoc;
    }

    /**
     * @param dataCadPisDoc the dataCadPisDoc to set
     */
    public void setDataCadPisDoc(Date dataCadPisDoc) {
        this.dataCadPisDoc = dataCadPisDoc;
    }

    /**
     * @return the tituloDoc
     */
    public String getTituloDoc() {
        return tituloDoc;
    }

    /**
     * @param tituloDoc the tituloDoc to set
     */
    public void setTituloDoc(String tituloDoc) {
        this.tituloDoc = tituloDoc;
    }

    /**
     * @return the zonaDoc
     */
    public String getZonaDoc() {
        return zonaDoc;
    }

    /**
     * @param zonaDoc the zonaDoc to set
     */
    public void setZonaDoc(String zonaDoc) {
        this.zonaDoc = zonaDoc;
    }

    /**
     * @return the secaoDoc
     */
    public String getSecaoDoc() {
        return secaoDoc;
    }

    /**
     * @param secaoDoc the secaoDoc to set
     */
    public void setSecaoDoc(String secaoDoc) {
        this.secaoDoc = secaoDoc;
    }

    /**
     * @return the ctpsDoc
     */
    public String getCtpsDoc() {
        return ctpsDoc;
    }

    /**
     * @param ctpsDoc the ctpsDoc to set
     */
    public void setCtpsDoc(String ctpsDoc) {
        this.ctpsDoc = ctpsDoc;
    }

    /**
     * @return the serieDoc
     */
    public String getSerieDoc() {
        return serieDoc;
    }

    /**
     * @param serieDoc the serieDoc to set
     */
    public void setSerieDoc(String serieDoc) {
        this.serieDoc = serieDoc;
    }

    /**
     * @return the habiliDoc
     */
    public String getHabiliDoc() {
        return habiliDoc;
    }

    /**
     * @param habiliDoc the habiliDoc to set
     */
    public void setHabiliDoc(String habiliDoc) {
        this.habiliDoc = habiliDoc;
    }

    /**
     * @return the reserVistaDoc
     */
    public String getReserVistaDoc() {
        return reserVistaDoc;
    }

    /**
     * @param reserVistaDoc the reserVistaDoc to set
     */
    public void setReserVistaDoc(String reserVistaDoc) {
        this.reserVistaDoc = reserVistaDoc;
    }

    /**
     * @return the cateDoc
     */
    public String getCateDoc() {
        return cateDoc;
    }

    /**
     * @param cateDoc the cateDoc to set
     */
    public void setCateDoc(String cateDoc) {
        this.cateDoc = cateDoc;
    }

    /**
     * @return the cartSaudeDoc
     */
    public String getCartSaudeDoc() {
        return cartSaudeDoc;
    }

    /**
     * @param cartSaudeDoc the cartSaudeDoc to set
     */
    public void setCartSaudeDoc(String cartSaudeDoc) {
        this.cartSaudeDoc = cartSaudeDoc;
    }

    /**
     * @return the profDoc
     */
    public String getProfDoc() {
        return profDoc;
    }

    /**
     * @param profDoc the profDoc to set
     */
    public void setProfDoc(String profDoc) {
        this.profDoc = profDoc;
    }

    /**
     * @return the alturaDoc
     */
    public String getAlturaDoc() {
        return alturaDoc;
    }

    /**
     * @param alturaDoc the alturaDoc to set
     */
    public void setAlturaDoc(String alturaDoc) {
        this.alturaDoc = alturaDoc;
    }

    /**
     * @return the pesoDoc
     */
    public String getPesoDoc() {
        return pesoDoc;
    }

    /**
     * @param pesoDoc the pesoDoc to set
     */
    public void setPesoDoc(String pesoDoc) {
        this.pesoDoc = pesoDoc;
    }

    /**
     * @return the calcaDoc
     */
    public String getCalcaDoc() {
        return calcaDoc;
    }

    /**
     * @param calcaDoc the calcaDoc to set
     */
    public void setCalcaDoc(String calcaDoc) {
        this.calcaDoc = calcaDoc;
    }

    /**
     * @return the camisaDoc
     */
    public String getCamisaDoc() {
        return camisaDoc;
    }

    /**
     * @param camisaDoc the camisaDoc to set
     */
    public void setCamisaDoc(String camisaDoc) {
        this.camisaDoc = camisaDoc;
    }

    /**
     * @return the sapatoDoc
     */
    public String getSapatoDoc() {
        return sapatoDoc;
    }

    /**
     * @param sapatoDoc the sapatoDoc to set
     */
    public void setSapatoDoc(String sapatoDoc) {
        this.sapatoDoc = sapatoDoc;
    }

    /**
     * @return the carteiraDoc
     */
    public String getCarteiraDoc() {
        return carteiraDoc;
    }

    /**
     * @param carteiraDoc the carteiraDoc to set
     */
    public void setCarteiraDoc(String carteiraDoc) {
        this.carteiraDoc = carteiraDoc;
    }

    /**
     * @return the tipoConjugue
     */
    public String getTipoConjugue() {
        return tipoConjugue;
    }

    /**
     * @param tipoConjugue the tipoConjugue to set
     */
    public void setTipoConjugue(String tipoConjugue) {
        this.tipoConjugue = tipoConjugue;
    }

    /**
     * @return the dataNasConjugue
     */
    public Date getDataNasConjugue() {
        return dataNasConjugue;
    }

    /**
     * @param dataNasConjugue the dataNasConjugue to set
     */
    public void setDataNasConjugue(Date dataNasConjugue) {
        this.dataNasConjugue = dataNasConjugue;
    }

    /**
     * @return the nomeConjugue
     */
    public String getNomeConjugue() {
        return nomeConjugue;
    }

    /**
     * @param nomeConjugue the nomeConjugue to set
     */
    public void setNomeConjugue(String nomeConjugue) {
        this.nomeConjugue = nomeConjugue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idFunc;
        hash = 79 * hash + this.idCargo;
        hash = 79 * hash + this.idDepartamento;
        hash = 79 * hash + this.idEnd;
        hash = 79 * hash + this.idDoc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColaboradoresTransferenciasUnidades other = (ColaboradoresTransferenciasUnidades) obj;
        if (this.idFunc != other.idFunc) {
            return false;
        }
        if (this.idCargo != other.idCargo) {
            return false;
        }
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        if (this.idEnd != other.idEnd) {
            return false;
        }
        if (this.idDoc != other.idDoc) {
            return false;
        }
        return true;
    }
}
