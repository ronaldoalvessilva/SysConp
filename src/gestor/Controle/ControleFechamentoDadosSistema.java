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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADALOTE) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (SAIDACRC) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (TRANSFERENCIACRC) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RETORNOSCRC) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RETORNOESPONTANEO) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RECAPTURA) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RETORNOAUDIENCIA) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RETORNOMEDICO) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PREVISAOSAIDA) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (RETORNOTRANSFERENCIA) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (AGENDAESCOLTA) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (EVADIDOSIND) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PROGRESSAOREGIME) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGISTRO_CANCELADO_NE) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGISTRO_CANCELADO_RETORNOS) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGISTROCANCELADO) os Dados.\n\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGRESSAOREGIME) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    // MÓDULO PORTARIA
    // VISITAS RELIGIOSAS
    public FechamentoRegistros fecharVisitasReligiosas(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_VISITAS_RELIGIOSA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADA_SAIDA_VISITAS_RELIGIOSA)os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTTRADA PELA PRIMEIRA VEZ
    public FechamentoRegistros fecharEntradaInternosPortaria(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAINTERNOSPORTARIA)os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //NOVA ENTRADA
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADANOVA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA PERTENCES
    public FechamentoRegistros fecharEntradaPertences(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAPERTENCES SET SituacaoEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE SituacaoEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAPERTENCES) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA PERTENCES
    public FechamentoRegistros fecharEntradaOFJI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA_INTERNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAS_OFICIAL_JUSTICA_INTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADAS DE ADVOGADOS INTERNOS
    public FechamentoRegistros fecharEntradaADVI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASADVINTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADAS FAMILIAR AOS INTERNOS
    public FechamentoRegistros fecharEntradaFamiliar(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASADVINTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRENCIAS P1
    public FechamentoRegistros fecharOcorrenciasP1(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1 SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_P1) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PERNOITE DE INTERNOS - ANALISAR ANTES DE EXECUTAR
    public FechamentoRegistros fecharPernoiteInternos(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERNOITE_INTERNOS SET StatusRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRegistro='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistro<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PERNOITE_INTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PERNOITE DE INTERNOS - ANALISAR ANTES DE EXECUTAR
    public FechamentoRegistros fecharRegistroRetorno(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRETORNO SET StatusRet=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRet='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLancRetorno<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGRETORNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //REGISTRO SAIDA PORTARIA
    public FechamentoRegistros fecharSaidaPortaria(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGSAIDACRC SET StatusSai=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusSai='" + pSTATUS_FINALIZADO + "' "
                    + "AND DatalancaMov<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REGSAIDACRC) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //TRANSIENTES
    public FechamentoRegistros fecharTransientes(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSIENTES SET StatusTrans=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusTrans='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataTrans<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (TRANSIENTES) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA DE OFICIAL DE JUSTIÇA
    public FechamentoRegistros fecharOFF(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAS_OFICIAL_JUSTICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA ADVOGADO
    public FechamentoRegistros fecharADV(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVOGADOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASADVOGADOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA COLABORADORES
    public FechamentoRegistros fecharCOL(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFUNC SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASFUNC) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENTRADA VISITAS DIVERSAS
    public FechamentoRegistros fecharVD(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASVISITAS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASVISITAS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
    //ENTRADA VEICULOS DE CARGA
    public FechamentoRegistros fecharEVC(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOCARGA SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAVEICULOCARGA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
    //ENTRADA VEICULOS DE TERCEIROS
    public FechamentoRegistros fecharEVCt(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAVEICULOSTERCEIRO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
    //ENTRADA VEICULOS DA UNIDADE
    public FechamentoRegistros fecharEVCu(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAVEICULOSUNIDADE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
    //OCORRÊNCIAS PI EXTERNA
    public FechamentoRegistros fecharOCRP1e(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1E SET StatusEnt=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEnt='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc<='" + objFecha.getDataFechamento() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_P1E) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
}
