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
public class TripApplicationsTableModel extends AbstractTableModel {
    
    private List<Application> applications; // for storing items
    private String[] title = {"Name", "Price", "Remark", "Application"};

    public TripApplicationsTableModel(List<Application> applications) {
        setApplications(applications);
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public int getRowCount() {
        return applications.size();
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
        Application application = applications.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return application.getApplicationID();
            case 1: return application.getApplicationDate();
            case 2: return application.getStatus();
            case 3: return application.getVolunteer();  
            default: return "";
        }
    }
// User-defined table model MUST override ////
// the following THREE methods ///////////////



}