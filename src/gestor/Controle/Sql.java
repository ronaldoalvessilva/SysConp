/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ronal
 */
public class Sql {

    public int auto_icrement(String sql) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexaoBancoDados conecta = new ConexaoBancoDados();
        conecta.abrirConexao();
        try {
            ps = conecta.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("idmaximo" + e.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                conecta.desconecta();
            } catch (Exception e) {
            }
        }
        return id;
    }
    public static void main(String[] args) {
    }
}
