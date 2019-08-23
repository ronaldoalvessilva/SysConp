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
public class AtendimentoFamiliar {

    private int IdAtendf;
    private String statusAtend;
    private int IdVisita;
    private int IdInternoCrc;
    private String nomeVisita;
    private String nomeInterno;
    private Date DataAtendf;
    private String Pergunta1Atendf;
    private String Pergunta2Atendf;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;
    private String companheiroUnidade;
    private String visitaInternoUnidade;
    private String creasCreas;
    private String bolsaFamilia;
    private String reconhecerPaternidade;
    private String auxilioReclusao;
    private String outroBerneficio;
    private String possuiFilhos;
    private int quantidadeFilhos;
    private String qualIdade;
    private String estudam;
    private String tipoEscola;
    private String participaProjeto;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone1;
    private String telefone2;
    private String celular;
    private String trabalha;
    private String escolaridade;
    private String problemaSaude;
    private String quaisProblemaSaude;
    private String usoMedicacao;
    private String quaisMedicacoes;
    private String doencaPermanente;
    private String quaisDoencas;
    private int idEvolucao;
    private Date dataEvolucao;
    private String textoEvolucao;

    public AtendimentoFamiliar() {
    }

    public AtendimentoFamiliar(int IdAtendf, String statusAtend, int IdVisita, int IdInternoCrc, String nomeVisita, String nomeInterno, Date DataAtendf, String Pergunta1Atendf, String Pergunta2Atendf, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String companheiroUnidade, String visitaInternoUnidade, String creasCreas, String bolsaFamilia, String reconhecerPaternidade, String auxilioReclusao, String outroBerneficio, String possuiFilhos, int quantidadeFilhos, String qualIdade, String estudam, String tipoEscola, String participaProjeto, String endereco, String cidade, String estado, String telefone1, String telefone2, String celular, String trabalha, String escolaridade, String problemaSaude, String quaisProblemaSaude, String usoMedicacao, String quaisMedicacoes, String doencaPermanente, String quaisDoencas, int idEvolucao, Date dataEvolucao, String textoEvolucao) {
        this.IdAtendf = IdAtendf;
        this.statusAtend = statusAtend;
        this.IdVisita = IdVisita;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeVisita = nomeVisita;
        this.nomeInterno = nomeInterno;
        this.DataAtendf = DataAtendf;
        this.Pergunta1Atendf = Pergunta1Atendf;
        this.Pergunta2Atendf = Pergunta2Atendf;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.companheiroUnidade = companheiroUnidade;
        this.visitaInternoUnidade = visitaInternoUnidade;
        this.creasCreas = creasCreas;
        this.bolsaFamilia = bolsaFamilia;
        this.reconhecerPaternidade = reconhecerPaternidade;
        this.auxilioReclusao = auxilioReclusao;
        this.outroBerneficio = outroBerneficio;
        this.possuiFilhos = possuiFilhos;
        this.quantidadeFilhos = quantidadeFilhos;
        this.qualIdade = qualIdade;
        this.estudam = estudam;
        this.tipoEscola = tipoEscola;
        this.participaProjeto = participaProjeto;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.celular = celular;
        this.trabalha = trabalha;
        this.escolaridade = escolaridade;
        this.problemaSaude = problemaSaude;
        this.quaisProblemaSaude = quaisProblemaSaude;
        this.usoMedicacao = usoMedicacao;
        this.quaisMedicacoes = quaisMedicacoes;
        this.doencaPermanente = doencaPermanente;
        this.quaisDoencas = quaisDoencas;
        this.idEvolucao = idEvolucao;
        this.dataEvolucao = dataEvolucao;
        this.textoEvolucao = textoEvolucao;
    }

    /**
     * @return the IdAtendf
     */
    public int getIdAtendf() {
        return IdAtendf;
    }

