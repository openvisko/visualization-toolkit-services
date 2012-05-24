package edu.utep.trustlab.toolkitOperators.example;

import javax.jws.WebParam;

/*
 * This is the class that the Web services will be constructed from if you are using a bottom-up approach.
 */
public class ExposedServices {
	
	/*
	 * You need to create a method for each operator template class developed in step 1. You must make sure to name the input
	 * dataset as "url". There can then be an arbitrary number of input parameters, including the empty set.
	 */
	public String wrappedExectuable(
			@WebParam(name="url") String url,
			@WebParam(name="param1")String param1,
			@WebParam(name="param2")String param2,
			@WebParam(name="param3")String param3){
	
		WrappedExecutable wrapper = new WrappedExecutable(url);	//instantiate your template wrapper passing the input url	
		return wrapper.transform(param1, param2, param3);		//call the "transform" method of your template wrapper and return result
	}
}