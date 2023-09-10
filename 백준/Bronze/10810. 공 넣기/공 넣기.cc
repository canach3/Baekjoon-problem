#include <iostream>
using namespace std;

int main() {
	
	int n, time;
	int first, last, ball;
	int* basArr;
	
	cin >> n >> time;
	
	basArr = new int[n];
	
	for (int i = 0; i < n; i++)
	{
		basArr[i] = 0;
	}

	for (int i = 0; i < time; i++)
	{
		cin >> first >> last >> ball;

		for (int j = first; j <= last; j++)
		{
			basArr[j - 1] = ball;
		}
	}

	for (int i = 0; i < n; i++)
	{
		cout << basArr[i] << " ";
	}
	delete[] basArr;

	return 0;
}