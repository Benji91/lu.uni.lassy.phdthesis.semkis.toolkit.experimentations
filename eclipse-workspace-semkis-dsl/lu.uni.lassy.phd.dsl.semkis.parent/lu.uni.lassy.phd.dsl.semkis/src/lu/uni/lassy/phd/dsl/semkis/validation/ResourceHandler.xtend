package lu.uni.lassy.phd.dsl.semkis.validation


import lu.uni.lassy.phd.dsl.semkis.semkis.ctDataset
import lu.uni.lassy.phd.dsl.semkis.semkis.ctEquivalenceClass


import java.util.List
import org.eclipse.emf.ecore.resource.Resource

class ResourceHandler {
	
	def static getDatasets(List<Resource> input){
		var Iterable<ctDataset> datasets = input.map(r|r.allContents.toIterable.filter(typeof(ctDataset))).flatten
		return datasets
	}
	
	def static getEquivalenceClasses(List<Resource> input){
		var Iterable<ctEquivalenceClass> equivalenceClasses = input.map(r|r.allContents.toIterable.filter(typeof(ctEquivalenceClass))).flatten
		return equivalenceClasses
	}

	
	
}