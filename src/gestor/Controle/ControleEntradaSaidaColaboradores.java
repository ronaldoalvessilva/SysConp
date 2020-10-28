/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradasSaidasColaboradores;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jIdColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jCodigoPesqFunc;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jComboBoxUnidadeDestino;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jIdRegistro;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pTOTAL_registros;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pCODIGO_registro;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pCODIGO_colaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pUNIDADE_origem;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jComboBoxUnidadeOrigem;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pRESPOSTA_opcao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEntradaSaidaColaboradores {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradasSaidasColaboradores objEntraSaiFunc = new EntradasSaidasColaboradores();

    public EntradasSaidasColaboradores incluirRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_SAIDAS_COLABORADORES (StatusRegistro,DataRegistro,Operacao,TipoMovimento,UnidadeOrigem,UnidadeDestino,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEntradaSaidaCola.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntradaSaidaCola.getDataRegistro().getTime()));
            pst.setString(3, objEntradaSaidaCola.getOperacao());
            pst.setString(4, objEntradaSaidaCola.getTipoMovimento());
            pst.setString(5, objEntradaSaidaCola.getUnidadeOrigem());
            pst.setString(6, objEntradaSaidaCola.getUnidadeDestino());
            pst.setString(7, objEntradaSaidaCola.getMotivo());
            pst.setString(8, objEntradaSaidaCola.getUsuarioInsert());
            pst.setString(9, objEntradaSaidaCola.getDataInsert());
            pst.setString(10, objEntradaSaidaCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores alterarRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=?,DataRegistro=?,Operacao=?,TipoMovimento=?,UnidadeOrigem=?,UnidadeDestino=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegRegistro='" + objEntradaSaidaCola.getIdRegistro() + "'");
            pst.setString(1, objEntradaSaidaCola.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntradaSaidaCola.getDataRegistro().getTime()));
            pst.setString(3, objEntradaSaidaCola.getOperacao());
            pst.setString(4, objEntradaSaidaCola.getTipoMovimento());
            pst.setString(5, objEntradaSaidaCola.getUnidadeOrigem());
            pst.setString(6, objEntradaSaidaCola.getUnidadeDestino());
            pst.setString(7, objEntradaSaidaCola.getMotivo());
            pst.setString(8, objEntradaSaidaCola.getUsuarioUp());
            pst.setString(9, objEntradaSaidaCola.getDataUp());
            pst.setString(10, objEntradaSaidaCola.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores excluirRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAS_SAIDAS_COLABORADORES WHERE IdRegRegistro='" + objEntradaSaidaCola.getIdRegistro() + "'");
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores finalizarRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntradaSaidaCola.getIdRegistro() + "'");
            pst.setString(1, objEntradaSaidaCola.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores PESQUISAR_status(EntradasSaidasColaboradores objEntradaSaidaCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegRegistro,StatusRegistro "
                    + "FROM ENTRADAS_SAIDAS_COLABORADORES "
                    + "WHERE IdRegRegistro='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            objEntradaSaidaCola.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não foi possível verificar se lançamento foi finalizado.\nERROR: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

//------------------------------------------------- ITENS COLABORADORES --------------------------------------------------------------------------------
    public EntradasSaidasColaboradores incluirItensRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENTRADAS_SAIDAS_COLABORADORES (IdRegRegistro,IdFunc,DataEvento,DataRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objEntradaSaidaCola.getIdRegistro());
            pst.setInt(2, objEntradaSaidaCola.getIdColaborador());
            if (objEntradaSaidaCola.getDataEvento() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objEntradaSaidaCola.getDataEvento().getTime()));
            } else {
                pst.setDate(3, null);
            }
            if (objEntradaSaidaCola.getDataRetorno() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEntradaSaidaCola.getDataRegistro().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objEntradaSaidaCola.getUsuarioInsert());
            pst.setString(6, objEntradaSaidaCola.getDataInsert());
            pst.setString(7, objEntradaSaidaCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores alterarItensRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENTRADAS_SAIDAS_COLABORADORES SET IdRegRegistro=?,IdFunc=?,DataEvento=?,DataRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objEntradaSaidaCola.getIdItem() + "'");
            pst.setInt(1, objEntradaSaidaCola.getIdRegistro());
            pst.setInt(2, objEntradaSaidaCola.getIdColaborador());
            if (objEntradaSaidaCola.getDataEvento() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objEntradaSaidaCola.getDataEvento().getTime()));
            } else {
                pst.setDate(3, null);
            }
            if (objEntradaSaidaCola.getDataRetorno() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEntradaSaidaCola.getDataRegistro().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objEntradaSaidaCola.getUsuarioUp());
            pst.setString(6, objEntradaSaidaCola.getDataUp());
            pst.setString(7, objEntradaSaidaCola.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores excluirItensRegistroSaida(EntradasSaidasColaboradores objEntradaSaidaCola) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENTRADAS_SAIDAS_COLABORADORES WHERE IdItem='" + objEntradaSaidaCola.getIdItem() + "'");
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    //----------------------------- PESQUISAS ------------------------------------------------------
    public List<EntradasSaidasColaboradores> read() throws Exception {
        pTOTAL_registros = 0;
        List<EntradasSaidasColaboradores> listaTodasSaidasSimbolicas = new ArrayList<EntradasSaidasColaboradores>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegRegistro,StatusRegistro, "
                    + "DataRegistro,Operacao,TipoMovimento,UnidadeOrigem, "
                    + "UnidadeDestino,Motivo "
                    + "FROM ENTRADAS_SAIDAS_COLABORADORES");
            while (conecta.rs.next()) {
                EntradasSaidasColaboradores pENTRADA_saida = new EntradasSaidasColaboradores();
                pENTRADA_saida.setIdRegistro(conecta.rs.getInt("IdRegRegistro"));
                pENTRADA_saida.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pENTRADA_saida.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pENTRADA_saida.setOperacao(conecta.rs.getString("Operacao"));
                pENTRADA_saida.setTipoMovimento(conecta.rs.getString("TipoMovimento"));
                pENTRADA_saida.setUnidadeOrigem(conecta.rs.getString("UnidadeOrigem"));
                pENTRADA_saida.setUnidadeDestino(conecta.rs.getString("UnidadeDestino"));
                pENTRADA_saida.setMotivo(conecta.rs.getString("Motivo"));
                listaTodasSaidasSimbolicas.add(pENTRADA_saida);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaTodasSaidasSimbolicas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public EntradasSaidasColaboradores PESQUISAR_codigo(EntradasSaidasColaboradores objEntradaSaidaCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegRegistro "
                    + "FROM ENTRADAS_SAIDAS_COLABORADORES");
            conecta.rs.last();
            jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegRegistro")));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    //PESQUISAR UNIDADES
    public EntradasSaidasColaboradores PESQUISAR_unidades(EntradasSaidasColaboradores objEntradaSaidaCola) {
        jComboBoxUnidadeOrigem.removeAllItems();
        jComboBoxUnidadeDestino.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdUnidEmp, "
                    + "IdEmpresa,DescricaoUnidade "
                    + "FROM UNIDADE_PENAL_EMPRESA ");
            conecta.rs.first();
            do {
                jComboBoxUnidadeOrigem.addItem(conecta.rs.getString("DescricaoUnidade"));
                pUNIDADE_origem = conecta.rs.getInt("IdUnidEmp");
                jComboBoxUnidadeDestino.addItem(conecta.rs.getString("DescricaoUnidade"));
            } while (conecta.rs.next());
            jComboBoxUnidadeOrigem.updateUI();
            jComboBoxUnidadeDestino.updateUI();
        } catch (Exception ERROR) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores MOSTRAR_colaborador(EntradasSaidasColaboradores objEntradaSaidaCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegRegistro, "
                    + "StatusRegistro,DataRegistro, "
                    + "Operacao,TipoMovimento, "
                    + "UnidadeOrigem,UnidadeDestino,"
                    + "Motivo "
                    + "FROM ENTRADAS_SAIDAS_COLABORADORES "
                    + "WHERE IdRegRegistro='" + jCodigoPesqFunc.getText() + "' ");
            conecta.rs.first();
            objEntradaSaidaCola.setIdRegistro(conecta.rs.getInt("IdRegRegistro"));
            objEntradaSaidaCola.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
            objEntradaSaidaCola.setDataRegistro(conecta.rs.getDate("DataRegistro"));
            objEntradaSaidaCola.setOperacao(conecta.rs.getString("Operacao"));
            objEntradaSaidaCola.setTipoMovimento(conecta.rs.getString("TipoMovimento"));
            objEntradaSaidaCola.setUnidadeOrigem(conecta.rs.getString("UnidadeOrigem"));
            objEntradaSaidaCola.setUnidadeDestino(conecta.rs.getString("UnidadeDestino"));
            objEntradaSaidaCola.setMotivo(conecta.rs.getString("Motivo"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEntradaSaidaCola;
    }

    public EntradasSaidasColaboradores PESQUISAR_EXISTENCIA_colaborador(EntradasSaidasColaboradores objSaida) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegRegistro, "
                    + "IdFunc "
                    + "FROM ITENS_ENTRADAS_SAIDAS_COLABORADORES "
                    + "WHERE IdRegRegistro='" + jIdRegistro.getText() + "' "
                    + "AND IdFunc='" + jIdColaborador.getText() + "'");
            conecta.rs.first();
            pCODIGO_registro = conecta.rs.getString("IdRegRegistro");
            pCODIGO_colaborador = conecta.rs.getString("IdFunc");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objSaida;
    }         
}
