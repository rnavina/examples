## A Simple Restful Resource using Jetty Server and Jersey (rest-server)

### Pre-requisites 

* JDK 8+
* (Optional) IntelliJ

### Steps to Execute

#### Build
```
cd examples/
./gradlew clean :rest-server:buildTar
```

#### Deploy Server
```
cd examples
cd rest-server/build/distributions/
mkdir -p serverDeployDir
tar -xvf rest-server-*.tgz -C serverDeployDir
./serverDeployDir/bin/run-rest-server.sh
```
This brings up a Jetty-based REST Server at port 5555

#### Test
* Open the browser and navigate to localhost:5555/home
* Try localhost:5555/home/hello
* Try localhost:5555/home/param?name="FooBar"
* Try localhost:5555/home/path/FooBar
