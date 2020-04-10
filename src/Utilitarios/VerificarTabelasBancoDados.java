/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CriarTabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class VerificarTabelasBancoDados {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CriarTabela objTabela = new CriarTabela();
    
    public CriarTabela criarTabela(CriarTabela objTabela) {

        conecta.abrirConexao();
        try {         
            PreparedStatement pst = conecta.con.prepareStatement("USE DB_SOCIALIZA");
            PreparedStatement smt = conecta.con.prepareStatement("IF NOT EXISTS(SELECT * FROM PROCEDIMENTOS)CREATE TABLE PROCEDIMENTOS "
                    + "(IdProc INT IDENTITY (1,1) PRIMARY KEY NOT NULL, "
                    + "StatusLanc VARCHAR(30) NULL, "
                    + "DataLanc DATE NULL, "
                    + "HorarioInicial VARCHAR(20) NULL, "
                    + "HorarioTermino VARCHAR(20) NULL, "
                    + "Responsavel VARCHAR(300) NULL, "
                    + "Observacao VARCHAR(MAX) NULL, "
                    + "UsuarioInsert VARCHAR(50) NULL, "
                    + "UsuarioUp VARCHAR(50) NULL, "
                    + "DataInsert VARCHAR(20) NULL, "
                    + "DataUp VARCHAR(20) NULL, "
                    + "HorarioInsert VARCHAR(10) NULL, "
                    + "HorarioUp VARCHAR(10) NULL,");
            pst.execute(); // Executa abertura do banco
            smt.execute(); // executa a criação da tabela
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CRIAR TABELA\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTabela;
    }
}
