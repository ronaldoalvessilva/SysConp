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
public class ItensAgendaLaborativa {

    private int idItem;
    private int idAgenda;
    private int idInternoCrc;
    private String nomeInterno;
    private String statusInterno;
    private int idEmp;
    private String nomeEmpresa;
    private String observacaoInterno;
    private String tipoEmpresa;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;      
    private int DiaSeg;
    private int DiaTer;
    private int DiaQua;
    private int DiaQui;
    private int DiaSex;
    private int DiaSab;
    private int DiaDom;
    private String horaSeg;
    private String horaTer;
    private String horaQua;
    private String horaQui;
    private String horaSex;
    private String horaSab;
    private String horaDom;
    private String horaSegEnt;
    private String horaTerEnt;
    private String horaQuaEnt;
    private String horaQuiEnt;
    private String horaSexEnt;
    private String horaSabEnt;
    private String horaDomEnt;   

    public ItensAgendaLaborativa(int idItem, int idAgenda, int idInternoCrc, String nomeInterno, String statusInterno, int idEmp, String nomeEmpresa, String observacaoInterno, String tipoEmpresa, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, int DiaSeg, int DiaTer, int DiaQua, int DiaQui, int DiaSex, int DiaSab, int DiaDom, String horaSeg, String horaTer, String horaQua, String horaQui, String horaSex, String horaSab, String horaDom, String horaSegEnt, String horaTerEnt, String horaQuaEnt, String horaQuiEnt, String horaSexEnt, String horaSabEnt, String horaDomEnt) {
        this.idItem = idItem;
        this.idAgenda = idAgenda;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.statusInterno = statusInterno;
        this.idEmp = idEmp;
        this.nomeEmpresa = nomeEmpresa;
        this.observacaoInterno = observacaoInterno;
        this.tipoEmpresa = tipoEmpresa;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.DiaSeg = DiaSeg;
        this.DiaTer = DiaTer;
        this.DiaQua = DiaQua;
        this.DiaQui = DiaQui;
        this.DiaSex = DiaSex;
        this.DiaSab = DiaSab;
        this.DiaDom = DiaDom;
        this.horaSeg = horaSeg;
        this.horaTer = horaTer;
        this.horaQua = horaQua;
        this.horaQui = horaQui;
        this.horaSex = horaSex;
        this.horaSab = horaSab;
        this.horaDom = horaDom;
        this.horaSegEnt = horaSegEnt;
        this.horaTerEnt = horaTerEnt;
        this.horaQuaEnt = horaQuaEnt;
        this.horaQuiEnt = horaQuiEnt;
        this.horaSexEnt = horaSexEnt;
        this.horaSabEnt = horaSabEnt;
        this.horaDomEnt = horaDomEnt;
    }

    public ItensAgendaLaborativa() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idAgenda
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * @param idAgenda the idAgenda to set
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
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
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the statusInterno
     */
    public String getStatusInterno() {
        return statusInterno;
    }

    /**
     * @param statusInterno the statusInterno to set
     */
    public void setStatusInterno(String statusInterno) {
        this.statusInterno = statusInterno;
    }

    /**
     * @return the idEmp
     */
    public int getIdEmp() {
        return idEmp;
    }

    /**
     * @param idEmp the idEmp to set
     */
    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * @return the observacaoInterno
     */
    public String getObservacaoInterno() {
        return observacaoInterno;
    }

    /**
     * @param observacaoInterno the observacaoInterno to set
     */
    public void setObservacaoInterno(String observacaoInterno) {
        this.observacaoInterno = observacaoInterno;
    }

