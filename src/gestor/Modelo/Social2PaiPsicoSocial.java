/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class Social2PaiPsicoSocial {

    private int idFamiliar;
    private String nomeFamiliar;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;    
    private String vinculo;
    private int idade;
    private String ocupacao;
    private String enderecoTelefonePAI;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public Social2PaiPsicoSocial(int idFamiliar, String nomeFamiliar, int idPai, int idInternoCrc, String nomeInternoCrc, String vinculo, int idade, String ocupacao, String enderecoTelefonePAI, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFamiliar = idFamiliar;
        this.nomeFamiliar = nomeFamiliar;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.vinculo = vinculo;
        this.idade = idade;
        this.ocupacao = ocupacao;
        this.enderecoTelefonePAI = enderecoTelefonePAI;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Social2PaiPsicoSocial() {
    }

    /**
     * @return the idFamiliar
     */
    public int getIdFamiliar() {
        return idFamiliar;
    }

    /**
     * @param idFamiliar the idFamiliar to set
     */
    public void setIdFamiliar(int idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    /**
     * @return the nomeFamiliar
     */
    public String getNomeFamiliar() {
        return nomeFamiliar;
    }

    /**
     * @param nomeFamiliar the nomeFamiliar to set
     */
    public void setNomeFamiliar(String nomeFamiliar) {
        this.nomeFamiliar = nomeFamiliar;
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
     * @return the vinculo
     */
    public String getVinculo() {
        return vinculo;
    }

    /**
     * @param vinculo the vinculo to set
     */
    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the ocupacao
     */
    public String getOcupacao() {
        return ocupacao;
    }

    /**
     * @param ocupacao the ocupacao to set
     */
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    /**
     * @return the enderecoTelefonePAI
     */
    public String getEnderecoTelefonePAI() {
        return enderecoTelefonePAI;
    }

    /**
     * @param enderecoTelefonePAI the enderecoTelefonePAI to set
     */
    public void setEnderecoTelefonePAI(String enderecoTelefonePAI) {
        this.enderecoTelefonePAI = enderecoTelefonePAI;
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
