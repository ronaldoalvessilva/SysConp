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
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.jComboBoxCargoPesquisa;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.jComboBoxDepartamentoPesquisa;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pNOME_colaborador;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pNOME_MAE_colaborador;
import static gestor.Visao.TelaFinalizarEntradaSaidaColaboradorADM.pRESPOSTA_reposta;
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
public class ControleTransferenciaColaboradorUnidades {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    //
    int codCargo;
    int codDepto;

    // -------------------------------------------------------- UNIDADE DE LAURO DE FREITAS
    public ColaboradoresTransferenciasUnidades incluirColaboradorLF(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargo(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDepto(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    public ColaboradoresTransferenciasUnidades incluirDocumentosColaborador(ColaboradoresTransferenciasUnidades objCola) {
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL --------------------------------------------------
    public void pPESQUISAR_colaboradorLF(String pNOME_func, String pNOME_mae) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaLF.rs.first();
            pNOME_colaborador = conectaLF.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaLF.rs.getString("NomeMae");
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conectaLF.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargo(String nome) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaLF.rs.first();
            codCargo = conectaLF.rs.getInt("IdCargo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conectaLF.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarDepto(String nome) {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conectaLF.rs.first();
            codDepto = conectaLF.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * "
                    + "FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "INNER JOIN ENDERECOS "
                    + "ON COLABORADOR.IdFunc=ENDERECOS.IdFunc "
                    + "INNER JOIN DOCUMENTOS "
                    + "ON COLABORADOR.IdFunc=DOCUMENTOS.IdFunc  "
                    + "WHERE COLABORADOR.IdFunc='" + objCola.getIdFunc() + "'");
            while (conectaLF.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conectaLF.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conectaLF.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conectaLF.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conectaLF.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conectaLF.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conectaLF.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conectaLF.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conectaLF.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conectaLF.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conectaLF.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conectaLF.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conectaLF.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conectaLF.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conectaLF.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conectaLF.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conectaLF.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conectaLF.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conectaLF.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conectaLF.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conectaLF.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conectaLF.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conectaLF.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conectaLF.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conectaLF.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conectaLF.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conectaLF.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conectaLF.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conectaLF.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conectaLF.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conectaLF.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conectaLF.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conectaLF.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conectaLF.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conectaLF.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conectaLF.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaLF.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaLF.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conectaLF.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conectaLF.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conectaLF.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conectaLF.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conectaLF.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conectaLF.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conectaLF.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conectaLF.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conectaLF.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conectaLF.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conectaLF.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conectaLF.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conectaLF.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conectaLF.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conectaLF.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conectaLF.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conectaLF.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conectaLF.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conectaLF.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conectaLF.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conectaLF.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conectaLF.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conectaLF.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conectaLF.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conectaLF.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conectaLF.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conectaLF.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaLF.desconecta();
        }
        return null;
    }

    // -------------------------------------------------------- UNIDADE DE SALVADOR ------------------------------------------------------
    public ColaboradoresTransferenciasUnidades incluirColaboradorSSA(ColaboradoresTransferenciasUnidades objCola) {
        buscarCargoSSA(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDeptoSSA(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL --------------------------------------------------
    public void pPESQUISAR_colaboradorSSA(String pNOME_func, String pNOME_mae) {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaSSA.rs.first();
            pNOME_colaborador = conectaSSA.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaSSA.rs.getString("NomeMae");
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
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
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
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

    public ColaboradoresTransferenciasUnidades PESQUISAR_codigo(ColaboradoresTransferenciasUnidades objCola) {
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
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
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objCola;
    }

    //-------------------------------------- PESQUISAS POR UNIDADE PRISIONAL --------------------------------------------------
    public void pPESQUISAR_colaboradorVC(String pNOME_func, String pNOME_mae) {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + pNOME_func + "' "
                    + "AND NomeMae='" + pNOME_mae + "'");
            conectaVC.rs.first();
            pNOME_colaborador = conectaVC.rs.getString("NomeFunc");
            pNOME_MAE_colaborador = conectaVC.rs.getString("NomeMae");
            pRESPOSTA_reposta = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_reposta = "Não";
//            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conectaVC.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
    public void buscarCargoVC(String nome) {
        conectaSSA.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conectaVC.rs.first();
            codCargo = conectaVC.rs.getInt("IdCargo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
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
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conectaVC.desconecta();
    }
}
