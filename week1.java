public class week1{
   static int efficientTraveler(int nums[],int initEnergy){
       int ans=0;
       for(int i=0;i<nums.length;i++){
        //Decreasing energy while visiting city
        initEnergy=initEnergy-nums[i];
        if(initEnergy==0||initEnergy<0){
            break;
        }
        ans++;
       }
        return ans;
    }
    static int sumThatStandOuts(int nums[]){
        int total=0;
        //For calculating total
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        //For traversing each element
        for(int i=0;i<nums.length;i++){
            int prefixSum=0;
            int suffixSum=0;
            //Calculating prefix sum
            for(int j=0;j<i;j++){
                prefixSum+=nums[j];
            }
            suffixSum=total-prefixSum-nums[i];
            if(suffixSum==prefixSum){
                return i;
            }
        }
        return -1;
    }
    static int numberOfFlips(int arr[]){
        int zeros=0,ones=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
               zeros++;
            else if(arr[i]==1)
               ones++;
        }
        return Math.min(zeros, ones);
    }
    static int oddOneOut(int arr[]){
        int freq[] = new int[arr.length];
        //Calculating frequency
        for(int i=0;i<arr.length;i++){
            if(freq[arr[i]]==0){
                freq[arr[i]]=1;
            }else{
                freq[arr[i]]++;
            }
        }
        //Finding number with freq = 1 i.e., Non repeated
        for(int i=0;i<freq.length;i++){
            if(freq[i]==1){
                return i;
            }
        }
        return -1;
    }
    static boolean smartPairFinder(int nums[],int k){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                //Checking whether pair(i,j) exist such that i+j=k
                if(nums[i]+nums[j]==k){
                    return true;
                }
            }
        }
        return false;
    }
    static int minimalistPainter(int time[]){
        int totalTime=0;
        int maxTime=0;
        for(int i=0;i<time.length;i++){
            totalTime+=time[i];
            if(time[i]>maxTime){
                maxTime=time[i];
            }
        }
        return totalTime-maxTime;
    }
    
    public static void main(String[] args) {
        //int nums[]={4,2,6,3,5};
        //System.out.println("Farthest city index:"+efficientTraveler(nums,10));
        // int nums[]={2,3,-1,8,4};
        // System.out.println("Prefix sum stands out at index:"+sumThatStandOuts(nums));
        // int arr[]={1,0,0,1,1};
        // System.out.println("Mininum number of flips required:"+numberOfFlips(arr));
        // int nums[]={2,3,5,4,5,3,2};
        // System.out.println("Number with no repetition:"+oddOneOut(nums));
        // int nums[]={3,5,1,7};
        // System.out.println("Smart pair exits?:"+smartPairFinder(nums, 8));
        // int time[]={4,2,3,7};
        // System.out.println("Minimum time after skipping:"+minimalistPainter(time));
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,4);
        double distance = p1.distance(p2);
        System.out.println("Distance between p1 and p2:"+distance);
        System.out.println("Original:"+p1);
        p1.translate(1, 2);
        System.out.println("Translated:"+p1);
        Circle c1 = new Circle(5);
        Square s1 = new Square(2);
        System.out.println("Area of circle:"+c1.getArea());
        System.out.println("Area of square:"+s1.getArea());
    }
}
class Point{
    private float x;
    private float y;
    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public double distance(Point obj){
        double dx = Math.pow(obj.x-this.x,2);
        double dy = Math.pow(obj.y-this.y, 2);
        return Math.sqrt(dx+dy);
    }
    public void translate(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    }
    @Override
    public String toString(){
      return "("+this.x+","+this.y+")";
    }
}
abstract class Shape extends Point{
    public abstract double getArea();
}
class Circle extends Shape{
private int radius;
public Circle(int radius){
    this.radius=radius;
}
@Override
public double getArea() {
    return Math.PI*radius*radius;
}
}
class Square extends Shape{
private int side;
public Square(int side){
    this.side=side;
}
@Override
public double getArea() {
    return side*side;
}
}