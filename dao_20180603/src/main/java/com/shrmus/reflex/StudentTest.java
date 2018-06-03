package com.shrmus.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.junit.Test;

public class StudentTest {
	
	/**
	 * 反射实例化新对象
	 */
	@Test
	public void newInstance() throws Exception{
		// 原对象
		Student student = new Student();
		System.out.println(student);
		
		// 原对象的Class对象
		Class<? extends Student> clazz = student.getClass();
		
		// 实例化一个新对象
		Student newInstance = clazz.newInstance();
		System.out.println(newInstance);
		
		// 获取类的全路径
		String name = clazz.getName();
		System.out.println(name);
	}
	
	/**
	 * 反射获取字段
	 */
	@Test
	public void getDeclaredFields() throws Exception {
		Class clazz = Student.class;
		
		// 根据字段名获取字段的信息
		Field field1 = clazz.getDeclaredField("name");
		System.out.println(field1.toGenericString());
		
		// 获取类中的所有字段
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType().getTypeName() + " " + clazz.getName() + "." + field.getName());
		}
	}
	
	/**
	 * 反射获取构造方法
	 */
	@Test
	public void getDeclaredConstructors() throws Exception {
		Class clazz = Student.class;
		
		// 根据构造方法的参数个数获取构造方法
		Constructor constructor1 = clazz.getDeclaredConstructor(Integer.TYPE,String.class,Integer.TYPE);
		System.out.println(constructor1.toGenericString());
		
		// 获取所有构造方法
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName());
			
			// 获取参数类型
			Type[] genericParameterTypes = constructor.getGenericParameterTypes();
			System.out.print("(");
			if(genericParameterTypes.length > 0) {
				int length = genericParameterTypes.length;
				for(int i = 0; i < length - 1; i++) {
					String typeName = genericParameterTypes[i].getTypeName();
					System.out.print(typeName + ", ");
				}
				System.out.print(genericParameterTypes[length - 1].getTypeName());
			}
			System.out.print(")");
			System.out.println();
		}
	}
	
	/**
	 * 反射获取类的所有方法
	 */
	@Test
	public void getDeclaredMethods() throws Exception {
		Class<? extends Student> clazz = Student.class;
		
		// 根据方法名获取方法对象
		Method declaredMethod = clazz.getDeclaredMethod("test04",String.class,Student.class);
		Student student = clazz.newInstance();
		// 执行方法
		String string = "haha";
		student.setName("张三");
		Object invoke = declaredMethod.invoke(student,string,student);
		System.out.println(invoke);
		
		// 获取所有方法，不包括构造方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method method : declaredMethods) {
			System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getGenericReturnType().getTypeName() + " " + clazz.getName() + "." + method.getName());
			// 获取参数类型
			Type[] genericParameterTypes = method.getGenericParameterTypes();
			System.out.print("(");
			if(genericParameterTypes.length > 0) {
				int length = genericParameterTypes.length;
				for(int i = 0; i < length - 1; i++) {
					String typeName = genericParameterTypes[i].getTypeName();
					System.out.print(typeName + ", ");
				}
				System.out.print(genericParameterTypes[length - 1].getTypeName());
			}
			System.out.print(")");
			System.out.println();
		}
	}
	
}
