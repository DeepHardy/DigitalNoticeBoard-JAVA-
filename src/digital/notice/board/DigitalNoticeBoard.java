/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.notice.board;

import java.sql.SQLException;

/**
 *
 * @author deepak
 */
public class DigitalNoticeBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        HomePage home=new HomePage();
        home.setVisible(true);
    } 
}
