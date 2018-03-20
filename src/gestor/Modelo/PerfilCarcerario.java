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
public class PerfilCarcerario {

    private int idPerfilCar;
    private int idPerfil;
    private int idInternoCrc;
    private String nomeInternoPerfil;
    private String residenciaFixa;
    private int filhosRecPaternidade;
    private int filhosMaior21;
    private String composicaoFamiliar;
    private String rG;
    private int filhosMenor21;
    private String cPF;
    private String familiaRecBeneGov;
    private String temVisita;
    private String escolaridade;
    private String frequentaEscolaUnid;
    private String fezENEN;
    private String atividadeLabor;
    private String carteiraAssinada;
    private String transtornoMental;
    private String usouDrogas;
    private String usaDrogas;
    private String diabetes;
    private String hipertensao;
    private String sifilis;
    private String tuberculose;
    private String hepatite;
    private String hIV;
    private String hanseniase;
    private String reu;
    private int artigo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String InteresseTrabalhar;
    private String AnemiaFalsiforme;   

    public PerfilCarcerario(int idPerfilCar, int idPerfil, int idInternoCrc, String nomeInternoPerfil, String residenciaFixa, int filhosRecPaternidade, int filhosMaior21, String composicaoFamiliar, String rG, int filhosMenor21, String cPF, String familiaRecBeneGov, String temVisita, String escolaridade, String frequentaEscolaUnid, String fezENEN, String atividadeLabor, String carteiraAssinada, String transtornoMental, String usouDrogas, String usaDrogas, String diabetes, String hipertensao, String sifilis, String tuberculose, String hepatite, String hIV, String hanseniase, String reu, int artigo, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String InteresseTrabalhar, String AnemiaFalsiforme) {
        this.idPerfilCar = idPerfilCar;
        this.idPerfil = idPerfil;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoPerfil = nomeInternoPerfil;
        this.residenciaFixa = residenciaFixa;
        this.filhosRecPaternidade = filhosRecPaternidade;
        this.filhosMaior21 = filhosMaior21;
        this.composicaoFamiliar = composicaoFamiliar;
        this.rG = rG;
        this.filhosMenor21 = filhosMenor21;
        this.cPF = cPF;
        this.familiaRecBeneGov = familiaRecBeneGov;
        this.temVisita = temVisita;
        this.escolaridade = escolaridade;
        this.frequentaEscolaUnid = frequentaEscolaUnid;
        this.fezENEN = fezENEN;
        this.atividadeLabor = atividadeLabor;
        this.carteiraAssinada = carteiraAssinada;
        this.transtornoMental = transtornoMental;
        this.usouDrogas = usouDrogas;
        this.usaDrogas = usaDrogas;
        this.diabetes = diabetes;
        this.hipertensao = hipertensao;
        this.sifilis = sifilis;
        this.tuberculose = tuberculose;
        this.hepatite = hepatite;
        this.hIV = hIV;
        this.hanseniase = hanseniase;
        this.reu = reu;
        this.artigo = artigo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.InteresseTrabalhar = InteresseTrabalhar;
        this.AnemiaFalsiforme = AnemiaFalsiforme;
    }

    public PerfilCarcerario() {
    }

    /**
     * @return the idPerfilCar
     */
    public int getIdPerfilCar() {
        return idPerfilCar;
    }

    /**
     * @param idPerfilCar the idPerfilCar to set
     */
    public void setIdPerfilCar(int idPerfilCar) {
        this.idPerfilCar = idPerfilCar;
    }

    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
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
     * @return the nomeInternoPerfil
     */
    public String getNomeInternoPerfil() {
        return nomeInternoPerfil;
    }

    /**
     * @param nomeInternoPerfil the nomeInternoPerfil to set
     */
    public void setNomeInternoPerfil(String nomeInternoPerfil) {
        this.nomeInternoPerfil = nomeInternoPerfil;
    }

    /**
     * @return the residenciaFixa
     */
    public String getResidenciaFixa() {
        return residenciaFixa;
    }

    /**
     * @param residenciaFixa the residenciaFixa to set
     */
    public void setResidenciaFixa(String residenciaFixa) {
        this.residenciaFixa = residenciaFixa;
    }

    /**
     * @return the filhosRecPaternidade
     */
    public int getFilhosRecPaternidade() {
        return filhosRecPaternidade;
    }

    /**
     * @param filhosRecPaternidade the filhosRecPaternidade to set
     */
    public void setFilhosRecPaternidade(int filhosRecPaternidade) {
        this.filhosRecPaternidade = filhosRecPaternidade;
    }

    /**
     * @return the filhosMaior21
     */
    public int getFilhosMaior21() {
        return filhosMaior21;
    }

    /**
     * @param filhosMaior21 the filhosMaior21 to set
     */
    public void setFilhosMaior21(int filhosMaior21) {
        this.filhosMaior21 = filhosMaior21;
    }

    /**
     * @return the composicaoFamiliar
     */
    public String getComposicaoFamiliar() {
        return composicaoFamiliar;
    }

    /**
     * @param composicaoFamiliar the composicaoFamiliar to set
     */
    public void setComposicaoFamiliar(String composicaoFamiliar) {
        this.composicaoFamiliar = composicaoFamiliar;
    }

    /**
     * @return the rG
     */
    public String getrG() {
        return rG;
    }

    /**
     * @param rG the rG to set
     */
    public void setrG(String rG) {
        this.rG = rG;
    }

