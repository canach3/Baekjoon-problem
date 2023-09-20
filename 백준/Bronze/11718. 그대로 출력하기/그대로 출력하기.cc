#include <iostream>
#include <string>

using namespace std;

int main() {
	
	string input;
	
	do
	{
		getline(cin, input);
		cout << input << endl;
	} 
	while (empty(input) == 0);
	
	
}