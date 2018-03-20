/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaAdvogados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntAdvogados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaAdvogados objItensAdvogado = new ItensEntradaAdvogados();
    int codAdvogado;
    int codDepto;

    public ItensEntradaAdvogados incluirItensVisitas(ItensEntradaAdvogados objItensAdvogado) {
        buscarAdvogado(objItensAdvogado.getNomeAdvogado(),objItensAdvogado.getIdAdvogado());
        buscarDepto(objItensAdvogado.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSADVOGADO (IdAdvogado,IdDepartamento,IdLanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert,Motivo) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codAdvogado);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensAdvogado.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensAdvogado.getDataEntrada().getTime()));
            pst.setString(5, objItensAdvogado.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensAdvogado.getDataSaida().getTime()));
            pst.setString(7, objItensAdvogado.getHorarioSaida());
            pst.setString(8, objItensAdvogado.getUsuarioInsert());
            pst.setString(9, objItensAdvogado.getDataInsert());
            pst.setString(10, objItensAdvogado.getHoraInsert());
            pst.setString(11, objItensAdvogado.getMotivoVisita());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensAdvogado;
    }

    public ItensEntradaAdvogados alterarItensVisitas(ItensEntradaAdvogados objItensAdvogado) {
        buscarAdvogado(objItensAdvogado.getNomeAdvogado(),objItensAdvogado.getIdAdvogado());
        buscarDepto(objItensAdvogado.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSADVOGADO SET IdAdvogado=?,IdDepartamento=?,IdLanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Motivo=? WHERE IdItem='" + objItensAdvogado.getIdItem() + "'");
            pst.setInt(1, codAdvogado);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensAdvogado.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensAdvogado.getDataEntrada().getTime()));
            pst.setString(5, objItensAdvogado.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensAdvogado.getDataSaida().getTime()));
            pst.setString(7, objItensAdvogado.getHorarioSaida());            
            pst.setString(8, objItensAdvogado.getUsuarioUp());
            pst.setString(9, objItensAdvogado.getDataUp());
            pst.setString(10, objItensAdvogado.getHoraUp());
            pst.setString(11, objItensAdvogado.getMotivoVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO :" + ex);
        }
        conecta.desconecta();
        return objItensAdvogado;
    }

    public ItensEntradaAdvogados excluirItensVisita(ItensEntradaAdvogados objItensAdvogado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSADVOGADO WHERE IdItem='" + objItensAdvogado.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAdvogado;
    }

    public void buscarAdvogado(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADVOGADOS WHERE NomeAdvogado='" + desc + "'AND IdAdvogado='" + codigo + "'");
            conecta.rs.first();
            codAdvogado = conecta.rs.getInt("IdAdvogado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (ADVOGADO) a ser exibido !!!" + e);
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
