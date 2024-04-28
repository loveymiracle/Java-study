// 해시 > 베스트 앨범
package ex05;

import java.util.*;

// genres											plays						return
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
// TC 너무 적은 문제로 TC 좀 만들어서 간다!
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 500, 500, 2500]	[4, 1, 0, 2]
// -> 재생횟수가 같은 노래가 많은 경우는 ? -> 고유번호가 낮아야 한다.
// ["classic", "classic", "classic", "classic", "pop"]	[500, 500, 500, 500, 2500]	[4, 0, 1]
// ["classic", "classic", "classic", "classic", "classic"]	[500, 500, 500, 500, 2500]	[4, 0]

// 요구 사항
// 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
// 제한사항
// 1. genres[i]는 고유번호가 i인 노래의 장르입니다.
// 2. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
// 3. genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
// 4. 장르 종류는 100개 미만입니다.
// 5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
// 6. 모든 장르는 재생된 횟수가 다릅니다.

// 알고리즘 전략
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
// 0. 자료구조 고민해야 한다.
//   -> 장르별 플레이시간을 모은 자료구조 하나 필요 -> 장르별 우선순위 정렬하기 위한 용도
//   -> 장르별 플레이시간별 index로 계산되어 장르 내에서 정렬할 자료 구조 하나 필요
// 1. 장르별 플레이시간을 묶어 일종의 ID를 만들고 index를 맵핑하는 자료구조를 만든다.
//  - 장르가 classic이고 플레이시간이 500이면 인덱스가 0이면 -> classic500(key) : 0(value)
//    classic500:0
//    pop600:1
//    classic150:2
//    classic800:3
//    pop2500:4
// 2. 장르별 플레이시간을 더해서 map-list 형태로 다시 구현 (이걸 첫번째로 먼저 만들었다)
//  - classic : [800, 500, 150]
//  - pop : [2500, 150]
// 3. 전체 재생시간을 구하고 장르별 우선순위를 정리
//  - 1순위 : 2500 + 600 = 3100, pop이 1순위
//  - 2순위 : 800 + 500 + 150 = 1450, classic이 2순위
// 4. 장르별 우선순위와 장르별로 가장 많이 재생된 곡을 찾아와 index로 변환하여 답을 출력
//  - pop 2500-4, 600-1
//  - classic 800-3, 500-0

public class Solution {
	
	public int[] solution(String[] genres, int[] plays) {
		// 장르, 장르 별 플레이시간이 정렬된 리스트
		Map<String, Set<Integer>> genresTimeMap = new HashMap<>();
		
		// 고유id (장르+플레이시간)를 index로 환산시켜주는 자료구조
		// -> 만일 자을와 플레이시간이 같은 경우? -> index가 낮은 상태로 정렬
		Map<Long, Set<Integer>> idToIndexMap = new TreeMap<>();
		
		// 장르별 모든 재생시간을 구하는 Map
		// pop-3100, classic-1450
		Map<String, Integer> genresToTotalTimeMap = new HashMap<>();
		
		// 초기화 로직
		for(int i = 0; i < genres.length; i++) {
			// idToIndexMap 초기화 부
			long idKey = (long)genres[i].hashCode() * 100000 + plays[i]; // 고유 hash key 알고리즘
//			System.out.println(genres[i]);
//			System.out.println(plays[i]);
//			System.out.println(idKey);
			if(idToIndexMap.get(idKey) == null) {
				idToIndexMap.put(idKey, new TreeSet<>());
			}
			idToIndexMap.get(idKey).add(i);
			// genresTimeMap 초기화 부
			if(genresTimeMap.get(genres[i]) == null) {
				genresTimeMap.put(genres[i], new TreeSet<>());
			}
			genresTimeMap.get(genres[i]).add(plays[i]);
			
			// genresToTotalTimeMap 초기화 부
//			genresToTotalTimeMap.put(genres[i],
//					genresToTotalTimeMap.getOrDefault(genres[i], 0) + plays[i]);
			if(genresToTotalTimeMap.get(genres[i]) == null) {
				genresToTotalTimeMap.put(genres[i], 0);
			}
			genresToTotalTimeMap.put(genres[i],
					genresToTotalTimeMap.get(genres[i]) + plays[i]);
		}
		System.out.println("idToIndexMap");
		System.out.println(idToIndexMap + "\n"); // {11118500600=[1], 11118502500=[4], 85362088200500=[0, 2, 3]}
		System.out.println("genresTimeMap");
		System.out.println(genresTimeMap + "\n"); // {pop=[600, 2500], classic=[500]}
		System.out.println("genresToTotalTimeMap");
		System.out.println(genresToTotalTimeMap + "\n"); // {pop=3100, classic=1500}
		
		// 장르별 우선순위 선정하는 알고리즘
		// 전체 시간을 가져오면 장르를 가져오는 genresToTotalTimeMap 역맵
		// -> TreeMap 만든 이유 : 장르별 재생시간순으로 정렬하기 위함
		Map<Integer, String> totalTimeToGenresMap = new TreeMap<>();
		Set<String> keySet = genresToTotalTimeMap.keySet(); // Type mismatch: cannot convert from Set<String> to String
		for(String key : keySet) {
			totalTimeToGenresMap.put(genresToTotalTimeMap.get(key), key);
		}
		
		System.out.println("totalTimeToGenresMap");
		System.out.println(totalTimeToGenresMap + "\n"); // {1500=classic, 3100=pop}
		
		// 수록곡을 선정하는 과정
		int[] answer = new int[genres.length]; // 크기 미정인 상태!
		int count = 0; // 수록된 곡의 갯수, 나중에 자를 예정!
		Set<Integer> keySet2 = totalTimeToGenresMap.keySet();
		List<Integer> list = new ArrayList<>(keySet2);
		Collections.reverse(list); // 장르별 재생시간으로 내림차순으로 정렬된 리스트
		System.out.println(list);
		
		for(int genresTotalTime : list) {
			String genre = totalTimeToGenresMap.get(genresTotalTime); // 가장 많이 재생된 장르부터 뽑아온다.
			System.out.println(genre); // pop, classic
			Set<Integer> set = genresTimeMap.get(genre);
			System.out.println(set);
			List<Integer> genreMusicList = new ArrayList<>(set);
			Collections.reverse(genreMusicList);
			System.out.println(genreMusicList);
			System.out.println("genre");
			
			int i = 0;
			out : for(int musicTime : genreMusicList) {
				long idKey = (long)genre.hashCode() * 100000 + musicTime;
//				System.out.println(idKey);
				Set<Integer> indexSet = idToIndexMap.get(idKey);
//				System.out.println(indexSet);
				for(int index : indexSet) {
					answer[count++] = index;
					if(++i >= 2) {
						break out;
					}
				}
			}
		}
        return Arrays.copyOf(answer, count);
    }
	
	public static void main(String[] args) {
    	String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//    	int[] plays = {500, 600, 150, 800, 2500};
    	int[] plays = {500, 600, 500, 500, 2500}; // 겹치는 케이스 
    	int[] result = new Solution().solution(genres, plays);
    	System.out.println(Arrays.toString(result));
    	System.out.println("답 : " + "4, 1, 0, 2");
	}

}
