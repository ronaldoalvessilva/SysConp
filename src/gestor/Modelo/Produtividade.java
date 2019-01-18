/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author geiba
 */
public class Produtividade {
    
    private int idRegistro;
    private DateTime dataRegistro;
    private String horario;
    private int idInternoCRC; // FK
    private String tipoAtendimento;
    private int idDepartamento; //FK
    private byte assinaturaDigital;
    private String atendido;
    private int idAtendimento;
    private int evolucao;
    private DateTime dataAtendimento;
    private String usuarioInsert;
    private String usuarioUpdate;
    private String dataInsert;
    private String dataUpdate;
    private String horarioInsert;
    private String horarioUpdate;
    private String impresso;
    private int idFuncionario;
    private String dataAssinatura;
    private String horaAssinatura;
    private String motivo;
    private byte assinaturaLiberador;
    private String atendeEvolucao;    

    /**
     * @return the idRegistro
     */
    public int getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public DateTime getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(DateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
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
     * @return the idInternoCRC
     */
    public int getIdInternoCRC() {
        return idInternoCRC;
    }

    /**
     * @param idInternoCRC the idInternoCRC to set
     */
    public void setIdInternoCRC(int idInternoCRC) {
        this.idInternoCRC = idInternoCRC;
    }

    /**
     * @return the tipoAtendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * @param tipoAtendimento the tipoAtendimento to set
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the assinaturaDigital
     */
    public byte getAssinaturaDigital() {
        return assinaturaDigital;
    }

    /**
     * @param assinaturaDigital the assinaturaDigital to set
     */
    public void setAssinaturaDigital(byte assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    /**
     * @return the atendido
     */
    public String getAtendido() {
        return atendido;
    }

    /**
     * @param atendido the atendido to set
     */
    public void setAtendido(String atendido) {
        this.atendido = atendido;
    }

    /**
     * @return the idAtendimento
     */
    public int getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * @param idAtendimento the idAtendimento to set
     */
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    /**
     * @return the evolucao
     */
    public int getEvolucao() {
        return evolucao;
    }

    /**
     * @param evolucao the evolucao to set
     */
    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }

    /**
     * @return the dataAtendimento
     */
    public DateTime getDataAtendimento() {
        return dataAtendimento;
    }

    /**
     * @param dataAtendimento the dataAtendimento to set
     */
    public void setDataAtendimento(DateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
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
     * @return the usuarioUpdate
     */
    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    /**
     * @param usuarioUpdate the usuarioUpdate to set
     */
    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
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
     * @return the dataUpdate
     */
    public String getDataUpdate() {
        return dataUpdate;
    }

    /**
     * @param dataUpdate the dataUpdate to set
     */
    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
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
     * @return the horarioUpdate
     */
    public String getHorarioUpdate() {
        return horarioUpdate;
    }

    /**
     * @param horarioUpdate the horarioUpdate to set
     */
    public void setHorarioUpdate(String horarioUpdate) {
        this.horarioUpdate = horarioUpdate;
    }

    /**
     * @return the impresso
     */
    public String getImpresso() {
        return impresso;
    }

    /**
     * @param impresso the impresso to set
     */
    public void setImpresso(String impresso) {
        this.impresso = impresso;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the dataAssinatura
     */
    public String getDataAssinatura() {
        return dataAssinatura;
    }

    /**
     * @param dataAssinatura the dataAssinatura to set
     */
    public void setDataAssinatura(String dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    /**
     * @return the horaAssinatura
     */
    public String getHoraAssinatura() {
        return horaAssinatura;
    }

    /**
     * @param horaAssinatura the horaAssinatura to set
     */
    public void setHoraAssinatura(String horaAssinatura) {
        this.horaAssinatura = horaAssinatura;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the assinaturaLiberador
     */
    public byte getAssinaturaLiberador() {
        return assinaturaLiberador;
    }

    /**
     * @param assinaturaLiberador the assinaturaLiberador to set
     */
    public void setAssinaturaLiberador(byte assinaturaLiberador) {
        this.assinaturaLiberador = assinaturaLiberador;
    }

    /**
     * @return the atendeEvolucao
     */
    public String getAtendeEvolucao() {
        return atendeEvolucao;
    }

    /**
     * @param atendeEvolucao the atendeEvolucao to set
     */
    public void setAtendeEvolucao(String atendeEvolucao) {
        this.atendeEvolucao = atendeEvolucao;
    }
}

