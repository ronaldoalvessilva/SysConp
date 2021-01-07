/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Arma;
import static gestor.Visao.TelaArmas.jComboBoxGrupoArma;
import static gestor.Visao.TelaArmas.jIdArma;
import static gestor.Visao.TelaArmas.jPesqDescricaoArma;
import static gestor.Visao.TelaArmas.pID_grupo;
import static gestor.Visao.TelaArmas.pRESPOSTA_grupo;
import static gestor.Visao.TelaArmas.pTOTAL_grupo;
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
public class ControleArma {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Arma objArma = new Arma();

    Integer pCODIGO_grupo = 0;

    public Arma incluirArmas(Arma objArma) {
        PESQUISAR_grupo(objArma.getGrupoArma());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ARMAS (SerieArma,NCMArma,DataCadastroArma,StatusArma,"
                    + "DescricaoArma,IdGrupoArm,MarcaArma,ModeloArma,CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma,PesoArma,MiraArma,AlturaArma,"
                    + "LarguraArma,ComprimentoCanoArma,ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma,RegistroArma,LicencaArma,"
                    + "DataLicencaArma,UnidadeArma,LocalizacaoArma,CustoArma,EstoqueArma,FotoArma,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objArma.getSerieArma());
            pst.setString(2, objArma.getnCMArma());
            pst.setTimestamp(3, new java.sql.Timestamp(objArma.getDataCadastroArma().getTime()));
            pst.setString(4, objArma.getStatusArma());
            pst.setString(5, objArma.getDescricaoArma()); 
            pst.setInt(6, pCODIGO_grupo);
            pst.setString(7, objArma.getMarcaArma());
            pst.setString(8, objArma.getModeloArma());
            pst.setString(9, objArma.getCalibreArma());
            pst.setString(10, objArma.getCanoArma());
            pst.setString(11, objArma.getNumeroTirosArma());
            pst.setString(12, objArma.getAcabamentoArma());
            pst.setString(13, objArma.getPesoArma());
            pst.setString(14, objArma.getMiraArma());
            pst.setString(15, objArma.getAlturaArma());
            pst.setString(16, objArma.getLarguraArma());
            pst.setString(17, objArma.getComprimentoCanoArma());
            pst.setString(18, objArma.getComprimentoTotalArma());
            pst.setString(19, objArma.getDispositivoSegurancaArma());
            pst.setString(20, objArma.getOutrasCaracteristicasArma());
            pst.setString(21, objArma.getRegistroArma());
            pst.setString(22, objArma.getLicencaArma());
            if (objArma.getDataLicencaArma() != null) {
                pst.setTimestamp(23, new java.sql.Timestamp(objArma.getDataLicencaArma().getTime()));
            } else {
                pst.setDate(23, null);
            }
            pst.setString(24, objArma.getUnidadeArma());
            pst.setString(25, objArma.getLocalizacaoArma());
            pst.setFloat(26, objArma.getCustoArma());
            pst.setString(27, objArma.getEstoqueArma());
            pst.setBytes(28, objArma.getFotoArma());
            pst.setString(29, objArma.getUsuarioInsert());
            pst.setString(30, objArma.getDataInsert());
            pst.setString(31, objArma.getHorarioInsert());
            pst.execute();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma alterarArmas(Arma objArma) {
        PESQUISAR_grupo(objArma.getGrupoArma());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ARMAS SET SerieArma=?,NCMArma=?,DataCadastroArma=?,StatusArma=?,"
                    + "DescricaoArma=?,IdGrupoArm=?,MarcaArma=?,ModeloArma=?,CalibreArma=?,CanoArma=?,NumeroTirosArma=?,AcabamentoArma=?,PesoArma=?,MiraArma=?,AlturaArma=?,"
                    + "LarguraArma=?,ComprimentoCanoArma=?,ComprimentoTotalArma=?,DispositivoSegurancaArma=?,OutrasCaracteristicasArma=?,RegistroArma=?,LicencaArma=?,"
                    + "DataLicencaArma=?,UnidadeArma=?,LocalizacaoArma=?,CustoArma=?,EstoqueArma=?,FotoArma=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.setString(1, objArma.getSerieArma());
            pst.setString(2, objArma.getnCMArma());
            pst.setTimestamp(3, new java.sql.Timestamp(objArma.getDataCadastroArma().getTime()));
            pst.setString(4, objArma.getStatusArma());
            pst.setString(5, objArma.getDescricaoArma()); 
            pst.setInt(6, pCODIGO_grupo);
            pst.setString(7, objArma.getMarcaArma());
            pst.setString(8, objArma.getModeloArma());
            pst.setString(9, objArma.getCalibreArma());
            pst.setString(10, objArma.getCanoArma());
            pst.setString(11, objArma.getNumeroTirosArma());
            pst.setString(12, objArma.getAcabamentoArma());
            pst.setString(13, objArma.getPesoArma());
            pst.setString(14, objArma.getMiraArma());
            pst.setString(15, objArma.getAlturaArma());
            pst.setString(16, objArma.getLarguraArma());
            pst.setString(17, objArma.getComprimentoCanoArma());
            pst.setString(18, objArma.getComprimentoTotalArma());
            pst.setString(19, objArma.getDispositivoSegurancaArma());
            pst.setString(20, objArma.getOutrasCaracteristicasArma());
            pst.setString(21, objArma.getRegistroArma());
            pst.setString(22, objArma.getLicencaArma());
            if (objArma.getDataLicencaArma() != null) {
                pst.setTimestamp(23, new java.sql.Timestamp(objArma.getDataLicencaArma().getTime()));
            } else {
                pst.setDate(23, null);
            }
            pst.setString(24, objArma.getUnidadeArma());
            pst.setString(25, objArma.getLocalizacaoArma());
            pst.setFloat(26, objArma.getCustoArma());
            pst.setString(27, objArma.getEstoqueArma());
            pst.setBytes(28, objArma.getFotoArma());
            pst.setString(29, objArma.getUsuarioUp());
            pst.setString(30, objArma.getDataUp());
            pst.setString(31, objArma.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }
    
    public Arma alterarQRCodeArmas(Arma objArma) {        

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ARMAS SET QRCode=? WHERE IdArma='" + objArma.getIdArma() + "'");           
            pst.setBytes(1, objArma.getqRCodeArma());
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }


    public Arma excluirArmas(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ARMAS WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public List<Arma> TODOS_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_TODAS_Armas = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT IdArma,SerieArma, "
                    + "NCMArma,DataCadastro,StatusArma,DescricaoArma, "
                    + "ARMAS.IdGrupoArm,DescricaoGrupoArma,MarcaArma,ModeloArma, "
                    + "CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma, "
                    + "PesoArma,MiraArma,AlturaArma,LarguraArma,ComprimentoCanoArma, "
                    + "ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma, "
                    + "RegistroArma,LicencaArma,DataLicencaArma,UnidadeArma, "
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma "
                    + "FROM ARMAS "
                    + "INNER JOIN GRUPO_ARMAS "
                    + "ON ARMAS.IdGrupoArm=GRUPO_ARMAS.IdGrupoArm "
                    + "ORDER BY DescricaoArma");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("SerieArma"));
                pArmas.setnCMArma(conecta.rs.getString("NCMArma"));
                pArmas.setDataCadastroArma(conecta.rs.getDate("DataCadastro"));
                pArmas.setStatusArma(conecta.rs.getString("StatusArma"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setIdGrupoArma(conecta.rs.getInt("IdGrupoArm"));
                pArmas.setGrupoArma(conecta.rs.getString("DescricaoGrupoArma"));
                pArmas.setMarcaArma(conecta.rs.getString("MarcaArma"));
                pArmas.setModeloArma(conecta.rs.getString("ModeloArma"));
                pArmas.setCalibreArma(conecta.rs.getString("CalibreArma"));
                pArmas.setCanoArma(conecta.rs.getString("CanoArma"));
                pArmas.setNumeroTirosArma(conecta.rs.getString("NumeroTirosArma"));
                pArmas.setAcabamentoArma(conecta.rs.getString("AcabamentoArma"));
                pArmas.setPesoArma(conecta.rs.getString("PesoArma"));
                pArmas.setMiraArma(conecta.rs.getString("MiraArma"));
                pArmas.setAlturaArma(conecta.rs.getString("AlturaArma"));
                pArmas.setLarguraArma(conecta.rs.getString("LarguraArma"));
                pArmas.setComprimentoCanoArma(conecta.rs.getString("ComprimentoCanoArma"));
                pArmas.setComprimentoTotalArma(conecta.rs.getString("ComprimentoTotalArma"));
                pArmas.setDispositivoSegurancaArma(conecta.rs.getString("DispositivoSegurancaArma"));
                pArmas.setOutrasCaracteristicasArma(conecta.rs.getString("OutrasCaracteristicasArma"));
                pArmas.setRegistroArma(conecta.rs.getString("RegistroArma"));
                pArmas.setLicencaArma(conecta.rs.getString("LicencaArma"));
                pArmas.setDataLicencaArma(conecta.rs.getDate("DataLicencaArma"));
                pArmas.setUnidadeArma(conecta.rs.getString("UnidadeArma"));
                pArmas.setLocalizacaoArma(conecta.rs.getString("LocalizacaoArma"));
                pArmas.setCustoArma(conecta.rs.getFloat("CustoArma"));
                pArmas.setEstoqueArma(conecta.rs.getString("EstoqueArma"));
                pArmas.setFotoArma(conecta.rs.getBytes("FotoArma"));               
                LISTAR_TODAS_Armas.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_TODAS_Armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<Arma> pNOME_ARMAS_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_NOMES_armas = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT IdArma,SerieArma, "
                    + "NCMArma,DataCadastro,StatusArma,DescricaoArma, "
                    + "ARMAS.IdGrupoArm,DescricaoGrupoArma,MarcaArma,ModeloArma, "
                    + "CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma, "
                    + "PesoArma,MiraArma,AlturaArma,LarguraArma,ComprimentoCanoArma, "
                    + "ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma, "
                    + "RegistroArma,LicencaArma,DataLicencaArma,UnidadeArma, "
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma "
                    + "FROM ARMAS "
                    + "INNER JOIN GRUPO_ARMAS "
                    + "ON ARMAS.IdGrupoArm=GRUPO_ARMAS.IdGrupoArm "
                    + "WHERE DescricaoArma LIKE'%" + jPesqDescricaoArma.getText() + "%' ");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("SerieArma"));
                pArmas.setnCMArma(conecta.rs.getString("NCMArma"));
                pArmas.setDataCadastroArma(conecta.rs.getDate("DataCadastro"));
                pArmas.setStatusArma(conecta.rs.getString("StatusArma"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setIdGrupoArma(conecta.rs.getInt("IdGrupoArm"));
                pArmas.setGrupoArma(conecta.rs.getString("DescricaoGrupoArma"));
                pArmas.setMarcaArma(conecta.rs.getString("MarcaArma"));
                pArmas.setModeloArma(conecta.rs.getString("ModeloArma"));
                pArmas.setCalibreArma(conecta.rs.getString("CalibreArma"));
                pArmas.setCanoArma(conecta.rs.getString("CanoArma"));
                pArmas.setNumeroTirosArma(conecta.rs.getString("NumeroTirosArma"));
                pArmas.setAcabamentoArma(conecta.rs.getString("AcabamentoArma"));
                pArmas.setPesoArma(conecta.rs.getString("PesoArma"));
                pArmas.setMiraArma(conecta.rs.getString("MiraArma"));
                pArmas.setAlturaArma(conecta.rs.getString("AlturaArma"));
                pArmas.setLarguraArma(conecta.rs.getString("LarguraArma"));
                pArmas.setComprimentoCanoArma(conecta.rs.getString("ComprimentoCanoArma"));
                pArmas.setComprimentoTotalArma(conecta.rs.getString("ComprimentoTotalArma"));
                pArmas.setDispositivoSegurancaArma(conecta.rs.getString("DispositivoSegurancaArma"));
                pArmas.setOutrasCaracteristicasArma(conecta.rs.getString("OutrasCaracteristicasArma"));
                pArmas.setRegistroArma(conecta.rs.getString("RegistroArma"));
                pArmas.setLicencaArma(conecta.rs.getString("LicencaArma"));
                pArmas.setDataLicencaArma(conecta.rs.getDate("DataLicencaArma"));
                pArmas.setUnidadeArma(conecta.rs.getString("UnidadeArma"));
                pArmas.setLocalizacaoArma(conecta.rs.getString("LocalizacaoArma"));
                pArmas.setCustoArma(conecta.rs.getFloat("CustoArma"));
                pArmas.setEstoqueArma(conecta.rs.getString("EstoqueArma"));
                pArmas.setFotoArma(conecta.rs.getBytes("FotoArma")); 
                LISTAR_NOMES_armas.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_NOMES_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<Arma> pCODIGO_GRUPO_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_ARAMAS_codigo = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT IdArma,SerieArma, "
                    + "NCMArma,DataCadastro,StatusArma,DescricaoArma, "
                    + "ARMAS.IdGrupoArm,DescricaoGrupoArma,MarcaArma,ModeloArma, "
                    + "CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma, "
                    + "PesoArma,MiraArma,AlturaArma,LarguraArma,ComprimentoCanoArma, "
                    + "ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma, "
                    + "RegistroArma,LicencaArma,DataLicencaArma,UnidadeArma, "
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma "
                    + "FROM ARMAS "
                    + "INNER JOIN GRUPO_ARMAS "
                    + "ON ARMAS.IdGrupoArm=GRUPO_ARMAS.IdGrupoArm "
                    + "WHERE IdArma='" + pID_grupo.toString().trim() + "' ");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("SerieArma"));
                pArmas.setnCMArma(conecta.rs.getString("NCMArma"));
                pArmas.setDataCadastroArma(conecta.rs.getDate("DataCadastro"));
                pArmas.setStatusArma(conecta.rs.getString("StatusArma"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setIdGrupoArma(conecta.rs.getInt("IdGrupoArm"));
                pArmas.setGrupoArma(conecta.rs.getString("DescricaoGrupoArma"));
                pArmas.setMarcaArma(conecta.rs.getString("MarcaArma"));
                pArmas.setModeloArma(conecta.rs.getString("ModeloArma"));
                pArmas.setCalibreArma(conecta.rs.getString("CalibreArma"));
                pArmas.setCanoArma(conecta.rs.getString("CanoArma"));
                pArmas.setNumeroTirosArma(conecta.rs.getString("NumeroTirosArma"));
                pArmas.setAcabamentoArma(conecta.rs.getString("AcabamentoArma"));
                pArmas.setPesoArma(conecta.rs.getString("PesoArma"));
                pArmas.setMiraArma(conecta.rs.getString("MiraArma"));
                pArmas.setAlturaArma(conecta.rs.getString("AlturaArma"));
                pArmas.setLarguraArma(conecta.rs.getString("LarguraArma"));
                pArmas.setComprimentoCanoArma(conecta.rs.getString("ComprimentoCanoArma"));
                pArmas.setComprimentoTotalArma(conecta.rs.getString("ComprimentoTotalArma"));
                pArmas.setDispositivoSegurancaArma(conecta.rs.getString("DispositivoSegurancaArma"));
                pArmas.setOutrasCaracteristicasArma(conecta.rs.getString("OutrasCaracteristicasArma"));
                pArmas.setRegistroArma(conecta.rs.getString("RegistroArma"));
                pArmas.setLicencaArma(conecta.rs.getString("LicencaArma"));
                pArmas.setDataLicencaArma(conecta.rs.getDate("DataLicencaArma"));
                pArmas.setUnidadeArma(conecta.rs.getString("UnidadeArma"));
                pArmas.setLocalizacaoArma(conecta.rs.getString("LocalizacaoArma"));
                pArmas.setCustoArma(conecta.rs.getFloat("CustoArma"));
                pArmas.setEstoqueArma(conecta.rs.getString("EstoqueArma"));
                pArmas.setFotoArma(conecta.rs.getBytes("FotoArma")); 
                LISTAR_ARAMAS_codigo.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_ARAMAS_codigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<Arma> pDATA_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_ARAMAS_codigo = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT IdArma,SerieArma, "
                    + "NCMArma,DataCadastro,StatusArma,DescricaoArma, "
                    + "ARMAS.IdGrupoArm,DescricaoGrupoArma,MarcaArma,ModeloArma, "
                    + "CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma, "
                    + "PesoArma,MiraArma,AlturaArma,LarguraArma,ComprimentoCanoArma, "
                    + "ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma, "
                    + "RegistroArma,LicencaArma,DataLicencaArma,UnidadeArma, "
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma "
                    + "FROM ARMAS "
                    + "INNER JOIN GRUPO_ARMAS "
                    + "ON ARMAS.IdGrupoArm=GRUPO_ARMAS.IdGrupoArm "
                    + "WHERE DataCadastro='" + pID_grupo.toString().trim() + "' ");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("SerieArma"));
                pArmas.setnCMArma(conecta.rs.getString("NCMArma"));
                pArmas.setDataCadastroArma(conecta.rs.getDate("DataCadastro"));
                pArmas.setStatusArma(conecta.rs.getString("StatusArma"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setIdGrupoArma(conecta.rs.getInt("IdGrupoArm"));
                pArmas.setGrupoArma(conecta.rs.getString("DescricaoGrupoArma"));
                pArmas.setMarcaArma(conecta.rs.getString("MarcaArma"));
                pArmas.setModeloArma(conecta.rs.getString("ModeloArma"));
                pArmas.setCalibreArma(conecta.rs.getString("CalibreArma"));
                pArmas.setCanoArma(conecta.rs.getString("CanoArma"));
                pArmas.setNumeroTirosArma(conecta.rs.getString("NumeroTirosArma"));
                pArmas.setAcabamentoArma(conecta.rs.getString("AcabamentoArma"));
                pArmas.setPesoArma(conecta.rs.getString("PesoArma"));
                pArmas.setMiraArma(conecta.rs.getString("MiraArma"));
                pArmas.setAlturaArma(conecta.rs.getString("AlturaArma"));
                pArmas.setLarguraArma(conecta.rs.getString("LarguraArma"));
                pArmas.setComprimentoCanoArma(conecta.rs.getString("ComprimentoCanoArma"));
                pArmas.setComprimentoTotalArma(conecta.rs.getString("ComprimentoTotalArma"));
                pArmas.setDispositivoSegurancaArma(conecta.rs.getString("DispositivoSegurancaArma"));
                pArmas.setOutrasCaracteristicasArma(conecta.rs.getString("OutrasCaracteristicasArma"));
                pArmas.setRegistroArma(conecta.rs.getString("RegistroArma"));
                pArmas.setLicencaArma(conecta.rs.getString("LicencaArma"));
                pArmas.setDataLicencaArma(conecta.rs.getDate("DataLicencaArma"));
                pArmas.setUnidadeArma(conecta.rs.getString("UnidadeArma"));
                pArmas.setLocalizacaoArma(conecta.rs.getString("LocalizacaoArma"));
                pArmas.setCustoArma(conecta.rs.getFloat("CustoArma"));
                pArmas.setEstoqueArma(conecta.rs.getString("EstoqueArma"));
                pArmas.setFotoArma(conecta.rs.getBytes("FotoArma")); 
                LISTAR_ARAMAS_codigo.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_ARAMAS_codigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public Arma pBUSCAR_codigo(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma "
                    + "FROM ARMAS");
            conecta.rs.last();
            jIdArma.setText(String.valueOf(conecta.rs.getInt("IdArma")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma PESQUISAR_grupo(Arma objArma) {
        jComboBoxGrupoArma.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdGrupoArm,"
                    + "DescricaoGrupoArma "
                    + "FROM GRUPO_ARMAS "
                    + "ORDER BY DescricaoGrupoArma");
            conecta.rs.first();
            do {
                jComboBoxGrupoArma.addItem(conecta.rs.getString("DescricaoGrupoArma"));
            } while (conecta.rs.next());
            jComboBoxGrupoArma.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objArma;
    }

    public void PESQUISAR_grupo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdGrupoArm,DescricaoGrupoArma "
                    + "FROM GRUPO_ARMAS "
                    + "WHERE DescricaoGrupoArma='" + nome + "'");
            conecta.rs.first();
            pCODIGO_grupo = conecta.rs.getInt("IdGrupoArm");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
