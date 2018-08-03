import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static HashMap<Integer,Integer> real = new HashMap<Integer,Integer>();
	public static boolean tracks(int index,HashMap<Integer,Integer> m,int sum,int target) {
		if(sum==target) {
			real.put(index, m.get(index));
			return true;
		}
		if(index==m.size()) return false;
		if(tracks(index+1,m,sum+m.get(index),target)) {
			real.put(index, m.get(index));
			return true;
		}
		
		return tracks(index+1,m,sum,target);
	}
	
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line;
	while((line=br.readLine())!=null&&!line.isEmpty()) {
		Scanner sc = new Scanner(line);
		int target = sc.nextInt();
		int n= sc.nextInt();
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
		m.clear();
		for(int i=0; i<n; i++) m.put(i, sc.nextInt());
		while(tracks(0,m,0,target)!=true) target--;
		tracks(0,m,0,target);
		int sum2 =0;
		for(int i=0; i<n; i++) {
			if(real.get(i)!=null) {
				sum2+= real.get(i);
				if(sum2>target) {
					sum2-=real.get(i);
					break;
				}
				System.out.print(real.get(i)+" ");
			}
			
		}
		System.out.println("sum:"+sum2);
		real.clear();
	}
}
}