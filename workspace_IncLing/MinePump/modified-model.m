MINEPUMPPL___ : BASE___ :: _MINEPUMPPL___ ;

BASE___ : Command* WaterSensor* methane* :: _BASE___ ;

Command : STARTCOMMAND___
	| STOPCOMMAND___ ;

WaterSensor : HIGHWATERSENSOR___
	| LOWWATERSENSOR___ ;

methane : METHANEQUERY___
	| METHANEALARM___ ;


