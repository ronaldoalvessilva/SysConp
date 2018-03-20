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
public class AtendimentoFemininoP4 {

    private int idAfp4;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private float pesoGestante;
    private float alturaGestante;
    private int face;
    private int tronco;
    private int membroInferior;
    private int membroSuperior;
    private String inspecaoPeleMucosa;
    private String palpacaoTireoide;
    private String exameAbdomem;
    private float alturaUterina;
    private String posicaoFetal;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AtendimentoFemininoP4(int idAfp4, int idLanc, int idInternoCrc, String nomeInternoCrc, float pesoGestante, float alturaGestante, int face, int tronco, int membroInferior, int membroSuperior, String inspecaoPeleMucosa, String palpacaoTireoide, String exameAbdomem, float alturaUterina, String posicaoFetal, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAfp4 = idAfp4;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.pesoGestante = pesoGestante;
        this.alturaGestante = alturaGestante;
        this.face = face;
        this.tronco = tronco;
        this.membroInferior = membroInferior;
        this.membroSuperior = membroSuperior;
        this.inspecaoPeleMucosa = inspecaoPeleMucosa;
        this.palpacaoTireoide = palpacaoTireoide;
        this.exameAbdomem = exameAbdomem;
        this.alturaUterina = alturaUterina;
        this.posicaoFetal = posicaoFetal;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtendimentoFemininoP4() {
    }

    /**
     * @return the idAfp4
     */
    public int getIdAfp4() {
        return idAfp4;
    }

    /**
     * @param idAfp4 the idAfp4 to set
     */
    public void setIdAfp4(int idAfp4) {
        this.idAfp4 = idAfp4;
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
     * @return the pesoGestante
     */
    public float getPesoGestante() {
        return pesoGestante;
    }

    /**
     * @param pesoGestante the pesoGestante to set
     */
    public void setPesoGestante(float pesoGestante) {
        this.pesoGestante = pesoGestante;
    }

    /**
     * @return the alturaGestante
     */
    public float getAlturaGestante() {
        return alturaGestante;
    }

    /**
     * @param alturaGestante the alturaGestante to set
     */
    public void setAlturaGestante(float alturaGestante) {
        this.alturaGestante = alturaGestante;
    }

    /**
     * @return the face
     */
    public int getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(int face) {
        this.face = face;
    }

    /**
     * @return the tronco
     */
    public int getTronco() {
        return tronco;
    }

    /**
     * @param tronco the tronco to set
     */
    public void setTronco(int tronco) {
        this.tronco = tronco;
    }

    /**
     * @return the membroInferior
     */
    public int getMembroInferior() {
        return membroInferior;
    }

    /**
     * @param membroInferior the membroInferior to set
     */
    public void setMembroInferior(int membroInferior) {
        this.membroInferior = membroInferior;
    }

    /**
     * @return the membroSuperior
     */
    public int getMembroSuperior() {
        return membroSuperior;
    }

    /**
     * @param membroSuperior the membroSuperior to set
     */
    public void setMembroSuperior(int membroSuperior) {
        this.membroSuperior = membroSuperior;
    }

    /**
     * @return the inspecaoPeleMucosa
     */
    public String getInspecaoPeleMucosa() {
        return inspecaoPeleMucosa;
    }

    /**
     * @param inspecaoPeleMucosa the inspecaoPeleMucosa to set
     */
    public void setInspecaoPeleMucosa(String inspecaoPeleMucosa) {
        this.inspecaoPeleMucosa = inspecaoPeleMucosa;
    }

    /**
     * @return the palpacaoTireoide
     */
    public String getPalpacaoTireoide() {
        return palpacaoTireoide;
    }

    /**
     * @param palpacaoTireoide the palpacaoTireoide to set
     */
    public void setPalpacaoTireoide(String palpacaoTireoide) {
        this.palpacaoTireoide = palpacaoTireoide;
    }

    /**
     * @return the exameAbdomem
     */
    public String getExameAbdomem() {
        return exameAbdomem;
    }

    /**
     * @param exameAbdomem the exameAbdomem to set
     */
    public void setExameAbdomem(String exameAbdomem) {
        this.exameAbdomem = exameAbdomem;
    }

    /**
     * @return the alturaUterina
     */
    public float getAlturaUterina() {
        return alturaUterina;
    }

    /**
     * @param alturaUterina the alturaUterina to set
     */
    public void setAlturaUterina(float alturaUterina) {
        this.alturaUterina = alturaUterina;
    }

    /**
     * @return the posicaoFetal
     */
    public String getPosicaoFetal() {
        return posicaoFetal;
    }

    /**
     * @param posicaoFetal the posicaoFetal to set
     */
    public void setPosicaoFetal(String posicaoFetal) {
        this.posicaoFetal = posicaoFetal;
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
