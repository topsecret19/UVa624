import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static HashMap<String,Boolean> answers = new HashMap<String,Boolean>();
	static HashMap<Integer,Integer> real = new HashMap<Integer,Integer>();
	static int target;
	static HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	public static boolean tracks(int index,int sum) {
		String answer = index+"-"+sum;
		if(sum==target) {
			real.put(index, m.get(index));
			answers.put(answer, true);
			return true;
		}
		if(answers.get(answer)!=null) return answers.get(answer);
		if(index==m.size()) {
			answers.put(answer, false);
			return false;
		}
		if(tracks(index+1,sum+m.get(index))) {
			real.put(index, m.get(index));
			answers.put(answer, true);
			return true;
		}
		return tracks(index+1,sum);
	}
	
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line;
	while((line=br.readLine())!=null&&!line.isEmpty()) {
		Scanner sc = new Scanner(line);
		target = sc.nextInt();
		int n= sc.nextInt();
		m.clear();
		for(int i=0; i<n; i++) m.put(i, sc.nextInt());
		while(tracks(0,0)!=true) target--;
		tracks(0,0);
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
		answers.clear();
	}
}
}
