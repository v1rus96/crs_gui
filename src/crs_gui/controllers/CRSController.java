/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.controllers;

import crs_gui.models.Application;
import crs_gui.models.CRS;
import crs_gui.models.Staff;
import crs_gui.models.Trip;
import crs_gui.models.User;
import crs_gui.models.Volunteer;
import crs_gui.views.CRSView;
import crs_gui.views.ManagerView;
import crs_gui.views.StaffView;
import crs_gui.views.VolunteerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class CRSController {

    private CRS crs;

    public CRSController() {
        crs = new CRS();
        initiateUser();
    }

    public CRS getCRS() {
        return crs;
    }

    private void initiateUser() {
        User manager = new Staff("manager", "manager", "James Bond",
                "012-1234567", "Manager", LocalDate.of(2000, 3, 28));
        crs.addUser(manager);
        addOthers();
    }

    public void addOthers() {
        crs.addUser(new Volunteer("benjamin", "benjamin",
                "Benjamin", "012-4"));
        crs.addUser(new Staff("jimmy", "jimmy",
                "Jimmy", "011-1", "Admin", LocalDate.of(2009, 1, 20)));
        crs.addUser(new Staff("jenny", "jenny",
                "Jenny", "011-3", "Junior Admin", LocalDate.of(2020, 11, 11)));
        crs.addUser(new Volunteer("alex", "alex",
                "Alex", "012-5"));
        Trip trip = new Trip("5.5 Richter Scale", "Metropolitan City",
                LocalDate.of(2021, 3, 22), 3, Trip.CrisisType.EARTHQUAKE);
        crs.addTrip(trip);
        ((Staff) crs.getUsers().get(2)).addTrip(trip);
        Application app = new Application(LocalDate.now(),
                trip, (Volunteer) crs.getUsers().get(1));
        trip.addApplication(app);
        app.setTrip(trip);
    }

    public void checkCredentials(String username, String password) {
        User user = crs.findUser(username);
        if (user == null) {
            System.out.println("Not found!");
        } else if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password!");
        } else {
            System.out.println("Found");
            if (user instanceof Volunteer) {
                VolunteerView vView = new VolunteerView(crs, user);
                vView.setVisible(true);
            } else if (user instanceof Staff) {
                Staff staff = (Staff) user;
                if (staff.getPosition().equalsIgnoreCase("Manager")) {
                    ManagerView mView = new ManagerView(crs, user);
                    mView.setVisible(true);
                } else {
                    StaffView sView = new StaffView(crs, user);
                    sView.setVisible(true);
                }
            }
        }
    }

    public void register(String username, String password, String name, String phone) {
        crs.addUser(new Volunteer(
                username,
                password,
                name,
                phone));
    }
    
    public void readnadwrite() {
        try {
            FileOutputStream f = new FileOutputStream(new File("mybean.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(crs);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("mybean.ser"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            CRS crs = (CRS) oi.readObject();
            
            System.out.print(crs);

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
