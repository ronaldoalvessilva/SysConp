/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DepositoInterno;
import gestor.Modelo.EstornoDepositoSaque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEstornoDepositoSaque {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EstornoDepositoSaque objEstorno = new EstornoDepositoSaque();
    int codInt = 0;

    public EstornoDepositoSaque incluirEstornoDepositos(EstornoDepositoSaque objEstorno) {
        buscarInterno(objEstorno.getNomeInternoCrc(), objEstorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTORNO_DEPOSITO_SAQUE (StatusEstorno,DataLanc,IdInternoCrc,Tipo,IdRegistro,DataRegistro,ValorEstorno,ValorDepositoSaque,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEstorno.getStatusEstorno());
            pst.setTimestamp(2, new java.sql.Timestamp(objEstorno.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objEstorno.getTipo());
            pst.setInt(5, objEstorno.getIdRegistro());
            pst.setTimestamp(6, new java.sql.Timestamp(objEstorno.getDataRegistro().getTime()));
            pst.setFloat(7, objEstorno.getValorEstorno());
            pst.setFloat(8, objEstorno.getValorDepositoSaque());
            pst.setString(9, objEstorno.getObservacao());
            pst.setString(10, objEstorno.getUsuarioInsert());
            pst.setString(11, objEstorno.getDataInsert());
            pst.setString(12, objEstorno.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEstorno;
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
}
