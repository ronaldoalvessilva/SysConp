/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALOTE SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancaMov<='" + objFecha.getDataFechamento() + "'");
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
            pst = conecta.con.prepareStatement("UPDATE SAIDACRC SET StatusSai=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusSai='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancaMov<='" + objFecha.getDataFechamento() + "'");
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
            pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIACRC SET StatusTran=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusTran='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancTransf<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOSCRC SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOESPONTANEO SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RECAPTURA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOAUDIENCIA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOMEDICO SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PREVISAOSAIDA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOTRANSFERENCIA SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharAgendaEscolta(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDAESCOLTA SET StatusAgenda=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAgenda='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAgenda<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharEvadidos(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVADIDOSIND SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharProgressaoRegime(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROGRESSAOREGIME SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharProrrogacao_SAIDA_tmp(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR SET StatusRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRegistro='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistro<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharRegistroCanceladoNE(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_NE SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharRegistroCanceladoRetorno(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_RETORNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharRegistroCancelado(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTROCANCELADO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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

    public FechamentoRegistros fecharRegressaoRegime(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRESSAOREGIME SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADANOVA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
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
