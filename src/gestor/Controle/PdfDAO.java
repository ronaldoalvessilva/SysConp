/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PdfVO;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.PdfView.jCodigoInternoPDF;
import static gestor.Visao.PdfView.txtPesquisa;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ronal
 */
public class PdfDAO {

    int codigoInterno = 0;
    String nomeInternoCrc = "";

    //Método para exibir os PDF´S
    public ArrayList<PdfVO> Listar_PdfVO() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexaoBancoDados con = new ConexaoBancoDados();        
        PdfVO objPdf = new PdfVO();
        objPdf.setIdInternoCrc(Integer.valueOf(jCodigoInternoPDF.getText()));
        con.abrirConexao();
        String sql = "SELECT * FROM PDF_INTERNOS WHERE IdInternoCrc='" + objPdf.getIdInternoCrc() + "'";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId(rs.getInt(1));
                vo.setDescricao(rs.getString(3));
                vo.setDocumento(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconecta();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public ArrayList<PdfVO> ListarDoc_PdfVO() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexaoBancoDados con = new ConexaoBancoDados();        
        PdfVO objPdf = new PdfVO();
        objPdf.setIdInternoCrc(Integer.valueOf(jCodigoInternoPDF.getText()));
        con.abrirConexao();
        String sql = "SELECT * FROM PDF_INTERNOS WHERE DescricaoPdf LIKE'%" + txtPesquisa.getText() + "%' AND IdInternoCrc='" + jCodigoInternoPDF.getText() + "'";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId(rs.getInt(1));
                vo.setDescricao(rs.getString(3));
                vo.setDocumento(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconecta();
            } catch (Exception ex) {
            }
        }
        return list;
    }
    public void inserir_PdfVO(PdfVO vo) {
        ConexaoBancoDados con = new ConexaoBancoDados();
        con.abrirConexao();
        String sql = "INSERT INTO PDF_INTERNOS (IdInternoCrc, DescricaoPdf, DocumentoPdf) VALUES (?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            ps.setInt(1, vo.getIdInternoCrc());
            ps.setString(2, vo.getDescricao());
            ps.setBytes(3, vo.getDocumento());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                con.desconecta();
            } catch (Exception e) {
            }
        }
    }

    public void alterar_PdfVO(PdfVO vo) {
        ConexaoBancoDados con = new ConexaoBancoDados();
        con.abrirConexao();
        String sql = "UPDATE PDF_INTERNOS SET  DescricaoPdf=?, DocumentoPdf=? WHERE IdPdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            ps.setString(1, vo.getDescricao());
            ps.setBytes(2, vo.getDocumento());
            ps.setInt(3, vo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                con.desconecta();
            } catch (Exception e) {
            }
        }
    }

    public void alterar_PdfVO2(PdfVO vo) {
        ConexaoBancoDados con = new ConexaoBancoDados();
        con.abrirConexao();
        PdfVO objPdf = new PdfVO();
        String sql = "UPDATE PDF_INTERNOS SET DescricaoPdf = ? WHERE IdPdf='" + objPdf.getId() + "'";
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            ps.setString(1, vo.getDescricao());
            ps.setInt(2, vo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                con.desconecta();
            } catch (Exception e) {
            }
        }
    }

    public void excluir_PdfVO(PdfVO vo) {
        ConexaoBancoDados con = new ConexaoBancoDados();
        con.abrirConexao();
        ProntuarioCrc objPron = new ProntuarioCrc();
        String sql = "DELETE FROM PDF_INTERNOS WHERE IdPdf='" + vo.getId() + "'";
        PreparedStatement ps = null;
        try {
            ps = con.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                con.desconecta();
            } catch (Exception e) {
            }
        }
    }

    //Método para exibir PDF do banco para a tabela
    public void exibir_PDF(int id) {

        ConexaoBancoDados con = new ConexaoBancoDados();
        con.abrirConexao();
        ProntuarioCrc objPron = new ProntuarioCrc();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        try {
            ps = con.con.prepareStatement("SELECT DocumentoPdf FROM PDF_INTERNOS WHERE IdPdf=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);
            int tamanhoInput = bos.available();
            byte[] dadosPDF = new byte[tamanhoInput];
            bos.read(dadosPDF, 0, tamanhoInput);
            OutputStream out = new FileOutputStream("new.pdf");
            out.write(dadosPDF);
            out.close();
            bos.close();
            ps.close();
            rs.close();
            con.desconecta();
        } catch (IOException | NumberFormatException | SQLException e) {
            System.out.println("Erro ao abrir arquivo PDF. " + e.getMessage());
        }
    }
}
