package com.jksoft.runpro;

import java.io.File;
import java.io.IOException;
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

public class TcxFileParser {

	public List<Lap> parseTcxFile(File file) {
		List<Lap> laps = new ArrayList<Lap>();

		DocumentBuilder db = createDocumentBuilder();
		Document doc = createDocumentFromXmlFile(file, db);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("Lap");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				laps.add(parseLapElementNode(element));
			}
		}
		return laps;
	}

	private Lap parseLapElementNode(Element element) {
		Lap lap = new Lap();

		lap.setStartTime(DateConverterUtils
				.convertStringToLocalDateTime(element.getAttribute("StartTime")));
		Double d = Double.parseDouble(element
				.getElementsByTagName("TotalTimeSeconds").item(0)
				.getTextContent());
		lap.setDuration(DateConverterUtils.convertTimeInSecondsToDuration(d
				.intValue()));
		lap.setDistance(Double.parseDouble(element
				.getElementsByTagName("DistanceMeters").item(0)
				.getTextContent()));
		lap.setMaxSpeed(Double.parseDouble(element
				.getElementsByTagName("MaximumSpeed").item(0).getTextContent()));
		lap.setCalories(Integer.parseInt(element
				.getElementsByTagName("Calories").item(0).getTextContent()));
		lap.setAvgHeartRate(Integer.parseInt(element
				.getElementsByTagName("AverageHeartRateBpm").item(0)
				.getChildNodes().item(1).getTextContent()));
		lap.setMaxHeartRate(Integer.parseInt(element
				.getElementsByTagName("MaximumHeartRateBpm").item(0)
				.getChildNodes().item(1).getTextContent()));
		lap.setAvgSpeed(Double.parseDouble(element
				.getElementsByTagName("ns2:AvgSpeed").item(0).getTextContent()));

		return lap;
	}

	private Document createDocumentFromXmlFile(File xmlFile, DocumentBuilder db) {
		Document doc;
		try {
			doc = db.parse(xmlFile);
		} catch (SAXException | IOException e) {
			throw new IllegalArgumentException(e);
		}
		return doc;
	}

	private DocumentBuilder createDocumentBuilder() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			return dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new IllegalStateException(e);
		}
	}

}