    /**
     * @param IdAtendf the IdAtendf to set
     */
    public void setIdAtendf(int IdAtendf) {
        this.IdAtendf = IdAtendf;
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
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
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
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
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
     * @return the DataAtendf
     */
    public Date getDataAtendf() {
        return DataAtendf;
    }

    /**
     * @param DataAtendf the DataAtendf to set
     */
    public void setDataAtendf(Date DataAtendf) {
        this.DataAtendf = DataAtendf;
    }

    /**
     * @return the Pergunta1Atendf
     */
    public String getPergunta1Atendf() {
        return Pergunta1Atendf;
    }

    /**
     * @param Pergunta1Atendf the Pergunta1Atendf to set
     */
    public void setPergunta1Atendf(String Pergunta1Atendf) {
        this.Pergunta1Atendf = Pergunta1Atendf;
    }

    /**
     * @return the Pergunta2Atendf
     */
    public String getPergunta2Atendf() {
        return Pergunta2Atendf;
    }

    /**
     * @param Pergunta2Atendf the Pergunta2Atendf to set
     */
    public void setPergunta2Atendf(String Pergunta2Atendf) {
        this.Pergunta2Atendf = Pergunta2Atendf;
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
     * @return the companheiroUnidade
     */
    public String getCompanheiroUnidade() {
        return companheiroUnidade;
    }

    /**
     * @param companheiroUnidade the companheiroUnidade to set
     */
    public void setCompanheiroUnidade(String companheiroUnidade) {
        this.companheiroUnidade = companheiroUnidade;
    }

    /**
     * @return the visitaInternoUnidade
     */
    public String getVisitaInternoUnidade() {
        return visitaInternoUnidade;
    }

    /**
     * @param visitaInternoUnidade the visitaInternoUnidade to set
     */
    public void setVisitaInternoUnidade(String visitaInternoUnidade) {
        this.visitaInternoUnidade = visitaInternoUnidade;
    }

    /**
     * @return the creasCreas
     */
    public String getCreasCreas() {
        return creasCreas;
    }

    /**
     * @param creasCreas the creasCreas to set
     */
    public void setCreasCreas(String creasCreas) {
        this.creasCreas = creasCreas;
    }

    /**
     * @return the bolsaFamilia
     */
    public String getBolsaFamilia() {
        return bolsaFamilia;
    }

    /**
     * @param bolsaFamilia the bolsaFamilia to set
     */
    public void setBolsaFamilia(String bolsaFamilia) {
        this.bolsaFamilia = bolsaFamilia;
    }

    /**
     * @return the reconhecerPaternidade
     */
    public String getReconhecerPaternidade() {
        return reconhecerPaternidade;
    }

    /**
     * @param reconhecerPaternidade the reconhecerPaternidade to set
     */
    public void setReconhecerPaternidade(String reconhecerPaternidade) {
        this.reconhecerPaternidade = reconhecerPaternidade;
    }

    /**
     * @return the auxilioReclusao
     */
    public String getAuxilioReclusao() {
        return auxilioReclusao;
    }

    /**
     * @param auxilioReclusao the auxilioReclusao to set
     */
    public void setAuxilioReclusao(String auxilioReclusao) {
        this.auxilioReclusao = auxilioReclusao;
    }

    /**
     * @return the outroBerneficio
     */
    public String getOutroBerneficio() {
        return outroBerneficio;
    }

    /**
     * @param outroBerneficio the outroBerneficio to set
     */
    public void setOutroBerneficio(String outroBerneficio) {
        this.outroBerneficio = outroBerneficio;
    }

    /**
     * @return the possuiFilhos
     */
    public String getPossuiFilhos() {
        return possuiFilhos;
    }

    /**
     * @param possuiFilhos the possuiFilhos to set
     */
    public void setPossuiFilhos(String possuiFilhos) {
        this.possuiFilhos = possuiFilhos;
    }

    /**
     * @return the quantidadeFilhos
     */
    public int getQuantidadeFilhos() {
        return quantidadeFilhos;
    }

    /**
     * @param quantidadeFilhos the quantidadeFilhos to set
     */
    public void setQuantidadeFilhos(int quantidadeFilhos) {
        this.quantidadeFilhos = quantidadeFilhos;
    }

    /**
     * @return the qualIdade
     */
    public String getQualIdade() {
        return qualIdade;
    }

    /**
     * @param qualIdade the qualIdade to set
     */
    public void setQualIdade(String qualIdade) {
        this.qualIdade = qualIdade;
    }

    /**
     * @return the estudam
     */
    public String getEstudam() {
        return estudam;
    }

    /**
     * @param estudam the estudam to set
     */
    public void setEstudam(String estudam) {
        this.estudam = estudam;
    }

    /**
     * @return the tipoEscola
     */
    public String getTipoEscola() {
        return tipoEscola;
    }

    /**
     * @param tipoEscola the tipoEscola to set
     */
    public void setTipoEscola(String tipoEscola) {
        this.tipoEscola = tipoEscola;
    }

    /**
     * @return the participaProjeto
     */
    public String getParticipaProjeto() {
        return participaProjeto;
    }

    /**
     * @param participaProjeto the participaProjeto to set
     */
    public void setParticipaProjeto(String participaProjeto) {
        this.participaProjeto = participaProjeto;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * @param telefone2 the telefone2 to set
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the trabalha
     */
    public String getTrabalha() {
        return trabalha;
    }

    /**
     * @param trabalha the trabalha to set
     */
    public void setTrabalha(String trabalha) {
        this.trabalha = trabalha;
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
     * @return the problemaSaude
     */
    public String getProblemaSaude() {
        return problemaSaude;
    }

    /**
     * @param problemaSaude the problemaSaude to set
     */
    public void setProblemaSaude(String problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    /**
     * @return the quaisProblemaSaude
     */
    public String getQuaisProblemaSaude() {
        return quaisProblemaSaude;
    }

    /**
     * @param quaisProblemaSaude the quaisProblemaSaude to set
     */
    public void setQuaisProblemaSaude(String quaisProblemaSaude) {
        this.quaisProblemaSaude = quaisProblemaSaude;
    }

    /**
     * @return the usoMedicacao
     */
    public String getUsoMedicacao() {
        return usoMedicacao;
    }

    /**
     * @param usoMedicacao the usoMedicacao to set
     */
    public void setUsoMedicacao(String usoMedicacao) {
        this.usoMedicacao = usoMedicacao;
    }

    /**
     * @return the quaisMedicacoes
     */
    public String getQuaisMedicacoes() {
        return quaisMedicacoes;
    }

    /**
     * @param quaisMedicacoes the quaisMedicacoes to set
     */
    public void setQuaisMedicacoes(String quaisMedicacoes) {
        this.quaisMedicacoes = quaisMedicacoes;
    }

    /**
     * @return the doencaPermanente
     */
    public String getDoencaPermanente() {
        return doencaPermanente;
    }

    /**
     * @param doencaPermanente the doencaPermanente to set
     */
    public void setDoencaPermanente(String doencaPermanente) {
        this.doencaPermanente = doencaPermanente;
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
     * @return the idEvolucao
     */
    public int getIdEvolucao() {
        return idEvolucao;
    }

    /**
     * @param idEvolucao the idEvolucao to set
     */
    public void setIdEvolucao(int idEvolucao) {
        this.idEvolucao = idEvolucao;
    }

    /**
     * @return the dataEvolucao
     */
    public Date getDataEvolucao() {
        return dataEvolucao;
    }

    /**
     * @param dataEvolucao the dataEvolucao to set
     */
    public void setDataEvolucao(Date dataEvolucao) {
        this.dataEvolucao = dataEvolucao;
    }

    /**
     * @return the textoEvolucao
     */
    public String getTextoEvolucao() {
        return textoEvolucao;
    }

    /**
     * @param textoEvolucao the textoEvolucao to set
     */
    public void setTextoEvolucao(String textoEvolucao) {
        this.textoEvolucao = textoEvolucao;
    }
}
