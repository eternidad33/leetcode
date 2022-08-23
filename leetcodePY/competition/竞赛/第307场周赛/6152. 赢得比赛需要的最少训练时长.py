from typing import List


class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int],
                         experience: List[int]) -> int:
        # e1为精力值，e2为经验值
        e1, e2 = initialEnergy, initialExperience

        # 最少要训练精力的小时数
        ans = sum(energy) - e1 + 1 if sum(energy) - e1 + 1 > 0 else 0
        e1 += ans

        for i in range(len(experience)):
            if e2 <= experience[i]:
                # 如果经验值小于等于怪物的经验值，须训练经验值
                tmp = experience[i] - e2 + 1
                ans += tmp
                e2 = experience[i] + 1
            # 打败野怪，经验值加，精力值减
            e1 -= energy[i]
            e2 += experience[i]

        return ans


initialEnergy = 1
initialExperience = 1
energy = [1, 1, 1, 1]
experience = [1, 1, 1, 50]
print(Solution().minNumberOfHours(initialEnergy, initialExperience, energy, experience))
