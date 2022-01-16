---
# SEMKIS User manual
## 1. Project repository informations
Describe the project repository and the structure of the folders e.g. The folder XxX contains the project files specifying XxX....
## 2. Run experiment
### 2.1 Prerequisites
Environmental requirements to be fulfilled before proceeding to the _Execution_.
- Java 1.8+
- Git
- Download and install [Eclipse IDE for Java and DSL developers](https://www.eclipse.org/downloads/packages/)
- Install Sirius package by adding _http://download.eclipse.org/sirius/updates/releases/6.6.0/2020-09_ to your Eclipse installation to reach the update site of Sirius <br>
--To add the URL, go to Help > Install new Software > Add


### 2.2 Execution
1. Clone the GIT repository containing the project files
2. Import the following project folders into your eclipse environment: <br>
-- SEMKIS/lu.uni.lassy.phd.dsl.semkis.parent <br>
-- SEMKIS/lu.uni.lassy.phd.dsl.semkis.common
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
