FROM therickys93/ubuntu14java
ADD . /ibanandccbot
WORKDIR /ibanandccbot
RUN ./gradlew clean stage
CMD bash run.sh