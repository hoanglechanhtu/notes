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


