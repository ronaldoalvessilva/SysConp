/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAgendaEscolta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleModificaAgendaEscoltaSaida {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAgendaEscolta objItensAgenda = new ItensAgendaEscolta();

    public ItensAgendaEscolta modificarAgendaInterno(ItensAgendaEscolta objItensAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSAGENDA SET UtilizaAgenda=? WHERE IdInternoCrc='" + objItensAgenda.getIdInternoCrc()+ "' AND IdItem='" + objItensAgenda.getIdItem() + "'");
            pst.setString(1, objItensAgenda.getUtilizaAgenda());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

}
