/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDadosSSA;
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
public class ControleListaTransferenciaColaSSA {
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    
    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * "
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
            while (conectaSSA.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conectaSSA.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conectaSSA.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conectaSSA.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conectaSSA.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conectaSSA.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conectaSSA.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conectaSSA.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conectaSSA.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conectaSSA.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conectaSSA.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conectaSSA.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conectaSSA.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conectaSSA.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conectaSSA.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conectaSSA.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conectaSSA.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conectaSSA.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conectaSSA.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conectaSSA.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conectaSSA.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conectaSSA.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conectaSSA.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conectaSSA.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conectaSSA.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conectaSSA.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conectaSSA.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conectaSSA.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conectaSSA.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conectaSSA.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conectaSSA.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conectaSSA.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conectaSSA.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conectaSSA.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conectaSSA.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conectaSSA.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaSSA.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaSSA.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conectaSSA.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conectaSSA.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conectaSSA.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conectaSSA.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conectaSSA.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conectaSSA.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conectaSSA.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conectaSSA.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conectaSSA.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conectaSSA.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conectaSSA.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conectaSSA.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conectaSSA.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conectaSSA.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conectaSSA.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conectaSSA.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conectaSSA.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conectaSSA.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conectaSSA.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conectaSSA.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conectaSSA.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conectaSSA.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conectaSSA.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conectaSSA.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conectaSSA.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conectaSSA.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conectaSSA.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaSSA.desconecta();
        }
        return null;
    }
}
