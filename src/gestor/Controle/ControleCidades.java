/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCidades {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Cidades objCidades = new Cidades();
    int codPaises;
    

    public Cidades incluirCidades(Cidades objCidades) {
        buscarPais(objCidades.getNomePais());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CIDADES (DddCidade,NomeCidade,UfCidade,IdPais,UsuarioInsert)VALUES(?,?,?,?,?)");
            pst.setInt(1, objCidades.getDddCidade());
            pst.setString(2, objCidades.getNomeCidade());
            pst.setString(3, objCidades.getUfCidade());
            pst.setInt(4, codPaises);
            pst.setString(5, objCidades.getNomeusuario());
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCidades;
    }

    public Cidades alterarCidades(Cidades objCidades) {
        buscarPais(objCidades.getNomePais());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CIDADES SET DddCidade=?,NomeCidade=?,UfCidade=?,IdPais=?,UsuarioInsert=? WHERE IdCidade='" + objCidades.getIdCidade() + "'");
            pst.setInt(1, objCidades.getDddCidade());
            pst.setString(2, objCidades.getNomeCidade());
            pst.setString(3, objCidades.getUfCidade());
            pst.setInt(4, codPaises);
            pst.setString(5, objCidades.getNomeusuario());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterado os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCidades;
    }

    public Cidades excluirCidades(Cidades objCidades) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CIDADES WHERE IdCidade='" + objCidades.getIdCidade() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterado os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCidades;
    }

    public void buscarPais(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAISES WHERE NomePais='" + nome + "'");
            conecta.rs.first();
            codPaises = conecta.rs.getInt("IdPais");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!" + ex);
        }
        conecta.desconecta();
    }
}
