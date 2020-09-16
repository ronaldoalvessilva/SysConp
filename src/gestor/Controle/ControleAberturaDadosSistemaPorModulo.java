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
public class ControleAberturaDadosSistemaPorModulo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_FINALIZADO = "FINALIZADO";

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
                    + "AND DataLancaMov BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancaMov BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancTransf BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataAgenda BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataRegistro BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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

    //ENTRADA PELA PRIMEIRA VEZ
    public FechamentoRegistros fecharEntradaInternosPortaria(FechamentoRegistros objFecha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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

    //ENTRADA OFICIAL DE JUSTIÇA AOS INTERNOS
    public FechamentoRegistros fecharEntradaOFJI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA_INTERNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFAMILIAR SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADASFAMILIAR) os Dados.\n\nERRO: " + ex);
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataRegistro BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLancRetorno BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DatalancaMov BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataTrans BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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

    //OCORRÊNCIAS P1 EXTERNA
    public FechamentoRegistros fecharOCRP1e(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1E SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
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

    //MÓDULO ALMOXARIFADO
    //COMPOSIÇÃO DE KIT DE HIGIÊNE
    public FechamentoRegistros fecharALMOX(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET StatusComp=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusComp='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataComp BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ESTORNO DE SAIDA
    public FechamentoRegistros fecharESTORNO(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTORNO_PRODUTOS_AC SET StatusEst=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEst='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataEst BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ESTORNO_PRODUTOS_AC) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //NOTA FISCAL DE COMPRAS
    public FechamentoRegistros fecharNFC(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE NF_COMPRAS SET StatusNf=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusNf='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataEntrada BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (NF_COMPRAS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //REQUISAÇÃO AVULSA DE PRODUTOS
    public FechamentoRegistros fecharRAP(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS SET StatusReq=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusReq='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataReq BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REQUISICAO_AVULSA_PRODUTOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //REQUISIÇÃO PRODUTOS INTERNOS
    public FechamentoRegistros fecharRPI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS SET StatusReq=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusReq='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataReq BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (REQUISICAO_PRODUTOS_INTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //BASE
    //LOCAÇÃO DE INTERNOS
    public FechamentoRegistros fecharLOCA(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCACAOINTERNO SET StatusLoca=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLoca='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanca BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (LOCACAOINTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRENCIA BASE SEGURANÇA
    public FechamentoRegistros fecharOCRbs(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_BASE_SEGURANCA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRENCIA BASE SEGURANCA AUXILIAR
    public FechamentoRegistros fecharOCRbsa(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA_AUXILIAR SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_BASE_SEGURANCA_AUXILIAR) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ENFERMAGEM
    //ADMISSÃO ENFERMAGEM
    public FechamentoRegistros fecharADMEnfermagem(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOENFERMEIRA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAOENFERMEIRA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO ENFERMAGEM AUXILIAR
    public FechamentoRegistros fecharADMEnfermagemAux(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_ENFERMEIRA_COMPLEMENTAR SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_ENFERMEIRA_COMPLEMENTAR) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO MÉDICA
    public FechamentoRegistros fecharADMmedica(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOMEDICA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAOMEDICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO MÉDICA
    public FechamentoRegistros fecharADMmedicaAux(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_MEDICA_ADICIONAL SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_MEDICA_ADICIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //APRAZAMENTO DE MEDICAÇÃO
    public FechamentoRegistros fecharAPRAZAMENTO(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APRAZAMENTO_MEDICACAO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (APRAZAMENTO_MEDICACAO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO EM GRUPO ENFERMARIA
    public FechamentoRegistros fecharATGRUE(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_ENFERMAGEM SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_ENFERMAGEM) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO TÉCNICO ENFERMAGEM
    public FechamentoRegistros fecharATTENF(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTECENFERMAGEM SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOTECENFERMAGEM) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //AVALAIAÇÃO MÉDICA E PSIQUIATRICA
    public FechamentoRegistros fecharAVAMP(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_MEDICA_PSIQUIATRICA SET StatusAval=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAval='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAval BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (AVALIACAO_MEDICA_PSIQUIATRICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIA ENFERMARIA
    public FechamentoRegistros fecharOCEN(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_ME SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_ME) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //SOLICITAÇÃO DE EXAMES
    public FechamentoRegistros fecharSOLIX(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO SET StatusSolExame=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusSolExame='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataSolExame BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //GERENCIA ADMINISTRATIVA
    //ATIVIDADES REALIZADAS MENSALMENTE
    public FechamentoRegistros fecharATIVI_realizadas(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtividade='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataCriacao BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENCIMENTO JURIDICO
    public FechamentoRegistros fecharATEND_JURI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOJURIDICO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOJURIDICO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO JURIDICO ADICIONAL
    public FechamentoRegistros fecharADM_JURI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_JURIDICO_ADICIONAL SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_JURIDICO_ADICIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO FAMILIAR JURIDICO
    public FechamentoRegistros fecharATEND_FAM_JURI(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIARJURIDICO SET StatusAtendf=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendf='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtendf BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOFAMILIARJURIDICO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //FICHA JURIDICA
    public FechamentoRegistros fecharFICHA_juri(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_JURIDICA SET StatusFicha=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusFicha='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataFicha BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (FICHA_JURIDICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PAGAMENTO DE KIT DE HIGIENE
    public FechamentoRegistros fecharPAGTO_kit(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PAGAMENTO_KIT_INTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO ODONTOLOGICO
    public FechamentoRegistros fecharATEND_odonto(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTODONTO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTODONTO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIA ODONTOLOGICO
    public FechamentoRegistros fecharOCORRE_odonto(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_OD SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_OD) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSAO PEDAGOGICA
    public FechamentoRegistros fecharADM_peda(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA SET StatusAdm=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAdm='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAdm BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_PEDAGOGIA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSAO PEDAGOGICA NOVA
    public FechamentoRegistros fecharADM_pedaNova(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA_NOVA SET StatusAdm=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAdm='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAdm BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_PEDAGOGIA_NOVA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO EM GRUPO PEDAGOGIA
    public FechamentoRegistros fecharATM_GRUPO_peda(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PE SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_PE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATIVIDADES COMPLEMENTARES
    public FechamentoRegistros fecharATV_complementar(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET StatusAC=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAC='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAC BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_COMPLEMENTARES_PEDAGOGICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //CONTROLE DE FREQUENCIA EXTERNA
    public FechamentoRegistros fecharFrequencia(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_PEDAGOGIA_EXTERNA SET StatusFreqLab=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusFreqLab='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataFreqLab BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (FREQUENCIA_PEDAGOGIA_EXTERNA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO PSICOLOGICA
    public FechamentoRegistros fecharADM_psi(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOPSI SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAOPSI) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO EM GRUPO PSICOLOGICA
    public FechamentoRegistros fecharATG_psi(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PSICOLOGIA SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_PSICOLOGIA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //AVALIAÇÃO PSICOLOGICA
    public FechamentoRegistros fecharAVA_psi(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAOPSI SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (AVALIACAOPSI) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIA PSICOLOGICA
    public FechamentoRegistros fecharOCO_psi(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_PSI SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_PSI) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PORTA DE ENTRADA PSICOLOGICA
    public FechamentoRegistros fecharPORTA_psi(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_PSICOLOGIA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PORTA_ENTRADA_PSICOLOGIA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //MOVIMENTO POPULAÇÃO
    public FechamentoRegistros fecharMOVPOP_seg(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVPOPULACAO SET StatusPop=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusPop='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataPopMov BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (MOVPOPULACAO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIAS SEGURANÇA
    public FechamentoRegistros fecharOCORR_seg(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIASEGURANCA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIASEGURANCA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //SERVIÇO SOCIAL
    //ATENDIMENTO EM GRUPO
    public FechamentoRegistros fecharATEND_grupoSS(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_SS SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_SS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO FAMILIAR
    public FechamentoRegistros fecharATEND_famSS(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIAR SET StatusAtendf=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendf='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtendf BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOFAMILIAR) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTOSOCIAL
    public FechamentoRegistros fecharATEND_social(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET StatusAtend=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtend='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOSOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATUALIZAÇÃO DOCUMENTOS DE INTERNOS
    public FechamentoRegistros fecharATUALIZACAO_documentos(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZACAO_DOCUMENTOS_INTERNOS SET StatusDoc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusDoc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATUALIZACAO_DOCUMENTOS_INTERNOS) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //CANCELAMENTO DE VISITAS EXTERNA AOS INTERNOS
    public FechamentoRegistros fecharCANCELA_visita(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL SET StatusCan=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusCan='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataCan BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //CONTROLE DE LIGAÇÕES
    public FechamentoRegistros fecharCONTROLE_ligacoes(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTROLIGA SET StatusControl=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusControl='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataControl BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (CONTROLIGA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIAS SERVIÇO SOCIAL
    public FechamentoRegistros fecharOCORR(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_SERVICO_SOCIAL SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PERFIL CARCERÁRIO
    public FechamentoRegistros fecharPERFIL(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusPerfil='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataPerfil BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PERFIL_CARCERARIO_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //PORTA DE ENTRADA
    public FechamentoRegistros fecharPORTA(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_SERVICO_SOCIAL SET StatusAtend=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtend='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PORTA_ENTRADA_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //TERAPIA OCUPACIONAL
    //ADMISSÃO TERAPIA 
    public FechamentoRegistros fecharADM_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_TERAPIA_PE SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_TERAPIA_PE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //AGENDA LABORATIVA
    public FechamentoRegistros fecharAGENDA_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDALABORATIVA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataCadastro BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (AGENDALABORATIVA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO EM GRUPO
    public FechamentoRegistros fecharATENDE_GRU_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_TO SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_TO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO TERAPIA
    public FechamentoRegistros fecharATENDE_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTERAPIA SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTOTERAPIA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //CAPACITAÇÃO INTERNO
    public FechamentoRegistros fecharCAPACITA_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CAPACITACAO_INTERNO_TO SET StatusRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRegistro='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistro BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (CAPACITACAO_INTERNO_TO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //FREQUENCIA CAPACITAÇÃO DE INTERNO
    public FechamentoRegistros fecharFREQUENTA_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_CAPACITACAO_INTERNO_TO SET StatusRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusRegistro='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistro BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (FREQUENCIA_CAPACITACAO_INTERNO_TO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //FREQUENCIA LABORATIVA DE INTERNO
    public FechamentoRegistros fecharFREQUENTA_labor_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_LABORATIVA_EXTERNA SET StatusFreqLab=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusFreqLab='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataFreqLab BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (FREQUENCIA_LABORATIVA_EXTERNA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIAS
    public FechamentoRegistros fecharOCORR_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_TO SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_TO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //TRIAGEM OCUPACIONAL
    public FechamentoRegistros fecharTRIAGEM_to(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRIAGEM_OCUPACIONAL SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (TRIAGEM_OCUPACIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //EDUCAÇÃO FISICA
    //ADMISSAÕ EDUCAÇÃO FISICA
    public FechamentoRegistros fecharADM_ef(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_EDUCACAO_FISICA SET StatusEF=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEF='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistroEF BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_EDUCACAO_FISICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ADMISSÃO EDUCAÇÃO FISICA NOVA
    public FechamentoRegistros fecharADM_EF_nova(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_EDUCACAO_FISICA_NOVA SET StatusEF=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusEF='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataRegistroEF BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ADMISSAO_EDUCACAO_FISICA_NOVA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //ATENDIMENTO EM GRUPO
    public FechamentoRegistros fecharATEND_GRUPO_ef(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_EF SET StatusAtendGrupo=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusAtendGrupo='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataAtend BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATENDIMENTO_GRUPO_EF) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }

    //OCORRÊNCIAS
    public FechamentoRegistros fecharOCORRE_ef(FechamentoRegistros objFecha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_EF SET StatusLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE StatusLanc='" + pSTATUS_FINALIZADO + "' "
                    + "AND DataLanc BETWEEN'" + objFecha.getDataInicial() + "' "
                    + "AND'" + objFecha.getDataFinal() + "'");
            pst.setString(1, objFecha.getStatusRegistro());
            pst.setString(2, objFecha.getUsuarioUp());
            pst.setString(3, objFecha.getDataFechamento());
            pst.setString(4, objFecha.getHoraFechamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (OCORRENCIAS_EF) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFecha;
    }
}
