/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaInternosPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensEntradaPortaria_SAIDAS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaInternosPortaria objItensEntIntPort = new ItensEntradaInternosPortaria();
    //
    String nomeOpeCancelamento = "Cancelamento de Saída de Interno";

    public ItensEntradaInternosPortaria incluirItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_REGISTRO_CANCELADO_SAIDAS (IdLanc,NomeInternoCrc,DataSaida,HoraSaida,OficioInternos,OrigemInterno,ConfirmaEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensEntIntPort.getIdLanc());
            pst.setString(2, objItensEntIntPort.getNomeInternoCrc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensEntIntPort.getDataSaida().getTime()));
            pst.setString(4, objItensEntIntPort.getHoraSaida());
            pst.setString(5, objItensEntIntPort.getNumeroOficio());
            pst.setString(6, objItensEntIntPort.getOrigemInterno());
            pst.setString(7, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(8, objItensEntIntPort.getUsuarioInsert());
            pst.setString(9, objItensEntIntPort.getDataInsert());
            pst.setString(10, objItensEntIntPort.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria alterarItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REGISTRO_CANCELADO_SAIDAS SET IdLanc=?,NomeInternoCrc=?,DataSaida=?,HoraSaida=?,OficioInternos=?,OrigemInterno=?,ConfirmaEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
            pst.setInt(1, objItensEntIntPort.getIdLanc());
            pst.setString(2, objItensEntIntPort.getNomeInternoCrc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensEntIntPort.getDataSaida().getTime()));
            pst.setString(4, objItensEntIntPort.getHoraSaida());
            pst.setString(5, objItensEntIntPort.getNumeroOficio());
            pst.setString(6, objItensEntIntPort.getOrigemInterno());
            pst.setString(7, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(8, objItensEntIntPort.getUsuarioUp());
            pst.setString(9, objItensEntIntPort.getDataUp());
            pst.setString(10, objItensEntIntPort.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria excluirItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_REGISTRO_CANCELADO_SAIDAS WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    // PARTE DO CANCELAMENTO DAS SAÍDAS - CRC E PORTARIA
    //EXCLUIR DE SAIDA PELO CRC
    public ItensEntradaInternosPortaria excluir_SAIDA_PortariaCrc(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "'AND IdItem='" + objItensEntIntPort.getIdEntraSaida()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    //CANCELAR O REGISTRO NA PORTARIA
    public ItensEntradaInternosPortaria confirmar_CANCELAMENTO_SaidaCRCPr(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGSAIDA SET RegistroCancelado=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "' AND DestinoSaida='" + objItensEntIntPort.getOrigemInterno() + "'");
            pst.setString(1, objItensEntIntPort.getRegistroCancelado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
    
    //EXCLUIR REGISTRO NA PORTARIA QUANDO LANÇAMENTO ESTIVER ERRADO
    public ItensEntradaInternosPortaria excluir_SAIDA_portaria(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSREGSAIDA WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "' AND DestinoSaida='" + objItensEntIntPort.getOrigemInterno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
    
    public ItensEntradaInternosPortaria excluirMOVI_SAIDA(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVISR WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc()+ "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
    
     public ItensEntradaInternosPortaria incluir_MOVIMENTO_CANCELAMENTOSaida_CRC_PROTARIA(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objItensEntIntPort.getIdInternoCrc());
            pst.setInt(2, objItensEntIntPort.getIdEntraSaida());
            pst.setString(3, nomeOpeCancelamento);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensEntIntPort.getDataSaida().getTime()));
            pst.setString(5, objItensEntIntPort.getNomeDestino());
            pst.setInt(6, objItensEntIntPort.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
     
     //CANCELA SAIDA NO CRC - TABELA ITENSSAIDA
     public ItensEntradaInternosPortaria alterar_ITENSSAIDA_CANCELADO(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET SaidaConfirmada=?,RegistroCancelado=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "'AND IdItem='" + objItensEntIntPort.getIdEntraSaida()+ "'");
            pst.setString(1, objItensEntIntPort.getSaidaConfirmada());
            pst.setString(2, objItensEntIntPort.getRegistroCancelado());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
     
      //CANCELA SAIDA NO CRC - TABELA ITENSTRANSFERENCIA
     public ItensEntradaInternosPortaria alterar_ITENTRANSFERENCIA_CANCELADO(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET SaidaConfirmada=?,RegistroCancelado=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdSaida='" + objItensEntIntPort.getIdRetorno() + "'AND IdItem='" + objItensEntIntPort.getIdEntraSaida()+ "'");
            pst.setString(1, objItensEntIntPort.getSaidaConfirmada());
            pst.setString(2, objItensEntIntPort.getRegistroCancelado());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
}
