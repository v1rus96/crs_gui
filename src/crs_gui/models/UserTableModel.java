/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class UserTableModel extends AbstractTableModel {
    private List<User> users; // for storing items
    private String[] title = {"Name", "Phone"};

    public UserTableModel(List<User> users) {
        setTrips(users);
    }

    public void setTrips(List<User> users) {
        this.users = users;
    }

    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return title[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return user.getName();
            case 1: return user.getPhone();
            default: return "";
        }
    }
}
