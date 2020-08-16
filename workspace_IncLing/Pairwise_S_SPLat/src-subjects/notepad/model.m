// Flattened feature model for Notepad



Notepad : 
[WORDCOUNTTOOLBAR___] [WORDCOUNTMENUBAR___] [WORDCOUNT___]

[UNDOREDOTOOLBAR___] [UNDOREDOMENUBAR___] [UNDOREDO___]

[SEARCHTOOLBAR___] [SEARCHMENUBAR___] [SEARCH___]

[PRINTTOOLBAR___] [PRINTMENUBAR___] [PRINT___]

[PERSISTENCETOOLBAR___] [PERSISTENCEMENUBAR___] [PERSISTENCE___]

[FORMATTOOLBAR___] [FORMATMENUBAR___] [FORMAT___]

[EDITTOOLBAR___] [EDITMENUBAR___] [EDIT___]

[BASETOOLBAR___] [BASEMENUBAR___] BASE___ ::

NotepadProductLine ;



%% // constraints




// One of the two UI mechanisms need to be present
BASEMENUBAR___ or BASETOOLBAR___;

// This feature requires both menubar and toolbar usability's sake.
EDIT___ implies (BASEMENUBAR___ and BASETOOLBAR___);

// We have features like *Feature*ToolBar and *Feature*MenuBar so that
// *Feature* can work with either BASETOOLBAR___ or BASEMENUBAR___.  Without these features,
// we would be required to have both the ToolBar and the MenuBar for a given feature
// due to implementation constraints

WORDCOUNTTOOLBAR___ iff (WORDCOUNT___ and BASETOOLBAR___);
WORDCOUNTMENUBAR___ iff (WORDCOUNT___ and BASEMENUBAR___);

UNDOREDOTOOLBAR___ iff (UNDOREDO___ and BASETOOLBAR___);
UNDOREDOMENUBAR___ iff (UNDOREDO___ and BASEMENUBAR___);

SEARCHTOOLBAR___ iff (SEARCH___ and BASETOOLBAR___);
SEARCHMENUBAR___ iff (SEARCH___ and BASEMENUBAR___);

PRINTTOOLBAR___ iff (PRINT___ and BASETOOLBAR___);
PRINTMENUBAR___ iff (PRINT___ and BASEMENUBAR___);

PERSISTENCETOOLBAR___ iff (PERSISTENCE___ and BASETOOLBAR___);
PERSISTENCEMENUBAR___ iff (PERSISTENCE___ and BASEMENUBAR___);

FORMATTOOLBAR___ iff (FORMAT___ and BASETOOLBAR___);
FORMATMENUBAR___ iff (FORMAT___ and BASEMENUBAR___);

EDITTOOLBAR___ iff (EDIT___ and BASETOOLBAR___);
EDITMENUBAR___ iff (EDIT___ and BASEMENUBAR___);


