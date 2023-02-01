./mvnw spring-boot:run

localhost:8080/v1/students/

localhost:8080/v1/students/1

curl -X POST localhost:8080/v1/students \
-H 'Content-Type: application/json' \
-d '{"name":"sue", "email":"sue@email.com"}'

curl -X PUT localhost:8080/v1/students/3 \
-H 'Content-Type: application/json' \
-d '{"name":"darby", "email":"darby@email.com"}'

curl -X DELETE localhost:8080/v1/students/3

./mvnw test

2023-1-20

https://www.youtube.com/watch?v=_thI-4AF7M8&t=7s

https://fullstackdeveloper.guru/2020/05/01/how-to-integrate-sqlite-database-with-spring-boot/

https://sainimanish700.medium.com/mybatis-with-spring-boot-example-d521f393a742

https://start.spring.io/

	Lombok + Spring Web + Mybatis Framework + Apache Freemaker + Flyway Migration + 
	Spring Boot DevTools

https://www.baeldung.com/spring-boot-sqlite

https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

https://spring.io/guides/gs/spring-boot/

2023-1-21

https://mkyong.com/maven/maven-error-invalid-target-release-17/

https://zetcode.com/springboot/freemarker/

https://spring.io/guides/gs/rest-service/

https://medium.com/@nadinCodeHat/rest-api-naming-conventions-and-best-practices-1c4e781eb6a5

https://o7planning.org/11547/spring-boot-and-freemarker  //crud spring boot 2.0

https://www.dariawan.com/tutorials/spring/spring-boot-freemarker-crud-example/

2023-1-22

https://www.baeldung.com/mybatis

https://takeaction.github.io/mybatis-one-to-many/

https://www.sqlitetutorial.net/sqlite-foreign-key/

2023-1-24

https://www.baeldung.com/spring-boot-flyway-repair

https://www.beekeeperstudio.io/blog/guide-to-boolean-columns-in-sqlite

https://stackoverflow.com/questions/20657566/how-to-implement-manytomany-relationship-in-mybatis

https://www.javadevjournal.com/spring/spring-session-with-jdbc/

https://www.techgeeknext.com/spring-boot/spring-boot-session-management

2023-1-25

https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html

https://www.baeldung.com/spring-security-csrf

https://hellokoding.com/spring-boot-hello-world-example-with-freemarker/

https://hellokoding.com/form-data-binding-and-validation-example-with-java-spring-boot-and-freemarker/

2023-1-29

https://howtodoinjava.com/spring5/security/login-form-example/#231-custom-login-page

https://bcrypt-generator.com/

https://www.baeldung.com/spring-security-granted-authority-vs-role

2023-1-30

https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch16s04.html

https://www.marcobehler.com/guides/spring-security

https://polinwei.com/freemarker-spring-boot-security-tag/

https://github.com/spring-projects/spring-security/issues/3275

https://stackoverflow.com/questions/65705637/how-to-get-current-authenticated-user-from-current-session-in-the-freemarker-tem

2023-1-31

https://www.baeldung.com/spring-boot-internationalization

https://www.javachinna.com/sending-email-using-spring-boot-2-internationalization-i18n-and-freemarker-html-email-template-with-inline-image-and-attachment/

https://www.baeldung.com/spring-bean-scopes

https://www.baeldung.com/spring-boot-testing

https://veeevek.medium.com/springboot-separate-unit-integration-test-336abbc38ef4

Auto-wiring is the process of looking for a potential object match requiring dependency and injecting it into the target object. This project is mainly performed by AutowiredAnnotationBeanPostProcessor and Java Reflection API.

@Inject and @Autowired both annotations are used for autowiring in your application. @Inject annotation is part of Java CDI which was introduced in Java 6, whereas @Autowire annotation is part of spring framework. Both annotations fulfill same purpose therefore, anything of these we can use in our application.

@Resource will narrow down the search first by name then by type and finally by Qualifiers (ignored if match is found by name). @Autowired and @Inject will narrow down the search first by type then by qualifier and finally by the name.

https://spring.io/guides/gs/testing-web/

https://www.baeldung.com/introduction-to-assertj
