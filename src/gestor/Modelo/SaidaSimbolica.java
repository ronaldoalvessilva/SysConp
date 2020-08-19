/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ronaldo.silva7
 */
public class SaidaSimbolica {

    private Integer idRegSaida;
    private String statusRegistro;
    private Date dataRegistro;
    private String nrdocumento;
    private String varaCrime;
    private String nomeJuiz;
    private String localAudiencia;
    private String tipoBeneficio;
    private String motivoSaida;
    private Integer idItem;
    private Integer idInternoCrc;
    private String matriculaPenal;
    private String regimePenal;
    private String maeInterno;
    private String nomeInternoCrc;
    private String nrdocumentoSA;
    private Date dataRegistroSA;
    private String tipoBeneficioSA;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;  

    public SaidaSimbolica() {
    }

    public SaidaSimbolica(Integer idRegSaida, String statusRegistro, Date dataRegistro, String nrdocumento, String varaCrime, String nomeJuiz, String localAudiencia, String tipoBeneficio, String motivoSaida, Integer idItem, Integer idInternoCrc, String matriculaPenal, String regimePenal, String maeInterno, String nomeInternoCrc, String nrdocumentoSA, Date dataRegistroSA, String tipoBeneficioSA, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegSaida = idRegSaida;
        this.statusRegistro = statusRegistro;
        this.dataRegistro = dataRegistro;
        this.nrdocumento = nrdocumento;
        this.varaCrime = varaCrime;
        this.nomeJuiz = nomeJuiz;
        this.localAudiencia = localAudiencia;
        this.tipoBeneficio = tipoBeneficio;
        this.motivoSaida = motivoSaida;
        this.idItem = idItem;
        this.idInternoCrc = idInternoCrc;
        this.matriculaPenal = matriculaPenal;
        this.regimePenal = regimePenal;
        this.maeInterno = maeInterno;
        this.nomeInternoCrc = nomeInternoCrc;
        this.nrdocumentoSA = nrdocumentoSA;
        this.dataRegistroSA = dataRegistroSA;
        this.tipoBeneficioSA = tipoBeneficioSA;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegSaida
     */
    public Integer getIdRegSaida() {
        return idRegSaida;
    }

    /**
     * @param idRegSaida the idRegSaida to set
     */
    public void setIdRegSaida(Integer idRegSaida) {
        this.idRegSaida = idRegSaida;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the nrdocumento
     */
    public String getNrdocumento() {
        return nrdocumento;
    }

    /**
     * @param nrdocumento the nrdocumento to set
     */
    public void setNrdocumento(String nrdocumento) {
        this.nrdocumento = nrdocumento;
    }

    /**
     * @return the varaCrime
     */
    public String getVaraCrime() {
        return varaCrime;
    }

    /**
     * @param varaCrime the varaCrime to set
     */
    public void setVaraCrime(String varaCrime) {
        this.varaCrime = varaCrime;
    }

    /**
     * @return the nomeJuiz
     */
    public String getNomeJuiz() {
        return nomeJuiz;
    }

    /**
     * @param nomeJuiz the nomeJuiz to set
     */
    public void setNomeJuiz(String nomeJuiz) {
        this.nomeJuiz = nomeJuiz;
    }

    /**
     * @return the localAudiencia
     */
    public String getLocalAudiencia() {
        return localAudiencia;
    }

    /**
     * @param localAudiencia the localAudiencia to set
     */
    public void setLocalAudiencia(String localAudiencia) {
        this.localAudiencia = localAudiencia;
    }

    /**
     * @return the tipoBeneficio
     */
    public String getTipoBeneficio() {
        return tipoBeneficio;
    }

    /**
     * @param tipoBeneficio the tipoBeneficio to set
     */
    public void setTipoBeneficio(String tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    /**
     * @return the motivoSaida
     */
    public String getMotivoSaida() {
        return motivoSaida;
    }

    /**
     * @param motivoSaida the motivoSaida to set
     */
    public void setMotivoSaida(String motivoSaida) {
        this.motivoSaida = motivoSaida;
    }

    /**
     * @return the idItem
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idInternoCrc
     */
    public Integer getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(Integer idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the matriculaPenal
     */
    public String getMatriculaPenal() {
        return matriculaPenal;
    }

    /**
     * @param matriculaPenal the matriculaPenal to set
     */
    public void setMatriculaPenal(String matriculaPenal) {
        this.matriculaPenal = matriculaPenal;
    }

    /**
     * @return the regimePenal
     */
    public String getRegimePenal() {
        return regimePenal;
    }

    /**
     * @param regimePenal the regimePenal to set
     */
    public void setRegimePenal(String regimePenal) {
        this.regimePenal = regimePenal;
    }

    /**
     * @return the maeInterno
     */
    public String getMaeInterno() {
        return maeInterno;
    }

    /**
     * @param maeInterno the maeInterno to set
     */
    public void setMaeInterno(String maeInterno) {
        this.maeInterno = maeInterno;
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
     * @return the nrdocumentoSA
     */
    public String getNrdocumentoSA() {
        return nrdocumentoSA;
    }

    /**
     * @param nrdocumentoSA the nrdocumentoSA to set
     */
    public void setNrdocumentoSA(String nrdocumentoSA) {
        this.nrdocumentoSA = nrdocumentoSA;
    }

    /**
     * @return the dataRegistroSA
     */
    public Date getDataRegistroSA() {
        return dataRegistroSA;
    }

    /**
     * @param dataRegistroSA the dataRegistroSA to set
     */
    public void setDataRegistroSA(Date dataRegistroSA) {
        this.dataRegistroSA = dataRegistroSA;
    }

    /**
     * @return the tipoBeneficioSA
     */
    public String getTipoBeneficioSA() {
        return tipoBeneficioSA;
    }

    /**
     * @param tipoBeneficioSA the tipoBeneficioSA to set
     */
    public void setTipoBeneficioSA(String tipoBeneficioSA) {
        this.tipoBeneficioSA = tipoBeneficioSA;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idRegSaida);
        hash = 97 * hash + Objects.hashCode(this.idItem);
        hash = 97 * hash + Objects.hashCode(this.idInternoCrc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaidaSimbolica other = (SaidaSimbolica) obj;
        if (!Objects.equals(this.idRegSaida, other.idRegSaida)) {
            return false;
        }
        if (!Objects.equals(this.idItem, other.idItem)) {
            return false;
        }
        if (!Objects.equals(this.idInternoCrc, other.idInternoCrc)) {
            return false;
        }
        return true;
    }
}