    /**
     * @return the tipoEmpresa
     */
    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    /**
     * @param tipoEmpresa the tipoEmpresa to set
     */
    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }

    /**
     * @return the DiaSeg
     */
    public int getDiaSeg() {
        return DiaSeg;
    }

    /**
     * @param DiaSeg the DiaSeg to set
     */
    public void setDiaSeg(int DiaSeg) {
        this.DiaSeg = DiaSeg;
    }

    /**
     * @return the DiaTer
     */
    public int getDiaTer() {
        return DiaTer;
    }

    /**
     * @param DiaTer the DiaTer to set
     */
    public void setDiaTer(int DiaTer) {
        this.DiaTer = DiaTer;
    }

    /**
     * @return the DiaQua
     */
    public int getDiaQua() {
        return DiaQua;
    }

    /**
     * @param DiaQua the DiaQua to set
     */
    public void setDiaQua(int DiaQua) {
        this.DiaQua = DiaQua;
    }

    /**
     * @return the DiaQui
     */
    public int getDiaQui() {
        return DiaQui;
    }

    /**
     * @param DiaQui the DiaQui to set
     */
    public void setDiaQui(int DiaQui) {
        this.DiaQui = DiaQui;
    }

    /**
     * @return the DiaSex
     */
    public int getDiaSex() {
        return DiaSex;
    }

    /**
     * @param DiaSex the DiaSex to set
     */
    public void setDiaSex(int DiaSex) {
        this.DiaSex = DiaSex;
    }

    /**
     * @return the DiaSab
     */
    public int getDiaSab() {
        return DiaSab;
    }

    /**
     * @param DiaSab the DiaSab to set
     */
    public void setDiaSab(int DiaSab) {
        this.DiaSab = DiaSab;
    }

    /**
     * @return the DiaDom
     */
    public int getDiaDom() {
        return DiaDom;
    }

    /**
     * @param DiaDom the DiaDom to set
     */
    public void setDiaDom(int DiaDom) {
        this.DiaDom = DiaDom;
    }

    /**
     * @return the horaSeg
     */
    public String getHoraSeg() {
        return horaSeg;
    }

    /**
     * @param horaSeg the horaSeg to set
     */
    public void setHoraSeg(String horaSeg) {
        this.horaSeg = horaSeg;
    }

    /**
     * @return the horaTer
     */
    public String getHoraTer() {
        return horaTer;
    }

    /**
     * @param horaTer the horaTer to set
     */
    public void setHoraTer(String horaTer) {
        this.horaTer = horaTer;
    }

    /**
     * @return the horaQua
     */
    public String getHoraQua() {
        return horaQua;
    }

    /**
     * @param horaQua the horaQua to set
     */
    public void setHoraQua(String horaQua) {
        this.horaQua = horaQua;
    }

    /**
     * @return the horaQui
     */
    public String getHoraQui() {
        return horaQui;
    }

    /**
     * @param horaQui the horaQui to set
     */
    public void setHoraQui(String horaQui) {
        this.horaQui = horaQui;
    }

    /**
     * @return the horaSex
     */
    public String getHoraSex() {
        return horaSex;
    }

    /**
     * @param horaSex the horaSex to set
     */
    public void setHoraSex(String horaSex) {
        this.horaSex = horaSex;
    }

    /**
     * @return the horaSab
     */
    public String getHoraSab() {
        return horaSab;
    }

    /**
     * @param horaSab the horaSab to set
     */
    public void setHoraSab(String horaSab) {
        this.horaSab = horaSab;
    }

    /**
     * @return the horaDom
     */
    public String getHoraDom() {
        return horaDom;
    }

    /**
     * @param horaDom the horaDom to set
     */
    public void setHoraDom(String horaDom) {
        this.horaDom = horaDom;
    }

    /**
     * @return the horaSegEnt
     */
    public String getHoraSegEnt() {
        return horaSegEnt;
    }

    /**
     * @param horaSegEnt the horaSegEnt to set
     */
    public void setHoraSegEnt(String horaSegEnt) {
        this.horaSegEnt = horaSegEnt;
    }

    /**
     * @return the horaTerEnt
     */
    public String getHoraTerEnt() {
        return horaTerEnt;
    }

    /**
     * @param horaTerEnt the horaTerEnt to set
     */
    public void setHoraTerEnt(String horaTerEnt) {
        this.horaTerEnt = horaTerEnt;
    }

    /**
     * @return the horaQuaEnt
     */
    public String getHoraQuaEnt() {
        return horaQuaEnt;
    }

    /**
     * @param horaQuaEnt the horaQuaEnt to set
     */
    public void setHoraQuaEnt(String horaQuaEnt) {
        this.horaQuaEnt = horaQuaEnt;
    }

    /**
     * @return the horaQuiEnt
     */
    public String getHoraQuiEnt() {
        return horaQuiEnt;
    }

    /**
     * @param horaQuiEnt the horaQuiEnt to set
     */
    public void setHoraQuiEnt(String horaQuiEnt) {
        this.horaQuiEnt = horaQuiEnt;
    }

    /**
     * @return the horaSexEnt
     */
    public String getHoraSexEnt() {
        return horaSexEnt;
    }

    /**
     * @param horaSexEnt the horaSexEnt to set
     */
    public void setHoraSexEnt(String horaSexEnt) {
        this.horaSexEnt = horaSexEnt;
    }

    /**
     * @return the horaSabEnt
     */
    public String getHoraSabEnt() {
        return horaSabEnt;
    }

    /**
     * @param horaSabEnt the horaSabEnt to set
     */
    public void setHoraSabEnt(String horaSabEnt) {
        this.horaSabEnt = horaSabEnt;
    }

    /**
     * @return the horaDomEnt
     */
    public String getHoraDomEnt() {
        return horaDomEnt;
    }

    /**
     * @param horaDomEnt the horaDomEnt to set
     */
    public void setHoraDomEnt(String horaDomEnt) {
        this.horaDomEnt = horaDomEnt;
    }
}
