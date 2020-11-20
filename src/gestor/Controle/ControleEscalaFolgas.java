/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalaFolgas;
import static gestor.Visao.TelaCronogramaEscala.d4;
import static gestor.Visao.TelaEscalaFolgas.jCodigoPesqEscala;
import static gestor.Visao.TelaEscalaFolgas.pRESPOSTA_opcao;
import static gestor.Visao.TelaEscalaFolgas.jIdRegistro;
import static gestor.Visao.TelaEscalaFolgas.pDESCRICAO_escala;
import static gestor.Visao.TelaEscalaFolgas.pQUANTIDADE_trabalho;
import static gestor.Visao.TelaFuncionarios.pRESPOSTA_escala;
import static gestor.Visao.TelaFuncionarios.pID_ESCALA;
import static gestor.Visao.TelaFuncionarios.jCodigoPesqFunc;
import static gestor.Visao.TelaFuncionarios.pCODIGO_colaborador;
import static gestor.Visao.TelaCronogramaEscala.pRESPOSTA_crono;
import static gestor.Visao.TelaCronogramaEscala.pDATA_cronograma;
import static gestor.Visao.TelaCronogramaEscala.pTOTAL_REGISTROS_crono;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEscalaFolgas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalaFolgas objEscalas = new EscalaFolgas();

    String pDATA_pesquisa;
    String pDATA_grava;

    public EscalaFolgas incluirEscalaTrabalaho(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESCALA_TRABALHO (StatusEscala,DataCadastro,DescricaoEscala,QuantidadeTrab,QuantidadeFolga,Turno,Turma,HorarioInicial,HorarioFinal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEscalas.getStatusEscala());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscalas.getDataCadastro().getTime()));
            pst.setString(3, objEscalas.getDescricaoEscala());
            pst.setInt(4, objEscalas.getQuantidadeTrab());
            pst.setInt(5, objEscalas.getQuantidadeFolga());
            pst.setString(6, objEscalas.getTurno());
            pst.setString(7, objEscalas.getTurma());
            pst.setString(8, objEscalas.getHorarioInicial());
            pst.setString(9, objEscalas.getHorarioFinal());
            pst.setString(10, objEscalas.getUsuarioInsert());
            pst.setString(11, objEscalas.getDataInsert());
            pst.setString(12, objEscalas.getHorarioInsert());
            pst.execute();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas alterarEscalaTrabalaho(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCALA_TRABALHO SET StatusEscala=?,DataCadastro=?,DescricaoEscala=?,QuantidadeTrab=?,QuantidadeFolga=?,Turno=?,Turma=?,HorarioInicial=?,HorarioFinal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistro='" + objEscalas.getIdRegistro() + "'");
            pst.setString(1, objEscalas.getStatusEscala());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscalas.getDataCadastro().getTime()));
            pst.setString(3, objEscalas.getDescricaoEscala());
            pst.setInt(4, objEscalas.getQuantidadeTrab());
            pst.setInt(5, objEscalas.getQuantidadeFolga());
            pst.setString(6, objEscalas.getTurno());
            pst.setString(7, objEscalas.getTurma());
            pst.setString(8, objEscalas.getHorarioInicial());
            pst.setString(9, objEscalas.getHorarioFinal());
            pst.setString(10, objEscalas.getUsuarioUp());
            pst.setString(11, objEscalas.getDataUp());
            pst.setString(12, objEscalas.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_opcao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_opcao = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas excluirEscalaTrabalaho(EscalaFolgas objEscalas) {

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

    public EscalaFolgas MOSTRAR_escala(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "StatusEscala,DataCadastro, "
                    + "QuantidadeTrab,QuantidadeFolga, "
                    + "DescricaoEscala,Turno,"
                    + "Turma,HorarioInicial,HorarioFinal  "
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
            objEscalas.setHorarioInicial(conecta.rs.getString("HorarioInicial"));
            objEscalas.setHorarioFinal(conecta.rs.getString("HorarioFinal"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas PESQUISAR_codigo(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro "
                    + "FROM ESCALA_TRABALHO");
            conecta.rs.last();
            jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegistro")));
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro\n" + ERROR);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas PESQUISAR_escala(EscalaFolgas objEscalas) {
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

    //----------------------------- TELA FUNCIONÁRIOS ESCALA DE TRABALHO E FOLGAS -----------------------
    public EscalaFolgas incluirEscalaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT ESCALA_TRABALHO_FOLGA_COLABORADOR (IdRegistro,IdFunc,QuantidadeTrab,QuantidadeFolga,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objEscalas.getIdRegistro());
            pst.setInt(2, objEscalas.getIdFunc());
            pst.setInt(3, objEscalas.getQuantidadeTrab());
            pst.setInt(4, objEscalas.getQuantidadeFolga());
            pst.setString(5, objEscalas.getUsuarioInsert());
            pst.setString(6, objEscalas.getDataInsert());
            pst.setString(7, objEscalas.getHorarioInsert());
            pst.execute();
            pRESPOSTA_escala = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_escala = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas alterarEscalaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCALA_TRABALHO_FOLGA_COLABORADOR SET IdRegistro=?,IdFunc=?,QuantidadeTrab=?,QuantidadeFolga=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEscala='" + objEscalas.getIdEscala() + "'");
            pst.setInt(1, objEscalas.getIdRegistro());
            pst.setInt(2, objEscalas.getIdFunc());
            pst.setInt(3, objEscalas.getQuantidadeTrab());
            pst.setInt(4, objEscalas.getQuantidadeFolga());
            pst.setString(5, objEscalas.getUsuarioUp());
            pst.setString(6, objEscalas.getDataUp());
            pst.setString(7, objEscalas.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_escala = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_escala = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas excluirEscalaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESCALA_TRABALHO_FOLGA_COLABORADOR WHERE IdEscala='" + objEscalas.getIdEscala() + "'");
            pst.executeUpdate();
            pRESPOSTA_escala = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_escala = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas PESQUISAR_CODIGO_escala(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdEscala "
                    + "FROM ESCALA_TRABALHO_FOLGA_COLABORADOR");
            conecta.rs.last();
            pID_ESCALA = conecta.rs.getInt("IdEscala");
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro\n" + ERROR);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas MOSTRAR_CODIGO_ESCALA_func(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdEscala, "
                    + "IdRegistro, "
                    + "IdFunc "
                    + "FROM ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "WHERE IdFunc='" + jCodigoPesqFunc.getText() + "'");
            conecta.rs.first();
            pCODIGO_colaborador = conecta.rs.getInt("IdFunc");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
        return objEscalas;
    }

    //--------------------------------------  CRONOGRAMA DE ESCALA DE TRABALHO E FOLGA ----------------------------
    public EscalaFolgas incluirCronogramaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR (IdRegistro,IdEscala,IdFunc,DataCronograma,StatusTrabFolga,DataInicial,DataFinal,DataPrimeiraFolga,PrimeiroApt,SegundoApt) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEscalas.getIdRegistro());
            pst.setInt(2, objEscalas.getIdEscala());
            pst.setInt(3, objEscalas.getIdFunc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEscalas.getDataCronograma().getTime()));
            pst.setString(5, objEscalas.getStatusTrabFolga());
            pst.setTimestamp(6, new java.sql.Timestamp(objEscalas.getDataInicial().getTime()));
            pst.setTimestamp(7, new java.sql.Timestamp(objEscalas.getDataFinal().getTime()));
            if (objEscalas.getDataPrimeiraFolga() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objEscalas.getDataPrimeiraFolga().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objEscalas.getPrimeiroApt());
            pst.setString(10, objEscalas.getSegundoApt());
            pst.execute();
            pRESPOSTA_crono = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_crono = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas alterarCronogramaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR SET IdRegistro=?,IdEscala=?,IdFunc=?,DataCronograma=?,StatusTrabFolga=?,DataInicial=?,DataFinal=?,DataPrimeiraFolga=?,PrimeiroApt=?,SegundoApt=? WHERE IdCrono='" + objEscalas.getIdCrono() + "'");
            pst.setInt(1, objEscalas.getIdRegistro());
            pst.setInt(2, objEscalas.getIdEscala());
            pst.setInt(3, objEscalas.getIdFunc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEscalas.getDataCronograma().getTime()));
            pst.setString(5, objEscalas.getStatusTrabFolga());
            pst.setTimestamp(6, new java.sql.Timestamp(objEscalas.getDataInicial().getTime()));
            pst.setTimestamp(7, new java.sql.Timestamp(objEscalas.getDataFinal().getTime()));
            if (objEscalas.getDataPrimeiraFolga() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objEscalas.getDataPrimeiraFolga().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objEscalas.getPrimeiroApt());
            pst.setString(10, objEscalas.getSegundoApt());
            pst.executeUpdate();
            pRESPOSTA_crono = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_crono = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas excluirCronogramaTrabalhoFolga(EscalaFolgas objEscalas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR WHERE IdCrono='" + objEscalas.getIdCrono() + "'");
            pst.executeUpdate();
            pRESPOSTA_crono = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_crono = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas alterarStatusCronogramaTrabalhoFolga(EscalaFolgas objEscalas) {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        pDATA_grava = formatoAmerica.format(objEscalas.getDataCronograma());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR SET StatusTrabFolga=? WHERE IdFunc='" + objEscalas.getIdFunc() + "' AND DataCronograma='" + pDATA_grava + "'");
            pst.setString(1, objEscalas.getStatusTrabFolga());
            pst.executeUpdate();
            ++pTOTAL_REGISTROS_crono;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    //
    public EscalaFolgas PESQUISAR_DATA_Folga(EscalaFolgas objEscalas) {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        pDATA_pesquisa = formatoAmerica.format(d4);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdFunc, "
                    + "DataCronograma "
                    + "FROM CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "WHERE DataCronograma='" + pDATA_pesquisa + "'");
            conecta.rs.first();
            pDATA_cronograma = conecta.rs.getDate("DataCronograma");

        } catch (Exception ERROR) {
        }
        conecta.desconecta();
        return objEscalas;
    }
}
