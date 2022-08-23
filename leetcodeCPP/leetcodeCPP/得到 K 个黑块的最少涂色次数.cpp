#include<iostream>
using namespace std;

class Solution {
public:
	int minimumRecolors(string blocks, int k) {
		int n = blocks.size();
		int ans = k;
		for (int i = 0; i <= n - k; i++) {
			int cnt = 0;
			for (int j = i; j < i + k; j++) {
				if (blocks[j] == 'W')
					cnt++;
			}
			ans = min(ans, cnt);
		}
		return ans;

	}
};

int main() {
	Solution s;
	string blocks = "WBBWWBBWBW";
	int k = 7;
	int a = s.minimumRecolors(blocks, k);
	cout << a;
	return 0;
}