#include <iostream>
using namespace std;

int main() {
	int n;
	int times;

	cin >> n >> times;

	int* basket = new int[n];
	
	for (int i = 0; i < n; i++)
	{
		basket[i] = 0;
	}

	int first;
	int last;
	int ballN;

	for (int i = 0; i < times; i++)
	{
		cin >> first >> last >> ballN;

		for (int j = first - 1; j < last; j++)
		{
			basket[j] = ballN;
		}
	}

	for (int i = 0; i < n; i++)
	{
		cout << basket[i] << " ";
	}

	delete[] basket;
}