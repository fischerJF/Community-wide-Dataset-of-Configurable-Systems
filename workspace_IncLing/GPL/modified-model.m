GPL : Alg+ [Src] [WEIGHTED___] Gtp BASE___ :: MainGpl ;
Gtp : DIRECTED___ | UNDIRECTED___ ;
Src: Src2 SEARCH___ :: SrcProg;
Src2 : BFS___ | DFS___ ;
Alg : NUMBER___ | CONNECTED___ | STRONGLYCONNECTED___  | CYCLE___ | MSTPRIM___ | MSTKRUSKAL___ | SHORTEST___ ;

%% 
NUMBER___ implies Src;
CONNECTED___ implies (UNDIRECTED___ and Src);
STRONGLYCONNECTED___ implies (DIRECTED___ and DFS___);
CYCLE___ implies (DFS___);
(MSTKRUSKAL___ or MSTPRIM___) implies (UNDIRECTED___ and WEIGHTED___);
(MSTKRUSKAL___ or MSTPRIM___) implies (not (MSTKRUSKAL___ and MSTPRIM___));
SHORTEST___ implies (DIRECTED___ and WEIGHTED___);
