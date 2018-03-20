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
public class VerificarDocumentosVisita {

    private int idVerDoc;
    private int idVisita;
    private String nomeVisita;
    private int IdinternoCrc;
    private String nomeInternooCrc;
    private int ident;
    private int dFoto;
    private int ant;
    private int comp;
    private int decla;
    private int autori;
    private String colaboradorResponsavel;
    private String justificativa;
    private String aprova;
    private int ates;
    private int visApr;
    private int visRep;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;          

    public VerificarDocumentosVisita(int idVerDoc, int idVisita, String nomeVisita, int IdinternoCrc, String nomeInternooCrc, int ident, int dFoto, int ant, int comp, int decla, int autori, String colaboradorResponsavel, String justificativa, String aprova, int ates, int visApr, int visRep, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idVerDoc = idVerDoc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.IdinternoCrc = IdinternoCrc;
        this.nomeInternooCrc = nomeInternooCrc;
        this.ident = ident;
        this.dFoto = dFoto;
        this.ant = ant;
        this.comp = comp;
        this.decla = decla;
        this.autori = autori;
        this.colaboradorResponsavel = colaboradorResponsavel;
        this.justificativa = justificativa;
        this.aprova = aprova;
        this.ates = ates;
        this.visApr = visApr;
        this.visRep = visRep;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public VerificarDocumentosVisita() {
    }

    /**
     * @return the idVerDoc
     */
    public int getIdVerDoc() {
        return idVerDoc;
    }

    /**
     * @param idVerDoc the idVerDoc to set
     */
    public void setIdVerDoc(int idVerDoc) {
        this.idVerDoc = idVerDoc;
    }

    /**
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    /**
     * @return the IdinternoCrc
     */
    public int getIdinternoCrc() {
        return IdinternoCrc;
    }

    /**
     * @param IdinternoCrc the IdinternoCrc to set
     */
    public void setIdinternoCrc(int IdinternoCrc) {
        this.IdinternoCrc = IdinternoCrc;
    }

    /**
     * @return the nomeInternooCrc
     */
    public String getNomeInternooCrc() {
        return nomeInternooCrc;
    }

    /**
     * @param nomeInternooCrc the nomeInternooCrc to set
     */
    public void setNomeInternooCrc(String nomeInternooCrc) {
        this.nomeInternooCrc = nomeInternooCrc;
    }

    /**
     * @return the ident
     */
    public int getIdent() {
        return ident;
    }

    /**
     * @param ident the ident to set
     */
    public void setIdent(int ident) {
        this.ident = ident;
    }

    /**
     * @return the dFoto
     */
    public int getdFoto() {
        return dFoto;
    }

    /**
     * @param dFoto the dFoto to set
     */
    public void setdFoto(int dFoto) {
        this.dFoto = dFoto;
    }

    /**
     * @return the ant
     */
    public int getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(int ant) {
        this.ant = ant;
    }

    /**
     * @return the comp
     */
    public int getComp() {
        return comp;
    }

    /**
     * @param comp the comp to set
     */
    public void setComp(int comp) {
        this.comp = comp;
    }

    /**
     * @return the decla
     */
    public int getDecla() {
        return decla;
    }

    /**
     * @param decla the decla to set
     */
    public void setDecla(int decla) {
        this.decla = decla;
    }

    /**
     * @return the autori
     */
    public int getAutori() {
        return autori;
    }

    /**
     * @param autori the autori to set
     */
    public void setAutori(int autori) {
        this.autori = autori;
    }

    /**
     * @return the colaboradorResponsavel
     */
    public String getColaboradorResponsavel() {
        return colaboradorResponsavel;
    }

    /**
     * @param colaboradorResponsavel the colaboradorResponsavel to set
     */
    public void setColaboradorResponsavel(String colaboradorResponsavel) {
        this.colaboradorResponsavel = colaboradorResponsavel;
    }

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the aprova
     */
    public String getAprova() {
        return aprova;
    }

    /**
     * @param aprova the aprova to set
     */
    public void setAprova(String aprova) {
        this.aprova = aprova;
    }

    /**
     * @return the ates
     */
    public int getAtes() {
        return ates;
    }

    /**
     * @param ates the ates to set
     */
    public void setAtes(int ates) {
        this.ates = ates;
    }

    /**
     * @return the visApr
     */
    public int getVisApr() {
        return visApr;
    }

    /**
     * @param visApr the visApr to set
     */
    public void setVisApr(int visApr) {
        this.visApr = visApr;
    }

    /**
     * @return the visRep
     */
    public int getVisRep() {
        return visRep;
    }

    /**
     * @param visRep the visRep to set
     */
    public void setVisRep(int visRep) {
        this.visRep = visRep;
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
