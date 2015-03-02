package com.jksoft.runpro;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
