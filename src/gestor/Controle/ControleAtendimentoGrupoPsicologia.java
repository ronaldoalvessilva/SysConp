/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPsicologica;
import gestor.Modelo.AtividadesGrupoPsicologia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleAtendimentoGrupoPsicologia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesGrupoPsicologia objAvalia = new AtividadesGrupoPsicologia();

    int codigoPavilhao;
    int codigoCela;
    int codInterno;

    public AtividadesGrupoPsicologia incluirAtendimentoGrupoAba01Psi(AtividadesGrupoPsicologia objAvalia) {
        buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTO_GRUPO_PSICOLOGIA (StatusAtendGrupo,DataAtend,Responsavel,IdPav,IdCela,Ambiente,HoraioInicio,HorarioTermino,"
                    + "LocalAtividade,GrupoAtividade,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAvalia.getStatusAtendGrupo());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAtend().getTime()));
            pst.setString(3, objAvalia.getResponsavel());
            pst.setInt(4, codigoPavilhao);
            pst.setInt(5, codigoCela);
            pst.setString(6, objAvalia.getAmbiente());
            pst.setString(7, objAvalia.getHoraioInicio());
            pst.setString(8, objAvalia.getHorarioTermino());
            pst.setString(9, objAvalia.getLocalAtividade());
            pst.setString(10, objAvalia.getGrupoAtividade());
            pst.setString(11, objAvalia.getObservacao());
            pst.setString(12, objAvalia.getUsuarioInsert());
            pst.setString(13, objAvalia.getDataInsert());
            pst.setString(14, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoAba01Psi(AtividadesGrupoPsicologia objAvalia) {
       buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PSICOLOGIA SET StatusAtendGrupo=?,DataAtend=?,Responsavel=?,IdPav=?,IdCela=?,Ambiente=?,HoraioInicio=?,HorarioTermino=?,"
                    + "LocalAtividade=?,GrupoAtividade=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtGrupoPsi='" + objAvalia.getIdAtGrupoPsi() + "'");
            pst.setString(1, objAvalia.getStatusAtendGrupo());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAtend().getTime()));
            pst.setString(3, objAvalia.getResponsavel());
            pst.setInt(4, codigoPavilhao);
            pst.setInt(5, codigoCela);
            pst.setString(6, objAvalia.getAmbiente());
            pst.setString(7, objAvalia.getHoraioInicio());
            pst.setString(8, objAvalia.getHorarioTermino());
            pst.setString(9, objAvalia.getLocalAtividade());
            pst.setString(10, objAvalia.getGrupoAtividade());
            pst.setString(11, objAvalia.getObservacao());
            pst.setString(12, objAvalia.getUsuarioUp());
            pst.setString(13, objAvalia.getDataUp());
            pst.setString(14, objAvalia.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoAba01Psi(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTO_GRUPO_PSICOLOGIA WHERE IdAtGrupoPsi='" + objAvalia.getIdAtGrupoPsi() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    //----------------------------- PLANEJAMENTO -------------------------------------------//
    // ---------------------------- PARTICIPANTES -----------------------------------------//
    // ---------------------------- AVALIAÇÃO EM GRUPO ------------------------------------ //
    // ----------------------------- AVALIAÇÃO INDIVIDUAL ---------------------------------//
    // ----------------------------- FIM DOS MÉTODOS DE PERSISTENCIA ---------------------//
    public void buscarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void buscarCela(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELA "
                    + "WHERE EndCelaPav='" + desc + "'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
        conecta.desconecta();
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
        conecta.desconecta();
    }
}
