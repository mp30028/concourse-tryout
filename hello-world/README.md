# knapsack-hello-world
Reference repository to build and deploy a simple application using GitHub workflows and actions


### To run on server
1. The workflow on pull-request will test, build and create a package called hello-world-jar.zip

2. It will then SFTP the contents of the zipped package to remote server

3. The location where the contents are saved by SFTP includes shell script called `entrypoint.sh` which can be used to start the app in a docker container

4. The docker container should be started with<br/>
`docker run --rm -it -d --name=jdk-17-hello-world -v /installed-apps/hello-world-jar:/hello-world-app -p 80:80 -p 443:443 --env-file /installed-apps/hello-world-jar/env.list --entrypoint /hello-world-app/entrypoint.sh eclipse-temurin:17`

5. NOTE: The ssl settings in application.properties file needs to be overridden with environment variables in order to use the certificates stored on the server. The environment variables are stored in the `env.list` file that is passed as an argument when the container is started.

-trigger build