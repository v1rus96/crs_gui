/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class CRS {
	public enum UserType {
		MANAGER, STAFF, VOLUNTEER
	}
	
	private List<User> users;
	private List<Trip> trips;
	
	/**
	 * Constructor for CRS
	 */
	public CRS() {
		setUsers(new ArrayList<User>());
		setTrips(new ArrayList<Trip>());
	}
	
	/**
	 * Adding user to CRS, could be a Staff or a 
	 * volunteer
	 * @param aUser New user to be added.
	 */
	public void addUser(User aUser) {
		getUsers().add(aUser);
	}
	
	/**
	 * Adding new trip organised by staff.
	 * @param aTrip New trip to be added
	 */
	public void addTrip(Trip aTrip) {
		getTrips().add(aTrip);
	}
	
	/**
	 * Finding a user based on the unique username.
	 * @param username username of user
	 * @return The user whose username matches the
	 * parametric username, null otherwise
	 */
	public User findUser(String username) {
		for (User user: getUsers())
			if (user.getUsername().equalsIgnoreCase(username))
				return user;
		return null;
	}
	
	/**
	 * Find a trip based on the trip ID
	 * @param tripID ID of trip to search
	 * @return Trip which matches parametric ID,
	 * null otherwise
	 */
	public Trip findTrip(String tripID) {
		for (Trip trip: getTrips())
			if (trip.getTripID().equalsIgnoreCase(tripID))
				return trip;
		return null;
	}
	
	/**
	 * @return Number of users in CRS
	 */
	public int numOfUsers() {
		return getUsers().size();
	}
	
	/**
	 * @return Number of organised trips in CRS
	 */
	public int numOfTrips() {
		return getTrips().size();
	}
	
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the trips
	 */
	public List<Trip> getTrips() {
		return trips;
	}
	/**
	 * @param trips the trips to set
	 */
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	/**
	 * @param criteria Criteria used to determine the sorting order
	 * @return String containing the details of all users who is
	 * sorted based on the parametric criteria.
	 */
	public String sortUsers(String criteria) {
		ArrayList<User> usersClone = (ArrayList<User>) getUsers();	
		ArrayList<User> cloneUsers = (ArrayList<User>) usersClone.clone();
		if (criteria.equalsIgnoreCase("name"))
			Collections.sort(cloneUsers);
		String allUsers = "";
		for (User user: cloneUsers)
			allUsers += user + "\n";
		return allUsers;
	}
	
	/**
	 * Returns all applications submitted for trips.
	 * trip 
	 * @return String containing the details of all 
	 * applications submitted for trips.
	 */
	public List<Application> allApplications() {
            List<Application> applications = new ArrayList<Application>();
            for (Trip trip: getTrips()) {
		if (trip.numOfApplications() != 0) {
                    for (Application app: trip.getApplications())
			applications.add(app);
		}
            }
            return applications;
	}
}