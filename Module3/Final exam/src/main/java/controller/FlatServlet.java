package controller;

import common.InputChecker;
import model.Flat;
import service.FlatService;
import service.FlatServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "FlatServlet", urlPatterns = {"/flats", "/"})
public class FlatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FlatService flatService;
    private InputChecker inputChecker = new InputChecker();

    public void init() {
        flatService = new FlatServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertFlat(request, response);
                    break;
                case "edit":
                    updateFlat(request, response);
                    break;
//                case "sort":
//                    sortUsers(request, response);
//                    break;
                default:
                    listFlat(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String searchType = request.getParameter("searchType");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteFlat(request, response);
                    break;
                case "search":
                    switch (searchType){
                        case "Type":
                            searchByType(request, response);
                            break;
                        case "Floors":
                            searchByFloors(request, response);
                            break;
                        case "Price":
                            searchByPrice(request, response);
                            break;
                    }
                    break;
//                case "sort":
//                    sortUsers(request, response);
//                    break;
                default:
                    listFlat(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFlat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ArrayList<Flat> listFlat = flatService.selectAll();
        request.setAttribute("listFlat", listFlat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flat flat = flatService.selectFlat(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("flat", flat);
        dispatcher.forward(request, response);
    }

    private void insertFlat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        String code = request.getParameter("code");
        String area = request.getParameter("area");
        String floors = request.getParameter("floors");
        String description = request.getParameter("description");
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String price = request.getParameter("price");

        Flat flat = new Flat();
        flat.setCode(code);
        flat.setArea(Double.parseDouble(area));
        flat.setFloors(Integer.parseInt(floors));
        flat.setDescription(description);
        flat.setStart(start);
        flat.setEnd(end);
        flat.setType(type);
        flat.setStatus(status);
        flat.setPrice(Double.parseDouble(price));
        request.setAttribute("flat", flat);
        int checkColumn = 0;

        int duplicate = 0;
        ArrayList<Flat> listFlat = flatService.selectAll();
        for (Flat f : listFlat){
            if (f.getCode().equals(code)){
                duplicate++;
            }
        }
        if(!inputChecker.areaCheck(area)){
            request.setAttribute("areaMessage", "Area must be a number bigger than 20");
        }
        else {
            checkColumn++;
        }
        if (!inputChecker.codeCheck(code)){
            request.setAttribute("codeMessage", "Wrong code format");
        }
        else if (duplicate > 0){
            request.setAttribute("codeMessage", "Code duplicate");
        }
        else {
            checkColumn++;
        }
        if (!inputChecker.floorCheck(floors)){
            request.setAttribute("floorsMessage", "Floors must be a number > 0 and <= 15");
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.priceCheck(price)){
            request.setAttribute("priceMessage", "Price must be a number > 1.000.000");
        }
        else {
            checkColumn++;
        }
        if(checkColumn == 4){
            flatService.insertFlat(flat);
            request.getRequestDispatcher("create.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateFlat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        String code = request.getParameter("code");
        String area = request.getParameter("area");
        String floors = request.getParameter("floors");
        String description = request.getParameter("description");
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String price = request.getParameter("price");

        Flat flat = new Flat();
        flat.setCode(code);
        flat.setArea(Double.parseDouble(area));
        flat.setFloors(Integer.parseInt(floors));
        flat.setDescription(description);
        flat.setStart(start);
        flat.setEnd(end);
        flat.setType(type);
        flat.setStatus(status);
        flat.setPrice(Double.parseDouble(price));
        request.setAttribute("flat", flat);
        int checkColumn = 0;

        int duplicate = 0;
        ArrayList<Flat> listFlat = flatService.selectAll();
        for (Flat f : listFlat){
            if (f.getCode().equals(code)){
                duplicate++;
            }
        }
        if(!inputChecker.areaCheck(area)){
            request.setAttribute("areaMessage", "Area must be a number bigger than 20");
        }
        else {
            checkColumn++;
        }
        if (!inputChecker.codeCheck(code)){
            request.setAttribute("codeMessage", "Wrong code format");
        }
        else if (duplicate > 1){
            request.setAttribute("codeMessage", "Code duplicate");
        }
        else {
            checkColumn++;
        }
        if (!inputChecker.floorCheck(floors)){
            request.setAttribute("floorsMessage", "Floors must be a number > 0 and <= 15");
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.priceCheck(price)){
            request.setAttribute("priceMessage", "Price must be a number > 1.000.000");
        }
        else {
            checkColumn++;
        }
        if(checkColumn == 4){
            flatService.updateFlat(flat);
            request.getRequestDispatcher("edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteFlat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        flatService.deleteFlat(id);
        ArrayList<Flat> listFlat = flatService.selectAll();
        request.setAttribute("listFlat", listFlat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByType(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchName = request.getParameter("search");
        ArrayList<Flat> searchResult = flatService.searchFlatByType(searchName);
        request.setAttribute("listFlat", searchResult);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void searchByFloors(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchName = request.getParameter("search");
        ArrayList<Flat> searchResult = flatService.searchFlatByFloor(Integer.parseInt(searchName));
        request.setAttribute("listFlat", searchResult);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void searchByPrice(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchName = request.getParameter("search");
        ArrayList<Flat> searchResult = flatService.searchFlatByPrice(Double.parseDouble(searchName));
        request.setAttribute("listFlat", searchResult);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
