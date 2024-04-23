#include <iostream>
#include <string>
using namespace std;

int main() {
	int n;
	cin >> n;

	int i = 0;
	int m = 0;

	while (n != m) {
		i++;
		string iS = to_string(i);

		if (iS.find("666") != string::npos)
		{
			m++;
		}
	}

	 cout << i << endl;
}