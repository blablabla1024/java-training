package com.jksoft.runpro;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jksoft.runpro.to.Lap;

public class StatsReportGeneratorTest {

	private final StatsReportGenerator generator = new StatsReportGenerator();

	@Ignore
	@Test
	public void shouldGenerateReportForListWithOneEmptyLap() {

		// given
		List<Lap> laps = new ArrayList<Lap>();
		laps.add(new Lap());
		// when
		String report = generator.generateStatsReport(laps);
		// then
		assertEquals(
				"---------------------------------------\n"
				+ "Okr¹¿enie 1\n"
				+ "---------------------------------------",
				report);
	}

	@Ignore
	@Test
	public void shouldGenerateReportForListWithOneNotEmptyLap() {

		// given
		List<Lap> laps = new ArrayList<Lap>();

		Lap lap = new Lap();
		lap.setStartTime(DateConverterUtils
				.convertStringToLocalDateTime("2015-01-19T19:51:53.750Z"));
		lap.setDuration(1467);
		lap.setDistance(4270.7998046875);
		lap.setMaxSpeed(13.59999942779541);
		lap.setCalories(0);
		lap.setAvgHeartRate(160);
		lap.setMaxHeartRate(168);
		lap.setAvgSpeed(10.477812767028809);

		laps.add(lap);
		// when
		String report = generator.generateStatsReport(laps);
		// then
		assertEquals("expected", report);
	}

	@Ignore
	@Test
	public void shouldGenerateReportForListWithTwoLaps() {

		// given
		List<Lap> laps = new ArrayList<Lap>();
		laps.add(new Lap());
		// when
		String report = generator.generateStatsReport(laps);
		// then
		assertEquals("expected", report);
	}

	@Ignore
	@Test
	public void shouldGenerateReportForListWithThreeLaps() {

		// given
		List<Lap> laps = new ArrayList<Lap>();
		laps.add(new Lap());
		// when
		String report = generator.generateStatsReport(laps);
		// then
		assertEquals("expected", report);
	}

	@Test
	public void shouldGenerateEmptyReport() {

		// given
		List<Lap> laps = new ArrayList<Lap>();
		// when
		String report = generator.generateStatsReport(laps);
		// then
		assertEquals("", report);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNullPassed() {
		// given
		List<Lap> laps = null;
		// when
		generator.generateStatsReport(laps);
		// then
	}
	
	@Test
	public void shouldGenerateLapReport(){
				
		//given
		Lap lap = new Lap();
		lap.setStartTime(DateConverterUtils
				.convertStringToLocalDateTime("2015-01-19T19:51:53.750Z"));
		lap.setDuration(1521);
		lap.setDistance(4270.9998046875);
		lap.setMaxSpeed(13.59999942779541);
		lap.setCalories(352);
		lap.setAvgHeartRate(160);
		lap.setMaxHeartRate(171);
		lap.setAvgSpeed(10.477812767028809);
		//when
		String report = generator.generateLapReport(lap);
		//then
		assertEquals("start:               2015-01-19 19:51\r\n"
				+ "czas trwania:              1521 s\r\n"
				+ "odleg³oœæ:           4271,000 m\r\n"
				+ "prêdkoœæ max.:       13,600 km/h\r\n"
				+ "prêdkoœæ œrednia:    10,478 km/h\r\n"
				+ "kalorie:                    352 kcal\r\n"
				+ "têtno œrednie:              160\r\n"
				+ "têtno max.:                 171\r\n", report);
	}

}
