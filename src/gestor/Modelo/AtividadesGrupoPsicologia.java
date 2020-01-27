/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class AtividadesGrupoPsicologia {

    //ABA MANUTENÇÃO
    private int idAtGrupoPsi;
    private String statusAtendGrupo;
    private Date dataAtend;
    private String responsavel;
    private int idPav;
    private int idCela;
    private String descricaoPavilhao;
    private String descricaoCela;
    private String ambiente;
    private String horaioInicio;
    private String horarioTermino;
    private String localAtividade;
    private String grupoAtividade;
    private String observacao;
    // ABA PLANEJAMENTO
    private int idItemPlan;
    private String tema;
    private String horaInicio;
    private String horaTermino;
    private String turno;
    private String atividades;
    private String recursos;
    private String textoAtendimento;
    // ABA PARTICIPANTES
    private int idItemPart;
    private int idInternoCrc;
    private String nomeInternoCrc;
    // ABA AVALIAÇÃO EM GRUPO
    private int idItemAvag;
    private String textoAvalaiacaoGrupo;
    // ABA AVALIAÇÃO INDIVIDUAL
    private int idItemAvai;
    private String textoAvalaiacaoInd;
    //
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public AtividadesGrupoPsicologia() {
    }

    public AtividadesGrupoPsicologia(int idAtGrupoPsi, String statusAtendGrupo, Date dataAtend, String responsavel, int idPav, int idCela, String descricaoPavilhao, String descricaoCela, String ambiente, String horaioInicio, String horarioTermino, String localAtividade, String grupoAtividade, String observacao, int idItemPlan, String tema, String horaInicio, String horaTermino, String turno, String atividades, String recursos, String textoAtendimento, int idItemPart, int idInternoCrc, String nomeInternoCrc, int idItemAvag, String textoAvalaiacaoGrupo, int idItemAvai, String textoAvalaiacaoInd, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idAtGrupoPsi = idAtGrupoPsi;
        this.statusAtendGrupo = statusAtendGrupo;
        this.dataAtend = dataAtend;
        this.responsavel = responsavel;
        this.idPav = idPav;
        this.idCela = idCela;
        this.descricaoPavilhao = descricaoPavilhao;
        this.descricaoCela = descricaoCela;
        this.ambiente = ambiente;
        this.horaioInicio = horaioInicio;
        this.horarioTermino = horarioTermino;
        this.localAtividade = localAtividade;
        this.grupoAtividade = grupoAtividade;
        this.observacao = observacao;
        this.idItemPlan = idItemPlan;
        this.tema = tema;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.turno = turno;
        this.atividades = atividades;
        this.recursos = recursos;
        this.textoAtendimento = textoAtendimento;
        this.idItemPart = idItemPart;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idItemAvag = idItemAvag;
        this.textoAvalaiacaoGrupo = textoAvalaiacaoGrupo;
        this.idItemAvai = idItemAvai;
        this.textoAvalaiacaoInd = textoAvalaiacaoInd;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idAtGrupoPsi
     */
    public int getIdAtGrupoPsi() {
        return idAtGrupoPsi;
    }

    /**
     * @param idAtGrupoPsi the idAtGrupoPsi to set
     */
    public void setIdAtGrupoPsi(int idAtGrupoPsi) {
        this.idAtGrupoPsi = idAtGrupoPsi;
    }

    /**
     * @return the statusAtendGrupo
     */
    public String getStatusAtendGrupo() {
        return statusAtendGrupo;
    }

    /**
     * @param statusAtendGrupo the statusAtendGrupo to set
     */
    public void setStatusAtendGrupo(String statusAtendGrupo) {
        this.statusAtendGrupo = statusAtendGrupo;
    }

    /**
     * @return the dataAtend
     */
    public Date getDataAtend() {
        return dataAtend;
    }

    /**
     * @param dataAtend the dataAtend to set
     */
    public void setDataAtend(Date dataAtend) {
        this.dataAtend = dataAtend;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the horaioInicio
     */
    public String getHoraioInicio() {
        return horaioInicio;
    }

    /**
     * @param horaioInicio the horaioInicio to set
     */
    public void setHoraioInicio(String horaioInicio) {
        this.horaioInicio = horaioInicio;
    }

    /**
     * @return the horarioTermino
     */
    public String getHorarioTermino() {
        return horarioTermino;
    }

    /**
     * @param horarioTermino the horarioTermino to set
     */
    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    /**
     * @return the localAtividade
     */
    public String getLocalAtividade() {
        return localAtividade;
    }

    /**
     * @param localAtividade the localAtividade to set
     */
    public void setLocalAtividade(String localAtividade) {
        this.localAtividade = localAtividade;
    }

    /**
     * @return the grupoAtividade
     */
    public String getGrupoAtividade() {
        return grupoAtividade;
    }

    /**
     * @param grupoAtividade the grupoAtividade to set
     */
    public void setGrupoAtividade(String grupoAtividade) {
        this.grupoAtividade = grupoAtividade;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the idItemPlan
     */
    public int getIdItemPlan() {
        return idItemPlan;
    }

    /**
     * @param idItemPlan the idItemPlan to set
     */
    public void setIdItemPlan(int idItemPlan) {
        this.idItemPlan = idItemPlan;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaTermino
     */
    public String getHoraTermino() {
        return horaTermino;
    }

    /**
     * @param horaTermino the horaTermino to set
     */
    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the atividades
     */
    public String getAtividades() {
        return atividades;
    }

    /**
     * @param atividades the atividades to set
     */
    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    /**
     * @return the recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the textoAtendimento
     */
    public String getTextoAtendimento() {
        return textoAtendimento;
    }

    /**
     * @param textoAtendimento the textoAtendimento to set
     */
    public void setTextoAtendimento(String textoAtendimento) {
        this.textoAtendimento = textoAtendimento;
    }

    /**
     * @return the idItemPart
     */
    public int getIdItemPart() {
        return idItemPart;
    }

    /**
     * @param idItemPart the idItemPart to set
     */
    public void setIdItemPart(int idItemPart) {
        this.idItemPart = idItemPart;
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
     * @return the idItemAvag
     */
    public int getIdItemAvag() {
        return idItemAvag;
    }

    /**
     * @param idItemAvag the idItemAvag to set
     */
    public void setIdItemAvag(int idItemAvag) {
        this.idItemAvag = idItemAvag;
    }

    /**
     * @return the textoAvalaiacaoGrupo
     */
    public String getTextoAvalaiacaoGrupo() {
        return textoAvalaiacaoGrupo;
    }

    /**
     * @param textoAvalaiacaoGrupo the textoAvalaiacaoGrupo to set
     */
    public void setTextoAvalaiacaoGrupo(String textoAvalaiacaoGrupo) {
        this.textoAvalaiacaoGrupo = textoAvalaiacaoGrupo;
    }

    /**
     * @return the idItemAvai
     */
    public int getIdItemAvai() {
        return idItemAvai;
    }

    /**
     * @param idItemAvai the idItemAvai to set
     */
    public void setIdItemAvai(int idItemAvai) {
        this.idItemAvai = idItemAvai;
    }

    /**
     * @return the textoAvalaiacaoInd
     */
    public String getTextoAvalaiacaoInd() {
        return textoAvalaiacaoInd;
    }

    /**
     * @param textoAvalaiacaoInd the textoAvalaiacaoInd to set
     */
    public void setTextoAvalaiacaoInd(String textoAvalaiacaoInd) {
        this.textoAvalaiacaoInd = textoAvalaiacaoInd;
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
