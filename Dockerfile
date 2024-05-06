# Use a base image with Tomcat pre-installed
FROM tomcat:latest

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy  WAR file into the Tomcat webapps directory
COPY target/app.war /usr/local/tomcat/webapps/ROOT.war
