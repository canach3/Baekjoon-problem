#include <iostream>
#include <string>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	string s;
	
	for (int i = 0; i < n; i++)
	{
		cin >> s;
		cout << s[0] << s[s.length() - 1] << endl;
	}
	
}