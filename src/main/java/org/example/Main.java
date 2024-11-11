package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 *
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 *
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 *
 */
public class Main {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> sets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        // 将每个用户的收藏转换为集合，并存储在列表中
        for (List<String> companyList : favoriteCompanies) {
            sets.add(new HashSet<>(companyList));
        }

        // 检查每个集合是否是其他集合的子集
        for (int i = 0; i < sets.size(); i++) {
            boolean isSubset = false;
            for (int j = 0; j < sets.size(); j++) {
                if (i != j && sets.get(j).containsAll(sets.get(i))) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) {
                ans.add(i);
            }
        }

        return ans;
    }
}