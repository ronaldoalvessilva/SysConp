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
public class UsuarioConectado {

    private int idUser;
    private String dataPlugado;
    private String dataDesconectado;
    private String horarioPlugado;
    private String horarioDesconectado;
    private String nomeUsuario;
    private String conectadoDesconectado;
    private String hostName;
    private String ipHost; 
    private String statusFlag;      

    public UsuarioConectado(int idUser, String dataPlugado, String dataDesconectado, String horarioPlugado, String horarioDesconectado, String nomeUsuario, String conectadoDesconectado, String hostName, String ipHost, String statusFlag) {
        this.idUser = idUser;
        this.dataPlugado = dataPlugado;
        this.dataDesconectado = dataDesconectado;
        this.horarioPlugado = horarioPlugado;
        this.horarioDesconectado = horarioDesconectado;
        this.nomeUsuario = nomeUsuario;
        this.conectadoDesconectado = conectadoDesconectado;
        this.hostName = hostName;
        this.ipHost = ipHost;
        this.statusFlag = statusFlag;
    }

    public UsuarioConectado() {
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the dataPlugado
     */
    public String getDataPlugado() {
        return dataPlugado;
    }

    /**
     * @param dataPlugado the dataPlugado to set
     */
    public void setDataPlugado(String dataPlugado) {
        this.dataPlugado = dataPlugado;
    }

    /**
     * @return the dataDesconectado
     */
    public String getDataDesconectado() {
        return dataDesconectado;
    }

    /**
     * @param dataDesconectado the dataDesconectado to set
     */
    public void setDataDesconectado(String dataDesconectado) {
        this.dataDesconectado = dataDesconectado;
    }

    /**
     * @return the horarioPlugado
     */
    public String getHorarioPlugado() {
        return horarioPlugado;
    }

    /**
     * @param horarioPlugado the horarioPlugado to set
     */
    public void setHorarioPlugado(String horarioPlugado) {
        this.horarioPlugado = horarioPlugado;
    }

    /**
     * @return the horarioDesconectado
     */
    public String getHorarioDesconectado() {
        return horarioDesconectado;
    }

    /**
     * @param horarioDesconectado the horarioDesconectado to set
     */
    public void setHorarioDesconectado(String horarioDesconectado) {
        this.horarioDesconectado = horarioDesconectado;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the conectadoDesconectado
     */
    public String getConectadoDesconectado() {
        return conectadoDesconectado;
    }

    /**
     * @param conectadoDesconectado the conectadoDesconectado to set
     */
    public void setConectadoDesconectado(String conectadoDesconectado) {
        this.conectadoDesconectado = conectadoDesconectado;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * @return the ipHost
     */
    public String getIpHost() {
        return ipHost;
    }

    /**
     * @param ipHost the ipHost to set
     */
    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    /**
     * @return the statusFlag
     */
    public String getStatusFlag() {
        return statusFlag;
    }

    /**
     * @param statusFlag the statusFlag to set
     */
    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }
}
