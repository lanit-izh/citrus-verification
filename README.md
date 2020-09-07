swagger-verification
version 1.1.3 

swagger-verification - это верификатор спецификации Swagger OpenAPI.
Библиотека удаляет deprecated и некорректные эндпоинты.

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
                            <version>1.1.3</version>
                            <configuration>
                                <path>src/main/resources/swagger/swagger-restfull.json</path>
                            </configuration>
                            <executions>
                                <execution>
                                    <id>process</id>
                                    <phase>process-classes</phase>
                                    <goals>
                                        <goal>setPath</goal>
                                    </goals>
                                </execution>
                            </executions>
                        </plugin>
Конфигурация плагина

Основные настройки:

<path> - путь к файлу спецификации Swagger OpenAPI;

Выполняется с помощью команды:

mvn clean install
