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
public class LivrosRevistasJornais {

    private int idLivro;
    private String statusLivro;
    private String tipoLivro;
    private String tituloLivro;
    private int idForn;
    private String nomeEditora;
    private String codigoBarra;
    private int prazoEmp;
    private String idioma;
    private Date dataAquisicao;
    private int idCat;
    private String descricaoCategoria;
    private String iSBN;
    private String volume;
    private String edicao;
    private String paginas;
    private int idLocal;
    private String descricaoLocal;
    private String observacao;
    private String foto1;
    private String foto2;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public LivrosRevistasJornais(int idLivro, String statusLivro, String tipoLivro, String tituloLivro, int idForn, String nomeEditora, String codigoBarra, int prazoEmp, String idioma, Date dataAquisicao, int idCat, String descricaoCategoria, String iSBN, String volume, String edicao, String paginas, int idLocal, String descricaoLocal, String observacao, String foto1, String foto2, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idLivro = idLivro;
        this.statusLivro = statusLivro;
        this.tipoLivro = tipoLivro;
        this.tituloLivro = tituloLivro;
        this.idForn = idForn;
        this.nomeEditora = nomeEditora;
        this.codigoBarra = codigoBarra;
        this.prazoEmp = prazoEmp;
        this.idioma = idioma;
        this.dataAquisicao = dataAquisicao;
        this.idCat = idCat;
        this.descricaoCategoria = descricaoCategoria;
        this.iSBN = iSBN;
        this.volume = volume;
        this.edicao = edicao;
        this.paginas = paginas;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.observacao = observacao;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public LivrosRevistasJornais() {
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the statusLivro
     */
    public String getStatusLivro() {
        return statusLivro;
    }

    /**
     * @param statusLivro the statusLivro to set
     */
    public void setStatusLivro(String statusLivro) {
        this.statusLivro = statusLivro;
    }

    /**
     * @return the tipoLivro
     */
    public String getTipoLivro() {
        return tipoLivro;
    }

    /**
     * @param tipoLivro the tipoLivro to set
     */
    public void setTipoLivro(String tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    /**
     * @return the tituloLivro
     */
    public String getTituloLivro() {
        return tituloLivro;
    }

    /**
     * @param tituloLivro the tituloLivro to set
     */
    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    /**
     * @return the idForn
     */
    public int getIdForn() {
        return idForn;
    }

    /**
     * @param idForn the idForn to set
     */
    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    /**
     * @return the nomeEditora
     */
    public String getNomeEditora() {
        return nomeEditora;
    }

    /**
     * @param nomeEditora the nomeEditora to set
     */
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return the prazoEmp
     */
    public int getPrazoEmp() {
        return prazoEmp;
    }

    /**
     * @param prazoEmp the prazoEmp to set
     */
    public void setPrazoEmp(int prazoEmp) {
        this.prazoEmp = prazoEmp;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the dataAquisicao
     */
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    /**
     * @param dataAquisicao the dataAquisicao to set
     */
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * @return the idCat
     */
    public int getIdCat() {
        return idCat;
    }

    /**
     * @param idCat the idCat to set
     */
    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    /**
     * @return the descricaoCategoria
     */
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    /**
     * @param descricaoCategoria the descricaoCategoria to set
     */
    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    /**
     * @return the iSBN
     */
    public String getiSBN() {
        return iSBN;
    }

    /**
     * @param iSBN the iSBN to set
     */
    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the paginas
     */
    public String getPaginas() {
        return paginas;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the descricaoLocal
     */
    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    /**
     * @param descricaoLocal the descricaoLocal to set
     */
    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
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
     * @return the foto1
     */
    public String getFoto1() {
        return foto1;
    }

    /**
     * @param foto1 the foto1 to set
     */
    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    /**
     * @return the foto2
     */
    public String getFoto2() {
        return foto2;
    }

    /**
     * @param foto2 the foto2 to set
     */
    public void setFoto2(String foto2) {
        this.foto2 = foto2;
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
