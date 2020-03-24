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
public class HistoricoEducacionalLaboral {
    
    private int idHistoricoEdu;
    private int idHistoricoLab;
    private int idAtend;
    private int idItem;
    private int idATN;
    private int idHistoricoEduN;
    private int idItemICTHEN;
    private int idHistoricoLabPN;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String escreveProprioNome;
    private String sabeLerEscrever;
    private String nivelInstrucao;
    private String interesseEstudar;
    private int idCurso;
    private String cursoProfissionalizante;
    private String descricaoCurso;
    private int prioridadeCurso;
    private String temProfissao;
    private String qualProfissao;
    private int idProfissao;
    private String experienciaProfissional;
    private String qualExperienciaProfissional;
    private String desejaTrabalharUnid;
    private int tipoRemuneracao;
    private String interesseRemuneracao;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;             

    public HistoricoEducacionalLaboral() {
    }

    public HistoricoEducacionalLaboral(int idHistoricoEdu, int idHistoricoLab, int idAtend, int idItem, int idATN, int idHistoricoEduN, int idItemICTHEN, int idHistoricoLabPN, int idInternoCrc, String nomeInternoCrc, String escreveProprioNome, String sabeLerEscrever, String nivelInstrucao, String interesseEstudar, int idCurso, String cursoProfissionalizante, String descricaoCurso, int prioridadeCurso, String temProfissao, String qualProfissao, int idProfissao, String experienciaProfissional, String qualExperienciaProfissional, String desejaTrabalharUnid, int tipoRemuneracao, String interesseRemuneracao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idHistoricoEdu = idHistoricoEdu;
        this.idHistoricoLab = idHistoricoLab;
        this.idAtend = idAtend;
        this.idItem = idItem;
        this.idATN = idATN;
        this.idHistoricoEduN = idHistoricoEduN;
        this.idItemICTHEN = idItemICTHEN;
        this.idHistoricoLabPN = idHistoricoLabPN;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.escreveProprioNome = escreveProprioNome;
        this.sabeLerEscrever = sabeLerEscrever;
        this.nivelInstrucao = nivelInstrucao;
        this.interesseEstudar = interesseEstudar;
        this.idCurso = idCurso;
        this.cursoProfissionalizante = cursoProfissionalizante;
        this.descricaoCurso = descricaoCurso;
        this.prioridadeCurso = prioridadeCurso;
        this.temProfissao = temProfissao;
        this.qualProfissao = qualProfissao;
        this.idProfissao = idProfissao;
        this.experienciaProfissional = experienciaProfissional;
        this.qualExperienciaProfissional = qualExperienciaProfissional;
        this.desejaTrabalharUnid = desejaTrabalharUnid;
        this.tipoRemuneracao = tipoRemuneracao;
        this.interesseRemuneracao = interesseRemuneracao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idHistoricoEdu
     */
    public int getIdHistoricoEdu() {
        return idHistoricoEdu;
    }

    /**
     * @param idHistoricoEdu the idHistoricoEdu to set
     */
    public void setIdHistoricoEdu(int idHistoricoEdu) {
        this.idHistoricoEdu = idHistoricoEdu;
    }

    /**
     * @return the idHistoricoLab
     */
    public int getIdHistoricoLab() {
        return idHistoricoLab;
    }

    /**
     * @param idHistoricoLab the idHistoricoLab to set
     */
    public void setIdHistoricoLab(int idHistoricoLab) {
        this.idHistoricoLab = idHistoricoLab;
    }

    /**
     * @return the idAtend
     */
    public int getIdAtend() {
        return idAtend;
    }

    /**
     * @param idAtend the idAtend to set
     */
    public void setIdAtend(int idAtend) {
        this.idAtend = idAtend;
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
     * @return the idATN
     */
    public int getIdATN() {
        return idATN;
    }

    /**
     * @param idATN the idATN to set
     */
    public void setIdATN(int idATN) {
        this.idATN = idATN;
    }

    /**
     * @return the idHistoricoEduN
     */
    public int getIdHistoricoEduN() {
        return idHistoricoEduN;
    }

    /**
     * @param idHistoricoEduN the idHistoricoEduN to set
     */
    public void setIdHistoricoEduN(int idHistoricoEduN) {
        this.idHistoricoEduN = idHistoricoEduN;
    }

    /**
     * @return the idItemICTHEN
     */
    public int getIdItemICTHEN() {
        return idItemICTHEN;
    }

    /**
     * @param idItemICTHEN the idItemICTHEN to set
     */
    public void setIdItemICTHEN(int idItemICTHEN) {
        this.idItemICTHEN = idItemICTHEN;
    }

    /**
     * @return the idHistoricoLabPN
     */
    public int getIdHistoricoLabPN() {
        return idHistoricoLabPN;
    }

    /**
     * @param idHistoricoLabPN the idHistoricoLabPN to set
     */
    public void setIdHistoricoLabPN(int idHistoricoLabPN) {
        this.idHistoricoLabPN = idHistoricoLabPN;
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
     * @return the escreveProprioNome
     */
    public String getEscreveProprioNome() {
        return escreveProprioNome;
    }

    /**
     * @param escreveProprioNome the escreveProprioNome to set
     */
    public void setEscreveProprioNome(String escreveProprioNome) {
        this.escreveProprioNome = escreveProprioNome;
    }

    /**
     * @return the sabeLerEscrever
     */
    public String getSabeLerEscrever() {
        return sabeLerEscrever;
    }

    /**
     * @param sabeLerEscrever the sabeLerEscrever to set
     */
    public void setSabeLerEscrever(String sabeLerEscrever) {
        this.sabeLerEscrever = sabeLerEscrever;
    }

    /**
     * @return the nivelInstrucao
     */
    public String getNivelInstrucao() {
        return nivelInstrucao;
    }

    /**
     * @param nivelInstrucao the nivelInstrucao to set
     */
    public void setNivelInstrucao(String nivelInstrucao) {
        this.nivelInstrucao = nivelInstrucao;
    }

    /**
     * @return the interesseEstudar
     */
    public String getInteresseEstudar() {
        return interesseEstudar;
    }

    /**
     * @param interesseEstudar the interesseEstudar to set
     */
    public void setInteresseEstudar(String interesseEstudar) {
        this.interesseEstudar = interesseEstudar;
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
     * @return the cursoProfissionalizante
     */
    public String getCursoProfissionalizante() {
        return cursoProfissionalizante;
    }

    /**
     * @param cursoProfissionalizante the cursoProfissionalizante to set
     */
    public void setCursoProfissionalizante(String cursoProfissionalizante) {
        this.cursoProfissionalizante = cursoProfissionalizante;
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
     * @return the prioridadeCurso
     */
    public int getPrioridadeCurso() {
        return prioridadeCurso;
    }

    /**
     * @param prioridadeCurso the prioridadeCurso to set
     */
    public void setPrioridadeCurso(int prioridadeCurso) {
        this.prioridadeCurso = prioridadeCurso;
    }

    /**
     * @return the temProfissao
     */
    public String getTemProfissao() {
        return temProfissao;
    }

    /**
     * @param temProfissao the temProfissao to set
     */
    public void setTemProfissao(String temProfissao) {
        this.temProfissao = temProfissao;
    }

    /**
     * @return the qualProfissao
     */
    public String getQualProfissao() {
        return qualProfissao;
    }

    /**
     * @param qualProfissao the qualProfissao to set
     */
    public void setQualProfissao(String qualProfissao) {
        this.qualProfissao = qualProfissao;
    }

    /**
     * @return the idProfissao
     */
    public int getIdProfissao() {
        return idProfissao;
    }

    /**
     * @param idProfissao the idProfissao to set
     */
    public void setIdProfissao(int idProfissao) {
        this.idProfissao = idProfissao;
    }

    /**
     * @return the experienciaProfissional
     */
    public String getExperienciaProfissional() {
        return experienciaProfissional;
    }

    /**
     * @param experienciaProfissional the experienciaProfissional to set
     */
    public void setExperienciaProfissional(String experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    /**
     * @return the qualExperienciaProfissional
     */
    public String getQualExperienciaProfissional() {
        return qualExperienciaProfissional;
    }

    /**
     * @param qualExperienciaProfissional the qualExperienciaProfissional to set
     */
    public void setQualExperienciaProfissional(String qualExperienciaProfissional) {
        this.qualExperienciaProfissional = qualExperienciaProfissional;
    }

    /**
     * @return the desejaTrabalharUnid
     */
    public String getDesejaTrabalharUnid() {
        return desejaTrabalharUnid;
    }

    /**
     * @param desejaTrabalharUnid the desejaTrabalharUnid to set
     */
    public void setDesejaTrabalharUnid(String desejaTrabalharUnid) {
        this.desejaTrabalharUnid = desejaTrabalharUnid;
    }

    /**
     * @return the tipoRemuneracao
     */
    public int getTipoRemuneracao() {
        return tipoRemuneracao;
    }

    /**
     * @param tipoRemuneracao the tipoRemuneracao to set
     */
    public void setTipoRemuneracao(int tipoRemuneracao) {
        this.tipoRemuneracao = tipoRemuneracao;
    }

    /**
     * @return the interesseRemuneracao
     */
    public String getInteresseRemuneracao() {
        return interesseRemuneracao;
    }

    /**
     * @param interesseRemuneracao the interesseRemuneracao to set
     */
    public void setInteresseRemuneracao(String interesseRemuneracao) {
        this.interesseRemuneracao = interesseRemuneracao;
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
