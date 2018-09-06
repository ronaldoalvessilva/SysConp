/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DigitalColaborador;
import gestor.Modelo.ItensTransientes;
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
public class ControleItensTransientes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensTransientes objItensTransi = new ItensTransientes();

    int codigoTransiente;
    String pBio = null;
    public static int count = 0;
    public static int qtdColaboradores = 0;
    String statusVisita = "Ativo";

    public ItensTransientes incluirItensTransientes(ItensTransientes objItensTransi) {
        if (objItensTransi.getTipoTrans() == 0) {
            buscarAdvogado(objItensTransi.getNomeAdvogado(), objItensTransi.getIdAdvogado());
        } else if (objItensTransi.getTipoTrans() == 1) {
            buscarColaborador(objItensTransi.getNomeColaborador(), objItensTransi.getIdFunc());
        } else if (objItensTransi.getTipoTrans() == 2) {
            buscarVisitasDiversas(objItensTransi.getNomeVisitaDiversa(), objItensTransi.getIdVisitaDiversas());
        } else if (objItensTransi.getTipoTrans() == 3) {
            buscarOficialJustica(objItensTransi.getNomeOficial(), objItensTransi.getIdOficial());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_TRANSIENTES_VISITAS_DIVERSAS (IdTrans,IdCodigo,TipoTrans,Destino,Motivo,DataEntrada,HoraEntrada,DataSaida,HoraSaida,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaEntrada) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensTransi.getIdTrans());
            pst.setInt(2, codigoTransiente);
            pst.setInt(3, objItensTransi.getTipoTrans());
            pst.setString(4, objItensTransi.getDestino());
            pst.setString(5, objItensTransi.getMotivo());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensTransi.getDataEntrada().getTime()));
            pst.setString(7, objItensTransi.getHoraEntrada());
            pst.setTimestamp(8, new java.sql.Timestamp(objItensTransi.getDataSaida().getTime()));
            pst.setString(9, objItensTransi.getHoraSaida());
            pst.setString(10, objItensTransi.getUsuarioInsert());
            pst.setString(11, objItensTransi.getDataInsert());
            pst.setString(12, objItensTransi.getHorarioInsert());
            pst.setBytes(13, objItensTransi.getAssinaturaEntradaColaborador());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTransi;
    }

    public ItensTransientes alterarItensTransientes(ItensTransientes objItensTransi) {
        if (objItensTransi.getTipoTrans() == 0) {
            buscarAdvogado(objItensTransi.getNomeAdvogado(), objItensTransi.getIdAdvogado());
        } else if (objItensTransi.getTipoTrans() == 1) {
            buscarColaborador(objItensTransi.getNomeColaborador(), objItensTransi.getIdFunc());
        } else if (objItensTransi.getTipoTrans() == 2) {
            buscarVisitasDiversas(objItensTransi.getNomeVisitaDiversa(), objItensTransi.getIdVisitaDiversas());
        } else if (objItensTransi.getTipoTrans() == 3) {
            buscarOficialJustica(objItensTransi.getNomeOficial(), objItensTransi.getIdOficial());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_TRANSIENTES_VISITAS_DIVERSAS SET IdTrans=?,IdCodigo=?,TipoTrans=?,Destino=?,Motivo=?,DataEntrada=?,HoraEntrada=?,DataSaida=?,HoraSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaSaida=? WHERE IdItem='" + objItensTransi.getIdItens() + "'");
            pst.setInt(1, objItensTransi.getIdTrans());
            pst.setInt(2, codigoTransiente);
            pst.setInt(3, objItensTransi.getTipoTrans());
            pst.setString(4, objItensTransi.getDestino());
            pst.setString(5, objItensTransi.getMotivo());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensTransi.getDataEntrada().getTime()));
            pst.setString(7, objItensTransi.getHoraEntrada());
            pst.setTimestamp(8, new java.sql.Timestamp(objItensTransi.getDataSaida().getTime()));
            pst.setString(9, objItensTransi.getHoraSaida());
            pst.setString(10, objItensTransi.getUsuarioUp());
            pst.setString(11, objItensTransi.getDataUp());
            pst.setString(12, objItensTransi.getHorarioUp());
            pst.setBytes(13, objItensTransi.getAssinaturaEntradaColaborador());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTransi;
    }

    public ItensTransientes alterarItensTransientesBiometria(ItensTransientes objItensTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_TRANSIENTES_VISITAS_DIVERSAS SET DataSaida=?,HoraSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaSaida=? WHERE IdItem='" + objItensTransi.getIdItens() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensTransi.getDataSaida().getTime()));
            pst.setString(2, objItensTransi.getHoraSaida());
            pst.setString(3, objItensTransi.getUsuarioUp());
            pst.setString(4, objItensTransi.getDataUp());
            pst.setString(5, objItensTransi.getHorarioUp());
            pst.setBytes(6, objItensTransi.getAssinaturaEntradaColaborador());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTransi;
    }

    public ItensTransientes excluirItensTransientes(ItensTransientes objItensTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS WHERE IdItem='" + objItensTransi.getIdItens() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTransi;
    }

    public void buscarAdvogado(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADVOGADOS WHERE NomeAdvogado='" + nome + "'AND IdAdvogado='" + codigo + "'");
            conecta.rs.first();
            codigoTransiente = conecta.rs.getInt("IdAdvogado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (ADVOGADO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarColaborador(String nomeFunc, int codigoFunc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nomeFunc + "'AND IdFunc='" + codigoFunc + "'");
            conecta.rs.first();
            codigoTransiente = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (COLABORADOR) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarVisitasDiversas(String nomeVisita, int codigoVisita) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE NomeVisita='" + nomeVisita + "' AND IdVisita='" + codigoVisita + "'");
            conecta.rs.first();
            codigoTransiente = conecta.rs.getInt("IdVisita");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (VISITAS DIVERSAS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarOficialJustica(String nomeOficial, int codigoOficial) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OFICIAL_JUSTICA WHERE NomeOficial='" + nomeOficial + "' AND IdOficial='" + codigoOficial + "'");
            conecta.rs.first();
            codigoTransiente = conecta.rs.getInt("IdOficial");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (OFICIAL DE JUSTIÇA) a serem exibidos !!!");
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
                pDigi.setMatricula(conecta.rs.getString("MatriculaFunc"));
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
