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
public class ItensListaEspera {

    private int idItem;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private int idCela;
    private String descricaoCela;
    private String encaminharAtividade;
    private String profissaoInterno;
    private String ObsInt;
    //
    private int idItemOcupa;
    private int idCodigoOcupa;
    private String descricaoOcupacao;
    private String encaminhamentoOcupa;
    //
    private int idItemCursos;
    private int idCurso;
    private String descricaoCurso;
    private String encaminhamentoCurso;
    //
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;   

    public ItensListaEspera(int idItem, int idLanc, int idInternoCrc, String nomeInterno, int idCela, String descricaoCela, String encaminharAtividade, String profissaoInterno, String ObsInt, int idItemOcupa, int idCodigoOcupa, String descricaoOcupacao, String encaminhamentoOcupa, int idItemCursos, int idCurso, String descricaoCurso, String encaminhamentoCurso, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.encaminharAtividade = encaminharAtividade;
        this.profissaoInterno = profissaoInterno;
        this.ObsInt = ObsInt;
        this.idItemOcupa = idItemOcupa;
        this.idCodigoOcupa = idCodigoOcupa;
        this.descricaoOcupacao = descricaoOcupacao;
        this.encaminhamentoOcupa = encaminhamentoOcupa;
        this.idItemCursos = idItemCursos;
        this.idCurso = idCurso;
        this.descricaoCurso = descricaoCurso;
        this.encaminhamentoCurso = encaminhamentoCurso;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensListaEspera() {
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
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the encaminharAtividade
     */
    public String getEncaminharAtividade() {
        return encaminharAtividade;
    }

    /**
     * @param encaminharAtividade the encaminharAtividade to set
     */
    public void setEncaminharAtividade(String encaminharAtividade) {
        this.encaminharAtividade = encaminharAtividade;
    }

    /**
     * @return the profissaoInterno
     */
    public String getProfissaoInterno() {
        return profissaoInterno;
    }

    /**
     * @param profissaoInterno the profissaoInterno to set
     */
    public void setProfissaoInterno(String profissaoInterno) {
        this.profissaoInterno = profissaoInterno;
    }

    /**
     * @return the ObsInt
     */
    public String getObsInt() {
        return ObsInt;
    }

    /**
     * @param ObsInt the ObsInt to set
     */
    public void setObsInt(String ObsInt) {
        this.ObsInt = ObsInt;
    }

    /**
     * @return the idItemOcupa
     */
    public int getIdItemOcupa() {
        return idItemOcupa;
    }

    /**
     * @param idItemOcupa the idItemOcupa to set
     */
    public void setIdItemOcupa(int idItemOcupa) {
        this.idItemOcupa = idItemOcupa;
    }

    /**
     * @return the idCodigoOcupa
     */
    public int getIdCodigoOcupa() {
        return idCodigoOcupa;
    }

    /**
     * @param idCodigoOcupa the idCodigoOcupa to set
     */
    public void setIdCodigoOcupa(int idCodigoOcupa) {
        this.idCodigoOcupa = idCodigoOcupa;
    }

    /**
     * @return the descricaoOcupacao
     */
    public String getDescricaoOcupacao() {
        return descricaoOcupacao;
    }

    /**
     * @param descricaoOcupacao the descricaoOcupacao to set
     */
    public void setDescricaoOcupacao(String descricaoOcupacao) {
        this.descricaoOcupacao = descricaoOcupacao;
    }

    /**
     * @return the encaminhamentoOcupa
     */
    public String getEncaminhamentoOcupa() {
        return encaminhamentoOcupa;
    }

    /**
     * @param encaminhamentoOcupa the encaminhamentoOcupa to set
     */
    public void setEncaminhamentoOcupa(String encaminhamentoOcupa) {
        this.encaminhamentoOcupa = encaminhamentoOcupa;
    }

    /**
     * @return the idItemCursos
     */
    public int getIdItemCursos() {
        return idItemCursos;
    }

    /**
     * @param idItemCursos the idItemCursos to set
     */
    public void setIdItemCursos(int idItemCursos) {
        this.idItemCursos = idItemCursos;
    }

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the descricaoCurso
     */
    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    /**
     * @param descricaoCurso the descricaoCurso to set
     */
    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    /**
     * @return the encaminhamentoCurso
     */
    public String getEncaminhamentoCurso() {
        return encaminhamentoCurso;
    }

    /**
     * @param encaminhamentoCurso the encaminhamentoCurso to set
     */
    public void setEncaminhamentoCurso(String encaminhamentoCurso) {
        this.encaminhamentoCurso = encaminhamentoCurso;
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
}
