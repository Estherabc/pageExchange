package njit;

public class randomNumber {
	int[] rand(int n,int length){
		int[] rand=new int[n];
		for(int i=0;i<n;i++){
			rand[i]=(int)(Math.random()*1000%length)+1;  // 产生随机数0～1000
		}
		return rand;
	}

}
