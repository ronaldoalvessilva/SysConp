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
public class VisitaInterno {

    private int idVisita;
    private String statusVisita;
    private String foto;
    private String nomeVisita;
    private String parentescoVisita;
    private Date dataNascVisita;
    private String sexoVisita;
    private Date dataCadVisita;
    private Date dataAntecedente;
    private String adultoCrianca;
    private String visitaIntima;
    private String rg;
    private String emissor;
    private String cpf;
    private String enderecoVisita;
    private String bairroVisita;
    private String cidadeVisita;
    private String cepVisita;
    private String estadoVisita;
    private String telefoneVisita;
    private String telefone1Visita;
    private String celularVisita;
    private String celular1Visita;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;
    private String nacionalidade;
    private Date dataEmissao;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4;    

    public VisitaInterno(int idVisita, String statusVisita, String foto, String nomeVisita, String parentescoVisita, Date dataNascVisita, String sexoVisita, Date dataCadVisita, Date dataAntecedente, String adultoCrianca, String visitaIntima, String rg, String emissor, String cpf, String enderecoVisita, String bairroVisita, String cidadeVisita, String cepVisita, String estadoVisita, String telefoneVisita, String telefone1Visita, String celularVisita, String celular1Visita, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String nacionalidade, Date dataEmissao, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4) {
        this.idVisita = idVisita;
        this.statusVisita = statusVisita;
        this.foto = foto;
        this.nomeVisita = nomeVisita;
        this.parentescoVisita = parentescoVisita;
        this.dataNascVisita = dataNascVisita;
        this.sexoVisita = sexoVisita;
        this.dataCadVisita = dataCadVisita;
        this.dataAntecedente = dataAntecedente;
        this.adultoCrianca = adultoCrianca;
        this.visitaIntima = visitaIntima;
        this.rg = rg;
        this.emissor = emissor;
        this.cpf = cpf;
        this.enderecoVisita = enderecoVisita;
        this.bairroVisita = bairroVisita;
        this.cidadeVisita = cidadeVisita;
        this.cepVisita = cepVisita;
        this.estadoVisita = estadoVisita;
        this.telefoneVisita = telefoneVisita;
        this.telefone1Visita = telefone1Visita;
        this.celularVisita = celularVisita;
        this.celular1Visita = celular1Visita;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.nacionalidade = nacionalidade;
        this.dataEmissao = dataEmissao;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
    }

    public VisitaInterno() {
    }

    /**
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the statusVisita
     */
    public String getStatusVisita() {
        return statusVisita;
    }

