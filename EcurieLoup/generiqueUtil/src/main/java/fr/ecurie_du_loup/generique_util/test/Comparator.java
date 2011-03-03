package fr.ecurie_du_loup.generique_util.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Comparator {
	
	public static <T> void compareJUnit(T excepted, T actual){
		Comparator.compareJUnit(excepted, actual, new ArrayList<String>());
	
	}

	public static <T> void compareJUnit(T excepted, T actual, Collection<String> notCheckedMembers){
		/*System.out.println("class excepted "+excepted.getClass());
		System.out.println("class actual "+actual.getClass());*/
		Class c = excepted.getClass();
		for(Method method: c.getMethods()){
			if(method.getName().startsWith("get")){
				if(!notCheckedMembers.contains(method.getName())){
					try{
						Object objExcepted = method.invoke(excepted, new Object[]{});
						Object objActual = method.invoke(actual, new Object[]{});
						
						/*System.out.println(method.getName()+" : ");
						Comparator.print("excepted", objExcepted);
						Comparator.print("actual", objActual);*/
						
						if((objExcepted instanceof Date )&& (objActual instanceof Date)){
							
							Date dateExcepted = (Date)objExcepted;
							Date dateActual = (Date)objActual;
							
							long timeExcepted  =Comparator.getTime(dateExcepted);
							long timeActual = Comparator.getTime(dateActual);
							assertEquals(timeExcepted, timeActual);
						}else if((objExcepted instanceof Collection<?> )&& (objActual instanceof Collection<?>)){
							Collection<Object> colExcepted= new ArrayList<Object>((Collection<Object>)objExcepted);
							Collection<Object> colActual= new ArrayList<Object>((Collection<Object>)objActual);
							assertEquals(colExcepted, colActual);
						}	else{
						
							assertEquals(objExcepted, objActual);
						}
						
					}catch(Exception e){
						e.printStackTrace();
						fail(e.getMessage());
					}
				}
			}


		}
	}
	
	private static long getTime(Date date){
		long time = date.getTime();		
		time = (time /1000)*1000;
		return time;
		
	}
	
	private static void print(String name,Object object){
		if(object != null){
		System.out.println(name+" => "+object+" "+object.getClass());
		}else{
			System.out.println(name+" => "+null);
		}
		
	}
	
}
