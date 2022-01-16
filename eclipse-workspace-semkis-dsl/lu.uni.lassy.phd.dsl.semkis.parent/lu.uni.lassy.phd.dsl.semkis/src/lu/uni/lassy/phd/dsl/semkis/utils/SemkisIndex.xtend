package lu.uni.lassy.phd.dsl.semkis.utils

import com.google.inject.Inject
import lu.uni.lassy.phd.dsl.semkis.semkis.SemkisPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider


class SemkisIndex {
	@Inject ResourceDescriptionsProvider rdp

	@Inject IContainer.Manager cm

	def getVisibleEObjectDescriptions(EObject o) {
		o.getVisibleContainers.map [ container |
			container.getExportedObjects
		].flatten
	}

	def getVisibleEObjectDescriptions(EObject o, EClass type) {
		var list = o.getVisibleContainers.map [ container |
			container.getExportedObjectsByType(type)
		].flatten

		//remove duplicates from the list, if any
		return list.toSet()		 		
	}


	def getVisibleDatasetsDescriptions(EObject o) {
		o.getVisibleEObjectDescriptions(SemkisPackage::eINSTANCE.getctDataset)
	}

	
	def getVisibleEquivalenceClassDescriptions(EObject o) {
		o.getVisibleEObjectDescriptions(SemkisPackage::eINSTANCE.getctEquivalenceClass)
	}
	
	
	def getVisibleContainers(EObject o) {
		val index = rdp.getResourceDescriptions(o.eResource)
		val rd = index.getResourceDescription(o.eResource.URI)
		if (rd !== null)
			cm.getVisibleContainers(rd, index)
		else
			emptyList
	}


	def getResourceDescription(EObject o) {
		val index = rdp.getResourceDescriptions(o.eResource)
		index.getResourceDescription(o.eResource.URI)
	}

	def getExportedEObjectDescriptions(EObject o) {
		o.getResourceDescription.getExportedObjects
	}
}