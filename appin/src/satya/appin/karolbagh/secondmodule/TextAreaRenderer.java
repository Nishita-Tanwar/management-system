package satya.appin.karolbagh.secondmodule;


import javax.swing.JTable; 
import javax.swing.JTextArea; 
import javax.swing.table.DefaultTableCellRenderer; 
import javax.swing.table.TableCellRenderer; 
import javax.swing.table.TableColumn; 
import javax.swing.table.TableColumnModel; 
import java.awt.Component; 
import java.util.Enumeration; 
import java.util.HashMap; 
import java.util.Map; 
 

public class TextAreaRenderer extends JTextArea implements TableCellRenderer { 
    private final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); 
 
    private final Map<JTable, Map<Object, Map<Object, Integer>>> tablecellSizes = new HashMap<JTable, Map<Object, Map<Object, Integer>>>(); 
 
    
    public TextAreaRenderer() { 
        setLineWrap(true); 
        setWrapStyleWord(true); 
    } 
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
  boolean hasFocus, int row, int column) 
    { 
        
        renderer.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, column); 
        setForeground(renderer.getForeground()); 
        setBackground(renderer.getBackground()); 
        setBorder(renderer.getBorder()); 
        setFont(renderer.getFont()); 
        setText(renderer.getText()); 
 
        TableColumnModel columnModel = table.getColumnModel(); 
        setSize(columnModel.getColumn(column).getWidth(), 0); 
        int height_wanted = (int) getPreferredSize().getHeight(); 
        addSize(table, row, column, height_wanted); 
        height_wanted = findTotalMaximumRowSize(table, row); 
        if (height_wanted != table.getRowHeight(row)) { 
            table.setRowHeight(row, height_wanted); 
        } 
        return this; 
    } 
 
  
    private void addSize(JTable table, int row, int column, int height) { 
        Map<Object, Map<Object, Integer>> rowsMap = tablecellSizes.get(table); 
        if (rowsMap == null) { 
            tablecellSizes.put(table, rowsMap = new HashMap<Object, Map<Object, Integer>>()); 
        } 
        Map<Object, Integer> rowheightsMap = rowsMap.get(row); 
        if (rowheightsMap == null) { 
            rowsMap.put(row, rowheightsMap = new HashMap<Object, Integer>()); 
        } 
        rowheightsMap.put(column, height); 
    } 
 
   
    private int findTotalMaximumRowSize(JTable table, int row) { 
        int maximum_height = 0; 
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns(); 
        while (columns.hasMoreElements()) { 
            TableColumn tc = columns.nextElement(); 
            TableCellRenderer cellRenderer = tc.getCellRenderer(); 
            if (cellRenderer instanceof TextAreaRenderer) { 
                TextAreaRenderer tar = (TextAreaRenderer) cellRenderer; 
                maximum_height = Math.max(maximum_height, 
                        tar.findMaximumRowSize(table, row)); 
            } 
        } 
        return maximum_height; 
    } 
 
   
    private int findMaximumRowSize(JTable table, int row) { 
        Map<Object, Map<Object, Integer>> rows = tablecellSizes.get(table); 
        if (rows == null) return 0; 
        Map<Object, Integer> rowheights = rows.get(row); 
        if (rowheights == null) return 0; 
        int maximum_height = 0; 
        for (Map.Entry<Object, Integer> entry : rowheights.entrySet()) { 
            int cellHeight = entry.getValue(); 
            maximum_height = Math.max(maximum_height, cellHeight); 
        } 
        return maximum_height; 
    } 
}