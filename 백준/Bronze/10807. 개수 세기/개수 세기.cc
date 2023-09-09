# include <iostream>
using namespace std;

int main() {

	int n, v;
	int arr[101];
	int	count = 0;
	
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	cin >> v;

	for (int i = 0; i < n; i++)
	{
		if (v == arr[i]) {
			count += 1;
		}
	}

	cout << count << endl;

	return 0;
}