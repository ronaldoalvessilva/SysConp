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
public class CCGF_PAI {
    private int idCCFGF;
    private int idVF;
    private int idPai;   
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idFamiliarPAI;
    private String nomeFamiliarPAI;
    private int idadeFamiliarPAI;
    private String vinculoPAI;
    private String ocupacaoFamiliarPAI;
    private String enderecoTelefonePAI;
    private String temFilhos;
    private int quantosFilhos;
    private String reconhecerPaterna;
    private String dadosPaternidade;
    private String estaoFilhos;
    private String necessidaEspecial;
    private String necessidadeESP;
    private String cRAS;
    private String cREAS;
    private String recebeBeneficio;
    private String quaisBeneficiosFamilia;
    private String antesBeneficio;
    private String quaisBeneficiosAntesPrisao;
    private String necessitaBeneficio;
    private String quemNecessitaBeneficio;
    private String moradia;
    private String modalidade;
    private String abastecimento;
    private String eliminaDejetos;
    private String descarte;
    private String familiaVulneraSocial;
    private String viveuRua;
    private int quantoTempo;
    private String motivo;
    private String familiaDetido;
    private String restabelecerVinculo;
    private String comoRestabelecer;
    private int idVisitaPAI;
    private String nomeVisitaPAI;
    private String ocupacaoVisita;
    private String parentescoPAI;
    private int idadeVisita;
    private int idVisitaIntima;
    private String nomeVisitaIntima;
    private String ocupacaoVisitaIntima;
    private String parentescoVisitaIntima;
    private String idadeVisitaIntima;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;         

