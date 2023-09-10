#include <iostream>
using namespace std;

int main() {
	
	int n, time;
	int first, last, temp;
	int* basArr;
	
	cin >> n >> time;
	
	basArr = new int[n];
	
	for (int i = 0; i < n; i++)
	{
		basArr[i] = i + 1;
	}

	for (int i = 0; i < time; i++)
	{
		cin >> first >> last;

		temp = basArr[first - 1];
		basArr[first - 1] = basArr[last - 1];
		basArr[last - 1] = temp;
	}

	for (int i = 0; i < n; i++)
	{
		cout << basArr[i] << " ";
	}

	delete[] basArr;

	return 0;
}