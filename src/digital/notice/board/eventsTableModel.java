/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.notice.board;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Deepak
 */
public class eventsTableModel extends AbstractTableModel {
    
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "SrNo","Start Date","End Date","Details"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public eventsTableModel(ResultSet rs2) {
      
      ResultSets=new ArrayList<>();  
    
      try{
        while(rs2.next()){
      
              String[] row={
                rs2.getString("SrNo"),rs2.getString("StartDate"), rs2.getString("EndDate"), rs2.getString("Details")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in EventsTableModel "+e);
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
