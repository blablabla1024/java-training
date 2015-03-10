package com.jksoft.runpro;

import static org.junit.Assert.*;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jksoft.runpro.to.Lap;

public class TcxFileParserTest {
	
	private final TcxFileParser tcxFileParser = new TcxFileParser();
	
	
	@Test
	public void shouldParseTcxFileWithOneLap() {
		
		//given
		File file = new FileFinder().findFile("test_file_one_lap.tcx");
		//when
		List<Lap> laps = tcxFileParser.parseTcxFile(file);
		//then
		assertEquals(laps.size(), 1);
		Lap lap = laps.get(0);
		assertEquals(lap.getAvgHeartRate(),155);
		assertEquals(lap.getAvgSpeed(), 10.01242733001709, 0);
		assertEquals(lap.getCalories(), 204);
		assertEquals(lap.getDistance(), 5053.5999755859375, 0);
		assertEquals(lap.getDuration(), Duration.ofSeconds(645));
		assertEquals(lap.getMaxHeartRate(), 178);
		assertEquals(lap.getMaxSpeed(), 11.387699804561237, 0);
		assertEquals(lap.getStartTime(), DateConverterUtils
				.convertStringToLocalDateTime("2015-03-05T10:12:05.125Z"));
		assertEquals(lap.getStartTime().getYear(), 2015);
		assertEquals(lap.getStartTime().getMonthValue(), 3);
		assertEquals(lap.getStartTime().getDayOfMonth(), 5);
		assertEquals(lap.getStartTime().getHour(), 10);
		assertEquals(lap.getStartTime().getMinute(), 12);
		assertEquals(lap.getStartTime().getSecond(), 5);
		assertEquals(lap.getStartTime().getNano(), 125000000);
		
		
	}
	
	@Ignore
	@Test
	public void shouldParseTcxFileWithoutLaps() {
		
		//given
		//when
		//then
		
	}
	
	@Ignore
	@Test
	public void shouldParseTcxFileWithTwoLaps() {
		
		//given
		//when
		//then
		
	}

}