    /**
     * @return the filhosMenor21
     */
    public int getFilhosMenor21() {
        return filhosMenor21;
    }

    /**
     * @param filhosMenor21 the filhosMenor21 to set
     */
    public void setFilhosMenor21(int filhosMenor21) {
        this.filhosMenor21 = filhosMenor21;
    }

    /**
     * @return the cPF
     */
    public String getcPF() {
        return cPF;
    }

    /**
     * @param cPF the cPF to set
     */
    public void setcPF(String cPF) {
        this.cPF = cPF;
    }

    /**
     * @return the familiaRecBeneGov
     */
    public String getFamiliaRecBeneGov() {
        return familiaRecBeneGov;
    }

    /**
     * @param familiaRecBeneGov the familiaRecBeneGov to set
     */
    public void setFamiliaRecBeneGov(String familiaRecBeneGov) {
        this.familiaRecBeneGov = familiaRecBeneGov;
    }

    /**
     * @return the temVisita
     */
    public String getTemVisita() {
        return temVisita;
    }

    /**
     * @param temVisita the temVisita to set
     */
    public void setTemVisita(String temVisita) {
        this.temVisita = temVisita;
    }

    /**
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the frequentaEscolaUnid
     */
    public String getFrequentaEscolaUnid() {
        return frequentaEscolaUnid;
    }

    /**
     * @param frequentaEscolaUnid the frequentaEscolaUnid to set
     */
    public void setFrequentaEscolaUnid(String frequentaEscolaUnid) {
        this.frequentaEscolaUnid = frequentaEscolaUnid;
    }

    /**
     * @return the fezENEN
     */
    public String getFezENEN() {
        return fezENEN;
    }

    /**
     * @param fezENEN the fezENEN to set
     */
    public void setFezENEN(String fezENEN) {
        this.fezENEN = fezENEN;
    }

    /**
     * @return the atividadeLabor
     */
    public String getAtividadeLabor() {
        return atividadeLabor;
    }

    /**
     * @param atividadeLabor the atividadeLabor to set
     */
    public void setAtividadeLabor(String atividadeLabor) {
        this.atividadeLabor = atividadeLabor;
    }

    /**
     * @return the carteiraAssinada
     */
    public String getCarteiraAssinada() {
        return carteiraAssinada;
    }

    /**
     * @param carteiraAssinada the carteiraAssinada to set
     */
    public void setCarteiraAssinada(String carteiraAssinada) {
        this.carteiraAssinada = carteiraAssinada;
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
     * @return the usouDrogas
     */
    public String getUsouDrogas() {
        return usouDrogas;
    }

    /**
     * @param usouDrogas the usouDrogas to set
     */
    public void setUsouDrogas(String usouDrogas) {
        this.usouDrogas = usouDrogas;
    }

    /**
     * @return the usaDrogas
     */
    public String getUsaDrogas() {
        return usaDrogas;
    }

    /**
     * @param usaDrogas the usaDrogas to set
     */
    public void setUsaDrogas(String usaDrogas) {
        this.usaDrogas = usaDrogas;
    }

    /**
     * @return the diabetes
     */
    public String getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the hipertensao
     */
    public String getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the sifilis
     */
    public String getSifilis() {
        return sifilis;
    }

    /**
     * @param sifilis the sifilis to set
     */
    public void setSifilis(String sifilis) {
        this.sifilis = sifilis;
    }

    /**
     * @return the tuberculose
     */
    public String getTuberculose() {
        return tuberculose;
    }

    /**
     * @param tuberculose the tuberculose to set
     */
    public void setTuberculose(String tuberculose) {
        this.tuberculose = tuberculose;
    }

    /**
     * @return the hepatite
     */
    public String getHepatite() {
        return hepatite;
    }

    /**
     * @param hepatite the hepatite to set
     */
    public void setHepatite(String hepatite) {
        this.hepatite = hepatite;
    }

    /**
     * @return the hIV
     */
    public String gethIV() {
        return hIV;
    }

    /**
     * @param hIV the hIV to set
     */
    public void sethIV(String hIV) {
        this.hIV = hIV;
    }

    /**
     * @return the hanseniase
     */
    public String getHanseniase() {
        return hanseniase;
    }

    /**
     * @param hanseniase the hanseniase to set
     */
    public void setHanseniase(String hanseniase) {
        this.hanseniase = hanseniase;
    }

    /**
     * @return the reu
     */
    public String getReu() {
        return reu;
    }

    /**
     * @param reu the reu to set
     */
    public void setReu(String reu) {
        this.reu = reu;
    }

    /**
     * @return the artigo
     */
    public int getArtigo() {
        return artigo;
    }

    /**
     * @param artigo the artigo to set
     */
    public void setArtigo(int artigo) {
        this.artigo = artigo;
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

    /**
     * @return the InteresseTrabalhar
     */
    public String getInteresseTrabalhar() {
        return InteresseTrabalhar;
    }

    /**
     * @param InteresseTrabalhar the InteresseTrabalhar to set
     */
    public void setInteresseTrabalhar(String InteresseTrabalhar) {
        this.InteresseTrabalhar = InteresseTrabalhar;
    }

    /**
     * @return the AnemiaFalsiforme
     */
    public String getAnemiaFalsiforme() {
        return AnemiaFalsiforme;
    }

    /**
     * @param AnemiaFalsiforme the AnemiaFalsiforme to set
     */
    public void setAnemiaFalsiforme(String AnemiaFalsiforme) {
        this.AnemiaFalsiforme = AnemiaFalsiforme;
    }
}
