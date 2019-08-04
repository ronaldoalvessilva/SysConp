/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InternosEntradaSaidaEducacional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleInternosEntradaSaidaEducacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosEntradaSaidaEducacional objInteEntSaiEduca = new InternosEntradaSaidaEducacional();

    int codInterno;

    public InternosEntradaSaidaEducacional incluirEntSaiInternoEducar(InternosEntradaSaidaEducacional objInteEntSaiEduca) {
        buscarInternos(objInteEntSaiEduca.getNomeInternoEduca(), objInteEntSaiEduca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOS_ENTRADA_SAIDA_EDUCACAO (IdLanc,IdInternoCrc,DataSaida,HorarioSaida,DataEntrada,HorarioEntrada,Observacao,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaSaida) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objInteEntSaiEduca.getIdLanc());
            pst.setInt(2, codInterno);
            if (objInteEntSaiEduca.getDataSaida() == null) {
                pst.setDate(3, null);
            } else {
                pst.setTimestamp(3, new java.sql.Timestamp(objInteEntSaiEduca.getDataSaida().getTime()));
            }
            pst.setString(4, objInteEntSaiEduca.getHorarioSaida());
            if (objInteEntSaiEduca.getDataEntrada() == null) {
                pst.setDate(5, null);
            } else {
                pst.setTimestamp(5, new java.sql.Timestamp(objInteEntSaiEduca.getDataEntrada().getTime()));
            }
            pst.setString(6, objInteEntSaiEduca.getHorarioEntrada());
            pst.setString(7, objInteEntSaiEduca.getObservacao());
            pst.setString(8, objInteEntSaiEduca.getUsuarioInsert());
            pst.setString(9, objInteEntSaiEduca.getDataInsert());
            pst.setString(10, objInteEntSaiEduca.getHorarioInsert());
            pst.setBytes(11, objInteEntSaiEduca.getpAssinaturaDigital());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }

    public InternosEntradaSaidaEducacional alterarEntSaiInternoEducar(InternosEntradaSaidaEducacional objInteEntSaiEduca) {
        buscarInternos(objInteEntSaiEduca.getNomeInternoEduca(), objInteEntSaiEduca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_ENTRADA_SAIDA_EDUCACAO SET IdLanc=?,IdInternoCrc=?,DataSaida=?,HorarioSaida=?,DataEntrada=?,HorarioEntrada=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaEntrada WHERE IdItem='" + objInteEntSaiEduca.getIdItem() + "'");
            pst.setInt(1, objInteEntSaiEduca.getIdLanc());
            pst.setInt(2, codInterno);
            if (objInteEntSaiEduca.getDataSaida() == null) {
                pst.setDate(3, null);
            } else {
                pst.setTimestamp(3, new java.sql.Timestamp(objInteEntSaiEduca.getDataSaida().getTime()));
            }
            pst.setString(4, objInteEntSaiEduca.getHorarioSaida());
            if (objInteEntSaiEduca.getDataEntrada() == null) {
                pst.setDate(5, null);
            } else {
                pst.setTimestamp(5, new java.sql.Timestamp(objInteEntSaiEduca.getDataEntrada().getTime()));
            }
            pst.setString(6, objInteEntSaiEduca.getHorarioEntrada());
            pst.setString(7, objInteEntSaiEduca.getObservacao());
            pst.setString(8, objInteEntSaiEduca.getUsuarioUp());
            pst.setString(9, objInteEntSaiEduca.getDataUp());
            pst.setString(10, objInteEntSaiEduca.getHorarioUp());
            pst.setBytes(11, objInteEntSaiEduca.getpAssinaturaDigital());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }

    public InternosEntradaSaidaEducacional excluiEntSaiInternoEducar(InternosEntradaSaidaEducacional objInteEntSaiEduca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO WHERE IdItem='" + objInteEntSaiEduca.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }

//--------------------------- ENTRADA E SAIDA POPR BIOMETRIA -------------------------
     public InternosEntradaSaidaEducacional saidaEntSaiInternoEducar(InternosEntradaSaidaEducacional objInteEntSaiEduca) {
        buscarInternos(objInteEntSaiEduca.getNomeInternoEduca(), objInteEntSaiEduca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOS_ENTRADA_SAIDA_EDUCACAO (IdLanc,IdInternoCrc,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaSaida) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objInteEntSaiEduca.getIdLanc());
            pst.setInt(2, codInterno);
            if (objInteEntSaiEduca.getDataSaida() == null) {
                pst.setDate(3, null);
            } else {
                pst.setTimestamp(3, new java.sql.Timestamp(objInteEntSaiEduca.getDataSaida().getTime()));
            }
            pst.setString(4, objInteEntSaiEduca.getHorarioSaida());           
            pst.setString(5, objInteEntSaiEduca.getUsuarioInsert());
            pst.setString(6, objInteEntSaiEduca.getDataInsert());
            pst.setString(7, objInteEntSaiEduca.getHorarioInsert());
            pst.setBytes(8, objInteEntSaiEduca.getpAssinaturaDigital());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }

    public InternosEntradaSaidaEducacional retornoEntSaiInternoEducar(InternosEntradaSaidaEducacional objInteEntSaiEduca) {
        buscarInternos(objInteEntSaiEduca.getNomeInternoEduca(), objInteEntSaiEduca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_ENTRADA_SAIDA_EDUCACAO SET IdLanc=?,IdInternoCrc=?,DataEntrada=?,HorarioEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaEntrada=? WHERE IdItem='" + objInteEntSaiEduca.getIdItem() + "'");
            pst.setInt(1, objInteEntSaiEduca.getIdLanc());
            pst.setInt(2, codInterno);           
            if (objInteEntSaiEduca.getDataEntrada() == null) {
                pst.setDate(3, null);
            } else {
                pst.setTimestamp(3, new java.sql.Timestamp(objInteEntSaiEduca.getDataEntrada().getTime()));
            }
            pst.setString(4, objInteEntSaiEduca.getHorarioEntrada());            
            pst.setString(5, objInteEntSaiEduca.getUsuarioUp());
            pst.setString(6, objInteEntSaiEduca.getDataUp());
            pst.setString(7, objInteEntSaiEduca.getHorarioUp());
            pst.setBytes(8, objInteEntSaiEduca.getpAssinaturaDigital());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados da BIOMETRIA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }

    
    public void buscarInternos(String nome, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + id + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os internos." + e);
        }
        conecta.desconecta();
    }

    public InternosEntradaSaidaEducacional alterarQuantidadeFrequencia(InternosEntradaSaidaEducacional objInteEntSaiEduca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA SET TotalDias=? WHERE IdInternoCrc='" + objInteEntSaiEduca.getIdInternoCrc() + "'AND MesReferencia='" + objInteEntSaiEduca.getMesReferencia() + "'");
            pst.setInt(1, objInteEntSaiEduca.getQtdInt());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objInteEntSaiEduca;
    }
}
