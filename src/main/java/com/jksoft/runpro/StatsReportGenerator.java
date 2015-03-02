package com.jksoft.runpro;

import java.util.List;

import com.jksoft.runpro.to.Lap;

public class StatsReportGenerator {

	private static String NEW_LINE = System.lineSeparator();

	public String generateStatsReport(List<Lap> laps) {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (Lap l : laps) {
			sb.append("---------------------------------------").append(
					NEW_LINE);
			sb.append("Okr¹¿enie ").append(i).append(NEW_LINE);
			sb.append("---------------------------------------").append(
					NEW_LINE);
			sb.append(l.generateLapReport()).append(NEW_LINE);

			i++;
		}
		return sb.toString();
	}

}
