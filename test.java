class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d,p; // 배달할 개수, 수거할 개수
        int rd = 0;
        int rp = 0; // 초과한 개수
        int q; // 왕복 횟수
        int num;
        for (int i = n-1; i>=0; i--){
            d = deliveries[i] - rd;
            p = pickups[i] - rp;
            if (d<=0 && p<=0){
                rd = -d;
                rp = -p;
                continue;
            }
            q = count(d,p,cap);

            answer += q*(i+1)*2;

            num = q*cap;

            rd = num-d;
            rp = num-p;
        }
        return answer;
    }

    public int count(int d, int p, int cap){
        int r;
        int q;
        if (d>=p){
            r = d%cap;
            q = (r==0) ? d/cap : d/cap + 1;
        } else{
            r = p%cap;
            q = (r==0) ? p/cap : p/cap + 1;
        }
        return q;
    }
}