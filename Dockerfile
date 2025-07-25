FROM bellsoft/liberica-openjdk-alpine:23-cds
RUN apk add curl jq
WORKDIR /home/ProjectName
ADD . .
#ADD runner.sh runner.sh
# Fix for windows
RUN dos2unix runner.sh

ENTRYPOINT sh runner.sh