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

#Membuat Enkripsi File jdbc.properties
* Enkripsi ini terdapat di dalam project Belajar-Testing-DBUnit
* buka file jdbc.properties yang ada di dalam folder resources
* setiap yang di enkripsi ganti dengan enkripsi yang telah anda buat
* untuk melakukan enkripsi maka jalankan main class yang ada di project Belajar Testing DBUnit
* hasil enkrispi diganti dengan hasil enkripsi yang anda buat
* Jika masih error atau database tidak terkoneksi, periksa kembali connectionnya, url, nama database, 
  username dan password database
* Di dalam Project Belajar Testing Spring Boot Terdapat contoh konfigurasi database dan jangan lupa diganti
  dengan database anda sebelum melakukan testing aplikasi

#Melakukan Testing
untuk melakukan testing jalankan sintak berikut pada root project maven :

    ```sh
    mvn clean package
    ```
Selanjutnya untuk membuat Coverage Testing maka jalankan sintak berikut :

   ```sh
   mvn clean cobertura:cobertura
   ```
lalu buka file index.html yang terdapat di folder target/site/cobertura di masing - masing
folder aplikasi
    
#Mengatasi Error
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