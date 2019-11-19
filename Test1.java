class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(r+l)>>>1;
             if(target==nums[mid]){
                    return mid;
             }else if(nums[mid]>=nums[l]){
                 if(target<nums[mid]&&target>=nums[l]){
                    r=mid-1;
                }else{
                     l=mid+1;
                 }
            }else{
                 if(target>nums[mid]&&target<=nums[r]){
                     l=mid+1;
                 }else{
                     r=mid-1;
                 }
             }
        }
        return -1;
    }
}

人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。

当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
否则，A 可以给 B 发送好友请求。

注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好
友请求。 

求总共会发出多少份好友请求?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int numFriendRequests(int[] ages) {
        int num=0;
        int[] res=new int[121];
        for(int age:ages){
            res[age]++;
        }
        for(int i=1;i<121;i++){
           for(int j=(int)(0.5*i+8);j<=i;j++){
               if(i!=j){
                   num+=res[i]*res[j];
               }if(i==j){
                   num+=(res[i]-1)*res[i];
               }
           }
        }
       
        return num;
    }
}

给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

 class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int num=0;
       int[] res=new int[A.length+1];
       for(int i=0;i<A.length;i++){
           res[i+1]=res[i]+A[i];
       }
       int[] count=new int[K];
       for(int i:res){
           count[(i%K+K)%K]++;
       }
       for(int x:count){
           num+=x*(x-1)>>>1;
       }
       return num;
    }
}

给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-sightseeing-pair
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int left=A[0];
        int res=Integer.MIN_VALUE;
        for(int r=1;r<A.length;r++){
            res=Math.max(res,left+A[r]-r);
            left=Math.max(left,A[r]+r);
        }
        return res;
    }
}