    import java.util.*;
    import java.lang.*;
     
    public class ds{
    	public static Scanner scanner = new Scanner(System.in);
    	
    	public static void main(String[] args){
    		int n = scanner.nextInt();
    		scanner.nextLine();
    		
    		HashSet<String> myhash = new HashSet<String>();
    		while(n != 0){
    			n--;
    			String name =  scanner.nextLine();
    			if(!myhash.contains(name)){
    				myhash.add(name);
    				System.out.println("OK");
    			}else{
    				function(myhash,name);
    			}
    			      
    		}
    	}
    	
    	public static void function(HashSet<String> myhash,String name){
    		StringBuilder sb = new StringBuilder(name);
    		sb.append(1);
    		for(int i = 2;myhash.contains(sb.toString());i++){
    			sb.deleteCharAt(sb.length()-1);
    			sb.append(i);
    		}
    		System.out.println(sb);
    		myhash.add(sb.toString());
    	}
    }
