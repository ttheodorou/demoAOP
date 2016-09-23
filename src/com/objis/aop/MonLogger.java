package com.objis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class MonLogger {

	/*
	 * Cette m�thode est appel�e � chaque fois (et avant) qu'une m�thode du
	 * package com.objis.service est intercept�e
	 */
	public void logMethodEntry(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();

		// Nom de la m�thode intercept�e
		String name = joinPoint.getSignature().toLongString();
		StringBuffer sb = new StringBuffer(name + " appel� avec: [");

		// Liste des valeurs des arguments re�us par la m�thode
		for (int i = 0; i < args.length; i++) {
			Object o = args[i];
			sb.append("'" + o + "'");
			sb.append((i == args.length - 1) ? "" : ", ");
		}
		sb.append("]");
		System.out.println(sb);
	}

	/*
	 * Cette m�thode est appel�e � chaque fois (et apr�s) qu'une m�thode du
	 * package com.objis..service est intercept�e. 'result' correspondant au
	 * retour de la m�thode intercept�e
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

	public void logMethodAfter(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().toLongString();
		String retour = "La m�thode : " + name
				+ " a �t� lanc�e avec succ�s. Le d�tail de son execution est d�taill� plus loin !";
		System.out.println(retour);

	}

	//PAS AU POINT
//	public Object doBasicProfiling2(ProceedingJoinPoint pjp)
//			throws Throwable {
//		
//		logMethodEntry(joinPoint);
//		Object retVal = pjp.proceed();
//		StaticPart staticPart = null; Object result = null;
//		logMethodExit(staticPart, result);
//		return retVal;
//	}

}