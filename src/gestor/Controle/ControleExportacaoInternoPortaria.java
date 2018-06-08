/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import gestor.Modelo.TransferenciaInternosPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleExportacaoInternoPortaria {

    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    TransferenciaInternosPortaria pSaidaPortaria = new TransferenciaInternosPortaria();

    // TABELA DO BANCO DE DADOS DE LAURO DE FREITAS.
    public TransferenciaInternosPortaria incluirInternoPortariaLF(TransferenciaInternosPortaria pSaidaPortaria) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES (Cnc,Matricula,NomeInterno,DataExp,"
                    + "HoraSaida,Documento,UnidadeOrigem,ConfirmadoExp,ConfirmadoImp) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pSaidaPortaria.getCncPortaria());
            pst.setString(2, pSaidaPortaria.getMatriculaCrc());
            pst.setString(3, pSaidaPortaria.getNomeInternoCrc());
            if (pSaidaPortaria.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(pSaidaPortaria.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, pSaidaPortaria.getHorarioSaida());
            pst.setString(6, pSaidaPortaria.getDocumento());
            pst.setString(7, pSaidaPortaria.getNomeUnidade());
            pst.setString(8, pSaidaPortaria.getConfirmaExp());
            pst.setString(9, pSaidaPortaria.getConfirmaImp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return pSaidaPortaria;
    }

    // TABELA DO BANCO DE DADOS DE ITABUNA
    public TransferenciaInternosPortaria incluirInternoPortariaITB(TransferenciaInternosPortaria pSaidaPortaria) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES (Cnc,Matricula,NomeInterno,DataExp,"
                    + "HoraSaida,Documento,UnidadeOrigem,ConfirmadoExp,ConfirmadoImp) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pSaidaPortaria.getCncPortaria());
            pst.setString(2, pSaidaPortaria.getMatriculaCrc());
            pst.setString(3, pSaidaPortaria.getNomeInternoCrc());
            if (pSaidaPortaria.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(pSaidaPortaria.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, pSaidaPortaria.getHorarioSaida());
            pst.setString(6, pSaidaPortaria.getDocumento());
            pst.setString(7, pSaidaPortaria.getNomeUnidade());
            pst.setString(8, pSaidaPortaria.getConfirmaExp());
            pst.setString(9, pSaidaPortaria.getConfirmaImp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return pSaidaPortaria;
    }
    // TABELA DE DADOS DE VITÓRIA DA CONQUISTA

    public TransferenciaInternosPortaria incluirInternoPortariaVC(TransferenciaInternosPortaria pSaidaPortaria) {

        conectaVC.abrirConexao();
       try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES (Cnc,Matricula,NomeInterno,DataExp,"
                    + "HoraSaida,Documento,UnidadeOrigem,ConfirmadoExp,ConfirmadoImp) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pSaidaPortaria.getCncPortaria());
            pst.setString(2, pSaidaPortaria.getMatriculaCrc());
            pst.setString(3, pSaidaPortaria.getNomeInternoCrc());
            if (pSaidaPortaria.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(pSaidaPortaria.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, pSaidaPortaria.getHorarioSaida());
            pst.setString(6, pSaidaPortaria.getDocumento());
            pst.setString(7, pSaidaPortaria.getNomeUnidade());
            pst.setString(8, pSaidaPortaria.getConfirmaExp());
            pst.setString(9, pSaidaPortaria.getConfirmaImp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return pSaidaPortaria;
    }

    // TABELA DO BANCO DE DADOS DE SALVADOR
    public TransferenciaInternosPortaria incluirInternoPortariaSSA(TransferenciaInternosPortaria pSaidaPortaria) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES (Cnc,Matricula,NomeInterno,DataExp,"
                    + "HoraSaida,Documento,UnidadeOrigem,ConfirmadoExp,ConfirmadoImp) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pSaidaPortaria.getCncPortaria());
            pst.setString(2, pSaidaPortaria.getMatriculaCrc());
            pst.setString(3, pSaidaPortaria.getNomeInternoCrc());
            if (pSaidaPortaria.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(pSaidaPortaria.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, pSaidaPortaria.getHorarioSaida());
            pst.setString(6, pSaidaPortaria.getDocumento());
            pst.setString(7, pSaidaPortaria.getNomeUnidade());
            pst.setString(8, pSaidaPortaria.getConfirmaExp());
            pst.setString(9, pSaidaPortaria.getConfirmaImp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return pSaidaPortaria;
    }

    // CONJUNTO PENAL DE BARREIRAS
    public TransferenciaInternosPortaria incluirInternoPortariaBAR(TransferenciaInternosPortaria pSaidaPortaria) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES (Cnc,Matricula,NomeInterno,DataExp,"
                    + "HoraSaida,Documento,UnidadeOrigem,ConfirmadoExp,ConfirmadoImp) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pSaidaPortaria.getCncPortaria());
            pst.setString(2, pSaidaPortaria.getMatriculaCrc());
            pst.setString(3, pSaidaPortaria.getNomeInternoCrc());
            if (pSaidaPortaria.getDataSaida() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(pSaidaPortaria.getDataSaida().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, pSaidaPortaria.getHorarioSaida());
            pst.setString(6, pSaidaPortaria.getDocumento());
            pst.setString(7, pSaidaPortaria.getNomeUnidade());
            pst.setString(8, pSaidaPortaria.getConfirmaExp());
            pst.setString(9, pSaidaPortaria.getConfirmaImp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return pSaidaPortaria;
    }
}
