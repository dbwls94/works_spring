package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import first.common.logger.LoggerInterceptor;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	//여기서는 하나의 요청을 쉽게 볼 수 있도록 경계선 로그 출력
	
	//전처리기 메소드
	//client -> controller로 요청할 때 그 요청을 처리할 메소드
	//컨트롤러가 호출되기 전에 실행됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================          START         ======================================");
			log.debug(" Request URI \t:  " + request.getRequestURI()); //현재 호출된 URI
		}
		return super.preHandle(request, response, handler);
	}
	
	//후처리기 메소드
	//controller -> client로 응답할 때 그 요청을 처리할 메소드
	//컨트롤러가 실행되고 난 후 호출됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================           END          ======================================\n");
		}
	}
}