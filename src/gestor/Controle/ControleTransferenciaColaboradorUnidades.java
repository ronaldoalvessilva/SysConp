/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.ColaboradoresTransferenciasUnidades;
import gestor.Modelo.EntradasSaidasColaboradores;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.jComboBoxCargoPesquisa;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.jComboBoxDepartamentoPesquisa;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pNOME_colaborador;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pNOME_MAE_colaborador;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_LF_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_SSA_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_ITB_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_BAR_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_VC_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_LH_reposta;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_FI_reposta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleTransferenciaColaboradorUnidades {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    EntradasSaidasColaboradores objEntraSaiFunc = new EntradasSaidasColaboradores();
    //
    int codCargo;
    int codDepto;

    // -------------------------------------------------------- UNIDADE DE LAURO DE FREITAS ------------------------------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorLF(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoLF(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoLF(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_LF_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LF_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorLF(ColaboradoresTransferenciasUnidades objCola) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_LF_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LF_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorLF(ColaboradoresTransferenciasUnidades objCola) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_LF_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LF_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaborador(ColaboradoresTransferenciasUnidades objCola) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_LF_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LF_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorLF(EntradasSaidasColaboradores objEntraSaiFunc) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objEntraSaiFunc;
    }

    public ColaboradoresTransferenciasUnidades FINALIZAR_ColaboradorLF(ColaboradoresTransferenciasUnidades objCola) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL LAURO DE FREITAS --------------------------------------------------
    public void pPESQUISAR_colaboradorLF(String pNOME_func, String pNOME_mae) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaLF.rs.first();
            pNOME_colaborador = conectaLF.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaLF.rs.getString("NomeMae");
            pRESPOSTA_LF_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LF_reposta = "Não";
        }
        conectaLF.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoLF(String nome) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaLF.rs.first();
            codCargo = conectaLF.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conectaLF.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoLF(String nome) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaLF.rs.first();
            codDepto = conectaLF.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conectaLF.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoLF(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM CARGOS");
            conectaLF.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaLF.rs.getString("NomeCargo"));
            } while (conectaLF.rs.next());
        } catch (SQLException ex) {
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoLF(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conectaLF.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conectaLF.rs.getString("NomeDepartamento"));
            } while (conectaLF.rs.next());
        } catch (SQLException ex) {
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoLF(ColaboradoresTransferenciasUnidades objCola) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conectaLF.rs.last();
            objCola.setIdFunc(conectaLF.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conectaLF.desconecta();
        return objCola;
    }

    // -------------------------------------------------------- UNIDADE PRISIONAL DE SALVADOR ------------------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoSSA(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoSSA(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,"
                    + "MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,"
                    + "NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,"
                    + "RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,"
                    + "Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            if (objCola.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_SSA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_SSA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_SSA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_SSA_reposta = "Não";
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_SSA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_SSA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_SSA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_SSA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL SALVADOR --------------------------------------------------
    public void pPESQUISAR_colaboradorSSA(String pNOME_func, String pNOME_mae) {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaSSA.rs.first();
            pNOME_colaborador = conectaSSA.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaSSA.rs.getString("NomeMae");
            pRESPOSTA_SSA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_SSA_reposta = "Não";
        }
        conectaSSA.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoSSA(String nome) {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaSSA.rs.first();
            codCargo = conectaSSA.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conectaSSA.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoSSA(String nome) {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaSSA.rs.first();
            codDepto = conectaSSA.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conectaSSA.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoSSA(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM CARGOS");
            conectaSSA.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaSSA.rs.getString("NomeCargo"));
            } while (conectaSSA.rs.next());
        } catch (SQLException ex) {
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoSSA(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conectaSSA.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conectaSSA.rs.getString("NomeDepartamento"));
            } while (conectaSSA.rs.next());
        } catch (SQLException ex) {
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoSSA(ColaboradoresTransferenciasUnidades objCola) {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conectaSSA.rs.last();
            objCola.setIdFunc(conectaSSA.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorSSA(EntradasSaidasColaboradores objEntraSaiFunc) {
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objEntraSaiFunc;
    }

    public ColaboradoresTransferenciasUnidades FINALIZAR_ColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    //------------------------------------------------- UNIDADE PRISIONAL VITÓRIA DA CONQUISTA ---------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorVC(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoVC(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoVC(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_VC_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_VC_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaboradorVC(ColaboradoresTransferenciasUnidades objCola) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_VC_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_VC_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorVC(ColaboradoresTransferenciasUnidades objCola) {
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_VC_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_VC_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorVC(ColaboradoresTransferenciasUnidades objCola) {
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_VC_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_VC_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL VITÓRIA DA CONQUISTA --------------------------------------------------
    public void pPESQUISAR_colaboradorVC(String pNOME_func, String pNOME_mae) {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaVC.rs.first();
            pNOME_colaborador = conectaVC.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaVC.rs.getString("NomeMae");
            pRESPOSTA_VC_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_VC_reposta = "Não";
        }
        conectaVC.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoVC(String nome) {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaVC.rs.first();
            codCargo = conectaVC.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conectaVC.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoVC(String nome) {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaVC.rs.first();
            codDepto = conectaVC.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conectaVC.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoVC(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM CARGOS");
            conectaVC.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaVC.rs.getString("NomeCargo"));
            } while (conectaVC.rs.next());
        } catch (SQLException ex) {
        }
        conectaVC.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoVC(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conectaVC.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conectaVC.rs.getString("NomeDepartamento"));
            } while (conectaVC.rs.next());
        } catch (SQLException ex) {
        }
        conectaVC.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoVC(ColaboradoresTransferenciasUnidades objCola) {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conectaVC.rs.last();
            objCola.setIdFunc(conectaVC.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conectaVC.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorVC(EntradasSaidasColaboradores objEntraSaiFunc) {
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objEntraSaiFunc;
    }

    public ColaboradoresTransferenciasUnidades FINALIZAR_ColaboradorVC(ColaboradoresTransferenciasUnidades objCola) {
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    //--------------------------------------------------- UNIDADE DE ITABUNA -------------------------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorITB(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoITB(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoITB(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_ITB_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_ITB_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
        }
        conectaITB.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorITB(ColaboradoresTransferenciasUnidades objCola) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_ITB_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_ITB_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorITB(ColaboradoresTransferenciasUnidades objCola) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_ITB_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_ITB_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaboradorITB(ColaboradoresTransferenciasUnidades objCola) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_ITB_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_ITB_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorITB(EntradasSaidasColaboradores objEntraSaiFunc) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR(FINALIZAR) os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objEntraSaiFunc;
    }

    public ColaboradoresTransferenciasUnidades FINALIZAR_ColaboradorITB(ColaboradoresTransferenciasUnidades objCola) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL ITABUNA --------------------------------------------------
    public void pPESQUISAR_colaboradorITB(String pNOME_func, String pNOME_mae) {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaITB.rs.first();
            pNOME_colaborador = conectaITB.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaITB.rs.getString("NomeMae");
            pRESPOSTA_ITB_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_ITB_reposta = "Não";
        }
        conectaITB.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoITB(String nome) {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaITB.rs.first();
            codCargo = conectaITB.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conectaITB.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoITB(String nome) {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaITB.rs.first();
            codDepto = conectaITB.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conectaITB.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoITB(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM CARGOS");
            conectaITB.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaITB.rs.getString("NomeCargo"));
            } while (conectaITB.rs.next());
        } catch (SQLException ex) {
        }
        conectaITB.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoITB(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conectaITB.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conectaITB.rs.getString("NomeDepartamento"));
            } while (conectaITB.rs.next());
        } catch (SQLException ex) {
        }
        conectaITB.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoITB(ColaboradoresTransferenciasUnidades objCola) {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conectaITB.rs.last();
            objCola.setIdFunc(conectaITB.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conectaITB.desconecta();
        return objCola;
    }

    //-------------------------------------------- UNIDADE DE BARREIRAS ------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorBAR(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoBAR(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoBAR(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_BAR_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_BAR_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorBAR(ColaboradoresTransferenciasUnidades objCola) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_BAR_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_BAR_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorBAR(ColaboradoresTransferenciasUnidades objCola) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_BAR_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_BAR_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaboradorBAR(ColaboradoresTransferenciasUnidades objCola) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_BAR_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_BAR_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorBAR(EntradasSaidasColaboradores objEntraSaiFunc) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR(FINALIZAR) os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objEntraSaiFunc;
    }

    public ColaboradoresTransferenciasUnidades FINALIZAR_ColaboradorBAR(ColaboradoresTransferenciasUnidades objCola) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL LAURO DE FREITAS --------------------------------------------------
    public void pPESQUISAR_colaboradorBAR(String pNOME_func, String pNOME_mae) {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaBAR.rs.first();
            pNOME_colaborador = conectaBAR.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaBAR.rs.getString("NomeMae");
            pRESPOSTA_BAR_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_BAR_reposta = "Não";
        }
        conectaBAR.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoBAR(String nome) {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaBAR.rs.first();
            codCargo = conectaBAR.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conectaBAR.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoBAR(String nome) {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaBAR.rs.first();
            codDepto = conectaITB.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conectaBAR.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoBAR(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM CARGOS");
            conectaBAR.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaBAR.rs.getString("NomeCargo"));
            } while (conectaBAR.rs.next());
        } catch (SQLException ex) {
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoBAR(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conectaBAR.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conectaBAR.rs.getString("NomeDepartamento"));
            } while (conectaBAR.rs.next());
        } catch (SQLException ex) {
        }
        conectaBAR.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoBAR(ColaboradoresTransferenciasUnidades objCola) {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conectaBAR.rs.last();
            objCola.setIdFunc(conectaBAR.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conectaBAR.desconecta();
        return objCola;
    }

    //----------------------------------------- LOCALHOST --------------------------------------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorLH(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoLH(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoLH(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
            pRESPOSTA_LH_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LH_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirEnderecosColaboradorLH(ColaboradoresTransferenciasUnidades objCola) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getEndereco());
            pst.setString(2, objCola.getBairroEnd());
            pst.setString(3, objCola.getCompEnd());
            pst.setString(4, objCola.getCidadeEnd());
            pst.setString(5, objCola.getEstadoEnd());
            pst.setString(6, objCola.getCepEnd());
            pst.setString(7, objCola.getFoneEnd());
            pst.setString(8, objCola.getTelEnd());
            pst.setString(9, objCola.getCelEnd());
            pst.setString(10, objCola.getEmalEnd());
            pst.setString(11, objCola.getUrl());
            pst.setString(12, objCola.getObservacao());
            pst.setInt(13, objCola.getIdFunc());
            pst.setString(14, objCola.getUsuarioInsert());
            pst.setString(15, objCola.getDataInsert());
            pst.setString(16, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_LH_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LH_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaboradorLH(ColaboradoresTransferenciasUnidades objCola) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCola.getIdFunc());
            pst.setString(2, objCola.getRgDoc());
            if (objCola.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCola.getOrgaoDoc());
            pst.setString(5, objCola.getEstadoOrgao());
            pst.setString(6, objCola.getCpfDoc());
            pst.setString(7, objCola.getPisDoc());
            if (objCola.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getTituloDoc());
            pst.setString(10, objCola.getZonaDoc());
            pst.setString(11, objCola.getSecaoDoc());
            pst.setString(12, objCola.getCtpsDoc());
            pst.setString(13, objCola.getSerieDoc());
            pst.setString(14, objCola.getHabiliDoc());
            pst.setString(15, objCola.getReserVistaDoc());
            pst.setString(16, objCola.getCateDoc());
            pst.setString(17, objCola.getCartSaudeDoc());
            pst.setString(18, objCola.getProfDoc());
            pst.setString(19, objCola.getAlturaDoc());
            pst.setString(20, objCola.getPesoDoc());
            pst.setString(21, objCola.getCalcaDoc());
            pst.setString(22, objCola.getCamisaDoc());
            pst.setString(23, objCola.getSapatoDoc());
            pst.setString(24, objCola.getCarteiraDoc());
            pst.setString(25, objCola.getTipoConjugue());
            if (objCola.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objCola.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objCola.getNomeConjugue());
            pst.setString(28, objCola.getUsuarioInsert());
            pst.setString(29, objCola.getDataInsert());
            pst.setString(30, objCola.getHorarioInsert());
            pst.execute();
            pRESPOSTA_LH_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LH_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades alterarColaboradorLH(ColaboradoresTransferenciasUnidades objCola) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COLABORADOR SET StatusFunc=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.executeUpdate();
            pRESPOSTA_LH_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LH_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public EntradasSaidasColaboradores FINALIZAR_TRANSFERENCIA_ColaboradorLH(EntradasSaidasColaboradores objEntraSaiFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_COLABORADORES SET StatusRegistro=? WHERE IdRegRegistro='" + objEntraSaiFunc.getIdRegistro() + "'");
            pst.setString(1, objEntraSaiFunc.getStatusRegistro());
            pst.executeUpdate();
            pRESPOSTA_FI_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_FI_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR(FINALIZAR) os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntraSaiFunc;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL LAURO DE FREITAS --------------------------------------------------
    public void pPESQUISAR_colaboradorLH(String pNOME_func, String pNOME_mae) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conecta.rs.first();
            pNOME_colaborador = conecta.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conecta.rs.getString("NomeMae");
            pRESPOSTA_LH_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_LH_reposta = "Não";
        }
        conecta.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoLH(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conecta.rs.first();
            codCargo = conecta.rs.getInt("IdCargo");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDeptoLH(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_cargoLH(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxCargoPesquisa.removeAllItems();
        conecta.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM CARGOS");
            conectaSSA.rs.first();
            do {
                jComboBoxCargoPesquisa.addItem(conectaSSA.rs.getString("NomeCargo"));
            } while (conectaSSA.rs.next());
        } catch (SQLException ex) {
        }
        conectaSSA.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades pPESQUISAR_departamentoLH(ColaboradoresTransferenciasUnidades objCola) {
        jComboBoxDepartamentoPesquisa.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS");
            conecta.rs.first();
            do {
                jComboBoxDepartamentoPesquisa.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigoLH(ColaboradoresTransferenciasUnidades objCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdFunc "
                    + "FROM COLABORADOR");
            conecta.rs.last();
            objCola.setIdFunc(conecta.rs.getInt("IdFunc"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleTransferenciaColaboradorUnidades.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objCola;
    }
}
