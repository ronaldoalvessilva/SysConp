/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class PsicologiaMedicoPaiPsicosocial {
        private int idPsiMed;
	private int idPai;	
	private int idInternoCrc;
        private String nomeInternoCrc;
	private String familiaTranstornoMental;
	private String quemTranstornoMental;
	private String qualTranstornoMental;
	private String necessidadePSI;
	private int consultaPSI;
	private int acompanhaPSI;
	private String fazUsoDroga;
	private String quaisDrogas;
	private String compartilhaDrogas;
	private String reducaoDanos;
	private String porqueReduzDanos;
	private String aceitaProgramasDanos;
	private String porqueAceitaProgroReduDanos;
	private String queixaProbSaude;
	private int hipertensao;
	private int diabetes;
	private int tuberculose;
	private int dST;
	private int hepatite;
	private int hanseniase;
	private int outrasDoencas;
	private String quaisOutrasDoencas;
	private String problemasSaudeBucal;
	private String fazTratamentoBucal;
	private String quaisTratamentoBucal;
	private String usuarioInsert;
	private String usuarioUp;
	private String dataInsert;
	private String dataUp;
	private String horarioInsert;
	private String horarioUp;    

    public PsicologiaMedicoPaiPsicosocial(int idPsiMed, int idPai, int idInternoCrc, String nomeInternoCrc, String familiaTranstornoMental, String quemTranstornoMental, String qualTranstornoMental, String necessidadePSI, int consultaPSI, int acompanhaPSI, String fazUsoDroga, String quaisDrogas, String compartilhaDrogas, String reducaoDanos, String porqueReduzDanos, String aceitaProgramasDanos, String porqueAceitaProgroReduDanos, String queixaProbSaude, int hipertensao, int diabetes, int tuberculose, int dST, int hepatite, int hanseniase, int outrasDoencas, String quaisOutrasDoencas, String problemasSaudeBucal, String fazTratamentoBucal, String quaisTratamentoBucal, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPsiMed = idPsiMed;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.familiaTranstornoMental = familiaTranstornoMental;
        this.quemTranstornoMental = quemTranstornoMental;
        this.qualTranstornoMental = qualTranstornoMental;
        this.necessidadePSI = necessidadePSI;
        this.consultaPSI = consultaPSI;
        this.acompanhaPSI = acompanhaPSI;
        this.fazUsoDroga = fazUsoDroga;
        this.quaisDrogas = quaisDrogas;
        this.compartilhaDrogas = compartilhaDrogas;
        this.reducaoDanos = reducaoDanos;
        this.porqueReduzDanos = porqueReduzDanos;
        this.aceitaProgramasDanos = aceitaProgramasDanos;
        this.porqueAceitaProgroReduDanos = porqueAceitaProgroReduDanos;
        this.queixaProbSaude = queixaProbSaude;
        this.hipertensao = hipertensao;
        this.diabetes = diabetes;
        this.tuberculose = tuberculose;
        this.dST = dST;
        this.hepatite = hepatite;
        this.hanseniase = hanseniase;
        this.outrasDoencas = outrasDoencas;
        this.quaisOutrasDoencas = quaisOutrasDoencas;
        this.problemasSaudeBucal = problemasSaudeBucal;
        this.fazTratamentoBucal = fazTratamentoBucal;
        this.quaisTratamentoBucal = quaisTratamentoBucal;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PsicologiaMedicoPaiPsicosocial() {
    }

    /**
     * @return the idPsiMed
     */
    public int getIdPsiMed() {
        return idPsiMed;
    }

    /**
     * @param idPsiMed the idPsiMed to set
     */
    public void setIdPsiMed(int idPsiMed) {
        this.idPsiMed = idPsiMed;
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
     * @return the familiaTranstornoMental
     */
    public String getFamiliaTranstornoMental() {
        return familiaTranstornoMental;
    }

    /**
     * @param familiaTranstornoMental the familiaTranstornoMental to set
     */
    public void setFamiliaTranstornoMental(String familiaTranstornoMental) {
        this.familiaTranstornoMental = familiaTranstornoMental;
    }

    /**
     * @return the quemTranstornoMental
     */
    public String getQuemTranstornoMental() {
        return quemTranstornoMental;
    }

    /**
     * @param quemTranstornoMental the quemTranstornoMental to set
     */
    public void setQuemTranstornoMental(String quemTranstornoMental) {
        this.quemTranstornoMental = quemTranstornoMental;
    }

    /**
     * @return the qualTranstornoMental
     */
    public String getQualTranstornoMental() {
        return qualTranstornoMental;
    }

    /**
     * @param qualTranstornoMental the qualTranstornoMental to set
     */
    public void setQualTranstornoMental(String qualTranstornoMental) {
        this.qualTranstornoMental = qualTranstornoMental;
    }

    /**
     * @return the necessidadePSI
     */
    public String getNecessidadePSI() {
        return necessidadePSI;
    }

    /**
     * @param necessidadePSI the necessidadePSI to set
     */
    public void setNecessidadePSI(String necessidadePSI) {
        this.necessidadePSI = necessidadePSI;
    }

    /**
     * @return the consultaPSI
     */
    public int getConsultaPSI() {
        return consultaPSI;
    }

    /**
     * @param consultaPSI the consultaPSI to set
     */
    public void setConsultaPSI(int consultaPSI) {
        this.consultaPSI = consultaPSI;
    }

    /**
     * @return the acompanhaPSI
     */
    public int getAcompanhaPSI() {
        return acompanhaPSI;
    }

    /**
     * @param acompanhaPSI the acompanhaPSI to set
     */
    public void setAcompanhaPSI(int acompanhaPSI) {
        this.acompanhaPSI = acompanhaPSI;
    }

    /**
     * @return the fazUsoDroga
     */
    public String getFazUsoDroga() {
        return fazUsoDroga;
    }

    /**
     * @param fazUsoDroga the fazUsoDroga to set
     */
    public void setFazUsoDroga(String fazUsoDroga) {
        this.fazUsoDroga = fazUsoDroga;
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
     * @return the compartilhaDrogas
     */
    public String getCompartilhaDrogas() {
        return compartilhaDrogas;
    }

    /**
     * @param compartilhaDrogas the compartilhaDrogas to set
     */
    public void setCompartilhaDrogas(String compartilhaDrogas) {
        this.compartilhaDrogas = compartilhaDrogas;
    }

    /**
     * @return the reducaoDanos
     */
    public String getReducaoDanos() {
        return reducaoDanos;
    }

    /**
     * @param reducaoDanos the reducaoDanos to set
     */
    public void setReducaoDanos(String reducaoDanos) {
        this.reducaoDanos = reducaoDanos;
    }

    /**
     * @return the porqueReduzDanos
     */
    public String getPorqueReduzDanos() {
        return porqueReduzDanos;
    }

    /**
     * @param porqueReduzDanos the porqueReduzDanos to set
     */
    public void setPorqueReduzDanos(String porqueReduzDanos) {
        this.porqueReduzDanos = porqueReduzDanos;
    }

    /**
     * @return the aceitaProgramasDanos
     */
    public String getAceitaProgramasDanos() {
        return aceitaProgramasDanos;
    }

    /**
     * @param aceitaProgramasDanos the aceitaProgramasDanos to set
     */
    public void setAceitaProgramasDanos(String aceitaProgramasDanos) {
        this.aceitaProgramasDanos = aceitaProgramasDanos;
    }

    /**
     * @return the porqueAceitaProgroReduDanos
     */
    public String getPorqueAceitaProgroReduDanos() {
        return porqueAceitaProgroReduDanos;
    }

    /**
     * @param porqueAceitaProgroReduDanos the porqueAceitaProgroReduDanos to set
     */
    public void setPorqueAceitaProgroReduDanos(String porqueAceitaProgroReduDanos) {
        this.porqueAceitaProgroReduDanos = porqueAceitaProgroReduDanos;
    }

    /**
     * @return the queixaProbSaude
     */
    public String getQueixaProbSaude() {
        return queixaProbSaude;
    }

    /**
     * @param queixaProbSaude the queixaProbSaude to set
     */
    public void setQueixaProbSaude(String queixaProbSaude) {
        this.queixaProbSaude = queixaProbSaude;
    }

    /**
     * @return the hipertensao
     */
    public int getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(int hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the diabetes
     */
    public int getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the tuberculose
     */
    public int getTuberculose() {
        return tuberculose;
    }

    /**
     * @param tuberculose the tuberculose to set
     */
    public void setTuberculose(int tuberculose) {
        this.tuberculose = tuberculose;
    }

    /**
     * @return the dST
     */
    public int getdST() {
        return dST;
    }

    /**
     * @param dST the dST to set
     */
    public void setdST(int dST) {
        this.dST = dST;
    }

    /**
     * @return the hepatite
     */
    public int getHepatite() {
        return hepatite;
    }

    /**
     * @param hepatite the hepatite to set
     */
    public void setHepatite(int hepatite) {
        this.hepatite = hepatite;
    }

    /**
     * @return the hanseniase
     */
    public int getHanseniase() {
        return hanseniase;
    }

    /**
     * @param hanseniase the hanseniase to set
     */
    public void setHanseniase(int hanseniase) {
        this.hanseniase = hanseniase;
    }

    /**
     * @return the outrasDoencas
     */
    public int getOutrasDoencas() {
        return outrasDoencas;
    }

    /**
     * @param outrasDoencas the outrasDoencas to set
     */
    public void setOutrasDoencas(int outrasDoencas) {
        this.outrasDoencas = outrasDoencas;
    }

    /**
     * @return the quaisOutrasDoencas
     */
    public String getQuaisOutrasDoencas() {
        return quaisOutrasDoencas;
    }

    /**
     * @param quaisOutrasDoencas the quaisOutrasDoencas to set
     */
    public void setQuaisOutrasDoencas(String quaisOutrasDoencas) {
        this.quaisOutrasDoencas = quaisOutrasDoencas;
    }

    /**
     * @return the problemasSaudeBucal
     */
    public String getProblemasSaudeBucal() {
        return problemasSaudeBucal;
    }

    /**
     * @param problemasSaudeBucal the problemasSaudeBucal to set
     */
    public void setProblemasSaudeBucal(String problemasSaudeBucal) {
        this.problemasSaudeBucal = problemasSaudeBucal;
    }

    /**
     * @return the fazTratamentoBucal
     */
    public String getFazTratamentoBucal() {
        return fazTratamentoBucal;
    }

    /**
     * @param fazTratamentoBucal the fazTratamentoBucal to set
     */
    public void setFazTratamentoBucal(String fazTratamentoBucal) {
        this.fazTratamentoBucal = fazTratamentoBucal;
    }

    /**
     * @return the quaisTratamentoBucal
     */
    public String getQuaisTratamentoBucal() {
        return quaisTratamentoBucal;
    }

    /**
     * @param quaisTratamentoBucal the quaisTratamentoBucal to set
     */
    public void setQuaisTratamentoBucal(String quaisTratamentoBucal) {
        this.quaisTratamentoBucal = quaisTratamentoBucal;
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
