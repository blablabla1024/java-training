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

public class Stats {
	
	private List<Lap> laps;
	
private static String newLine = System.lineSeparator();

	public Stats(){
		laps = new ArrayList<Lap>();
	}
	
	
	private String trainingToString(){
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(Lap l: laps){
			sb.append("---------------------------------------").append(newLine);
			sb.append("Okr¹¿enie ").append(i).append(newLine);
			sb.append("---------------------------------------").append(newLine);
			sb.append(l.toString()).append(newLine);
			
			i++;
		}
		return sb.toString();
	}
	
	public void execute(String[] args) throws URISyntaxException, ParserConfigurationException, SAXException, IOException{
		
		Path path = Paths.get(ClassLoader.getSystemResource("Jakub_Karbowiak_2015-01-19_20-41-08.tcx").toURI());
		File xmlFile = path.toFile();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder(); 
		Document doc = db.parse(xmlFile);
		
		laps = new ArrayList<Lap>();
			 
		doc.getDocumentElement().normalize();
	 		 
		NodeList nList = doc.getElementsByTagName("Lap");
	 
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);
			
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				
				Lap lap = new Lap();
				
				lap.setStartTime(eElement.getAttribute("StartTime"));
				Double d = Double.parseDouble(eElement.getElementsByTagName("TotalTimeSeconds").item(0).getTextContent());
				lap.setDuration(d.intValue());
				lap.setDistance( Double.parseDouble(eElement.getElementsByTagName("DistanceMeters").item(0).getTextContent()));
				lap.setMaxSpeed(Double.parseDouble(eElement.getElementsByTagName("MaximumSpeed").item(0).getTextContent()));
				lap.setCalories(Integer.parseInt(eElement.getElementsByTagName("Calories").item(0).getTextContent()));
				lap.setAvgHeartRate(Integer.parseInt(eElement.getElementsByTagName("AverageHeartRateBpm").item(0).getChildNodes().item(1).getTextContent()));
				lap.setMaxHeartRate(Integer.parseInt(eElement.getElementsByTagName("MaximumHeartRateBpm").item(0).getChildNodes().item(1).getTextContent()));
				lap.setAvgSpeed(Double.parseDouble(eElement.getElementsByTagName("ns2:AvgSpeed").item(0).getTextContent()));
				
				NodeList nl = eElement.getElementsByTagName("Track").item(0).getChildNodes();
				int j = nl.getLength();
				System.out.println(nl.item(0).getTextContent());
				System.out.println(nl.item(1).getTextContent());
				System.out.println(nl.item(2).getTextContent());
				System.out.println("----");
				
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element) nNode;
				
				laps.add(lap);
			}
		}
		
		System.out.println(trainingToString());
		
	}

	
	public static void main(String[] args){
		
		try {
			new Stats().execute(args);
		} catch (URISyntaxException e) {
			throw new IllegalStateException();
		} catch (ParserConfigurationException e) {
			throw new IllegalStateException();
		} catch (SAXException e) {
			throw new IllegalStateException();
		} catch (IOException e) {
			throw new IllegalStateException();
		}
			
	}

}
