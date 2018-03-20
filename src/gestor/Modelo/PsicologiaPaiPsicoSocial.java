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
public class PsicologiaPaiPsicoSocial {

    private int IdPsiPai;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String transtornoMental;
    private String tratamentoAnterior;
    private String quaisTratamentosMentais;
    private String outrosTratamento;
    private String foiInternado;
    private String especificarFrequenciasLocais;
    private String medicacoesUtilizadas;
    private String episodioDepressivo;
    private String surtoPsicotico;
    private String tentativaSuicidio;
    private String comportamentoViolento;
    private String envolveJustica;
    private String usoMedicaPsiquia;
    private String observacaoDepressivo;
    private String observacaoSurto;
    private String observacaoTentativaSuicidio;
    private String observacaoComportamentoViolento;
    private String observacaoEnvolveJustica;
    private String observacaoUsoMedicacoPsiquiatrica;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public PsicologiaPaiPsicoSocial(int IdPsiPai, int idPai, int idInternoCrc, String nomeInternoCrc, String transtornoMental, String tratamentoAnterior, String quaisTratamentosMentais, String outrosTratamento, String foiInternado, String especificarFrequenciasLocais, String medicacoesUtilizadas, String episodioDepressivo, String surtoPsicotico, String tentativaSuicidio, String comportamentoViolento, String envolveJustica, String usoMedicaPsiquia, String observacaoDepressivo, String observacaoSurto, String observacaoTentativaSuicidio, String observacaoComportamentoViolento, String observacaoEnvolveJustica, String observacaoUsoMedicacoPsiquiatrica, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.IdPsiPai = IdPsiPai;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.transtornoMental = transtornoMental;
        this.tratamentoAnterior = tratamentoAnterior;
        this.quaisTratamentosMentais = quaisTratamentosMentais;
        this.outrosTratamento = outrosTratamento;
        this.foiInternado = foiInternado;
        this.especificarFrequenciasLocais = especificarFrequenciasLocais;
        this.medicacoesUtilizadas = medicacoesUtilizadas;
        this.episodioDepressivo = episodioDepressivo;
        this.surtoPsicotico = surtoPsicotico;
        this.tentativaSuicidio = tentativaSuicidio;
        this.comportamentoViolento = comportamentoViolento;
        this.envolveJustica = envolveJustica;
        this.usoMedicaPsiquia = usoMedicaPsiquia;
        this.observacaoDepressivo = observacaoDepressivo;
        this.observacaoSurto = observacaoSurto;
        this.observacaoTentativaSuicidio = observacaoTentativaSuicidio;
        this.observacaoComportamentoViolento = observacaoComportamentoViolento;
        this.observacaoEnvolveJustica = observacaoEnvolveJustica;
        this.observacaoUsoMedicacoPsiquiatrica = observacaoUsoMedicacoPsiquiatrica;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PsicologiaPaiPsicoSocial() {
    }

    /**
     * @return the IdPsiPai
     */
    public int getIdPsiPai() {
        return IdPsiPai;
    }

    /**
     * @param IdPsiPai the IdPsiPai to set
     */
    public void setIdPsiPai(int IdPsiPai) {
        this.IdPsiPai = IdPsiPai;
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the transtornoMental
     */
    public String getTranstornoMental() {
        return transtornoMental;
    }

    /**
     * @param transtornoMental the transtornoMental to set
     */
    public void setTranstornoMental(String transtornoMental) {
        this.transtornoMental = transtornoMental;
    }

    /**
     * @return the tratamentoAnterior
     */
    public String getTratamentoAnterior() {
        return tratamentoAnterior;
    }

    /**
     * @param tratamentoAnterior the tratamentoAnterior to set
     */
    public void setTratamentoAnterior(String tratamentoAnterior) {
        this.tratamentoAnterior = tratamentoAnterior;
    }

    /**
     * @return the quaisTratamentosMentais
     */
    public String getQuaisTratamentosMentais() {
        return quaisTratamentosMentais;
    }

    /**
     * @param quaisTratamentosMentais the quaisTratamentosMentais to set
     */
    public void setQuaisTratamentosMentais(String quaisTratamentosMentais) {
        this.quaisTratamentosMentais = quaisTratamentosMentais;
    }

    /**
     * @return the outrosTratamento
     */
    public String getOutrosTratamento() {
        return outrosTratamento;
    }

    /**
     * @param outrosTratamento the outrosTratamento to set
     */
    public void setOutrosTratamento(String outrosTratamento) {
        this.outrosTratamento = outrosTratamento;
    }

    /**
     * @return the foiInternado
     */
    public String getFoiInternado() {
        return foiInternado;
    }

    /**
     * @param foiInternado the foiInternado to set
     */
    public void setFoiInternado(String foiInternado) {
        this.foiInternado = foiInternado;
    }

    /**
     * @return the especificarFrequenciasLocais
     */
    public String getEspecificarFrequenciasLocais() {
        return especificarFrequenciasLocais;
    }

    /**
     * @param especificarFrequenciasLocais the especificarFrequenciasLocais to set
     */
    public void setEspecificarFrequenciasLocais(String especificarFrequenciasLocais) {
        this.especificarFrequenciasLocais = especificarFrequenciasLocais;
    }

    /**
     * @return the medicacoesUtilizadas
     */
    public String getMedicacoesUtilizadas() {
        return medicacoesUtilizadas;
    }

    /**
     * @param medicacoesUtilizadas the medicacoesUtilizadas to set
     */
    public void setMedicacoesUtilizadas(String medicacoesUtilizadas) {
        this.medicacoesUtilizadas = medicacoesUtilizadas;
    }

    /**
     * @return the episodioDepressivo
     */
    public String getEpisodioDepressivo() {
        return episodioDepressivo;
    }

    /**
     * @param episodioDepressivo the episodioDepressivo to set
     */
    public void setEpisodioDepressivo(String episodioDepressivo) {
        this.episodioDepressivo = episodioDepressivo;
    }

    /**
     * @return the surtoPsicotico
     */
    public String getSurtoPsicotico() {
        return surtoPsicotico;
    }

    /**
     * @param surtoPsicotico the surtoPsicotico to set
     */
    public void setSurtoPsicotico(String surtoPsicotico) {
        this.surtoPsicotico = surtoPsicotico;
    }

    /**
     * @return the tentativaSuicidio
     */
    public String getTentativaSuicidio() {
        return tentativaSuicidio;
    }

    /**
     * @param tentativaSuicidio the tentativaSuicidio to set
     */
    public void setTentativaSuicidio(String tentativaSuicidio) {
        this.tentativaSuicidio = tentativaSuicidio;
    }

    /**
     * @return the comportamentoViolento
     */
    public String getComportamentoViolento() {
        return comportamentoViolento;
    }

    /**
     * @param comportamentoViolento the comportamentoViolento to set
     */
    public void setComportamentoViolento(String comportamentoViolento) {
        this.comportamentoViolento = comportamentoViolento;
    }

    /**
     * @return the envolveJustica
     */
    public String getEnvolveJustica() {
        return envolveJustica;
    }

    /**
     * @param envolveJustica the envolveJustica to set
     */
    public void setEnvolveJustica(String envolveJustica) {
        this.envolveJustica = envolveJustica;
    }

    /**
     * @return the usoMedicaPsiquia
     */
    public String getUsoMedicaPsiquia() {
        return usoMedicaPsiquia;
    }

    /**
     * @param usoMedicaPsiquia the usoMedicaPsiquia to set
     */
    public void setUsoMedicaPsiquia(String usoMedicaPsiquia) {
        this.usoMedicaPsiquia = usoMedicaPsiquia;
    }

    /**
     * @return the observacaoDepressivo
     */
    public String getObservacaoDepressivo() {
        return observacaoDepressivo;
    }

    /**
     * @param observacaoDepressivo the observacaoDepressivo to set
     */
    public void setObservacaoDepressivo(String observacaoDepressivo) {
        this.observacaoDepressivo = observacaoDepressivo;
    }

    /**
     * @return the observacaoSurto
     */
    public String getObservacaoSurto() {
        return observacaoSurto;
    }

    /**
     * @param observacaoSurto the observacaoSurto to set
     */
    public void setObservacaoSurto(String observacaoSurto) {
        this.observacaoSurto = observacaoSurto;
    }

    /**
     * @return the observacaoTentativaSuicidio
     */
    public String getObservacaoTentativaSuicidio() {
        return observacaoTentativaSuicidio;
    }

    /**
     * @param observacaoTentativaSuicidio the observacaoTentativaSuicidio to set
     */
    public void setObservacaoTentativaSuicidio(String observacaoTentativaSuicidio) {
        this.observacaoTentativaSuicidio = observacaoTentativaSuicidio;
    }

    /**
     * @return the observacaoComportamentoViolento
     */
    public String getObservacaoComportamentoViolento() {
        return observacaoComportamentoViolento;
    }

    /**
     * @param observacaoComportamentoViolento the observacaoComportamentoViolento to set
     */
    public void setObservacaoComportamentoViolento(String observacaoComportamentoViolento) {
        this.observacaoComportamentoViolento = observacaoComportamentoViolento;
    }

    /**
     * @return the observacaoEnvolveJustica
     */
    public String getObservacaoEnvolveJustica() {
        return observacaoEnvolveJustica;
    }

    /**
     * @param observacaoEnvolveJustica the observacaoEnvolveJustica to set
     */
    public void setObservacaoEnvolveJustica(String observacaoEnvolveJustica) {
        this.observacaoEnvolveJustica = observacaoEnvolveJustica;
    }

    /**
     * @return the observacaoUsoMedicacoPsiquiatrica
     */
    public String getObservacaoUsoMedicacoPsiquiatrica() {
        return observacaoUsoMedicacoPsiquiatrica;
    }

    /**
     * @param observacaoUsoMedicacoPsiquiatrica the observacaoUsoMedicacoPsiquiatrica to set
     */
    public void setObservacaoUsoMedicacoPsiquiatrica(String observacaoUsoMedicacoPsiquiatrica) {
        this.observacaoUsoMedicacoPsiquiatrica = observacaoUsoMedicacoPsiquiatrica;
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
