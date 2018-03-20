/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroSaidaPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegistroSaida {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroSaidaPortaria objSaida = new RegistroSaidaPortaria();
   

    public RegistroSaidaPortaria incluirRegSaidaInternos(RegistroSaidaPortaria objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGSAIDACRC (ObsSaida,StatusSai,DataLancaMov,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objSaida.getObsSaida());
            pst.setString(2, objSaida.getStatusSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objSaida.getDataLanc().getTime()));
            pst.setString(4, objSaida.getUsuarioInsert());
            pst.setString(5, objSaida.getDataInsert());
            pst.setString(6, objSaida.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaida;

    }

    public RegistroSaidaPortaria alterarRegSaidaInternos(RegistroSaidaPortaria objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGSAIDACRC SET ObsSaida=?,StatusSai=?,DataLancaMov=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSaida='" + objSaida.getIdSaida() + "'");
            pst.setString(1, objSaida.getObsSaida());
            pst.setString(2, objSaida.getStatusSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objSaida.getDataLanc().getTime()));
            pst.setString(4, objSaida.getUsuarioInsert());
            pst.setString(5, objSaida.getDataInsert());
            pst.setString(6, objSaida.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaida;

    }

    //Método para excluir ENTRADAS    
    public RegistroSaidaPortaria excluirRegSaidaInternos(RegistroSaidaPortaria objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM REGSAIDACRC WHERE IdSaida='" + objSaida.getIdSaida() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    //Método para excluir ENTRADAS    
    public RegistroSaidaPortaria finalizarRegSaidaInternos(RegistroSaidaPortaria objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("UPDATE REGSAIDACRC SET StatusSai=? WHERE IdSaida='" + objSaida.getIdSaida() + "'");
            pst.setString(1, objSaida.getStatusSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objSaida;
    }
}
