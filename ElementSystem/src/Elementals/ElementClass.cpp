#include "ElementClass.h"
#include "DB/PeriodicTable.h"

const char* Element::getName() {
	return name;
}
void Element::initFromID(unsigned int id) {
	PeriodicTable::returnElement(id, this);
}
float Element::getElectronegativity() {
	return electronegativity;
}
const short unsigned int Element::getProtons() {
	return protons;
}
void Element::setElement(const char* name, unsigned int protons, float electronegativity) {
	this->name = name;
	this->protons = protons;
	this->electronegativity = electronegativity;
}
Element::Element() {}