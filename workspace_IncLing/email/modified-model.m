RunningExample: [VERIFY___] [SIGN___] [KEYS___] [FORWARD___] [ENCRYPT___] [DECRYPT___] [AUTORESPONDER___] [ADDRESSBOOK___] BASE___ :: Program;

%%
 
ENCRYPT___ implies DECRYPT___;
DECRYPT___ implies ENCRYPT___;
ENCRYPT___ implies KEYS___;
SIGN___ implies VERIFY___;
VERIFY___ implies SIGN___;
SIGN___ implies KEYS___;