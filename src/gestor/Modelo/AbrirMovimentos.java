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
public class AbrirMovimentos {

    private int idLanc;
    private String AcessosPessoas;
    private String statusLanc;

    public AbrirMovimentos(int idLanc, String AcessosPessoas, String statusLanc) {
        this.idLanc = idLanc;
        this.AcessosPessoas = AcessosPessoas;
        this.statusLanc = statusLanc;
    }

    public AbrirMovimentos() {
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the AcessosPessoas
     */
    public String getAcessosPessoas() {
        return AcessosPessoas;
    }

    /**
     * @param AcessosPessoas the AcessosPessoas to set
     */
    public void setAcessosPessoas(String AcessosPessoas) {
        this.AcessosPessoas = AcessosPessoas;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }
}
