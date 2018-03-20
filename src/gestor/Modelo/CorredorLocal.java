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
public class CorredorLocal {

    private int idCor;
    private String statusCor;
    private String descricaoCor;
    private String idLocal;
    private String nomeLocal;

    public CorredorLocal(int idCor, String statusCor, String descricaoCor, String idLocal, String nomeLocal) {
        this.idCor = idCor;
        this.statusCor = statusCor;
        this.descricaoCor = descricaoCor;
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
    }

    public CorredorLocal() {
    }

    /**
     * @return the idCor
     */
    public int getIdCor() {
        return idCor;
    }

    /**
     * @param idCor the idCor to set
     */
    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    /**
     * @return the statusCor
     */
    public String getStatusCor() {
        return statusCor;
    }

    /**
     * @param statusCor the statusCor to set
     */
    public void setStatusCor(String statusCor) {
        this.statusCor = statusCor;
    }

    /**
     * @return the descricaoCor
     */
    public String getDescricaoCor() {
        return descricaoCor;
    }

    /**
     * @param descricaoCor the descricaoCor to set
     */
    public void setDescricaoCor(String descricaoCor) {
        this.descricaoCor = descricaoCor;
    }

    /**
     * @return the idLocal
     */
    public String getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
}
