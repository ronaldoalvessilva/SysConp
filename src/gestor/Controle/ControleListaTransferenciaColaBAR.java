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
public class ControleListaTransferenciaColaBAR {
    ConexaoBancoDadosVC conectaBAR = new ConexaoBancoDadosVC();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    
    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * "
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
            while (conectaBAR.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conectaBAR.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conectaBAR.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conectaBAR.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conectaBAR.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conectaBAR.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conectaBAR.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conectaBAR.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conectaBAR.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conectaBAR.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conectaBAR.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conectaBAR.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conectaBAR.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conectaBAR.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conectaBAR.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conectaBAR.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conectaBAR.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conectaBAR.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conectaBAR.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conectaBAR.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conectaBAR.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conectaBAR.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conectaBAR.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conectaBAR.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conectaBAR.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conectaBAR.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conectaBAR.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conectaBAR.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conectaBAR.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conectaBAR.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conectaBAR.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conectaBAR.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conectaBAR.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conectaBAR.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conectaBAR.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conectaBAR.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaBAR.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaBAR.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conectaBAR.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conectaBAR.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conectaBAR.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conectaBAR.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conectaBAR.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conectaBAR.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conectaBAR.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conectaBAR.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conectaBAR.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conectaBAR.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conectaBAR.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conectaBAR.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conectaBAR.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conectaBAR.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conectaBAR.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conectaBAR.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conectaBAR.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conectaBAR.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conectaBAR.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conectaBAR.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conectaBAR.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conectaBAR.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conectaBAR.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conectaBAR.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conectaBAR.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conectaBAR.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conectaBAR.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaBAR.desconecta();
        }
        return null;
    }
}
