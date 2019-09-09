package steve.http;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;

import javax.servlet.ServletException;

/**
 * @author steve
 */
public class ServerTest2 {
    public static void main(String[] args) throws ServletException {
        ServletInfo servletInfo = Servlets.servlet("userServlet", UserServlet.class);
        servletInfo.addInitParam("name", "steve");
        servletInfo.addMappings("/userServlet");
        DeploymentInfo deployment = Servlets.deployment();
        deployment.setContextPath("/underTow");
        deployment.setClassLoader(ServerTest2.class.getClassLoader());
        deployment.setDeploymentName("undertowTest.war");
        deployment.addServlet(servletInfo);
        ServletContainer servletContainer = Servlets.defaultContainer();
        DeploymentManager deploymentManager = servletContainer.addDeployment(deployment);
        deploymentManager.deploy();
        PathHandler pathHandler = Handlers.path();
        HttpHandler httpHandler = deploymentManager.start();
        pathHandler.addPrefixPath("/underTow", httpHandler);
        Undertow server = Undertow.builder().addHttpListener(9000, "localhost").setHandler(pathHandler).build();
        server.start();
    }
}
