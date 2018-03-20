/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DepositoInterno;
import static gestor.Visao.TelaPesqDepositoPortaria.idItem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDeposito {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DepositoInterno objDeposito = new DepositoInterno();
    int codInt = 0;
    int codUsu = 0;

    public DepositoInterno incluirDepositos(DepositoInterno objDeposito) {
        buscarInterno(objDeposito.getNomeInterno(), objDeposito.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEPOSITO (StatusLanc,DataLanc,IdInternoCrc,ValorDeposito,Depositante,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objDeposito.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDeposito.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setFloat(4, objDeposito.getValorDeposito());
            pst.setString(5, objDeposito.getDepositante());
            pst.setString(6, objDeposito.getObservacao());
            pst.setString(7, objDeposito.getUsuarioInsert());
            pst.setString(8, objDeposito.getDataInsert());
            pst.setString(9, objDeposito.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public DepositoInterno alterarDepositos(DepositoInterno objDeposito) {
        buscarInterno(objDeposito.getNomeInterno(), objDeposito.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITO SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,ValorDeposito=?,Depositante=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objDeposito.getIdLanc() + "'");
            pst.setString(1, objDeposito.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDeposito.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setFloat(4, objDeposito.getValorDeposito());
            pst.setString(5, objDeposito.getDepositante());
            pst.setString(6, objDeposito.getObservacao());
            pst.setString(7, objDeposito.getUsuarioUp());
            pst.setString(8, objDeposito.getDataUp());
            pst.setString(9, objDeposito.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public DepositoInterno excluirDepositos(DepositoInterno objDeposito) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEPOSITO WHERE IdLanc='" + objDeposito.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public DepositoInterno finalizarDepositos(DepositoInterno objDeposito) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITO SET StatusLanc=? WHERE IdLanc='" + objDeposito.getIdLanc() + "'");
            pst.setString(1, objDeposito.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    // Atualizar tabela ITENSDEPOSITOPORTARIA impedindo que seja alterar e excluido após a confirmação do deposito.
    public DepositoInterno atualizarDepositos(DepositoInterno objDeposito) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSDEPOSITOPORTARIA SET Efetuado=? WHERE IdItem='" + idItem + "'AND IdInternoCrc='" + objDeposito.getIdInternoCrc() + "'");
            pst.setString(1, objDeposito.getEfetuado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR DEPOSITO PORTARIA os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    //---------------------------- HISTÓRICO DE MOVIMENTAÇÃO DE AUTORIZAÇÃO DE MODIFICAÇÃO DO DEPOSITO
    public DepositoInterno incluirHitorico(DepositoInterno objDeposito) {
        buscarUsuario(objDeposito.getNomeUsuario(), objDeposito.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_LIBERADORES_BANCO_VIRTUAL (DataLanc,IdLanc,IdUsuario,Tipo,ValorLiberado,SaldoAtual) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objDeposito.getDataLancMov().getTime()));
            pst.setInt(2, objDeposito.getIdLanc());
            pst.setInt(3, codUsu);
            pst.setInt(4, objDeposito.getTipo());
            pst.setFloat(5, objDeposito.getValorLiberado());
            pst.setFloat(6, objDeposito.getSaldoAtual());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public DepositoInterno alterarHitorico(DepositoInterno objDeposito) {
        buscarUsuario(objDeposito.getNomeUsuario(), objDeposito.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_LIBERADORES_BANCO_VIRTUAL SET DataLanc=?,IdLanc=?,IdUsuario=?,Tipo=?,ValorLiberado=? WHERE IdLanc='" + objDeposito.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objDeposito.getDataLancMov().getTime()));
            pst.setInt(2, codUsu);
            pst.setInt(3, objDeposito.getIdLanc());
            pst.setInt(4, objDeposito.getTipo());
            pst.setDouble(5, objDeposito.getValorLiberado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public DepositoInterno excluirHitorico(DepositoInterno objDeposito) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_LIBERADORES_BANCO_VIRTUAL WHERE IdLanc='" + objDeposito.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDeposito;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do interno a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarUsuario(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nome + "'AND IdUsuario='" + codigo + "'");
            conecta.rs.first();
            codUsu = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do usuário a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
