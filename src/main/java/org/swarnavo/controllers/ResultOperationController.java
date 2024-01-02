package org.swarnavo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.swarnavo.entity.ResultBBA;
import org.swarnavo.entity.ResultBCA;
import org.swarnavo.entity.ResultBHM;
import org.swarnavo.model.BBAModel;
import org.swarnavo.model.BCAModel;
import org.swarnavo.model.BHMModel;

/**
 * Servlet implementation class ResultOperationController
 */
@WebServlet("/operation/adminop/genform")
public class ResultOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
		case "bcaresultform":
			request.getRequestDispatcher("/addResultBCA.jsp").forward(request, response);
			break;
		case "bbaresultform":
			request.getRequestDispatcher("/addResultBBA.jsp").forward(request, response);
			break;
		case "bhmresultform":
			request.getRequestDispatcher("/addResultBHM.jsp").forward(request, response);
			break;
		case "updatebba" :
			request.getRequestDispatcher("/updateResultBBA.jsp").forward(request, response);
			break;
		case "updatebca" :
			request.getRequestDispatcher("/updateResultBCA.jsp").forward(request, response);
			break;
		case "updatebhm":
			request.getRequestDispatcher("/updateResultBHM.jsp").forward(request, response);
			break;
		case "deletebba":
			deleteBBAResultOperation(Integer.parseInt(request.getParameter("result_id")));
		      request.setAttribute("alertType", "fail");
		      request.setAttribute("alertMsg", "Deletion operation successful");
			listResults(request,response);
			break;
		case "deletebca":
			deleteBCAResultOperation(Integer.parseInt(request.getParameter("result_id")));
		      request.setAttribute("alertType", "fail");
		      request.setAttribute("alertMsg", "Deletion operation successful");
			listResults(request,response);
			break;
		case "deletebhm":
			deleteBHMResultOperation(Integer.parseInt(request.getParameter("result_id")));
		      request.setAttribute("alertType", "fail");
		      request.setAttribute("alertMsg", "Deletion operation successful");
			listResults(request,response);
			break;
		default:
			request.getRequestDispatcher("/addResultBCA.jsp").forward(request, response);
			break;
		}
	}


	private void deleteBHMResultOperation(int result_id) {
		new BHMModel().deleteBHMRes(dataSource, result_id);
	}


	private void deleteBCAResultOperation(int result_id) {
		new BCAModel().deleteBCARes(dataSource, result_id);
		
	}


	private void deleteBBAResultOperation(int result_id) {
		new BBAModel().deleteBBARes(dataSource, result_id);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String generateForm = request.getParameter("generateForm");
		generateForm = generateForm.toLowerCase();
		
		switch (generateForm) {

		case "addresultbba":
			ResultBBA newResultBBA = new ResultBBA(Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("management_acc")),
					Integer.parseInt(request.getParameter("ad_sales")),
					Integer.parseInt(request.getParameter("ind_relations")),
					Integer.parseInt(request.getParameter("public_serv")),
					Integer.parseInt(request.getParameter("project")),
					request.getParameter("remark"));
			addBBAResultOperation(newResultBBA);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Add operation successful");
			listResults(request,response);
			break;
		case "addresultbca":
			ResultBCA newResultBCA = new ResultBCA(Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("it")),
					Integer.parseInt(request.getParameter("network")),
					Integer.parseInt(request.getParameter("elective")),
					Integer.parseInt(request.getParameter("it_lab")),
					Integer.parseInt(request.getParameter("network_lab")),
					Integer.parseInt(request.getParameter("minor_project")),
					request.getParameter("remark"));
			addBCAResultOperation(newResultBCA);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Add operation successful");
			listResults(request,response);
			break;
		case "addresultbhm":
			ResultBHM newResultBHM = new ResultBHM(Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("epi_health")),
					Integer.parseInt(request.getParameter("support_ut")),
					Integer.parseInt(request.getParameter("fm_ra")),
					Integer.parseInt(request.getParameter("project")),
					request.getParameter("remark"));
			addBHMResultOperation(newResultBHM);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Add operation successful");
			listResults(request,response);
			break;
			
		case "updateresultbba":
			ResultBBA updatedResultBBA = new ResultBBA(Integer.parseInt(request.getParameter("result_id")),
					Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("management_acc")),
					Integer.parseInt(request.getParameter("ad_sales")),
					Integer.parseInt(request.getParameter("ind_relations")),
					Integer.parseInt(request.getParameter("public_serv")),
					Integer.parseInt(request.getParameter("project")),
					request.getParameter("remark"));
			updateBBAResultOperation(updatedResultBBA);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Updation operation successful");
			listResults(request,response);
			break;
		case "updateresultbca":
			ResultBCA updatedResultBCA = new ResultBCA(Integer.parseInt(request.getParameter("result_id")),
					Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("it")),
					Integer.parseInt(request.getParameter("network")),
					Integer.parseInt(request.getParameter("elective")),
					Integer.parseInt(request.getParameter("it_lab")),
					Integer.parseInt(request.getParameter("network_lab")),
					Integer.parseInt(request.getParameter("minor_project")),
					request.getParameter("remark"));
			updateBCAResultOperation(updatedResultBCA);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Updation operation successful");
			listResults(request,response);			
			break;
		case "updateresultbhm":
			ResultBHM updatedResultBHM = new ResultBHM(Integer.parseInt(request.getParameter("result_id")),
					Integer.parseInt(request.getParameter("roll_no")),
					Integer.parseInt(request.getParameter("epi_health")),
					Integer.parseInt(request.getParameter("support_ut")),
					Integer.parseInt(request.getParameter("fm_ra")),
					Integer.parseInt(request.getParameter("project")),
					request.getParameter("remark"));
			updateBHMResultOperation(updatedResultBHM);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Add operation successful");
			listResults(request,response);
			break;

		default:
			break;
		}

	}
	
	private void updateBHMResultOperation(ResultBHM updatedResultBHM) {
		new BHMModel().updateBHMRes(dataSource, updatedResultBHM);
	}


	private void addBHMResultOperation(ResultBHM newResultBHM) {
		new BHMModel().addBHMRes(dataSource, newResultBHM);
		return;
		
	}


	private void addBCAResultOperation(ResultBCA newResultBCA) {
		new BCAModel().addBCARes(dataSource, newResultBCA);
	}


	private void updateBCAResultOperation(ResultBCA updatedResultBCA) {
		new BCAModel().updateBCARes(dataSource, updatedResultBCA);
	}


	private void updateBBAResultOperation(ResultBBA updatedResult) {
		new BBAModel().updateBBARes(dataSource, updatedResult);
	}


	private void addBBAResultOperation(ResultBBA newResult) {
		new BBAModel().addBBARes(dataSource, newResult);		
	}
	
	protected void listResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "All Student Results");
		List<ResultBBA> listBBA = new ArrayList<ResultBBA>();
		listBBA = new BBAModel().listResults(dataSource);
		request.setAttribute("listBBA", listBBA);
		
		List<ResultBCA> listBCA = new ArrayList<ResultBCA>();
		listBCA = new BCAModel().listResults(dataSource);
		request.setAttribute("listBCA", listBCA);
		
		List<ResultBHM> listBHM = new ArrayList<ResultBHM>();
		listBHM = new BHMModel().listResults(dataSource);
		request.setAttribute("listBHM", listBHM);
		request.getRequestDispatcher("/viewResult.jsp").forward(request, response);

	}

}
