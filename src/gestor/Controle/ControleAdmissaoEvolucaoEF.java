/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEvolucaoEducacaoFisica;
import static gestor.Visao.TelaAdmissaoEvolucoEF.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAdmissaoEvolucaoEF {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEvolucaoEducacaoFisica objAdmissao = new AdmissaoEvolucaoEducacaoFisica();

    int codInterno = 0;

    //ABA MANUTENÇÃO
    public AdmissaoEvolucaoEducacaoFisica incluirAdmissaoEF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_EDUCACAO_FISICA (StatusEF,"
                    + "DataRegistroEF,IdInternoCrc,PesoEF,AlturaEF,AtividadeFisica,FrequenciaSemanal,NivelCondicionamento,"
                    + "RestricaoAtividadeFisica,QualRestricaoFisica,ProblemaCardiaco,QualProblemaCardiaco,AlgumTipoCirurgia,"
                    + "EspecificarCirurgia,ProblemaOrtopedico,HabitoFumar,QuantosCigarros,AlgumMedicamento,EspecificarMedicamento,"
                    + "Diabetico,PressaoSanguinea,DoresPeito,Desmaio,TextoEvolucaoAdmissao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAdmissao.getStatusEF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmissao.getDataRegistroEF().getTime()));
            pst.setInt(3, codInterno);
            pst.setFloat(4, objAdmissao.getPesoEF());
            pst.setFloat(5, objAdmissao.getAlturaEF());
            pst.setString(6, objAdmissao.getAtividadeFisica());
            pst.setString(7, objAdmissao.getFrequenciaSemanal());
            pst.setString(8, objAdmissao.getNivelCondicionamento());
            pst.setString(9, objAdmissao.getRestricaoAtividadeFisica());
            pst.setString(10, objAdmissao.getQualRestricaoFisica());
            pst.setString(11, objAdmissao.getProblemaCardiaco());
            pst.setString(12, objAdmissao.getQualProblemaCardiaco());
            pst.setString(13, objAdmissao.getAlgumTipoCirurgia());
            pst.setString(14, objAdmissao.getEspecificarCirurgia());
            pst.setString(15, objAdmissao.getProblemaOrtopedico());
            pst.setString(16, objAdmissao.getHabitoFumar());
            pst.setInt(17, objAdmissao.getQuantosCigarros());
            pst.setString(18, objAdmissao.getAlgumMedicamento());
            pst.setString(19, objAdmissao.getEspecificarMedicamento());
            pst.setString(20, objAdmissao.getDiabetico());
            pst.setString(21, objAdmissao.getPressaoSanguinea());
            pst.setString(22, objAdmissao.getDoresPeito());
            pst.setString(23, objAdmissao.getDesmaio());
            pst.setString(24, objAdmissao.getTextoEvolucaoAdmissao());
            pst.setString(25, objAdmissao.getUsuarioInsert());
            pst.setString(26, objAdmissao.getDataInsert());
            pst.setString(27, objAdmissao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public AdmissaoEvolucaoEducacaoFisica alterarAdmissaoEF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_EDUCACAO_FISICA SET StatusEF=?,"
                    + "DataRegistroEF=?,IdInternoCrc=?,PesoEF=?,AlturaEF=?,AtividadeFisica=?,FrequenciaSemanal=?,NivelCondicionamento=?,"
                    + "RestricaoAtividadeFisica=?,QualRestricaoFisica=?,ProblemaCardiaco=?,QualProblemaCardiaco=?,AlgumTipoCirurgia=?,"
                    + "EspecificarCirurgia=?,ProblemaOrtopedico=?,HabitoFumar=?,QuantosCigarros=?,AlgumMedicamento=?,EspecificarMedicamento=?,"
                    + "Diabetico=?,PressaoSanguinea=?,DoresPeito=?,Desmaio=?,TextoEvolucaoAdmissao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroEF='" + objAdmissao.getIdRegistroEF() + "'");
            pst.setString(1, objAdmissao.getStatusEF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmissao.getDataRegistroEF().getTime()));
            pst.setInt(3, codInterno);
            pst.setFloat(4, objAdmissao.getPesoEF());
            pst.setFloat(5, objAdmissao.getAlturaEF());
            pst.setString(6, objAdmissao.getAtividadeFisica());
            pst.setString(7, objAdmissao.getFrequenciaSemanal());
            pst.setString(8, objAdmissao.getNivelCondicionamento());
            pst.setString(9, objAdmissao.getRestricaoAtividadeFisica());
            pst.setString(10, objAdmissao.getQualRestricaoFisica());
            pst.setString(11, objAdmissao.getProblemaCardiaco());
            pst.setString(12, objAdmissao.getQualProblemaCardiaco());
            pst.setString(13, objAdmissao.getAlgumTipoCirurgia());
            pst.setString(14, objAdmissao.getEspecificarCirurgia());
            pst.setString(15, objAdmissao.getProblemaOrtopedico());
            pst.setString(16, objAdmissao.getHabitoFumar());
            pst.setInt(17, objAdmissao.getQuantosCigarros());
            pst.setString(18, objAdmissao.getAlgumMedicamento());
            pst.setString(19, objAdmissao.getEspecificarMedicamento());
            pst.setString(20, objAdmissao.getDiabetico());
            pst.setString(21, objAdmissao.getPressaoSanguinea());
            pst.setString(22, objAdmissao.getDoresPeito());
            pst.setString(23, objAdmissao.getDesmaio());
            pst.setString(24, objAdmissao.getTextoEvolucaoAdmissao());
            pst.setString(25, objAdmissao.getUsuarioUp());
            pst.setString(26, objAdmissao.getDataUp());
            pst.setString(27, objAdmissao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public AdmissaoEvolucaoEducacaoFisica excluirAdmissaoEF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_EDUCACAO_FISICA  WHERE IdRegistroEF='" + objAdmissao.getIdRegistroEF() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }

    public List<AdmissaoEvolucaoEducacaoFisica> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<AdmissaoEvolucaoEducacaoFisica> listaTodasAdmissao = new ArrayList<AdmissaoEvolucaoEducacaoFisica>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdAtividade,StatusAtividade,"
                    + "DataCriacao,Populacao, "
                    + "MesReferencia,AnoReferencia, "
                    + "DescricaoUnidade "
                    + "FROM ATIVIDADES_UNIDADE "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON ATIVIDADES_UNIDADE.IdUnidEmp=UNIDADE_PENAL_EMPRESA.IdUnidEmp");
            while (conecta.rs.next()) {
                AdmissaoEvolucaoEducacaoFisica pAdmissao = new AdmissaoEvolucaoEducacaoFisica();
                pAdmissao.setIdRegistroEF(conecta.rs.getInt("IdRegistroEF"));
                pAdmissao.setStatusEF(conecta.rs.getString("StatusEF"));
                pAdmissao.setDataRegistroEF(conecta.rs.getDate("DataRegistroEF"));
                pAdmissao.setIdInternoEF(conecta.rs.getInt("IdInternoCrc"));
                pAdmissao.setNomeInternoEF(conecta.rs.getString("NomeInternoCrc"));
                pAdmissao.setMatriculaEF(conecta.rs.getString("MatriculaCrc"));
                pAdmissao.setDataNascimentoEF(conecta.rs.getDate("DataNascCrc"));
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
