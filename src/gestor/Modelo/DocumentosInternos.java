/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class DocumentosInternos {

    private int idDoc;
    private String statusDoc;
    private Date dataDoc;
    private int idInternoCrc;
    private String nomeInterno;
    private String rgDoc;
    private String cpfDoc;
    private String cnhDoc;
    private String tituloDoc;
    private String reservistaDoc;
    private String ctpsDoc;
    private String cNascimentoDoc;
    private String cCasamentoDoc;
    private String outrosDoc;
    private Date dataDevolucaoDoc;
    private String observacaoDoc;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   
    private String rGVia;
    private String reservistaVia;
    private String eleitorVia;
    private String cPFVia;
    private String cTPSVia;
    private String tituloVia;
    private String certidaoCasaVia;
    private String cNHVia;
    private String certidaoNascVia;
    private String passaporteVia;
    private int codigoRegistro;
    private String tipoDocumento;
    private String horario;    
    private String motivoDevolucao;    

    public DocumentosInternos(int idDoc, String statusDoc, Date dataDoc, int idInternoCrc, String nomeInterno, String rgDoc, String cpfDoc, String cnhDoc, String tituloDoc, String reservistaDoc, String ctpsDoc, String cNascimentoDoc, String cCasamentoDoc, String outrosDoc, Date dataDevolucaoDoc, String observacaoDoc, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp, String rGVia, String reservistaVia, String eleitorVia, String cPFVia, String cTPSVia, String tituloVia, String certidaoCasaVia, String cNHVia, String certidaoNascVia, String passaporteVia, int codigoRegistro, String tipoDocumento, String horario, String motivoDevolucao) {
        this.idDoc = idDoc;
        this.statusDoc = statusDoc;
        this.dataDoc = dataDoc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.rgDoc = rgDoc;
        this.cpfDoc = cpfDoc;
        this.cnhDoc = cnhDoc;
        this.tituloDoc = tituloDoc;
        this.reservistaDoc = reservistaDoc;
        this.ctpsDoc = ctpsDoc;
        this.cNascimentoDoc = cNascimentoDoc;
        this.cCasamentoDoc = cCasamentoDoc;
        this.outrosDoc = outrosDoc;
        this.dataDevolucaoDoc = dataDevolucaoDoc;
        this.observacaoDoc = observacaoDoc;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.rGVia = rGVia;
        this.reservistaVia = reservistaVia;
        this.eleitorVia = eleitorVia;
        this.cPFVia = cPFVia;
        this.cTPSVia = cTPSVia;
        this.tituloVia = tituloVia;
        this.certidaoCasaVia = certidaoCasaVia;
        this.cNHVia = cNHVia;
        this.certidaoNascVia = certidaoNascVia;
        this.passaporteVia = passaporteVia;
        this.codigoRegistro = codigoRegistro;
        this.tipoDocumento = tipoDocumento;
        this.horario = horario;
        this.motivoDevolucao = motivoDevolucao;
    }

    public DocumentosInternos() {
    }

    /**
     * @return the idDoc
     */
    public int getIdDoc() {
        return idDoc;
    }

    /**
     * @param idDoc the idDoc to set
     */
    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * @return the statusDoc
     */
    public String getStatusDoc() {
        return statusDoc;
    }

    /**
     * @param statusDoc the statusDoc to set
     */
    public void setStatusDoc(String statusDoc) {
        this.statusDoc = statusDoc;
    }

    /**
     * @return the dataDoc
     */
    public Date getDataDoc() {
        return dataDoc;
    }

    /**
     * @param dataDoc the dataDoc to set
     */
    public void setDataDoc(Date dataDoc) {
        this.dataDoc = dataDoc;
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
     * @return the rgDoc
     */
    public String getRgDoc() {
        return rgDoc;
    }

    /**
     * @param rgDoc the rgDoc to set
     */
    public void setRgDoc(String rgDoc) {
        this.rgDoc = rgDoc;
    }

    /**
     * @return the cpfDoc
     */
    public String getCpfDoc() {
        return cpfDoc;
    }

    /**
     * @param cpfDoc the cpfDoc to set
     */
    public void setCpfDoc(String cpfDoc) {
        this.cpfDoc = cpfDoc;
    }

    /**
     * @return the cnhDoc
     */
    public String getCnhDoc() {
        return cnhDoc;
    }

    /**
     * @param cnhDoc the cnhDoc to set
     */
    public void setCnhDoc(String cnhDoc) {
        this.cnhDoc = cnhDoc;
    }

    /**
     * @return the tituloDoc
     */
    public String getTituloDoc() {
        return tituloDoc;
    }

    /**
     * @param tituloDoc the tituloDoc to set
     */
    public void setTituloDoc(String tituloDoc) {
        this.tituloDoc = tituloDoc;
    }

    /**
     * @return the reservistaDoc
     */
    public String getReservistaDoc() {
        return reservistaDoc;
    }

    /**
     * @param reservistaDoc the reservistaDoc to set
     */
    public void setReservistaDoc(String reservistaDoc) {
        this.reservistaDoc = reservistaDoc;
    }

    /**
     * @return the ctpsDoc
     */
    public String getCtpsDoc() {
        return ctpsDoc;
    }

    /**
     * @param ctpsDoc the ctpsDoc to set
     */
    public void setCtpsDoc(String ctpsDoc) {
        this.ctpsDoc = ctpsDoc;
    }

    /**
     * @return the cNascimentoDoc
     */
    public String getcNascimentoDoc() {
        return cNascimentoDoc;
    }

    /**
     * @param cNascimentoDoc the cNascimentoDoc to set
     */
    public void setcNascimentoDoc(String cNascimentoDoc) {
        this.cNascimentoDoc = cNascimentoDoc;
    }

    /**
     * @return the cCasamentoDoc
     */
    public String getcCasamentoDoc() {
        return cCasamentoDoc;
    }

    /**
     * @param cCasamentoDoc the cCasamentoDoc to set
     */
    public void setcCasamentoDoc(String cCasamentoDoc) {
        this.cCasamentoDoc = cCasamentoDoc;
    }

    /**
     * @return the outrosDoc
     */
    public String getOutrosDoc() {
        return outrosDoc;
    }

    /**
     * @param outrosDoc the outrosDoc to set
     */
    public void setOutrosDoc(String outrosDoc) {
        this.outrosDoc = outrosDoc;
    }

    /**
     * @return the dataDevolucaoDoc
     */
    public Date getDataDevolucaoDoc() {
        return dataDevolucaoDoc;
    }

    /**
     * @param dataDevolucaoDoc the dataDevolucaoDoc to set
     */
    public void setDataDevolucaoDoc(Date dataDevolucaoDoc) {
        this.dataDevolucaoDoc = dataDevolucaoDoc;
    }

    /**
     * @return the observacaoDoc
     */
    public String getObservacaoDoc() {
        return observacaoDoc;
    }

    /**
     * @param observacaoDoc the observacaoDoc to set
     */
    public void setObservacaoDoc(String observacaoDoc) {
        this.observacaoDoc = observacaoDoc;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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

    /**
     * @return the rGVia
     */
    public String getrGVia() {
        return rGVia;
    }

    /**
     * @param rGVia the rGVia to set
     */
    public void setrGVia(String rGVia) {
        this.rGVia = rGVia;
    }

    /**
     * @return the reservistaVia
     */
    public String getReservistaVia() {
        return reservistaVia;
    }

    /**
     * @param reservistaVia the reservistaVia to set
     */
    public void setReservistaVia(String reservistaVia) {
        this.reservistaVia = reservistaVia;
    }

    /**
     * @return the eleitorVia
     */
    public String getEleitorVia() {
        return eleitorVia;
    }

    /**
     * @param eleitorVia the eleitorVia to set
     */
    public void setEleitorVia(String eleitorVia) {
        this.eleitorVia = eleitorVia;
    }

    /**
     * @return the cPFVia
     */
    public String getcPFVia() {
        return cPFVia;
    }

    /**
     * @param cPFVia the cPFVia to set
     */
    public void setcPFVia(String cPFVia) {
        this.cPFVia = cPFVia;
    }

    /**
     * @return the cTPSVia
     */
    public String getcTPSVia() {
        return cTPSVia;
    }

    /**
     * @param cTPSVia the cTPSVia to set
     */
    public void setcTPSVia(String cTPSVia) {
        this.cTPSVia = cTPSVia;
    }

    /**
     * @return the tituloVia
     */
    public String getTituloVia() {
        return tituloVia;
    }

    /**
     * @param tituloVia the tituloVia to set
     */
    public void setTituloVia(String tituloVia) {
        this.tituloVia = tituloVia;
    }

    /**
     * @return the certidaoCasaVia
     */
    public String getCertidaoCasaVia() {
        return certidaoCasaVia;
    }

    /**
     * @param certidaoCasaVia the certidaoCasaVia to set
     */
    public void setCertidaoCasaVia(String certidaoCasaVia) {
        this.certidaoCasaVia = certidaoCasaVia;
    }

    /**
     * @return the cNHVia
     */
    public String getcNHVia() {
        return cNHVia;
    }

    /**
     * @param cNHVia the cNHVia to set
     */
    public void setcNHVia(String cNHVia) {
        this.cNHVia = cNHVia;
    }

    /**
     * @return the certidaoNascVia
     */
    public String getCertidaoNascVia() {
        return certidaoNascVia;
    }

    /**
     * @param certidaoNascVia the certidaoNascVia to set
     */
    public void setCertidaoNascVia(String certidaoNascVia) {
        this.certidaoNascVia = certidaoNascVia;
    }

    /**
     * @return the passaporteVia
     */
    public String getPassaporteVia() {
        return passaporteVia;
    }

    /**
     * @param passaporteVia the passaporteVia to set
     */
    public void setPassaporteVia(String passaporteVia) {
        this.passaporteVia = passaporteVia;
    }

    /**
     * @return the codigoRegistro
     */
    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    /**
     * @param codigoRegistro the codigoRegistro to set
     */
    public void setCodigoRegistro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the motivoDevolucao
     */
    public String getMotivoDevolucao() {
        return motivoDevolucao;
    }

    /**
     * @param motivoDevolucao the motivoDevolucao to set
     */
    public void setMotivoDevolucao(String motivoDevolucao) {
        this.motivoDevolucao = motivoDevolucao;
    }
   
}
