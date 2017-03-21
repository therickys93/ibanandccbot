FROM therickys93/ubuntu14java
ADD . /ibanandccbot
WORKDIR /ibanandccbot
RUN ./gradlew clean check stage
CMD bash run.sh