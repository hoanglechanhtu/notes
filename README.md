# notes
This is a simple terminal like web application using AWS cloud.
# Deploy to amazon
## Using Elastic Benstalk
Build jar file
```mvn package```
Using created jar file to create Elastic Beanstalk application and enviroment
![image](https://user-images.githubusercontent.com/16283386/129476094-b3db6baa-ddb2-446c-967f-92c51a89bfda.png)
Change SERVER_PORT to 5000, because Elastic Beanstalk assumes that application will listen to port 5000.
Done
![image](https://user-images.githubusercontent.com/16283386/129476715-f055a278-ed31-4d16-92ee-1cf965cc6840.png)
But what's wrong with the health check? There was no health check path configuration when i created and i couldn't find it after created too.
It's in load balancer's configuration.
![image](https://user-images.githubusercontent.com/16283386/129477039-5d6c4d4f-1b13-40df-8bd9-adce4ff2490a.png)
Change the health check path, save and remember to Apply.
## Using CodePipeline
buildspec.yml to build spring boot application
```
version: 0.2

phases:
  install:
    runtime-versions:
      java: corretto8
  pre_build:
    commands:
      - echo "Entered the pre-build phase"
  build:
    commands:
      - echo "Entered build phase"
      - mvn clean install
  post_build:
     commands:
       - echo "Entered the post-build phase"
       - mv target/aws-note.jar app.jar
artifacts:
  files:
    # publish the now top level app.jar as the artifact
    - app.jar
```
After create code pipeline, 
![image](https://user-images.githubusercontent.com/16283386/129524214-68f56e18-ed44-4960-ae44-0ef0a1397748.png)

### CodeBuild will download dependencies everytime, how to cache the dependencies?
![image](https://user-images.githubusercontent.com/16283386/129525567-09809cd9-c1b4-454f-9b16-267491d6220a.png)
Code build detail before cache
![image](https://user-images.githubusercontent.com/16283386/129525895-a5e6d436-ddbd-48e0-8ef1-57d8d1e2125a.png)

To configure dependencies cache, go to Artifacts setting, add cache configuration.
![image](https://user-images.githubusercontent.com/16283386/129526391-d045c785-4d77-4b1c-a02b-98d6ca4258cf.png)

Update build spec to specicfy dependecies folder
buildspec.yml to build spring boot application
```
version: 0.2

phases:
  install:
    runtime-versions:
      java: corretto8
  pre_build:
    commands:
      - echo "Entered the pre-build phase"
  build:
    commands:
      - echo "Entered build phase"
      - mvn clean install
  post_build:
     commands:
       - echo "Entered the post-build phase"
       - mv target/aws-note.jar app.jar
artifacts:
  files:
    # publish the now top level app.jar as the artifact
    - app.jar
cache:
  paths:
    - '/root/.m2/**/*'
```
The dependency files will be save in s3
![image](https://user-images.githubusercontent.com/16283386/129530316-388ce6ab-5eea-4218-9d2a-4e6c02af9359.png)

After set up dependency cache, you will see that the download source increase slightly and the build time decrease greatly from about 5 min to 16s.
![image](https://user-images.githubusercontent.com/16283386/129531001-bbb82174-5626-45b3-83a3-b0be1f03980c.png)

## Logs and events
### Create notifications when an EC2 instance is shutdown
First, create SNS topic and email subscription.
![image](https://user-images.githubusercontent.com/16283386/129592505-e49689ab-292f-46b1-86ba-7c01a5174352.png)
Create a rule which will publish a message to topic whenever a EC2 instance is shutting down.
