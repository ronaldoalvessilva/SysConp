/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroSaidaPortaria;
import gestor.Modelo.TransferenciaInternosPortaria;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jIDlanc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegistroSaida {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroSaidaPortaria objSaida = new RegistroSaidaPortaria();
    public static int qtdInternosSaidaPorta = 0;

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

    public List<TransferenciaInternosPortaria> read() throws Exception {
        List<TransferenciaInternosPortaria> listaInternosSaidaPorta = new ArrayList<TransferenciaInternosPortaria>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGSAIDA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGSAIDACRC "
                    + "ON ITENSREGSAIDA.IdSaida=REGSAIDACRC.IdSaida "                   
                    + "WHERE ITENSREGSAIDA.IdSaida='" + jIDlanc.getText() + "'");
            while (conecta.rs.next()) {
                TransferenciaInternosPortaria pSaidaPortaria = new TransferenciaInternosPortaria();
                pSaidaPortaria.setDataSaida(conecta.rs.getDate("DataSaida"));
                pSaidaPortaria.setMatriculaCrc(conecta.rs.getString("MatriculaCrc"));
                pSaidaPortaria.setCncPortaria(conecta.rs.getString("Cnc"));
                pSaidaPortaria.setIdInternoSaida(conecta.rs.getInt("IdInternoCrc"));
                pSaidaPortaria.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pSaidaPortaria.setNomeUnidade(conecta.rs.getString("DestinoSaida"));
                pSaidaPortaria.setDocumento(conecta.rs.getString("DocumentoSaida"));
                pSaidaPortaria.setHorarioSaida(conecta.rs.getString("HoraSaida"));
                listaInternosSaidaPorta.add(pSaidaPortaria);
                qtdInternosSaidaPorta++;
            }
            return listaInternosSaidaPorta;
        } catch (SQLException ex) {
            Logger.getLogger(ControleItensRegSaidaInternos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
