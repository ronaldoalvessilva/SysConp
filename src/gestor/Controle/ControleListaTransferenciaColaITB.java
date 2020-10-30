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
public class ControleListaTransferenciaColaITB {
    ConexaoBancoDadosVC conectaITB = new ConexaoBancoDadosVC();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    
    public List<ColaboradoresTransferenciasUnidades> read() throws Exception {
        List<ColaboradoresTransferenciasUnidades> LISTAR_TODOS_Colaboradores = new ArrayList<ColaboradoresTransferenciasUnidades>();
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * "
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
            while (conectaITB.rs.next()) {
                ColaboradoresTransferenciasUnidades pTRANSFERENCIA_colaboradores = new ColaboradoresTransferenciasUnidades();
                pTRANSFERENCIA_colaboradores.setIdFunc(conectaITB.rs.getInt("IdFunc"));
                pTRANSFERENCIA_colaboradores.setStatusFunc(conectaITB.rs.getString("StatusFunc"));
                pTRANSFERENCIA_colaboradores.setDataCadastro(conectaITB.rs.getDate("DataCadFunc"));
                pTRANSFERENCIA_colaboradores.setNomeFuncionario(conectaITB.rs.getString("NomeFunc"));
                pTRANSFERENCIA_colaboradores.setSexo(conectaITB.rs.getString("SexoFunc"));
                pTRANSFERENCIA_colaboradores.setEscolaridade(conectaITB.rs.getString("EscolaFunc"));
                pTRANSFERENCIA_colaboradores.setMatricula(conectaITB.rs.getString("MatriculaFunc"));
                pTRANSFERENCIA_colaboradores.setIdCargo(conectaITB.rs.getInt("IdCargo"));
                pTRANSFERENCIA_colaboradores.setNomeCargo(conectaITB.rs.getString("NomeCargo"));
                pTRANSFERENCIA_colaboradores.setIdDepartamento(conectaITB.rs.getInt("IdDepartamento"));
                pTRANSFERENCIA_colaboradores.setNomeDepartamento(conectaITB.rs.getString("NomeDepartamento"));
                pTRANSFERENCIA_colaboradores.setEstadoCivil(conectaITB.rs.getString("EstadoCivil"));
                pTRANSFERENCIA_colaboradores.setDataNascimento(conectaITB.rs.getDate("DataNascimento"));
                pTRANSFERENCIA_colaboradores.setNomeMae(conectaITB.rs.getString("NomeMae"));
                pTRANSFERENCIA_colaboradores.setNomePai(conectaITB.rs.getString("NomePai"));
                pTRANSFERENCIA_colaboradores.setReligiao(conectaITB.rs.getString("Religiao"));
                pTRANSFERENCIA_colaboradores.setTipoSangue(conectaITB.rs.getString("TipoSangue"));
                pTRANSFERENCIA_colaboradores.setCargaHoraria(conectaITB.rs.getString("CargaHoraria"));
                pTRANSFERENCIA_colaboradores.setRegimeTrabalho(conectaITB.rs.getString("RegimeTrabalho"));
                pTRANSFERENCIA_colaboradores.setHorarioInicio(conectaITB.rs.getString("HorarioInicio"));
                pTRANSFERENCIA_colaboradores.setHorarioFinal(conectaITB.rs.getString("HorarioFinal"));
                pTRANSFERENCIA_colaboradores.setFuncao(conectaITB.rs.getString("Funcao"));
                pTRANSFERENCIA_colaboradores.setNacionalidade(conectaITB.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setPais(conectaITB.rs.getString("Pais"));
                pTRANSFERENCIA_colaboradores.setNaturalidade(conectaITB.rs.getString("Naturalidade"));
                pTRANSFERENCIA_colaboradores.setEstadoNacionalidade(conectaITB.rs.getString("Nacionalidade"));
                pTRANSFERENCIA_colaboradores.setImagemFrenteCO(conectaITB.rs.getBytes("ImagemFrenteCO"));
                //ENDEREÇO
                pTRANSFERENCIA_colaboradores.setIdEnd(conectaITB.rs.getInt("IdEnd"));
                pTRANSFERENCIA_colaboradores.setEndereco(conectaITB.rs.getString("Endereco"));
                pTRANSFERENCIA_colaboradores.setBairroEnd(conectaITB.rs.getString("BairroEnd"));
                pTRANSFERENCIA_colaboradores.setCompEnd(conectaITB.rs.getString("CompEnd"));
                pTRANSFERENCIA_colaboradores.setCidadeEnd(conectaITB.rs.getString("CidadeEnd"));
                pTRANSFERENCIA_colaboradores.setEstadoEnd(conectaITB.rs.getString("UfEnd"));
                pTRANSFERENCIA_colaboradores.setCepEnd(conectaITB.rs.getString("CepEnd"));
                // CONTATO
                pTRANSFERENCIA_colaboradores.setEmailEndEmp(conectaITB.rs.getString("EmailEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaITB.rs.getString("FoneEnd"));
                pTRANSFERENCIA_colaboradores.setTelEnd(conectaITB.rs.getString("TelEnd"));
                pTRANSFERENCIA_colaboradores.setCelEnd(conectaITB.rs.getString("CelEnd"));
                pTRANSFERENCIA_colaboradores.setUrl(conectaITB.rs.getString("Url"));
                pTRANSFERENCIA_colaboradores.setObservacao(conectaITB.rs.getString("Observacao"));
                // DOCUMENTOS
                pTRANSFERENCIA_colaboradores.setIdDoc(conectaITB.rs.getInt("IdDoc"));
                pTRANSFERENCIA_colaboradores.setRgDoc(conectaITB.rs.getString("RgDoc"));
                pTRANSFERENCIA_colaboradores.setCpfDoc(conectaITB.rs.getString("CpfDoc"));
                pTRANSFERENCIA_colaboradores.setDataEmissaoDoc(conectaITB.rs.getDate("DataEmissaoDoc"));
                pTRANSFERENCIA_colaboradores.setOrgaoDoc(conectaITB.rs.getString("OrgaoDoc"));
                pTRANSFERENCIA_colaboradores.setEstadoOrgao(conectaITB.rs.getString("EstadoOrg"));
                pTRANSFERENCIA_colaboradores.setPisDoc(conectaITB.rs.getString("PisDoc"));
                pTRANSFERENCIA_colaboradores.setDataCadPisDoc(conectaITB.rs.getDate("DataCadPisDoc"));
                pTRANSFERENCIA_colaboradores.setTituloDoc(conectaITB.rs.getString("TituloDoc"));
                pTRANSFERENCIA_colaboradores.setZonaDoc(conectaITB.rs.getString("ZonaDoc"));
                pTRANSFERENCIA_colaboradores.setSecaoDoc(conectaITB.rs.getString("SecaoDoc"));
                pTRANSFERENCIA_colaboradores.setCtpsDoc(conectaITB.rs.getString("CtpsDoc"));
                pTRANSFERENCIA_colaboradores.setSerieDoc(conectaITB.rs.getString("SerieDoc"));
                pTRANSFERENCIA_colaboradores.setHabiliDoc(conectaITB.rs.getString("HabiliDoc"));
                pTRANSFERENCIA_colaboradores.setReserVistaDoc(conectaITB.rs.getString("ReservistaDoc"));
                pTRANSFERENCIA_colaboradores.setCateDoc(conectaITB.rs.getString("CateDoc"));
                pTRANSFERENCIA_colaboradores.setCartSaudeDoc(conectaITB.rs.getString("CartSaudeDoc"));
                pTRANSFERENCIA_colaboradores.setProfDoc(conectaITB.rs.getString("ProfDoc"));
                pTRANSFERENCIA_colaboradores.setAlturaDoc(conectaITB.rs.getString("AlturaDoc"));
                pTRANSFERENCIA_colaboradores.setCalcaDoc(conectaITB.rs.getString("CalcaDoc"));
                pTRANSFERENCIA_colaboradores.setSapatoDoc(conectaITB.rs.getString("SapatoDoc"));
                pTRANSFERENCIA_colaboradores.setPesoDoc(conectaITB.rs.getString("PesoDoc"));
                pTRANSFERENCIA_colaboradores.setCamisaDoc(conectaITB.rs.getString("CamisaDoc"));
                pTRANSFERENCIA_colaboradores.setCarteiraDoc(conectaITB.rs.getString("CarteiraDoc"));
                LISTAR_TODOS_Colaboradores.add(pTRANSFERENCIA_colaboradores);
            }
            return LISTAR_TODOS_Colaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradaSaidaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaITB.desconecta();
        }
        return null;
    }
}
