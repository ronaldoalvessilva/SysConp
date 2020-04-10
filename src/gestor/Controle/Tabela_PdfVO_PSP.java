/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Modelo.PdfVO;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class Tabela_PdfVO_PSP {

    PdfDAO_PSP dao = null;
    public static int count_PdfVO = 0;

    public void visualizar_PdfBean(JTable tabela) {
        tabela.setDefaultRenderer(Object.class, new imgTabela());
        DefaultTableModel dt = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Código");
        dt.addColumn("Descrição");
        dt.addColumn("Documento");
        ImageIcon icone = null;
        if (get_Image("/gestor/Imagens/Pdf16.png") != null) {
            icone = new ImageIcon(get_Image("/gestor/Imagens/Pdf16.png"));
        }
        dao = new PdfDAO_PSP();
        PdfVO bean = new PdfVO();
        ArrayList<PdfVO> list = dao.Listar_PdfVO();

        if (list.size() > 0) {
            count_PdfVO = 0;
            for (int i = 0; i < list.size(); i++) {  
                Object fila[] = new Object[3];
                bean = list.get(i);
                fila[0] = bean.getId();
                fila[1] = bean.getDescricao();
                if (bean.getDocumento() != null) {
                    fila[2] = new JButton(icone);  
                } else {
                    fila[2] = new JButton("Vazio");
                }
                count_PdfVO = count_PdfVO + 1;
                dt.addRow(fila);
            }
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();            
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tabela.setModel(dt);
            tabela.setRowHeight(32);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(30);
            //
            tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        }
    }

    public Image get_Image(String rota) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(rota));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
