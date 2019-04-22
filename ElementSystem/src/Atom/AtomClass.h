#pragma once
#include "../Elementals/ElementClass.h";

class Atom : public Element {
public:
	Atom(unsigned int n);
	unsigned int getElectrons();
	unsigned int getNeutrons();
	unsigned int getBasicMass();
	int getCharge();
private:
	unsigned int electrons;
	unsigned int neutrons;
};