    public CCGF_PAI(int idCCFGF, int idVF, int idPai, int idInternoCrc, String nomeInternoCrc, int idFamiliarPAI, String nomeFamiliarPAI, int idadeFamiliarPAI, String vinculoPAI, String ocupacaoFamiliarPAI, String enderecoTelefonePAI, String temFilhos, int quantosFilhos, String reconhecerPaterna, String dadosPaternidade, String estaoFilhos, String necessidaEspecial, String necessidadeESP, String cRAS, String cREAS, String recebeBeneficio, String quaisBeneficiosFamilia, String antesBeneficio, String quaisBeneficiosAntesPrisao, String necessitaBeneficio, String quemNecessitaBeneficio, String moradia, String modalidade, String abastecimento, String eliminaDejetos, String descarte, String familiaVulneraSocial, String viveuRua, int quantoTempo, String motivo, String familiaDetido, String restabelecerVinculo, String comoRestabelecer, int idVisitaPAI, String nomeVisitaPAI, String ocupacaoVisita, String parentescoPAI, int idadeVisita, int idVisitaIntima, String nomeVisitaIntima, String ocupacaoVisitaIntima, String parentescoVisitaIntima, String idadeVisitaIntima, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idCCFGF = idCCFGF;
        this.idVF = idVF;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idFamiliarPAI = idFamiliarPAI;
        this.nomeFamiliarPAI = nomeFamiliarPAI;
        this.idadeFamiliarPAI = idadeFamiliarPAI;
        this.vinculoPAI = vinculoPAI;
        this.ocupacaoFamiliarPAI = ocupacaoFamiliarPAI;
        this.enderecoTelefonePAI = enderecoTelefonePAI;
        this.temFilhos = temFilhos;
        this.quantosFilhos = quantosFilhos;
        this.reconhecerPaterna = reconhecerPaterna;
        this.dadosPaternidade = dadosPaternidade;
        this.estaoFilhos = estaoFilhos;
        this.necessidaEspecial = necessidaEspecial;
        this.necessidadeESP = necessidadeESP;
        this.cRAS = cRAS;
        this.cREAS = cREAS;
        this.recebeBeneficio = recebeBeneficio;
        this.quaisBeneficiosFamilia = quaisBeneficiosFamilia;
        this.antesBeneficio = antesBeneficio;
        this.quaisBeneficiosAntesPrisao = quaisBeneficiosAntesPrisao;
        this.necessitaBeneficio = necessitaBeneficio;
        this.quemNecessitaBeneficio = quemNecessitaBeneficio;
        this.moradia = moradia;
        this.modalidade = modalidade;
        this.abastecimento = abastecimento;
        this.eliminaDejetos = eliminaDejetos;
        this.descarte = descarte;
        this.familiaVulneraSocial = familiaVulneraSocial;
        this.viveuRua = viveuRua;
        this.quantoTempo = quantoTempo;
        this.motivo = motivo;
        this.familiaDetido = familiaDetido;
        this.restabelecerVinculo = restabelecerVinculo;
        this.comoRestabelecer = comoRestabelecer;
        this.idVisitaPAI = idVisitaPAI;
        this.nomeVisitaPAI = nomeVisitaPAI;
        this.ocupacaoVisita = ocupacaoVisita;
        this.parentescoPAI = parentescoPAI;
        this.idadeVisita = idadeVisita;
        this.idVisitaIntima = idVisitaIntima;
        this.nomeVisitaIntima = nomeVisitaIntima;
        this.ocupacaoVisitaIntima = ocupacaoVisitaIntima;
        this.parentescoVisitaIntima = parentescoVisitaIntima;
        this.idadeVisitaIntima = idadeVisitaIntima;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    public CCGF_PAI() {
    }

    /**
     * @return the idCCFGF
     */
    public int getIdCCFGF() {
        return idCCFGF;
    }

    /**
     * @param idCCFGF the idCCFGF to set
     */
    public void setIdCCFGF(int idCCFGF) {
        this.idCCFGF = idCCFGF;
    }

    /**
     * @return the idVF
     */
    public int getIdVF() {
        return idVF;
    }

    /**
     * @param idVF the idVF to set
     */
    public void setIdVF(int idVF) {
        this.idVF = idVF;
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
     * @return the idFamiliarPAI
     */
    public int getIdFamiliarPAI() {
        return idFamiliarPAI;
    }

    /**
     * @param idFamiliarPAI the idFamiliarPAI to set
     */
    public void setIdFamiliarPAI(int idFamiliarPAI) {
        this.idFamiliarPAI = idFamiliarPAI;
    }

    /**
     * @return the nomeFamiliarPAI
     */
    public String getNomeFamiliarPAI() {
        return nomeFamiliarPAI;
    }

    /**
     * @param nomeFamiliarPAI the nomeFamiliarPAI to set
     */
    public void setNomeFamiliarPAI(String nomeFamiliarPAI) {
        this.nomeFamiliarPAI = nomeFamiliarPAI;
    }

    /**
     * @return the idadeFamiliarPAI
     */
    public int getIdadeFamiliarPAI() {
        return idadeFamiliarPAI;
    }

    /**
     * @param idadeFamiliarPAI the idadeFamiliarPAI to set
     */
    public void setIdadeFamiliarPAI(int idadeFamiliarPAI) {
        this.idadeFamiliarPAI = idadeFamiliarPAI;
    }

    /**
     * @return the vinculoPAI
     */
    public String getVinculoPAI() {
        return vinculoPAI;
    }

    /**
     * @param vinculoPAI the vinculoPAI to set
     */
    public void setVinculoPAI(String vinculoPAI) {
        this.vinculoPAI = vinculoPAI;
    }

    /**
     * @return the ocupacaoFamiliarPAI
     */
    public String getOcupacaoFamiliarPAI() {
        return ocupacaoFamiliarPAI;
    }

    /**
     * @param ocupacaoFamiliarPAI the ocupacaoFamiliarPAI to set
     */
    public void setOcupacaoFamiliarPAI(String ocupacaoFamiliarPAI) {
        this.ocupacaoFamiliarPAI = ocupacaoFamiliarPAI;
    }

    /**
     * @return the enderecoTelefonePAI
     */
    public String getEnderecoTelefonePAI() {
        return enderecoTelefonePAI;
    }

    /**
     * @param enderecoTelefonePAI the enderecoTelefonePAI to set
     */
    public void setEnderecoTelefonePAI(String enderecoTelefonePAI) {
        this.enderecoTelefonePAI = enderecoTelefonePAI;
    }

    /**
     * @return the temFilhos
     */
    public String getTemFilhos() {
        return temFilhos;
    }

    /**
     * @param temFilhos the temFilhos to set
     */
    public void setTemFilhos(String temFilhos) {
        this.temFilhos = temFilhos;
    }

    /**
     * @return the quantosFilhos
     */
    public int getQuantosFilhos() {
        return quantosFilhos;
    }

    /**
     * @param quantosFilhos the quantosFilhos to set
     */
    public void setQuantosFilhos(int quantosFilhos) {
        this.quantosFilhos = quantosFilhos;
    }

    /**
     * @return the reconhecerPaterna
     */
    public String getReconhecerPaterna() {
        return reconhecerPaterna;
    }

    /**
     * @param reconhecerPaterna the reconhecerPaterna to set
     */
    public void setReconhecerPaterna(String reconhecerPaterna) {
        this.reconhecerPaterna = reconhecerPaterna;
    }

    /**
     * @return the dadosPaternidade
     */
    public String getDadosPaternidade() {
        return dadosPaternidade;
    }

    /**
     * @param dadosPaternidade the dadosPaternidade to set
     */
    public void setDadosPaternidade(String dadosPaternidade) {
        this.dadosPaternidade = dadosPaternidade;
    }

    /**
     * @return the estaoFilhos
     */
    public String getEstaoFilhos() {
        return estaoFilhos;
    }

    /**
     * @param estaoFilhos the estaoFilhos to set
     */
    public void setEstaoFilhos(String estaoFilhos) {
        this.estaoFilhos = estaoFilhos;
    }

    /**
     * @return the necessidaEspecial
     */
    public String getNecessidaEspecial() {
        return necessidaEspecial;
    }

    /**
     * @param necessidaEspecial the necessidaEspecial to set
     */
    public void setNecessidaEspecial(String necessidaEspecial) {
        this.necessidaEspecial = necessidaEspecial;
    }

    /**
     * @return the necessidadeESP
     */
    public String getNecessidadeESP() {
        return necessidadeESP;
    }

    /**
     * @param necessidadeESP the necessidadeESP to set
     */
    public void setNecessidadeESP(String necessidadeESP) {
        this.necessidadeESP = necessidadeESP;
    }

    /**
     * @return the cRAS
     */
    public String getcRAS() {
        return cRAS;
    }

    /**
     * @param cRAS the cRAS to set
     */
    public void setcRAS(String cRAS) {
        this.cRAS = cRAS;
    }

    /**
     * @return the cREAS
     */
    public String getcREAS() {
        return cREAS;
    }

    /**
     * @param cREAS the cREAS to set
     */
    public void setcREAS(String cREAS) {
        this.cREAS = cREAS;
    }

    /**
     * @return the recebeBeneficio
     */
    public String getRecebeBeneficio() {
        return recebeBeneficio;
    }

    /**
     * @param recebeBeneficio the recebeBeneficio to set
     */
    public void setRecebeBeneficio(String recebeBeneficio) {
        this.recebeBeneficio = recebeBeneficio;
    }

    /**
     * @return the quaisBeneficiosFamilia
     */
    public String getQuaisBeneficiosFamilia() {
        return quaisBeneficiosFamilia;
    }

    /**
     * @param quaisBeneficiosFamilia the quaisBeneficiosFamilia to set
     */
    public void setQuaisBeneficiosFamilia(String quaisBeneficiosFamilia) {
        this.quaisBeneficiosFamilia = quaisBeneficiosFamilia;
    }

    /**
     * @return the antesBeneficio
     */
    public String getAntesBeneficio() {
        return antesBeneficio;
    }

    /**
     * @param antesBeneficio the antesBeneficio to set
     */
    public void setAntesBeneficio(String antesBeneficio) {
        this.antesBeneficio = antesBeneficio;
    }

    /**
     * @return the quaisBeneficiosAntesPrisao
     */
    public String getQuaisBeneficiosAntesPrisao() {
        return quaisBeneficiosAntesPrisao;
    }

    /**
     * @param quaisBeneficiosAntesPrisao the quaisBeneficiosAntesPrisao to set
     */
    public void setQuaisBeneficiosAntesPrisao(String quaisBeneficiosAntesPrisao) {
        this.quaisBeneficiosAntesPrisao = quaisBeneficiosAntesPrisao;
    }

    /**
     * @return the necessitaBeneficio
     */
    public String getNecessitaBeneficio() {
        return necessitaBeneficio;
    }

    /**
     * @param necessitaBeneficio the necessitaBeneficio to set
     */
    public void setNecessitaBeneficio(String necessitaBeneficio) {
        this.necessitaBeneficio = necessitaBeneficio;
    }

    /**
     * @return the quemNecessitaBeneficio
     */
    public String getQuemNecessitaBeneficio() {
        return quemNecessitaBeneficio;
    }

    /**
     * @param quemNecessitaBeneficio the quemNecessitaBeneficio to set
     */
    public void setQuemNecessitaBeneficio(String quemNecessitaBeneficio) {
        this.quemNecessitaBeneficio = quemNecessitaBeneficio;
    }

    /**
     * @return the moradia
     */
    public String getMoradia() {
        return moradia;
    }

    /**
     * @param moradia the moradia to set
     */
    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    /**
     * @return the modalidade
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the abastecimento
     */
    public String getAbastecimento() {
        return abastecimento;
    }

    /**
     * @param abastecimento the abastecimento to set
     */
    public void setAbastecimento(String abastecimento) {
        this.abastecimento = abastecimento;
    }

    /**
     * @return the eliminaDejetos
     */
    public String getEliminaDejetos() {
        return eliminaDejetos;
    }

    /**
     * @param eliminaDejetos the eliminaDejetos to set
     */
    public void setEliminaDejetos(String eliminaDejetos) {
        this.eliminaDejetos = eliminaDejetos;
    }

    /**
     * @return the descarte
     */
    public String getDescarte() {
        return descarte;
    }

    /**
     * @param descarte the descarte to set
     */
    public void setDescarte(String descarte) {
        this.descarte = descarte;
    }

    /**
     * @return the familiaVulneraSocial
     */
    public String getFamiliaVulneraSocial() {
        return familiaVulneraSocial;
    }

    /**
     * @param familiaVulneraSocial the familiaVulneraSocial to set
     */
    public void setFamiliaVulneraSocial(String familiaVulneraSocial) {
        this.familiaVulneraSocial = familiaVulneraSocial;
    }

    /**
     * @return the viveuRua
     */
    public String getViveuRua() {
        return viveuRua;
    }

    /**
     * @param viveuRua the viveuRua to set
     */
    public void setViveuRua(String viveuRua) {
        this.viveuRua = viveuRua;
    }

    /**
     * @return the quantoTempo
     */
    public int getQuantoTempo() {
        return quantoTempo;
    }

    /**
     * @param quantoTempo the quantoTempo to set
     */
    public void setQuantoTempo(int quantoTempo) {
        this.quantoTempo = quantoTempo;
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
     * @return the familiaDetido
     */
    public String getFamiliaDetido() {
        return familiaDetido;
    }

    /**
     * @param familiaDetido the familiaDetido to set
     */
    public void setFamiliaDetido(String familiaDetido) {
        this.familiaDetido = familiaDetido;
    }

    /**
     * @return the restabelecerVinculo
     */
    public String getRestabelecerVinculo() {
        return restabelecerVinculo;
    }

    /**
     * @param restabelecerVinculo the restabelecerVinculo to set
     */
    public void setRestabelecerVinculo(String restabelecerVinculo) {
        this.restabelecerVinculo = restabelecerVinculo;
    }

    /**
     * @return the comoRestabelecer
     */
    public String getComoRestabelecer() {
        return comoRestabelecer;
    }

    /**
     * @param comoRestabelecer the comoRestabelecer to set
     */
    public void setComoRestabelecer(String comoRestabelecer) {
        this.comoRestabelecer = comoRestabelecer;
    }

    /**
     * @return the idVisitaPAI
     */
    public int getIdVisitaPAI() {
        return idVisitaPAI;
    }

    /**
     * @param idVisitaPAI the idVisitaPAI to set
     */
    public void setIdVisitaPAI(int idVisitaPAI) {
        this.idVisitaPAI = idVisitaPAI;
    }

    /**
     * @return the nomeVisitaPAI
     */
    public String getNomeVisitaPAI() {
        return nomeVisitaPAI;
    }

    /**
     * @param nomeVisitaPAI the nomeVisitaPAI to set
     */
    public void setNomeVisitaPAI(String nomeVisitaPAI) {
        this.nomeVisitaPAI = nomeVisitaPAI;
    }

    /**
     * @return the ocupacaoVisita
     */
    public String getOcupacaoVisita() {
        return ocupacaoVisita;
    }

    /**
     * @param ocupacaoVisita the ocupacaoVisita to set
     */
    public void setOcupacaoVisita(String ocupacaoVisita) {
        this.ocupacaoVisita = ocupacaoVisita;
    }

    /**
     * @return the parentescoPAI
     */
    public String getParentescoPAI() {
        return parentescoPAI;
    }

    /**
     * @param parentescoPAI the parentescoPAI to set
     */
    public void setParentescoPAI(String parentescoPAI) {
        this.parentescoPAI = parentescoPAI;
    }

    /**
     * @return the idadeVisita
     */
    public int getIdadeVisita() {
        return idadeVisita;
    }

    /**
     * @param idadeVisita the idadeVisita to set
     */
    public void setIdadeVisita(int idadeVisita) {
        this.idadeVisita = idadeVisita;
    }

    /**
     * @return the idVisitaIntima
     */
    public int getIdVisitaIntima() {
        return idVisitaIntima;
    }

    /**
     * @param idVisitaIntima the idVisitaIntima to set
     */
    public void setIdVisitaIntima(int idVisitaIntima) {
        this.idVisitaIntima = idVisitaIntima;
    }

    /**
     * @return the nomeVisitaIntima
     */
    public String getNomeVisitaIntima() {
        return nomeVisitaIntima;
    }

    /**
     * @param nomeVisitaIntima the nomeVisitaIntima to set
     */
    public void setNomeVisitaIntima(String nomeVisitaIntima) {
        this.nomeVisitaIntima = nomeVisitaIntima;
    }

    /**
     * @return the ocupacaoVisitaIntima
     */
    public String getOcupacaoVisitaIntima() {
        return ocupacaoVisitaIntima;
    }

    /**
     * @param ocupacaoVisitaIntima the ocupacaoVisitaIntima to set
     */
    public void setOcupacaoVisitaIntima(String ocupacaoVisitaIntima) {
        this.ocupacaoVisitaIntima = ocupacaoVisitaIntima;
    }

    /**
     * @return the parentescoVisitaIntima
     */
    public String getParentescoVisitaIntima() {
        return parentescoVisitaIntima;
    }

    /**
     * @param parentescoVisitaIntima the parentescoVisitaIntima to set
     */
    public void setParentescoVisitaIntima(String parentescoVisitaIntima) {
        this.parentescoVisitaIntima = parentescoVisitaIntima;
    }

    /**
     * @return the idadeVisitaIntima
     */
    public String getIdadeVisitaIntima() {
        return idadeVisitaIntima;
    }

    /**
     * @param idadeVisitaIntima the idadeVisitaIntima to set
     */
    public void setIdadeVisitaIntima(String idadeVisitaIntima) {
        this.idadeVisitaIntima = idadeVisitaIntima;
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
