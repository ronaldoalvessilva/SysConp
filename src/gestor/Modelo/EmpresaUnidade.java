/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class EmpresaUnidade {
    
        private int idUnidEmp;
	private String descricaoUnidade;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String regime;
	private int capacidadeMas;
	private int capacidadeFen;
	private int capacidadeTotal;
        private int idEmpresa;
        private String descricaoEmpresa;
        private Double versaoAtual;
	private String usuarioInsert;
	private String usuarioUp;	
	private String dataInsert;
	private String dataUp;	
	private String horarioInsert;
	private String horarioUp;   
        private String sigla;
    public EmpresaUnidade() {
    }

    public EmpresaUnidade(int idUnidEmp, String descricaoUnidade, String endereco, String bairro, String cidade, String estado, String regime, int capacidadeMas, int capacidadeFen, int capacidadeTotal, int idEmpresa, String descricaoEmpresa, Double versaoAtual, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String sigla) {
        this.idUnidEmp = idUnidEmp;
        this.descricaoUnidade = descricaoUnidade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.regime = regime;
        this.capacidadeMas = capacidadeMas;
        this.capacidadeFen = capacidadeFen;
        this.capacidadeTotal = capacidadeTotal;
        this.idEmpresa = idEmpresa;
        this.descricaoEmpresa = descricaoEmpresa;
        this.versaoAtual = versaoAtual;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.sigla = sigla;
    }

    /**
     * @return the idUnidEmp
     */
    public int getIdUnidEmp() {
        return idUnidEmp;
    }

    /**
     * @param idUnidEmp the idUnidEmp to set
     */
    public void setIdUnidEmp(int idUnidEmp) {
        this.idUnidEmp = idUnidEmp;
    }

    /**
     * @return the descricaoUnidade
     */
    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    /**
     * @param descricaoUnidade the descricaoUnidade to set
     */
    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
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
     * @return the capacidadeMas
     */
    public int getCapacidadeMas() {
        return capacidadeMas;
    }

    /**
     * @param capacidadeMas the capacidadeMas to set
     */
    public void setCapacidadeMas(int capacidadeMas) {
        this.capacidadeMas = capacidadeMas;
    }

    /**
     * @return the capacidadeFen
     */
    public int getCapacidadeFen() {
        return capacidadeFen;
    }

    /**
     * @param capacidadeFen the capacidadeFen to set
     */
    public void setCapacidadeFen(int capacidadeFen) {
        this.capacidadeFen = capacidadeFen;
    }

    /**
     * @return the capacidadeTotal
     */
    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    /**
     * @param capacidadeTotal the capacidadeTotal to set
     */
    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the descricaoEmpresa
     */
    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    /**
     * @param descricaoEmpresa the descricaoEmpresa to set
     */
    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    /**
     * @return the versaoAtual
     */
    public Double getVersaoAtual() {
        return versaoAtual;
    }

    /**
     * @param versaoAtual the versaoAtual to set
     */
    public void setVersaoAtual(Double versaoAtual) {
        this.versaoAtual = versaoAtual;
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
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
