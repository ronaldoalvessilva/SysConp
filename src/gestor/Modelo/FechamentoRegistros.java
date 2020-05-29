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

    public FechamentoRegistros() {
    }

    public FechamentoRegistros(String statusRegistro, String usuarioUp, String dataFechamento, String horaFechamento) {
        this.statusRegistro = statusRegistro;
        this.usuarioUp = usuarioUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
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
}
