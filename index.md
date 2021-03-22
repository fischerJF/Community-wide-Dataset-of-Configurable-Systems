   
  <div style="background-color: rgb(189,183,183);  height: 30px">
  <a href="#descr">DATASET ARTIFACTS</a> - <a href="#construction">DATASET CONSTRUCTION</a> - <a href="#references">REFERENCES</a> - <a   href="#contact">CONTACT</a>  
  </div>

  
Test-enriched Configurable System Dataset is composed of 30 configurable systems. This dataset's configurable systems belong to several domains, such as games, text editor, media management, and file compression. Several datasets for the configurable systems have been used. However, this dataset is the first dataset for configurable systems with an extensive test suite. Furthermore, it is an excellent opportunity to share knowledge on test strategies for configurable systems because we use the same test suite towards an unbiased comparison of effectiveness and efficiency of testing strategies for
configurable systems. We believe that our dataset can be a common
point of comparison for configurable system testing strategies.

<h1> <a name="descr">Description of Dataset Artifacts</a></h1>
Choose the configurable systems in the table below to access the related artifacts.
All other configurable systems in our dataset follow the same structure.

1. Feature Model: We provide the feature model in two different
file formats: Guidsl and XML.

2. Metrics: We provide a set of 14 metrics to characterize the
dataset systems. We make these metrics available in a CSV
file. Each line of the file indicates a class of the configurable
system, and the columns indicate the metrics. few examples
of the available metrics are: i) CBO (Coupling between objects):
it counts the number of dependencies a class has; and
ii) WMC (Weight Method Class): it counts the number of
branch instructions in a class. Participants can choose to use
these metrics in their strategies if they wish.

3. Source Code: We provide the source code and test suite for
each configurable system 5. These systems were encoded
with the Java language using the variability encoding technique.
Test approaches that prioritize test cases can choose a
group of available test cases. However, new test cases should
not be included in the challenge.

4. Found Faults: We provide the found failures for the challenge
systems 6. We present these faults in a CSV file that
contains the configuration in which the fault occurred, the
stack trace, and the test case that observed the failure.

5. Analyzed Configurations: We provide the configurations that
we run with for (baseline 1, baseline 2,  CASA, Chvatal, ICPL, IncLing, and YASA). 



