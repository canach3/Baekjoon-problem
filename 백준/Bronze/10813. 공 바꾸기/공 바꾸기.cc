#include <iostream>
using namespace std;

int main() {
	int n;
	int times;

	cin >> n >> times;

	int* basket = new int[n];

	for (int i = 0; i < n; i++)
	{
		basket[i] = i + 1;
	}

	int p1;
	int p2;
	int temp;

	for (int i = 0; i < times; i++)
	{
		cin >> p1 >> p2;
		
		temp = basket[p1 - 1];
		basket[p1 - 1] = basket[p2 - 1];
		basket[p2 - 1] = temp;
	}

	for (int i = 0; i < n; i++)
	{
		cout << basket[i] << " ";
	}

	delete[] basket;
}