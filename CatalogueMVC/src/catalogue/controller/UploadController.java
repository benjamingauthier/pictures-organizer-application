package catalogue.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.servlet.ModelAndView;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/UploadController")
@MultipartConfig
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public String getPath(HttpServletRequest request, HttpServletResponse arg1) 
			{
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		return sc.getRealPath("/ressources/images");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("titre");
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		String fileName = filePart.getSubmittedFileName();
		try {
			filePart.write(getPath(request, response)+"/"+fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] splitFileName = fileName.split("\\.");
		response.sendRedirect("/CatalogueMVC/catalogue/add/"+request.getParameter("catId")+"/photo/"+splitFileName[0]+"/extention/"+splitFileName[1]);
		doGet(request, response);
	}

}
