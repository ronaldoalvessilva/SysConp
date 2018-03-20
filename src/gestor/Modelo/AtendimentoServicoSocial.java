/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class AtendimentoServicoSocial {

    private int idAtend;
    private Date dataAtend;
    private int idInternoCrc;
    private String nomeInterno;
    private String statusAtend;
    private String ContatoAtend;
    private String TelefoneAtend;
    private String Telefone1Atend;
    private String CelualarAtend;
    private String EnderecoAtend;
    private String BairroAtend;
    private String CidadeAtend;
    private String EstadoAtend;
    private String CartTrabAtend;
    private String Periodo;
    private String RecebeRecluAtend;
    private String DireitoAuxAtend;
    private String RecebeBolAtend;
    private String QtdPessoasAtend;
    private String QtdTrabaAtend;
    private String CN1Atend;
    private String CN2Atend;
    private String RG1Atend;
    private String RG2atend;
    private String CPF1Atend;
    private String CPF2Atend;
    private String CTPS1Atend;
    private String CTPS2Atend;
    //
    private String municipioNascimento;    
    private String tituloEleito1;
    private String tituloEleitor2;
    private String reservista1;
    private String reservista2;
    private String cartorioRegistro;
    private String recebeBeneficio;
    private String condicaoSegurado;
    private String esposaCompanheira;
    private String tempoConvivencia;
    private String nomeEsposaConvivencia;
    private String qtdPessoasResiCasa;
    private String encaminhaOutrosSetore;
    private String qualSetor;
    private String cancelarVisita;
    private String motivo;
    private String encaminhaTirarDoc;
    private Date dataEncaminharTiraDoc;
    private String encaminarReconhecerPaternidade;
    private Date dataEncaRecPaterna;
    private String recebeVisita;
    //       
    private String nomeConjuge;
    private String PossuiFilhosAtend;
    private String QtdFilhosAtend;
    private String QtdFilhos2Atend;
    private String FilhosNaoRegAtend;
    private String OutrosFilhosAtend;
    private String PaternidadeAtend;
    private String DefensorAtend;
    private String PartiFamiAtend;
    private String ConsiderAtend;
    private String deptoSocial;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;   

    public AtendimentoServicoSocial(int idAtend, Date dataAtend, int idInternoCrc, String nomeInterno, String statusAtend, String ContatoAtend, String TelefoneAtend, String Telefone1Atend, String CelualarAtend, String EnderecoAtend, String BairroAtend, String CidadeAtend, String EstadoAtend, String CartTrabAtend, String Periodo, String RecebeRecluAtend, String DireitoAuxAtend, String RecebeBolAtend, String QtdPessoasAtend, String QtdTrabaAtend, String CN1Atend, String CN2Atend, String RG1Atend, String RG2atend, String CPF1Atend, String CPF2Atend, String CTPS1Atend, String CTPS2Atend, String municipioNascimento, String tituloEleito1, String tituloEleitor2, String reservista1, String reservista2, String cartorioRegistro, String recebeBeneficio, String condicaoSegurado, String esposaCompanheira, String tempoConvivencia, String nomeEsposaConvivencia, String qtdPessoasResiCasa, String encaminhaOutrosSetore, String qualSetor, String cancelarVisita, String motivo, String encaminhaTirarDoc, Date dataEncaminharTiraDoc, String encaminarReconhecerPaternidade, Date dataEncaRecPaterna, String recebeVisita, String nomeConjuge, String PossuiFilhosAtend, String QtdFilhosAtend, String QtdFilhos2Atend, String FilhosNaoRegAtend, String OutrosFilhosAtend, String PaternidadeAtend, String DefensorAtend, String PartiFamiAtend, String ConsiderAtend, String deptoSocial, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idAtend = idAtend;
        this.dataAtend = dataAtend;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.statusAtend = statusAtend;
        this.ContatoAtend = ContatoAtend;
        this.TelefoneAtend = TelefoneAtend;
        this.Telefone1Atend = Telefone1Atend;
        this.CelualarAtend = CelualarAtend;
        this.EnderecoAtend = EnderecoAtend;
        this.BairroAtend = BairroAtend;
        this.CidadeAtend = CidadeAtend;
        this.EstadoAtend = EstadoAtend;
        this.CartTrabAtend = CartTrabAtend;
        this.Periodo = Periodo;
        this.RecebeRecluAtend = RecebeRecluAtend;
        this.DireitoAuxAtend = DireitoAuxAtend;
        this.RecebeBolAtend = RecebeBolAtend;
        this.QtdPessoasAtend = QtdPessoasAtend;
        this.QtdTrabaAtend = QtdTrabaAtend;
        this.CN1Atend = CN1Atend;
        this.CN2Atend = CN2Atend;
        this.RG1Atend = RG1Atend;
        this.RG2atend = RG2atend;
        this.CPF1Atend = CPF1Atend;
        this.CPF2Atend = CPF2Atend;
        this.CTPS1Atend = CTPS1Atend;
        this.CTPS2Atend = CTPS2Atend;
        this.municipioNascimento = municipioNascimento;
        this.tituloEleito1 = tituloEleito1;
        this.tituloEleitor2 = tituloEleitor2;
        this.reservista1 = reservista1;
        this.reservista2 = reservista2;
        this.cartorioRegistro = cartorioRegistro;
        this.recebeBeneficio = recebeBeneficio;
        this.condicaoSegurado = condicaoSegurado;
        this.esposaCompanheira = esposaCompanheira;
        this.tempoConvivencia = tempoConvivencia;
        this.nomeEsposaConvivencia = nomeEsposaConvivencia;
        this.qtdPessoasResiCasa = qtdPessoasResiCasa;
        this.encaminhaOutrosSetore = encaminhaOutrosSetore;
        this.qualSetor = qualSetor;
        this.cancelarVisita = cancelarVisita;
        this.motivo = motivo;
        this.encaminhaTirarDoc = encaminhaTirarDoc;
        this.dataEncaminharTiraDoc = dataEncaminharTiraDoc;
        this.encaminarReconhecerPaternidade = encaminarReconhecerPaternidade;
        this.dataEncaRecPaterna = dataEncaRecPaterna;
        this.recebeVisita = recebeVisita;
        this.nomeConjuge = nomeConjuge;
        this.PossuiFilhosAtend = PossuiFilhosAtend;
        this.QtdFilhosAtend = QtdFilhosAtend;
        this.QtdFilhos2Atend = QtdFilhos2Atend;
        this.FilhosNaoRegAtend = FilhosNaoRegAtend;
        this.OutrosFilhosAtend = OutrosFilhosAtend;
        this.PaternidadeAtend = PaternidadeAtend;
        this.DefensorAtend = DefensorAtend;
        this.PartiFamiAtend = PartiFamiAtend;
        this.ConsiderAtend = ConsiderAtend;
        this.deptoSocial = deptoSocial;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public AtendimentoServicoSocial() {
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
     * @return the statusAtend
     */
    public String getStatusAtend() {
        return statusAtend;
    }

    /**
     * @param statusAtend the statusAtend to set
     */
    public void setStatusAtend(String statusAtend) {
        this.statusAtend = statusAtend;
    }

    /**
     * @return the ContatoAtend
     */
    public String getContatoAtend() {
        return ContatoAtend;
    }

    /**
     * @param ContatoAtend the ContatoAtend to set
     */
    public void setContatoAtend(String ContatoAtend) {
        this.ContatoAtend = ContatoAtend;
    }

    /**
     * @return the TelefoneAtend
     */
    public String getTelefoneAtend() {
        return TelefoneAtend;
    }

    /**
     * @param TelefoneAtend the TelefoneAtend to set
     */
    public void setTelefoneAtend(String TelefoneAtend) {
        this.TelefoneAtend = TelefoneAtend;
    }

    /**
     * @return the Telefone1Atend
     */
    public String getTelefone1Atend() {
        return Telefone1Atend;
    }

    /**
     * @param Telefone1Atend the Telefone1Atend to set
     */
    public void setTelefone1Atend(String Telefone1Atend) {
        this.Telefone1Atend = Telefone1Atend;
    }

    /**
     * @return the CelualarAtend
     */
    public String getCelualarAtend() {
        return CelualarAtend;
    }

    /**
     * @param CelualarAtend the CelualarAtend to set
     */
    public void setCelualarAtend(String CelualarAtend) {
        this.CelualarAtend = CelualarAtend;
    }

    /**
     * @return the EnderecoAtend
     */
    public String getEnderecoAtend() {
        return EnderecoAtend;
    }

    /**
     * @param EnderecoAtend the EnderecoAtend to set
     */
    public void setEnderecoAtend(String EnderecoAtend) {
        this.EnderecoAtend = EnderecoAtend;
    }

    /**
     * @return the BairroAtend
     */
    public String getBairroAtend() {
        return BairroAtend;
    }

    /**
     * @param BairroAtend the BairroAtend to set
     */
    public void setBairroAtend(String BairroAtend) {
        this.BairroAtend = BairroAtend;
    }

    /**
     * @return the CidadeAtend
     */
    public String getCidadeAtend() {
        return CidadeAtend;
    }

    /**
     * @param CidadeAtend the CidadeAtend to set
     */
    public void setCidadeAtend(String CidadeAtend) {
        this.CidadeAtend = CidadeAtend;
    }

    /**
     * @return the EstadoAtend
     */
    public String getEstadoAtend() {
        return EstadoAtend;
    }

    /**
     * @param EstadoAtend the EstadoAtend to set
     */
    public void setEstadoAtend(String EstadoAtend) {
        this.EstadoAtend = EstadoAtend;
    }

    /**
     * @return the CartTrabAtend
     */
    public String getCartTrabAtend() {
        return CartTrabAtend;
    }

    /**
     * @param CartTrabAtend the CartTrabAtend to set
     */
    public void setCartTrabAtend(String CartTrabAtend) {
        this.CartTrabAtend = CartTrabAtend;
    }

    /**
     * @return the Periodo
     */
    public String getPeriodo() {
        return Periodo;
    }

    /**
     * @param Periodo the Periodo to set
     */
    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    /**
     * @return the RecebeRecluAtend
     */
    public String getRecebeRecluAtend() {
        return RecebeRecluAtend;
    }

    /**
     * @param RecebeRecluAtend the RecebeRecluAtend to set
     */
    public void setRecebeRecluAtend(String RecebeRecluAtend) {
        this.RecebeRecluAtend = RecebeRecluAtend;
    }

    /**
     * @return the DireitoAuxAtend
     */
    public String getDireitoAuxAtend() {
        return DireitoAuxAtend;
    }

    /**
     * @param DireitoAuxAtend the DireitoAuxAtend to set
     */
    public void setDireitoAuxAtend(String DireitoAuxAtend) {
        this.DireitoAuxAtend = DireitoAuxAtend;
    }

    /**
     * @return the RecebeBolAtend
     */
    public String getRecebeBolAtend() {
        return RecebeBolAtend;
    }

    /**
     * @param RecebeBolAtend the RecebeBolAtend to set
     */
    public void setRecebeBolAtend(String RecebeBolAtend) {
        this.RecebeBolAtend = RecebeBolAtend;
    }

    /**
     * @return the QtdPessoasAtend
     */
    public String getQtdPessoasAtend() {
        return QtdPessoasAtend;
    }

    /**
     * @param QtdPessoasAtend the QtdPessoasAtend to set
     */
    public void setQtdPessoasAtend(String QtdPessoasAtend) {
        this.QtdPessoasAtend = QtdPessoasAtend;
    }

    /**
     * @return the QtdTrabaAtend
     */
    public String getQtdTrabaAtend() {
        return QtdTrabaAtend;
    }

    /**
     * @param QtdTrabaAtend the QtdTrabaAtend to set
     */
    public void setQtdTrabaAtend(String QtdTrabaAtend) {
        this.QtdTrabaAtend = QtdTrabaAtend;
    }

    /**
     * @return the CN1Atend
     */
    public String getCN1Atend() {
        return CN1Atend;
    }

    /**
     * @param CN1Atend the CN1Atend to set
     */
    public void setCN1Atend(String CN1Atend) {
        this.CN1Atend = CN1Atend;
    }

    /**
     * @return the CN2Atend
     */
    public String getCN2Atend() {
        return CN2Atend;
    }

    /**
     * @param CN2Atend the CN2Atend to set
     */
    public void setCN2Atend(String CN2Atend) {
        this.CN2Atend = CN2Atend;
    }

    /**
     * @return the RG1Atend
     */
    public String getRG1Atend() {
        return RG1Atend;
    }

    /**
     * @param RG1Atend the RG1Atend to set
     */
    public void setRG1Atend(String RG1Atend) {
        this.RG1Atend = RG1Atend;
    }

    /**
     * @return the RG2atend
     */
    public String getRG2atend() {
        return RG2atend;
    }

    /**
     * @param RG2atend the RG2atend to set
     */
    public void setRG2atend(String RG2atend) {
        this.RG2atend = RG2atend;
    }

    /**
     * @return the CPF1Atend
     */
    public String getCPF1Atend() {
        return CPF1Atend;
    }

    /**
     * @param CPF1Atend the CPF1Atend to set
     */
    public void setCPF1Atend(String CPF1Atend) {
        this.CPF1Atend = CPF1Atend;
    }

    /**
     * @return the CPF2Atend
     */
    public String getCPF2Atend() {
        return CPF2Atend;
    }

    /**
     * @param CPF2Atend the CPF2Atend to set
     */
    public void setCPF2Atend(String CPF2Atend) {
        this.CPF2Atend = CPF2Atend;
    }

    /**
     * @return the CTPS1Atend
     */
    public String getCTPS1Atend() {
        return CTPS1Atend;
    }

    /**
     * @param CTPS1Atend the CTPS1Atend to set
     */
    public void setCTPS1Atend(String CTPS1Atend) {
        this.CTPS1Atend = CTPS1Atend;
    }

    /**
     * @return the CTPS2Atend
     */
    public String getCTPS2Atend() {
        return CTPS2Atend;
    }

    /**
     * @param CTPS2Atend the CTPS2Atend to set
     */
    public void setCTPS2Atend(String CTPS2Atend) {
        this.CTPS2Atend = CTPS2Atend;
    }

    /**
     * @return the municipioNascimento
     */
    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    /**
     * @param municipioNascimento the municipioNascimento to set
     */
    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    /**
     * @return the tituloEleito1
     */
    public String getTituloEleito1() {
        return tituloEleito1;
    }

    /**
     * @param tituloEleito1 the tituloEleito1 to set
     */
    public void setTituloEleito1(String tituloEleito1) {
        this.tituloEleito1 = tituloEleito1;
    }

    /**
     * @return the tituloEleitor2
     */
    public String getTituloEleitor2() {
        return tituloEleitor2;
    }

    /**
     * @param tituloEleitor2 the tituloEleitor2 to set
     */
    public void setTituloEleitor2(String tituloEleitor2) {
        this.tituloEleitor2 = tituloEleitor2;
    }

    /**
     * @return the reservista1
     */
    public String getReservista1() {
        return reservista1;
    }

    /**
     * @param reservista1 the reservista1 to set
     */
    public void setReservista1(String reservista1) {
        this.reservista1 = reservista1;
    }

    /**
     * @return the reservista2
     */
    public String getReservista2() {
        return reservista2;
    }

    /**
     * @param reservista2 the reservista2 to set
     */
    public void setReservista2(String reservista2) {
        this.reservista2 = reservista2;
    }

    /**
     * @return the cartorioRegistro
     */
    public String getCartorioRegistro() {
        return cartorioRegistro;
    }

    /**
     * @param cartorioRegistro the cartorioRegistro to set
     */
    public void setCartorioRegistro(String cartorioRegistro) {
        this.cartorioRegistro = cartorioRegistro;
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
     * @return the condicaoSegurado
     */
    public String getCondicaoSegurado() {
        return condicaoSegurado;
    }

    /**
     * @param condicaoSegurado the condicaoSegurado to set
     */
    public void setCondicaoSegurado(String condicaoSegurado) {
        this.condicaoSegurado = condicaoSegurado;
    }

    /**
     * @return the esposaCompanheira
     */
    public String getEsposaCompanheira() {
        return esposaCompanheira;
    }

    /**
     * @param esposaCompanheira the esposaCompanheira to set
     */
    public void setEsposaCompanheira(String esposaCompanheira) {
        this.esposaCompanheira = esposaCompanheira;
    }

    /**
     * @return the tempoConvivencia
     */
    public String getTempoConvivencia() {
        return tempoConvivencia;
    }

    /**
     * @param tempoConvivencia the tempoConvivencia to set
     */
    public void setTempoConvivencia(String tempoConvivencia) {
        this.tempoConvivencia = tempoConvivencia;
    }

    /**
     * @return the nomeEsposaConvivencia
     */
    public String getNomeEsposaConvivencia() {
        return nomeEsposaConvivencia;
    }

    /**
     * @param nomeEsposaConvivencia the nomeEsposaConvivencia to set
     */
    public void setNomeEsposaConvivencia(String nomeEsposaConvivencia) {
        this.nomeEsposaConvivencia = nomeEsposaConvivencia;
    }

    /**
     * @return the qtdPessoasResiCasa
     */
    public String getQtdPessoasResiCasa() {
        return qtdPessoasResiCasa;
    }

    /**
     * @param qtdPessoasResiCasa the qtdPessoasResiCasa to set
     */
    public void setQtdPessoasResiCasa(String qtdPessoasResiCasa) {
        this.qtdPessoasResiCasa = qtdPessoasResiCasa;
    }

    /**
     * @return the encaminhaOutrosSetore
     */
    public String getEncaminhaOutrosSetore() {
        return encaminhaOutrosSetore;
    }

    /**
     * @param encaminhaOutrosSetore the encaminhaOutrosSetore to set
     */
    public void setEncaminhaOutrosSetore(String encaminhaOutrosSetore) {
        this.encaminhaOutrosSetore = encaminhaOutrosSetore;
    }

    /**
     * @return the qualSetor
     */
    public String getQualSetor() {
        return qualSetor;
    }

    /**
     * @param qualSetor the qualSetor to set
     */
    public void setQualSetor(String qualSetor) {
        this.qualSetor = qualSetor;
    }

    /**
     * @return the cancelarVisita
     */
    public String getCancelarVisita() {
        return cancelarVisita;
    }

    /**
     * @param cancelarVisita the cancelarVisita to set
     */
    public void setCancelarVisita(String cancelarVisita) {
        this.cancelarVisita = cancelarVisita;
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
     * @return the encaminhaTirarDoc
     */
    public String getEncaminhaTirarDoc() {
        return encaminhaTirarDoc;
    }

    /**
     * @param encaminhaTirarDoc the encaminhaTirarDoc to set
     */
    public void setEncaminhaTirarDoc(String encaminhaTirarDoc) {
        this.encaminhaTirarDoc = encaminhaTirarDoc;
    }

    /**
     * @return the dataEncaminharTiraDoc
     */
    public Date getDataEncaminharTiraDoc() {
        return dataEncaminharTiraDoc;
    }

    /**
     * @param dataEncaminharTiraDoc the dataEncaminharTiraDoc to set
     */
    public void setDataEncaminharTiraDoc(Date dataEncaminharTiraDoc) {
        this.dataEncaminharTiraDoc = dataEncaminharTiraDoc;
    }

    /**
     * @return the encaminarReconhecerPaternidade
     */
    public String getEncaminarReconhecerPaternidade() {
        return encaminarReconhecerPaternidade;
    }

    /**
     * @param encaminarReconhecerPaternidade the encaminarReconhecerPaternidade to set
     */
    public void setEncaminarReconhecerPaternidade(String encaminarReconhecerPaternidade) {
        this.encaminarReconhecerPaternidade = encaminarReconhecerPaternidade;
    }

    /**
     * @return the dataEncaRecPaterna
     */
    public Date getDataEncaRecPaterna() {
        return dataEncaRecPaterna;
    }

    /**
     * @param dataEncaRecPaterna the dataEncaRecPaterna to set
     */
    public void setDataEncaRecPaterna(Date dataEncaRecPaterna) {
        this.dataEncaRecPaterna = dataEncaRecPaterna;
    }

    /**
     * @return the recebeVisita
     */
    public String getRecebeVisita() {
        return recebeVisita;
    }

    /**
     * @param recebeVisita the recebeVisita to set
     */
    public void setRecebeVisita(String recebeVisita) {
        this.recebeVisita = recebeVisita;
    }

    /**
     * @return the nomeConjuge
     */
    public String getNomeConjuge() {
        return nomeConjuge;
    }

    /**
     * @param nomeConjuge the nomeConjuge to set
     */
    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    /**
     * @return the PossuiFilhosAtend
     */
    public String getPossuiFilhosAtend() {
        return PossuiFilhosAtend;
    }

    /**
     * @param PossuiFilhosAtend the PossuiFilhosAtend to set
     */
    public void setPossuiFilhosAtend(String PossuiFilhosAtend) {
        this.PossuiFilhosAtend = PossuiFilhosAtend;
    }

    /**
     * @return the QtdFilhosAtend
     */
    public String getQtdFilhosAtend() {
        return QtdFilhosAtend;
    }

    /**
     * @param QtdFilhosAtend the QtdFilhosAtend to set
     */
    public void setQtdFilhosAtend(String QtdFilhosAtend) {
        this.QtdFilhosAtend = QtdFilhosAtend;
    }

    /**
     * @return the QtdFilhos2Atend
     */
    public String getQtdFilhos2Atend() {
        return QtdFilhos2Atend;
    }

    /**
     * @param QtdFilhos2Atend the QtdFilhos2Atend to set
     */
    public void setQtdFilhos2Atend(String QtdFilhos2Atend) {
        this.QtdFilhos2Atend = QtdFilhos2Atend;
    }

    /**
     * @return the FilhosNaoRegAtend
     */
    public String getFilhosNaoRegAtend() {
        return FilhosNaoRegAtend;
    }

    /**
     * @param FilhosNaoRegAtend the FilhosNaoRegAtend to set
     */
    public void setFilhosNaoRegAtend(String FilhosNaoRegAtend) {
        this.FilhosNaoRegAtend = FilhosNaoRegAtend;
    }

    /**
     * @return the OutrosFilhosAtend
     */
    public String getOutrosFilhosAtend() {
        return OutrosFilhosAtend;
    }

    /**
     * @param OutrosFilhosAtend the OutrosFilhosAtend to set
     */
    public void setOutrosFilhosAtend(String OutrosFilhosAtend) {
        this.OutrosFilhosAtend = OutrosFilhosAtend;
    }

    /**
     * @return the PaternidadeAtend
     */
    public String getPaternidadeAtend() {
        return PaternidadeAtend;
    }

    /**
     * @param PaternidadeAtend the PaternidadeAtend to set
     */
    public void setPaternidadeAtend(String PaternidadeAtend) {
        this.PaternidadeAtend = PaternidadeAtend;
    }

    /**
     * @return the DefensorAtend
     */
    public String getDefensorAtend() {
        return DefensorAtend;
    }

    /**
     * @param DefensorAtend the DefensorAtend to set
     */
    public void setDefensorAtend(String DefensorAtend) {
        this.DefensorAtend = DefensorAtend;
    }

    /**
     * @return the PartiFamiAtend
     */
    public String getPartiFamiAtend() {
        return PartiFamiAtend;
    }

    /**
     * @param PartiFamiAtend the PartiFamiAtend to set
     */
    public void setPartiFamiAtend(String PartiFamiAtend) {
        this.PartiFamiAtend = PartiFamiAtend;
    }

    /**
     * @return the ConsiderAtend
     */
    public String getConsiderAtend() {
        return ConsiderAtend;
    }

    /**
     * @param ConsiderAtend the ConsiderAtend to set
     */
    public void setConsiderAtend(String ConsiderAtend) {
        this.ConsiderAtend = ConsiderAtend;
    }

    /**
     * @return the deptoSocial
     */
    public String getDeptoSocial() {
        return deptoSocial;
    }

    /**
     * @param deptoSocial the deptoSocial to set
     */
    public void setDeptoSocial(String deptoSocial) {
        this.deptoSocial = deptoSocial;
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
}
