/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.notice.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Deepak
 */
public class announcementsTableModel extends AbstractTableModel {
    
    private int colnum=5;
    private int rownum;
    private String[] colNames={
        "SrNo","DateOfAnnounce","DateFor","Subject","Details"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableMod
     * @param rse*/
    public announcementsTableModel(ResultSet rs) {
      
      ResultSets=new ArrayList<>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)
            };
            ResultSets.add(row);
      
         }   
      }
      catch(SQLException e){
          System.out.println("Exception in announcementsTableModel");
            }
        
    }
   
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {

       return colNames[param];
    }
    
}
