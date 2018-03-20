/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoPedagogica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEvolucaoPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoPedagogica objEvolucaoAdmPedago = new EvolucaoPedagogica();

    int codInterno;

    public EvolucaoPedagogica incluirEvolucaoPed(EvolucaoPedagogica objEvolucaoAdmPedago) {
        buscarInternoCrc(objEvolucaoAdmPedago.getNomeInternoCrc(), objEvolucaoAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAO_ADMISSAO_PEDAGOGIA (IdAdm,IdInternoCrc,DataEvolucao,NomeDepartamento,DataEncaminhamento,HoraEncaminhamento,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEvolucaoAdmPedago.getIdAdm());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objEvolucaoAdmPedago.getDataEvolucao().getTime()));
            pst.setString(4, objEvolucaoAdmPedago.getNomeDepartamento());
            pst.setTimestamp(5, new java.sql.Timestamp(objEvolucaoAdmPedago.getDataEncaminhamento().getTime()));
            pst.setString(6, objEvolucaoAdmPedago.getHoraEncaminhamento());
            pst.setString(7, objEvolucaoAdmPedago.getHistorico());
            pst.setString(8, objEvolucaoAdmPedago.getUsuarioInsert());
            pst.setString(9, objEvolucaoAdmPedago.getDataInsert());
            pst.setString(10, objEvolucaoAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEvolucaoAdmPedago;
    }

    public EvolucaoPedagogica alterarEvolucaoPed(EvolucaoPedagogica objEvolucaoAdmPedago) {
        buscarInternoCrc(objEvolucaoAdmPedago.getNomeInternoCrc(), objEvolucaoAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_ADMISSAO_PEDAGOGIA SET IdAdm=?,IdInternoCrc=?,DataEvolucao=?,NomeDepartamento=?,DataEncaminhamento=?,HoraEncaminhamento=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEvolucao='" + objEvolucaoAdmPedago.getIdEvolucao() + "'");
            pst.setInt(1, objEvolucaoAdmPedago.getIdAdm());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objEvolucaoAdmPedago.getDataEvolucao().getTime()));
            pst.setString(4, objEvolucaoAdmPedago.getNomeDepartamento());
            pst.setTimestamp(5, new java.sql.Timestamp(objEvolucaoAdmPedago.getDataEncaminhamento().getTime()));
            pst.setString(6, objEvolucaoAdmPedago.getHoraEncaminhamento());
            pst.setString(7, objEvolucaoAdmPedago.getHistorico());
            pst.setString(8, objEvolucaoAdmPedago.getUsuarioUp());
            pst.setString(9, objEvolucaoAdmPedago.getDataUp());
            pst.setString(10, objEvolucaoAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEvolucaoAdmPedago;
    }

    public EvolucaoPedagogica excluirEvolucaoPed(EvolucaoPedagogica objEvolucaoAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAO_ADMISSAO_PEDAGOGIA WHERE IdEvolucao='" + objEvolucaoAdmPedago.getIdEvolucao() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEvolucaoAdmPedago;
    }

    public void buscarInternoCrc(String nomeInterno, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
