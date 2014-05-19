package main;

import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.Instances;

public class cluster {
	/**
	 * Creates a new dataset of input dataset without the labels for unsupervised learning
	 *
	 * @param dataSet the data set that will be removed of its label
	 * @return new dataSet without labels.
	 * @throws Exception 
	 */
	public static void kmeans(Instances dataSet2) throws Exception {
		SimpleKMeans kmeans = new SimpleKMeans();
		
		kmeans.setSeed(10);
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(6);
		kmeans.buildClusterer(dataSet2);
		
		int[] assignments = kmeans.getAssignments();
		
		
		dataSet2.insertAttributeAt(new Attribute("cluster group"), dataSet2.numAttributes());
		
		int i=0;
		for(int clusterNum : assignments) {
		    dataSet2.instance(i).setValue(dataSet2.numAttributes() - 1, clusterNum);
		    i++;
		}
		
		System.out.println(dataSet2.toSummaryString());

	}
}
