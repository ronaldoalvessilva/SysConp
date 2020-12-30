/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ronal
 */
public class ExportarArquivoCSV {

    //CRIADO EM 30/12/2020 - PARA TESTE. AINDA NÃO FOI TESTADO
    public static void main(String[] args) throws Exception {

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
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ronal\\Downloads\\Documentos\\CADASTRO_VISITAS_INTERNOS.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("CADASTRO_VISITAS_INTERNOS.xlsx written successfully");
    }
}
