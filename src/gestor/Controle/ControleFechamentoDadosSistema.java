/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import gestor.Modelo.LogSistema;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleFechamentoDadosSistema {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_FINALIZADO = "ABERTO";

    //BLOQUEAR E DESBLOQUEAR O SISTEMA PARA FECHAMENTO DE REGISTROS.
    public FechamentoRegistros bloquearSistema(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARAMETROSCRC SET SistemaManutencao=?");
            pst.setString(1, objFecha.getOpcaoBloquear());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel BLOQUEAR O SISTEMA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //MÓDULO CRC
    public FechamentoRegistros fecharEntradas(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALOTE SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusEnt='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharSaidas(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("UPDATE SAIDACRC SET StatusSai=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusSai='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharTransferencias(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIACRC SET StatusTran=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusTran='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRetornoSaidaTemporaria(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOSCRC SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRetornoEspontaneo(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOESPONTANEO SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRecaptura(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RECAPTURA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRetornoAudiencia(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOAUDIENCIA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRetornoMedico(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOMEDICO SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharPrevisaoSaida(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PREVISAOSAIDA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusLanc='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    public FechamentoRegistros fecharRetornoPorTransferencia(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOTRANSFERENCIA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusRet='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    // MÓDULO PORTARIA
    public FechamentoRegistros fecharNovaEntrada(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADANOVA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE StatusLanc='" + pSTATUS_FINALIZADO + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
}
