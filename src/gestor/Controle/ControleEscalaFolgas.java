/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalFolgas;
import static gestor.Visao.TelaEscalaFolgas.jCodigoPesqEscala;
import static gestor.Visao.TelaEscalaFolgas.pRESPOSTA_opcao;
import static gestor.Visao.TelaEscalaFolgas.jIdRegistro;
import static gestor.Visao.TelaEscalaFolgas.pDESCRICAO_escala;
import static gestor.Visao.TelaEscalaFolgas.pQUANTIDADE_trabalho;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEscalaFolgas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalFolgas objEscalas = new EscalFolgas();

    public EscalFolgas incluirEscalaTrabalaho(EscalFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESCALA_TRABALHO (StatusEscala,DataCadastro,DescricaoEscala,QuantidadeTrab,QuantidadeFolga,Turno,Turma,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEscalas.getStatusEscala());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscalas.getDataCadastro().getTime()));
            pst.setString(3, objEscalas.getDescricaoEscala());
            pst.setInt(4, objEscalas.getQuantidadeTrab());
            pst.setInt(5, objEscalas.getQuantidadeFolga());
            pst.setString(6, objEscalas.getTurno());
            pst.setString(7, objEscalas.getTurma());
            pst.setString(8, objEscalas.getUsuarioInsert());
            pst.setString(9, objEscalas.getDataInsert());
            pst.setString(10, objEscalas.getHorarioInsert());
            pst.execute();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalFolgas alterarEscalaTrabalaho(EscalFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCALA_TRABALHO SET StatusEscala=?,DataCadastro=?,DescricaoEscala=?,QuantidadeTrab=?,QuantidadeFolga=?,Turno=?,Turma=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistro='" + objEscalas.getIdRegistro() + "'");
            pst.setString(1, objEscalas.getStatusEscala());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscalas.getDataCadastro().getTime()));
            pst.setString(3, objEscalas.getDescricaoEscala());
            pst.setInt(4, objEscalas.getQuantidadeTrab());
            pst.setInt(5, objEscalas.getQuantidadeFolga());
            pst.setString(6, objEscalas.getTurno());
            pst.setString(7, objEscalas.getTurma());
            pst.setString(8, objEscalas.getUsuarioUp());
            pst.setString(9, objEscalas.getDataUp());
            pst.setString(10, objEscalas.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalFolgas excluirEscalaTrabalaho(EscalFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESCALA_TRABALHO WHERE IdRegistro='" + objEscalas.getIdRegistro() + "'");
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalFolgas MOSTRAR_escala(EscalFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "StatusEscala,DataCadastro, "
                    + "QuantidadeTrab,QuantidadeFolga, "
                    + "DescricaoEscala,Turno,"
                    + "Turma "
                    + "FROM ESCALA_TRABALHO "
                    + "WHERE IdRegistro='" + jCodigoPesqEscala.getText() + "' ");
            conecta.rs.first();
            objEscalas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objEscalas.setStatusEscala(conecta.rs.getString("StatusEscala"));
            objEscalas.setDataCadastro(conecta.rs.getDate("DataCadastro"));
            objEscalas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
            objEscalas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
            objEscalas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
            objEscalas.setTurno(conecta.rs.getString("Turno"));
            objEscalas.setTurma(conecta.rs.getString("Turma"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalFolgas PESQUISAR_codigo(EscalFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro "
                    + "FROM ESCALA_TRABALHO");
            conecta.rs.last();
            jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegistro")));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalFolgas PESQUISAR_escala(EscalFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DescricaoEscala, "
                    + "QuantidadeTrab "
                    + "FROM ESCALA_TRABALHO "
                    + "WHERE DescricaoEscala='" + objEscalas.getDescricaoEscala() + "' "
                    + "AND QuantidadeTrab='" + objEscalas.getQuantidadeTrab().toString() + "'");
            conecta.rs.first();
            pDESCRICAO_escala.equals(conecta.rs.getString("DescricaoEscala"));
            pQUANTIDADE_trabalho.equals(conecta.rs.getString("QuantidadeTrab"));
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
        return objEscalas;
    }
}
