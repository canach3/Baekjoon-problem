#include <iostream>
using namespace std;

int main() {

	int arr[42] = {};
	int n;
	int cnt = 0;
	
	for (int i = 0; i < 10; i++)
	{
		cin >> n;
		arr[n % 42]++;
	}

	for (int i = 0; i < 42; i++)
	{
		if (arr[i] != 0)
		{
			cnt++;
		}
	}cout << cnt << endl;

	return 0;

}