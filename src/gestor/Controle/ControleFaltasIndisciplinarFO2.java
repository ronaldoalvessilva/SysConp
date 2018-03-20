/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FaltasIndisciplinarFO1;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleFaltasIndisciplinarFO2 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FaltasIndisciplinarFO1 objFaltas = new FaltasIndisciplinarFO1();

    int codigoInterno;

    public FaltasIndisciplinarFO1 incluirFaltasFO1(FaltasIndisciplinarFO1 objFaltas) {
        buscarInterno(objFaltas.getNomeInternoCrc(), objFaltas.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01 (IdReg,IdInternoCrc,Incitar,"
                    + "Fugir,Possuir,Provocar,Descumprir,Desobedecer,Recusar,Posse,PraticarFato,Realiza,PraticarAto,Dificultar,Circular,Fabricar,"
                    + "Fabricar2,Fisica,Impedir,Portar,Dificultar1,Improvisar,Induzir,Simular,Divulgar,Recusar1,Submeter,Deixar,UsuarioInsert,"
                    + "DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFaltas.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, objFaltas.getIncitar());
            pst.setInt(4, objFaltas.getFugir());
            pst.setInt(5, objFaltas.getPossuir());
            pst.setInt(6, objFaltas.getProvocar());
            pst.setInt(7, objFaltas.getDescumprir());
            pst.setInt(8, objFaltas.getDesobedecer());
            pst.setInt(9, objFaltas.getRecusar());
            pst.setInt(10, objFaltas.getPosse());
            pst.setInt(11, objFaltas.getPraticarFato());
            pst.setInt(12, objFaltas.getRealiza());
            pst.setInt(13, objFaltas.getPraticarAto());
            pst.setInt(14, objFaltas.getDificultar());
            pst.setInt(15, objFaltas.getCircular());
            pst.setInt(16, objFaltas.getFabricar());
            pst.setInt(17, objFaltas.getFabricar2());
            pst.setInt(18, objFaltas.getFisica());
            pst.setInt(19, objFaltas.getImpedir());
            pst.setInt(20, objFaltas.getPortar());
            pst.setInt(21, objFaltas.getDificultar1());
            pst.setInt(22, objFaltas.getImprovisar());
            pst.setInt(23, objFaltas.getInduzir());
            pst.setInt(24, objFaltas.getSimular());
            pst.setInt(25, objFaltas.getDivulgar());
            pst.setInt(26, objFaltas.getRecusar1());
            pst.setInt(27, objFaltas.getSubmeter());
            pst.setInt(28, objFaltas.getDeixar());
            pst.setString(29, objFaltas.getUsuarioInsert());
            pst.setString(30, objFaltas.getDataInsert());
            pst.setString(31, objFaltas.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFaltas;
    }

    public FaltasIndisciplinarFO1 alterarFaltasFO1(FaltasIndisciplinarFO1 objFaltas) {
        buscarInterno(objFaltas.getNomeInternoCrc(), objFaltas.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01 SET IdReg=?,IdInternoCrc=?,"
                    + "Incitar=?,Fugir=?,Possuir=?,Provocar=?,Descumprir=?,Desobedecer=?,Recusar=?,Posse=?,PraticarFato=?,Realiza=?,PraticarAto=?,"
                    + "Dificultar=?,Circular=?,Fabricar=?,Fabricar2=?,Fisica=?,Impedir=?,Portar=?,Dificultar1=?,Improvisar=?,Induzir=?,Simular=?,"
                    + "Divulgar=?,Recusar1=?,Submeter=?,Deixar=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFaltaFO1='" + objFaltas.getIdFaltaFO1() + "'");
            pst.setInt(1, objFaltas.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, objFaltas.getIncitar());
            pst.setInt(4, objFaltas.getFugir());
            pst.setInt(5, objFaltas.getPossuir());
            pst.setInt(6, objFaltas.getProvocar());
            pst.setInt(7, objFaltas.getDescumprir());
            pst.setInt(8, objFaltas.getDesobedecer());
            pst.setInt(9, objFaltas.getRecusar());
            pst.setInt(10, objFaltas.getPosse());
            pst.setInt(11, objFaltas.getPraticarFato());
            pst.setInt(12, objFaltas.getRealiza());
            pst.setInt(13, objFaltas.getPraticarAto());
            pst.setInt(14, objFaltas.getDificultar());
            pst.setInt(15, objFaltas.getCircular());
            pst.setInt(16, objFaltas.getFabricar());
            pst.setInt(17, objFaltas.getFabricar2());
            pst.setInt(18, objFaltas.getFisica());
            pst.setInt(19, objFaltas.getImpedir());
            pst.setInt(20, objFaltas.getPortar());
            pst.setInt(21, objFaltas.getDificultar1());
            pst.setInt(22, objFaltas.getImprovisar());
            pst.setInt(23, objFaltas.getInduzir());
            pst.setInt(24, objFaltas.getSimular());
            pst.setInt(25, objFaltas.getDivulgar());
            pst.setInt(26, objFaltas.getRecusar1());
            pst.setInt(27, objFaltas.getSubmeter());
            pst.setInt(28, objFaltas.getDeixar());
            pst.setString(29, objFaltas.getUsuarioUp());
            pst.setString(30, objFaltas.getDataUp());
            pst.setString(31, objFaltas.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFaltas;
    }

    public FaltasIndisciplinarFO1 excluirFaltasFO1(FaltasIndisciplinarFO1 objFaltas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01 WHERE IdFaltaFO1='" + objFaltas.getIdFaltaFO1() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFaltas;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
