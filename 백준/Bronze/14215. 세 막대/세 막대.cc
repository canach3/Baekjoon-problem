#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	int stickArr[3];

	for (int i = 0; i < 3; i++)
	{
		cin >> stickArr[i];
	}

	sort(stickArr, stickArr + 3);

	if (stickArr[0] + stickArr[1] > stickArr[2]) {
		cout << stickArr[0] + stickArr[1] + stickArr[2] << endl;
	}
	else {
		cout << stickArr[0] + stickArr[1] + (stickArr[0] + stickArr[1] - 1) << endl;
	}
}