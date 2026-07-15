class Solution {
    public int gcdOfOddEvenSums(int n) {
        int so=0;
        int se=0;
        int a=1,b=2;
        for(int i=0;i<n;i++)//n=4,0,1,2,3.
        {
            so=so+(a);//1+3+5+7
            se=se+(b);//se=2+4+6+8.
            a=a+2;//3,5,7
            b=b+2;
        }
        //gcd(so,se)
        while(se!=0)
        {
            int temp=se;
            se=so%se;
            so=temp;
        }
        return so;
        
    }
}
