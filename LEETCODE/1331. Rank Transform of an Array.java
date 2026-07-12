class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //given -> 1-D ARRAY
        //USE OF HASH MAP
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) { //map.containsKey(num);
                map.put(num, rank);//map.put(num,rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}


        
