package main;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;

public class importer {
	/**
	 * Copies a csv file into a arff file;
	 *
	 * @param csv location of csv that will be copied into arff
	 * @param arff name of arff file that will be created
	 * @return      null
	 * @throws IOException 
	 */
	public static void csvToARFF(String csv, String arff) throws IOException {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(csv));
		Instances data = loader.getDataSet();
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(arff));
		saver.setDestination(new File(arff));
		saver.writeBatch();
		
		return;
	}
	
	
	/**
	 * Loads a arff file into a Instances variable for return.
	 *
	 * @param arff name of arff file to load data from
	 * @return instances loaded from arff file
	 */
	public static Instances loadData(String arff) throws Exception {
		DataSource source = new DataSource(arff);
		Instances data = source.getDataSet();
		data.setRelationName("supervised learning dataset");

		return data;
	}
}
