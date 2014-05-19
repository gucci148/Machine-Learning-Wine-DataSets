package main;
import java.io.File;
import java.io.IOException;

import weka.core.*;

public class driver {
	public static void main(String[] args) {
		String csv = "/home/banner/Documents/workspace/machine_learning/files/winelist.csv";
		String arff = "/home/banner/Documents/workspace/machine_learning/files/winelist.arff";
		Instances dataSet1, dataSet2;
		
		File arffFile = new File(arff);
		if(!arffFile.exists()) {	
			try {
				importer.csvToARFF(csv, arff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			dataSet1 = importer.loadData(arff);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			dataSet2 = filter.removeLabel(dataSet1);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		
		try {
			cluster.kmeans(dataSet2);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
