#include <iostream>
using namespace std;

int main() {
	
	int cheapestBurger = 2000;
	for (int i = 0; i < 3; i++)
	{
		int burger;
		cin >> burger;

		if (burger <= cheapestBurger)
		{
			cheapestBurger = burger;
		}
	}

	int cheapestDrink = 2000;
	for (int i = 0; i < 2; i++)
	{
		int softDrink;
		cin >> softDrink;

		if (softDrink <= cheapestDrink)
		{
			cheapestDrink = softDrink;
		}
	}

	cout << cheapestBurger + cheapestDrink - 50 << endl;
}