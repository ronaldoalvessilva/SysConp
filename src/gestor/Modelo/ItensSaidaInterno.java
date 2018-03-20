/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class ItensSaidaInterno {

    private int idSaida;
    private int idItemSaida;
    private Date dataSaida;
    private Date dataRetorno;
    private String nomeDestino;
    private String documento;
    private int idInternoSaida;
    private String nomeInterno;
    private String nomeUnidade;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String internoEvadido;
    private String confirmaRetorno;   
    private String confirmaEvasao; 
    private String dataEvasao;  
    private String confirmaSaida;    
    private Date dataEvasaoTmp;    
    private String obito;
    private String confirmaObito;    

    public ItensSaidaInterno(int idSaida, int idItemSaida, Date dataSaida, Date dataRetorno, String nomeDestino, String documento, int idInternoSaida, String nomeInterno, String nomeUnidade, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String internoEvadido, String confirmaRetorno, String confirmaEvasao, String dataEvasao, String confirmaSaida, Date dataEvasaoTmp, String obito, String confirmaObito) {
        this.idSaida = idSaida;
        this.idItemSaida = idItemSaida;
        this.dataSaida = dataSaida;
        this.dataRetorno = dataRetorno;
        this.nomeDestino = nomeDestino;
        this.documento = documento;
        this.idInternoSaida = idInternoSaida;
        this.nomeInterno = nomeInterno;
        this.nomeUnidade = nomeUnidade;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.internoEvadido = internoEvadido;
        this.confirmaRetorno = confirmaRetorno;
        this.confirmaEvasao = confirmaEvasao;
        this.dataEvasao = dataEvasao;
        this.confirmaSaida = confirmaSaida;
        this.dataEvasaoTmp = dataEvasaoTmp;
        this.obito = obito;
        this.confirmaObito = confirmaObito;
    }

    public ItensSaidaInterno() {
    }

    /**
     * @return the idSaida
     */
    public int getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    /**
     * @return the idItemSaida
     */
    public int getIdItemSaida() {
        return idItemSaida;
    }

    /**
     * @param idItemSaida the idItemSaida to set
     */
    public void setIdItemSaida(int idItemSaida) {
        this.idItemSaida = idItemSaida;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the nomeDestino
     */
    public String getNomeDestino() {
        return nomeDestino;
    }

    /**
     * @param nomeDestino the nomeDestino to set
     */
    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the idInternoSaida
     */
    public int getIdInternoSaida() {
        return idInternoSaida;
    }

    /**
     * @param idInternoSaida the idInternoSaida to set
     */
    public void setIdInternoSaida(int idInternoSaida) {
        this.idInternoSaida = idInternoSaida;
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
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
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
     * @return the internoEvadido
     */
    public String getInternoEvadido() {
        return internoEvadido;
    }

    /**
     * @param internoEvadido the internoEvadido to set
     */
    public void setInternoEvadido(String internoEvadido) {
        this.internoEvadido = internoEvadido;
    }

    /**
     * @return the confirmaRetorno
     */
    public String getConfirmaRetorno() {
        return confirmaRetorno;
    }

    /**
     * @param confirmaRetorno the confirmaRetorno to set
     */
    public void setConfirmaRetorno(String confirmaRetorno) {
        this.confirmaRetorno = confirmaRetorno;
    }

    /**
     * @return the confirmaEvasao
     */
    public String getConfirmaEvasao() {
        return confirmaEvasao;
    }

    /**
     * @param confirmaEvasao the confirmaEvasao to set
     */
    public void setConfirmaEvasao(String confirmaEvasao) {
        this.confirmaEvasao = confirmaEvasao;
    }

    /**
     * @return the dataEvasao
     */
    public String getDataEvasao() {
        return dataEvasao;
    }

    /**
     * @param dataEvasao the dataEvasao to set
     */
    public void setDataEvasao(String dataEvasao) {
        this.dataEvasao = dataEvasao;
    }

    /**
     * @return the confirmaSaida
     */
    public String getConfirmaSaida() {
        return confirmaSaida;
    }

    /**
     * @param confirmaSaida the confirmaSaida to set
     */
    public void setConfirmaSaida(String confirmaSaida) {
        this.confirmaSaida = confirmaSaida;
    }

    /**
     * @return the dataEvasaoTmp
     */
    public Date getDataEvasaoTmp() {
        return dataEvasaoTmp;
    }

    /**
     * @param dataEvasaoTmp the dataEvasaoTmp to set
     */
    public void setDataEvasaoTmp(Date dataEvasaoTmp) {
        this.dataEvasaoTmp = dataEvasaoTmp;
    }

    /**
     * @return the obito
     */
    public String getObito() {
        return obito;
    }

    /**
     * @param obito the obito to set
     */
    public void setObito(String obito) {
        this.obito = obito;
    }

    /**
     * @return the confirmaObito
     */
    public String getConfirmaObito() {
        return confirmaObito;
    }

    /**
     * @param confirmaObito the confirmaObito to set
     */
    public void setConfirmaObito(String confirmaObito) {
        this.confirmaObito = confirmaObito;
    }
}
