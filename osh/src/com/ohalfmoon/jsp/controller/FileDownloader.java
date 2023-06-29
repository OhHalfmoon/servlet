package com.ohalfmoon.jsp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohalfmoon.jsp.domain.Attach;
import com.ohalfmoon.jsp.util.ParamSolver;

@WebServlet("/download")
public class FileDownloader extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Attach attach = ParamSolver.getParams(req, Attach.class);
		System.out.println(attach);
		
		File file = attach.getFile();
		
		System.out.println(file);
		System.out.println(file.exists());
		
		//응답 제작
		resp.addHeader("Content-Disposition", "attachment; filename="+new String(attach.getOrigin().getBytes("utf-8"), "iso-8859-1"));
		
		//input
		//output
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		//byte[] bytes = bis.readAllBytes();
		byte[] bytes = new byte[(int)file.length()];
		bis.read(bytes);
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		bos.write(bytes);
		bis.close();
		bos.close();
	}
}
