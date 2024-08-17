Tech stack-> spring boot, starter mongodb, mongodb atlas(web,aws), mongodb atlas search(indexing), swagger ui
some imp. points:- 
1) mongodb atlas works fine with java 11 or greater(here wrapper java 11, in backend jdk 17)
2) swagger ui workes fine with spring boot 2.5.7
3) for mongodb atlas---> inside network access always add current public ip of your pc or add 0.0.0.0/0 for all ip access(keep in mind security issue)
4) for jdk 8 there is some compatibility issue with mongodb atlas. It is also posted inside mongodb atlas website below
   https://www.mongodb.com/docs/drivers/java/sync/current/connection-troubleshooting/#std-label-java-connection-troubleshooting
