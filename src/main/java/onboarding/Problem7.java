package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userMap = new HashMap<>();
        for (String visitor : visitors) {
            userMap.put(visitor, userMap.getOrDefault(visitor, 0) + 1);
        } // 방문한 횟수 당 +1

        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            if (friendMap.containsKey(friend.get(0))) {
                friendMap.get(friend.get(0)).add(friend.get(1));
            } else friendMap.put(friend.get(0), new ArrayList<>(Collections.singleton(friend.get(1))));
            if (friendMap.containsKey(friend.get(1))) {
                friendMap.get(friend.get(1)).add(friend.get(0));
            } else friendMap.put(friend.get(1), new ArrayList<>(Collections.singleton(friend.get(0))));

        }
        List<String> userFriends = friendMap.get(user); // user의 친구 목록
        for (Map.Entry<String, List<String>> entry : friendMap.entrySet()) {
            if (!entry.getKey().equals(user)) {
                for (String f : entry.getValue()) {
                    if (userFriends.contains(f)) {
                        userMap.put(entry.getKey(), userMap.getOrDefault(entry.getKey(), -10) + 10);
                    }
                }
            }
        }

        List<String> answer = userMap.entrySet().stream()
                .filter(entry -> entry.getValue() >0)
                .sorted((e1, e2) -> {
                    int compare = e2.getValue().compareTo(e1.getValue()); // value로 내림차순
                    if (compare != 0)
                        return compare;
                    return e1.getValue().compareTo(e2.getValue()); // 이름으로 오름차순
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        return answer;
    }
}
