/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronal
 */
public class PlanejamentoAtividades {

    private Integer codigo;
    private String sigla;
    private String descricaoPlanejamento;
    private String departamento;

    public PlanejamentoAtividades() {
    }

    public PlanejamentoAtividades(Integer codigo, String sigla, String descricaoPlanejamento, String departamento) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.descricaoPlanejamento = descricaoPlanejamento;
        this.departamento = departamento;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    /**
     * @return the descricaoPlanejamento
     */
    public String getDescricaoPlanejamento() {
        return descricaoPlanejamento;
    }

    /**
     * @param descricaoPlanejamento the descricaoPlanejamento to set
     */
    public void setDescricaoPlanejamento(String descricaoPlanejamento) {
        this.descricaoPlanejamento = descricaoPlanejamento;
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
}
