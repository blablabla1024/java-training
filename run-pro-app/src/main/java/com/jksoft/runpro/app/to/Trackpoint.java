package com.jksoft.runpro.app.to;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trackpoint {
	
	
	private LocalDateTime time; 
	private double altitudeMeters;
	private double distanceMeters;
	private int heartRate;
	private double latitude;
    private double longitude;
    private static DateTimeFormatter formatterToString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    
    
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public void setStartTime(String time){
		this.time = LocalDateTime.parse(time, formatter);
	}
	
	public double getAltitudeMeters() {
		return altitudeMeters;
	}
	public void setAltitudeMeters(double altitudeMeters) {
		this.altitudeMeters = altitudeMeters;
	}
	public double getDistanceMeters() {
		return distanceMeters;
	}
	public void setDistanceMeters(double distanceMeters) {
		this.distanceMeters = distanceMeters;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
        

}
