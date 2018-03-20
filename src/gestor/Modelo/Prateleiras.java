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
public class Prateleiras {

    private int idPrat;
    private String statusPrat;
    private String descricaoPrat;
    private int idLocal;
    private String descricaoLocal;
    private int idCor;
    private String descricaoCorredor;

    public Prateleiras(int idPrat, String statusPrat, String descricaoPrat, int idLocal, String descricaoLocal, int idCor, String descricaoCorredor) {
        this.idPrat = idPrat;
        this.statusPrat = statusPrat;
        this.descricaoPrat = descricaoPrat;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.idCor = idCor;
        this.descricaoCorredor = descricaoCorredor;
    }

    public Prateleiras() {
    }

    /**
     * @return the idPrat
     */
    public int getIdPrat() {
        return idPrat;
    }

    /**
     * @param idPrat the idPrat to set
     */
    public void setIdPrat(int idPrat) {
        this.idPrat = idPrat;
    }

    /**
     * @return the statusPrat
     */
    public String getStatusPrat() {
        return statusPrat;
    }

    /**
     * @param statusPrat the statusPrat to set
     */
    public void setStatusPrat(String statusPrat) {
        this.statusPrat = statusPrat;
    }

    /**
     * @return the descricaoPrat
     */
    public String getDescricaoPrat() {
        return descricaoPrat;
    }

    /**
     * @param descricaoPrat the descricaoPrat to set
     */
    public void setDescricaoPrat(String descricaoPrat) {
        this.descricaoPrat = descricaoPrat;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the descricaoLocal
     */
    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    /**
     * @param descricaoLocal the descricaoLocal to set
     */
    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
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
     * @return the descricaoCorredor
     */
    public String getDescricaoCorredor() {
        return descricaoCorredor;
    }

    /**
     * @param descricaoCorredor the descricaoCorredor to set
     */
    public void setDescricaoCorredor(String descricaoCorredor) {
        this.descricaoCorredor = descricaoCorredor;
    }
}
