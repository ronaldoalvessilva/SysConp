/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IngredientesFichaTecnica;
import gestor.Modelo.ItensReceitaCalculado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensCalculado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensReceitaCalculado objItensCal = new ItensReceitaCalculado();

    public ItensReceitaCalculado incluirItensCalcNUTRI(ItensReceitaCalculado objItensCal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI (Item,DataCalc,StatusCalc,IdFicha,IdProd,QtdPorcaoCalc,ItemCalc,Unidade,QtdPorcao,QtdTotal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensCal.getItem());
            pst.setTimestamp(2, new java.sql.Timestamp(objItensCal.getDataCalc().getTime()));
            pst.setString(3, objItensCal.getStatusCalc());
            pst.setInt(4, objItensCal.getIdFicha());
            pst.setInt(5, objItensCal.getIdProd());
            pst.setFloat(6, objItensCal.getQtdPorcaoCalc());
            pst.setInt(7, objItensCal.getItemCalc());
            pst.setString(8, objItensCal.getUnidade());
            pst.setFloat(9, objItensCal.getQtdPorcao());
            pst.setFloat(10, objItensCal.getQtdTotal());
            pst.setString(11, objItensCal.getUsuarioInsert());
            pst.setString(12, objItensCal.getDataInsert());
            pst.setString(13, objItensCal.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCal;
    }

    public ItensReceitaCalculado excluirItensCalcNUTRI(ItensReceitaCalculado objItensCal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI WHERE IdFicha='" + objItensCal.getIdFicha() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCal;
    }
}
