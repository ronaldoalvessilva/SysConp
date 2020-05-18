/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEvolucaoEducacaoFisica;
import static gestor.Visao.TelaAdmissaoEvolucoEF.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class listarTodosRegistros {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEvolucaoEducacaoFisica objAdmissao = new AdmissaoEvolucaoEducacaoFisica();

    public List<AdmissaoEvolucaoEducacaoFisica> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<AdmissaoEvolucaoEducacaoFisica> listaTodasAdmissao = new ArrayList<AdmissaoEvolucaoEducacaoFisica>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_EDUCACAO_FISICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
            while (conecta.rs.next()) {
                AdmissaoEvolucaoEducacaoFisica pAdmissao = new AdmissaoEvolucaoEducacaoFisica();
                pAdmissao.setIdRegistroEF(conecta.rs.getInt("IdRegistroEF"));
                pAdmissao.setStatusEF(conecta.rs.getString("StatusEF"));
                pAdmissao.setDataRegistroEF(conecta.rs.getDate("DataRegistroEF"));
                pAdmissao.setIdInternoEF(conecta.rs.getInt("IdInternoCrc"));
                pAdmissao.setNomeInternoEF(conecta.rs.getString("NomeInternoCrc"));
                pAdmissao.setMatriculaEF(conecta.rs.getString("MatriculaCrc"));
                pAdmissao.setDataNascimentoEF(conecta.rs.getDate("DataNasciCrc"));
                pAdmissao.setCaminhoFoto(conecta.rs.getString("FotoInternoCrc"));
                pAdmissao.setImagemBanco(conecta.rs.getBytes("ImagemFrente"));
                pAdmissao.setAtividadeFisica(conecta.rs.getString("AtividadeFisica"));
                pAdmissao.setFrequenciaSemanal(conecta.rs.getString("FrequenciaSemanal"));
                pAdmissao.setNivelCondicionamento(conecta.rs.getString("NivelCondicionamento"));
                pAdmissao.setRestricaoAtividadeFisica(conecta.rs.getString("AtividadeFisica"));
                pAdmissao.setQualRestricaoFisica(conecta.rs.getString("QualRestricaoFisica"));
                pAdmissao.setProblemaCardiaco(conecta.rs.getString("ProblemaCardiaco"));
                pAdmissao.setQualProblemaCardiaco(conecta.rs.getString("QualProblemaCardiaco"));
                pAdmissao.setAlgumTipoCirurgia(conecta.rs.getString("AlgumTipoCirurgia"));
                pAdmissao.setEspecificarCirurgia(conecta.rs.getString("EspecificarCirurgia"));
                pAdmissao.setProblemaOrtopedico(conecta.rs.getString("ProblemaOrtopedico"));
                pAdmissao.setHabitoFumar(conecta.rs.getString("HabitoFumar"));
                pAdmissao.setQuantosCigarros(conecta.rs.getInt("QuantosCigarros"));
                pAdmissao.setAlgumMedicamento(conecta.rs.getString("AlgumMedicamento"));
                pAdmissao.setEspecificarMedicamento(conecta.rs.getString("EspecificarMedicamento"));
                pAdmissao.setDiabetico(conecta.rs.getString("Diabetico"));
                pAdmissao.setPressaoSanguinea(conecta.rs.getString("PressaoSanguinea"));
                pAdmissao.setDoresPeito(conecta.rs.getString("DoresPeito"));
                pAdmissao.setDesmaio(conecta.rs.getString("Desmaio"));
                pAdmissao.setTextoEvolucaoAdmissao(conecta.rs.getString("TextoEvolucaoAdmissao"));
                pAdmissao.setUsuarioInsert(conecta.rs.getString("UsuarioInsert"));
                pAdmissao.setDataInsert(conecta.rs.getString("DataInsert"));
                pAdmissao.setHorarioInsert(conecta.rs.getString("HorarioInsert"));
                listaTodasAdmissao.add(pAdmissao);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaTodasAdmissao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleAdmissaoEvolucaoEF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
