class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> seq = new ArrayList<>();
        //10-11
        for(int start=1;start<=9;start++)
        {
            int num=start;//1,2,3,4,5,6,7,8,9 end 
            for(int next=start + 1;next<=9;next++)
            {
                num=num*10+next;//for 1:12,123,1234,12345...123456789 end then for 2 .....
                if(num>=low && num<=high)//ex. num=234 so 234>=100 yes and 234<=300 yes so add in list 
                seq.add(num);
            }
        }
        Collections.sort(seq);// like : 123,1234,234,2345->123,234,1234,2345
        return seq;
    }
}
