package com.jksoft.runpro;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jksoft.runpro.to.Lap;

@Component
public class Stats {

	private final FileFinder fileFinder;
	private final TcxFileParser tcxFileParser;
	private final StatsReportGenerator statsReportGenerator;
	private final OutputPrinter outputPrinter;

	@Autowired
	public Stats(FileFinder fileFinder, TcxFileParser tcxFileParser,
			StatsReportGenerator statsReportGenerator, OutputPrinter consoleOutputPrinter) {
		this.fileFinder = fileFinder;
		this.tcxFileParser = tcxFileParser;
		this.statsReportGenerator = statsReportGenerator;
		this.outputPrinter = consoleOutputPrinter;
	}

	public void execute(String[] args) {

		File xmlFile = fileFinder.findFile(args[0]);

		List<Lap> laps = tcxFileParser.parseTcxFile(xmlFile);

		String report = statsReportGenerator.generateStatsReport(laps);
		
		outputPrinter.print(report);

	}

}
