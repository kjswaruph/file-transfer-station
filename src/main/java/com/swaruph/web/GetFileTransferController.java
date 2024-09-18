package com.swaruph.web;
import com.swaruph.web.dao.FileTransferDao;
import com.swaruph.web.model.FileTransfer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "GetFileTransferController", value = "/GetFileTransferController")
public class GetFileTransferController extends HttpServlet {
//    @Override
////    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        int fid = Integer.parseInt(request.getParameter("fid"));
////        FileTransferDao fileTransferDao = new FileTransferDao();
////        FileTransfer fileTransfer = fileTransferDao.getFile(fid);
////
////        HttpSession session = request.getSession();
////        session.setAttribute("fileTransfer", fileTransfer);
////        response.sendRedirect("showFile.jsp");
////
////    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JakartaServletFileUpload upload = new JakartaServletFileUpload(new DiskFileItemFactory());
        List<FileItem> multifiles = upload.parseRequest(request);
        for (FileItem item : multifiles) {
            try {
                item.write(new File("/home/zappp/Linsynx/" + item.getName()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("file uploaded");

    }
}