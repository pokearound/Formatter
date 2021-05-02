# Formatter in Java

## Prerequisites for setup
- jdk
- maven

## How to generate test coverage report
```sh
mvn clean test jacoco:report 
open ./target/site/jacoco/index.html
```
### Test report

|Element|Missed Instructions|Cov.|Missed Branches|Cov.|Missed|Cxty|Missed|Lines|Missed|Methods|Missed|Classes|
|--- |--- |--- |--- |--- |--- |--- |--- |--- |--- |--- |--- |--- |
|Total|3 of 282|98%|1 of 20|95%|2|31|1|68|1|21|0|6|
|main||96%||100%|1|9|1|23|1|3|0|1|
|formatting||100%||87%|1|10|0|33|0|6|0|2|
|formatting.inst||100%||n/a|0|12|0|12|0|12|0|3|

## How to generate executable jar
```sh
mvn clean package
```
## How to execute

```sh
java -jar target/formatter.jar "This text should be left aligned" 10
java -jar target/formatter.jar "This text should be left aligned" 20 Left
java -jar target/formatter.jar "This text should be right aligned" 10 Right
java -jar target/formatter.jar "This text should be center aligned" 10 Center
```
