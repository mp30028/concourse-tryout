## Milestone-01
The branch **milestone_01** is a snapshot of a simple hello world application with 
1. TLS enabled
2. Auto redirect of http requests to https
3. Default certificate file which is used if the real certificates are not setup and configured
4. application.properties file configured to use default settings if environment variables are not setup
5. GitHub workflow to test, build and package on merge, 
6. GitHub actions used by the workflow to deploy, i.e. copy using SFTP to a remote server
7. GitHub action to start a docker container to run the application on the remote server

### Next
1. Integrate with KeyCloak for authentication and authorisation