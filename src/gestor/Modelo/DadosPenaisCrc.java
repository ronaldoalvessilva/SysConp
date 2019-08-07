/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class DadosPenaisCrc {

    private int IdPenais;
    private int IdInternoCrc;
    private String nomeInternoCrc;
    private String nomeUnidade;
    private Date DataEntrada;
    private Date DataCrime;
    private Date DataPrisao;
    private Date DataCondenacao;
    private String Participacao;
    private String Regime;
    private String Pena;
    private String Artigo1;
    private String Artigo2;
    private String Artigo3;
    private String Paragrafo1;
    private String Paragrafo2;
    private String Paragrafo3;
    private String crimeEdiondo;
    private Date terminoPena;
    private String FotoPerfil;
    private String FotoCorpo;
    private String FotoCorpo1;
    private String FotoCorpo2;
    private String FotoPolegarDireito;
    private String FotoPolegarEsquerdo;
    private String FotoIndicadorDireito;
    private String FotoIndicadorEsquerdo;
    private String FotoMedioDireito;
    private String FotoMedioEsquerto;
    private String FotoAnluarDireito;
    private String FotoAnluaresquerdo;
    private String FotoMeditoDireito;
    private String FotoMeditoEsquerdo;
    private String Identificador;
    private String Identificador1;
    private String Identificador2;
    private String Identificador3;
    private String Perfil;
    private String RegiaoCorpo;
    private String RegiaoCorpo1;
    private String RegiaoCorpo2;
    private String RegiaoCorpo3;
    private String varaCondenatoria;
    private Date dataNovaEntrada;
    private byte[] imagemPerfil;
    private byte[] imagemCorpo;
    private byte[] imagemCorpo1;
    private byte[] imagemCorpo2;
    private int idEntrada;
    private int idItem;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public DadosPenaisCrc() {
    }

    public DadosPenaisCrc(int IdPenais, int IdInternoCrc, String nomeInternoCrc, String nomeUnidade, Date DataEntrada, Date DataCrime, Date DataPrisao, Date DataCondenacao, String Participacao, String Regime, String Pena, String Artigo1, String Artigo2, String Artigo3, String Paragrafo1, String Paragrafo2, String Paragrafo3, String crimeEdiondo, Date terminoPena, String FotoPerfil, String FotoCorpo, String FotoCorpo1, String FotoCorpo2, String FotoPolegarDireito, String FotoPolegarEsquerdo, String FotoIndicadorDireito, String FotoIndicadorEsquerdo, String FotoMedioDireito, String FotoMedioEsquerto, String FotoAnluarDireito, String FotoAnluaresquerdo, String FotoMeditoDireito, String FotoMeditoEsquerdo, String Identificador, String Identificador1, String Identificador2, String Identificador3, String Perfil, String RegiaoCorpo, String RegiaoCorpo1, String RegiaoCorpo2, String RegiaoCorpo3, String varaCondenatoria, Date dataNovaEntrada, byte[] imagemPerfil, byte[] imagemCorpo, byte[] imagemCorpo1, byte[] imagemCorpo2, int idEntrada, int idItem, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.IdPenais = IdPenais;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.nomeUnidade = nomeUnidade;
        this.DataEntrada = DataEntrada;
        this.DataCrime = DataCrime;
        this.DataPrisao = DataPrisao;
        this.DataCondenacao = DataCondenacao;
        this.Participacao = Participacao;
        this.Regime = Regime;
        this.Pena = Pena;
        this.Artigo1 = Artigo1;
        this.Artigo2 = Artigo2;
        this.Artigo3 = Artigo3;
        this.Paragrafo1 = Paragrafo1;
        this.Paragrafo2 = Paragrafo2;
        this.Paragrafo3 = Paragrafo3;
        this.crimeEdiondo = crimeEdiondo;
        this.terminoPena = terminoPena;
        this.FotoPerfil = FotoPerfil;
        this.FotoCorpo = FotoCorpo;
        this.FotoCorpo1 = FotoCorpo1;
        this.FotoCorpo2 = FotoCorpo2;
        this.FotoPolegarDireito = FotoPolegarDireito;
        this.FotoPolegarEsquerdo = FotoPolegarEsquerdo;
        this.FotoIndicadorDireito = FotoIndicadorDireito;
        this.FotoIndicadorEsquerdo = FotoIndicadorEsquerdo;
        this.FotoMedioDireito = FotoMedioDireito;
        this.FotoMedioEsquerto = FotoMedioEsquerto;
        this.FotoAnluarDireito = FotoAnluarDireito;
        this.FotoAnluaresquerdo = FotoAnluaresquerdo;
        this.FotoMeditoDireito = FotoMeditoDireito;
        this.FotoMeditoEsquerdo = FotoMeditoEsquerdo;
        this.Identificador = Identificador;
        this.Identificador1 = Identificador1;
        this.Identificador2 = Identificador2;
        this.Identificador3 = Identificador3;
        this.Perfil = Perfil;
        this.RegiaoCorpo = RegiaoCorpo;
        this.RegiaoCorpo1 = RegiaoCorpo1;
        this.RegiaoCorpo2 = RegiaoCorpo2;
        this.RegiaoCorpo3 = RegiaoCorpo3;
        this.varaCondenatoria = varaCondenatoria;
        this.dataNovaEntrada = dataNovaEntrada;
        this.imagemPerfil = imagemPerfil;
        this.imagemCorpo = imagemCorpo;
        this.imagemCorpo1 = imagemCorpo1;
        this.imagemCorpo2 = imagemCorpo2;
        this.idEntrada = idEntrada;
        this.idItem = idItem;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the IdPenais
     */
    public int getIdPenais() {
        return IdPenais;
    }

    /**
     * @param IdPenais the IdPenais to set
     */
    public void setIdPenais(int IdPenais) {
        this.IdPenais = IdPenais;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
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
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    /**
     * @return the DataEntrada
     */
    public Date getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the DataCrime
     */
    public Date getDataCrime() {
        return DataCrime;
    }

    /**
     * @param DataCrime the DataCrime to set
     */
    public void setDataCrime(Date DataCrime) {
        this.DataCrime = DataCrime;
    }

    /**
     * @return the DataPrisao
     */
    public Date getDataPrisao() {
        return DataPrisao;
    }

    /**
     * @param DataPrisao the DataPrisao to set
     */
    public void setDataPrisao(Date DataPrisao) {
        this.DataPrisao = DataPrisao;
    }

    /**
     * @return the DataCondenacao
     */
    public Date getDataCondenacao() {
        return DataCondenacao;
    }

    /**
     * @param DataCondenacao the DataCondenacao to set
     */
    public void setDataCondenacao(Date DataCondenacao) {
        this.DataCondenacao = DataCondenacao;
    }

    /**
     * @return the Participacao
     */
    public String getParticipacao() {
        return Participacao;
    }

    /**
     * @param Participacao the Participacao to set
     */
    public void setParticipacao(String Participacao) {
        this.Participacao = Participacao;
    }

    /**
     * @return the Regime
     */
    public String getRegime() {
        return Regime;
    }

    /**
     * @param Regime the Regime to set
     */
    public void setRegime(String Regime) {
        this.Regime = Regime;
    }

    /**
     * @return the Pena
     */
    public String getPena() {
        return Pena;
    }

    /**
     * @param Pena the Pena to set
     */
    public void setPena(String Pena) {
        this.Pena = Pena;
    }

    /**
     * @return the Artigo1
     */
    public String getArtigo1() {
        return Artigo1;
    }

    /**
     * @param Artigo1 the Artigo1 to set
     */
    public void setArtigo1(String Artigo1) {
        this.Artigo1 = Artigo1;
    }

    /**
     * @return the Artigo2
     */
    public String getArtigo2() {
        return Artigo2;
    }

    /**
     * @param Artigo2 the Artigo2 to set
     */
    public void setArtigo2(String Artigo2) {
        this.Artigo2 = Artigo2;
    }

    /**
     * @return the Artigo3
     */
    public String getArtigo3() {
        return Artigo3;
    }

    /**
     * @param Artigo3 the Artigo3 to set
     */
    public void setArtigo3(String Artigo3) {
        this.Artigo3 = Artigo3;
    }

    /**
     * @return the Paragrafo1
     */
    public String getParagrafo1() {
        return Paragrafo1;
    }

    /**
     * @param Paragrafo1 the Paragrafo1 to set
     */
    public void setParagrafo1(String Paragrafo1) {
        this.Paragrafo1 = Paragrafo1;
    }

    /**
     * @return the Paragrafo2
     */
    public String getParagrafo2() {
        return Paragrafo2;
    }

    /**
     * @param Paragrafo2 the Paragrafo2 to set
     */
    public void setParagrafo2(String Paragrafo2) {
        this.Paragrafo2 = Paragrafo2;
    }

    /**
     * @return the Paragrafo3
     */
    public String getParagrafo3() {
        return Paragrafo3;
    }

    /**
     * @param Paragrafo3 the Paragrafo3 to set
     */
    public void setParagrafo3(String Paragrafo3) {
        this.Paragrafo3 = Paragrafo3;
    }

    /**
     * @return the crimeEdiondo
     */
    public String getCrimeEdiondo() {
        return crimeEdiondo;
    }

    /**
     * @param crimeEdiondo the crimeEdiondo to set
     */
    public void setCrimeEdiondo(String crimeEdiondo) {
        this.crimeEdiondo = crimeEdiondo;
    }

    /**
     * @return the terminoPena
     */
    public Date getTerminoPena() {
        return terminoPena;
    }

    /**
     * @param terminoPena the terminoPena to set
     */
    public void setTerminoPena(Date terminoPena) {
        this.terminoPena = terminoPena;
    }

    /**
     * @return the FotoPerfil
     */
    public String getFotoPerfil() {
        return FotoPerfil;
    }

    /**
     * @param FotoPerfil the FotoPerfil to set
     */
    public void setFotoPerfil(String FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    /**
     * @return the FotoCorpo
     */
    public String getFotoCorpo() {
        return FotoCorpo;
    }

    /**
     * @param FotoCorpo the FotoCorpo to set
     */
    public void setFotoCorpo(String FotoCorpo) {
        this.FotoCorpo = FotoCorpo;
    }

    /**
     * @return the FotoCorpo1
     */
    public String getFotoCorpo1() {
        return FotoCorpo1;
    }

    /**
     * @param FotoCorpo1 the FotoCorpo1 to set
     */
    public void setFotoCorpo1(String FotoCorpo1) {
        this.FotoCorpo1 = FotoCorpo1;
    }

    /**
     * @return the FotoCorpo2
     */
    public String getFotoCorpo2() {
        return FotoCorpo2;
    }

    /**
     * @param FotoCorpo2 the FotoCorpo2 to set
     */
    public void setFotoCorpo2(String FotoCorpo2) {
        this.FotoCorpo2 = FotoCorpo2;
    }

    /**
     * @return the FotoPolegarDireito
     */
    public String getFotoPolegarDireito() {
        return FotoPolegarDireito;
    }

    /**
     * @param FotoPolegarDireito the FotoPolegarDireito to set
     */
    public void setFotoPolegarDireito(String FotoPolegarDireito) {
        this.FotoPolegarDireito = FotoPolegarDireito;
    }

    /**
     * @return the FotoPolegarEsquerdo
     */
    public String getFotoPolegarEsquerdo() {
        return FotoPolegarEsquerdo;
    }

    /**
     * @param FotoPolegarEsquerdo the FotoPolegarEsquerdo to set
     */
    public void setFotoPolegarEsquerdo(String FotoPolegarEsquerdo) {
        this.FotoPolegarEsquerdo = FotoPolegarEsquerdo;
    }

    /**
     * @return the FotoIndicadorDireito
     */
    public String getFotoIndicadorDireito() {
        return FotoIndicadorDireito;
    }

    /**
     * @param FotoIndicadorDireito the FotoIndicadorDireito to set
     */
    public void setFotoIndicadorDireito(String FotoIndicadorDireito) {
        this.FotoIndicadorDireito = FotoIndicadorDireito;
    }

    /**
     * @return the FotoIndicadorEsquerdo
     */
    public String getFotoIndicadorEsquerdo() {
        return FotoIndicadorEsquerdo;
    }

    /**
     * @param FotoIndicadorEsquerdo the FotoIndicadorEsquerdo to set
     */
    public void setFotoIndicadorEsquerdo(String FotoIndicadorEsquerdo) {
        this.FotoIndicadorEsquerdo = FotoIndicadorEsquerdo;
    }

    /**
     * @return the FotoMedioDireito
     */
    public String getFotoMedioDireito() {
        return FotoMedioDireito;
    }

    /**
     * @param FotoMedioDireito the FotoMedioDireito to set
     */
    public void setFotoMedioDireito(String FotoMedioDireito) {
        this.FotoMedioDireito = FotoMedioDireito;
    }

    /**
     * @return the FotoMedioEsquerto
     */
    public String getFotoMedioEsquerto() {
        return FotoMedioEsquerto;
    }

    /**
     * @param FotoMedioEsquerto the FotoMedioEsquerto to set
     */
    public void setFotoMedioEsquerto(String FotoMedioEsquerto) {
        this.FotoMedioEsquerto = FotoMedioEsquerto;
    }

    /**
     * @return the FotoAnluarDireito
     */
    public String getFotoAnluarDireito() {
        return FotoAnluarDireito;
    }

    /**
     * @param FotoAnluarDireito the FotoAnluarDireito to set
     */
    public void setFotoAnluarDireito(String FotoAnluarDireito) {
        this.FotoAnluarDireito = FotoAnluarDireito;
    }

    /**
     * @return the FotoAnluaresquerdo
     */
    public String getFotoAnluaresquerdo() {
        return FotoAnluaresquerdo;
    }

    /**
     * @param FotoAnluaresquerdo the FotoAnluaresquerdo to set
     */
    public void setFotoAnluaresquerdo(String FotoAnluaresquerdo) {
        this.FotoAnluaresquerdo = FotoAnluaresquerdo;
    }

    /**
     * @return the FotoMeditoDireito
     */
    public String getFotoMeditoDireito() {
        return FotoMeditoDireito;
    }

    /**
     * @param FotoMeditoDireito the FotoMeditoDireito to set
     */
    public void setFotoMeditoDireito(String FotoMeditoDireito) {
        this.FotoMeditoDireito = FotoMeditoDireito;
    }

    /**
     * @return the FotoMeditoEsquerdo
     */
    public String getFotoMeditoEsquerdo() {
        return FotoMeditoEsquerdo;
    }

    /**
     * @param FotoMeditoEsquerdo the FotoMeditoEsquerdo to set
     */
    public void setFotoMeditoEsquerdo(String FotoMeditoEsquerdo) {
        this.FotoMeditoEsquerdo = FotoMeditoEsquerdo;
    }

    /**
     * @return the Identificador
     */
    public String getIdentificador() {
        return Identificador;
    }

    /**
     * @param Identificador the Identificador to set
     */
    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    /**
     * @return the Identificador1
     */
    public String getIdentificador1() {
        return Identificador1;
    }

    /**
     * @param Identificador1 the Identificador1 to set
     */
    public void setIdentificador1(String Identificador1) {
        this.Identificador1 = Identificador1;
    }

    /**
     * @return the Identificador2
     */
    public String getIdentificador2() {
        return Identificador2;
    }

    /**
     * @param Identificador2 the Identificador2 to set
     */
    public void setIdentificador2(String Identificador2) {
        this.Identificador2 = Identificador2;
    }

    /**
     * @return the Identificador3
     */
    public String getIdentificador3() {
        return Identificador3;
    }

    /**
     * @param Identificador3 the Identificador3 to set
     */
    public void setIdentificador3(String Identificador3) {
        this.Identificador3 = Identificador3;
    }

    /**
     * @return the Perfil
     */
    public String getPerfil() {
        return Perfil;
    }

    /**
     * @param Perfil the Perfil to set
     */
    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    /**
     * @return the RegiaoCorpo
     */
    public String getRegiaoCorpo() {
        return RegiaoCorpo;
    }

    /**
     * @param RegiaoCorpo the RegiaoCorpo to set
     */
    public void setRegiaoCorpo(String RegiaoCorpo) {
        this.RegiaoCorpo = RegiaoCorpo;
    }

    /**
     * @return the RegiaoCorpo1
     */
    public String getRegiaoCorpo1() {
        return RegiaoCorpo1;
    }

    /**
     * @param RegiaoCorpo1 the RegiaoCorpo1 to set
     */
    public void setRegiaoCorpo1(String RegiaoCorpo1) {
        this.RegiaoCorpo1 = RegiaoCorpo1;
    }

    /**
     * @return the RegiaoCorpo2
     */
    public String getRegiaoCorpo2() {
        return RegiaoCorpo2;
    }

    /**
     * @param RegiaoCorpo2 the RegiaoCorpo2 to set
     */
    public void setRegiaoCorpo2(String RegiaoCorpo2) {
        this.RegiaoCorpo2 = RegiaoCorpo2;
    }

    /**
     * @return the RegiaoCorpo3
     */
    public String getRegiaoCorpo3() {
        return RegiaoCorpo3;
    }

    /**
     * @param RegiaoCorpo3 the RegiaoCorpo3 to set
     */
    public void setRegiaoCorpo3(String RegiaoCorpo3) {
        this.RegiaoCorpo3 = RegiaoCorpo3;
    }

    /**
     * @return the varaCondenatoria
     */
    public String getVaraCondenatoria() {
        return varaCondenatoria;
    }

    /**
     * @param varaCondenatoria the varaCondenatoria to set
     */
    public void setVaraCondenatoria(String varaCondenatoria) {
        this.varaCondenatoria = varaCondenatoria;
    }

    /**
     * @return the dataNovaEntrada
     */
    public Date getDataNovaEntrada() {
        return dataNovaEntrada;
    }

    /**
     * @param dataNovaEntrada the dataNovaEntrada to set
     */
    public void setDataNovaEntrada(Date dataNovaEntrada) {
        this.dataNovaEntrada = dataNovaEntrada;
    }

    /**
     * @return the imagemPerfil
     */
    public byte[] getImagemPerfil() {
        return imagemPerfil;
    }

    /**
     * @param imagemPerfil the imagemPerfil to set
     */
    public void setImagemPerfil(byte[] imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    /**
     * @return the imagemCorpo
     */
    public byte[] getImagemCorpo() {
        return imagemCorpo;
    }

    /**
     * @param imagemCorpo the imagemCorpo to set
     */
    public void setImagemCorpo(byte[] imagemCorpo) {
        this.imagemCorpo = imagemCorpo;
    }

    /**
     * @return the imagemCorpo1
     */
    public byte[] getImagemCorpo1() {
        return imagemCorpo1;
    }

    /**
     * @param imagemCorpo1 the imagemCorpo1 to set
     */
    public void setImagemCorpo1(byte[] imagemCorpo1) {
        this.imagemCorpo1 = imagemCorpo1;
    }

    /**
     * @return the imagemCorpo2
     */
    public byte[] getImagemCorpo2() {
        return imagemCorpo2;
    }

    /**
     * @param imagemCorpo2 the imagemCorpo2 to set
     */
    public void setImagemCorpo2(byte[] imagemCorpo2) {
        this.imagemCorpo2 = imagemCorpo2;
    }

    /**
     * @return the idEntrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * @param idEntrada the idEntrada to set
     */
    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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
