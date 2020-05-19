/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEvolucaoEducacaoFisica;
import static gestor.Visao.TelaAdmissaoEF_SECUNDARIA.jID_REGISTRO_Pesquisa;
import static gestor.Visao.TelaAdmissaoEF_SECUNDARIA.pTOTAL_REGISTROS_ATIVIDADES;
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
public class ControleAdmissaoEvolucaoEF_NOVA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEvolucaoEducacaoFisica objAdmissao = new AdmissaoEvolucaoEducacaoFisica();

    int codInterno = 0;

    //ABA MANUTENÇÃO
    public AdmissaoEvolucaoEducacaoFisica incluirAdmissaoEF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_EDUCACAO_FISICA_NOVA (IdRegistroEF,StatusEF,"
                    + "DataRegistroEF,IdInternoCrc,PesoEF,AlturaEF,AtividadeFisica,FrequenciaSemanal,NivelCondicionamento,"
                    + "RestricaoAtividadeFisica,QualRestricaoFisica,ProblemaCardiaco,QualProblemaCardiaco,AlgumTipoCirurgia,"
                    + "EspecificarCirurgia,ProblemaOrtopedico,HabitoFumar,QuantosCigarros,AlgumMedicamento,EspecificarMedicamento,"
                    + "Diabetico,PressaoSanguinea,DoresPeito,Desmaio,TextoEvolucaoAdmissao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmissao.getIdRegistroEF());
            pst.setString(2, objAdmissao.getStatusEF());
            pst.setTimestamp(3, new java.sql.Timestamp(objAdmissao.getDataRegistroEF().getTime()));
            pst.setInt(4, codInterno);
            pst.setFloat(5, objAdmissao.getPesoEF());
            pst.setFloat(6, objAdmissao.getAlturaEF());
            pst.setString(7, objAdmissao.getAtividadeFisica());
            pst.setString(8, objAdmissao.getFrequenciaSemanal());
            pst.setString(9, objAdmissao.getNivelCondicionamento());
            pst.setString(10, objAdmissao.getRestricaoAtividadeFisica());
            pst.setString(11, objAdmissao.getQualRestricaoFisica());
            pst.setString(12, objAdmissao.getProblemaCardiaco());
            pst.setString(13, objAdmissao.getQualProblemaCardiaco());
            pst.setString(14, objAdmissao.getAlgumTipoCirurgia());
            pst.setString(15, objAdmissao.getEspecificarCirurgia());
            pst.setString(16, objAdmissao.getProblemaOrtopedico());
            pst.setString(17, objAdmissao.getHabitoFumar());
            pst.setInt(18, objAdmissao.getQuantosCigarros());
            pst.setString(19, objAdmissao.getAlgumMedicamento());
            pst.setString(20, objAdmissao.getEspecificarMedicamento());
            pst.setString(21, objAdmissao.getDiabetico());
            pst.setString(22, objAdmissao.getPressaoSanguinea());
            pst.setString(23, objAdmissao.getDoresPeito());
            pst.setString(24, objAdmissao.getDesmaio());
            pst.setString(25, objAdmissao.getTextoEvolucaoAdmissao());
            pst.setString(26, objAdmissao.getUsuarioInsert());
            pst.setString(27, objAdmissao.getDataInsert());
            pst.setString(28, objAdmissao.getHorarioInsert());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_EDUCACAO_FISICA_NOVA SET StatusEF=?,"
                    + "DataRegistroEF=?,IdInternoCrc=?,PesoEF=?,AlturaEF=?,AtividadeFisica=?,FrequenciaSemanal=?,NivelCondicionamento=?,"
                    + "RestricaoAtividadeFisica=?,QualRestricaoFisica=?,ProblemaCardiaco=?,QualProblemaCardiaco=?,AlgumTipoCirurgia=?,"
                    + "EspecificarCirurgia=?,ProblemaOrtopedico=?,HabitoFumar=?,QuantosCigarros=?,AlgumMedicamento=?,EspecificarMedicamento=?,"
                    + "Diabetico=?,PressaoSanguinea=?,DoresPeito=?,Desmaio=?,TextoEvolucaoAdmissao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroEF_NOVA='" + objAdmissao.getIdRegistroEF_NOVA() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_EDUCACAO_FISICA_NOVA  WHERE IdRegistroEF_NOVA='" + objAdmissao.getIdRegistroEF_NOVA() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }
    
    public AdmissaoEvolucaoEducacaoFisica finalizarAdmissaoEF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_EDUCACAO_FISICA_NOVA SET StatusEF=? WHERE IdRegistroEF_NOVA='" + objAdmissao.getIdRegistroEF_NOVA() + "'");
            pst.setString(1, objAdmissao.getStatusEF()); 
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    // EVOLUÇÃO EDUCAÇÃO FÍSICA
    public AdmissaoEvolucaoEducacaoFisica incluir_EVOLUCAO_EF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAO_EDUCACAO_FISICA (IdRegistroEF,"
                    + "DataEvolucaoEF,IdInternoCrc,TextoEvolucaoEF,AdmEvo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmissao.getIdRegistroEF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmissao.getDataEvolucaoEF().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAdmissao.getTextoEvolucaoEF());
            pst.setString(5, objAdmissao.getAdmEvo());
            pst.setString(6, objAdmissao.getUsuarioInsert());
            pst.setString(7, objAdmissao.getDataInsert());
            pst.setString(8, objAdmissao.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (EVOLUCAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public AdmissaoEvolucaoEducacaoFisica alterar_EVOLUCAO_EF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_EDUCACAO_FISICA SET IdRegistroEF=?,"
                    + "DataEvolucaoEF=?,IdInternoCrc=?,TextoEvolucaoEF=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objAdmissao.getIdItem() + "'");
            pst.setInt(1, objAdmissao.getIdRegistroEF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmissao.getDataEvolucaoEF().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAdmissao.getTextoEvolucaoEF());
            pst.setString(5, objAdmissao.getUsuarioInsert());
            pst.setString(6, objAdmissao.getDataUp());
            pst.setString(7, objAdmissao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (EVOLUCAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public AdmissaoEvolucaoEducacaoFisica excluir_EVOLUCAO_EF(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAO_EDUCACAO_FISICA WHERE IdItem='" + objAdmissao.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (EVOLUCAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmissao;
    }

    public AdmissaoEvolucaoEducacaoFisica alterar_EVOLUCAO_EF_ADM(AdmissaoEvolucaoEducacaoFisica objAdmissao) {
        buscarInterno(objAdmissao.getNomeInternoEF(), objAdmissao.getIdInternoEF());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_EDUCACAO_FISICA SET TextoEvolucaoEF=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroEF='" + objAdmissao.getIdRegistroEF() + "'AND AdmEvo='" + objAdmissao.getAdmEvo() + "'");         
            pst.setString(1, objAdmissao.getTextoEvolucaoEF());
            pst.setString(2, objAdmissao.getUsuarioInsert());
            pst.setString(3, objAdmissao.getDataUp());
            pst.setString(4, objAdmissao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (EVOLUCAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
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
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_EDUCACAO_FISICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ADMISSAO_EDUCACAO_FISICA.IdRegistroEF='" + jID_REGISTRO_Pesquisa.getText() + "'");
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
                pAdmissao.setPesoEF(conecta.rs.getFloat("PesoEF"));
                pAdmissao.setAlturaEF(conecta.rs.getFloat("AlturaEF"));
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
            Logger.getLogger(ControleAdmissaoEvolucaoEF_NOVA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
