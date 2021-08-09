/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.models;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class TripsTableModel extends AbstractTableModel {

    private List<Trip> trips; // for storing items
    private String[] title = {"ID","Description", "Location", "Date", "Type", "Required"};

    public TripsTableModel(List<Trip> trips) {
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
            case 1: return trip.getDescription();
            case 2: return trip.getLocation();
            case 3: return trip.getTripDate();
            case 4: return trip.getCrisisType();  
            case 5: return trip.getNumVolunteers();
            default: return "";
        }
    }
// User-defined table model MUST override ////
// the following THREE methods ///////////////



}
