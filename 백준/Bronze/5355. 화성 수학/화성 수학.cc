#include <iostream>
#include <string>
using namespace std;

int main() {

	int n;
	cin >> n;
	cin.ignore();

	for (int i = 0; i < n; i++)
	{
		float result;
		cin >> result;

		string ops;
		getline(cin, ops);

		for (int i = 1; i < ops.length(); i++)
		{
			if (ops[i] == '@')
			{
				result *= 3;
			}
			else if (ops[i] == '%')
			{
				result += 5;
			}
			else if (ops[i] == '#')
			{
				result -= 7;
			}
		}

		cout << fixed;
		cout.precision(2);
		cout << result << endl;
	}
}