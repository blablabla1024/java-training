package com.jksoft.runpro.to;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Lap {

	private LocalDateTime startTime;
	private Duration duration;
	private double distance;
	private double maxSpeed;
	private int calories;
	private int avgHeartRate;
	private int maxHeartRate;
	private double avgSpeed;
	private List<Trackpoint> track;

	public Lap() {

	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public void setDuration(int seconds) {
		this.duration = Duration.ofSeconds(seconds);
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setAvgHeartRate(int avgHeartRate) {
		this.avgHeartRate = avgHeartRate;
	}

	public void setMaxHeartRate(int maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}

	public double getAvgSpeed() {
		return avgSpeed;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public double getDistance() {
		return distance;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public int getCalories() {
		return calories;
	}

	public int getAvgHeartRate() {
		return avgHeartRate;
	}

	public int getMaxHeartRate() {
		return maxHeartRate;
	}

	public void setAvgSpeed(double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
}
