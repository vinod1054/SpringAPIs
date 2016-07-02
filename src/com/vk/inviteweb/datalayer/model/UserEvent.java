package com.vk.inviteweb.datalayer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserEvent {

	@Id
	private String userId;
	private String pedingEventsList;
	private String eventsGoing;
	private String eventsMissed;
	private String eventsNotGoing;
	private String adminEvents;
	private String inProgressEvents;
	private String currentLocation;
	private String lastKnownLocation;
	private Date lastLocationUpdated;
	private Date lastUpdated;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPedingEventsList() {
		return pedingEventsList;
	}
	public void setPedingEventsList(String pedingEventsList) {
		this.pedingEventsList = pedingEventsList;
	}
	public String getEventsGoing() {
		return eventsGoing;
	}
	public void setEventsGoing(String eventsGoing) {
		this.eventsGoing = eventsGoing;
	}
	public String getEventsMissed() {
		return eventsMissed;
	}
	public void setEventsMissed(String eventsMissed) {
		this.eventsMissed = eventsMissed;
	}
	public String getEventsNotGoing() {
		return eventsNotGoing;
	}
	public void setEventsNotGoing(String eventsNotGoing) {
		this.eventsNotGoing = eventsNotGoing;
	}
	public String getAdminEvents() {
		return adminEvents;
	}
	public void setAdminEvents(String adminEvents) {
		this.adminEvents = adminEvents;
	}
	public String getInProgressEvents() {
		return inProgressEvents;
	}
	public void setInProgressEvents(String inProgressEvents) {
		this.inProgressEvents = inProgressEvents;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getLastKnownLocation() {
		return lastKnownLocation;
	}
	public void setLastKnownLocation(String lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}
	public Date getLastLocationUpdated() {
		return lastLocationUpdated;
	}
	public void setLastLocationUpdated(Date lastLocationUpdated) {
		this.lastLocationUpdated = lastLocationUpdated;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