    /**
     * @param statusVisita the statusVisita to set
     */
    public void setStatusVisita(String statusVisita) {
        this.statusVisita = statusVisita;
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
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    /**
     * @return the parentescoVisita
     */
    public String getParentescoVisita() {
        return parentescoVisita;
    }

    /**
     * @param parentescoVisita the parentescoVisita to set
     */
    public void setParentescoVisita(String parentescoVisita) {
        this.parentescoVisita = parentescoVisita;
    }

    /**
     * @return the dataNascVisita
     */
    public Date getDataNascVisita() {
        return dataNascVisita;
    }

    /**
     * @param dataNascVisita the dataNascVisita to set
     */
    public void setDataNascVisita(Date dataNascVisita) {
        this.dataNascVisita = dataNascVisita;
    }

    /**
     * @return the sexoVisita
     */
    public String getSexoVisita() {
        return sexoVisita;
    }

    /**
     * @param sexoVisita the sexoVisita to set
     */
    public void setSexoVisita(String sexoVisita) {
        this.sexoVisita = sexoVisita;
    }

    /**
     * @return the dataCadVisita
     */
    public Date getDataCadVisita() {
        return dataCadVisita;
    }

    /**
     * @param dataCadVisita the dataCadVisita to set
     */
    public void setDataCadVisita(Date dataCadVisita) {
        this.dataCadVisita = dataCadVisita;
    }

    /**
     * @return the dataAntecedente
     */
    public Date getDataAntecedente() {
        return dataAntecedente;
    }

    /**
     * @param dataAntecedente the dataAntecedente to set
     */
    public void setDataAntecedente(Date dataAntecedente) {
        this.dataAntecedente = dataAntecedente;
    }

    /**
     * @return the adultoCrianca
     */
    public String getAdultoCrianca() {
        return adultoCrianca;
    }

    /**
     * @param adultoCrianca the adultoCrianca to set
     */
    public void setAdultoCrianca(String adultoCrianca) {
        this.adultoCrianca = adultoCrianca;
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
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the enderecoVisita
     */
    public String getEnderecoVisita() {
        return enderecoVisita;
    }

    /**
     * @param enderecoVisita the enderecoVisita to set
     */
    public void setEnderecoVisita(String enderecoVisita) {
        this.enderecoVisita = enderecoVisita;
    }

    /**
     * @return the bairroVisita
     */
    public String getBairroVisita() {
        return bairroVisita;
    }

    /**
     * @param bairroVisita the bairroVisita to set
     */
    public void setBairroVisita(String bairroVisita) {
        this.bairroVisita = bairroVisita;
    }

    /**
     * @return the cidadeVisita
     */
    public String getCidadeVisita() {
        return cidadeVisita;
    }

    /**
     * @param cidadeVisita the cidadeVisita to set
     */
    public void setCidadeVisita(String cidadeVisita) {
        this.cidadeVisita = cidadeVisita;
    }

    /**
     * @return the cepVisita
     */
    public String getCepVisita() {
        return cepVisita;
    }

    /**
     * @param cepVisita the cepVisita to set
     */
    public void setCepVisita(String cepVisita) {
        this.cepVisita = cepVisita;
    }

    /**
     * @return the estadoVisita
     */
    public String getEstadoVisita() {
        return estadoVisita;
    }

    /**
     * @param estadoVisita the estadoVisita to set
     */
    public void setEstadoVisita(String estadoVisita) {
        this.estadoVisita = estadoVisita;
    }

    /**
     * @return the telefoneVisita
     */
    public String getTelefoneVisita() {
        return telefoneVisita;
    }

    /**
     * @param telefoneVisita the telefoneVisita to set
     */
    public void setTelefoneVisita(String telefoneVisita) {
        this.telefoneVisita = telefoneVisita;
    }

    /**
     * @return the telefone1Visita
     */
    public String getTelefone1Visita() {
        return telefone1Visita;
    }

    /**
     * @param telefone1Visita the telefone1Visita to set
     */
    public void setTelefone1Visita(String telefone1Visita) {
        this.telefone1Visita = telefone1Visita;
    }

    /**
     * @return the celularVisita
     */
    public String getCelularVisita() {
        return celularVisita;
    }

    /**
     * @param celularVisita the celularVisita to set
     */
    public void setCelularVisita(String celularVisita) {
        this.celularVisita = celularVisita;
    }

    /**
     * @return the celular1Visita
     */
    public String getCelular1Visita() {
        return celular1Visita;
    }

    /**
     * @param celular1Visita the celular1Visita to set
     */
    public void setCelular1Visita(String celular1Visita) {
        this.celular1Visita = celular1Visita;
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
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the biometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return biometriaDedo1;
    }

    /**
     * @param biometriaDedo1 the biometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] biometriaDedo1) {
        this.biometriaDedo1 = biometriaDedo1;
    }

    /**
     * @return the biometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return biometriaDedo2;
    }

    /**
     * @param biometriaDedo2 the biometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] biometriaDedo2) {
        this.biometriaDedo2 = biometriaDedo2;
    }

    /**
     * @return the biometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return biometriaDedo3;
    }

    /**
     * @param biometriaDedo3 the biometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] biometriaDedo3) {
        this.biometriaDedo3 = biometriaDedo3;
    }

    /**
     * @return the biometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return biometriaDedo4;
    }

    /**
     * @param biometriaDedo4 the biometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] biometriaDedo4) {
        this.biometriaDedo4 = biometriaDedo4;
    }
}
