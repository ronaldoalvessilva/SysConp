/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IngredientesFichaTecnica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleIngredientesFichaTecnica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IngredientesFichaTecnica objIngredientes = new IngredientesFichaTecnica();
    int codProd;

    public IngredientesFichaTecnica incluirIngredientesFichaTecnicaNUTRI(IngredientesFichaTecnica objIngredientes) {
        buscarProduto(objIngredientes.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INGREDIENTES_FICHA_TECNICA_NUTRI (Item,IdFicha,IdProd,QtdItem,Perda,QtdFinal,PesoBruto,PesoLiquido,FatorCorrecao,FatorCoccao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objIngredientes.getItem());
            pst.setInt(2, objIngredientes.getIdFicha());
            pst.setInt(3, codProd);
            pst.setFloat(4, objIngredientes.getQtdItem());
            pst.setFloat(5, objIngredientes.getPerda());
            pst.setFloat(6, objIngredientes.getQuantidadeFinal());
            pst.setFloat(7, objIngredientes.getPesoBruto());
            pst.setFloat(8, objIngredientes.getPesoLiquido());
            pst.setFloat(9, objIngredientes.getFatorCorrecao());
            pst.setFloat(10, objIngredientes.getFatorCoccao());
            pst.setString(11, objIngredientes.getUsuarioInsert());
            pst.setString(12, objIngredientes.getDataInsert());
            pst.setString(13, objIngredientes.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIngredientes;
    }

    public IngredientesFichaTecnica alterarIngredientesFichaTecnicaNUTRI(IngredientesFichaTecnica objIngredientes) {
        buscarProduto(objIngredientes.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INGREDIENTES_FICHA_TECNICA_NUTRI SET Item=?,IdFicha=?,IdProd=?,QtdItem=?,Perda=?,QtdFinal=?,PesoBruto=?,PesoLiquido=?,FatorCorrecao=?,FatorCoccao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objIngredientes.getIdItem() + "'");
            pst.setInt(1, objIngredientes.getItem());
            pst.setInt(2, objIngredientes.getIdFicha());
            pst.setInt(3, codProd);
            pst.setFloat(4, objIngredientes.getQtdItem());
            pst.setFloat(5, objIngredientes.getPerda());
            pst.setFloat(6, objIngredientes.getQuantidadeFinal());
            pst.setFloat(7, objIngredientes.getPesoBruto());
            pst.setFloat(8, objIngredientes.getPesoLiquido());
            pst.setFloat(9, objIngredientes.getFatorCorrecao());
            pst.setFloat(10, objIngredientes.getFatorCoccao());
            pst.setString(11, objIngredientes.getUsuarioUp());
            pst.setString(12, objIngredientes.getDataUp());
            pst.setString(13, objIngredientes.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIngredientes;
    }

    public IngredientesFichaTecnica excluirIngredientesFichaTecnicaNUTRI(IngredientesFichaTecnica objIngredientes) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INGREDIENTES_FICHA_TECNICA_NUTRI WHERE Item='" + objIngredientes.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIngredientes;
    }

    public void buscarProduto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + desc + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o código do produto.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
