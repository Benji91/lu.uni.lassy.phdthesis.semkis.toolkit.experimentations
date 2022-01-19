---
# SEMKIS: Software engineering methodology for the knowledge management of intelligent Systems
## Experimentations and User manual for the SEMKIS domain-specific language (SEMKIS-DSL)
### 1. Project repository informations

SEMKIS is a software engineering methodology for supporting software engineers to engineer deep learning datasets for developing improved neural networks (NN).
We want to support NN software engineers with the software engineering principles in order to produce high-quality neural networks.
Therefore, we introduce an iterative business process supporting the improvement of neural networks via dataset augmentation.
The datasets are engineered based on the customer's requirements and the neural network's recognition skills (key-properties) acquired during the training.

To support our SEMKIS methodology with a tool, we have developed the SEMKIS-toolseet, consisting of a textual editor and the SEMKIS domain-specific language (SEMKIS-DSL).
The SEMKIS-DSL has been developed for support software engineers to support the specification of the requirements and key-properties of neural networks.
The aim is to provide the required methods and tools for analysing the neural network's key-properties and customer's requirements in order to determine and specify a dataset augmentation.
The dataset augmentation specification is used to reengineer the training and testing dataset for improving the neural network during another training.
Each time the neural network has been training, the analysis is performed in order to verify the satisfaction of the reuqirements.
If the requirements are not satisfied, then we reengineer the datasets and retrain the neural network.

This GIT repository contains the experimentations presented in my PhD thesis presenting the SEMKIS methodology.
It contains several specifications of the neural network's requirements and key-properties.

The folder eclipse-workspace-semkis-dsl contains all Eclipse projects related to the SEMKIS-DSL grammar.
The folder runtime-EclipseXtext contains some concrete specifications in the context of the MNIST (recognition of handwritten digits) and meter counter (recognition of the meter counter state) case studies.

### 2. References
- Jahić, Benjamin, Nicolas Guelfi, and Benoît Ries. "Specifying Key-properties to Improve the Recognition Skills of Neural Networks." Proceedings of the 2020 European Symposium on Software Engineering. 2020.
- Jahić, Benjamin, Nicolas Guelfi, and Benoît Ries. "Software engineering for dataset augmentation using generative adversarial networks." 2019 IEEE 10th International Conference on Software Engineering and Service Science (ICSESS). IEEE, 2019.	
- Jahić, Benjamin, Nicolas Guelfi, and Benoît Ries. "SEMKIS-DSL: a Domain-Specific Language for Specifying Neural Network's Key-Properties." Lassy, Technical Report, 2021.


### 3. Run experiment
#### 3.1 Prerequisites
Environmental requirements to be fulfilled before proceeding to the _Execution_.
- Java 1.8+
- Git
- Download and install [Eclipse IDE for Java and DSL developers](https://www.eclipse.org/downloads/packages/)
- Install Sirius package by adding _http://download.eclipse.org/sirius/updates/releases/6.6.0/2020-09_ to your Eclipse installation to reach the update site of Sirius <br>
--To add the URL, go to Help > Install new Software > Add





#### 3.2 Execution
1. Clone the GIT repository containing the project files
2. Import the following projects inside these folders into your eclipse environment: <br>
-- All projects inside: SEMKIS/lu.uni.lassy.phd.dsl.semkis.parent <br>
-- Project: SEMKIS/lu.uni.lassy.phd.dsl.semkis.common
3. In eclipse, open the lu.uni.lassy.phd.dsl.semkis.parent/lu.uni.lassy.phd.dsl.semkis/src/lu.uni.lassy.phd.dsl.semkis package contained in lu.uni.lassy.phd.dsl.semkis.parent 
4. Inside the package, find the Semkis.xtext file
5. Right-click on Semkis.xtext file, then select _Run as_ and _Generate Xtext Artifacts_
6. Once the console outputs _Done_, you know that the artifacts have been generated
7. Now right-click on the lu.uni.lassy.phd.dsl.semkis.parent/lu.uni.lassy.phd.dsl.semkis package, then select _Run as_ and Eclipse Application
8. Wait until a new Eclipse environment has opened
9. Inside the new Eclipse environment, import the semkis experiment project folders:<br>
-- SEMKIS/experiment/countermeter-experiment <br>
-- SEMKIS/experiment/countermeter-specification-experiment <br>
-- SEMKIS/experiment/mnist-specification-experiment


---
