#pragma once

class Element {
public:
	const char* getName();
	const short unsigned int getProtons();
	float getElectronegativity();

	void setElement(const char* name, unsigned int protons, float electronegativity);
private:
	const char* name;
	unsigned int protons;
	float electronegativity;
protected:
	void initFromID(unsigned int n);
	Element();
};