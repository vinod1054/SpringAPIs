package com.vk.inviteweb.datalayer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Event {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String eventId;
	private String eventName;
	private String eventDescription;
	private String eventLocation;
	private String createdBy;
	private String updatedBy;
	private String eventMembers;
	private String eventAdmins;
	private String eventParticipating;
	private String eventMaybe;
	private String eventNotComing;
	private String eventParticipated;
	private Date eventStartDate;
	private Date eventEndDate;
	private Date eventCreatedAt;
	private Date eventUpdatedAt;
	
	String sampleJson="eventName:,eventName,eventDescription,eventLocation,createdBy,updatedBy,eventMembers,eventAdmins,eventParticipating"+
	"eventMaybe,eventNotComing,eventParticipated";
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getEventMembers() {
		return eventMembers;
	}
	public void setEventMembers(String eventMembers) {
		this.eventMembers = eventMembers;
	}
	public String getEventAdmins() {
		return eventAdmins;
	}
	public void setEventAdmins(String eventAdmins) {
		this.eventAdmins = eventAdmins;
	}
	public String getEventParticipating() {
		return eventParticipating;
	}
	public void setEventParticipating(String eventParticipating) {
		this.eventParticipating = eventParticipating;
	}
	public String getEventMaybe() {
		return eventMaybe;
	}
	public void setEventMaybe(String eventMaybe) {
		this.eventMaybe = eventMaybe;
	}
	public String getEventNotComing() {
		return eventNotComing;
	}
	public void setEventNotComing(String eventNotComing) {
		this.eventNotComing = eventNotComing;
	}
	public String getEventParticipated() {
		return eventParticipated;
	}
	public void setEventParticipated(String eventParticipated) {
		this.eventParticipated = eventParticipated;
	}
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public Date getEventCreatedAt() {
		return eventCreatedAt;
	}
	public void setEventCreatedAt(Date eventCreatedAt) {
		this.eventCreatedAt = eventCreatedAt;
	}
	public Date getEventUpdatedAt() {
		return eventUpdatedAt;
	}
	public void setEventUpdatedAt(Date eventUpdatedAt) {
		this.eventUpdatedAt = eventUpdatedAt;
	}
	
	

}
