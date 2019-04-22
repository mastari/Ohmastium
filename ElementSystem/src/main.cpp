#include <iostream>
#include "Atom/AtomClass.h"
#include "Elementals/DB/PeriodicTable.h"
#include "Atomic Utilities/AtomUtils.h"

using namespace std;

int main() {
	Atom a = Atom(4);
	cout << a.getBasicMass();
	//Just a few things ^^
}