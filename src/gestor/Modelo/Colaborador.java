/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo Alves da Silva
 */
public class Colaborador {
   private int idFunc ;
   private int idCargo;
   private int idCidade;
   private int idDepto;
private int matFunc;
private String nomeFunc; 
private Date dataCadFun;
private Date dataNascFunc;
private String estadoCivilFunc;
private String sexoFunc;
private String escolaFunc;
private String religiaoFunc;
private String tipoSangFunc;
private String nomeCidade;
private String nomeCargo;
private String nomeDepartamento;
private String maeFunc;
private String paiFunc;
private String conjuFunc;
private Date dataNasCon;
private String foto;

    public Colaborador(int idFunc, int idCargo, int idCidade, int idDepto, int matFunc, String nomeFunc, Date dataCadFun, Date dataNascFunc, String estadoCivilFunc, String sexoFunc, String escolaFunc, String religiaoFunc, String tipoSangFunc, String nomeCidade, String nomeCargo, String nomeDepartamento, String maeFunc, String paiFunc, String conjuFunc, Date dataNasCon, String foto) {
        this.idFunc = idFunc;
        this.idCargo = idCargo;
        this.idCidade = idCidade;
        this.idDepto = idDepto;
        this.matFunc = matFunc;
        this.nomeFunc = nomeFunc;
        this.dataCadFun = dataCadFun;
        this.dataNascFunc = dataNascFunc;
        this.estadoCivilFunc = estadoCivilFunc;
        this.sexoFunc = sexoFunc;
        this.escolaFunc = escolaFunc;
        this.religiaoFunc = religiaoFunc;
        this.tipoSangFunc = tipoSangFunc;
        this.nomeCidade = nomeCidade;
        this.nomeCargo = nomeCargo;
        this.nomeDepartamento = nomeDepartamento;
        this.maeFunc = maeFunc;
        this.paiFunc = paiFunc;
        this.conjuFunc = conjuFunc;
        this.dataNasCon = dataNasCon;
        this.foto = foto;
    }

    public Colaborador() {
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
     * @return the idCidade
     */
    public int getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the idDepto
     */
    public int getIdDepto() {
        return idDepto;
    }

    /**
     * @param idDepto the idDepto to set
     */
    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    /**
     * @return the matFunc
     */
    public int getMatFunc() {
        return matFunc;
    }

    /**
     * @param matFunc the matFunc to set
     */
    public void setMatFunc(int matFunc) {
        this.matFunc = matFunc;
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
     * @return the dataCadFun
     */
    public Date getDataCadFun() {
        return dataCadFun;
    }

    /**
     * @param dataCadFun the dataCadFun to set
     */
    public void setDataCadFun(Date dataCadFun) {
        this.dataCadFun = dataCadFun;
    }

    /**
     * @return the dataNascFunc
     */
    public Date getDataNascFunc() {
        return dataNascFunc;
    }

    /**
     * @param dataNascFunc the dataNascFunc to set
     */
    public void setDataNascFunc(Date dataNascFunc) {
        this.dataNascFunc = dataNascFunc;
    }

    /**
     * @return the estadoCivilFunc
     */
    public String getEstadoCivilFunc() {
        return estadoCivilFunc;
    }

    /**
     * @param estadoCivilFunc the estadoCivilFunc to set
     */
    public void setEstadoCivilFunc(String estadoCivilFunc) {
        this.estadoCivilFunc = estadoCivilFunc;
    }

    /**
     * @return the sexoFunc
     */
    public String getSexoFunc() {
        return sexoFunc;
    }

    /**
     * @param sexoFunc the sexoFunc to set
     */
    public void setSexoFunc(String sexoFunc) {
        this.sexoFunc = sexoFunc;
    }

    /**
     * @return the escolaFunc
     */
    public String getEscolaFunc() {
        return escolaFunc;
    }

    /**
     * @param escolaFunc the escolaFunc to set
     */
    public void setEscolaFunc(String escolaFunc) {
        this.escolaFunc = escolaFunc;
    }

    /**
     * @return the religiaoFunc
     */
    public String getReligiaoFunc() {
        return religiaoFunc;
    }

    /**
     * @param religiaoFunc the religiaoFunc to set
     */
    public void setReligiaoFunc(String religiaoFunc) {
        this.religiaoFunc = religiaoFunc;
    }

    /**
     * @return the tipoSangFunc
     */
    public String getTipoSangFunc() {
        return tipoSangFunc;
    }

    /**
     * @param tipoSangFunc the tipoSangFunc to set
     */
    public void setTipoSangFunc(String tipoSangFunc) {
        this.tipoSangFunc = tipoSangFunc;
    }

    /**
     * @return the nomeCidade
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * @param nomeCidade the nomeCidade to set
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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
     * @return the maeFunc
     */
    public String getMaeFunc() {
        return maeFunc;
    }

    /**
     * @param maeFunc the maeFunc to set
     */
    public void setMaeFunc(String maeFunc) {
        this.maeFunc = maeFunc;
    }

    /**
     * @return the paiFunc
     */
    public String getPaiFunc() {
        return paiFunc;
    }

    /**
     * @param paiFunc the paiFunc to set
     */
    public void setPaiFunc(String paiFunc) {
        this.paiFunc = paiFunc;
    }

    /**
     * @return the conjuFunc
     */
    public String getConjuFunc() {
        return conjuFunc;
    }

    /**
     * @param conjuFunc the conjuFunc to set
     */
    public void setConjuFunc(String conjuFunc) {
        this.conjuFunc = conjuFunc;
    }

    /**
     * @return the dataNasCon
     */
    public Date getDataNasCon() {
        return dataNasCon;
    }

    /**
     * @param dataNasCon the dataNasCon to set
     */
    public void setDataNasCon(Date dataNasCon) {
        this.dataNasCon = dataNasCon;
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

    @Override
    public String toString() {
        return getNomeFunc(); //To change body of generated methods, choose Tools | Templates.
    }

}
