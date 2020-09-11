swagger-verification
version 1.1.3 

swagger-verification - это верификатор спецификации Swagger OpenAPI.
Библиотека проверяет Swagger OpenAPI на deprecated и некорректные эндпоинты.

Системные требования

JDK - 1.8
Maven - 3.5 и выше

Как добавить в проект

Предварительно нужно скачать плагин и установить его в локальный репозиторий с помощью команды:

mvn clean install
Далее добавить в проект следующую конфигурацию плагина в POM-файл Maven:

                     <plugin>
                            <groupId>ru.lanit</groupId>
                            <artifactId>swagger-verification</artifactId>
                            <version>1.3.0</version>
                            <configuration>
                                <path>D:\Work\checkSwagger\src\main\resources\api-shop.json</path>
                                <isDelete>false</isDelete>
                            </configuration>
                            <executions>
                                <execution>
                                    <id>process</id>
                                    <phase>process-classes</phase>
                                    <goals>
                                        <goal>properties</goal>
                                    </goals>
                                </execution>
                            </executions>
                       </plugin>
Конфигурация плагина

Основные настройки:
<path> - путь к файлу спецификации Swagger OpenAPI;
<isDelete> - удаление некорректных эндпоинтов;

Выполняется с помощью команды:

mvn clean install