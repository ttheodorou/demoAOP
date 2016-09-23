package com.objis.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class MonLogger {	
	/* Cette méthode est appelée à chaque fois (et avant) qu'une méthode du
	 package com.objis.service est interceptée
	 */
	public void logMethodEntry(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		
		// Nom de la méthode interceptée
		String name = joinPoint.getSignature().toLongString();
		StringBuffer sb = new StringBuffer(name + " appellé avec: [");
		
		// Liste des valeurs des arguments reçus par la méthode
		for (int i = 0; i < args.length; i++) {
			Object o = args[i];
			sb.append("'" + o + "'");
			sb.append((i == args.length - 1) ? "" : ", ");
		}
		sb.append("]");
		System.out.println(sb);
	}
	
	/* Cette méthode est appelée à chaque fois (et après) qu'une méthode du
	   package com.objis..service est interceptée. 'result' correspondant au retour de la méthode interceptée
	 */
	public void logMethodExit(StaticPart staticPart, Object result) {
		// Information sur le point de jonction
		String name = staticPart.getSignature().toLongString();

		System.out.println(name + " retourne : [" + result + "]");
	}

	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
	    System.out.println("AVANT");
	    Object retVal = pjp.proceed();
	    System.out.println("APRES");
	    return retVal;
	}
	
}