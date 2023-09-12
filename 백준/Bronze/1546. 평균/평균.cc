#include <iostream>
using namespace std;

int main() {

	int n;
	double score;
	double max = 0;
	double sum = 0;
	cin >> n;

	double* scoreArr = new double[n];

	for (int i = 0; i < n; i++)
	{
		cin >> score;
		scoreArr[i] = score;

		if (score >= max)
		{
			max = score;
		}
	}
	for (int i = 0; i < n; i++)
	{
		scoreArr[i] = scoreArr[i] / max * 100;
		sum += scoreArr[i];
	}

	cout << fixed;
	cout.precision(6);

	cout << sum / n << endl;

}