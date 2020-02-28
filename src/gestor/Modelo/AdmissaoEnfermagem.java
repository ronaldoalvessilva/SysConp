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
public class AdmissaoEnfermagem {

    private int idLanc;
    private int idADME;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private int estadoEmocional;
    private int sonoRepouso;
    private int nivelConciencia;
    private String pressaoArterial;
    private String hemograma;
    private String temperatura;
    private String frequenciaRespitatoria;
    private String peso;
    private String frequenciaCardiaca;
    private String usaMedicamentos;
    private String qualMedicacao;
    private int locomocao;
    private int acuidadeVisual;
    private int acuidadeAuditiva;
    private int funcaoMotora;
    private String qualFuncaoMotora;
    private int falaLinguagem;
    private String qualFala;
    private int pele;
    private int mucosa;
    private String tipoPele;
    private String localizacao;
    private int cabelos;
    private int boca;
    private int funcaoRespiratoria;
    private int torax;
    private int funcaoIntestinal;
    private String diasConstipado;
    private int abdome;
    private int funcaoVesical;
    private int genitalia;
    private String qualGenitalia;
    private String vacinado;
    private String quaisVacinas;
    private String vdrl;
    private String hepatiteC;
    private String hepatiteB;
    private String hiv;
    private String cirurgias;
    private String quaisCirurgias;
    private String usuarioDrogas;
    private String quaisDrogas;
    private String portadorDoenca;
    private String quaisDoencas;
    private String Alergias;
    private String quaisAlergias;
    private String observacao;
    private String deptoMedico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private String sifilis;
    private String diabetes;
    private String hipertensao;
    private String tuberculose;
    private String escabiose;
    private String hanseniase;
    private String vacina;
    private String dst;
    private String hpv;

    public AdmissaoEnfermagem() {
    }

