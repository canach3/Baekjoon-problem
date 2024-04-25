#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;

	int* numArr = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> numArr[i];
	}

	sort(numArr, numArr + n);

	for (int i = 0; i < n; i++)
	{
		cout << numArr[i] << endl;
	}
}