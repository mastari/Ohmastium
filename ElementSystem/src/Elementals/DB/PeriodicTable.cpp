  #include "PeriodicTable.h"
#include "../ElementClass.h"
#include <iostream>

void PeriodicTable::returnElement(int an, Element* e) {
	if (an > 118 || an < 1) {
		std::cout << "Element with " << an << " protons does not exist, returning Ytterbium..." << std::endl;
		e->setElement(names[69], 69, electronegativity[69]);
		return;
	}
	e->setElement(names[an - 1], an, electronegativity[an - 1]);
	return;
}

const char* PeriodicTable::names[118] = {
	"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium","Aluminum","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium","Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine","Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium","Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium","Lanthanum","Cerium","Praseodymium","Neodymium","Promethium","Samarium","Europium","Gadolinium","Terbium","Dysprosium","Holmium","Erbium","Thulium","Ytterbium","Lutetium","Hafnium","Tantalum","Tungsten","Rhenium","Osmium","Iridium","Platinum","Gold","Mercury","Thallium","Lead","Bismuth","Polonium","Astatine","Radon","Francium","Radium","Actinium","Thorium","Protactinium","Uranium","Neptunium","Plutonium","Americium","Curium","Berkelium","Californium","Einsteinium","Fermium","Mendelevium","Nobelium","Lawrencium","Rutherfordium","Dubnium","Seaborgium","Bohrium","Hassium","Meitnerium","Darmstadtium","Roentgenium","Copernicium","Nihonium","Flerovium","Moscovium","Livermorium","Tennessine","Oganesson"
};

const char* PeriodicTable::symbols[118] = {
	"H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg","Cn","Nh","Fl","Mc","Lv","Ts","Og"
};

float PeriodicTable::electronegativity[118] = {
	2.20f,(float)NULL,0.98f,1.57f,2.04f,2.55f,3.04f,3.44f,3.98f,(float)NULL,0.93f,1.31f,1.61f,1.90f,2.19f,2.58f,3.16f,(float)NULL,0.82f,1.00f,1.36f,1.54f,1.63f,1.66f,1.55f,1.83f,1.88f,1.91f,1.90f,1.65f,1.81f,2.01f,2.18f,2.55f,2.96f,3.00f,0.82f,0.95f,1.22f,1.33f,1.6f,2.16f,1.9f,2.2f,2.28f,2.20f,1.93f,1.69f,1.78f,1.96f,2.05f,2.1f,2.66f,2.6f,0.79f,0.89f,1.10f,1.12f,1.13f,1.14f,(float)NULL,1.17f,(float)NULL,1.20f,(float)NULL,1.22f,1.23f,1.24f,1.25f,(float)NULL,1.27f,1.3f,1.5f,2.36f,1.9f,2.2f,2.20f,2.28f,2.54f,2.00f,1.62f,2.33f,2.02f,2.0f,2.2f,(float)NULL,(float)NULL,0.9f,1.1f,1.3f,1.5f,1.38f,1.36f,1.28f,1.3f,1.3f,1.3f,1.3f,1.3f,1.3f,1.3f,1.3f,(float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL, (float)NULL
};

const char* PeriodicTable::getSymbol(int an) {
	if (an > 118 || an < 1) {
		std::cout << "Element with " << an << " protons does not exist, returning symbol for Ytterbium..." << std::endl;
		return symbols[69];
	}
	return symbols[an - 1];
}
float PeriodicTable::getElectronegativity(int an) {
	if (an > 118 || an < 1) {
		std::cout << "Element with " << an << " protons does not exist, returning electronegativity for Ytterbium..." << std::endl;
		return electronegativity[69];
	}
	return electronegativity[an - 1];
}