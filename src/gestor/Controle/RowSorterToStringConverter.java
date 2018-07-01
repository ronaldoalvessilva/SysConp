/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author ronal
 */
public class RowSorterToStringConverter extends Converter{
    private JTable table;

    /**
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    @Override
    public Object convertForward(Object value) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return value.toString();
    }

    @Override
    public Object convertReverse(Object mask) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableRowSorter sorter = new TableRowSorter(table.getModel());

        // O seguinte comando torna o filtro case-sensitive. se vocÃª
        // quiser o fitro case-sensitive, descomente a linha abaixo e
        // comente as 7 linhas abaixo dela.
        // sorter.setRowFilter(RowFilter.regexFilter(".*" + mask + ".*"));
        // as seguintes 7 linhas criam um filtro case-sensitive. se vocÃª deseja
        // um filtro case-insensitive, comente essas linhas e descomente a linha 
        // acima.
        String m = mask.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
        }

        sorter.setRowFilter(RowFilter.regexFilter(".*" + sb + ".*"));
        return sorter;
    }
}
