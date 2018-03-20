/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaAdvogados;
import gestor.Modelo.ItensOficialJustica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntOficialJustica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensOficialJustica objItensOficialJustica = new ItensOficialJustica();
    int codOficialJustica;
    int codDepto;

    public ItensOficialJustica incluirItensOficialJustica(ItensOficialJustica objItensOficialJustica) {
        buscarOficial(objItensOficialJustica.getNomeOficial(),objItensOficialJustica.getIdOficial());
        buscarDepto(objItensOficialJustica.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENTRADAS_OFICIAL_JUSTICA (IdOficial,IdDepartamento,IdLanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert,Motivo) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codOficialJustica);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensOficialJustica.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensOficialJustica.getDataEntrada().getTime()));
            pst.setString(5, objItensOficialJustica.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensOficialJustica.getDataSaida().getTime()));
            pst.setString(7, objItensOficialJustica.getHorarioSaida());
            pst.setString(8, objItensOficialJustica.getUsuarioInsert());
            pst.setString(9, objItensOficialJustica.getDataInsert());
            pst.setString(10, objItensOficialJustica.getHoraInsert());
            pst.setString(11, objItensOficialJustica.getMotivoVisita());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensOficialJustica;
    }

    public ItensOficialJustica alterarItensOficialJustica(ItensOficialJustica objItensOficialJustica) {
        buscarOficial(objItensOficialJustica.getNomeOficial(),objItensOficialJustica.getIdOficial());
        buscarDepto(objItensOficialJustica.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENTRADAS_OFICIAL_JUSTICA SET IdOficial=?,IdDepartamento=?,IdLanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Motivo=? WHERE IdItem='" + objItensOficialJustica.getIdItem() + "'");
            pst.setInt(1, codOficialJustica);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensOficialJustica.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensOficialJustica.getDataEntrada().getTime()));
            pst.setString(5, objItensOficialJustica.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensOficialJustica.getDataSaida().getTime()));
            pst.setString(7, objItensOficialJustica.getHorarioSaida());            
            pst.setString(8, objItensOficialJustica.getUsuarioUp());
            pst.setString(9, objItensOficialJustica.getDataUp());
            pst.setString(10, objItensOficialJustica.getHoraUp());
            pst.setString(11, objItensOficialJustica.getMotivoVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensOficialJustica;
    }

    public ItensOficialJustica excluirItensOficialJustica(ItensOficialJustica objItensOficialJustica) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENTRADAS_OFICIAL_JUSTICA WHERE IdItem='" + objItensOficialJustica.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensOficialJustica;
    }

    public void buscarOficial(String desc,int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OFICIAL_JUSTICA WHERE NomeOficial='" + desc + "'AND IdOficial='" + codigo + "'");
            conecta.rs.first();
            codOficialJustica = conecta.rs.getInt("IdOficial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (OFICIAL DE JUSTICA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarDepto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + desc + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DEPARTAMENTO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
