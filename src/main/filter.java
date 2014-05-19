package main;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class filter {
	/**
	 * Creates a new dataset of input dataset without the labels for unsupervised learning
	 *
	 * @param dataSet the data set that will be removed of its label
	 * @return new dataSet without labels.
	 * @throws Exception 
	 */
	public static Instances removeLabel(Instances dataSet) throws Exception {
		String[] opts = new String[]{ "-R", "12"};
		
		Remove remove = new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(dataSet);
		
		Instances newData = Filter.useFilter(dataSet, remove);
		newData.setRelationName("Unsupervised learning dataset");
		
		return newData;
	}
}