|Name 	        |#LOC   | Packages|	Classes	|Methods|Features|	Valid Configurations	  |
|-------        |-------|---------|---------|-------|--------|------- |
|[ArgoUML](pages/ArgoUML.md)             |153,977 |92       |1,812    |	13,034|	8	     |256      |
|[ATM](pages/ATM.md)                     |	 1,160|	2	      |27       |	100   |	7      |80       |	
|[Bankaccount](pages/Bankaccount.md)     |	189   |	3       |	9	      |22     |	10     |144      |
|[Checkstyle](pages/Checkstyle.md)       |	61,435|	14      |	78      |	719	  |141	   |> 2 ^135 | 
|[Chess](pages/Chess.md)                 |	2,149	|7	      |22	      |162	  |3	     |8	       |
|[Companies](pages/Companies.md)         |	2,477	|16	      |50	      |244  	|10	     |192	     |
|[Elevator](pages/Elevator.md)           |	426	  |2	      |7	      |59	    |5	     |20	   	 |
|[Email](pages/Email.md)                 |	429	  |3	      |7	      |49	    |8	     |40	     |
|[FeatureAMP1](pages/FeatureAMP1.md)     |	1,350	|4	      |15	      |93	    |28	      |6732	   |
|[FeatureAMP2](pages/FeatureAMP2.md)     |	2,033	|3	      |14	      |167	  |34	      |7020	   |	
|[FeatureAMP3](pages/FeatureAMP3.md)     |	2,575	|8	      |16	      |223	  |27	      |20500	 |	
|[FeatureAMP4](pages/FeatureAMP4.md)     |	2,147	|2	      |57	      |203	  |27	      |6732	   |	
|[FeatureAMP5](pages/FeatureAMP5.md)     |	1,344	|3	      |9	      |895	  |29	      |3810	   |
|[FeatureAMP6](pages/FeatureAMP6.md)     |	2,418	|8	      |30	      |202	  |38	      |21522   |
|[FeatureAMP7](pages/FeatureAMP7.md)     |	5,644	|3	      |46	      |220	  |29	      |15795   |   
|[FeatureAMP8](pages/FeatureAMP8.md)     | 	2,376	|2	      |6	      |106	  |27	      |15708   |
|[FeatureAMP9](pages/FeatureAMP9.md)     |	1,859	|3	      |8	      |134	  |24	      |6732	   |
|[GPL](pages/GPL.md)                     |	1,235	|3	      |17	      |78	    |13	      |73	     |
|[IntegerSetSPL](pages/IntegerSetSPL.md)  |	200	  |2	      |3	      |20	    |3	      |2	     |
|[Jtopas](pages/Jtopas.md)               |	4397	|7	      |43	      |472    |	5	      |32	     |
|[MinePump](pages/MinePump.md)           |	244	  |2	      |7	      |26	    |7	      |64	     |
|[Notepad](pages/Notepad.md)             |	1564	|4	      |17	      |90	    |17	      |256     |
|[Paycard](pages/Paycard.md)             |	374	  |2	      |8	      |27	    |4	      |6      |
|[Prop4J](pages/Prop4J.md)               |	1,138	|2	      |15	      |90	    |17	      |5029    |
|[Sudoku](pages/Sudoku.md)               |	949	  |2	      |13	      |51	    |6	      |20	   |
|[TaskObserver](pages/TaskObserver.md)   |	486	  |2	      |10	      |33	    |3	      |8	  |
|[Telecom](pages/Telecom.md)             |	273	  |2	      |40	      |11	    |3	      |4	   |
|[UnionFindSPL](pages/UnionFindSPL.md)   |	335	  |2	      |36	      |5	    |13	      |10	 	  |
|[Vending Machine](pages/Vending Machine.md)|	472	  |2	      |7	      |21	    |8	      |256     |
|[ZipMe](pages/ZipMe.md)                 |	4,647 |3	      |311	    |33	    |13	      |24	     |


<H1> <a name="construction">Dataset Construction</a></H1>


We conduct an ad hoc literature review analyzing survey papers on testing configurable systems and well-known datasets of configurable systems

[All configurable systems found in the analyzed repositories](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/ad_hoc_review/ALL.csv)

[The intersection between configurable systems in the repositories analyzed](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/ad_hoc_review/Intersection%20.csv)

[Running Testing Strategies- script](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/Tools)



<h1> <a name="references">References</a></h1>

- Ferreira, Fischer; Vale, Gustavo; Diniz, João Paulo; Figueiredo, Eduardo; 2020. <i>On the Proposal and Evaluation of a Test-enriched Dataset for Configurable Systems.</i> Proceedings of the 14th International Working Conference on Variability Modelling of Software-Intensive Systems (VaMoS).

- Ferreira, Fischer; Viggiato, Markos; Souza, Maurício; Figueiredo, Eduardo; 2020. <i> Testing Configurable Software Systems: The Failure Observation Challenge. </i> Proceedings of the 24th ACM International Systems and Software Product Line Conference  (SPLC).

- Ferreira, Fischer; Diniz, João Paulo; Silva, Cleiton; Figueiredo, Eduardo; 2019. <i> Testing Tools for Configurable Software Systems: A Review-based Empirical Study. </i> Proceedings of the 13th International Working Conference on Variability Modelling of Software-Intensive Systems (VaMoS).



<h1> <a name="contact">Contact</a></h1>

- [Fischer Ferreira](http://labsoft.dcc.ufmg.br/doku.php?id=people:students:fischer_ferreira): fischerjf@dcc.ufmg.br
- [Gustavo Vale](http://labsoft.dcc.ufmg.br/doku.php?id=people:students:gustavo_do_vale): vale@cs.uni-saarland.de
- [João Paulo Diniz](http://labsoft.dcc.ufmg.br/doku.php?id=people:students:joao_diniz): jpaulo@dcc.ufmg.br
- [Eduardo Figueiredo](http://labsoft.dcc.ufmg.br/doku.php?id=people:researchers:eduardo_figueiredo): figueiredo@dcc.ufmg.br

