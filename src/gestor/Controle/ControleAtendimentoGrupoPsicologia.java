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

    public AtividadesGrupoPsicologia incluirAtendimentoGrupoManutencaoPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTO_GRUPO_PSICOLOGIA (StatusAtendGrupo,DataAtend,Responsavel,IdPav,Ambiente,HoraioInicio,HorarioTermino,"
                    + "LocalAtividade,GrupoAtividade,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAvalia.getStatusAtendGrupo());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAtend().getTime()));
            pst.setString(3, objAvalia.getResponsavel());
            pst.setInt(4, codigoPavilhao);
            pst.setString(5, objAvalia.getAmbiente());
            pst.setString(6, objAvalia.getHoraioInicio());
            pst.setString(7, objAvalia.getHorarioTermino());
            pst.setString(8, objAvalia.getLocalAtividade());
            pst.setString(9, objAvalia.getGrupoAtividade());
            pst.setString(10, objAvalia.getObservacao());
            pst.setString(11, objAvalia.getUsuarioInsert());
            pst.setString(12, objAvalia.getDataInsert());
            pst.setString(13, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoManutencaoPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PSICOLOGIA SET StatusAtendGrupo=?,DataAtend=?,Responsavel=?,IdPav=?,Ambiente=?,HoraioInicio=?,HorarioTermino=?,"
                    + "LocalAtividade=?,GrupoAtividade=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtGrupoPsi='" + objAvalia.getIdAtGrupoPsi() + "'");
            pst.setString(1, objAvalia.getStatusAtendGrupo());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAtend().getTime()));
            pst.setString(3, objAvalia.getResponsavel());
            pst.setInt(4, codigoPavilhao);
            pst.setString(5, objAvalia.getAmbiente());
            pst.setString(6, objAvalia.getHoraioInicio());
            pst.setString(7, objAvalia.getHorarioTermino());
            pst.setString(8, objAvalia.getLocalAtividade());
            pst.setString(9, objAvalia.getGrupoAtividade());
            pst.setString(10, objAvalia.getObservacao());
            pst.setString(11, objAvalia.getUsuarioUp());
            pst.setString(12, objAvalia.getDataUp());
            pst.setString(13, objAvalia.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoManutencaoPsi(AtividadesGrupoPsicologia objAvalia) {
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
    public AtividadesGrupoPsicologia incluirPlanejamentoPSI(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA (IdAtGrupoPsi,Tema,HoraInicio,HoraTermino,Turno,Atividades,Recursos,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setString(2, objAvalia.getTema());
            pst.setString(3, objAvalia.getHoraInicio());
            pst.setString(4, objAvalia.getHoraTermino());
            pst.setString(5, objAvalia.getTurno());
            pst.setString(6, objAvalia.getAtividades());
            pst.setString(7, objAvalia.getRecursos());
            pst.setString(8, objAvalia.getUsuarioInsert());
            pst.setString(9, objAvalia.getDataInsert());
            pst.setString(10, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarPlanejamentoPSI(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA SET IdAtGrupoPsi=?,Tema=?,HoraInicio=?,HoraTermino=?,Turno=?,Atividades=?,Recursos=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemPlan='" + objAvalia.getIdItemPlan() + "'");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setString(2, objAvalia.getTema());
            pst.setString(3, objAvalia.getHoraInicio());
            pst.setString(4, objAvalia.getHoraTermino());
            pst.setString(5, objAvalia.getTurno());
            pst.setString(6, objAvalia.getAtividades());
            pst.setString(7, objAvalia.getRecursos());
            pst.setString(8, objAvalia.getUsuarioUp());
            pst.setString(9, objAvalia.getDataUp());
            pst.setString(10, objAvalia.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirPlanejamentoPSI(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA WHERE IdItemPlan='" + objAvalia.getIdItemPlan() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ---------------------------- PARTICIPANTES -----------------------------------------//
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoParticipantesPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA (IdAtGrupoPsi,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setInt(2, codInterno);
            pst.setString(3, objAvalia.getUsuarioInsert());
            pst.setString(4, objAvalia.getDataInsert());
            pst.setString(5, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia incluirAGrupoPP(AtividadesGrupoPsicologia objAvalia) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA (IdAtGrupoPsi,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setInt(2, objAvalia.getIdInternoCrc());
            pst.setString(3, objAvalia.getUsuarioInsert());
            pst.setString(4, objAvalia.getDataInsert());
            pst.setString(5, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoParticipantesPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA SET IdAtGrupoPsi=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemPart='" + objAvalia.getIdItemPart() + "'");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setInt(2, codInterno);
            pst.setString(3, objAvalia.getUsuarioUp());
            pst.setString(4, objAvalia.getDataUp());
            pst.setString(5, objAvalia.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoParticipantesPsi(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA WHERE IdItemPart='" + objAvalia.getIdItemPart() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ---------------------------- AVALIAÇÃO EM GRUPO ------------------------------------ //
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoAVGPsi(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA (IdAtGrupoPsi,TextoAvalaiacaoGrupo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setString(2, objAvalia.getTextoAvalaiacaoGrupo());
            pst.setString(3, objAvalia.getUsuarioInsert());
            pst.setString(4, objAvalia.getDataInsert());
            pst.setString(5, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoAVGPsi(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA SET IdAtGrupoPsi=?,TextoAvalaiacaoGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemAvag='" + objAvalia.getIdItemAvag() + "'");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setString(2, objAvalia.getTextoAvalaiacaoGrupo());
            pst.setString(3, objAvalia.getUsuarioUp());
            pst.setString(4, objAvalia.getDataUp());
            pst.setString(5, objAvalia.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoAVGPsi(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA WHERE IdItemAvag='" + objAvalia.getIdItemAvag() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ----------------------------- AVALIAÇÃO INDIVIDUAL ---------------------------------//
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoAVGIPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA (IdAtGrupoPsi,IdInternoCrc,TextoAvalaiacaoInd,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setInt(2, codInterno);
            pst.setString(3, objAvalia.getTextoAvalaiacaoInd());
            pst.setString(4, objAvalia.getUsuarioInsert());
            pst.setString(5, objAvalia.getDataInsert());
            pst.setString(6, objAvalia.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoAVGIPsi(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA SET IdAtGrupoPsi=?,IdInternoCrc=?,TextoAvalaiacaoInd=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemAvai='" + objAvalia.getIdItemAvai() + "'");
            pst.setInt(1, objAvalia.getIdAtGrupoPsi());
            pst.setInt(2, codInterno);
            pst.setString(3, objAvalia.getTextoAvalaiacaoInd());
            pst.setString(4, objAvalia.getUsuarioInsert());
            pst.setString(5, objAvalia.getDataInsert());
            pst.setString(6, objAvalia.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoAVGIPsi(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA WHERE IdItemAvai='" + objAvalia.getIdItemAvai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

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
