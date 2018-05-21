/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import gestor.Modelo.TransferenciaInternos;
import static gestor.Visao.TelaTransfInterno.jIDlanc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensTransfInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensTransInterno objItensTrans = new ItensTransInterno();
    TransferenciaInternos objTrans = new TransferenciaInternos();
    int codInt;
    int qtdUnit = 1;
    int codUnid;
    public static int qtdInternosTransf = 0;

    public ItensTransInterno incluirItensTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        buscarUnidade(objItensTrans.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSTRANSFERENCIA (IdInternoCrc,IdTransf,DataTransf,IdUnid,DocumentoTransf,SaidaConfirmada,QtdTransf,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setInt(4, codUnid);
            pst.setString(5, objItensTrans.getDocumento());
            pst.setString(6, objItensTrans.getConfirmaSaida());
            pst.setInt(7, qtdUnit);
            pst.setString(8, objItensTrans.getUsuarioInsert());
            pst.setString(9, objItensTrans.getDataInsert());
            pst.setString(10, objItensTrans.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno alterarItensTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        buscarUnidade(objItensTrans.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSTRANSFERENCIA  SET IdInternoCrc=?,IdTransf=?,DataTransf=?,IdUnid=?,DocumentoTransf=?,SaidaConfirmada=?,QtdTransf=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensTrans.getIdItemTrans() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setInt(4, codUnid);
            pst.setString(5, objItensTrans.getDocumento());
            pst.setString(6, objItensTrans.getConfirmaSaida());
            pst.setInt(7, qtdUnit);
            pst.setString(8, objItensTrans.getUsuarioUp());
            pst.setString(9, objItensTrans.getDataUp());
            pst.setString(10, objItensTrans.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    //Método para excluir ITENS DE TRANSFERêNCIA
    public ItensTransInterno excluirItensTransf(ItensTransInterno objItensTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSTRANSFERENCIA WHERE IdItem='" + objItensTrans.getIdItemTrans() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensTrans;

    }
    //---------------------------------------- ITENSCRCPORTARIA ----------------------------------------------------------

    // Informa quais internos irão sair VINCULO ENTRE ITENSTRANSFERENCIA E ITENSREGPORTARIA
    public ItensTransInterno incluirItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSCRCPORTARIA (IdInternoCrc,IdSaida,IdItemSaida,DataSaida,DataRetorno,DestinoSaida,DocumentoSaida,SaidaConfirmada,Evadido) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setInt(3, objItensTrans.getIdItemTrans());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            if (objItensTrans.getDataRetorno() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensTrans.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensTrans.getNomeDestino());
            pst.setString(7, objItensTrans.getDocumento());
            pst.setString(8, objItensTrans.getConfirmaSaida());
            pst.setString(9, objItensTrans.getInternoEvadido());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno alterarItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET IdInternoCrc=?,IdSaida=?,IdItemSaida=?,DataSaida=?,DataRetorno=?,DestinoSaida=?,DocumentoSaida=?,SaidaConfirmada=?,Evadido=? WHERE IdItemSaida='" + objItensTrans.getIdItemTrans() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setInt(3, objItensTrans.getIdItemTrans());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            if (objItensTrans.getDataRetorno() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensTrans.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensTrans.getNomeDestino());
            pst.setString(7, objItensTrans.getDocumento());
            pst.setString(8, objItensTrans.getConfirmaSaida());
            pst.setString(9, objItensTrans.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno excluirItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdItemSaida='" + objItensTrans.getIdItemTrans() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    // Buscar INTERNO
    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    // Buscar UNIDADE PENAL
    public void buscarUnidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE WHERE DescricaoUnid='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE PENAL) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<ProntuarioFisicosPenaisInternos> read() throws Exception {
        conecta.abrirConexao();
        List<ProntuarioFisicosPenaisInternos> listaInternosTransf = new ArrayList<ProntuarioFisicosPenaisInternos>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSTRANSFERENCIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSFISICOSINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE ITENSTRANSFERENCIA.IdTransf='" + jIDlanc.getText() + "'");
            while (conecta.rs.next()) {
                ProntuarioFisicosPenaisInternos pProntuarios = new ProntuarioFisicosPenaisInternos();
                pProntuarios.setIdInterno(conecta.rs.getInt("IdInternoCrc"));
                pProntuarios.setMatricula(conecta.rs.getString("MatriculaCrc"));
                pProntuarios.setDataCadast(conecta.rs.getDate("DataCadastCrc"));
                pProntuarios.setDataNasci(conecta.rs.getDate("DataNasciCrc"));
                pProntuarios.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                pProntuarios.setMaeInterno(conecta.rs.getString("MaeInternoCrc"));
                pProntuarios.setPaiInterno(conecta.rs.getString("PaiInternoCrc"));
                pProntuarios.setAlcunha(conecta.rs.getString("AlcunhaCrc"));
                pProntuarios.setRgInterno(conecta.rs.getString("RgInternoCrc"));
                pProntuarios.setCpfInterno(conecta.rs.getString("CpfInternoCrc"));
                pProntuarios.setCartoaSus(conecta.rs.getString("CartaoSus"));
                pProntuarios.setFotoPerfil(conecta.rs.getString("FotoInternoCrc"));
                pProntuarios.setEscolaridade(conecta.rs.getString("EscolaridadeCrc"));
                pProntuarios.setEstadoCivil(conecta.rs.getString("EstadoCivilCrc"));
                pProntuarios.setSexo(conecta.rs.getString("SexoCrc"));
                pProntuarios.setSituacao(conecta.rs.getString("SituacaoCrc"));
                pProntuarios.setPaiInterno(conecta.rs.getString("NomePais"));
                pProntuarios.setCidade(conecta.rs.getString("NomeCidade"));
                pProntuarios.setReligiao(conecta.rs.getString("ReligiaoCrc"));
                pProntuarios.setProfissao(conecta.rs.getString("ProfissaoCrc"));
                pProntuarios.setEndereco(conecta.rs.getString("EnderecoCrc"));
                pProntuarios.setBairro(conecta.rs.getString("BairroCrc"));
                pProntuarios.setCidade(conecta.rs.getString("CidadeCrc"));
                pProntuarios.setEstado(conecta.rs.getString("EstadoCrc"));
                pProntuarios.setCnc(conecta.rs.getString("Cnc"));
                // Tabela Dados Fisicos
                pProntuarios.setCutis(conecta.rs.getString("Cutis"));
                pProntuarios.setOlhos(conecta.rs.getString("Olhos"));
                pProntuarios.setCabelos(conecta.rs.getString("Cabelos"));
                pProntuarios.setBarba(conecta.rs.getString("Barba"));
                pProntuarios.setBigode(conecta.rs.getString("Bigode"));
                pProntuarios.setNariz(conecta.rs.getString("Nariz"));
                pProntuarios.setBoca(conecta.rs.getString("Boca"));
                pProntuarios.setRosto(conecta.rs.getString("Rosto"));
                pProntuarios.setLabios(conecta.rs.getString("Labios"));
                pProntuarios.setCamisa(conecta.rs.getString("Camisa"));
                pProntuarios.setCalca(conecta.rs.getString("Calca"));
                pProntuarios.setSapato(conecta.rs.getString("Sapato"));
                pProntuarios.setPeso(conecta.rs.getString("Peso"));
                pProntuarios.setAltura(conecta.rs.getString("Altura"));
                pProntuarios.setSinais(conecta.rs.getString("Sinais"));
                pProntuarios.setOrelha(conecta.rs.getString("Orelhas"));
                pProntuarios.setPescoco(conecta.rs.getString("Pescoco"));
                pProntuarios.setCompleicao(conecta.rs.getString("Compleicao"));
//                // Tabela Dados Penais
                pProntuarios.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pProntuarios.setDataCrime(conecta.rs.getDate("DataCrime"));
                pProntuarios.setDataPrisao(conecta.rs.getDate("DataPrisao"));
                pProntuarios.setDataCondenacao(conecta.rs.getDate("DataCondenacao"));
                pProntuarios.setParticipacao(conecta.rs.getString("Participacao"));
                pProntuarios.setRegime(conecta.rs.getString("Regime"));
                pProntuarios.setPena(conecta.rs.getString("Pena"));
                pProntuarios.setArtigo1(conecta.rs.getString("Artigo1"));
                pProntuarios.setArtigo2(conecta.rs.getString("Artigo2"));
                pProntuarios.setArtigo3(conecta.rs.getString("Artigo3"));
                pProntuarios.setParagrafo1(conecta.rs.getString("Paragrafo1"));
                pProntuarios.setParagrafo2(conecta.rs.getString("Paragrafo2"));
                pProntuarios.setParagrafo3(conecta.rs.getString("Paragrafo3"));
                pProntuarios.setCrimeEdiondo(conecta.rs.getString("CrimeEdiondo"));
                pProntuarios.setTerminoPena(conecta.rs.getDate("TerminoPena"));
                pProntuarios.setVaraCondenatoria(conecta.rs.getString("VaraCondenatoria"));
                pProntuarios.setDataNovaEntrada(conecta.rs.getDate("DataNovaEntrada"));
                //
                pProntuarios.setIdentificador(conecta.rs.getString("Identificador"));
                pProntuarios.setIdentificador1(conecta.rs.getString("Identificador1"));
                pProntuarios.setIdentificador2(conecta.rs.getString("Identificador2"));
                pProntuarios.setIdentificador3(conecta.rs.getString("Identificador3"));
                pProntuarios.setPerfil(conecta.rs.getString("Perfil"));
                pProntuarios.setRegiaoCorpo(conecta.rs.getString("RegiaoCorpo"));
                pProntuarios.setRegiaoCorpo1(conecta.rs.getString("RegiaoCorpo1"));
                pProntuarios.setRegiaoCorpo2(conecta.rs.getString("RegiaoCorpo2"));
                listaInternosTransf.add(pProntuarios);
                qtdInternosTransf++;
            }
            return listaInternosTransf;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
