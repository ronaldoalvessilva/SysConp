/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaAcessos {

    private int idTela;
    private String nomeTela;
    private int idUsuario;
    private String nomeUsuario;
    private int idModulo;
    private String nomeModulo;
    private int abrir;
    private int incluir;
    private int alterar;
    private int excluir;
    private int gravar;
    private int consultar;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public TelaAcessos(int idTela, String nomeTela, int idUsuario, String nomeUsuario, int idModulo, String nomeModulo, int abrir, int incluir, int alterar, int excluir, int gravar, int consultar, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idTela = idTela;
        this.nomeTela = nomeTela;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.idModulo = idModulo;
        this.nomeModulo = nomeModulo;
        this.abrir = abrir;
        this.incluir = incluir;
        this.alterar = alterar;
        this.excluir = excluir;
        this.gravar = gravar;
        this.consultar = consultar;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TelaAcessos() {
    }

    /**
     * @return the idTela
     */
    public int getIdTela() {
        return idTela;
    }

    /**
     * @param idTela the idTela to set
     */
    public void setIdTela(int idTela) {
        this.idTela = idTela;
    }

    /**
     * @return the nomeTela
     */
    public String getNomeTela() {
        return nomeTela;
    }

    /**
     * @param nomeTela the nomeTela to set
     */
    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
     * @return the idModulo
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * @return the nomeModulo
     */
    public String getNomeModulo() {
        return nomeModulo;
    }

    /**
     * @param nomeModulo the nomeModulo to set
     */
    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    /**
     * @return the abrir
     */
    public int getAbrir() {
        return abrir;
    }

    /**
     * @param abrir the abrir to set
     */
    public void setAbrir(int abrir) {
        this.abrir = abrir;
    }

    /**
     * @return the incluir
     */
    public int getIncluir() {
        return incluir;
    }

    /**
     * @param incluir the incluir to set
     */
    public void setIncluir(int incluir) {
        this.incluir = incluir;
    }

    /**
     * @return the alterar
     */
    public int getAlterar() {
        return alterar;
    }

    /**
     * @param alterar the alterar to set
     */
    public void setAlterar(int alterar) {
        this.alterar = alterar;
    }

    /**
     * @return the excluir
     */
    public int getExcluir() {
        return excluir;
    }

    /**
     * @param excluir the excluir to set
     */
    public void setExcluir(int excluir) {
        this.excluir = excluir;
    }

    /**
     * @return the gravar
     */
    public int getGravar() {
        return gravar;
    }

    /**
     * @param gravar the gravar to set
     */
    public void setGravar(int gravar) {
        this.gravar = gravar;
    }

    /**
     * @return the consultar
     */
    public int getConsultar() {
        return consultar;
    }

    /**
     * @param consultar the consultar to set
     */
    public void setConsultar(int consultar) {
        this.consultar = consultar;
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
