/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CadastroTelasSistema;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleTelasSistema {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadTela = new CadastroTelasSistema();

    public CadastroTelasSistema incluirTelaAcesso(CadastroTelasSistema objCadTela) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TELAS (IdModulo,nomeTela) VALUES(?,?)");
            pst.setInt(1, objCadTela.getIdModulo());
            pst.setString(2, objCadTela.getNomeTela());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCadTela;
    }
}
