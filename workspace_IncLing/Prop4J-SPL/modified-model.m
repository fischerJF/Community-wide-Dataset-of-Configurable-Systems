PROP4JSPL___ : [OPERATORS___] [INPUT_OUTPUT___] [SATSOLVER___] [TO_CNF___] [TESTS___] :: _PROP4JSPL___ ;

OPERATORS___ : [AND___] [OR___] [IMPLIES___] [NEGATION___] [EQUALS___] [EXTENDED___] :: _OPERATORS___ ;

EXTENDED___ : [ATLEAST___] [ATMOST___] [CHOOSE___] :: _EXTENDED___ ;

INPUT_OUTPUT___ : [NODE_READER___] [NODE_WRITER___] :: _INPUT_OUTPUT___ ;

%%

SATSOLVER___ implies TO_CNF___ ;
TO_CNF___ implies EXTENDED___ ;
TESTS___ implies TO_CNF___ and NODE_READER___ ;

