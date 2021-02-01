/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitaInterno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ronal
 */
public class ManipularArquivoCSV {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitaInterno objVisita = new VisitaInterno();

    public static String pRESPOSTA = "Sim";

    public static void exportarCSV(String path) throws IOException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa", "W@e3R4#14");
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("USE DB_SOCIALIZA_VC SELECT * FROM VISITASINTERNO");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("CADASTRO_VISITAS_INTERNOS");
            XSSFRow row = spreadsheet.createRow(0);
            XSSFCell cell;
            cell = row.createCell(1);
            cell.setCellValue("IdVisita");
            cell = row.createCell(2);
            cell.setCellValue("NomeVisita");
            cell = row.createCell(3);
            cell.setCellValue("ParentescoVisita");
            cell = row.createCell(4);
            cell.setCellValue("Rg");
            cell = row.createCell(5);
            cell.setCellValue("Cpf");
            int i = 1;
            while (resultSet.next()) {
                row = spreadsheet.createRow(i);
                cell = row.createCell(1);
                cell.setCellValue(resultSet.getInt("Código"));
                cell = row.createCell(2);
                cell.setCellValue(resultSet.getString("Nome Visita"));
                cell = row.createCell(3);
                cell.setCellValue(resultSet.getString("Grau Parentesco"));
                cell = row.createCell(4);
                cell.setCellValue(resultSet.getString("RG"));
                cell = row.createCell(5);
                cell.setCellValue(resultSet.getString("CPF"));
//            cell = row.createCell(6);
//            cell.setCellValue(resultSet.getInt("Ninstalação"));
                i++;
            }
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("CADASTRO_VISITAS_INTERNOS.xlsx written successfully");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManipularArquivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VisitaInterno pEXPORTAR_ARQ_VISITA_csv(String pathDestino) throws FileNotFoundException, IOException {
        String sql = "SELECT * FROM VISITASINTERNO";
        int i = 1;
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("CADASTRO_VISITAS_INTERNOS");
            XSSFRow row = spreadsheet.createRow(0);
            XSSFCell cell;
            conecta.rs.first();
            do {
                cell = row.createCell(1);
                cell.setCellValue("IdVisita");
                cell = row.createCell(2);
                cell.setCellValue("NomeVisita");
                cell = row.createCell(3);
                cell.setCellValue("ParentescoVisita");
                cell = row.createCell(4);
                cell.setCellValue("Rg");
                cell = row.createCell(5);
                cell.setCellValue("Cpf");

            } while (conecta.rs.next());
            row = spreadsheet.createRow(i);
            cell = row.createCell(1);
            cell.setCellValue(conecta.rs.getInt("Código"));
            cell = row.createCell(2);
            cell.setCellValue(conecta.rs.getString("Nome Visita"));
            cell = row.createCell(3);
            cell.setCellValue(conecta.rs.getString("Grau Parentesco"));
            cell = row.createCell(4);
            cell.setCellValue(conecta.rs.getString("RG"));
            cell = row.createCell(5);
            cell.setCellValue(conecta.rs.getString("CPF"));
            i++;
            FileOutputStream out = new FileOutputStream(new File(pathDestino));
            workbook.write(out);
            out.close();
            System.out.println("CADASTRO_VISITAS_INTERNOS.xlsx written successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ManipularArquivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
