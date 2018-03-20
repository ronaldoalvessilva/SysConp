/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class DigitalColaborador {
    
    private int idFunc;
    private String nomeFunc;
    private String caminhoFotoColaborador;
    private String funcao;
    private String departamento;
    private String matricula;   
    private String fotoColaborador;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4;          

    public DigitalColaborador(int idFunc, String nomeFunc, String caminhoFotoColaborador, String funcao, String departamento, String matricula, String fotoColaborador, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4) {
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.caminhoFotoColaborador = caminhoFotoColaborador;
        this.funcao = funcao;
        this.departamento = departamento;
        this.matricula = matricula;
        this.fotoColaborador = fotoColaborador;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
    }

    public DigitalColaborador() {
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
     * @return the caminhoFotoColaborador
     */
    public String getCaminhoFotoColaborador() {
        return caminhoFotoColaborador;
    }

    /**
     * @param caminhoFotoColaborador the caminhoFotoColaborador to set
     */
    public void setCaminhoFotoColaborador(String caminhoFotoColaborador) {
        this.caminhoFotoColaborador = caminhoFotoColaborador;
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
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
     * @return the fotoColaborador
     */
    public String getFotoColaborador() {
        return fotoColaborador;
    }

    /**
     * @param fotoColaborador the fotoColaborador to set
     */
    public void setFotoColaborador(String fotoColaborador) {
        this.fotoColaborador = fotoColaborador;
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
