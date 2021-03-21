
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



|Name 	        |#LOC   | Packages|	Classes	|Methods|Features|	VC	   |Var     |	#Test |	Covarege|	Killed mutants|
|-------        |-------|---------|---------|-------|--------|-------  |------- |-------|---------|---------      |
|[ArgoUML](pages/ArgoUML.md)        |153,977|92       |1,812    |	13,034|	8	     |256      |1388    |1,326	 |17%     |9%             |
|[ATM](pages/ATM.md)            |	 1,160|	2	      |27       |	100   |	7      |80       |	44    |	76     |91%     |79%            |
|[Bankaccount](pages/Bankaccount.md)    |	189   |	3       |	9	      |22     |	10     |144      |	13	  |	42     |92%     |62%            |
|[Checkstyle](pages/Checkstyle.md)     |	61,435|	14      |	78      |	719	  |141	   |> 2 ^135 |	180   |719     |38%     | 5%            | 
|[Chess](pages/Chess.md)          |	2,149	|7	      |22	      |162	  |3	     |8	       |20	    |	77	   |72%     |	72%           |
|[Companies](pages/Companies.md)      |	2,477	|16	      |50	      |244  	|10	     |192	     |255	    |	42	   |70%     |	46%           |
|[Elevator](pages/Elevator.md)       |	426	  |2	      |7	      |59	    |5	     |20	     |9		    | 59	   |92%     |	73%           |
|[Email](pages/Email.md)         |	429	  |3	      |7	      |49	    |8	     |40	     |30	    |	85	   |97% 	  |61%            |
|[FeatureAMP1](pages/FeatureAMP1.md)    |	1,350	|4	      |15	      |93	    |28	      |6732	   |40	    |18		   |85%	    |46%            |
|[FeatureAMP2](pages/FeatureAMP2.md)    |	2,033	|3	      |14	      |167	  |34	      |7020	   |55			|18	     |72%     |43%            |	
|[FeatureAMP3](pages/FeatureAMP3.md)    |	2,575	|8	      |16	      |223	  |27	      |20500	 |93	    |	15	    |77%	  |42%            |	
|[FeatureAMP4](pages/FeatureAMP4.md)    |	2,147	|2	      |57	      |203	  |27	      |6732	   |57	    |	12	    |82%    |40%            |	
|[FeatureAMP5](pages/FeatureAMP5.md)    |	1,344	|3	      |9	      |895	  |29	      |3810	   |36	    |	17	    |91%	  |49%           |
|[FeatureAMP6](pages/FeatureAMP6.md)    |	2,418	|8	      |30	      |202	  |38	      |21522   |76		  |	09      |31%	  |46%          |
|[FeatureAMP7](pages/FeatureAMP7.md)    |	5,644	|3	      |46	      |220	  |29	      |15795   |57			|	08	    |28%    | 40%              |   
|[FeatureAMP8](pages/FeatureAMP8.md)    |	2,376	|2	      |6	      |106	  |27	      |15708   |48	    |	78	  	|82%	  |42% 	          |
|[FeatureAMP9](pages/FeatureAMP9.md)    |	1,859	|3	      |8	      |134	  |24	      |6732	   |53	    |	105		  |83%	  |63%	           |
|[GPL](pages/GPL.md)           |	1,235	|3	      |17	      |78	    |13	      |73	     |59	    |	51		  |83%	  |60%	            |
|[IntegerSetSPL](pages/IntegerSetSPL.md)  |	200	  |2	      |3	      |20	    |3	      |2	     |7	      |	19		  |100%   |	80%	         |
|[Jtopas](pages/Jtopas.md)        |	4397	|7	      |43	      |472    |	5	      |32	     |10	    |87			  |67%		  |50%	  |
|[MinePump](pages/MinePump.md)       |	244	  |2	      |7	      |26	    |7	      |64	     |4	      |34		    |91%		  |65%	  |
|[Notepad](pages/Notepad.md)        |	1564	|4	      |17	      |90	    |17	      |256     |24	    |25		    |59%		  |15%	  |
|[Paycard](pages/Paycard.md)       |	374	  |2	      |8	      |27	    |4	      |6	     |10	    |13		    |88%		  |61%	  |
|[Prop4J](pages/Prop4J.md)        |	1,138	|2	      |15	      |90	    |17	      |5029    |17	    |63		    |71%		  |67%	  |
|[Sudoku](pages/Sudoku.md)       |	949	  |2	      |13	      |51	    |6	      |20	     |53	    |35		    |80%		  |67%	  |
|[TaskObserver](pages/TaskObserver.md)  |	486	  |2	      |10	      |33	    |3	      |8	     |9	      |24		    |91%		  |71%	  |
|[Telecom](pages/Telecom.md)      |	273	  |2	      |40	      |11	    |3	      |4	     |6	      |26		    |99%		  |65%	  |
|[UnionFindSPL](pages/UnionFindSPL.md)  |	335	  |2	      |36	      |5	    |13	      |10	     |12	    |40		    |84%		  |66%	  |
|[Vending Machine](pages/Vending Machine.md)|	472	  |2	      |7	      |21	    |8	      |256     |7	      |37		    |97%		  |83%	  |
|[ZipMe](pages/ZipMe.md)          |	4,647 |3	      |311	    |33	    |13	      |24	     |343	    |22		    |41%		  |19%	  |





We conduct an ad hoc literature review analyzing survey papers on testing configurable systems and well-known datasets of configurable systems

[All configurable systems found in the analyzed repositories](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/ad_hoc_review/ALL.csv)

[The intersection between configurable systems in the repositories analyzed](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/ad_hoc_review/Intersection%20.csv)

[Running Testing Strategies- script](https://github.com/fischerJF/Community-wide-Dataset-of-Configurable-Systems/blob/master/Tools)

