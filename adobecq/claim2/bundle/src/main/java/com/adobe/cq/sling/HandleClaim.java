package com.adobe.cq.sling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.ServerException;
import java.util.Dictionary;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.osgi.OsgiUtil;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.component.ComponentContext;
import javax.jcr.Session;
import javax.jcr.Node;
import org.json.simple.JSONObject;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.PrintWriter;


@SlingServlet(methods = {"GET"},
        metatype = true,
        resourceTypes = {"services/powerproxy"},
        selectors = {"groups"})
public class HandleClaim extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
    private static final long serialVersionUID = 2598426539166789515L;

    private static final Logger log = LoggerFactory.getLogger(HandleClaim.class);



    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

        try
        {
            log.info("---> THIS IS THE GET METHOD OF slingSevletApp/components/page/slingTemplate");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This value was returned by an AEM Sling Servlet bound by using a Sling ResourceTypes property</h1>");
            out.println("</html></body>");

        }
        catch(Exception e)
        {
            log.info(e.getMessage(),e);
        }
    }
}