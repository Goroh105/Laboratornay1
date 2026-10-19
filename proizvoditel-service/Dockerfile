# ===== Stage 1: Build =====
FROM eclipse-temurin:21-jdk-alpine as build

LABEL maintainer="konoplevade <dasha49422@gmail.com>"

VOLUME /tmp

COPY target/proizvoditel-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Распаковываем jar, чтобы отделить слои приложения от зависимостей
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# ===== Stage 2: Runtime =====
FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp

ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Запуск приложения (укажите ваш главный класс!)
ENTRYPOINT ["java","-cp","app:app/lib/*","com.dolsoft.proizvoditelservice.ProizvoditelServiceApplication"]