/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensFrequencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosFrequencia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensFrequencia objItensFreq = new ItensFrequencia();

    int codInterno;
    double qtdFrequencia;

    public ControleInternosFrequencia() {
        this.qtdFrequencia = 2.5;
    }

    public ItensFrequencia incluirFrequenciaInternos(ItensFrequencia objItensFreq) {
        buscarInternoCrc(objItensFreq.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSFREQUENCIA (IdFreq,IdInternoCrc,QtdFrequencia,DataEntrada,DataSaida,HorarioEntrada,HorarioSaida,Presenca,Utilizado,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensFreq.getIdFreq());
            pst.setInt(2, codInterno);
            pst.setDouble(3, qtdFrequencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensFreq.getDataEntrada().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objItensFreq.getDataSaida().getTime()));
            pst.setString(6, objItensFreq.getHorarioEntrada());
            pst.setString(7, objItensFreq.getHorarioSaida());
            pst.setString(8, objItensFreq.getPresenca());
            pst.setString(9, objItensFreq.getUtilizacaoMatricula());
            pst.setString(10, objItensFreq.getUsuarioInsert());
            pst.setString(11, objItensFreq.getDataInsert());
            pst.setString(12, objItensFreq.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFreq;
    }

    public ItensFrequencia alterarFrequenciaInternos(ItensFrequencia objItensFreq) {
        buscarInternoCrc(objItensFreq.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSFREQUENCIA SET IdFreq=?,IdInternoCrc=?,QtdFrequencia=?,DataEntrada=?,DataSaida=?,HorarioEntrada=?,HorarioSaida=?,Presenca=?,Utilizado=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensFreq.getIdItem() + "'");
            pst.setInt(1, objItensFreq.getIdFreq());
            pst.setInt(2, codInterno);
            pst.setDouble(3, qtdFrequencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensFreq.getDataEntrada().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objItensFreq.getDataSaida().getTime()));
            pst.setString(6, objItensFreq.getHorarioEntrada());
            pst.setString(7, objItensFreq.getHorarioSaida());
            pst.setString(8, objItensFreq.getPresenca());
            pst.setString(9, objItensFreq.getUtilizacaoMatricula());
            pst.setString(10, objItensFreq.getUsuarioUp());
            pst.setString(11, objItensFreq.getDataUp());
            pst.setString(12, objItensFreq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFreq;
    }

    public ItensFrequencia excluirFrequenciaInternos(ItensFrequencia objItensFreq) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSFREQUENCIA WHERE IdItem='" + objItensFreq.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFreq;
    }

    public void buscarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
