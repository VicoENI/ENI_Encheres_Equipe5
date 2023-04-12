package fr.eni.encheres.filters;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CsrfFilter
 */
@WebFilter("/inscription")
public class CsrfFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CsrfFilter() 
    {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() 
	{
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{		
		if (request instanceof HttpServletRequest) 
		{
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession(false);
            if (session != null)
            {
            	String method = httpRequest.getMethod();
            	
            	if(method.equalsIgnoreCase("POST"))
            	{
            		String csrfToken = (String) session.getAttribute("csrfToken");
                    if (csrfToken == null) 
                    {
                        csrfToken = UUID.randomUUID().toString();
                        session.setAttribute("csrfToken", csrfToken);
                    }
                    String requestCsrfToken = httpRequest.getParameter("csrf_token");
                    if (requestCsrfToken == null || !requestCsrfToken.equals(csrfToken))
                    {
                        HttpServletResponse httpResponse = (HttpServletResponse) response;
                        httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Jeton CSRF invalide");
                        return;
                    }
            	}                
            }            
            else
            {
            	session = httpRequest.getSession();
            	String csrfToken = (String) session.getAttribute("csrfToken");
    	        if (csrfToken == null) 
    	        {
    	            csrfToken = UUID.randomUUID().toString();
    	            session.setAttribute("csrfToken", csrfToken);
    	        }
    	        request.setAttribute("csrfToken", csrfToken);
            }
        }
        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
