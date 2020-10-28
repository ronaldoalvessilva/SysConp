/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.ColaboradoresTransferenciasUnidades;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleListaTransferenciaColaVC {
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    
    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * "
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
            while (conectaVC.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conectaVC.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conectaVC.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conectaVC.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conectaVC.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conectaVC.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conectaVC.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conectaVC.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conectaVC.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conectaVC.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conectaVC.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conectaVC.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conectaVC.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conectaVC.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conectaVC.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conectaVC.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conectaVC.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conectaVC.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conectaVC.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conectaVC.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conectaVC.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conectaVC.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conectaVC.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conectaVC.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conectaVC.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conectaVC.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conectaVC.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conectaVC.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conectaVC.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conectaVC.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conectaVC.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conectaVC.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conectaVC.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conectaVC.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conectaVC.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conectaVC.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaVC.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaVC.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conectaVC.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conectaVC.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conectaVC.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conectaVC.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conectaVC.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conectaVC.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conectaVC.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conectaVC.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conectaVC.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conectaVC.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conectaVC.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conectaVC.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conectaVC.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conectaVC.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conectaVC.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conectaVC.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conectaVC.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conectaVC.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conectaVC.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conectaVC.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conectaVC.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conectaVC.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conectaVC.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conectaVC.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conectaVC.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conectaVC.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conectaVC.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaVC.desconecta();
        }
        return null;
    }
}
