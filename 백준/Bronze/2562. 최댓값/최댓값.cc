#include <iostream>
using namespace std;

int main() {
	
	int arr[9];
	int max = 0;
	int idx;

	for (int i = 0; i < 9; i++)
	{
		cin >> arr[i];
		if (arr[i] > max)
		{
			max = arr[i];
			idx = i + 1;
		}
	}

	cout << max << endl;
	cout << idx << endl;

	return 0;
}