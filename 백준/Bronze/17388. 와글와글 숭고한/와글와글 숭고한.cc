#include <iostream>
using namespace std;

int main() {
	
	int s, k, h;
	cin >> s >> k >> h;

	if (s + k + h >= 100) 
	{
		cout << "OK" << endl;
	}
	else if (min(s, min(k, h)) == s)
	{
		cout << "Soongsil" << endl;
	}
	else if (min(s, min(k, h)) == k)
	{
		cout << "Korea" << endl;
	}
	else {
		cout << "Hanyang" << endl;
	}
}