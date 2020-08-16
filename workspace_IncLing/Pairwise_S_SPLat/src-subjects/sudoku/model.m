//hared
SPL : BASE___ [STATES___] [UNDO___] [COLOR___] [SOLVER___] [GENERATOR___] [EXTENDEDSUDOKU___] :: _SPL ;

%% // constraints
UNDO___ implies STATES___ ;
GENERATOR___ implies SOLVER___ ;
SOLVER___ implies UNDO___ ;