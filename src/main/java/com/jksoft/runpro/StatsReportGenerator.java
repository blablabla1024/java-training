package com.jksoft.runpro;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jksoft.runpro.to.Lap;

@Component
public class StatsReportGenerator {

	private static String NEW_LINE = System.lineSeparator();

	public String generateStatsReport(List<Lap> laps) {
		if(laps == null){
			throw new IllegalArgumentException();
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (Lap l : laps) {
			sb.append("---------------------------------------").append(
					NEW_LINE);
			sb.append("Okr¹¿enie ").append(i).append(NEW_LINE);
			sb.append("---------------------------------------").append(
					NEW_LINE);
			sb.append(generateLapReport(l)).append(NEW_LINE);

			i++;
		}
		return sb.toString();
	}

	public String generateLapReport(Lap lap) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				String.format("%-20s %16s", "start:", DateConverterUtils
						.convertLocalDateTimeToString(lap.getStartTime())))
				.append(NEW_LINE);
		sb.append(
				String.format("%-20s %10d s", "czas trwania:",
						lap.getDuration().getSeconds())).append(NEW_LINE);
		sb.append(String.format("%-20s %6.3f m", "odleg³oœæ:", lap.getDistance()))
				.append(NEW_LINE);
		sb.append(String.format("%-20s %6.3f km/h", "prêdkoœæ max.:", lap.getMaxSpeed()))
				.append(NEW_LINE);
		sb.append(
				String.format("%-20s %6.3f km/h", "prêdkoœæ œrednia:", lap.getAvgSpeed()))
				.append(NEW_LINE);
		sb.append(String.format("%-20s %10d kcal", "kalorie:", lap.getCalories()))
				.append(NEW_LINE);
		sb.append(String.format("%-20s %10d", "têtno œrednie:", lap.getAvgHeartRate()))
				.append(NEW_LINE);
		sb.append(String.format("%-20s %10d", "têtno max.:", lap.getMaxHeartRate()))
				.append(NEW_LINE);

		return sb.toString();
	}

}
