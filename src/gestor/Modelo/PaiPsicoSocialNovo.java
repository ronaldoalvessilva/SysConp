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
public class PaiPsicoSocialNovo {
    private int idPai;
    private String statusPai;
    private Date dataPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idadeInterno;
    private String OrientacaoSexual;
    private String dadosPessoais;
    private String municipioRegistrado;
    private String tipoOrientacaoSexual;
    private String documentoDelega;
    private String qualDocumento;
    private String qualDelegacia;
    private String regularizarDocumento;
    private String tipoDocumento;
    private String rGInternoPAI;
    private String emissor;
    private Date dataExpedicao;
    private String cPFInternoPAI;
    private String cartaoSUSPAI;
    private String tituloEleitor;
    private String zona;
    private String sessao;
    private String nIS;
    private String cTPS;
    private String serie;
    private String religiao;
    private String estadoCivil;
    private String endereco;
    private String complemento;
    private String referencia;
    private String bairro;
    private String cidade;
    private String estado;
    private String Naturalidade;
    private String telefone;
    private String telefone1;
    private String celular;          
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public PaiPsicoSocialNovo(int idPai, String statusPai, Date dataPai, int idInternoCrc, String nomeInternoCrc, int idadeInterno, String OrientacaoSexual, String dadosPessoais, String municipioRegistrado, String tipoOrientacaoSexual, String documentoDelega, String qualDocumento, String qualDelegacia, String regularizarDocumento, String tipoDocumento, String rGInternoPAI, String emissor, Date dataExpedicao, String cPFInternoPAI, String cartaoSUSPAI, String tituloEleitor, String zona, String sessao, String nIS, String cTPS, String serie, String religiao, String estadoCivil, String endereco, String complemento, String referencia, String bairro, String cidade, String estado, String Naturalidade, String telefone, String telefone1, String celular, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPai = idPai;
        this.statusPai = statusPai;
        this.dataPai = dataPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idadeInterno = idadeInterno;
        this.OrientacaoSexual = OrientacaoSexual;
        this.dadosPessoais = dadosPessoais;
        this.municipioRegistrado = municipioRegistrado;
        this.tipoOrientacaoSexual = tipoOrientacaoSexual;
        this.documentoDelega = documentoDelega;
        this.qualDocumento = qualDocumento;
        this.qualDelegacia = qualDelegacia;
        this.regularizarDocumento = regularizarDocumento;
        this.tipoDocumento = tipoDocumento;
        this.rGInternoPAI = rGInternoPAI;
        this.emissor = emissor;
        this.dataExpedicao = dataExpedicao;
        this.cPFInternoPAI = cPFInternoPAI;
        this.cartaoSUSPAI = cartaoSUSPAI;
        this.tituloEleitor = tituloEleitor;
        this.zona = zona;
        this.sessao = sessao;
        this.nIS = nIS;
        this.cTPS = cTPS;
        this.serie = serie;
        this.religiao = religiao;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.complemento = complemento;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.Naturalidade = Naturalidade;
        this.telefone = telefone;
        this.telefone1 = telefone1;
        this.celular = celular;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PaiPsicoSocialNovo() {
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
     * @return the statusPai
     */
    public String getStatusPai() {
        return statusPai;
    }

    /**
     * @param statusPai the statusPai to set
     */
    public void setStatusPai(String statusPai) {
        this.statusPai = statusPai;
    }

    /**
     * @return the dataPai
     */
    public Date getDataPai() {
        return dataPai;
    }

    /**
     * @param dataPai the dataPai to set
     */
    public void setDataPai(Date dataPai) {
        this.dataPai = dataPai;
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
     * @return the idadeInterno
     */
    public int getIdadeInterno() {
        return idadeInterno;
    }

    /**
     * @param idadeInterno the idadeInterno to set
     */
    public void setIdadeInterno(int idadeInterno) {
        this.idadeInterno = idadeInterno;
    }

    /**
     * @return the OrientacaoSexual
     */
    public String getOrientacaoSexual() {
        return OrientacaoSexual;
    }

    /**
     * @param OrientacaoSexual the OrientacaoSexual to set
     */
    public void setOrientacaoSexual(String OrientacaoSexual) {
        this.OrientacaoSexual = OrientacaoSexual;
    }

    /**
     * @return the dadosPessoais
     */
    public String getDadosPessoais() {
        return dadosPessoais;
    }

    /**
     * @param dadosPessoais the dadosPessoais to set
     */
    public void setDadosPessoais(String dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    /**
     * @return the municipioRegistrado
     */
    public String getMunicipioRegistrado() {
        return municipioRegistrado;
    }

    /**
     * @param municipioRegistrado the municipioRegistrado to set
     */
    public void setMunicipioRegistrado(String municipioRegistrado) {
        this.municipioRegistrado = municipioRegistrado;
    }

    /**
     * @return the tipoOrientacaoSexual
     */
    public String getTipoOrientacaoSexual() {
        return tipoOrientacaoSexual;
    }

    /**
     * @param tipoOrientacaoSexual the tipoOrientacaoSexual to set
     */
    public void setTipoOrientacaoSexual(String tipoOrientacaoSexual) {
        this.tipoOrientacaoSexual = tipoOrientacaoSexual;
    }

    /**
     * @return the documentoDelega
     */
    public String getDocumentoDelega() {
        return documentoDelega;
    }

    /**
     * @param documentoDelega the documentoDelega to set
     */
    public void setDocumentoDelega(String documentoDelega) {
        this.documentoDelega = documentoDelega;
    }

    /**
     * @return the qualDocumento
     */
    public String getQualDocumento() {
        return qualDocumento;
    }

    /**
     * @param qualDocumento the qualDocumento to set
     */
    public void setQualDocumento(String qualDocumento) {
        this.qualDocumento = qualDocumento;
    }

    /**
     * @return the qualDelegacia
     */
    public String getQualDelegacia() {
        return qualDelegacia;
    }

    /**
     * @param qualDelegacia the qualDelegacia to set
     */
    public void setQualDelegacia(String qualDelegacia) {
        this.qualDelegacia = qualDelegacia;
    }

    /**
     * @return the regularizarDocumento
     */
    public String getRegularizarDocumento() {
        return regularizarDocumento;
    }

    /**
     * @param regularizarDocumento the regularizarDocumento to set
     */
    public void setRegularizarDocumento(String regularizarDocumento) {
        this.regularizarDocumento = regularizarDocumento;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the rGInternoPAI
     */
    public String getrGInternoPAI() {
        return rGInternoPAI;
    }

    /**
     * @param rGInternoPAI the rGInternoPAI to set
     */
    public void setrGInternoPAI(String rGInternoPAI) {
        this.rGInternoPAI = rGInternoPAI;
    }

    /**
     * @return the emissor
     */
    public String getEmissor() {
        return emissor;
    }

    /**
     * @param emissor the emissor to set
     */
    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    /**
     * @return the dataExpedicao
     */
    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * @param dataExpedicao the dataExpedicao to set
     */
    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    /**
     * @return the cPFInternoPAI
     */
    public String getcPFInternoPAI() {
        return cPFInternoPAI;
    }

    /**
     * @param cPFInternoPAI the cPFInternoPAI to set
     */
    public void setcPFInternoPAI(String cPFInternoPAI) {
        this.cPFInternoPAI = cPFInternoPAI;
    }

    /**
     * @return the cartaoSUSPAI
     */
    public String getCartaoSUSPAI() {
        return cartaoSUSPAI;
    }

    /**
     * @param cartaoSUSPAI the cartaoSUSPAI to set
     */
    public void setCartaoSUSPAI(String cartaoSUSPAI) {
        this.cartaoSUSPAI = cartaoSUSPAI;
    }

    /**
     * @return the tituloEleitor
     */
    public String getTituloEleitor() {
        return tituloEleitor;
    }

    /**
     * @param tituloEleitor the tituloEleitor to set
     */
    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * @return the sessao
     */
    public String getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the nIS
     */
    public String getnIS() {
        return nIS;
    }

    /**
     * @param nIS the nIS to set
     */
    public void setnIS(String nIS) {
        this.nIS = nIS;
    }

    /**
     * @return the cTPS
     */
    public String getcTPS() {
        return cTPS;
    }

    /**
     * @param cTPS the cTPS to set
     */
    public void setcTPS(String cTPS) {
        this.cTPS = cTPS;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
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
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the Naturalidade
     */
    public String getNaturalidade() {
        return Naturalidade;
    }

    /**
     * @param Naturalidade the Naturalidade to set
     */
    public void setNaturalidade(String Naturalidade) {
        this.Naturalidade = Naturalidade;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
