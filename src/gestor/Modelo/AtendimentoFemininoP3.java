/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class AtendimentoFemininoP3 {

    private int idAfp3;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private Date dataUltimaMenstruacao;
    private String gestante;
    private String certezaDuvidaGestacao;
    private String habitosAlimentares;
    private String medicamentoGestacao;
    private String internacaoGestacao;
    private String ondeGestacao;
    private int cigarro;
    private int pacaia;
    private int maconha;
    private int cocaina;
    private int craque;
    private int alcool;
    private int outros;
    private String quaisDrogras;
    private String sinaisSintomas;
    private String ocupacaoHabitual;
    private String aceitacaoGravidez;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AtendimentoFemininoP3(int idAfp3, int idLanc, int idInternoCrc, String nomeInternoCrc, Date dataUltimaMenstruacao, String gestante, String certezaDuvidaGestacao, String habitosAlimentares, String medicamentoGestacao, String internacaoGestacao, String ondeGestacao, int cigarro, int pacaia, int maconha, int cocaina, int craque, int alcool, int outros, String quaisDrogras, String sinaisSintomas, String ocupacaoHabitual, String aceitacaoGravidez, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAfp3 = idAfp3;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataUltimaMenstruacao = dataUltimaMenstruacao;
        this.gestante = gestante;
        this.certezaDuvidaGestacao = certezaDuvidaGestacao;
        this.habitosAlimentares = habitosAlimentares;
        this.medicamentoGestacao = medicamentoGestacao;
        this.internacaoGestacao = internacaoGestacao;
        this.ondeGestacao = ondeGestacao;
        this.cigarro = cigarro;
        this.pacaia = pacaia;
        this.maconha = maconha;
        this.cocaina = cocaina;
        this.craque = craque;
        this.alcool = alcool;
        this.outros = outros;
        this.quaisDrogras = quaisDrogras;
        this.sinaisSintomas = sinaisSintomas;
        this.ocupacaoHabitual = ocupacaoHabitual;
        this.aceitacaoGravidez = aceitacaoGravidez;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtendimentoFemininoP3() {
    }

    /**
     * @return the idAfp3
     */
    public int getIdAfp3() {
        return idAfp3;
    }

    /**
     * @param idAfp3 the idAfp3 to set
     */
    public void setIdAfp3(int idAfp3) {
        this.idAfp3 = idAfp3;
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
     * @return the dataUltimaMenstruacao
     */
    public Date getDataUltimaMenstruacao() {
        return dataUltimaMenstruacao;
    }

    /**
     * @param dataUltimaMenstruacao the dataUltimaMenstruacao to set
     */
    public void setDataUltimaMenstruacao(Date dataUltimaMenstruacao) {
        this.dataUltimaMenstruacao = dataUltimaMenstruacao;
    }

    /**
     * @return the gestante
     */
    public String getGestante() {
        return gestante;
    }

    /**
     * @param gestante the gestante to set
     */
    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    /**
     * @return the certezaDuvidaGestacao
     */
    public String getCertezaDuvidaGestacao() {
        return certezaDuvidaGestacao;
    }

    /**
     * @param certezaDuvidaGestacao the certezaDuvidaGestacao to set
     */
    public void setCertezaDuvidaGestacao(String certezaDuvidaGestacao) {
        this.certezaDuvidaGestacao = certezaDuvidaGestacao;
    }

    /**
     * @return the habitosAlimentares
     */
    public String getHabitosAlimentares() {
        return habitosAlimentares;
    }

    /**
     * @param habitosAlimentares the habitosAlimentares to set
     */
    public void setHabitosAlimentares(String habitosAlimentares) {
        this.habitosAlimentares = habitosAlimentares;
    }

    /**
     * @return the medicamentoGestacao
     */
    public String getMedicamentoGestacao() {
        return medicamentoGestacao;
    }

    /**
     * @param medicamentoGestacao the medicamentoGestacao to set
     */
    public void setMedicamentoGestacao(String medicamentoGestacao) {
        this.medicamentoGestacao = medicamentoGestacao;
    }

    /**
     * @return the internacaoGestacao
     */
    public String getInternacaoGestacao() {
        return internacaoGestacao;
    }

    /**
     * @param internacaoGestacao the internacaoGestacao to set
     */
    public void setInternacaoGestacao(String internacaoGestacao) {
        this.internacaoGestacao = internacaoGestacao;
    }

    /**
     * @return the ondeGestacao
     */
    public String getOndeGestacao() {
        return ondeGestacao;
    }

    /**
     * @param ondeGestacao the ondeGestacao to set
     */
    public void setOndeGestacao(String ondeGestacao) {
        this.ondeGestacao = ondeGestacao;
    }

    /**
     * @return the cigarro
     */
    public int getCigarro() {
        return cigarro;
    }

    /**
     * @param cigarro the cigarro to set
     */
    public void setCigarro(int cigarro) {
        this.cigarro = cigarro;
    }

    /**
     * @return the pacaia
     */
    public int getPacaia() {
        return pacaia;
    }

    /**
     * @param pacaia the pacaia to set
     */
    public void setPacaia(int pacaia) {
        this.pacaia = pacaia;
    }

    /**
     * @return the maconha
     */
    public int getMaconha() {
        return maconha;
    }

    /**
     * @param maconha the maconha to set
     */
    public void setMaconha(int maconha) {
        this.maconha = maconha;
    }

    /**
     * @return the cocaina
     */
    public int getCocaina() {
        return cocaina;
    }

    /**
     * @param cocaina the cocaina to set
     */
    public void setCocaina(int cocaina) {
        this.cocaina = cocaina;
    }

    /**
     * @return the craque
     */
    public int getCraque() {
        return craque;
    }

    /**
     * @param craque the craque to set
     */
    public void setCraque(int craque) {
        this.craque = craque;
    }

    /**
     * @return the alcool
     */
    public int getAlcool() {
        return alcool;
    }

    /**
     * @param alcool the alcool to set
     */
    public void setAlcool(int alcool) {
        this.alcool = alcool;
    }

    /**
     * @return the outros
     */
    public int getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(int outros) {
        this.outros = outros;
    }

    /**
     * @return the quaisDrogras
     */
    public String getQuaisDrogras() {
        return quaisDrogras;
    }

    /**
     * @param quaisDrogras the quaisDrogras to set
     */
    public void setQuaisDrogras(String quaisDrogras) {
        this.quaisDrogras = quaisDrogras;
    }

    /**
     * @return the sinaisSintomas
     */
    public String getSinaisSintomas() {
        return sinaisSintomas;
    }

    /**
     * @param sinaisSintomas the sinaisSintomas to set
     */
    public void setSinaisSintomas(String sinaisSintomas) {
        this.sinaisSintomas = sinaisSintomas;
    }

    /**
     * @return the ocupacaoHabitual
     */
    public String getOcupacaoHabitual() {
        return ocupacaoHabitual;
    }

    /**
     * @param ocupacaoHabitual the ocupacaoHabitual to set
     */
    public void setOcupacaoHabitual(String ocupacaoHabitual) {
        this.ocupacaoHabitual = ocupacaoHabitual;
    }

    /**
     * @return the aceitacaoGravidez
     */
    public String getAceitacaoGravidez() {
        return aceitacaoGravidez;
    }

    /**
     * @param aceitacaoGravidez the aceitacaoGravidez to set
     */
    public void setAceitacaoGravidez(String aceitacaoGravidez) {
        this.aceitacaoGravidez = aceitacaoGravidez;
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
