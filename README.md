# Belajar-Testing-Aplikasi

Aplikasi ini dibuat bertujuan untuk memperdalam testing sebuah aplikasi

Teknologi yang digunakan :
* Spring
* MariaDB (database)
* jasypt (enksripsi file jdbc.properties)
* bonecp (pooling database)
* slf4j (log)
* JUnit (Unit Testing)
* DBUnit (Integration Testing)
* cobertura (Coverage Testing)

jika terjadi error seperti ini :
`org.jasypt.exceptions.EncryptionOperationNotPossibleException:
 Encryption raised an exception. A possible cause is you are using 
 strong encryption algorithms and you have not installed the Java 
 Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy 
 Files in this Java Virtual Machine`

silahkan download JCE (Java Cryptography Extension) di situsnya oracle lalu lakukan step berikut :
* ekstrak file tersebut yang berisi file `local_policy.jar` dan `US_export_policy.jar`
* lalu copy ke folder `JAVA_HOME\jre\lib\security\`