import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@interface ClassInfo {
	String author();
	int revision() default 1;
	boolean checked() default true;
	Class<?>[] related();
}

@ClassInfo (
	author = "Az",	
	related = {String.class, Integer.class}
)
public class ClassInfoTest {
	public static void main (String[] args) {
		Class aClass = ClassInfoTest.class;
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof ClassInfo){
		        ClassInfo myAnnotation = (ClassInfo) annotation;
		        System.out.println("author: " + ((ClassInfo) myAnnotation).author());
		        System.out.println("revision: " + ((ClassInfo) myAnnotation).revision());
		        System.out.println("checked: " + ((ClassInfo) myAnnotation).checked());
		        System.out.println("related: " + ((ClassInfo) myAnnotation).related());
		    }
		}
		
		annotations.getClass().getAnnotation(ClassInfo.class);
	}
}