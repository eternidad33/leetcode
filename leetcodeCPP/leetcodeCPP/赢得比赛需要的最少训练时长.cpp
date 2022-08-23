#include<iostream>
using namespace std;

class Solution {
public:
	int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
		int ans = 0;
		int s = 0;
		int en = initialEnergy, ex = initialExperience;
		//先计算所有对手的精力和
		for (int i = 0; i < energy.size(); i++) {
			s += energy[i];
		}
		ans = s - initialEnergy + 1 > 0 ? s - initialEnergy + 1 : 0;
		//训练精力，en+
		en += ans;
		for (int j = 0; j < experience.size(); j++) {
			if (ex <= experience[j]) {
				//训练经验，ex+
				ans += experience[j] - ex + 1;
				ex = experience[j] + 1;
			}
			en -= energy[j];
			ex += experience[j];
		}
		return ans;
	}
};