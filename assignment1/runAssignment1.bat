TITLE Assignment 1 

START "" microservice-eureka-naming-server\startEurekaServices.bat
timeout /t 20
START "" microservice-dataaccess-service\startDataaccessService.bat
timeout /t 20
START "" microservice-sha256-service\startSha256Service.bat