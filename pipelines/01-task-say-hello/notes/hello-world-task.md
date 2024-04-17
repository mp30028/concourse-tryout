## Tasks
Tasks are the central concept in Concourse.
They can be run directly or from within jobs in a pipeline.

## Running a task directly

#### Step-1. Login
`fly -t ci login -c https://mp30028.com:9943`<br/><br/>
![login](./login.png)<br/><br/>
![login-success](./login-success.png)<br/>

#### Step-2. Execute the task
`fly -t ci execute -c hello-world-task.yml`<br/><br/>
![run-task](./run-task.png)


