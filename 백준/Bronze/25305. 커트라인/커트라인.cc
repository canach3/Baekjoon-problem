#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	int cutLine;
	cin >> n >> cutLine;

	int* students = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> students[i];
	}

	sort(students, students + n);

	cout << students[n - cutLine] << endl;
}