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
public class FemininoAdmissaoPedago {

    private int idFemAdm;
    private int idAdm;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String filhoDesejado;
    private String queriaEngravidar;
    private String foiAcidental;
    private String perturbou;
    private String comoFoiGestacao;
    private String comoFoiParto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public FemininoAdmissaoPedago(int idFemAdm, int idAdm, int idInternoCrc, String nomeInternoCrc, String filhoDesejado, String queriaEngravidar, String foiAcidental, String perturbou, String comoFoiGestacao, String comoFoiParto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFemAdm = idFemAdm;
        this.idAdm = idAdm;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.filhoDesejado = filhoDesejado;
        this.queriaEngravidar = queriaEngravidar;
        this.foiAcidental = foiAcidental;
        this.perturbou = perturbou;
        this.comoFoiGestacao = comoFoiGestacao;
        this.comoFoiParto = comoFoiParto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FemininoAdmissaoPedago() {
    }

    /**
     * @return the idFemAdm
     */
    public int getIdFemAdm() {
        return idFemAdm;
    }

    /**
     * @param idFemAdm the idFemAdm to set
     */
    public void setIdFemAdm(int idFemAdm) {
        this.idFemAdm = idFemAdm;
    }

    /**
     * @return the idAdm
     */
    public int getIdAdm() {
        return idAdm;
    }

    /**
     * @param idAdm the idAdm to set
     */
    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
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
     * @return the filhoDesejado
     */
    public String getFilhoDesejado() {
        return filhoDesejado;
    }

    /**
     * @param filhoDesejado the filhoDesejado to set
     */
    public void setFilhoDesejado(String filhoDesejado) {
        this.filhoDesejado = filhoDesejado;
    }

    /**
     * @return the queriaEngravidar
     */
    public String getQueriaEngravidar() {
        return queriaEngravidar;
    }

    /**
     * @param queriaEngravidar the queriaEngravidar to set
     */
    public void setQueriaEngravidar(String queriaEngravidar) {
        this.queriaEngravidar = queriaEngravidar;
    }

    /**
     * @return the foiAcidental
     */
    public String getFoiAcidental() {
        return foiAcidental;
    }

    /**
     * @param foiAcidental the foiAcidental to set
     */
    public void setFoiAcidental(String foiAcidental) {
        this.foiAcidental = foiAcidental;
    }

    /**
     * @return the perturbou
     */
    public String getPerturbou() {
        return perturbou;
    }

    /**
     * @param perturbou the perturbou to set
     */
    public void setPerturbou(String perturbou) {
        this.perturbou = perturbou;
    }

    /**
     * @return the comoFoiGestacao
     */
    public String getComoFoiGestacao() {
        return comoFoiGestacao;
    }

    /**
     * @param comoFoiGestacao the comoFoiGestacao to set
     */
    public void setComoFoiGestacao(String comoFoiGestacao) {
        this.comoFoiGestacao = comoFoiGestacao;
    }

    /**
     * @return the comoFoiParto
     */
    public String getComoFoiParto() {
        return comoFoiParto;
    }

    /**
     * @param comoFoiParto the comoFoiParto to set
     */
    public void setComoFoiParto(String comoFoiParto) {
        this.comoFoiParto = comoFoiParto;
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
