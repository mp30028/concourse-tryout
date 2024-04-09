See documentation at [Concourse Documentation](https://concourse-ci.org/docs.html)

Note the the docker-compose.yml file used in this project was adapted from https://github.com/concourse/concourse/blob/master/docker-compose.yml

Other useful resources
https://github.com/ruanbekker/concourse-swarm-app-demo
https://dev.to/ruanbekker/using-concourse-ci-to-deploy-to-docker-swarm-5g4b
https://www.meshcloud.io/en/blog/deploying-concourse-ci-on-openstack-using-docker/
https://gist.githubusercontent.com/JohannesRudolph/d86ae89b786dc23272172f20ed0a884e/raw/41cc76e0e4d1e2f8a41565fdf824c17a65cfa456/docker-compose.yml
https://docs.concourse.farm/config/web
https://concourse-ci.org/fly.html
https://concourse-ci.org/tutorial-hello-world.html#run-the-pipeline
https://github.com/concourse/concourse/blob/master/docker-compose.yml
https://concourse-ci.org/auth.html


[Local Instance started up with docker compose defaults](https://localhost:9443/)

### Logging in with fly on localhost
fly -t example_01 login -c https://localhost:9943 --ca-cert ..\..\docker\concourse\certs\localhost.crt

### create and run hello world
1. `cd ..\.pipelines\hello-world`

2. Take a look at the prepared hello world pipeline `cat .\hello-world.yml`

3. Build the pipeline
`fly -t example_01 set-pipeline -p hello-world -c .\hello-world.yml`

4. Unpause the pipeline
`fly -t example_01 unpause-pipeline -p hello-world`

5. Run the pipeline
`fly -t example_01 trigger-job --job hello-world/hello-world-job --watch`