// Implementation (safegen) constraints
EDITMENUBAR___ implies BASE___; // Notepad.java: 204
FORMAT___ implies BASE___; // Fonts.java: 32
BASEMENUBAR___ implies (BASE___); // Notepad.java: 413
UNDOREDOTOOLBAR___ implies EDITTOOLBAR___; // Notepad.java: 358
WORDCOUNTMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 600
PERSISTENCEMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 518
SEARCHMENUBAR___ implies (BASE___); // Notepad.java: 576
EDIT___ implies BASE___; // Actions.java: 55
FORMAT___ implies (FORMATMENUBAR___); // Actions.java: 90
UNDOREDOMENUBAR___ implies BASE___; // Notepad.java: 302
EDIT___ implies (BASE___); // Actions.java: 57
EDITTOOLBAR___ implies (EDIT___); // Notepad.java: 376
SEARCHMENUBAR___ implies BASE___; // Notepad.java: 260
WORDCOUNT___ implies BASE___; // Actions.java: 602
FORMATTOOLBAR___ implies (FORMAT___); // Notepad.java: 687
EDITTOOLBAR___ implies BASE___; // Notepad.java: 209
PRINT___ implies (BASE___); // Actions.java: 557
PERSISTENCEMENUBAR___ implies (BASE___); // Notepad.java: 519
SEARCHTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 746
EDITTOOLBAR___ implies (BASE___); // Notepad.java: 362
PERSISTENCETOOLBAR___ implies BASE___; // Notepad.java: 245
FORMATTOOLBAR___ implies (BASE___); // Notepad.java: 677
PRINTMENUBAR___ implies BASE___; // Notepad.java: 250
SEARCHTOOLBAR___ implies (SEARCH___); // Notepad.java: 756
FORMATMENUBAR___ implies BASE___; // Notepad.java: 214
SEARCHMENUBAR___ implies BASE___; // Notepad.java: 261
EDITMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 306
EDITTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 362
PERSISTENCE___ implies (BASE___); // ExampleFileFilter.java: 161
WORDCOUNTTOOLBAR___ implies (WORDCOUNT___); // Notepad.java: 772
EDIT___ implies (BASE___); // Actions.java: 57
PRINTMENUBAR___ implies (BASE___); // Notepad.java: 561
UNDOREDOMENUBAR___ implies EDITMENUBAR___; // Notepad.java: 302
WORDCOUNTTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 761
PRINT___ implies BASE___; // PRINT___.java: 24
UNDOREDOMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 303
FORMATMENUBAR___ implies (BASE___); // Notepad.java: 496
PERSISTENCETOOLBAR___ implies (BASE___); // Notepad.java: 693
UNDOREDO___ implies BASE___; // Notepad.java: 118
UNDOREDOTOOLBAR___ implies BASE___; // Notepad.java: 358
PERSISTENCEMENUBAR___ implies BASE___; // Notepad.java: 240
PRINTTOOLBAR___ implies (BASE___); // Notepad.java: 731
WORDCOUNTMENUBAR___ implies (BASE___); // Notepad.java: 601
EDITMENUBAR___ implies BASE___; // Notepad.java: 205
BASEMENUBAR___ implies BASE___; // Notepad.java: 165
UNDOREDO___ implies BASE___; // Notepad.java: 118
FORMATMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 492
WORDCOUNTTOOLBAR___ implies (BASE___); // Notepad.java: 762
EDITMENUBAR___ implies (BASE___); // Notepad.java: 306
BASEMENUBAR___ implies (BASE___); // Notepad.java: 416
EDITMENUBAR___ implies (BASE___); // Notepad.java: 306
FORMATTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 676
PERSISTENCEMENUBAR___ implies BASE___; // Notepad.java: 241
WORDCOUNT___ implies (BASE___); // Actions.java: 608
EDITMENUBAR___ implies (EDIT___); // Notepad.java: 322
PERSISTENCE___ implies BASE___; // Actions.java: 145
PRINTTOOLBAR___ implies BASE___; // Notepad.java: 255
WORDCOUNT___ implies (BASE___); // Actions.java: 608
PERSISTENCE___ implies (BASE___); // Actions.java: 179
PERSISTENCETOOLBAR___ implies (PERSISTENCE___); // Notepad.java: 707
UNDOREDOTOOLBAR___ implies UNDOREDO___; // Notepad.java: 359
FORMAT___ implies BASE___; // Fonts.java: 24
PRINTTOOLBAR___ implies BASE___; // Notepad.java: 256
WORDCOUNTTOOLBAR___ implies BASE___; // Notepad.java: 619
WORDCOUNTTOOLBAR___ implies BASE___; // Notepad.java: 620
FORMAT___ implies (BASE___); // Fonts.java: 54
PERSISTENCETOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 692
SEARCH___ implies (BASE___); // Actions.java: 573
PRINT___ implies BASE___; // Actions.java: 549
PRINTTOOLBAR___ implies (BASE___); // Notepad.java: 733
BASETOOLBAR___ implies (BASE___); // Notepad.java: 627
WORDCOUNTMENUBAR___ implies (WORDCOUNT___); // Notepad.java: 612
EDIT___ implies BASE___; // Actions.java: 56
FORMATTOOLBAR___ implies (BASE___); // Notepad.java: 679
FORMATMENUBAR___ implies (FORMAT___); // Notepad.java: 504
WORDCOUNTMENUBAR___ implies (BASE___); // Notepad.java: 603
BASETOOLBAR___ implies BASE___; // Notepad.java: 181
PRINTTOOLBAR___ implies (PRINT___); // Notepad.java: 741
PERSISTENCEMENUBAR___ implies (PERSISTENCE___); // Notepad.java: 534
FORMAT___ implies (BASE___); // Actions.java: 95
PRINTMENUBAR___ implies BASE___; // Notepad.java: 251
FORMATTOOLBAR___ implies BASE___; // Notepad.java: 236
EDITTOOLBAR___ implies BASE___; // Notepad.java: 210
UNDOREDO___ implies (BASE___); // Notepad.java: 120
BASETOOLBAR___ implies BASE___; // Notepad.java: 180
PERSISTENCE___ implies BASE___; // ExampleFileFilter.java: 39
WORDCOUNTTOOLBAR___ implies (BASE___); // Notepad.java: 764
FORMATMENUBAR___ implies BASE___; // Notepad.java: 215
SEARCHMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 575
WORDCOUNTMENUBAR___ implies BASE___; // Notepad.java: 400
WORDCOUNT___ implies BASE___; // Actions.java: 606
SEARCH___ implies BASE___; // Actions.java: 562
UNDOREDOMENUBAR___ implies UNDOREDO___; // Notepad.java: 303
PRINTMENUBAR___ implies (PRINT___); // Notepad.java: 570
SEARCH___ implies (BASE___); // Actions.java: 575
SEARCHMENUBAR___ implies (SEARCH___); // Notepad.java: 586
SEARCHMENUBAR___ implies (BASE___); // Notepad.java: 576
PRINT___ implies (BASE___); // PRINT___.java: 46
SEARCH___ implies BASE___; // Actions.java: 561
PERSISTENCETOOLBAR___ implies BASE___; // Notepad.java: 246
PRINTTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 730
UNDOREDO___ implies (BASE___); // RedoAction.java: 33
PRINTMENUBAR___ implies BASEMENUBAR___; // Notepad.java: 559
SEARCHTOOLBAR___ implies (BASE___); // Notepad.java: 748
PERSISTENCETOOLBAR___ implies (BASE___); // Notepad.java: 694
FORMATMENUBAR___ implies (BASE___); // Notepad.java: 493
PERSISTENCEMENUBAR___ implies (BASE___); // Notepad.java: 520
SEARCHTOOLBAR___ implies BASE___; // Notepad.java: 269
EDITTOOLBAR___ implies (BASE___); // Notepad.java: 362
BASEMENUBAR___ implies BASE___; // Notepad.java: 164
SEARCHTOOLBAR___ implies (BASE___); // Notepad.java: 747
UNDOREDOTOOLBAR___ implies (BASE___); // Notepad.java: 359
UNDOREDOMENUBAR___ implies (BASE___); // Notepad.java: 303
UNDOREDOTOOLBAR___ implies BASETOOLBAR___; // Notepad.java: 359
WORDCOUNTMENUBAR___ implies BASE___; // Notepad.java: 401
PRINTMENUBAR___ implies (BASE___); // Notepad.java: 560
SEARCHTOOLBAR___ implies BASE___; // Notepad.java: 270
BASETOOLBAR___ implies (BASE___); // Notepad.java: 638
FORMATTOOLBAR___ implies BASE___; // Notepad.java: 235





//<TESTING - remove these
//BASE___ implies (not BASEMENUBAR___);
//BASE___ implies SEARCHTOOLBAR___;
//BASE___ implies WORDCOUNTTOOLBAR___;

