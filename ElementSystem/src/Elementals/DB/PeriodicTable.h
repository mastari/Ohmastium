#pragma once
#include "../ElementClass.h"

class PeriodicTable {
public:
	static void returnElement(int an, Element* e);
	static const char* getSymbol(int an);
	static float getElectronegativity(int an);
private:
	PeriodicTable();
	static const char* names[118];
	static const char* symbols[118];
	static float electronegativity[118];
};