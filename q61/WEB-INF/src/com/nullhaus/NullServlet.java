package com.nullhaus;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/foo/*", name="NullServlet", asyncSupported=true)
public class NullServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.getWriter().println("Howdy from NullServlet1!");

		final AsyncContext ac = req.startAsync();

		ac.start(new Runnable() {
			public void run() {
				System.out.println("Async!");
				ac.complete();
			}
		});
	}
}
