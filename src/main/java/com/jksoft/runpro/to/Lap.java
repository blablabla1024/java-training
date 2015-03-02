package com.jksoft.runpro.to;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	private static DateTimeFormatter formatterToString = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm");
	private static DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	private List<Trackpoint> track;

	private static String newLine = System.lineSeparator();

	public Lap() {

	}

	public String generateLapReport() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				String.format("%-20s %16s", "start:",
						startTime.format(formatterToString))).append(newLine);
		sb.append(
				String.format("%-20s %10d s", "czas trwania:",
						duration.getSeconds())).append(newLine);
		sb.append(String.format("%-20s %6.3f m", "odleg³oœæ:", distance))
				.append(newLine);
		sb.append(String.format("%-20s %6.3f km/h", "prêdkoœæ max.:", maxSpeed))
				.append(newLine);
		sb.append(
				String.format("%-20s %6.3f km/h", "prêdkoœæ œrednia:", avgSpeed))
				.append(newLine);
		sb.append(String.format("%-20s %10d kcal", "kalorie:", calories))
				.append(newLine);
		sb.append(String.format("%-20s %10d", "têtno œrednie:", avgHeartRate))
				.append(newLine);
		sb.append(String.format("%-20s %10d", "têtno max.:", maxHeartRate))
				.append(newLine);

		return sb.toString();
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public void setStartTime(String time) {
		this.startTime = LocalDateTime.parse(time, formatter);
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
