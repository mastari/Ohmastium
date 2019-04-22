#include "AtomClass.h"

//INITS: ion, isotope, raw

Atom::Atom(unsigned int n) {
	initFromID(n);
}

unsigned int Atom::getElectrons() {
	return electrons;
}

unsigned int Atom::getNeutrons() {
	return neutrons;
}

unsigned int Atom::getBasicMass() {
	return getProtons() + getNeutrons();
}

int Atom::getCharge() {
	return getProtons() - getElectrons();
}