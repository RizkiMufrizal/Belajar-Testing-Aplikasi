# Belajar-Testing-Aplikasi

Aplikasi ini dibuat bertujuan untuk memperdalam testing sebuah aplikasi

Teknologi yang digunakan :

Java Testing :
* Spring Boot
* Spring Data JPA
* Spring MVC
* Jackson
* MariaDB
* jasypt (enksripsi file jdbc.properties)
* bonecp (pooling database)
* slf4j (log)
* JUnit (Unit Testing)
* DBUnit (Integration Testing)
* cobertura (Coverage Testing)

Angular Testing :
* Yeoman
* Bower
* NPM
* Angular
* JQuery
* Bootstrap
* Grunt
* Karma
* PhantomJS
* UI Router

Web Server
* Tomcat 8.0.18
* Jetty 9.2.7.v20150116

jika terjadi error seperti ini :
`org.jasypt.exceptions.EncryptionOperationNotPossibleException:
 Encryption raised an exception. A possible cause is you are using 
 strong encryption algorithms and you have not installed the Java 
 Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy 
 Files in this Java Virtual Machine`

silahkan download JCE (Java Cryptography Extension) di situsnya oracle lalu lakukan step berikut :
* ekstrak file yang telah di download berdasarkan versi JDK nya 
* di dalam folder tersebut berisi file `local_policy.jar` dan `US_export_policy.jar`
* lalu copy ke folder `JAVA_HOME\jre\lib\security\`