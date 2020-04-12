/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAtividadesUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    //ABA MANUTENÇÃO
    public AtividadesMensalRealizadaUnidades incluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE (StatusAtividade,"
                    + "DataCriacao,DataAtualizacao,IdUnidEmp,Populacao,MesReferencia,AnoReferencia,IdFunc,"
                    + "Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=?,"
                    + "DataCriacao=?,DataAtualizacao=?,IdUnidEmp=?,Populacao=?,MesReferencia=?,AnoReferencia=?,IdFunc=?,"
                    + "Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades finalizarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //ABA ASSI
    public AtividadesMensalRealizadaUnidades incluirASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_SERVICO_SOCIAL (IdAtividade,"
                    + "AtendimentoPsicossocialPreso,AtendimentoPsicossocialFamiliaPreso,IdentificadoCivilmente,"
                    + "TotalServicoSocial) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getAtendimentoPsiPreso());
            pst.setInt(3, objAtividade.getAtendimentoPsiFamilaPreso());
            pst.setInt(4, objAtividade.getPresoIdentCivil());
            pst.setInt(5, objAtividade.getTotal01());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_SERVICO_SOCIAL SET AtendimentoPsicossocialPreso=?,"
                    + "AtendimentoPsicossocialFamiliaPreso=?,IdentificadoCivilmente=?,TotalServicoSocial=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getAtendimentoPsiPreso());
            pst.setInt(3, objAtividade.getAtendimentoPsiFamilaPreso());
            pst.setInt(4, objAtividade.getPresoIdentCivil());
            pst.setInt(5, objAtividade.getTotal01());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_SERVICO_SOCIAL WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AFV/AFI
    public AtividadesMensalRealizadaUnidades incluirAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA (IdAtividade,"
                    + "LanchesVisitantes,CafeContratada,AlmocoContratada,JantarContratada,LancheContratada,CafeContratante,"
                    + "AlmocoContratante,JantarContratante,LancheContratante,TotalAlimentacao) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getLanchesVisitantes());
            pst.setInt(3, objAtividade.getCafeContratada());
            pst.setInt(4, objAtividade.getAlmocoContratada());
            pst.setInt(5, objAtividade.getJantarContratada());
            pst.setInt(6, objAtividade.getLancheContratada());
            pst.setInt(7, objAtividade.getCafeContratante());
            pst.setInt(8, objAtividade.getAlmocoContratante());
            pst.setInt(9, objAtividade.getJantarContratante());
            pst.setInt(10, objAtividade.getLancheContratante());
            pst.setInt(11, objAtividade.getTotal02());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA SET LanchesVisitantes=?,"
                    + "CafeContratada=?,AlmocoContratada=?,JantarContratada=?,LancheContratada=?,CafeContratante=?,"
                    + "AlmocoContratante=?,JantarContratante=?,LancheContratante=?,TotalAlimentacao=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getLanchesVisitantes());
            pst.setInt(3, objAtividade.getCafeContratada());
            pst.setInt(4, objAtividade.getAlmocoContratada());
            pst.setInt(5, objAtividade.getJantarContratada());
            pst.setInt(6, objAtividade.getLancheContratada());
            pst.setInt(7, objAtividade.getCafeContratante());
            pst.setInt(8, objAtividade.getAlmocoContratante());
            pst.setInt(9, objAtividade.getJantarContratante());
            pst.setInt(10, objAtividade.getLancheContratante());
            pst.setInt(11, objAtividade.getTotal02());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }
}
