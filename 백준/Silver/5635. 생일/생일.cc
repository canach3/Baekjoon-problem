#include <iostream>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	string eldest = "";
	string youngest = "";
	int eldestBirthday[3] = { 31, 12, 2010 };
	int youngestBirthday[3] = { 0 };

	for (int i = 0; i < n; i++)
	{
		string name;
		int date, month, year;

		cin >> name >> date >> month >> year;

		if (year <= eldestBirthday[2])
		{
			if (year < eldestBirthday[2])
			{
				eldest = name;
				eldestBirthday[0] = date;
				eldestBirthday[1] = month;
				eldestBirthday[2] = year;
			}
			else if (month <= eldestBirthday[1])
			{
				if (month < eldestBirthday[1])
				{
					eldest = name;
					eldestBirthday[0] = date;
					eldestBirthday[1] = month;
					eldestBirthday[2] = year;
				}
				else if (date <= eldestBirthday[0])
				{
					if (date < eldestBirthday[0])
					{
						eldest = name;
						eldestBirthday[0] = date;
						eldestBirthday[1] = month;
						eldestBirthday[2] = year;
					}
				}	
			}
		}

		if (year >= youngestBirthday[2])
		{
			if (year > youngestBirthday[2])
			{
				youngest = name;
				youngestBirthday[0] = date;
				youngestBirthday[1] = month;
				youngestBirthday[2] = year;
			}
			else if (month >= youngestBirthday[1])
			{
				if (month > youngestBirthday[1])
				{
					youngest = name;
					youngestBirthday[0] = date;
					youngestBirthday[1] = month;
					youngestBirthday[2] = year;
				}
				else if (date >= youngestBirthday[0])
				{
					if (date > youngestBirthday[0])
					{
						youngest = name;
						youngestBirthday[0] = date;
						youngestBirthday[1] = month;
						youngestBirthday[2] = year;
					}
				}
			}
		}
	}

	cout << youngest << "\n" << eldest << endl;
}