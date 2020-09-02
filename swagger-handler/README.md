# swagger-verification
version 1.0.1

swagger-verification - это библиотека для обработки сваггер файлов в формате json и yaml(удаляет deprecated и некорректные endpoints)

Системные требования
--------------------
JDK - 1.8  
Maven - 3.3 и выше    

Как добавить в проект
--------------------
 добавить в проект следующую конфигурацию плагина в POM-файл Maven:
```xml
        <dependency>
            <groupId>ru.lanit</groupId>
            <artifactId>swagger-handler</artifactId>
            <version>1.0.1</version>
        </dependency>
```

