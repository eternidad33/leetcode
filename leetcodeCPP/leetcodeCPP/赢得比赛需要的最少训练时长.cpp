#include<iostream>
using namespace std;

class Solution {
public:
	int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
		int ans = 0;
		int s = 0;
		int en = initialEnergy, ex = initialExperience;
		//�ȼ������ж��ֵľ�����
		for (int i = 0; i < energy.size(); i++) {
			s += energy[i];
		}
		ans = s - initialEnergy + 1 > 0 ? s - initialEnergy + 1 : 0;
		//ѵ��������en+
		en += ans;
		for (int j = 0; j < experience.size(); j++) {
			if (ex <= experience[j]) {
				//ѵ�����飬ex+
				ans += experience[j] - ex + 1;
				ex = experience[j] + 1;
			}
			en -= energy[j];
			ex += experience[j];
		}
		return ans;
	}
};