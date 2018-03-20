/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DadosPenaisCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleNovaEntradaInternos {

    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    ConexaoBancoDados conecta = new ConexaoBancoDados();

    public DadosPenaisCrc incluirDataNovaEntrada(DadosPenaisCrc objDadosPena) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET DataNovaEntrada=? WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "'");
            if (objDadosPena.getDataNovaEntrada() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(objDadosPena.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(1, null);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR a nova data de entrada do Interno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDadosPena;
    }
}
