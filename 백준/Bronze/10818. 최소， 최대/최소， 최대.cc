#include <iostream>
using namespace std;

int main() {
	int min = 1000001;
	int max = -1000001;
	int n;
	int* arr;

	cin >> n;

	arr = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		if (arr[i] > max)
		{
			max = arr[i];
		}
		if (arr[i] < min)
		{
			min = arr[i];
		}
	}

	cout << min << " " << max << endl;

	delete[] arr;

	return 0;
}