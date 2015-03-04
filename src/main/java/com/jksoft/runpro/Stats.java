package com.jksoft.runpro;

import java.io.File;
import java.util.List;

import com.jksoft.runpro.to.Lap;

public class Stats {

	public void execute(String[] args) {

		File xmlFile = new FileFinder()
				.findFile("Jakub_Karbowiak_2015-01-19_20-41-08.tcx");

		List<Lap> laps = new TcxFileParser().parseTcxFile(xmlFile);

		System.out
				.println(new StatsReportGenerator().generateStatsReport(laps));

	}

}