    public AdmissaoEnfermagem(int idLanc, int idADME, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, int estadoEmocional, int sonoRepouso, int nivelConciencia, String pressaoArterial, String hemograma, String temperatura, String frequenciaRespitatoria, String peso, String frequenciaCardiaca, String usaMedicamentos, String qualMedicacao, int locomocao, int acuidadeVisual, int acuidadeAuditiva, int funcaoMotora, String qualFuncaoMotora, int falaLinguagem, String qualFala, int pele, int mucosa, String tipoPele, String localizacao, int cabelos, int boca, int funcaoRespiratoria, int torax, int funcaoIntestinal, String diasConstipado, int abdome, int funcaoVesical, int genitalia, String qualGenitalia, String vacinado, String quaisVacinas, String vdrl, String hepatiteC, String hepatiteB, String hiv, String cirurgias, String quaisCirurgias, String usuarioDrogas, String quaisDrogas, String portadorDoenca, String quaisDoencas, String Alergias, String quaisAlergias, String observacao, String deptoMedico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String sifilis, String diabetes, String hipertensao, String tuberculose, String escabiose, String hanseniase, String vacina, String dst, String hpv) {
        this.idLanc = idLanc;
        this.idADME = idADME;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.estadoEmocional = estadoEmocional;
        this.sonoRepouso = sonoRepouso;
        this.nivelConciencia = nivelConciencia;
        this.pressaoArterial = pressaoArterial;
        this.hemograma = hemograma;
        this.temperatura = temperatura;
        this.frequenciaRespitatoria = frequenciaRespitatoria;
        this.peso = peso;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.usaMedicamentos = usaMedicamentos;
        this.qualMedicacao = qualMedicacao;
        this.locomocao = locomocao;
        this.acuidadeVisual = acuidadeVisual;
        this.acuidadeAuditiva = acuidadeAuditiva;
        this.funcaoMotora = funcaoMotora;
        this.qualFuncaoMotora = qualFuncaoMotora;
        this.falaLinguagem = falaLinguagem;
        this.qualFala = qualFala;
        this.pele = pele;
        this.mucosa = mucosa;
        this.tipoPele = tipoPele;
        this.localizacao = localizacao;
        this.cabelos = cabelos;
        this.boca = boca;
        this.funcaoRespiratoria = funcaoRespiratoria;
        this.torax = torax;
        this.funcaoIntestinal = funcaoIntestinal;
        this.diasConstipado = diasConstipado;
        this.abdome = abdome;
        this.funcaoVesical = funcaoVesical;
        this.genitalia = genitalia;
        this.qualGenitalia = qualGenitalia;
        this.vacinado = vacinado;
        this.quaisVacinas = quaisVacinas;
        this.vdrl = vdrl;
        this.hepatiteC = hepatiteC;
        this.hepatiteB = hepatiteB;
        this.hiv = hiv;
        this.cirurgias = cirurgias;
        this.quaisCirurgias = quaisCirurgias;
        this.usuarioDrogas = usuarioDrogas;
        this.quaisDrogas = quaisDrogas;
        this.portadorDoenca = portadorDoenca;
        this.quaisDoencas = quaisDoencas;
        this.Alergias = Alergias;
        this.quaisAlergias = quaisAlergias;
        this.observacao = observacao;
        this.deptoMedico = deptoMedico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.sifilis = sifilis;
        this.diabetes = diabetes;
        this.hipertensao = hipertensao;
        this.tuberculose = tuberculose;
        this.escabiose = escabiose;
        this.hanseniase = hanseniase;
        this.vacina = vacina;
        this.dst = dst;
        this.hpv = hpv;
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
     * @return the idADME
     */
    public int getIdADME() {
        return idADME;
    }

    /**
     * @param idADME the idADME to set
     */
    public void setIdADME(int idADME) {
        this.idADME = idADME;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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
     * @return the estadoEmocional
     */
    public int getEstadoEmocional() {
        return estadoEmocional;
    }

    /**
     * @param estadoEmocional the estadoEmocional to set
     */
    public void setEstadoEmocional(int estadoEmocional) {
        this.estadoEmocional = estadoEmocional;
    }

    /**
     * @return the sonoRepouso
     */
    public int getSonoRepouso() {
        return sonoRepouso;
    }

    /**
     * @param sonoRepouso the sonoRepouso to set
     */
    public void setSonoRepouso(int sonoRepouso) {
        this.sonoRepouso = sonoRepouso;
    }

    /**
     * @return the nivelConciencia
     */
    public int getNivelConciencia() {
        return nivelConciencia;
    }

    /**
     * @param nivelConciencia the nivelConciencia to set
     */
    public void setNivelConciencia(int nivelConciencia) {
        this.nivelConciencia = nivelConciencia;
    }

    /**
     * @return the pressaoArterial
     */
    public String getPressaoArterial() {
        return pressaoArterial;
    }

    /**
     * @param pressaoArterial the pressaoArterial to set
     */
    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    /**
     * @return the hemograma
     */
    public String getHemograma() {
        return hemograma;
    }

    /**
     * @param hemograma the hemograma to set
     */
    public void setHemograma(String hemograma) {
        this.hemograma = hemograma;
    }

    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the frequenciaRespitatoria
     */
    public String getFrequenciaRespitatoria() {
        return frequenciaRespitatoria;
    }

    /**
     * @param frequenciaRespitatoria the frequenciaRespitatoria to set
     */
    public void setFrequenciaRespitatoria(String frequenciaRespitatoria) {
        this.frequenciaRespitatoria = frequenciaRespitatoria;
    }

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * @return the frequenciaCardiaca
     */
    public String getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    /**
     * @param frequenciaCardiaca the frequenciaCardiaca to set
     */
    public void setFrequenciaCardiaca(String frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    /**
     * @return the usaMedicamentos
     */
    public String getUsaMedicamentos() {
        return usaMedicamentos;
    }

    /**
     * @param usaMedicamentos the usaMedicamentos to set
     */
    public void setUsaMedicamentos(String usaMedicamentos) {
        this.usaMedicamentos = usaMedicamentos;
    }

    /**
     * @return the qualMedicacao
     */
    public String getQualMedicacao() {
        return qualMedicacao;
    }

    /**
     * @param qualMedicacao the qualMedicacao to set
     */
    public void setQualMedicacao(String qualMedicacao) {
        this.qualMedicacao = qualMedicacao;
    }

    /**
     * @return the locomocao
     */
    public int getLocomocao() {
        return locomocao;
    }

    /**
     * @param locomocao the locomocao to set
     */
    public void setLocomocao(int locomocao) {
        this.locomocao = locomocao;
    }

    /**
     * @return the acuidadeVisual
     */
    public int getAcuidadeVisual() {
        return acuidadeVisual;
    }

    /**
     * @param acuidadeVisual the acuidadeVisual to set
     */
    public void setAcuidadeVisual(int acuidadeVisual) {
        this.acuidadeVisual = acuidadeVisual;
    }

    /**
     * @return the acuidadeAuditiva
     */
    public int getAcuidadeAuditiva() {
        return acuidadeAuditiva;
    }

    /**
     * @param acuidadeAuditiva the acuidadeAuditiva to set
     */
    public void setAcuidadeAuditiva(int acuidadeAuditiva) {
        this.acuidadeAuditiva = acuidadeAuditiva;
    }

    /**
     * @return the funcaoMotora
     */
    public int getFuncaoMotora() {
        return funcaoMotora;
    }

    /**
     * @param funcaoMotora the funcaoMotora to set
     */
    public void setFuncaoMotora(int funcaoMotora) {
        this.funcaoMotora = funcaoMotora;
    }

    /**
     * @return the qualFuncaoMotora
     */
    public String getQualFuncaoMotora() {
        return qualFuncaoMotora;
    }

    /**
     * @param qualFuncaoMotora the qualFuncaoMotora to set
     */
    public void setQualFuncaoMotora(String qualFuncaoMotora) {
        this.qualFuncaoMotora = qualFuncaoMotora;
    }

    /**
     * @return the falaLinguagem
     */
    public int getFalaLinguagem() {
        return falaLinguagem;
    }

    /**
     * @param falaLinguagem the falaLinguagem to set
     */
    public void setFalaLinguagem(int falaLinguagem) {
        this.falaLinguagem = falaLinguagem;
    }

    /**
     * @return the qualFala
     */
    public String getQualFala() {
        return qualFala;
    }

    /**
     * @param qualFala the qualFala to set
     */
    public void setQualFala(String qualFala) {
        this.qualFala = qualFala;
    }

    /**
     * @return the pele
     */
    public int getPele() {
        return pele;
    }

    /**
     * @param pele the pele to set
     */
    public void setPele(int pele) {
        this.pele = pele;
    }

    /**
     * @return the mucosa
     */
    public int getMucosa() {
        return mucosa;
    }

    /**
     * @param mucosa the mucosa to set
     */
    public void setMucosa(int mucosa) {
        this.mucosa = mucosa;
    }

    /**
     * @return the tipoPele
     */
    public String getTipoPele() {
        return tipoPele;
    }

    /**
     * @param tipoPele the tipoPele to set
     */
    public void setTipoPele(String tipoPele) {
        this.tipoPele = tipoPele;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the cabelos
     */
    public int getCabelos() {
        return cabelos;
    }

    /**
     * @param cabelos the cabelos to set
     */
    public void setCabelos(int cabelos) {
        this.cabelos = cabelos;
    }

    /**
     * @return the boca
     */
    public int getBoca() {
        return boca;
    }

    /**
     * @param boca the boca to set
     */
    public void setBoca(int boca) {
        this.boca = boca;
    }

    /**
     * @return the funcaoRespiratoria
     */
    public int getFuncaoRespiratoria() {
        return funcaoRespiratoria;
    }

    /**
     * @param funcaoRespiratoria the funcaoRespiratoria to set
     */
    public void setFuncaoRespiratoria(int funcaoRespiratoria) {
        this.funcaoRespiratoria = funcaoRespiratoria;
    }

    /**
     * @return the torax
     */
    public int getTorax() {
        return torax;
    }

    /**
     * @param torax the torax to set
     */
    public void setTorax(int torax) {
        this.torax = torax;
    }

    /**
     * @return the funcaoIntestinal
     */
    public int getFuncaoIntestinal() {
        return funcaoIntestinal;
    }

    /**
     * @param funcaoIntestinal the funcaoIntestinal to set
     */
    public void setFuncaoIntestinal(int funcaoIntestinal) {
        this.funcaoIntestinal = funcaoIntestinal;
    }

    /**
     * @return the diasConstipado
     */
    public String getDiasConstipado() {
        return diasConstipado;
    }

    /**
     * @param diasConstipado the diasConstipado to set
     */
    public void setDiasConstipado(String diasConstipado) {
        this.diasConstipado = diasConstipado;
    }

    /**
     * @return the abdome
     */
    public int getAbdome() {
        return abdome;
    }

    /**
     * @param abdome the abdome to set
     */
    public void setAbdome(int abdome) {
        this.abdome = abdome;
    }

    /**
     * @return the funcaoVesical
     */
    public int getFuncaoVesical() {
        return funcaoVesical;
    }

    /**
     * @param funcaoVesical the funcaoVesical to set
     */
    public void setFuncaoVesical(int funcaoVesical) {
        this.funcaoVesical = funcaoVesical;
    }

    /**
     * @return the genitalia
     */
    public int getGenitalia() {
        return genitalia;
    }

    /**
     * @param genitalia the genitalia to set
     */
    public void setGenitalia(int genitalia) {
        this.genitalia = genitalia;
    }

    /**
     * @return the qualGenitalia
     */
    public String getQualGenitalia() {
        return qualGenitalia;
    }

    /**
     * @param qualGenitalia the qualGenitalia to set
     */
    public void setQualGenitalia(String qualGenitalia) {
        this.qualGenitalia = qualGenitalia;
    }

    /**
     * @return the vacinado
     */
    public String getVacinado() {
        return vacinado;
    }

    /**
     * @param vacinado the vacinado to set
     */
    public void setVacinado(String vacinado) {
        this.vacinado = vacinado;
    }

    /**
     * @return the quaisVacinas
     */
    public String getQuaisVacinas() {
        return quaisVacinas;
    }

    /**
     * @param quaisVacinas the quaisVacinas to set
     */
    public void setQuaisVacinas(String quaisVacinas) {
        this.quaisVacinas = quaisVacinas;
    }

    /**
     * @return the vdrl
     */
    public String getVdrl() {
        return vdrl;
    }

    /**
     * @param vdrl the vdrl to set
     */
    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    /**
     * @return the hepatiteC
     */
    public String getHepatiteC() {
        return hepatiteC;
    }

    /**
     * @param hepatiteC the hepatiteC to set
     */
    public void setHepatiteC(String hepatiteC) {
        this.hepatiteC = hepatiteC;
    }

    /**
     * @return the hepatiteB
     */
    public String getHepatiteB() {
        return hepatiteB;
    }

    /**
     * @param hepatiteB the hepatiteB to set
     */
    public void setHepatiteB(String hepatiteB) {
        this.hepatiteB = hepatiteB;
    }

    /**
     * @return the hiv
     */
    public String getHiv() {
        return hiv;
    }

    /**
     * @param hiv the hiv to set
     */
    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    /**
     * @return the cirurgias
     */
    public String getCirurgias() {
        return cirurgias;
    }

    /**
     * @param cirurgias the cirurgias to set
     */
    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    /**
     * @return the quaisCirurgias
     */
    public String getQuaisCirurgias() {
        return quaisCirurgias;
    }

    /**
     * @param quaisCirurgias the quaisCirurgias to set
     */
    public void setQuaisCirurgias(String quaisCirurgias) {
        this.quaisCirurgias = quaisCirurgias;
    }

    /**
     * @return the usuarioDrogas
     */
    public String getUsuarioDrogas() {
        return usuarioDrogas;
    }

    /**
     * @param usuarioDrogas the usuarioDrogas to set
     */
    public void setUsuarioDrogas(String usuarioDrogas) {
        this.usuarioDrogas = usuarioDrogas;
    }

    /**
     * @return the quaisDrogas
     */
    public String getQuaisDrogas() {
        return quaisDrogas;
    }

    /**
     * @param quaisDrogas the quaisDrogas to set
     */
    public void setQuaisDrogas(String quaisDrogas) {
        this.quaisDrogas = quaisDrogas;
    }

    /**
     * @return the portadorDoenca
     */
    public String getPortadorDoenca() {
        return portadorDoenca;
    }

    /**
     * @param portadorDoenca the portadorDoenca to set
     */
    public void setPortadorDoenca(String portadorDoenca) {
        this.portadorDoenca = portadorDoenca;
    }

    /**
     * @return the quaisDoencas
     */
    public String getQuaisDoencas() {
        return quaisDoencas;
    }

    /**
     * @param quaisDoencas the quaisDoencas to set
     */
    public void setQuaisDoencas(String quaisDoencas) {
        this.quaisDoencas = quaisDoencas;
    }

    /**
     * @return the Alergias
     */
    public String getAlergias() {
        return Alergias;
    }

    /**
     * @param Alergias the Alergias to set
     */
    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }

    /**
     * @return the quaisAlergias
     */
    public String getQuaisAlergias() {
        return quaisAlergias;
    }

    /**
     * @param quaisAlergias the quaisAlergias to set
     */
    public void setQuaisAlergias(String quaisAlergias) {
        this.quaisAlergias = quaisAlergias;
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
     * @return the deptoMedico
     */
    public String getDeptoMedico() {
        return deptoMedico;
    }

    /**
     * @param deptoMedico the deptoMedico to set
     */
    public void setDeptoMedico(String deptoMedico) {
        this.deptoMedico = deptoMedico;
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
     * @return the escabiose
     */
    public String getEscabiose() {
        return escabiose;
    }

    /**
     * @param escabiose the escabiose to set
     */
    public void setEscabiose(String escabiose) {
        this.escabiose = escabiose;
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
     * @return the vacina
     */
    public String getVacina() {
        return vacina;
    }

    /**
     * @param vacina the vacina to set
     */
    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    /**
     * @return the dst
     */
    public String getDst() {
        return dst;
    }

    /**
     * @param dst the dst to set
     */
    public void setDst(String dst) {
        this.dst = dst;
    }

    /**
     * @return the hpv
     */
    public String getHpv() {
        return hpv;
    }

    /**
     * @param hpv the hpv to set
     */
    public void setHpv(String hpv) {
        this.hpv = hpv;
    }
}
