/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesGrupoPsicologia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleAtendimentoGrupoEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesGrupoPsicologia objAvalia = new AtividadesGrupoPsicologia();

    int codigoPavilhao;
    int codigoCela;
    int codInterno;

    public AtividadesGrupoPsicologia incluirAtendimentoGrupoManutencaoENF(AtividadesGrupoPsicologia objAvalia) {
        buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTO_GRUPO_ENFERMAGEM (StatusAtendGrupo,DataAtend,Responsavel,IdPav,Ambiente,HoraioInicio,HorarioTermino,"
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

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoManutencaoENF(AtividadesGrupoPsicologia objAvalia) {
        buscarPavilhao(objAvalia.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_ENFERMAGEM SET StatusAtendGrupo=?,DataAtend=?,Responsavel=?,IdPav=?,Ambiente=?,HoraioInicio=?,HorarioTermino=?,"
                    + "LocalAtividade=?,GrupoAtividade=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtGrupoEnf='" + objAvalia.getIdAtGrupoPsi() + "'");
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

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoManutencaoENF(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTO_GRUPO_ENFERMAGEM WHERE IdAtGrupoEnf='" + objAvalia.getIdAtGrupoPsi() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    //----------------------------- PLANEJAMENTO -------------------------------------------//
    public AtividadesGrupoPsicologia incluirPlanejamentoENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM (IdAtGrupoEnf,Tema,HoraInicio,HoraTermino,Turno,Atividades,Recursos,"
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

    public AtividadesGrupoPsicologia alterarPlanejamentoENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM SET IdAtGrupoEnf=?,Tema=?,HoraInicio=?,HoraTermino=?,Turno=?,Atividades=?,Recursos=?,"
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

    public AtividadesGrupoPsicologia excluirPlanejamentoENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM WHERE IdItemPlanEnf='" + objAvalia.getIdItemPlan() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ---------------------------- PARTICIPANTES -----------------------------------------//
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoParticipantesENF(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM (IdAtGrupoEnf,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
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

    public AtividadesGrupoPsicologia incluirAGrupoENF(AtividadesGrupoPsicologia objAvalia) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM (IdAtGrupoEnf,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
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

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoParticipantesENF(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM SET IdAtGrupoEnf=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemPart='" + objAvalia.getIdItemPart() + "'");
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

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoParticipantesENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM WHERE IdItemPartEnf='" + objAvalia.getIdItemPart() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ---------------------------- AVALIAÇÃO EM GRUPO ------------------------------------ //
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoAVGENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM (IdAtGrupoEnf,TextoAvalaiacaoGrupo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
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

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoAVGENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM SET IdAtGrupoEnf=?,TextoAvalaiacaoGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemAvag='" + objAvalia.getIdItemAvag() + "'");
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

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoAVGENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM WHERE IdItemAvagEnf='" + objAvalia.getIdItemAvag() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    // ----------------------------- AVALIAÇÃO INDIVIDUAL ---------------------------------//
    public AtividadesGrupoPsicologia incluirAtendimentoGrupoAVGIENF(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM (IdAtGrupoEnf,IdInternoCrc,TextoAvalaiacaoInd,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
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

    public AtividadesGrupoPsicologia alterarAtendimentoGrupoAVGIENF(AtividadesGrupoPsicologia objAvalia) {
        buscarInterno(objAvalia.getNomeInternoCrc(), objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM SET IdAtGrupoEnf=?,IdInternoCrc=?,TextoAvalaiacaoInd=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemAvai='" + objAvalia.getIdItemAvai() + "'");
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

    public AtividadesGrupoPsicologia excluirAtendimentoGrupoAVGIENF(AtividadesGrupoPsicologia objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM WHERE IdItemAvaiEnf='" + objAvalia.getIdItemAvai() + "'");
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
