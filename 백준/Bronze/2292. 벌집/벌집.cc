#include <iostream>
using namespace std;

int main()
{
	int roomNum;
	cin >> roomNum;

	int maxRoomNum = 1;
	int times = 1;

	while (roomNum > maxRoomNum)
	{
		maxRoomNum = maxRoomNum + 6 * times;
		times++;
	}

	cout << times;
}