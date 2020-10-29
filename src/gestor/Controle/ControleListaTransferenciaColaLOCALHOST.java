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
public class ControleListaTransferenciaColaLOCALHOST {
    ConexaoBancoDadosVC conecta = new ConexaoBancoDadosVC();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    
    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * "
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
            while (conecta.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conecta.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conecta.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conecta.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conecta.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conecta.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conecta.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conecta.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conecta.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conecta.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conecta.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conecta.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conecta.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conecta.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conecta.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conecta.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conecta.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conecta.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conecta.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conecta.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conecta.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conecta.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conecta.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conecta.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conecta.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conecta.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conecta.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conecta.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conecta.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conecta.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conecta.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conecta.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conecta.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conecta.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conecta.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conecta.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conecta.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conecta.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conecta.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conecta.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conecta.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conecta.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conecta.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conecta.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conecta.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conecta.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conecta.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conecta.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conecta.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conecta.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conecta.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conecta.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conecta.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conecta.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conecta.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conecta.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conecta.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conecta.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conecta.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conecta.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conecta.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conecta.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conecta.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conecta.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conecta.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
