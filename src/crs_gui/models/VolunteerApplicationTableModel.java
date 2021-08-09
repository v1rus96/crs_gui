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
public class VolunteerApplicationTableModel extends AbstractTableModel{
    private List<Trip> trips; // for storing items
    private String[] title = {"Name", "Price", "Remark", "Application"};

    public VolunteerApplicationTableModel(List<Trip> trips) {
        setTrips(trips);
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    
    @Override
    public int getRowCount() {
        return trips.size();
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
        Trip trip = trips.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return trip.getTripID();
            case 1: return trip.getLocation();
            case 2: return trip.getTripDate();
            case 3: return trip.getCrisisType();  
            default: return "";
        }
    }
}
