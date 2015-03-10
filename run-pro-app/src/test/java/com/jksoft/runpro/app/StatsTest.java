package com.jksoft.runpro.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jksoft.runpro.app.FileFinder;
import com.jksoft.runpro.app.OutputPrinter;
import com.jksoft.runpro.app.Stats;
import com.jksoft.runpro.app.StatsReportGenerator;
import com.jksoft.runpro.app.TcxFileParser;
import com.jksoft.runpro.app.to.Lap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class StatsTest {
	
	@Test
	public void testExecute() {
		//given
		FileFinder fileFinder = mock(FileFinder.class);
		File file = new File("path");
		String filePath = "Jakub_Karbowiak_2015-01-19_20-41-08.tcx";
		when(fileFinder.findFile(filePath)).thenReturn(file);
		
		TcxFileParser tcxFileParser = mock(TcxFileParser.class);
		List<Lap> laps = new ArrayList<>();
		Lap lap = new Lap();
		lap.setAvgHeartRate(155);
		laps.add(lap);
		when(tcxFileParser.parseTcxFile(file)).thenReturn(laps);
		
		StatsReportGenerator statsReportGenerator = mock(StatsReportGenerator.class);
		String report = "report-test";
		when(statsReportGenerator.generateStatsReport(laps)).thenReturn(report);
		
		OutputPrinter outputPrinter = mock(OutputPrinter.class);
		Stats stats = new Stats(fileFinder, tcxFileParser, statsReportGenerator, outputPrinter);
		//when
		stats.execute(new String[]{filePath});
		//then
		verify(outputPrinter).print(report);
	}

}
