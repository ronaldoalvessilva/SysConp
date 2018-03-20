/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

/**
 *
 * @author user
 */
public class Operacao {
    
    private int idOp;    
    private String tipo;
    private String descricao;
    private String statusOperacao;  

    public Operacao(int idOp, String tipo, String descricao, String statusOperacao) {
        this.idOp = idOp;
        this.tipo = tipo;
        this.descricao = descricao;
        this.statusOperacao = statusOperacao;
    }

    public Operacao() {
    }

    /**
     * @return the idOp
     */
    public int getIdOp() {
        return idOp;
    }

    /**
     * @param idOp the idOp to set
     */
    public void setIdOp(int idOp) {
        this.idOp = idOp;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the statusOperacao
     */
    public String getStatusOperacao() {
        return statusOperacao;
    }

    /**
     * @param statusOperacao the statusOperacao to set
     */
    public void setStatusOperacao(String statusOperacao) {
        this.statusOperacao = statusOperacao;
    }
}
