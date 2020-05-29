/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronal
 */
public class FechamentoRegistros {
    
    private String statusRegistro;
    private String usuarioUp;
    private String dataFechamento;
    private String horaFechamento;
    private String sistemaManutencao;
    private String opcaoBloquear;
    private String opcaoDesbloquear;

    public FechamentoRegistros() {
    }

    public FechamentoRegistros(String statusRegistro, String usuarioUp, String dataFechamento, String horaFechamento, String sistemaManutencao, String opcaoBloquear, String opcaoDesbloquear) {
        this.statusRegistro = statusRegistro;
        this.usuarioUp = usuarioUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.sistemaManutencao = sistemaManutencao;
        this.opcaoBloquear = opcaoBloquear;
        this.opcaoDesbloquear = opcaoDesbloquear;
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
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    /**
     * @return the sistemaManutencao
     */
    public String getSistemaManutencao() {
        return sistemaManutencao;
    }

    /**
     * @param sistemaManutencao the sistemaManutencao to set
     */
    public void setSistemaManutencao(String sistemaManutencao) {
        this.sistemaManutencao = sistemaManutencao;
    }

    /**
     * @return the opcaoBloquear
     */
    public String getOpcaoBloquear() {
        return opcaoBloquear;
    }

    /**
     * @param opcaoBloquear the opcaoBloquear to set
     */
    public void setOpcaoBloquear(String opcaoBloquear) {
        this.opcaoBloquear = opcaoBloquear;
    }

    /**
     * @return the opcaoDesbloquear
     */
    public String getOpcaoDesbloquear() {
        return opcaoDesbloquear;
    }

    /**
     * @param opcaoDesbloquear the opcaoDesbloquear to set
     */
    public void setOpcaoDesbloquear(String opcaoDesbloquear) {
        this.opcaoDesbloquear = opcaoDesbloquear;
    }
}
