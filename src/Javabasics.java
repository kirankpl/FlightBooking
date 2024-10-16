import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Javabasics {
	public static void main(String args[]){
	int[] arr= new int[5];
	arr[1]=5;
	
	System.out.println(arr);
	
	int[] arr1= {1,2,3,4,5,6,7,8,9,10};
	
	System.out.println(arr1[1]);
	
//	for(int i=0;i<=arr1.length;i++)
//	{
//		System.out.println(arr1[i]);
//	}
//	for (int s:arr1)
//	{
//		System.out.println(s);
//	}
	
	
	for(int i=0;i<arr1.length;i++)
	{
		if(arr1[i]%2==0)
		{
		System.out.println(arr1[i]);
		}
	}
	
	ArrayList<String> a=new ArrayList<String>();
	a.add("kiran");
	a.add("rahul");
	a.add("jobin");
	a.add("vishnu");
	System.out.println(a.get(3));
	
	for(int i=0;i<a.size();i++)
	{
		System.out.println(a.get(i));
	}
	String s="kiran";
	String[] str=s.split("ra");
	System.out.println(str[0]);
	
	String[] name={"kiran","absolute","nation"};
	List<String> name1=Arrays.asList(name);
	System.out.println(name1);
}
}
