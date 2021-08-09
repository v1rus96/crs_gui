/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.models;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Application {
	public enum Status {
		NEW, ACCEPTED, REJECTED;
	}
	
	static int appIdGen = 1;
	private String applicationID;
	private LocalDate applicationDate;
	private Status status;
	private String remarks;
	private Trip trip;
	private Volunteer volunteer;
	
	/**
	 * Constructor for Application
	 * @param appDate Date of application
	 * @param trip Trip the application is associated with.
	 * @param volunteer Volunteer who applied the trip
	 */
	public Application(LocalDate appDate, Trip trip, Volunteer volunteer) {
		setTrip(trip);
		setApplicationID(appIdGen++);
		setApplicationDate(appDate);
		setStatus(Status.NEW);
		setRemarks("");
		setVolunteer(volunteer);
		volunteer.add(this);
	}
	
	/**
	 * @return the volunteer
	 */
	public Volunteer getVolunteer() {
		return volunteer;
	}

	/**
	 * @param volunteer the volunteer to set
	 */
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	/**
	 * @param applicationID the applicationID to set
	 */
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	/**
	 * @return the appIdGen
	 */
	public static int getAppIdGen() {
		return appIdGen;
	}
	
	/**
	 * @param appIdGen the appIdGen to set
	 */
	public static void setAppIdGen(int appIdGen) {
		Application.appIdGen = appIdGen;
	}
	
	/**
	 * @return the applicatonID
	 */
	public String getApplicationID() {
		return applicationID;
	}
	
	/**
	 * @param appID the applicatonID to set
	 */
	public void setApplicationID(int appID) {
		this.applicationID = String.format("A%02d:%s", 
			appID,getTrip().getTripID());;
	}
	
	/**
	 * @return the applicationDate
	 */
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	
	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * @return the trip
	 */
	public Trip getTrip() {
		return trip;
	}
	
	/**
	 * @param trip the trip to set
	 */
	public void setTrip(Trip trip) {
		this.trip = trip;
	}	
	
	/**
	 * @return Details of an application as string
	 */
	public String toString() {
		String str = getApplicationID() + " : " +  
			getTrip().getCrisisType() + " at " + getTrip().getLocation() + " on " +
			getTrip().getTripDate() + " - " + getVolunteer().getName() +
			" status: " + getStatus();
		if (!getRemarks().isEmpty())
			return str + ". Remarks: " + getRemarks();
		else
			return str;
	}
	
	/**
	 * @return True if this application has been processed
	 * by a staff, false otherwise
	 */
	public boolean hasProcessed() {
		return !getStatus().equals(Status.NEW);
	}
}
