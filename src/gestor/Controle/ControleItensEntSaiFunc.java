/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DigitalColaborador;
import gestor.Modelo.ItensEntSaiFunc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntSaiFunc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntSaiFunc objItensFunc = new ItensEntSaiFunc();
    //
    int codFunc;
    String pBio = null;
    public static int count = 0;
    public static int qtdColaboradores = 0;
    String statusVisita = "Ativo";
    String statusRol = "ABERTO";

    public ItensEntSaiFunc incluirItensFunc(ItensEntSaiFunc objItensFunc) {
        buscarColaborador(objItensFunc.getNomeColaborador(), objItensFunc.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSENTRADASFUNC (IdFunc,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaEntrada) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codFunc);
            pst.setInt(2, objItensFunc.getIdlanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensFunc.getDataEntrada().getTime()));
            pst.setString(4, objItensFunc.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensFunc.getDataSaida().getTime()));
            pst.setString(6, objItensFunc.getHorarioSaida());
            pst.setString(7, objItensFunc.getUsuarioInsert());
            pst.setString(8, objItensFunc.getDataInsert());
            pst.setString(9, objItensFunc.getHoraInsert());
            pst.setBytes(10, objItensFunc.getAssinaturaEntradaColaborador());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do colaborador na tabela (ITENSENTRADAFUNC)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensFunc;
    }

    public ItensEntSaiFunc alterarItensFunc(ItensEntSaiFunc objItensFunc) {
        buscarColaborador(objItensFunc.getNomeColaborador(), objItensFunc.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADASFUNC SET IdFunc=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensFunc.getIdItem() + "'");
            pst.setInt(1, codFunc);
            pst.setInt(2, objItensFunc.getIdlanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensFunc.getDataEntrada().getTime()));
            pst.setString(4, objItensFunc.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensFunc.getDataSaida().getTime()));
            pst.setString(6, objItensFunc.getHorarioSaida());
            pst.setString(7, objItensFunc.getUsuarioUp());
            pst.setString(8, objItensFunc.getDataUp());
            pst.setString(9, objItensFunc.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFunc;
    }

    public ItensEntSaiFunc alterarItensFuncBiometria(ItensEntSaiFunc objItensFunc) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADASFUNC SET DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaSaida=? WHERE IdItem='" + objItensFunc.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensFunc.getDataSaida().getTime()));
            pst.setString(2, objItensFunc.getHorarioSaida());
            pst.setString(3, objItensFunc.getUsuarioUp());
            pst.setString(4, objItensFunc.getDataUp());
            pst.setString(5, objItensFunc.getHoraUp());
            pst.setBytes(6, objItensFunc.getAssinaturaEntradaColaborador());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensFunc;
    }

    public ItensEntSaiFunc excluirItensFunc(ItensEntSaiFunc objItensFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSENTRADASFUNC WHERE IdItem='" + objItensFunc.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFunc;
    }

    public ItensEntSaiFunc excluirTodosItensFunc(ItensEntSaiFunc objItensFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSENTRADASFUNC WHERE IdLanc='" + objItensFunc.getIdlanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFunc;
    }

    public void buscarColaborador(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + desc + "' AND IdFunc='" + cod + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (COLABORADOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<DigitalColaborador> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalColaborador> listaColaboradores = new ArrayList<DigitalColaborador>();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "INNER JOIN BIOMETRIA_COLABORADORES "
                    + "ON COLABORADOR.IdFunc=BIOMETRIA_COLABORADORES.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE BIOMETRIA_COLABORADORES.BiometriaDedo1!='" + pBio + "' "
                    + "AND COLABORADOR.StatusFunc='" + statusVisita + "' ");
            while (conecta.rs.next()) {
                DigitalColaborador pDigi = new DigitalColaborador();
                pDigi.setIdFunc(conecta.rs.getInt("IdFunc"));
//                pDigi.setMatricula(conecta.rs.getString("NomeFunc"));
                pDigi.setNomeFunc(conecta.rs.getString("NomeFunc"));
                pDigi.setFuncao(conecta.rs.getString("NomeCargo"));
                pDigi.setFotoColaborador(conecta.rs.getString("ImagemFunc"));
                pDigi.setDepartamento(conecta.rs.getString("NomeDepartamento"));
                pDigi.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigi.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigi.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigi.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                pDigi.setImagemFrenteOF(conecta.rs.getBytes("ImagemFrenteCO"));
                listaColaboradores.add(pDigi);
                qtdColaboradores++;
            }
            return listaColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
