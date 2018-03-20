/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensSolicitantesCompras;
import gestor.Modelo.SolicitantesCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAtualizaValorSolicitantes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSolicitantesCompras itensSolComp = new ItensSolicitantesCompras();
    SolicitantesCompras solComp = new SolicitantesCompras();

    public ItensSolicitantesCompras alterarValorAcumuladoSolicitanteIndividualAC(ItensSolicitantesCompras itensSolComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITANTES_COMPRAS SET ValorVTA=? WHERE IdFunc='" + itensSolComp.getIdFunc() + "'AND DataInicial<='" + itensSolComp.getDataInicialComp() + "'AND DataFinal>='" + itensSolComp.getDataFinalComp()+ "'");         
            pst.setFloat(1, itensSolComp.getValorVTA());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR valor do colaborador.\nERRO: " + ex);
        }
        conecta.desconecta();
        return itensSolComp;
    }
    
    public SolicitantesCompras alterarValorAcumuladoSolicitanteGrupoAC(SolicitantesCompras solComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITANTES_COMPRAS SET ValorGAC=? WHERE IdDepartamento='" + solComp.getIdDepartamento() + "'AND TipoValor='" + solComp.getTipoValor()  + "'AND DataInicial<='" +  solComp.getDataInicialComp()+ "'AND DataFinal>='" + solComp.getDataFinalComp()+ "'");         
            pst.setFloat(1, solComp.getValorMax());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR valor do colaborador.\nERRO: " + ex);
        }
        conecta.desconecta();
        return solComp;
    }
}
