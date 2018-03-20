/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEncaminhamentoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensEncaminhamentoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEncaminhamentoInterno objItensEnca = new ItensEncaminhamentoInterno();

    public ItensEncaminhamentoInterno incluirItensEncaminhamento(ItensEncaminhamentoInterno objItensEnca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS (IdEnca,TipoEnca,DescricaoEncaminhamento,DataSaida,HoraSaida,DataRetorno,HoraRetorno,Motivo,Destino,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensEnca.getIdEnca());
            pst.setInt(2, objItensEnca.getTipoEnca());
            pst.setString(3, objItensEnca.getDescricaoEncaminhamento());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensEnca.getDataSaida().getTime()));
            pst.setString(5, objItensEnca.getHoraSaida());
            if (objItensEnca.getDataRetorno() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensEnca.getDataRetorno().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensEnca.getHoraRetorno());
            pst.setString(8, objItensEnca.getMotivo());
            pst.setString(9, objItensEnca.getDestino());
            pst.setString(10, objItensEnca.getUsuarioInsert());
            pst.setString(11, objItensEnca.getDataInsert());
            pst.setString(12, objItensEnca.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEnca;
    }

    public ItensEncaminhamentoInterno alterarItensEncaminhamento(ItensEncaminhamentoInterno objItensEnca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS SET IdEnca=?,TipoEnca=?,DescricaoEncaminhamento=?,DataSaida=?,HoraSaida=?,DataRetorno=?,HoraRetorno=?,Motivo=?,Destino=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemEnca='" + objItensEnca.getIdItemEnca() + "'");
            pst.setInt(1, objItensEnca.getIdEnca());
            pst.setInt(2, objItensEnca.getTipoEnca());
            pst.setString(3, objItensEnca.getDescricaoEncaminhamento());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensEnca.getDataSaida().getTime()));
            pst.setString(5, objItensEnca.getHoraSaida());
            if (objItensEnca.getDataRetorno() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensEnca.getDataRetorno().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensEnca.getHoraRetorno());
            pst.setString(8, objItensEnca.getMotivo());
            pst.setString(9, objItensEnca.getDestino());
            pst.setString(10, objItensEnca.getUsuarioUp());
            pst.setString(11, objItensEnca.getDataUp());
            pst.setString(12, objItensEnca.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEnca;
    }

    public ItensEncaminhamentoInterno excluirItensEncaminhamento(ItensEncaminhamentoInterno objItensEnca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS WHERE IdItemEnca='" + objItensEnca.getIdItemEnca() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEnca;
    }
}
