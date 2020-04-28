/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleProrrogarSaidaTmpPD {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public ProrrogarSaidaTemporariaPrisaoDomicilicar incluirProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR (StatusRegistro,DataRegistro,Responsavel,TipoSaida,Documento,DataDocumento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objProrroga.getStatusRegistro());
            if (objProrroga.getDataRegistro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objProrroga.getDataRegistro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objProrroga.getResponsavel());
            pst.setString(4, objProrroga.getTipoSaida());
            pst.setString(5, objProrroga.getDocumento());
            if (objProrroga.getDataDocumento() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objProrroga.getDataDocumento().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objProrroga.getObservacao());
            pst.setString(8, objProrroga.getUsuarioInsert());
            pst.setString(9, objProrroga.getDataInsert());
            pst.setString(10, objProrroga.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar alterarProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR SET StatusRegistro=?,DataRegistro=?,Responsavel=?,TipoSaida=?,Documento=?,DataDocumento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPro='" + objProrroga.getIdRegistro() + "'");
            pst.setString(1, objProrroga.getStatusRegistro());
            if (objProrroga.getDataRegistro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objProrroga.getDataRegistro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objProrroga.getResponsavel());
            pst.setString(4, objProrroga.getTipoSaida());
            pst.setString(5, objProrroga.getDocumento());
            if (objProrroga.getDataDocumento() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objProrroga.getDataDocumento().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objProrroga.getObservacao());
            pst.setString(8, objProrroga.getUsuarioUp());
            pst.setString(9, objProrroga.getDataUp());
            pst.setString(10, objProrroga.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar excluirProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR WHERE IdPro='" + objProrroga.getIdRegistro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar finalizarProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR SET StatusRegistro=? WHERE IdPro='" + objProrroga.getIdRegistro() + "'");
            pst.setString(1, objProrroga.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    //----------------------- INTERNOS DA PRORROGRAÇÃO DA SAÍDA TEMPORÁRIA/PRISÃO DOMICILIAR
    public ProrrogarSaidaTemporariaPrisaoDomicilicar incluirInternosProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR (IdPro,IdInternoCrc,IdSaida,DataSaida,DataPrevisaoRetorno,DataNova,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objProrroga.getIdRegistro());
            pst.setInt(2, objProrroga.getIdInternoPro());
            pst.setInt(3, objProrroga.getIdSaida());
            if (objProrroga.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objProrroga.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            if (objProrroga.getDataPrevisaoRetorno() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objProrroga.getDataPrevisaoRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (objProrroga.getDataNova() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objProrroga.getDataNova().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objProrroga.getObservacao());
            pst.setString(8, objProrroga.getUsuarioInsert());
            pst.setString(9, objProrroga.getDataInsert());
            pst.setString(10, objProrroga.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar alterarInternosProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR SET IdInternoCrc=?,IdSaida=?,DataSaida=?,DataPrevisaoRetorno=?,DataNova=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objProrroga.getIdItem() + "'");
            pst.setInt(1, objProrroga.getIdInternoPro());
            pst.setInt(2, objProrroga.getIdSaida());
            if (objProrroga.getDataSaida() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objProrroga.getDataSaida().getTime()));
            } else {
                pst.setDate(3, null);
            }
            if (objProrroga.getDataPrevisaoRetorno() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objProrroga.getDataPrevisaoRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            if (objProrroga.getDataNova() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objProrroga.getDataNova().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objProrroga.getUsuarioUp());
            pst.setString(7, objProrroga.getDataUp());
            pst.setString(8, objProrroga.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar excluirInternosProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR  WHERE IdItem='" + objProrroga.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }
    
    public ProrrogarSaidaTemporariaPrisaoDomicilicar excluirTodosInternosProrrogacao(ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR  WHERE IdRegistro='" + objProrroga.getIdRegistro()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR TODOS os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProrroga;
    }
}
