/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Arma;
import static gestor.Visao.TelaAcessoriosArma.jComboBoxDescricaoAcessorio;
import static gestor.Visao.TelaArmas.jComboBoxGrupoArma;
import static gestor.Visao.TelaArmas.jIdArma;
import static gestor.Visao.TelaArmas.jPesqDescricaoArma;
import static gestor.Visao.TelaArmas.jSerieArma;
import static gestor.Visao.TelaArmas.pID_grupo;
import static gestor.Visao.TelaArmas.pRESPOSTA_grupo;
import static gestor.Visao.TelaArmas.pTOTAL_grupo;
import static gestor.Visao.TelaArmas.pID_arma;
import static gestor.Visao.TelaArmas.pSERIE_arma;
import static gestor.Visao.TelaCodigoBarraArma.pRESPOSTA_codigo;
import static gestor.Visao.TelaCodigoBarraArma.pCODIGO_BArra;
import static gestor.Visao.TelaQRCode_Arama.pCODIGO_QRCODE_arma;
import static gestor.Visao.TelaQRCode_Arama.pCODIGO_QRCode;
import static gestor.Visao.TelaAcessoriosArma.pCODIGO_ACESSORIOS_arma;
import static gestor.Visao.TelaCodigoBarraArma.pCODIGO_BARRA_arma;
import static gestor.Visao.TelaAcessoriosArma.pID_acessorio;
import static gestor.Visao.TelaAcessoriosArma.pRESPOSTA_acessorio;
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
    Integer pCODIGO_acessorio = 0;
    Integer pCODIGO_local = 0;

    public Arma incluirArmas(Arma objArma) {
        PESQUISAR_grupo(objArma.getGrupoArma());
        PESQUISAR_local(objArma.getLocalizacaoArma());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ARMAS (SerieArma,NCMArma,DataCadastroArma,StatusArma,"
                    + "DescricaoArma,IdGrupoArm,MarcaArma,ModeloArma,CalibreArma,CanoArma,NumeroTirosArma,AcabamentoArma,PesoArma,MiraArma,AlturaArma,"
                    + "LarguraArma,ComprimentoCanoArma,ComprimentoTotalArma,DispositivoSegurancaArma,OutrasCaracteristicasArma,RegistroArma,LicencaArma,"
                    + "DataLicencaArma,UnidadeArma,IdLocal,CustoArma,EstoqueArma,FotoArma,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setInt(25, pCODIGO_local);
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
        PESQUISAR_local(objArma.getLocalizacaoArma());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ARMAS SET SerieArma=?,NCMArma=?,DataCadastroArma=?,StatusArma=?,"
                    + "DescricaoArma=?,IdGrupoArm=?,MarcaArma=?,ModeloArma=?,CalibreArma=?,CanoArma=?,NumeroTirosArma=?,AcabamentoArma=?,PesoArma=?,MiraArma=?,AlturaArma=?,"
                    + "LarguraArma=?,ComprimentoCanoArma=?,ComprimentoTotalArma=?,DispositivoSegurancaArma=?,OutrasCaracteristicasArma=?,RegistroArma=?,LicencaArma=?,"
                    + "DataLicencaArma=?,UnidadeArma=?,IdLocal=?,CustoArma=?,EstoqueArma=?,FotoArma=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdArma='" + objArma.getIdArma() + "'");
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
            pst.setInt(25, pCODIGO_local);
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
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma,QRCode "
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
                pArmas.setqRCodeArma(conecta.rs.getBytes("QRCode"));
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
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma,QRCode "
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
                pArmas.setqRCodeArma(conecta.rs.getBytes("QRCode"));
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
            conecta.executaSQL("SELECT "
                    + "a.IdArma, "
                    + "a.SerieArma, "
                    + "a.NCMArma, "
                    + "a.DataCadastro, "
                    + "a.StatusArma, "
                    + "a.DescricaoArma, "
                    + "a.IdGrupoArm, "
                    + "g.DescricaoGrupoArma, "
                    + "a.MarcaArma, "
                    + "a.ModeloArma, "
                    + "a.CalibreArma, "
                    + "a.CanoArma, "
                    + "a.NumeroTirosArma, "
                    + "a.AcabamentoArma, "
                    + "a.PesoArma, "
                    + "a.MiraArma, "
                    + "a.AlturaArma, "
                    + "a.LarguraArma, "
                    + "a.ComprimentoCanoArma, "
                    + "a.ComprimentoTotalArma, "
                    + "a.DispositivoSegurancaArma, "
                    + "a.OutrasCaracteristicasArma, "
                    + "a.RegistroArma, "
                    + "a.LicencaArma, "
                    + "a.DataLicencaArma, "
                    + "a.UnidadeArma, "
                    + "l.DescricaoLocal, "
                    + "a.CustoArma, "
                    + "a.EstoqueArma, "
                    + "a.FotoArma, "
                    + "a.QRCode, "
                    + "a.CodigoBarra "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN GRUPO_ARMAS AS g "
                    + "ON a.IdGrupoArm=g.IdGrupoArm "
                    + "INNER JOIN CODIGO_BARRA_ARMA AS c "
                    + "ON a.IdArma=c.IdArma "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON a.IdLocal=l.IdLocal "
                    + "WHERE a.IdArma='" + pID_grupo.toString().trim() + "' ");
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
                pArmas.setLocalizacaoArma(conecta.rs.getString("DescricaoLocal"));
                pArmas.setCustoArma(conecta.rs.getFloat("CustoArma"));
                pArmas.setEstoqueArma(conecta.rs.getString("EstoqueArma"));
                pArmas.setFotoArma(conecta.rs.getBytes("FotoArma"));
                pArmas.setqRCodeArma(conecta.rs.getBytes("QRCode"));
                pArmas.setCodigoBarra(conecta.rs.getBytes("CodigoBarra"));
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
                    + "LocalizacaoArma,CustoArma,EstoqueArma,FotoArma,QRCode "
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
                pArmas.setqRCodeArma(conecta.rs.getBytes("QRCode"));
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

    public Arma pPESQUISAR_serie(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma,SerieArma "
                    + "FROM ARMAS "
                    + "WHERE SerieArma='" + jSerieArma.getText() + "'");
            conecta.rs.first();
            pID_arma = conecta.rs.getString("IdArma");
            pSERIE_arma = conecta.rs.getString("SerieArma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }
    //-------------------------------------- QRCode ---------------------------------------------------------

    public Arma incluirQRCode(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO QRCODE_ARMA (IdArma,TextoQRCode,QRCode) VALUES(?,?,?)");
            pst.setInt(1, objArma.getIdArma());
            pst.setString(2, objArma.getTextoQRCode());
            pst.setBytes(3, objArma.getqRCodeArma());
            pst.execute();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma alterarQRCode(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE QRCODE_ARMA SET TextoQRCode=?,QRCode=? WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.setString(1, objArma.getTextoQRCode());
            pst.setBytes(2, objArma.getqRCodeArma());
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma excluirQRCode(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM QRCODE_ARMA WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma pBUSCAR_QRCode_codigo(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdQrCodeArma "
                    + "FROM QRCODE_ARMA");
            conecta.rs.last();
            pCODIGO_QRCode = conecta.rs.getInt("IdQrCodeArma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR o código do QRCode.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma pVERIFICAR_QRCode_codigo(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma "
                    + "FROM QRCODE_ARMA "
                    + "WHERE IdArma='" + jIdArma.getText() + "'");
            conecta.rs.first();
            pCODIGO_QRCODE_arma = conecta.rs.getString("IdArma");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objArma;
    }

    public void PESQUISAR_local(String local) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLocal, "
                    + "DescricaoLocal "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI"
                    + "WHERE DescricaoLocal='" + local + "'");
            conecta.rs.first();
            pCODIGO_local = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            Logger.getLogger(ControleArma.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public List<Arma> pPESQUISAR_QRCode_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_ARAMAS_codigo = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma, "
                    + "TextoQRCode, "
                    + "QRCode "
                    + "FROM QRCODE_ARMA "
                    + "WHERE IdArma='" + jIdArma.getText().toString().trim() + "'");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setTextoQRCode(conecta.rs.getString("TextoQRCode"));
                pArmas.setqRCodeArma(conecta.rs.getBytes("QRCode"));
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

    //---------------------------------------- CÓDIGO DE BARRAS ------------------------------------------------
    public Arma incluirCODIGO_barra(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CODIGO_BARRA_ARMA (IdArma,NumeroSerie,CodigoBarra) VALUES(?,?,?)");
            pst.setInt(1, objArma.getIdArma());
            pst.setString(2, objArma.getSerieArma());
            pst.setBytes(3, objArma.getCodigoBarra());
            pst.execute();
            pRESPOSTA_codigo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_codigo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma alterarCODIGO_barra(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CODIGO_BARRA_ARMA SET NumeroSerie=?,CodigoBarra=? WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.setString(1, objArma.getSerieArma());
            pst.setBytes(2, objArma.getCodigoBarra());
            pst.executeUpdate();
            pRESPOSTA_codigo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_codigo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma excluirCODIGO_barra(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CODIGO_BARRA_ARMA WHERE IdArma='" + objArma.getIdArma() + "'");
            pst.executeUpdate();
            pRESPOSTA_codigo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_codigo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma pBUSCAR_CODIGO_barra(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdCodigoBarraArma "
                    + "FROM CODIGO_BARRA_ARMA");
            conecta.rs.last();
            pCODIGO_BArra = conecta.rs.getInt("IdCodigoBarraArma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR o código de barra.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma pVERIFICAR_CODIGO_barra(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma "
                    + "FROM CODIGO_BARRA_ARMA "
                    + "WHERE IdArma='" + jIdArma.getText() + "'");
            conecta.rs.first();
            pCODIGO_BARRA_arma = conecta.rs.getString("IdArma");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objArma;
    }

    public List<Arma> pPESQUISAR_CODIGO_barras_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_CODIGO_barra = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT "
                    + "ARMAS.IdArma, "
                    + "NumeroSerie, "
                    + "DescricaoArma, "
                    + "CodigoBarra "
                    + "FROM CODIGO_BARRA_ARMA "
                    + "INNER JOIN ARMAS "
                    + "ON CODIGO_BARRA_ARMA.IdArma=ARMAS.IdArma "
                    + "WHERE ARMAS.IdArma='" + jIdArma.getText().toString().trim() + "'");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("NumeroSerie"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setCodigoBarra(conecta.rs.getBytes("CodigoBarra"));
                LISTAR_CODIGO_barra.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_CODIGO_barra;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //---------------------------------------------- ACESSÓRIOS --------------------------------------------------------------
    public Arma incluirACESSORIOS(Arma objArma) {
        PESQUISAR_CODIGO_acessorio(objArma.getDescricaoAcessorio());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ACESSORIOS_ARMA (IdArma,IdArmaACE,Quant,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objArma.getIdArma());
            pst.setInt(2, pCODIGO_acessorio);
            pst.setInt(3, objArma.getQuantidade());
            pst.setString(4, objArma.getObservacao());
            pst.setString(5, objArma.getUsuarioInsert());
            pst.setString(6, objArma.getDataInsert());
            pst.setString(7, objArma.getHorarioInsert());
            pst.execute();
            pRESPOSTA_acessorio = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_acessorio = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma alterarACESSORIOS(Arma objArma) {
        PESQUISAR_CODIGO_acessorio(objArma.getDescricaoAcessorio());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ACESSORIOS_ARMA SET IdArmaACE=?,Quant=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAcesArma='" + objArma.getIdAcesArma() + "'");
            pst.setInt(1, pCODIGO_acessorio);
            pst.setInt(2, objArma.getQuantidade());
            pst.setString(3, objArma.getObservacao());
            pst.setString(4, objArma.getUsuarioUp());
            pst.setString(5, objArma.getDataUp());
            pst.setString(6, objArma.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_acessorio = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_acessorio = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma excluirACESSORIOS(Arma objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ACESSORIOS_ARMA WHERE IdAcesArma='" + objArma.getIdAcesArma() + "'");
            pst.executeUpdate();
            pRESPOSTA_acessorio = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_acessorio = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public Arma pBUSCAR_CODIGO_acessorio(Arma objArma) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdAcesArma "
                    + "FROM ACESSORIOS_ARMA");
            conecta.rs.last();
            pCODIGO_ACESSORIOS_arma = conecta.rs.getInt("IdAcesArma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public List<Arma> ACESSORIOS_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<Arma> LISTAR_acessorios = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT ACESSORIOS_ARMA.IdAcesArma, "
                    + "ACESSORIOS_ARMA.IdArma, "
                    + "ACESSORIOS_ARMA.IdArmaACE, "
                    + "ACESSORIOS_ARMA_EPIs.DescricaoArmaACE, "
                    + "ACESSORIOS_ARMA.Quant, "
                    + "ACESSORIOS_ARMA.Observacao "
                    + "FROM ACESSORIOS_ARMA "
                    + "INNER JOIN ARMAS "
                    + "ON ACESSORIOS_ARMA.IdArma=ARMAS.IdArma "
                    + "INNER JOIN ACESSORIOS_ARMA_EPIs "
                    + "ON ACESSORIOS_ARMA.IdArmaACE=ACESSORIOS_ARMA_EPIs.IdArmaACE "
                    + "WHERE ACESSORIOS_ARMA.IdArma='" + jIdArma.getText() + "'");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdAcesArma(conecta.rs.getInt("IdAcesArma"));
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setIdArmaACE(conecta.rs.getInt("IdArmaACE"));
                pArmas.setDescricaoAcessorio(conecta.rs.getString("DescricaoArmaACE"));
                pArmas.setQuantidade(conecta.rs.getInt("Quant"));
                pArmas.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_acessorios.add(pArmas);
                pTOTAL_grupo++;
            }
            return LISTAR_acessorios;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //
    public List<Arma> ACESSORIOS_CODIGO_read() throws Exception {

        conecta.abrirConexao();
        List<Arma> LISTAR_acessorios = new ArrayList<Arma>();
        try {
            conecta.executaSQL("SELECT ACESSORIOS_ARMA.IdAcesArma, "
                    + "ACESSORIOS_ARMA.IdArma, "
                    + "ACESSORIOS_ARMA.IdArmaACE, "
                    + "ACESSORIOS_ARMA_EPIs.DescricaoArmaACE, "
                    + "ACESSORIOS_ARMA.Quant, "
                    + "ACESSORIOS_ARMA.Observacao, "
                    + "ARMAS.SerieArma,ARMAS.DescricaoArma "
                    + "FROM ACESSORIOS_ARMA "
                    + "INNER JOIN ARMAS "
                    + "ON ACESSORIOS_ARMA.IdArma=ARMAS.IdArma "
                    + "INNER JOIN ACESSORIOS_ARMA_EPIs "
                    + "ON ACESSORIOS_ARMA.IdArmaACE=ACESSORIOS_ARMA_EPIs.IdArmaACE "
                    + "WHERE ACESSORIOS_ARMA.IdAcesArma='" + pID_acessorio + "'");
            while (conecta.rs.next()) {
                Arma pArmas = new Arma();
                pArmas.setIdAcesArma(conecta.rs.getInt("IdAcesArma"));
                pArmas.setIdArmaACE(conecta.rs.getInt("IdArmaACE"));
                pArmas.setDescricaoAcessorio(conecta.rs.getString("DescricaoArmaACE"));
                pArmas.setIdArma(conecta.rs.getInt("IdArma"));
                pArmas.setSerieArma(conecta.rs.getString("SerieArma"));
                pArmas.setDescricaoArma(conecta.rs.getString("DescricaoArma"));
                pArmas.setQuantidade(conecta.rs.getInt("Quant"));
                pArmas.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_acessorios.add(pArmas);
            }
            return LISTAR_acessorios;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public Arma PESQUISAR_acessorios(Arma objArma) {
        jComboBoxDescricaoAcessorio.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdArmaACE,"
                    + "DescricaoArmaACE "
                    + "FROM ACESSORIOS_ARMA_EPIs "
                    + "ORDER BY DescricaoArmaACE");
            conecta.rs.first();
            do {
                jComboBoxDescricaoAcessorio.addItem(conecta.rs.getString("DescricaoArmaACE"));
            } while (conecta.rs.next());
            jComboBoxDescricaoAcessorio.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objArma;
    }

    public void PESQUISAR_CODIGO_acessorio(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdArmaACE,"
                    + "DescricaoArmaACE "
                    + "FROM ACESSORIOS_ARMA_EPIs "
                    + "WHERE DescricaoArmaACE='" + nome + "'");
            conecta.rs.first();
            pCODIGO_acessorio = conecta.rs.getInt("IdArmaACE");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //-------------------------------------- HISTÓRICO --------------------------------------
}
